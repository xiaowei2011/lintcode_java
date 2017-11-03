package test;

import java.util.Arrays;

public class LFUCache {
	
	private Node[] nodes;
	private int s;
	
	/*
	 * @param capacity: An integer
	 */
	public LFUCache(int capacity) {
		nodes = new Node[capacity];
	}

	/*
	 * @param key: An integer
	 * 
	 * @param value: An integer
	 * 
	 * @return: nothing
	 */
	public void set(int key, int value) {
		for(int i = 0; i < nodes.length; i++) {
			if(nodes[i] != null && nodes[i].key == key) {
				nodes[i].value = value;
				nodes[i].s = ++s;
			}else if(nodes[i] == null || i == nodes.length - 1) {
				nodes[i] = new Node();
				nodes[i].key = key;
				nodes[i].value = value;
				nodes[i].s = ++s;
			}
		}
		Arrays.sort(nodes, (a,b)->{
			if(a == null) {
				return 1;
			}
			if(b == null) {
				return -1;
			}
			if(b.g != a.g) {
				return b.g - a.g;
			}
			return b.s - a.s;
		});
	}

	/*
	 * @param key: An integer
	 * 
	 * @return: An integer
	 */
	public int get(int key) {
		Node node = null;
		for(int i = 0; i < nodes.length; i++) {
			if(nodes[i] != null && nodes[i].key == key) {
				node = nodes[i];
				node.g++;
				break;
			}
		}
		Arrays.sort(nodes, (a,b)->{
			if(a == null) {
				return 1;
			}
			if(b == null) {
				return -1;
			}
			if(a.g != b.g) {
				return b.g - a.g;
			}
			return b.s - a.s;
		});
		return node == null ? -1 : node.value;
	}

	public static void main(String[] args) {
		test1();
	}
	
	static void test1() {
		LFUCache cache = new LFUCache(3);
		cache.set(2, 2);
		cache.set(1, 1);
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		cache.set(3, 3);
		cache.set(4, 4);
		System.out.println(cache.get(3));
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		System.out.println(cache.get(4));
	}
	
	static void test2() {
		Node[] nodes = new Node[5];
		nodes[2] = new Node();
		nodes[2].key = 1;
		nodes[3] = new Node();
		nodes[3].key = 2;
		nodes[4] = new Node();
		nodes[4].s = 1;
		nodes[4].key = 3;
		Arrays.stream(nodes).forEach(System.out::println);
		Arrays.sort(nodes, (a,b)->{
			if(a == null) {
				return 1;
			}
			if(b == null) {
				return -1;
			}
			if(a.g != b.g) {
				return a.g - b.g;
			}
			return a.s - b.s;
		});
		System.out.println("sort");
		Arrays.stream(nodes).forEach(System.out::println);
	}

}
class Node{
	int key;
	int value;
	int g;
	int s;
	
	@Override
	public String toString() {
		return "[key="+key+"]";
	}
}
