# 📘 1918 (후위 표기식)

## 소요시간, 메모리

80ms, 11464KB

## 풀이 방법

- 피연산자들은 바로 출력하기 위해 StringBuilder에 넣어준다.
- 연산자들은 rank()를 통해 우선순위를 반환시켜준다.
  - \*,/가 우선순위 2, +,-가 우선순위 1, (,)가 우선순위 0 이다.
- 스택을 활용
  - ( 는 바로 스택에 넣어준다.
  - ) 는 ( 가 나올때까지 스택을 pop해준다.
  - 연산자들은 자기보다 우선순위가 높은 연산자가 스택에 있는경우 없을때까지 pop해준다.

## Code

```Java
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] C = br.readLine().toCharArray();
        for(int i=0; i<C.length; i++) {
            if('A'<= C[i] && C[i] <= 'Z') sb.append(C[i]);
            else {
                if(C[i] == '(') stack.push(C[i]);
                else if(C[i] == ')') {
                    while(!stack.isEmpty() && stack.peek()!='(') sb.append(stack.pop());
                    if(stack.peek()=='(') stack.pop();
                }
                else {
                    while(!stack.isEmpty() && rank(stack.peek()) >= rank(C[i])) {
                        sb.append(stack.pop());
                    }
                    stack.push(C[i]);
                }
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);
        br.close();
    }
    static int rank(char c) {
        if(c == '*' || c == '/') return 2;
        else if(c == '+' || c == '-') return 1;
        else return 0;
    }
}
```
