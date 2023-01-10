# 📘 5373 (큐빙)

## 소요시간, 메모리

176ms, 21284KB

## 풀이 방법

- 큐브의 단면도 각각의 6면을 2차원 배열로 만들어 생각함.
- 각 면끼리 맞닿는 인덱스를 생각하며 Front를 바라보는 기준으로 맞닿는 면의 인덱스를 temp를 활용하여 바꿔줌.
- 시계방향과 반시계방향으로 혼자 회전하는 경우는 메서드로 만들어 활용함.

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    static char[][] U = new char[3][3];
    static char[][] D = new char[3][3];
    static char[][] L = new char[3][3];
    static char[][] R = new char[3][3];
    static char[][] F = new char[3][3];
    static char[][] B = new char[3][3];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    U[i][j] = 'w';
                    D[i][j] = 'y';
                    F[i][j] = 'r';
                    B[i][j] = 'o';
                    L[i][j] = 'g';
                    R[i][j] = 'b';
                }
            }
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                char[] c = st.nextToken().toCharArray();
                if(c[0]=='U') up(c[1]);
                else if(c[0]=='D') down(c[1]);
                else if(c[0]=='L') left(c[1]);
                else if(c[0]=='R') right(c[1]);
                else if(c[0]=='F') front(c[1]);
                else back(c[1]);
            }
            for(int x=0; x<3; x++) {
                for(int y=0; y<3; y++) {
                    sb.append(U[x][y]);
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
        br.close();
    }
    static void up(char c) {
        if(c=='+') {
            char[] temp = Arrays.copyOf(L[0],3);
            L[0] = Arrays.copyOf(F[0],3);
            F[0] = Arrays.copyOf(R[0],3);
            R[0] = Arrays.copyOf(B[0],3);
            B[0] = Arrays.copyOf(temp,3);
            clock_turn(U);
        }
        else {
            char[] temp = Arrays.copyOf(L[0],3);
            L[0] = Arrays.copyOf(B[0],3);
            B[0] = Arrays.copyOf(R[0],3);
            R[0] = Arrays.copyOf(F[0],3);
            F[0] = Arrays.copyOf(temp,3);
            clock_return(U);
        }
    }
    static void down(char c) {
        if(c=='+') {
            char[] temp = Arrays.copyOf(L[2],3);
            L[2] = Arrays.copyOf(B[2],3);
            B[2] = Arrays.copyOf(R[2],3);
            R[2] = Arrays.copyOf(F[2],3);
            F[2] = Arrays.copyOf(temp,3);
            clock_turn(D);
        }
        else {
            char[] temp = Arrays.copyOf(L[2],3);
            L[2] = Arrays.copyOf(F[2],3);
            F[2] = Arrays.copyOf(R[2],3);
            R[2] = Arrays.copyOf(B[2],3);
            B[2] = Arrays.copyOf(temp,3);
            clock_return(D);
        }
    }
    static void left(char c) {
        if(c=='+') {
            char temp1 = U[0][0];
            char temp2 = U[1][0];
            char temp3 = U[2][0];
            U[2][0] = B[0][2]; U[1][0] = B[1][2]; U[0][0] = B[2][2];
            B[0][2] = D[2][0]; B[1][2] = D[1][0]; B[2][2] = D[0][0];
            D[2][0] = F[2][0]; D[1][0] = F[1][0]; D[0][0] = F[0][0];
            F[2][0] = temp3; F[1][0] = temp2; F[0][0] = temp1;
            clock_turn(L);
        }
        else {
            char temp1 = U[0][0];
            char temp2 = U[1][0];
            char temp3 = U[2][0];
            U[2][0] = F[2][0]; U[1][0] = F[1][0]; U[0][0] = F[0][0];
            F[2][0] = D[2][0]; F[1][0] = D[1][0]; F[0][0] = D[0][0];
            D[2][0] = B[0][2]; D[1][0] = B[1][2]; D[0][0] = B[2][2];
            B[0][2] = temp3; B[1][2] = temp2; B[2][2] = temp1;
            clock_return(L);
        }
    }
    static void right(char c) {
        if(c=='+') {
            char temp1 = U[2][2];
            char temp2 = U[1][2];
            char temp3 = U[0][2];
            U[2][2] = F[2][2]; U[1][2] = F[1][2]; U[0][2] = F[0][2];
            F[0][2] = D[0][2]; F[1][2] = D[1][2]; F[2][2] = D[2][2];
            D[2][2] = B[0][0]; D[1][2] = B[1][0]; D[0][2] = B[2][0];
            B[2][0] = temp3; B[1][0] = temp2; B[0][0] = temp1;
            clock_turn(R);
        }
        else {
            char temp1 = U[2][2];
            char temp2 = U[1][2];
            char temp3 = U[0][2];
            U[2][2] = B[0][0]; U[1][2] = B[1][0]; U[0][2] = B[2][0];
            B[2][0] = D[0][2]; B[1][0] = D[1][2]; B[0][0] = D[2][2];
            D[2][2] = F[2][2]; D[1][2] = F[1][2]; D[0][2] = F[0][2];
            F[0][2] = temp3; F[1][2] = temp2; F[2][2] = temp1;
            clock_return(R);
        }
    }
    static void front(char c) {
        if(c=='+') {
            char temp1 = U[2][0];
            char temp2 = U[2][1];
            char temp3 = U[2][2];
            U[2][0] = L[2][2]; U[2][1] = L[1][2]; U[2][2] = L[0][2];
            L[0][2] = D[0][0]; L[1][2] = D[0][1]; L[2][2] = D[0][2];
            D[0][0] = R[2][0]; D[0][1] = R[1][0]; D[0][2] = R[0][0];
            R[2][0] = temp3; R[1][0] = temp2; R[0][0] = temp1;
            clock_turn(F);
        }
        else {
            char temp1 = U[2][0];
            char temp2 = U[2][1];
            char temp3 = U[2][2];
            U[2][0] = R[0][0]; U[2][1] = R[1][0]; U[2][2] = R[2][0];
            R[0][0] = D[0][2]; R[1][0] = D[0][1]; R[2][0] = D[0][0];
            D[0][2] = L[2][2]; D[0][1] = L[1][2]; D[0][0] = L[0][2];
            L[2][2] = temp1; L[1][2] = temp2; L[0][2] = temp3;
            clock_return(F);
        }
    }
    static void back(char c) {
        if(c=='+') {
            char temp1 = U[0][2];
            char temp2 = U[0][1];
            char temp3 = U[0][0];
            U[0][0] = R[0][2]; U[0][1] = R[1][2]; U[0][2] = R[2][2];
            R[0][2] = D[2][2]; R[1][2] = D[2][1]; R[2][2] = D[2][0];
            D[2][2] = L[2][0]; D[2][1] = L[1][0]; D[2][0] = L[0][0];
            L[2][0] = temp3; L[1][0] = temp2; L[0][0] = temp1;
            clock_turn(B);
        }
        else {
            char temp1 = U[0][2];
            char temp2 = U[0][1];
            char temp3 = U[0][0];
            U[0][2] = L[0][0]; U[0][1] = L[1][0]; U[0][0] = L[2][0];
            L[0][0] = D[2][0]; L[1][0] = D[2][1]; L[2][0] = D[2][2];
            D[2][0] = R[2][2]; D[2][1] = R[1][2]; D[2][2] = R[0][2];
            R[2][2] = temp1; R[1][2] = temp2; R[0][2] = temp3;
            clock_return(B);
        }

    }
    static void clock_turn(char[][] c) {
        char temp1 = c[0][0];
        char temp2 = c[0][1];
        char temp3 = c[0][2];
        c[0][2] = c[0][0]; c[0][1] = c[1][0]; c[0][0] = c[2][0];
        c[0][0] = c[2][0]; c[1][0] = c[2][1]; c[2][0] = c[2][2];
        c[2][0] = c[2][2]; c[2][1] = c[1][2]; c[2][2] = c[0][2];
        c[2][2] = temp3; c[1][2] = temp2; c[0][2] = temp1;
    }
    static void clock_return(char[][] c) {
        char temp1 = c[0][0];
        char temp2 = c[0][1];
        char temp3 = c[0][2];
        c[0][0] = c[0][2]; c[0][1] = c[1][2]; c[0][2] = c[2][2];
        c[0][2] = c[2][2]; c[1][2] = c[2][1]; c[2][2] = c[2][0];
        c[2][2] = c[2][0]; c[2][1] = c[1][0]; c[2][0] = c[0][0];
        c[2][0] = temp1; c[1][0] = temp2; c[0][0] = temp3;
    }
}
```
