# 📘 2164 (카드2)

## 소요시간, 메모리

124ms, 23676KB

## 풀이 방법

- 큐에 1부터 N까지의 수를 모두 넣고 하나씩 빼며 큐의 크기가 1이면 반복문을 종료해주었다.
  - N이 1일때를 고려하여 반복문의 조건은 큐의 사이즈가 1이 아닐때 반복하도록 하였다.

## Code

```Java
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> que = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++) que.offer(i);
        while(que.size()!=1) {
            que.poll();
            if(que.size()==1) break;
            que.offer(que.poll());
        }
        System.out.println(que.peek());
        br.close();
    }
}
```
