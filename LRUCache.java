import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	class DoubleLinkedNode {
		int key;
		int value;
		DoubleLinkedNode pre;
		DoubleLinkedNode post;
	}

	Map<Integer, DoubleLinkedNode> map = new HashMap<Integer, DoubleLinkedNode>();
	DoubleLinkedNode head;
	DoubleLinkedNode tail;
	int count;
	int capacity;

	public void addNode(DoubleLinkedNode node) {
		head.post.pre = node;
		node.post = head.post;
		node.pre = head;
		head.post = node;

	}

	public void removeNode(DoubleLinkedNode node) {
		DoubleLinkedNode pre = node.pre;
		DoubleLinkedNode post = node.post;
		pre.post = post;
		post.pre = pre;
	}

	public void moveToHead(DoubleLinkedNode node) {
		removeNode(node);
		addNode(node);
	}

	public DoubleLinkedNode popTail() {
		DoubleLinkedNode res = tail.pre;
		removeNode(res);
		return res;
	}

	public LRUCache(int capacity) {
		count = 0;
		this.capacity = capacity;

		head = new DoubleLinkedNode();
		tail = new DoubleLinkedNode();

		head.post = tail;
		tail.pre = head;

		head.pre = null;
		tail.post = null;
	}

	public int get(int key) {
		DoubleLinkedNode cur = map.get(key);
		if (cur != null) {
			moveToHead(cur);
			return cur.value;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		DoubleLinkedNode cur = map.get(key);
		if (cur == null) {
			DoubleLinkedNode newNode = new DoubleLinkedNode();
			newNode.key = key;
			newNode.value = value;
			map.put(key, newNode);
			count++;
			addNode(newNode);
			if (count > capacity) {
				DoubleLinkedNode tail = popTail();
				map.remove(tail.key);
				count--;
			}

		} else {
			cur.value = value;
			moveToHead(cur);
		}
	}
}