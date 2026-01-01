/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        Node curr1=head1;
        Node curr2=head2;
        while(curr1!=curr2){
            curr1=(curr1!=null) ? curr1.next: head2;
            curr2=(curr2!=null) ? curr2.next :head1;
        }
        return curr1;
    }
}
