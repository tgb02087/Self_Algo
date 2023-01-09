# 📘 2887 (행성터널)

## 소요시간, 메모리

1068ms, 79948KB

## 풀이 방법

- 크루스칼 알고리즘을 활용
- 3차원 좌표(x,y,z)를 자신을 제외한 다른 모든 행성과 길이를 비교해보아야함.
  - 이중 for문으로 모든 행성과의 거리를 비교 해봐도 되지만 최대 N 값이 100,000이므로 시간초과 발생할것 같았음
  - x,y,z를 각각 정렬하여 따로 계산하여 간선으로 만듬
  - 예를 들어 0, 8, 4, 7, -1 이면 -1,0,4,7,8로 정렬 후(-1,0)(0,4)(4,7)(7,8)을 Edge로 추가

## Code

```Java
import java.util.*;
import java.io.*;
public class Main {
    static class Planet {
        int idx, cost;
        public Planet(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static class Edge {
        int a,b,cost;
        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
    static final int INF = Integer.MAX_VALUE;
    static PriorityQueue<Edge> que;
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Planet> que_x = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost,o2.cost));
        PriorityQueue<Planet> que_y = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost,o2.cost));
        PriorityQueue<Planet> que_z = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost,o2.cost));
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            que_x.offer(new Planet(i,x));
            que_y.offer(new Planet(i,y));
            que_z.offer(new Planet(i,z));
        }
        Planet cur_x = que_x.poll();
        Planet cur_y = que_y.poll();
        Planet cur_z = que_z.poll();
        que = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.cost,o2.cost));
        for(int i=1; i<N; i++) {
            cur_x = make(cur_x,que_x);
            cur_y = make(cur_y,que_y);
            cur_z = make(cur_z,que_z);
        }
        parents = new int[N];
        for(int i=0; i<N; i++) parents[i] = i;
        int res = 0;
        int cnt = 0;
        while(!que.isEmpty()) {
            Edge cur = que.poll();
            if(union(cur.a,cur.b)) {
                res += cur.cost;
                if(++cnt == N-1) break;
            }
        }
        System.out.println(res);
        br.close();
    }
    static Planet make(Planet cur, PriorityQueue<Planet> pq) {
        Planet next = pq.poll();
        que.offer(new Edge(cur.idx, next.idx, Math.abs(cur.cost-next.cost)));
        return next;
    }
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return false;
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
        return true;
    }
    static int find(int n) {
        if(parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }
}
```
