package cn.qian.algorithm;

/**
 * Created by 千里明月 on 2019/1/16.
 */

/**
 * 　队列（queue）是一种特殊的线性表，特殊之处在于它只允许在表的前端（front）进行删除操作，而在表的后端（rear）进行插入操作，
 * 和栈一样，队列是一种操作受限制的线性表。进行插入操作的端称为队尾，进行删除操作的端称为队头。队列中没有元素时，称为空队列。
 */
public class ArrayQueue {

    private Object[] queue;
    //元素数量
    private int eleNums;
    //队头
    private int front;
    //队尾
    private int rear;
    //队列大小
    private int size;

    public ArrayQueue(int size) {
        this.size = size;
        queue = new Object[size];
        front = 0;
        rear = -1;
        eleNums = 0;
    }

    public boolean insert(Object value) {
        if (isFull()) {
            System.out.println("队列已满");
            return false;
        }
        rear = (rear + 1) % size;
        queue[rear] = value;
        eleNums++;
        return true;
    }

    public Object remove() {
        if (isEmpty()){
            System.out.println("队列为空");
            return null;
        }
        Object o = queue[front];
        queue[front] = null;
        front = (front + 1) % size;
        eleNums--;
        return o;
    }

    public boolean isEmpty() {
        return eleNums == 0;
    }

    public Object peek() {
        return queue[front];
    }

    public int getSize() {
        return this.eleNums;
    }

    public boolean isFull() {
        return size == eleNums;
    }


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        System.out.println(queue.peek());
        System.out.println(queue.getSize());

        System.out.println(queue.remove());

        System.out.println(queue.getSize());

        System.out.println(queue.insert(6));
        System.out.println(queue.peek());

    }
}
