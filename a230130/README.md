# 📘 19238 (스타트 택시)

## 소요시간, 메모리

296ms, 22768KB

## 풀이 방법

- 최단 경로 계산 후 같은 거리에 있는 승객의 경우 행이 적은순, 행도 같다면 열이 적은순으로 먼저 태운다.

  - 처음에 단순히 bfs 탐색할때 {상 좌 우 하} 순으로 하면 된다고 생각했지만 틀림.
  - 반례 : 좌 좌 좌, 우 우 상
  - PriorityQueue를 사용하여 bfs에서 같은 거리에 있는 경우를 따로 고려해줌.

- 처음엔 map배열에 승객의 출발지와 목적지를 같이 기록함. (예로 승객2의 출발지:2, 목적지:-2)
- 문제의 조건을 보면 모든 출발지는 서로 다르다고 나와있지만, 목적지가 다르다는 조건은 없으므로 같은 목적지가 있는 반례가 있어 틀림.

  - map_end라는 ArrayList 이차원 배열을 하나더 만들어 같은 목적지를 list형태로 저장해주었다.

- 입력받은 M만큼 반복문을 돌며 중간 bfs에 실패하여 -1의 배열이 리턴 되는경우나 연료가 바닥나는경우 반복문 종료후 -1 출력

## Code

```Java
import java.util.*;
import java.io.*;
public class Main {
    static int[] di = {-1,0,0,1};   //상 좌 우 하
    static int[] dj = {0,-1,1,0};
    static int[][] map;
    static List<Integer>[][] map_end;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int O = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        map_end = new ArrayList[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                map_end[i][j] = new ArrayList<>();
            }
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;
        int n = 2;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            map[x1][y1] = n;
            map_end[x2][y2].add(n++);
        }
        int cnt = 0;
        int oil = O;
        boolean chk = false;
        while(cnt++ < M) {
            int[] re = start(x,y);
            if(re[0]==-1) {
                chk = true;
                break;
            }
            oil -= re[2];
            if(oil<0) {
                chk = true;
                break;
            }
            re = end(re[0],re[1],map[re[0]][re[1]]);
            if(re[0]==-1) {
                chk = true;
                break;
            }
            oil -= re[2];
            if(oil<0) {
                chk = true;
                break;
            }
            oil += re[2]*2;
            x = re[0];
            y = re[1];
        }
        if(chk) System.out.println(-1);
        else System.out.println(oil);
        br.close();
    }
    static int[] start(int st_x, int st_y) {
        if(1<map[st_x][st_y]) return new int[]{st_x,st_y,0};
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];
        boolean chk = false;
        int dis = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            if(o1[0]==o2[0]) return o1[1]-o2[1];
            else return o1[0]-o2[0];
        });
        visit[st_x][st_y] = true;
        que.offer(new int[]{st_x,st_y,0});
        while(!que.isEmpty()) {
            int[] xy = que.poll();
            if(dis==xy[2] && chk) {
                int[] pq_xy = pq.poll();
                return new int[]{pq_xy[0],pq_xy[1],dis};
            }
            for(int d=0; d<4; d++) {
                int nx = xy[0] + di[d];
                int ny = xy[1] + dj[d];
                if(nx<0 || N<= nx || ny<0 || N<=ny || visit[nx][ny] || map[nx][ny]==1) continue;
                if(1<map[nx][ny]) {
                    if(!chk) {
                        chk = true;
                        dis = xy[2]+1;
                        pq.offer(new int[]{nx,ny});
                    }
                    else {
                        pq.offer(new int[]{nx,ny});
                    }
                }
                visit[nx][ny] = true;
                que.offer(new int[]{nx,ny,xy[2]+1});
            }
        }
        return new int[]{-1,-1,-1};
    }
    static int[] end(int st_x, int st_y, int num) {
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];
        visit[st_x][st_y] = true;
        que.offer(new int[]{st_x,st_y,0});
        while(!que.isEmpty()) {
            int[] xy = que.poll();
            for(int d=0; d<4; d++) {
                int nx = xy[0] + di[d];
                int ny = xy[1] + dj[d];
                if(nx<0 || N<= nx || ny<0 || N<=ny || visit[nx][ny] || map[nx][ny]==1) continue;
                for(int i=0; i<map_end[nx][ny].size(); i++) {
                    if(map_end[nx][ny].get(i)==num) {
                        map[st_x][st_y] = 0;
                        map_end[nx][ny].remove(i);
                        return new int[]{nx,ny,xy[2]+1};
                    }
                }
                visit[nx][ny] = true;
                que.offer(new int[]{nx,ny,xy[2]+1});
            }
        }
        return new int[]{-1,-1,-1};
    }
}
```
