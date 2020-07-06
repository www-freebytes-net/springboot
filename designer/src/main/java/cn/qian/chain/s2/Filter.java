package cn.qian.chain.s2;

/**
 * Created by 千里明月 on 2019/1/8.
 */

/**
 * 责任处理者
 * 负责处理url
 */
public interface Filter {
     void doFilter(URLEntity urlEntity, String url, FilterChain chain) throws Exception;
}
