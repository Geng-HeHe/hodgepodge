package com.hehe.base.http.retrofit.calladapter;

import androidx.lifecycle.LiveData;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * Retrofit支持返回的数据类型适配器
 */
public class LiveDataWithResourceCallAdapterFactory extends CallAdapter.Factory {
    @Override
    public CallAdapter<?, ?> get( Type returnType,  Annotation[] annotations, Retrofit retrofit) {
        if (!(returnType instanceof ParameterizedType)){
            throw new IllegalArgumentException("接口方法返回值类型必须是一个确定的类型");
        }

        Type liveDataType = getParameterUpperBound(0, (ParameterizedType) returnType);
        return new LiveDataWithResourceCallAdapter(liveDataType,true);
    }


}
