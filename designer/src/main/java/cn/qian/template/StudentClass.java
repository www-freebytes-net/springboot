package cn.qian.template;

/**
 * Created by 千里明月 on 2019/1/8.
 */
public class StudentClass extends AbstractClass {

    @Override
    protected void eatBreakfast() {
        System.out.println("吃妈妈做的早饭");
    }

    @Override
    protected void dressup() {
        System.out.println("穿上学生服");
    }

    @Override
    protected void takeThings() {
        System.out.println("背上书包");
    }

}
