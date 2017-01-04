import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class WordLadderII {

	private class wordVertex implements Comparable<wordVertex> {
		String word;
		List<wordVertex> prev;
		int dist;
		HashSet<wordVertex> neighbors;

		wordVertex(String w) {
			word = w;
			prev = new LinkedList<wordVertex>();
			dist = Integer.MAX_VALUE;
			neighbors = new HashSet<wordVertex>();
		}

		public int compareTo(wordVertex o) {
			if (dist < o.dist)
				return -1;
			else if (dist > o.dist)
				return 1;
			return 0;
		}
	}

	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		wordVertex startw = new wordVertex(start);
		wordVertex endw = new wordVertex(end);
		startw.dist = 0;
		List<wordVertex> vertexs = new ArrayList<wordVertex>();
		vertexs.add(startw);
		vertexs.add(endw);
		for (String s : dict) {
			vertexs.add(new wordVertex(s));
		}

		for (int i = 0; i < vertexs.size(); i++) {
			wordVertex cur = vertexs.get(i);
			for (int j = i + 1; j < vertexs.size(); j++) {
				wordVertex nei = vertexs.get(j);
				int diff = 0;
				for (int k = 0; k < cur.word.length(); k++) {
					if (cur.word.charAt(k) != nei.word.charAt(k) && diff++ == 1) {
						break;
					}
				}
				if (diff == 1) {
					cur.neighbors.add(nei);
					nei.neighbors.add(cur);
				}
			}
		}

		PriorityQueue<wordVertex> queue = new PriorityQueue<wordVertex>();
		for (wordVertex v : vertexs) {
			queue.add(v);
		}
		while (!queue.isEmpty()) {
			wordVertex cur = queue.poll();
			if (cur.dist < Integer.MAX_VALUE) {
				for (wordVertex n : cur.neighbors) {
					if (cur.dist + 1 <= n.dist) {
						n.dist = cur.dist + 1;
						n.prev.add(cur);
						queue.remove(n);
						queue.add(n);
					}
				}
			}
		}
		List<List<String>> seqs = new LinkedList<List<String>>();
		LinkedList<String> seq = new LinkedList<String>();
		construct(endw, startw, seq, seqs);

		return seqs;

	}

	void construct(wordVertex endw, wordVertex startw, LinkedList<String> seq, List<List<String>> seqs) {
		seq.addFirst(endw.word);
		if (endw == startw) {
			seqs.add(new LinkedList<String>(seq));
		}
		for (wordVertex p : endw.prev) {
			construct(p, startw, seq, seqs);
		}
		seq.removeFirst();
	}

	public List<List<String>> findLadders2(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> results = new ArrayList<List<String>>();// �������
		wordList.add(endWord);// �����ĵ��ʼ����ֵ�
		Deque<List<String>> paths = new LinkedList<List<String>>();// ˫����У���¼�м���̲���������
		List<String> path0 = new LinkedList<String>();// ��һ������ֻ����beginWord
		path0.add(beginWord);
		paths.add(path0);
		int level = 1, lastLevel = Integer.MAX_VALUE;
		Set<String> preLevel = new HashSet<String>();// �������������¼��һ���������word
		while (!paths.isEmpty()) {
			List<String> path = paths.pollFirst();
			if (path.size() > level) {
				wordList.removeAll(preLevel);// ����һ�α������Ĵ��ﶼ�Ƴ�wordList����ֹ�ظ�����
				preLevel.clear();
				level = path.size();
				if (level > lastLevel)
					break;
			}
			String last = path.get(level - 1);
			char[] chars = last.toCharArray();
			for (int index = 0; index < last.length(); index++) {
				char original = chars[index];
				for (char a = 'a'; a <= 'z'; a++) {
					chars[index] = a;
					String next = new String(chars);
					if (wordList.contains(next)) {
						preLevel.add(next);
						List<String> nextPath = new LinkedList<String>(path);
						// �������������´ʣ�����������һ���ʾͼ������������ڼ���˫������
						nextPath.add(next);
						if (next.equals(endWord)) {
							results.add(nextPath);
							lastLevel = level;
						} else {
							paths.addLast(nextPath);
						}
					}
				}
				chars[index] = original;
			}
		}
		return results;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
