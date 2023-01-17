# 📘 2503 (숫자 야구)

## 소요시간, 메모리

88ms, 11836KB

## 풀이 방법

- 브루트포스로 모든 경우를 탐색해봄.
    - 조건에 맞게 1~9중 중복되지않는 숫자 이므로 123~987까지 탐색

## Code

```Java
import java.util.*;
import java.io.*;
public class Main {
    static class Baseball {
        int num, stk, ball;
        public Baseball(int num, int stk, int ball) {
            this.num = num;
            this.stk = stk;
            this.ball = ball;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new ArrayDeque<>();
        Baseball[] baseballs = new Baseball[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            baseballs[i] = new Baseball(n,s,b);
        }
        i:for(int i=123; i<=987; i++) {
            char[] str1 = String.valueOf(i).toCharArray();
            if(check(str1)) {
                for(int j=0; j<N; j++) {
                    char[] str2 = String.valueOf(baseballs[j].num).toCharArray();
                    if(!game(str1,str2,baseballs[j].stk,baseballs[j].ball)) continue i;
                }
                que.offer(Integer.parseInt(String.copyValueOf(str1)));
            }
        }
        System.out.println(que.size());
        br.close();
    }
    static boolean check(char[] c) {
        if(c[0] == c[1]) return false;
        else if(c[0] == c[2]) return false;
        else if(c[1] == c[2]) return false;
        else if(c[0] == '0' || c[1] == '0' || c[2] == '0') return false;
        else return true;
    }
    static boolean game(char[] c1, char[] c2, int s, int b) {
        for(int k=0; k<3; k++) {
            for(int v=0; v<3; v++) {
                if(c1[k]==c2[v]) {
                    if(k==v) s--;
                    else b--;
                }
            }
            if(s<0 || b<0) return false;
        }
        if(s!=0 || b!=0) return false;
        return true;
    }
}
```
