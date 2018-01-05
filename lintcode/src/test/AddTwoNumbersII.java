package test;

import java.util.Stack;

/**
 * @autor sunweijie
 * @since 2018年1月5日 下午5:14:11
 */
//221.链表求和II
public class AddTwoNumbersII {
	
	/*
     * @param l1: The first list.
     * @param l2: The second list.
     * @return: the sum list of l1 and l2.
     */
	public static ListNode addLists2(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
		ListNode p = l1;
		while(p != null) {
			s1.push(p.val);
			p = p.next;
		}
		p = l2;
		while(p != null) {
			s2.push(p.val);
			p = p.next;
		}
		int over = 0;
		ListNode l = null;
		while(!s1.isEmpty() && !s2.isEmpty()) {
			int n = s1.pop() + s2.pop() + over;
			over = n / 10;
			ListNode node = new ListNode(n % 10);
			node.next = l;
			l = node;
		}
		while(!s1.isEmpty()) {
			int n = s1.pop() + over;
			over = n / 10;
			ListNode node = new ListNode(n % 10);
			node.next = l;
			l = node;
		}
		while(!s2.isEmpty()) {
			int n = s2.pop() + over;
			over = n / 10;
			ListNode node = new ListNode(n % 10);
			node.next = l;
			l = node;
		}
		if(over > 0) {
			ListNode node = new ListNode(over);
			node.next = l;
			l = node;
		}
    	return l;
    }
	
	//运行不通过，当数过长是long溢出
    public static ListNode addLists2I(ListNode l1, ListNode l2) {
    	return longToList(listToLong(l1) + listToLong(l2));
    }
    
    static long listToLong(ListNode l) {
    	if(l == null) {
    		return 0;
    	}
    	long n = l.val;
    	while((l = l.next) != null) {
    		n = n * 10 + l.val;
    	}
    	return n;
    }
    
    static ListNode longToList(long n) {
    	if(n == 0) {
    		return new ListNode(0);
    	}
    	ListNode l = null;
    	while(n > 0) {
    		ListNode node = new ListNode((int)(n % 10));
    		n /= 10;
    		node.next = l;
    		l = node;
    	}
    	return l;
    }

	public static void main(String[] args) {
		ListNode l1 = new ListNode(6, new ListNode(1, new ListNode(7)));
		ListNode l2 = new ListNode(2, new ListNode(9, new ListNode(5)));
//		System.out.println(addLists2(l1, l2));
		int[] a1 = {1, 1, 1, 1, 1};
		l1 = Util.arrayToList(a1);
		int[] a2 = {9, 8, 8, 8, 8};
		l2 = Util.arrayToList(a2);	
		System.out.println(addLists2(l1, l2));	
	}

}
