package com.test.callback;

public interface ICallBack<T> {
     Object callback(T t, boolean needNew);
}
