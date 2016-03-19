package list;
//Given a singly linked list, determine if it is a palindrome. do it in O(n) time and O(1) space
public class PalindromeLinkedList {
	boolean palindrome=true;
	public boolean isPalindrome(ListNode head) {
		readback(head,head);
		return palindrome;
	}
	ListNode readback(ListNode back, ListNode forward){
		if(back==null)
			return forward;
		ListNode next=readback(back.next, forward);
		if(back.val!=next.val)
			palindrome=false;
		return next.next;
	}

}
