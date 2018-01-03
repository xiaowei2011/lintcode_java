package test;

/**
 * @autor sunweijie
 * @since 2018年1月1日 下午8:16:33
 */
//173.链表插入排序
public class InsertionSortList {
	
	/*
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode cur = head.next;
        head.next = null;
        while(cur != null) {
        	ListNode next = cur.next;
        	cur.next = null;
        	ListNode p = h.next;
        	ListNode pre = h;
        	while(p != null && p.val < cur.val) {
        		pre = p;
        		p = p.next;
        	}
        	pre.next = cur;
        	cur.next = p;
        	cur = next;
        }
    	return h.next;
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(3, new ListNode(2, new ListNode(0))));
		System.out.println(insertionSortList(head));
	}

}
