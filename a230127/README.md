# 📘 1427 (소트인사이트)

## 소요시간, 메모리

76ms, 11488KB

## 풀이 방법

- 처음엔 priorityque를 사용하여 풀었다. (224ms정도 소요)
- 더 시간을 단축시키기 위해 memo라는 배열을 활용.
  - 정렬을 하지 않고 memo에 카운팅한 값 그대로 출력하기 때문에 빠르게 풀 수 있었던 것 같다.

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] memo = new int[10];
        String s = br.readLine();
        for(int i=0; i<s.length(); i++) memo[s.charAt(i)-'0']++;
        for(int i=9; 0<=i; i--) for(int j=0; j<memo[i]; j++) System.out.print(i);
        br.close();
    }
}

```
