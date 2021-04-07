package com.hehe.base.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hehe.base.R;
import com.hehe.base.utils.Cons;


/**
 * 项目父Activity
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Utility.resetActivityTitle(this);
        setContentView(getLayoutId());

        initView();
        initData();
        initListener();

        initActionBar();
        regCommonBtn();
        // EventBus.getDefault().register(this);

    }


    /**
     * 设置 app 不随着系统字体的调整而变化
     */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config=new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config,res.getDisplayMetrics() );
        return res;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // EventBus.getDefault().unregister(this);
    }
    /**
     * actionbar
     */

    public abstract void initActionBar() ;
    /**
     * 获取布局的ID
     * @return
     */

    protected abstract int getLayoutId();

    /**
     * 初始化view
     *
     */

    public  abstract void initView() ;

    /**
     * 初始化adapter listenter
     */
    public abstract void initListener() ;

    /**
     * 初始化view的数据
     */

    public abstract  void initData();

    /**
     * 处理返回按键
     */

    public   void regCommonBtn(){

      /*  View back = findViewById(R.id.back);

        if (back != null){

            back.setOnClickListener(this);
        }*/
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.home){

            finish();
        }else{

            //处理返回的事件

            processClick(v);
        }

    }

    /**
     * 处理除了点击返回的事件
     * @param v
     */

    protected abstract void processClick(View v);


    /**
     * 创建对话框
     */

    protected ProgressDialog makeDialog(String msg){

        ProgressDialog dialog = new ProgressDialog(this);

        dialog.setMessage(msg);

        return  dialog;
    }



    /**
     *   页面的跳转
     * @param clazz
     * @param finish
     */
    protected void startNewActivity(Class clazz,boolean finish){
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
        if(finish) {
            finish();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // 希望就是打开或者关闭drawlayout


                finish();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();

    }


}