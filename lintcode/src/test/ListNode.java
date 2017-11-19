package test;

public class ListNode {
	
	int value;
	ListNode next;
	
	ListNode(){}
	
	ListNode(int value){
		this.value = value;
	}
	
	ListNode(int value, ListNode node){
		this.value = value; 
		next = node;
	}
	
	public String toString() {
		return value + "->" + next;
	}
}
