# 📘 6497 (전력난)

## 소요시간, 메모리

1308ms, 260672KB

## 풀이 방법

- 입력의 끝에 0 0 이 주어지는 조건을 제외하고는 다른 조건은 없어 최소 스패닝 트리 알고리즘을 활용하여 품.
  - 그 중 크루스칼 알고리즘을 활용. (프림 알고리즘으로도 풀어보기)

## Code

```Java
import java.util.*;
import java.io.*;
public class Main {
    static class Edge{
        int a, b, cost;
        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if(M==0 && N==0) break;
            PriorityQueue<Edge> que = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost,o2.cost));
            int sum = 0;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sum += c;
                que.offer(new Edge(a,b,c));
            }
            parents = new int[M];
            for(int i=0; i<M; i++) parents[i] = i;
            int res = 0;
            int cnt = 0;
            while(!que.isEmpty()) {
                Edge curEdge = que.poll();
                if(union(curEdge.a,curEdge.b)) {
                    res += curEdge.cost;
                    if(++cnt == M-1) break;
                }
            }
            sb.append(sum-res).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return false;
        parents[rootB] = rootA;
        return true;
    }
    static int find(int n) {
        if(parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }
}
```
