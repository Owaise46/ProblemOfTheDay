/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node reverseList(Node head) {
     Node curr=head;
      Node prev=null;
      Node fwd=null;
      while(curr!=null){
          fwd=curr.next;
          curr.next=prev;
          prev=curr;
          curr=fwd;
      }
      return prev;
    }
    
    public boolean isPalindrome(Node head) {
        Node slow=head, fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node curr=slow.next;
        slow.next=null;
        curr=reverseList(curr);
        
        while(head!=null && curr!=null){
            if(head.data!=curr.data) return false;
            head=head.next;
            curr=curr.next;
        } 
        return true;
    }
}
