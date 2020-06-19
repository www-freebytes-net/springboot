package cn.qian.algorithm;

class Value{
    public int i=15;
}
public class Test{
    public static void main(String argv[]){
        Test t=new Test( );
        t.first( );
        SingleLinkedList singleLinkedList = new SingleLinkedList();
    }

    public void first( ){
        int i=5;
        Value v=new Value( );
        System.out.println(v);
        v.i=25;
        second(v,i);
        System.out.println(v);
        System.out.println(v.i);
    }

    public void second(Value v,int i){
        System.out.println(v);
        i = 0;
        v.i = 20;
        Value val = new Value( );
        v = val;
        System.out.println(v);
        System.out.println(v.i+" "+i);
    }
}
