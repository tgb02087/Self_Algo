# 📘 17219 (김강호)

## 소요시간, 메모리

516ms, 63984KB

## 풀이 방법

- HashMap을 활용

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String,String> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            String site = st.nextToken();
            String pw = st.nextToken();
            map.put(site,pw);
        }
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<M; j++) {
            String site = br.readLine();
            String pw = map.get(site);
            sb.append(pw).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
```
