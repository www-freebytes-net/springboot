package cn.qian.chain.s1;

/**
 * Created by 千里明月 on 2019/1/25.
 *
 *
 * 责任链模式是一种对象的行为模式。在责任链模式里，很多对象由每一个对象对
 * 其下家的引用而连接起来形成一条链。请求在这个链上传递，直到链上的某一个
 * 对象决定处理此请求。发出这个请求的客户端并不知道链上的哪一个对象最终处
 * 理这个请求，这使得系统可以在不影响客户端的情况下动态地重新组织和分配责
 * 任。Tomcat中的Filter就是使用了责任链模式，创建一个Filter除了要在web.xml
 * 文件中做相应配置外，还需要实现javax.servlet.Filter接口。
 为了方便理解，责任链模式直接用马士兵老师中的一个例子来讲解，做下笔记也方便自己以后的复习查询：
 我们有一个字符串String msg = ":):,<script>,敏感,被就业,网络授课";我们希望应用以下三个规则对字符串进行过滤和谐处理：
 (1)将字符串中出现的"<>"符号替换成"[]"
 (2)处理字符串中的敏感信息，将被就业和谐成就业
 (3)将字符串中出现的":):"转换成"^V^";
 字符串会依次运用这三条规则，对字符串进行处理，每个规则都有自己需要完成的责任和任务。
 */
public class App {
    public static void main(String args[]) {
        //设定过滤规则，对msg字符串进行过滤处理
        String msg = ":):,<script>,敏感,被就业,网络授课";
        //过滤请求
        Request request=new Request();
        //set方法，将待处理字符串传递进去
        request.setRequest(msg);
        //处理过程结束，给出的响应
        Response response=new Response();
        //设置响应信息
        response.setResponse("response:");
        //FilterChain,过滤规则形成的拦截链条
        FilterChain fc=new FilterChain();
        //规则链条添加过滤规则，采用的是链式调用
        fc.addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter())
                .addFilter(new FaceFilter());
        //按照FilterChain的规则顺序，依次应用过滤规则
        fc.doFilter(request, response,fc);
        //打印请求信息
        System.out.println(request.getRequest());
        //打印响应信息
        System.out.println(response.getResponse());
        /*
         * 处理器对数据进行处理
         * --|----|---数据--|-----|---
         * 规则1      规则2                 规则3       规则4
         */
    }
}
