package test;

public class CountLinkedListNodes {
	
	public static int countNodes(ListNode head) {
		int count = 0;
		while(head != null) {
			count++;
			head = head.next;
		}
        return count;
    }
	
	//使用递归，报StackOverflowError错误
	public static int countNodes1(ListNode head) {
		if(head == null) {
			return 0;
		}
        return 1 + countNodes(head.next);
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
		System.out.println(head);
		System.out.println(countNodes(head));
	}

}
