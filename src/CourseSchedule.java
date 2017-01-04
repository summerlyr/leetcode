import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

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

	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses];
		int[] indegree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int s = prerequisites[i][0];
			int e = prerequisites[i][1];
			if (matrix[s][e] == 0)
				indegree[e]++;
			matrix[s][e] = 1;
			if (s != e && matrix[e][s] == 1)
				return false;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		int count = 0;
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			for (int i = 0; i < numCourses; i++) {
				if (matrix[course][i] == 1) {
					if (--indegree[i] == 0)
						queue.offer(i);
				}
			}
		}
		return count == numCourses;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
