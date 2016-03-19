package list;
//You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit.
//Add the two numbers and return it as a linked list.
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry=0;
		ListNode list1=l1,list2=l2,listres=new ListNode(-1),tmp=listres;
		while(list1!=null || list2!=null){
			if(list1!=null){
				carry=carry+list1.val;
				list1=list1.next;
			}
			if(list2!=null){
				carry=carry+list2.val;
				list2=list2.next;
			}
			tmp.next=new ListNode(carry%10);
			tmp=tmp.next;
			carry=carry/10;
		}
		if(carry!=0)
			tmp.next=new ListNode(carry%10);
		return listres.next;
	}

}
