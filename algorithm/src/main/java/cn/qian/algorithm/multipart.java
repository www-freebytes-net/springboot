package cn.qian.algorithm;

/**
 * Created by 千里明月 on 2019/2/15.
 */
public class multipart {
    static int sum=1;
    public static void main(String[] args) {
        sum= multi(2,8);
        System.out.println(sum);
    }

    /**
     *乘方问题
     * @param x
     * @param y
     * @return
     */
    private static int multi(int x,int y ) {
        if (x<0||y<0){
            return -1;
        }
        if (x==0){
            return 0;
        }
        if (y==0){
            return sum;
        }
        sum=sum*x;
        y--;
        return multi(x,y);
    }

}
