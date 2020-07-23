// https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });

        for (ListNode firstNode : lists) {
            if (firstNode != null)
                minHeap.add(firstNode);
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            head.next = node;
            head = head.next;
            if(node.next != null)
                minHeap.add(node.next);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // [
        // 1->4->5,
        // 1->3->4,
        // 2->6
        // ]

        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);

        ListNode n3 = new ListNode(2);
        n3.next = new ListNode(6);

        ListNode[] listArray = new ListNode[]{};

        ListNode res = new MergeKLists().mergeKLists(listArray);
        while(res!=null){
        System.out.println(res.val);
        res= res.next;
        }
    }
}