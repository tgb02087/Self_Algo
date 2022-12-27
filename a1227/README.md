# 📘 1780 (종이의 개수)

## 소요시간, 메모리

1028ms, 338712KB

## 풀이 방법

- 이차원 배열인 색종이를 탐색하여 다른수가 있다면 9등분으로 나눠서 재귀호출
- 끝까지 탐색하여 모두 같은수이면 해당 수 cnt 증가

- 시간이 많이 나와 다음에 다시 풀어봐야겠다.

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    static int cnt_1 = 0, cnt_2 = 0, cnt_3 = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cut(map);
        StringBuilder sb = new StringBuilder();
        sb.append(cnt_1).append('\n').append(cnt_2).append('\n').append(cnt_3).append('\n');
        System.out.println(sb);
        br.close();
    }
    static void cut(int[][] map) {
        int size = map.length;
        int num = map[0][0];
        if(size != 1) {
            for(int i=0; i<size; i++) {
                for(int j=0; j<size; j++) {
                    if(num != map[i][j]) {
                        int n = size/3;
                        int x = 0;
                        int y = 0;
                        int[][] m = new int[n][n];
                        for(int k=0; k<3; k++) {
                            for(int l=0; l<3; l++) {
                                for(int c=0; c<n; c++) {
                                    m[c] = Arrays.copyOfRange(map[x+c],y,y+n);
                                }
                                cut(m);
                                y+=n;
                                y%=size;
                            }
                            x+=n;
                        }
                        return;
                    }
                }
            }
        }
        if(num==-1) cnt_1++;
        else if(num==0) cnt_2++;
        else cnt_3++;
    }
}
```
