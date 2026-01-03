/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/

class Solution {
    // Merge two sorted lists that use `bottom` to chain nodes.
    private Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;
        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }
        // Ensure `next` is null in the merged (final) list
        result.next = null;
        return result;
    }

    public Node flatten(Node root) {
        if (root == null || root.next == null) return root;

        // Flatten the list to the right first
        root.next = flatten(root.next);

        // Merge current list (root and its bottom) with the flattened right list
        root = merge(root, root.next);

        return root;
    }
}
