package list;

public class ReverseNodesinkGroup {
	//recursive
	public ListNode reverseKGroup1(ListNode head, int k) {
        if(k==1)
            return head;
        ListNode dummp=new ListNode(-1);
        dummp.next=head;
        int len=k;
        while(head!=null){
            if(len==1){
                ListNode tmpnext=reverseKGroup(head.next, k);
                ListNode prev=tmpnext;
                ListNode cur=dummp.next;
                while(k>0){
                    ListNode next=cur.next;
                    cur.next=prev;
                    prev=cur;
                    cur=next;
                    k--;
                }
                dummp.next=prev;
                break;
            }
            head=head.next;
            len--;
        }
        return dummp.next;
    }
	//iterate, but wrong
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return null;
        if(k<2)
            return head;
        int len=1;
        ListNode dummp=new ListNode(-1);
        dummp.next=head;
        ListNode tmphead=dummp;
        while(head!=null){
            if(len%k==0){
            	ListNode tmpend=head.next;
                tmphead=reverse(tmphead, tmpend, k);
                head=tmpend;
            }
            else
                head=head.next;
            len++;
        }
        return dummp.next;
    }
    ListNode reverse(ListNode tmphead, ListNode tmpend, int k){
        ListNode prev=tmpend;
        ListNode cur=tmphead.next;
        while(k>0){
            k--;
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        ListNode tmp1=tmphead.next;
        tmphead.next=cur;
        tmp1.next=tmpend;
        return tmp1;
    }
    public static void main(String[] args){
    	ListNode node1=new ListNode(1);
    	ListNode node2=new ListNode(2);
    	ListNode node3=new ListNode(3);
    	node1.next=node2;
    	node2.next=node3;
    	ReverseNodesinkGroup RNG=new ReverseNodesinkGroup();
    	RNG.reverseKGroup(node1, 2);
    }

}
