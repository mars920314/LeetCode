package test;

public class reverselinkedlist {
	public void reverselinkedlist(ListNode root){
		if(root==null)
			return;
		ListNode fast=root;
		ListNode slow=root;
		while(fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==null)
				break;
		}
		ListNode prev=slow;
		ListNode curr=slow.next;
		ListNode next=null;
		while(curr!=null){
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
	}
	public static void main(String args[]){
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		ListNode node6=new ListNode(6);
		ListNode node7=new ListNode(7);
		ListNode node8=new ListNode(8);
		ListNode node9=new ListNode(9);
		ListNode node10=new ListNode(10);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node7;
		node7.next=node8;
		node8.next=node9;
		node9.next=node10;
		reverselinkedlist RL=new reverselinkedlist();
		RL.reverselinkedlist(node1);
	}

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int var){
		this.val=var;
	}
}