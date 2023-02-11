# 📘 16943 (숫자 재배치)

## 소요시간, 메모리

192ms, 12436KB

## 풀이 방법

- 0으로 시작하면 안되는 조건을 빠뜨려 틀림.
- 빠른 시간을 위해 자릿수를 그때그때 비교하며 가지치기를 진행하였는데, 자릿수를 비교하는부분에서 오히려 오류가 많이 생겨서 틀림.
- 정석적으로 숫자를 다 만든 후 숫자를 비교하여 품.

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    static int aSize, max = 0, B;
    static int[] arr, A;
    static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S1 = st.nextToken();
        aSize = S1.length();
        arr = new int[aSize];
        A = new int[aSize];
        v = new boolean[aSize];
        for(int i=0; i<aSize; i++) A[i] = S1.charAt(i)-'0';
        B = Integer.parseInt(st.nextToken());
        combi(0,0);
        if(max==0) System.out.println(-1);
        else System.out.println(max);
        br.close();
    }
    static void combi(int st, int cnt) {
        if(cnt == aSize) {
            if(arr[0]==0) return;
            int num = 0;
            for(int ar:arr) {
                num *= 10;
                num += ar;
            }
            if(num<B) max = Math.max(num,max);
            return;
        }
        for(int i=st; i<aSize; i++) {
            if(v[i]) continue;
            v[i] = true;
            arr[cnt] = A[i];
            combi(st,cnt+1);
            v[i] = false;
        }
    }
}

```
