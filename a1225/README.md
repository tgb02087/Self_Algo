# 📘 11399 (김강호)

## 소요시간, 메모리

88ms, 11976KB

## 풀이 방법

- 대기시간이 적은 경우부터 나열하면 됨.
  - 오름차순 정렬하여 더하여 품

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0; i<N; i++) que.offer(Integer.parseInt(st.nextToken()));
        int cur_sum = 0;
        int sum = 0;
        for(int i=0; i<N; i++) {
            cur_sum += que.poll();
            sum +=cur_sum;
        }
        System.out.println(sum);
        br.close();
    }
}
```
