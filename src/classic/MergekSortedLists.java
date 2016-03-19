package classic;
//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
public class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length==0 || lists[0]==null)
			return null;
		for(int i=lists.length-1;i>=0;i--){
			if(lists[i]==null)
				continue;
			else if(i==0)
				return lists[0];
			else if(i>lists.length-1-i)
				merge(lists, i, lists.length-i-1);
			else if(i==lists.length-1-i)
				break;
			else
				break;
		}
		mergeKLists(lists);
		return lists[0];
	}
	void merge(ListNode[] lists, int a, int b){
		ListNode mergelist=null;
		ListNode tmp=mergelist;
		while(lists[a]!=null || lists[b]!=null){
			if(lists[a]==null){
				int min=lists[b].val;
				tmp.next=new ListNode(min);
				tmp=tmp.next;
				lists[b]=lists[b].next;
			}
			else if(lists[b]==null){
				int min=lists[a].val;
				tmp.next=new ListNode(min);
				tmp=tmp.next;
				lists[a]=lists[a].next;
			}
			else if(lists[a].val>lists[b].val){
			    int min=lists[b].val;
				tmp.next=new ListNode(min);
				tmp=tmp.next;
				lists[b]=lists[b].next;
			}
			else{
			    int min=lists[a].val;
				tmp.next=new ListNode(min);
				tmp=tmp.next;
				lists[a]=lists[a].next;
			}
			//mergelist.
		}
		lists[a]=mergelist.next;
		lists[b]=null;
	}
	//divide and conquer
	public ListNode mergeKLists1(ListNode[] lists) {
		if(lists.length==0)
			return null;
		return mergeklist1(lists, 0, lists.length-1);
	}
	ListNode mergeklist1(ListNode[] lists, int start, int end){
		if(start==end)
			return lists[start];
		int mid=(end+start)/2;
		ListNode left=mergeklist1(lists, start, mid);
		ListNode right=mergeklist1(lists, mid+1, end);
		return merge1(left, right);
	}
	ListNode merge1(ListNode left, ListNode right){
		ListNode mergelist=new ListNode(0);
		ListNode tmp=mergelist;
		while(left!=null || right!=null){
			if(left==null){
				int min=right.val;
				tmp.next=new ListNode(min);
				tmp=tmp.next;
				right=right.next;
			}
			else if(right==null){
				int min=left.val;
				tmp.next=new ListNode(min);
				tmp=tmp.next;
				left=left.next;
			}
			else if(left.val>right.val){
			    int min=right.val;
				tmp.next=new ListNode(min);
				tmp=tmp.next;
				right=right.next;
			}
			else{
			    int min=left.val;
				tmp.next=new ListNode(min);
				tmp=tmp.next;
				left=left.next;
			}
			//mergelist.
		}
		return mergelist.next;
	}
	//iterate
	public ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length==0)
            return null;
        int len=lists.length;
        while(len>1){
            int halflen=(len+1)/2;
            for(int i=0;i<halflen && halflen+i<len;i++){
                lists[i]=merge2(lists[i],lists[halflen+i]);
            }
            len=halflen;
        }
        return lists[0];
    }
    ListNode merge2(ListNode list1, ListNode list2){
    	ListNode dummp=new ListNode(-1);
        ListNode tmp=dummp;
        while(list1!=null || list2!=null){
            if(list1==null && list2!=null){
                tmp.next=list2;
                list2=list2.next;
            }
            else if(list1!=null && list2==null){
                tmp.next=list1;
                list1=list1.next;
            }
            else if(list1.val<list2.val){
                tmp.next=list1;
                list1=list1.next;
            }
            else{
                tmp.next=list2;
                list2=list2.next;
            }
            tmp=tmp.next;
        }
        return dummp.next;
    }
    
    
    public static void main(String[] args){
    	MergekSortedLists MSL=new MergekSortedLists();
    	ListNode list1=null;
    	ListNode list2=new ListNode(1);
    	ListNode[] lists={null,new ListNode(1)};
    	MSL.mergeKLists2(lists);
    }
}