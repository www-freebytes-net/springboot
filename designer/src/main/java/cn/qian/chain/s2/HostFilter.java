package cn.qian.chain.s2;

import java.net.URL;

/**
 * Created by 千里明月 on 2019/1/8.
 */
//负责处理域名
public class HostFilter implements Filter {

    @Override
    public void doFilter(URLEntity urlEntity, String url, FilterChain chain) throws Exception {
        URL urlInstance = new URL(url);
        String host = urlInstance.getHost();
        urlEntity.setHost(host);
        chain.doFilter(urlEntity, url, chain);
    }
}
