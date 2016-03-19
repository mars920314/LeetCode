package list;
//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummp=new ListNode(-1);
		ListNode tmp=dummp;
		while(l1!=null || l2!=null){
			if(l1==null){
				tmp.next=l2;
				break;
			}
			else if(l2==null){
				tmp.next=l1;
				break;
			}
			else if(l1.val>l2.val){
				tmp.next=l2;
				l2=l2.next;
			}
			else{
				tmp.next=l1;
				l1=l1.next;
			}
			tmp=tmp.next;
		}
		return dummp.next;
	}

}
