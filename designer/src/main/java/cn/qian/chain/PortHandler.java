package cn.qian.chain;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 千里明月 on 2019/1/8.
 */
//负责处理端口
public class PortHandler extends Handler {

    @Override
    public void handleRequest(URLEntity urlEntity, String url) throws MalformedURLException {
        URL urlInstance = new URL(url);
        int port = urlInstance.getPort();
        urlEntity.setPort(port);
        if (getHandler() != null) {
            getHandler().handleRequest(urlEntity, url);
        }
    }
}
