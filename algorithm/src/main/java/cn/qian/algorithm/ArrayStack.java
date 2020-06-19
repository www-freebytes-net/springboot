package cn.qian.algorithm;

import java.util.Arrays;

/**
 * Created by 千里明月 on 2019/1/14.
 * 　栈（英语：stack）又称为堆栈或堆叠，栈作为一种数据结构，是一种只能在一端进行插入和删除操作的特殊线性表。它按照先进后出的原则存储数据，先进入的数据被压入栈底，
 * 最后的数据在栈顶，需要读数据的时候从栈顶开始弹出数据（最后一个数据被第一个读出来）。栈具有记忆作用，对栈的插入与删除操作中，不需要改变栈底指针。
 */
public class ArrayStack {
    private Object[] stack;
    private int top = -1;
    private int capicity;

    public ArrayStack(int capicity) {
        this.capicity = capicity;
        stack = new Object[capicity];
    }

    //压入元素
    public void push(Object o) {
        if ((top +1)== capicity) {
            grow();
        }
        stack[++top] = o;
    }

    //删除栈顶元素
    public void remove() {
        stack[top] = null;
        top--;
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //获取栈顶元素
    public Object peek() {
        return stack[top];
    }

    //弹出栈顶元素
    public Object pop() {
        Object peek = peek();
        remove();
        return peek;
    }

    /**
     * 是否需要扩容，如果需要，则扩大一倍并返回true，不需要则返回false
     */
    private void grow() {
        int newCapicity = (capicity << 1) > Integer.MAX_VALUE ? Integer.MAX_VALUE : capicity << 1;
        stack = Arrays.copyOf(stack, newCapicity);
        this.capicity = newCapicity;
    }


    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(2);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push("doubi");
//        System.out.println(arrayStack.peek());
//        System.out.println(arrayStack.isEmpty());
//        System.out.println(arrayStack.pop());
//        System.out.println(arrayStack.peek());

        while (!arrayStack.isEmpty()){
            System.out.println(arrayStack.pop());
        }

    }

}
