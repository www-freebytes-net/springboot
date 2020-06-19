package cn.qian.adapter;

/**
 * Created by 千里明月 on 2018/12/27.
 */

/**
 * 个人理解   所谓适配器 其实就是在不得不调用某个底层接口规范, 但出于某些需要又必须声明
 * 自己专属的接口规范的时候, 可以声明一个对象实现自己的接口,同时又调用到底层接口, 该对象
 * 即是适配器, 适配器做了两个接口之间的转换工作, 提供自定义接口的同时又隐藏了实际接口.
 * 这样的情况下, 用户调用自定义接口的时候,实际上调用的是适配器的功能, 但是适配器调用的又是
 * 底层接口的功能, 所以用户实际上还是调用了底层接口.
 * 适配器的使用场景应该主要是以下几种:
 * 1. 代码需要调用不同的sdk接口规范, 但是又希望能统一这些不同的sdk接口规范.
 * 比方说需要做一个实现遥控器开机和关机的功能, A和B厂商分别提供了不同的
 * SDk或者jar包,并暴露了开机和关机的接口, 用户希望统一这两个接口规范, 就自定义了一个
 * 接口, 定义了两个开机\关机的方法, 这时候,就可以声明两个适配器去实现这个自定义接口,
 * 但是适配器的实现方法中是分别调用A\B厂商的sdk去实现的, 至于怎么去调用, 分成了两种方式, 一种是
 * 适配器通过继承sdk的实现类, 继而通过调用父类的方法去实现; 一种是把sdk的实现子类通过属性的方式
 * 设置到适配器中,以此调用.
 * 2....
 */
public class App1 {
    public static void main(String[] args) {
        LongoAdptee adptee = new LongoAdptee();
        adptee.shutdownForLongo();
        ControllDevice nanyiAdptee = new NanyiAdptee();
        nanyiAdptee.shutdown();
        ControllDevice adpter = new LongoAdpter(adptee);
        adpter.shutdown();
    }
}

interface ControllDevice {
    void startup();

    void shutdown();
}

class LongoAdptee {
    public void startupForLongo() {
        System.out.println("朗哥的开机功能");
    }

    public void shutdownForLongo() {
        System.out.println("朗哥的关机功能");
    }
}

class NanyiAdptee implements ControllDevice {
    @Override
    public void startup() {
        System.out.println("南翼的开机功能");
    }

    @Override
    public void shutdown() {
        System.out.println("南翼的关机功能");
    }
}

class LongoAdpter implements ControllDevice {

    private LongoAdptee adptee;

    public LongoAdpter(LongoAdptee adptee) {
        this.adptee = adptee;
    }

    @Override
    public void startup() {
        adptee.shutdownForLongo();
    }

    @Override
    public void shutdown() {
        adptee.shutdownForLongo();
    }
}