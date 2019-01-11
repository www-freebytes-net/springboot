package cn.qian.chain;

/**
 * Created by 千里明月 on 2019/1/8.
 */

import java.net.MalformedURLException;

/**
 * 责任处理者
 * 负责处理url
 */
public abstract class Handler {

    public Handler handler;
    //处理url
    public abstract void handleRequest(URLEntity urlEntity,String url) throws MalformedURLException;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
