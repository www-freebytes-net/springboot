package cn.qian.algorithm;

/**
 * Created by 千里明月 on 2019/1/22.
 */
public class Hannuota {
    public static void main(String[] args) {
        move(3,'A','B','C');
    }
    //64盘子
    //1. 将a的63个盘子放到 b  将a最后一个盘子放到c
    //2. 将b的62个盘子放到 a  将b最后一个盘子放到c
    //3. 将a的61个盘子放到 b  将a最后一个盘子放到c
    //4. .........................

    //4盘子
    //1. 将a的3个盘子放到 b  将a最后一个盘子放到c
    //2. 将b的2个盘子放到 a  将b最后一个盘子放到c
    //3. 将a的1个盘子放到 b  将a最后一个盘子放到c
    //4. b只剩1个盘子了  直接将b的1个盘子放到 c

    //    将b柱子作为辅助，把a上的63个圆盘移动到b上
    //            将a上最后一个圆盘移动到c
    //    将a作为辅助，把b上的62个圆盘移动到a上
    //            将b上的最后一个圆盘移动到c
    //......

    public static void move(int n, char start, char temp, char target){
        if (n==1){
            System.out.println("将盘子"+n+"从塔座"+start+"-->"+target);
            return;
        }else {
            move(n-1,start, target,temp );//将n-1个盘子由a移动到b，以c为辅助柱子（注意参数顺序）
            System.out.println("将盘子"+n+"从塔座"+start+"-->"+target);//将a上的最后一个盘子移动到c
            move(n-1,temp,start,target);//将n-1个盘子由b移动到c，以a为辅助柱子

        }
    }


    public static void move_back(int n , char start, char temp, char target){
        if (n==1){
            System.out.println("盘子"+n+":   "+start+"---->"+target);
            return;
        }else {
            move_back(n-1,start,target,temp);
            System.out.println("盘子"+n+":   "+start+"---->"+target);
            move_back(n-1,temp,start,target);
        }

    }

}
