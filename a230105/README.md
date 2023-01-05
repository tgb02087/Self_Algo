# 📘 1238 (파티)

## 소요시간, 메모리

940ms, 92208KB

## 풀이 방법

- 다익스트라 알고리즘을 응용한 문제.
- 단방향의 도로이며 해당 정점으로 갔다가 다시 돌아와야함
  - (학생집, X) + (X, 학생집) 두번의 다익스트라 알고리즘을 더한 값을 비교하여 가장 큰 값을 출력

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    static class Node {
        int idx, cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static ArrayList<ArrayList<Node>> list;
    static int N;
    static final int INF = 1000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0; i<=N; i++) list.add(new ArrayList<>());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(s).add(new Node(e,c));
        }
        int max = 0;
        for(int i=1; i<=N; i++) max = Math.max(max, dijstra(i,X) + dijstra(X,i));
        System.out.println(max);
        br.close();
    }
    static int dijstra(int st, int end) {
        int[] dist = new int[N+1];
        for(int i=1; i<=N; i++) dist[i] = INF;
        PriorityQueue<Node> que = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));
        que.offer(new Node(st,0));
        dist[st] = 0;
        while(!que.isEmpty()) {
            Node curNode = que.poll();
            if(dist[curNode.idx] < curNode.cost) continue;
            for(int i=0; i<list.get(curNode.idx).size(); i++) {
                Node nextNode = list.get(curNode.idx).get(i);
                if(dist[nextNode.idx] > curNode.cost + nextNode.cost) {
                    dist[nextNode.idx] = curNode.cost + nextNode.cost;
                    que.offer(new Node(nextNode.idx,dist[nextNode.idx]));
                }
            }
        }
        return dist[end];
    }
}
```
