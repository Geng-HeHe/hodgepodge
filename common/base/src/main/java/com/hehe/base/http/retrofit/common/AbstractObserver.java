package com.hehe.base.http.retrofit.common;

import androidx.lifecycle.Observer;


public class AbstractObserver<T> implements Observer<Resource<T>>,ResponseCallBack<T>{
    @Override
    public void onChanged(Resource<T> resource) {
        try {
            if (resource == null){
                return;
            }
            if (resource.isSuccess()){
                Success(resource.getData());
            }else if (resource.isFailed()){
                Failed();
            }
        }catch(Exception e){

        }
    }
    @Override
    public void Success(T data) {

    }
    @Override
    public boolean Failed() {
        return false;
    }


}
