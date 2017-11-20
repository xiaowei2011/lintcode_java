package test;

public class ListNode {
	
	int val;
	ListNode next;
	
	ListNode(int val){
		this.val = val;
	}
	
	ListNode(int val, ListNode node){
		this.val = val; 
		next = node;
	}
	
	public String toString() {
		return val + "->" + next;
	}
}
