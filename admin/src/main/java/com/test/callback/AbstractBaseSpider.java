package com.test.callback;

import com.test.vo.IPMessage;

/**
 * @Description: TODO
 * @Author: spark
 * @Date: 2020/4/24 16:43
 **/
public abstract class AbstractBaseSpider {

    /**
     * 抓取出错时的回调对象
     *
     * @return
     */
    public ICallBack getICallBack() {
        return (ICallBack<IPMessage>) (ipMessage,needNew) -> deleteIPProxy(ipMessage,needNew);
    }

    /**
     * 删除IP代理
     *
     * @param ipMessage
     * @return
     */
    public IPMessage deleteIPProxy(IPMessage ipMessage, boolean needNew) {
        System.out.println(ipMessage.toString());
        if(!needNew)   return ipMessage;
        return ipMessage;
    }
}
