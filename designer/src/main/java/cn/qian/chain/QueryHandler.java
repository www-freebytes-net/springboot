package cn.qian.chain;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 千里明月 on 2019/1/8.
 */
//负责处理参数
public class QueryHandler extends Handler{

    @Override
    public void handleRequest(URLEntity urlEntity, String url) throws MalformedURLException {
        URL urlInstance = new URL(url);
        String query = urlInstance.getQuery();
        urlEntity.setQuery(query);
        if (getHandler() != null) {
            getHandler().handleRequest(urlEntity, url);
        }
    }
}
