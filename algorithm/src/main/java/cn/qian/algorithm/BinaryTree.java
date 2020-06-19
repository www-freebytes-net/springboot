package cn.qian.algorithm;

/**
 * Created by 千里明月 on 2019/2/15.
 * <p>
 * 二叉搜索树
 */
public class BinaryTree {
    private static Node root;

    public static void main(String[] args) {
        Node node = new Node(10);
        root = node;
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);

        Node node1 = bt.find(90);
        System.out.println(node1.data);

//        binaryTree.infixOrder(root);
//        binaryTree.preOrder(root);
//        binaryTree.postOrder(root);
        System.out.println(bt.findMax().data);
        System.out.println(bt.findMin().data);
    }

    static class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;

        public Node(int data) {
            this.data = data;
        }

        public void display() {
            System.out.println(data);
        }
    }

    public interface Tree {
        //查找节点
        public Node find(int key);

        //插入新节点
        public boolean insert(int key);

        //删除节点
        public boolean delete(int key);
        //Other Method......
    }

    /**
     * 　　查找某个节点，我们必须从根节点开始遍历。
     * 　　①、查找值比当前节点值大，则搜索右子树；
     * 　　②、查找值等于当前节点值，停止搜索（终止条件）；
     * 　　③、查找值小于当前节点值，则搜索左子树；
     *
     * @param key
     * @return
     */
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            int compare = compare(current.data, key);
            if (compare == 0) {
                return current;
            }
            if (compare == 1) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        return null;
    }

    private int compare(int x, int y) {
        return x == y ? 0 : (x > y ? 1 : -1);
    }

    /**
     * 　　 要插入节点，必须先找到插入的位置。与查找操作相似，由于二叉搜索树的特殊性，
     * 待插入的节点也需要从根节点开始进行比较，小于根节点则与根节点左子树比较，反之则
     * 与右子树比较，直到左子树为空或右子树为空，则插入到相应为空的位置，在比较的过程
     * 中要注意保存父节点的信息 及 待插入的位置是父节点的左子树还是右子树，才能插入到
     * 正确的位置。
     *
     * @param data
     * @return
     */
    public boolean insert(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
            return true;
        }
        Node current = root;
        while (current != null) {
            int compare = compare(data, current.data);
            if (compare == 0) {
                return true;
            }
            if (compare == 1) {
                if (current.rightChild != null) {
                    current = current.rightChild;
                    continue;
                } else {
                    current.rightChild = node;
                    return true;
                }
            } else {
                if (current.leftChild != null) {
                    current = current.leftChild;
                    continue;
                } else {
                    current.leftChild = node;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean delete(int key) {
        return false;
    }

    /**
     * 中序遍历:左子树——》根节点——》右子树
     *
     * @param current
     */
    public void infixOrder(Node current) {
        if (current == null) {
            return;
        }
        infixOrder(current.leftChild);
        System.out.println(current.data);
        infixOrder(current.rightChild);
    }

    /**
     * 前序遍历:根节点——》左子树——》右子树
     *
     * @param current
     */
    public void preOrder(Node current) {
        if (current == null) {
            return;
        }
        System.out.println(current.data);
        preOrder(current.leftChild);
        preOrder(current.rightChild);
    }

    /**
     * 后序遍历:左子树——》右子树——》根节点
     *
     * @param current
     */
    public void postOrder(Node current) {
        if (current == null) {
            return;
        }
        postOrder(current.leftChild);
        postOrder(current.rightChild);
        System.out.println(current.data);
    }

    /**
     * 找到最大值
     * @return
     */
    public Node findMin(){
        Node current = root;
        while (current!=null){
            if (current.leftChild!=null){
                current=current.leftChild;
            }else {
                break;
            }
        }
        return current;
    }

    /**
     * 找到最小值
     * @return
     */
    public Node findMax(){
        Node current = root;
        while (current!=null){
            if (current.rightChild!=null){
                current=current.rightChild;
            }else {
                break;
            }
        }
        return current;
    }
}
