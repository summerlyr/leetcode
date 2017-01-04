import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            public int compare(ListNode l1,ListNode l2) {
                return l1.val-l2.val;
            }
        };
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,cmp);
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(ListNode list:lists) {
            if(list!=null) queue.add(list);
        }
        while(!queue.isEmpty()) {
            ListNode next = queue.poll();
            if(next.next!=null) queue.add(next.next);
            cur.next = next;
            cur = cur.next;
        }
        return head.next;
    }
	
    public ListNode mergeKLists2(ListNode[] lists) {
        return partition(lists,0,lists.length-1);
    }
    public ListNode partition(ListNode[] lists,int s,int e) {
        if(s==e) return lists[s];
        if(s<e) {
            int m = (s+e)/2;
            ListNode l1 = partition(lists,s,m);
            ListNode l2 = partition(lists,m+1,e);
            return mergeTwoLists(l1,l2);
        }
        else return null;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode newlist = new ListNode(0);
		ListNode newhead = newlist;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				ListNode cur = new ListNode(l1.val);
				newhead.next = cur;
				l1 = l1.next;
			} else {
				ListNode cur = new ListNode(l2.val);
				newhead.next = cur;
				l2 = l2.next;
			}
			newhead = newhead.next;
		}
		while (l1 != null) {
			ListNode cur = new ListNode(l1.val);
			newhead.next = cur;
			newhead = newhead.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			ListNode cur = new ListNode(l2.val);
			newhead.next = cur;
			newhead = newhead.next;
			l2 = l2.next;
		}
		return newlist.next;
	}

}
