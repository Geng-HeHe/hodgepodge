package com.hehe.base.http.retrofit.common;

public class Resource<T> {
    private Status status;
    private T data;

    public Resource(Status status, T data) {
        this.status = status;
        this.data = data;
    }

    public static <T> Resource<T> success(T data){
        return new Resource<>(Status.SUCCESS,data);
    }


    /**
     * 请求失败，数据处理异常等
     */
    public static <T> Resource<T> errorFailed(){
        return new Resource<>(Status.FAILED,null);
    }

    public T getData(){
        if (status != Status.SUCCESS){
            throw new RuntimeException("");
        }
        return data;
    }

    public boolean isSuccess(){return status.equals(Status.SUCCESS);}
    public boolean isFailed(){return status.equals(Status.FAILED);}
    public void setData(T data){this.data = data;}
    public enum Status{
        /**
         * 成功
         */
        SUCCESS,
        /**
         * 请求失败，超时，数据异常等问题
         */
        FAILED,
    }
}
