# 📘 10610 (30)

## 소요시간, 메모리

116ms, 15036KB

## 풀이 방법

- 30의 배수가 되려면 맨 끝자리는 0이어야 하므로 먼저 정렬하여 0인지 아닌지 판별
- 끝자리가 0이라면 나머지 자리는 3의 배수이면 된다.

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] C = br.readLine().toCharArray();
        Arrays.sort(C);
        if(C[0]!='0') System.out.println(-1);
        else {
            int cSize = C.length;
            int res = 0;
            for(int i=0; i<cSize; i++) res += C[i];
            res -= ('0'*cSize);
            if(res%3==0) System.out.println(new StringBuilder(new String(C)).reverse());
            else System.out.println(-1);
        }
        br.close();
    }
}
```
