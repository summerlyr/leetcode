
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {

	List<Integer> list = new LinkedList<Integer>();

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (canFinish(numCourses, prerequisites)) {
			if (numCourses <= 0) {
				return null;
			}
			int[] res = new int[numCourses];
			int index = 0;
			if (prerequisites.length == 0 || prerequisites[0].length == 0) {
				while (index < numCourses) {
					res[index] = index++;
				}
				return res;
			}
			for (int i = 0; i < list.size(); i++) {
				res[i] = list.get(i);
			}
			return res;
		}
		return null;
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses == 0 || prerequisites.length == 0)
			return true;
		int[][] matrix = new int[numCourses][numCourses];
		int[] visit = new int[numCourses];
		Arrays.fill(visit, 0);
		for (int i = 0; i < prerequisites.length; i++) {
			int start = prerequisites[i][1];
			int end = prerequisites[i][0];
			matrix[start][end] = 1;
			if (start != end && matrix[end][start] == 1)
				return false;
		}

		return topo(matrix, visit);
	}

	boolean DFS(int pos, int[][] matrix, int[] visit) {
		visit[pos] = -1;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[pos][i] == 1 && visit[i] != 1) {
				if (visit[i] == -1)
					return false;
				else if (visit[i] == 0 && !DFS(i, matrix, visit))
					return false;
			}
		}
		visit[pos] = 1;
		list.add(pos);
		return true;
	}

	boolean topo(int[][] matrix, int[] visit) {
		for (int i = 0; i < visit.length; i++) {
			if (visit[i] == 0) {
				if (!DFS(i, matrix, visit))
					return false;
			}
		}
		return true;
	}

	public int[] findOrder2(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		if (prerequisites.length == 0) {
			for (int i = 0; i < numCourses; i++) {
				res[i] = i;
			}
			return res;
		}
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		int[] indegree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int s = prerequisites[i][0];
			int e = prerequisites[i][1];
			if (!map.containsKey(s)) {
				map.put(s, new HashSet<Integer>());
			}
			if (map.get(s).add(e))
				indegree[e]++;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		int count = numCourses - 1;
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int course = queue.poll();
			res[count--] = course;
			if (map.containsKey(course)) {
				for (int i : map.get(course)) {
					if (--indegree[i] == 0)
						queue.offer(i);
				}
			}
		}
		if (count != -1)
			return new int[0];
		return res;

	}

	public int[] findOrder3(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses];
		int[] indegree = new int[numCourses];
		int[] res = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int s = prerequisites[i][0];
			int e = prerequisites[i][1];
			if (matrix[s][e] == 0)
				indegree[e]++;
			matrix[s][e] = 1;
			if (s != e && matrix[e][s] == 1)
				return new int[0];
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		int count = numCourses - 1;
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int course = queue.poll();
			res[count--] = course;
			for (int i = 0; i < numCourses; i++) {
				if (matrix[course][i] == 1) {
					if (--indegree[i] == 0)
						queue.offer(i);
				}
			}
		}
		if (count != -1)
			return new int[0];
		return res;
	}

	public static void main(String[] args) {
		CourseScheduleII cs = new CourseScheduleII();
		int[][] t = { { 0, 1 }, { 1, 0 } };
		int[] r = cs.findOrder(2, t);
		System.out.println(r[0]);

	}

}
