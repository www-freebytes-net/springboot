package cn.qian.algorithm;

/**
 * Created by 千里明月 on 2019/1/21.
 */
public class LinkStack {
    private SingleLinkedList singleLinkedList;

    public void setSingleLinkedList(SingleLinkedList singleLinkedList) {
        this.singleLinkedList = singleLinkedList;
    }

    public void push(Object value){
        singleLinkedList.add(value);
    }
    public void pop(){
        singleLinkedList.deleteHead();
    }
    public void display(){
        singleLinkedList.display();
    }

    public static void main(String[] args) {
        LinkStack linkStack = new LinkStack();
        linkStack.setSingleLinkedList(new SingleLinkedList());
        linkStack.push('A');
        linkStack.push('B');
        linkStack.push('C');
        linkStack.push('D');
        linkStack.push('E');
        linkStack.display();
    }
}
