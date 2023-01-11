# 📘 14938 (서강그라운드)

## 소요시간, 메모리

232ms, 18176KB

## 풀이 방법

- 다익스트라 알고리즘을 활용
- 갈수있는 곳이 최단 거리일때가 아니라 문제에서 주어진 수색범위 안으로 갈 수 있는 경우에 cost를 더함.
  - visit 배열 활용

## Code

```Java
import java.util.*;
import java.io.*;
public class Main {
    static class Node {
        int idx,cost;
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static int N,M;
    static int[] cost;
    static List<List<Node>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        cost = new int[N+1];
        for(int i=1; i<=N; i++) cost[i] = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0; i<=N; i++) list.add(new ArrayList<>());
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,c));
            list.get(b).add(new Node(a,c));
        }
        int max = 0;
        for(int i=1; i<=N; i++) {
            max = Math.max(max, dijstra(i));
        }
        System.out.println(max);
        br.close();
    }
    static int dijstra(int st) {
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Node> que = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));
        que.offer(new Node(st,0));
        int sum = 0;
        while(!que.isEmpty()) {
            Node curNode = que.poll();
            if(visited[curNode.idx]) continue;
            visited[curNode.idx] = true;
            sum += cost[curNode.idx];
            for(int i=0; i<list.get(curNode.idx).size(); i++) {
                Node nextNode = list.get(curNode.idx).get(i);
                if(M>= curNode.cost + nextNode.cost) {
                    que.offer(new Node(nextNode.idx,curNode.cost + nextNode.cost));
                }
            }
        }
        return sum;
    }
}
```
