# 📘 1620 (김강호)

## 소요시간, 메모리

488ms, 61916KB

## 풀이 방법

- HashMap을 두개 활용하여 품
- 하나는 이름을 키로, 하나는 번호를 키로 추가

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> map = new HashMap<>();
        Map<Integer,String> map2 = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int idx = 1;
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            map.put(s,idx);
            map2.put(idx++,s);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            String s = br.readLine();
            if(map.get(s)==null) sb.append(map2.get(Integer.parseInt(s))).append('\n');
            else sb.append(map.get(s)).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}
```
