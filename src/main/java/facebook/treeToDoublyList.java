package facebook;
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
/*
Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.
 */
public class treeToDoublyList {
    Node first = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        inorder(root);
        last.right = first;
        first.left = last;
        return first;
    }

    public void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        if(last != null){
            last.right = root;
            root.left = last;
        } else {
            first = root;
            // keep the smallest node to close DLL later on
        }
        last = root;
        inorder(root.right);
    }

}
