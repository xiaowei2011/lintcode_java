package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	
	//使用堆，时间复杂度为nklogk,空间复杂度为k
	public static ListNode mergeKLists(List<ListNode> lists) {
		if(lists == null || lists.isEmpty()) {
			return null;
		}
		PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.size(), (a, b) -> {
			return a.val - b.val;
		});
		for(ListNode node : lists) {
			if(node != null) {
				heap.add(node);
			}
		}
		ListNode p = new ListNode(0);
		ListNode head = p;
		while(heap.size() > 0) {
			p.next = heap.poll();
			if(p.next.next != null) {
				heap.add(p.next.next);
			}
			p = p.next;
		}
		return head.next;
	}
	
	//分治法，时间复杂度为nklogk，空间复杂度为1
	public static ListNode mergeKLists3(List<ListNode> lists) {
		if(lists == null || lists.isEmpty()) {
			return null;
		}
		return mergeKList(lists, 0, lists.size() - 1);
	}
	
	public static ListNode mergeKList(List<ListNode> lists, int start, int end) {
		if(start == end) {
			return lists.get(start);
		}
		int mid = start + (end - start) / 2;
		ListNode left = lists.get(start);
		ListNode right = lists.get(end);
		left = mergeKList(lists, start, mid);	
		right = mergeKList(lists, mid + 1, end);
		ListNode p = new ListNode(0);
		ListNode head = p;
		while(left != null && right != null) {
			if(left.val <= right.val) {
				p.next = left;
				left = left.next;
			}else {
				p.next = right;
				right = right.next;
			}
			p = p.next;
		}
		if(left != null) {
			p.next = left;
		}
		if(right != null) {
			p.next = right;
		}
		return head.next;
	}

	//时间复杂度为n(k^2)
	public static ListNode mergeKLists2(List<ListNode> lists) {
		ListNode p = min(lists);
		ListNode head = p;
		ListNode pre = p;
		while((p = min(lists)) != null) {
			pre.next = p;
			pre = p;
		}
		return head;
	}
	
	static ListNode min(List<ListNode> lists) {
		ListNode p = null;
		int id = -1;
		for(int i = 0; i < lists.size(); i++) {
			ListNode node = lists.get(i);
			if(node != null && (p == null || node.val < p.val)) {
				p = node;
				id = i;
			}
		}
		if(id != -1) {
			lists.set(id, lists.get(id).next);
		}
		return p;
	}

	//链表数量为k,平均长度为n,则时间复杂度为nklog(nk),空间复杂度为nk,不够理想
	public static ListNode mergeKLists1(List<ListNode> lists) {
		List<Integer> list = new ArrayList<>();
		for (ListNode node : lists) {
			while (node != null) {
				list.add(node.val);
				node = node.next;
			}
		}
		Collections.sort(list);
		ListNode p = new ListNode(0);
		ListNode head = p;
		for (Integer val : list) {
			p.next = new ListNode(val);
			p = p.next;
		}
		return head.next;
	}

	public static void main(String[] args) {
		List<ListNode> nodes = new ArrayList<>();
		nodes.add(new ListNode(2, new ListNode(4)));
		nodes.add(null);
		nodes.add(new ListNode(-1));
		System.out.println(mergeKLists(nodes));
	}

}
