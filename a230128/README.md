# 📘 11656 (접미사 배열)

## 소요시간, 메모리

108ms, 17652KB

## 풀이 방법

- 입력받은 문자열 크기만큼 반복하면서 앞 한글자를 자르고 PriorityQue에 넣어 출력함.

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<String> pq = new PriorityQueue<>();
        String S = br.readLine();
        int size = S.length();
        for(int i=0; i<size; i++) pq.offer(S.substring(i,size));
        while(!pq.isEmpty()) sb.append(pq.poll()).append('\n');
        System.out.println(sb);
        br.close();
    }
}
```
