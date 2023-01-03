# 📘 1043 (거짓말)

## 소요시간, 메모리

80ms, 11584KB

## 풀이 방법

- 입력값을 서로 union하는 과정에서 처음 값을 그냥 1로 초기화 한상태로 진행하여 틀림.
  - 의도치 않은 부분에서 1과 union 발생.
- union 할때마다 모든 parents의 루트 값을 갱신시켜주는 for문을 넣음. (추후에 수정해봐야겠다)
- 진실을 아는 경우의 idx 값의 parents배열의 루트 값도 진실을 아는 경우로 갱신 시켜줌.

## Code

```Java
import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i=0; i<=N; i++) parents[i] = i;
        boolean[] fact = new boolean[N+1];
        int cur = 0;
        if(n!=0) {
            cur = Integer.parseInt(st.nextToken());
            fact[cur] = true;
            for(int i=1; i<n; i++) {
                int num = Integer.parseInt(st.nextToken());
                fact[num]=true;
                union(cur,num);
                cur = num;
            }
        }
        int[] chk = new int[M];
        int idx = 0;
        int cnt = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int k = Integer.parseInt(st.nextToken());
            cur = Integer.parseInt(st.nextToken());
            for(int j=1; j<k; j++) {
                int num = Integer.parseInt(st.nextToken());
                union(cur,num);
                cur = num;
            }
            chk[idx++] = cur;
        }
        for(int i=1; i<=N; i++) {
            if(fact[i]) {
                fact[parents[i]] = true;
            }
        }
        for(int i=0; i<M; i++) {
            if(!fact[find(chk[i])]) cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return false;
        if(rootA<=rootB) {
            parents[b] = rootA;
            for(int i=1; i<=N; i++) {
                if(parents[i] == rootB) parents[i] = rootA;
            }
        }
        else {
            parents[a] = rootB;
            for(int i=1; i<=N; i++) {
                if(parents[i] == rootA) parents[i] = rootB;
            }
        }
        return true;
    }
    static int find(int n) {
        if(parents[n] == n) return n;
        return find(parents[n]);
    }
}
```
