
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if (node == null)
			return null;
		if (map.containsKey(node.label)) {
			return map.get(node.label);
		}
		UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
		map.put(newHead.label, newHead);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			newHead.neighbors.add(cloneGraph(neighbor));
		}

		return newHead;
	}

	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if (node == null)
			return null;
		Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		UndirectedGraphNode ug = new UndirectedGraphNode(node.label);
		map.put(ug.label, ug);
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			for (UndirectedGraphNode n : cur.neighbors) {
				if (!map.containsKey(n.label)) {
					UndirectedGraphNode nh = new UndirectedGraphNode(n.label);
					map.put(n.label, nh);
					queue.add(n);
				}
				map.get(cur.label).neighbors.add(map.get(n.label));
			}
		}
		return ug;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
