# 📘 11650 (좌표 정렬하기)

## 소요시간, 메모리

636ms, 56072KB

## 풀이 방법

- 너무 쉽다 생각하고 문제를 대충 읽고 틀림. (문제를 잘 읽자)
  - Comparable를 사용하여 정렬하려는 값이 같을때 정렬할 조건을 작성.

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    static class XY implements Comparable<XY>{
        int x, y;
        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(XY o) {
            if(this.x==o.x) return this.y-o.y;
            return this.x-o.x;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        XY[] xy = new XY[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            xy[i] = new XY(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(xy);
        for(int i=0; i<N; i++) {
            sb.append(xy[i].x).append(" ").append(xy[i].y).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}
```
