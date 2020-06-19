package cn.qian.algorithm;

/**
 * Created by 千里明月 on 2019/1/21.
 * 单链表是链表中结构最简单的。一个单链表的节点(Node)分为两个部分，
 * 第一个部分(data)保存或者显示关于节点的信息，
 * 另一个部分存储下一个节点的地址。最后一个节点存储地址的部分指向空值。
 单向链表只可向一个方向遍历，一般查找一个节点的时候需要从第一个节点开
 始每次访问下一个节点，一直访问到需要的位置。而插入一个节点，对于单向链表，
 我们只提供在链表头插入，只需要将当前插入的节点设置为头节点，next指向原头节点即可。
 删除一个节点，我们将该节点的上一个节点的next指向该节点的下一个节点。
 */
public class SingleLinkedList {
    private int size;
    private Node head;

    private class Node{
        private Object value;
        private Node next;

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void add(Object value){
        Node node = new Node(value, this.head);
        this.head=node;
        this.size++;
    }
    public void delete(Object value){
        if (this.head==null){
            return;
        }
        if (value==head.value){
            System.out.println(head.value+"被删除");
            head=head.next;
            size--;
            return;
        }
        Node node = this.head;
        while (node.next!=null){
            if (value==node.next.value){
                node.next=node.next.next;
                System.out.println(value+"被删除");
                size--;
                return;
            }
            node=node.next;
        }
    }
    public Object search(Object value){
        Node node = new Node(this.head.value, this.head.next);
        while (node!=null){
            if (node.value==value){
                return node.value;
            }
            node=node.next;
        }
        return null;
    }
    public void display(){
        Node node = new Node(this.head.value, this.head.next);
        while (node!=null){
            System.out.println(node.value);
            node=node.next;
        }
    }

    public int size(){
        return this.size;
    }

    public void deleteHead(){
        if (head!=null){
            head=head.next;
            size--;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add('A');
        singleLinkedList.add('B');
        singleLinkedList.add('C');
        singleLinkedList.add('D');
        singleLinkedList.add('E');

        Object e = singleLinkedList.search('E');
        System.out.println(e.toString());

        singleLinkedList.display();

        singleLinkedList.delete('E');
        singleLinkedList.delete('A');

        singleLinkedList.display();

    }
}
