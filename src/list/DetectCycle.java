package list;
public class DetectCycle {
	//Given a linked list, determine if it has a cycle in it.
	public boolean hasCycle(ListNode head) {
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
				return true;
		}
		return false;
	}
	//Given a linked list, return the node where the cycle begins. If there is no cycle, return null. solve it without using extra space.
	public ListNode detectCycle(ListNode head) {
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				slow=head;
				while(slow!=fast){
					slow=slow.next;
					fast=fast.next;
				}
				return slow;
			}
		}
		return null;
    }
}

