package cn.qian.template;

/**
 * Created by 千里明月 on 2019/1/8.
 */
public class TeacherClass extends AbstractClass {


    @Override
    protected void eatBreakfast() {
        System.out.println("和孩子一起吃早饭");
    }

    @Override
    protected void dressup() {
        System.out.println("穿上教师服");
    }

    @Override
    protected void takeThings() {
        System.out.println("带上考卷");
    }
}
