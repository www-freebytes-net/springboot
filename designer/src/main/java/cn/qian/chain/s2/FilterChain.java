package cn.qian.chain.s2;


import java.util.ArrayList;
import java.util.List;

/**
 * 责任链对象
 */
public class FilterChain  implements Filter{
    List<Filter> filters = new ArrayList<Filter>();
    int index=0;
    public FilterChain addFilter(Filter f) {
        filters.add(f);
        return this;
    }
    @Override
    public void doFilter(URLEntity urlEntity, String url,FilterChain chain) throws Exception {
        //index初始化为0,filters.size()为3，不会执行return操作
        if(chain.index==chain.filters.size()){
            return;
        }
        //每执行一个过滤规则，index自增1
        Filter f=chain.filters.get(index);
        chain.index++;
        f.doFilter(urlEntity,url,chain);
    }
}
