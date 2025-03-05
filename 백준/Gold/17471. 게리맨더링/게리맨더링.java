import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int[] peoples;
	static int[][] map;
	static boolean[] isChoice;

	static int moveCnt = 0;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		// 입력 받는 함수
		input();
		
		// 이제 두 개의 지역구로 나눌 건데
		// 최소 1개는 가지고 있어야 하니 1부터 시작
		// N이 끝까지 돌 필요 없음 (근데 N이 너무 작아서 큰 차이 안남)
		for (int i = 1; i <= N/2; i++) {
			isChoice = new boolean[N + 1];
			// 조합뽑기
			combination(1, 0, i);
		}

		min = (min == Integer.MAX_VALUE) ? -1 : min;
		System.out.println(min);
	}

	public static void combination(int start, int depth, int r) {

		// 다 뽑았으면
		if (depth == r) {
			ArrayList<Integer> choiceList = new ArrayList<>();
			ArrayList<Integer> notChoiceList = new ArrayList<>();

			int choiceSum = 0;
			int notChoiceSum = 0;

			boolean isConnected = true;
			for (int i = 1; i <= N; i++) {
				// 선택한 것을 choiceList에 담고
				if (isChoice[i]) {
					choiceList.add(i);
					choiceSum += peoples[i];
				} else {	// 선택하지 않는 것들은 자동으로 noChoiceList에 담으면 됨
					notChoiceList.add(i);
					notChoiceSum += peoples[i];
				}
			}

			// 조합으로 선택한 것들이 연결되어 있는지를 확인
			moveCnt = 1;
			boolean[] visited = new boolean[N + 1];
			visited[choiceList.get(0)] = true;
			dfs(choiceList.get(0), choiceList, visited);
			// moveCnt가 연결된 노드의 갯수가 아니라면 모든 노드를 방문하지 못했다는 뜻으로 
			// isConnected를 false로 바꿔준다
			if (moveCnt != choiceList.size()) {
				isConnected = false;
			}

			// 선택하지 않은 남은 것들이 연결되어 있는지를 확인
			moveCnt = 1;
			visited = new boolean[N + 1];
			visited[notChoiceList.get(0)] = true;
			dfs(notChoiceList.get(0), notChoiceList, visited);
			if (moveCnt != notChoiceList.size()) {
				isConnected = false;
			}

			// 연결되어 있으면 최솟값 갱신
			if (isConnected) {
				min = Math.min(Math.abs(notChoiceSum - choiceSum), min);
			}
			return;
		}

		// 조합으로 뽑기
		for (int i = start; i <= N; i++) {
			isChoice[i] = true;
			combination(i + 1, depth + 1, r);
			isChoice[i] = false;
		}
	}

	// 연결 되어 있는지 깊이 우선 탐색
	public static void dfs(int node, ArrayList<Integer> list, boolean[] visited) {

		for (int i = 1; i <= N; i++) {
			// 현재 노드가 다른 노드들이랑 연결이 되어있고 아직 방문하지 않은 것
			if (map[node][i] == 1 && !visited[i]) {
				// 위 조건에 해당하는 노드가 현재 묶여있는 list에 들어 있는지 확인
				for (int j = 0; j < list.size(); j++) {
					if (i == list.get(j)) {
						visited[i] = true;
						// 움직일 수 있으면 moveCnt++
						moveCnt++;
						dfs(i, list, visited);
					}
				}
			}
		}
	}

	public static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		peoples = new int[N + 1];
		map = new int[N + 1][N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			peoples[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int neighborCnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < neighborCnt; j++) {
				int neighborIdx = Integer.parseInt(st.nextToken());

				map[i][neighborIdx] = 1;
			}
		}
	}
}
