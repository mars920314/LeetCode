package list;
//Given a sorted linked list, delete all duplicates such that each element appear only once.
public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null)
			return head;
		ListNode tmp=head;
		while(tmp.next!=null){
			if(tmp.val==tmp.next.val)
				tmp.next=tmp.next.next;
			else
				tmp=tmp.next;
		}
		return head;
	}
	//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
	public ListNode deleteDuplicates2(ListNode head) {
		ListNode dummp=new ListNode(-1);
		dummp.next=head;
		ListNode tmp=dummp;
		while(tmp.next!=null && tmp.next.next!=null){
			if(tmp.next.val==tmp.next.next.val){
				int dup=tmp.next.val;
				while(tmp.next!=null && tmp.next.val==dup){
					tmp.next=tmp.next.next;
				}
			}
			else
				tmp=tmp.next;
		}
		return dummp.next;
	}

}
