package cn.qian.chain.s2;

import java.net.URL;

/**
 * Created by 千里明月 on 2019/1/8.
 */
public class QueryFilter implements Filter {

    @Override
    public void doFilter(URLEntity urlEntity, String url, FilterChain chain) throws Exception {
        URL urlInstance = new URL(url);
        String query = urlInstance.getQuery();
        urlEntity.setQuery(query);
        chain.doFilter(urlEntity,url,chain);
    }
}
