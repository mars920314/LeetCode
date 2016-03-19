package list;
//Remove all elements from a linked list of integers that have value val.
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummp=new ListNode(-1);
		dummp.next=head;
		ListNode tmp=dummp;
		while(tmp.next!=null){
			if(tmp.next.val==val)
				tmp.next=tmp.next.next;
			else
				tmp=tmp.next;
		}
		return dummp.next;
	}

}
