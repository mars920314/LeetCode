package list;
//Given a linked list, remove the nth node from the end of list and return its head.
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast=head;
		ListNode slow=head;
		while(fast.next!=null){
			if(n<=0){
				slow=slow.next;
			}
			fast=fast.next;
			n--;
		}
		if(n>0)
			return head.next;
		slow.next=slow.next.next;
		return head;
	}

}
