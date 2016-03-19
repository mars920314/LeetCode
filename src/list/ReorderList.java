package list;
//Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
//reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
public class ReorderList {
	//like palindromeLinkedList, but get wrong
	public void reorderList(ListNode head) {
		readback(head, head);
	}
	ListNode readback(ListNode backward, ListNode forward){
		if(backward==null)
			return forward;
		ListNode next=readback(backward.next, forward);
		if(backward==next || backward.next==next){
			next.next=null;	//if not, there will be a loop
			return null;
		}
		if(next==null)
			return null;
		ListNode tmp=next.next;
		next.next=backward;
		backward.next=tmp;
		return tmp;
	}
	public static void main(String[] args){
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		ListNode node6=new ListNode(6);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		ReorderList RL=new ReorderList();
		RL.reorderList(node1);
	}

}
