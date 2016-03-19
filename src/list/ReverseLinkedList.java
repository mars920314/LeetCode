package list;
//Reverse a singly linked list.
public class ReverseLinkedList {
	//wrong
	public ListNode reverseList(ListNode head) {
		ListNode last=head;
		if(last==null)
			return head;
		ListNode cur=last.next;
		if(cur==null)
			return head;
		ListNode next=cur.next;
		head.next = null;
		while(cur.next!=null){
			next=cur.next;
			cur.next=last;
			last=cur;
			cur=next;
			next=cur.next;
		}
		return cur;
	}
	//iteratively
	public ListNode reverseList1(ListNode head) {
		if(head==null || head.next==null)
			return head;
		ListNode last=head;
		ListNode cur=head.next;
		head.next=null;
		while(cur!=null){
			ListNode next=cur.next;
			cur.next=last;
			last=cur;
			if(next!=null)
				cur=next;
			else
				break;
		}
		return cur;
		
	}
	//iteratively
	public ListNode reverseList2(ListNode head) {
		ListNode prev=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
	}
	//recursively
	public ListNode reverseList3(ListNode head) {
		if(head==null || head.next == null)
	        return head;
		ListNode next=head.next;
		head.next=null;
		ListNode res= reverseList3(next);
		next.next=head;
		return res;
	}
	//Reverse a linked list from position m to n. Do it in-place and in one-pass. For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL. 1 ≤ m ≤ n ≤ length of list.
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode tmp=dummy;
        while(m!=1){
            tmp=tmp.next;
            m--;
            n--;
        }
        ListNode prev=tmp.next;
        ListNode curr=prev.next;
        while(n!=1){
            n--;
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        tmp.next.next=curr;
        tmp.next=prev;
        return dummy.next;
    }

}
