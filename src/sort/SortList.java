package sort;
//Sort a linked list in O(n log n) time using constant space complexity.
//难点是如何O(1)定位节点。数组可以通过下标直接找到节点，但是链表没有下标，定位到第k个元素只能从节点头部顺序的访问K次.采用merge sort，可通过递归的特性来避免这个时间损耗
public class SortList {
	public ListNode sortList(ListNode head) {
		return null;
	}
	//Sort a linked list using insertion sort.
	public ListNode insertionSortList(ListNode head) {
		return null;
	}

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
