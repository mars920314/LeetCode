package list;
//Given a linked list, swap every two adjacent nodes and return its head.
public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode dummp=new ListNode(-1);
		dummp.next=head;
		ListNode prev=dummp;
		boolean reverse=true;
		while(head!=null && head.next!=null){
			ListNode next=head.next;
			if(reverse){
				head.next=next.next;
				prev.next=next;
				next.next=head;
				prev=next;
			}else{
				prev=head;
				head=head.next;
			}

			reverse=!reverse;
		}
		return dummp.next;
	}

}
