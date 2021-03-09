package com.hehe.hrouter.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.LruCache;

import androidx.annotation.NonNull;

import com.hehe.hrouter.annotation.model.RouterBean;
import com.hehe.hrouter.api.core.Call;
import com.hehe.hrouter.api.core.HRouterLoadGroup;
import com.hehe.hrouter.api.core.HRouterLoadPath;

/**
 * 路由加载管理器
 */
public final class RouterManager {

    //路由祖名
    private String group;
    //路由详细路径
    private String path;
    private static RouterManager instance;
    //Lru缓存，key：类名，value：路由组Group加载接口
    private LruCache<String, HRouterLoadGroup> groupCache;
    //Lru缓存，key：类名，value：路由组Group对应的详细Path加载接口
    private LruCache<String, HRouterLoadPath> pathCache;
    // APT生成的路由组Group源文件前缀名
    private static final String GROUP_FILE_PREFIX_NAME = ".HRouter$$Group$$";

    //单例方式，全局唯一
    public static RouterManager getInstance() {
        if (instance == null) {
            synchronized (RouterManager.class) {
                if (instance == null) {
                    instance = new RouterManager();
                }
            }
        }
        return instance;
    }

    private RouterManager() {
        // 初始化，并赋值缓存中条目的最大值（最多163组）
        groupCache = new LruCache<>(100);
        // 每组最多163条路径值
        pathCache = new LruCache<>(100);
    }

    public BundleManager build(String path) {
        //@HRouter注解中的path值，必须 / 开头
        if (TextUtils.isEmpty(path) || !path.startsWith("/")) {
            throw new IllegalArgumentException("未按规范配置，如：/app/MainActivity");
        }

        //获取组名
        group = subFromPath2Group(path);

        this.path = path;

        return new BundleManager();
    }

    private String subFromPath2Group(String path) {
        // 比如开发者代码为：path = "/MainActivity"，最后一个 / 符号必然在字符串第1位
        if (path.lastIndexOf("/") == 0) {
            // 架构师定义规范，让开发者遵循
            throw new IllegalArgumentException("@ARouter注解未按规范配置，如：/app/MainActivity");
        }

        // 从第一个 / 到第二个 / 中间截取，如：/app/MainActivity 截取出 app 作为group
        String finalGroup = path.substring(1, path.indexOf("/", 1));

        if (TextUtils.isEmpty(finalGroup)) {
            // 架构师定义规范，让开发者遵循
            throw new IllegalArgumentException("@ARouter注解未按规范配置，如：/app/MainActivity");
        }

        // 最终组名：app
        return finalGroup;
    }

    /**
     * 跳转
     *
     * @param context
     * @param bundleManager Bundle拼接参数管理类
     * @param code          这里的code，可能是requesCode，也可能是resultCode,取决于isResult
     * @return 普通调账可以忽略，用于跨模块CALL接口
     */
    Object navigation(@NonNull Context context, BundleManager bundleManager, int code) {
        String groupClassName = context.getPackageName() + ".apt" + GROUP_FILE_PREFIX_NAME + group;
        try {
            //HRouter$$Group$$app
            HRouterLoadGroup hRouterLoadGroup = groupCache.get(group);
            if (hRouterLoadGroup == null) {
                Class<?> aClass = Class.forName(groupClassName);
                hRouterLoadGroup = (HRouterLoadGroup) aClass.newInstance();
                groupCache.put(group, hRouterLoadGroup);
            }

            //HRouter$$Path$$app
            if (hRouterLoadGroup.loadGroup().isEmpty()) {
                throw new RuntimeException("路由加载失败");
            }
            HRouterLoadPath hRouterLoadPath = pathCache.get(path);
            if (hRouterLoadPath == null) {
                Class<? extends HRouterLoadPath> aClass1 = hRouterLoadGroup.loadGroup().get(group);
                if (aClass1 != null) hRouterLoadPath = aClass1.newInstance();
                if (hRouterLoadPath != null) pathCache.put(path, hRouterLoadPath);
            }

            if (hRouterLoadPath != null) {
                hRouterLoadPath.loadPath();
                if (hRouterLoadPath.loadPath().isEmpty()) {
                    throw new RuntimeException("路由路径加载失败");
                }

                RouterBean routerBean = hRouterLoadPath.loadPath().get(path);
                if (routerBean != null) {
                    switch (routerBean.getType()) {
                        case ACTIVITY:
                            Intent intent = new Intent(context, routerBean.getClazz());
                            intent.putExtras(bundleManager.getBundle());
                            // startActivityForResult -> setResult
                            if (bundleManager.isResult()) {
                                ((Activity) context).setResult(code, intent);
                                ((Activity) context).finish();
                            }

                            if (code > 0) {
                                ((Activity) context).startActivityForResult(intent, code, bundleManager.getBundle());
                            } else {
                                context.startActivity(intent, bundleManager.getBundle());
                            }
                            break;
                        case CALL:
                            Class<?> clazz = routerBean.getClazz();
                            Call call = (Call) clazz.newInstance();
                            bundleManager.setCall(call);
                            return bundleManager.getCall();
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
