# 📘 2023 (신기한 소수)

## 소요시간, 메모리

80ms, 11860KB

## 풀이 방법

- 숫자들은 무조건 한자릿 수 소수인 2,3,5,7로 시작하므로 sosu라는 배열을 사용
  - 소수들의 규칙을 보면 1,3,7,9로 이루어져있으므로 dis 라는 배열을 사용
  - sosu배열에 dis를 붙이면서 isSosu메서드로 소수인지 판별함

## Code

```Java
import java.io.*;
public class Main {
    static int N;
    static StringBuilder sb;
    static  String[] dis = new String[]{"1","3","7","9"};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        String[] sosu = new String[]{"2","3","5","7"};
        for(int i=0; i<4; i++) start(sosu[i],1);
        System.out.println(sb);
        br.close();
    }
    static void start(String s, int cnt) {
        if(cnt == N) sb.append(s).append('\n');
        for(int i=0; i<4; i++) {
            if(isSosu(Integer.parseInt(s+dis[i]))) start(s+dis[i],cnt+1);
        }
    }
    static boolean isSosu(int n) {
        int sq = (int)Math.sqrt(n);
        for(int i=2; i<=sq; i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
}
```
