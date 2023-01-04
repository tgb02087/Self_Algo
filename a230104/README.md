# 📘 1504 (특정한 최단 경로)

## 소요시간, 메모리

764ms, 71956KB

## 풀이 방법

- 다익스트라 알고리즘을 응용한 문제.
- 문제에서 주어진 정점 v1,v2 두개를 꼭 거쳐서 N까지의 최소값을 구하기 위해 두가지 방법 존재
  - 1. 1 -> v1 -> v2 -> N
  - 2. 1 -> v2 -> v1 -> N
- 각각의 구간을 다익스트라 알고리즘으로 나눠 최단 경로를 구한뒤 더한다.
  - 예를 들어 (1,v1) + (v1,v2) + (v2,N) 3가지의 다익스트라 최단경로 구하여 더한값 1경우와 2경우 중 작은 값 출력
  - INF 를 넘어가는 경우를 고려
  - INF는 최대 간선의 개수(200000) \* 최대 거리값(1000) = 200000000이다.

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    static final int INF = 200000000;
    static ArrayList<ArrayList<Node>> list;
    static int N;
    static class Node {
        int idx, cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(s).add(new Node(e,c));
            list.get(e).add(new Node(s,c));
        }
        st = new StringTokenizer(br.readLine()," ");
        int V1 = Integer.parseInt(st.nextToken());
        int V2 = Integer.parseInt(st.nextToken());
        int n1 = dijstra(1,V1) + dijstra(V1,V2) + dijstra(V2,N);
        int n2 = dijstra(1,V2) + dijstra(V2,V1) + dijstra(V1,N);
        if(INF<=n1 && INF<=n2) System.out.println(-1);
        else if(n1<n2) System.out.println(n1);
        else System.out.println(n2);
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
            if(dist[curNode.idx]< curNode.cost) {
                continue;
            }
            for(int i=0; i<list.get(curNode.idx).size(); i++) {
                Node ntNode = list.get(curNode.idx).get(i);
                if(dist[ntNode.idx] > curNode.cost + ntNode.cost) {
                    dist[ntNode.idx] = curNode.cost + ntNode.cost;
                    que.offer(new Node(ntNode.idx,dist[ntNode.idx]));
                }
            }
        }
        return dist[end];
    }
}
```
