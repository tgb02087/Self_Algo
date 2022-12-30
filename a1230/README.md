# 📘 9012 (괄호)

## 소요시간, 메모리

84ms, 11684KB

## 풀이 방법

- 스택을 활용하여 push할때마다 가장 위의 값을 확인하여 (,) 이 완성되면 바로 지워줌
- 마지막에 스택이 다 비어있으면 YES 출력

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<N; i++) {
            char[] C = br.readLine().toCharArray();
            stack.push(C[0]);
            for(int j=1; j<C.length; j++) {
                char c = C[j];
                if(!stack.isEmpty() && stack.peek()=='(') {
                    if(c == ')') stack.pop();
                    else stack.push(c);
                }
                else stack.push(c);
            }
            if(stack.isEmpty()) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
            stack.clear();
        }
        System.out.println(sb);
        br.close();
    }
}
```
