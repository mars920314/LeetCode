package list;
//Write a program to find the node at which the intersection of two singly linked lists begins.
public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA=length(headA);
		int lenB=length(headB);
		if(lenA>lenB)
			return getnode(headA, headB, lenA-lenB);
		else
			return getnode(headB, headA, lenB-lenA);
	}
	int length(ListNode tmp){
		int len=0;
		while(tmp!=null){
			len++;
			tmp=tmp.next;
		}
		return len;
	}
	ListNode getnode(ListNode longlist, ListNode shortlist, int diff){
		while(diff>0){
			longlist=longlist.next;
			diff--;
		}
		while(longlist!=null && shortlist!=null){
			if(longlist.val==shortlist.val)
				return longlist;
			longlist=longlist.next;
			shortlist=shortlist.next;
		}
		return null;
	}

}
