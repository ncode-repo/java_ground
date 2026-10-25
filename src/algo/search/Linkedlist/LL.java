package algo.search.Linkedlist;

import java.util.ArrayList;
import java.util.List;

class Node{
    int data;
    Node next;
    public Node(int x){
        data=x;
        next=null;
    }
}
public class LL {


    public static void main(String[] args) {
        Node head = new Node(0);
        System.out.print("head:");
        for (int i = 6; i >0 ; i--) {
            Node node = new Node(i);
            node.next=head;
            head=node;
            System.out.print("->"+i);
        }
        int mid= getMiddleNode(head);
        System.out.println("\nMid of LL="+mid);
    }
    static void pushNode(Node head, int data){
        Node node = new Node(data);
        node.next=head;
        head=node;
    }
    private static int getMiddleNode(Node head) {
        List<Integer> ll= new ArrayList<>();
        while (head!=null){
            ll.add(head.data);
            head=head.next;
        }
        return ll.get(ll.size()/2);
    }
}
