
import java.util.List;

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				triangle.get(i).set(j,
						Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
			}
		}
		return triangle.get(0).get(0);
	}

	public static void main(String[] args) {

	}
}
