package list;
//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//You should preserve the original relative order of the nodes in each of the two partitions.
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode dummp=new ListNode(-1);
		dummp.next=head;
		ListNode smalllist=dummp;
		ListNode dummplarge=new ListNode(-1);
		ListNode largerlist=dummplarge;
		while(smalllist.next!=null){
			if(smalllist.next.val<x){
				smalllist=smalllist.next;
			}else{
				largerlist.next=smalllist.next;
				largerlist=largerlist.next;
				smalllist.next=smalllist.next.next;
			}
		}
		largerlist.next=null;
		smalllist.next=dummplarge.next;
		return dummp.next;
	}
	public static void main(String[] args){
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		node1.next=node2;
		PartitionList PL=new PartitionList();
		PL.partition(node1, 0);
	}

}
