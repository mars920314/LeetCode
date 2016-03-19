package list;
//Given a list, rotate the list to the right by k places, where k is non-negative.
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if(head==null)
			return null;
		ListNode tmp=head;
		int len=1;
		while(tmp.next!=null){
			len++;
			tmp=tmp.next;
		}
		tmp.next=head;
		len=len-k%len;
		while(len>0){
			len--;
			tmp=tmp.next;
		}
		head=tmp.next;
		tmp.next=null;
		return head;
	}

}
