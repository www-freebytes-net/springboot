package cn.qian.template;

/**
 * Created by 千里明月 on 2019/1/8.
 */


public abstract class AbstractClass {
    public final void prepareGotoSchool(){
        dressup();
        eatBreakfast();
        takeThings();
    }

    protected abstract void eatBreakfast();

    protected abstract void dressup();

    protected abstract void takeThings();
}
