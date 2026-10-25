package algo.search.bts;

// Java program to find minimum
// value node in Binary Search Tree

// A binary tree node
class Node {

    int data;
    Node left, right, parent;

    Node(int d) {
        data = d;
        left = right = parent = null;
    }
}

public class BinaryTree {

    static Node head;

    /* Given a binary search tree and a number,
     inserts a new node with the given number in
     the correct place in the tree. Returns the new
     root pointer which the caller should then use
     (the standard trick to avoid using reference
     parameters). */
    Node insert(Node node, int data) {

        /* 1. If the tree is empty, return a new,
         single node */
        if (node == null) {
            return (new Node(data));
        } else {

            Node temp = null;

            /* 2. Otherwise, recur down the tree */
            if (data <= node.data) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
            } else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }

            /* return the (unchanged) node pointer */
            return node;
        }
    }

    Node inOrderSuccessor(Node n) {
        if(n.right!=null){
            return min(n);
        }
        Node temp = n.parent;
        while(temp!=null && temp== n.parent){
            n=temp;
            temp=n.parent;
        }
        return n;
    }

    private Node min(Node n) {
        Node curr = n;
        while(curr.right!=null){
            curr=curr.right;
        }
        return curr;
    }


    // Driver program to test above functions
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        temp = root.left.right.right;
        suc = tree.inOrderSuccessor(temp);
        if (suc != null) {
            System.out.println(
                    "Inorder successor of "
                            + temp.data + " is " + suc.data);
        } else {
            System.out.println(
                    "Inorder successor does not exist");
        }
    }
}
