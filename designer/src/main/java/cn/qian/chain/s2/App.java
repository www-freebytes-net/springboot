package cn.qian.chain.s2;

/**
 * Created by 千里明月 on 2019/1/8.
 */

/**
 * 什么是链
 * 1、链是一系列节点的集合。
 * 2.、链的各节点可灵活拆分再重组。
 * <p>
 * 职责链模式
 * 使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系，
 * 将这个对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理他为止。
 * <p>
 * 角色
 * 抽象处理者角色(Handler)：定义出一个处理请求的接口。如果需要，接口可以定义 出一个方法以设定和返回对下家的引用。这个角色通常由一个Java抽象类或者Java接口实现。
 * 具体处理者角色(ConcreteHandler)：具体处理者接到请求后，可以选择将请求处理掉，或者将请求传给下家。由于具体处理者持有对下家的引用，因此，如果需要，具体处理者可以访问下家。
 * 抽象处理者角色
 */
public class App {
    public static void main(String[] args) throws Exception {
        //构建责任链
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HostFilter()).
                addFilter(new PortFilter()).
                addFilter(new QueryFilter());
        URLEntity urlEntity = new URLEntity();
        String url ="http://192.168.50.103:8080/test?username=lin";
        filterChain.doFilter(urlEntity,url,filterChain);
        System.out.println(urlEntity.getHost());
        System.out.println(urlEntity.getPort());
        System.out.println(urlEntity.getQuery());
    }
}
