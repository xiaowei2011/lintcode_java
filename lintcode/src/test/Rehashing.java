package test;

/**
 * @autor sunweijie
 * @since 2017年12月25日 下午10:35:33
 */
//129.重哈希
public class Rehashing {
	
	 public static ListNode[] rehashing(ListNode[] hashTable) {
		 if(hashTable == null) {
			 return null;
		 }
		 ListNode[] list = new ListNode[hashTable.length * 2];
		 for(ListNode node : hashTable) {
			 int hash;
			 ListNode n, next;
			 while(node != null) {
				 hash = (node.val + list.length) % list.length;
				 if(list[hash] == null) {
					 list[hash] = node;
				 }else {
					 n = list[hash];
					 while(n.next != null) {
						 n = n.next;
					 }
					 n.next = node;
				 }
				 next = node.next;
				 node.next = null;
				 node = next; 
			 }
		 }
		 return list;
	 }
	 
	 public static void main(String[] args) {
		 ListNode[] list = new ListNode[4];
		 list[1] = new ListNode(21,new ListNode(9));
		 list[2] = new ListNode(14);
		 ListNode[] result = rehashing(list);
		 Util.print(result);
		 list = new ListNode[5];
		 list[2] = new ListNode(42, new ListNode(32));
		 list[3] = new ListNode(-7);
//		 Util.print(rehashing(list));
		 System.out.println(-7 % 5);
	 }
}
