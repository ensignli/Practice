package com.test.callback;

import com.test.vo.IPMessage;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description: TODO
 * @Author: spark
 * @Date: 2020/4/24 16:46
 **/
public class HttpClientSSLSpider extends  AbstractBaseSpider{

    @Getter
    @Setter
    private IPMessage ipMessage;

    public HttpClientSSLSpider() {
        IPMessage ipMessage=new IPMessage();
        ipMessage.setIpAddress("127.0.0.1");
        ipMessage.setIpPort(8080);
        this.ipMessage = ipMessage;
    }
    /**
     * 出问题时需要重做的内容
     * @param callBack
     * @param isBy
     * @return
     */
    public Object  doAfter(ICallBack callBack,boolean isBy)
    {
        IPMessage ipMessage=new IPMessage();
        ipMessage.setIpAddress("127.0.0.1");
        ipMessage.setIpPort(8089);
        //是否要清掉代理IP,如若不要清理，则清空代理，重新赋值
        if(!isBy) this.setIpMessage(ipMessage);
        //是否要重试
        if(true)
        {
            return tryDone(callBack);
        }
        else //如若不要重试，则不要再获取新的IP代理
        {
            callBack.callback(ipMessage,false);
        }
        return null;
    }

    /**
     * 尝试3次
     *
     * @param callBack
     * @return
     */
    private Object tryDone(ICallBack callBack) {
        //是否重试
        Integer isRetry = 1;
        if(isRetry==null) return null;
        if (isRetry==1) {
            Object ob = callBack.callback(ipMessage,true);
            return 1;
        } else if (isRetry==0) {
          return 0;
        }
        return null;
    }

    private void getICallBack(final long synId) {
        doAfter(super.getICallBack(),false);
    }

    public static void main(String... args) {
        HttpClientSSLSpider httpClientSSLSpider=new HttpClientSSLSpider();
        httpClientSSLSpider.getICallBack(0l);
    }

}
