package cn.qian.adapter;

/**
 * Created by 千里明月 on 2018/12/27.
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

class NanyiAdptee implements ControllDevice{
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