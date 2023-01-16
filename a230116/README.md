# 📘 15654 (N과 M(5))

## 소요시간, 메모리

308ms, 33744KB

## 풀이 방법

- 정렬하고 백트래킹하여 품.

## Code

```Java
import java.util.Arrays;
import java.util.Scanner;

class Main {
    static int[] nums;
    static int[] arr;
    static boolean[] isVisited;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        arr = new int[N];
        isVisited = new boolean[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        dfs(0);
        System.out.println(sb.toString());
    }

    private static void dfs(int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                arr[count] = nums[i];
                dfs(count + 1);
                isVisited[i] = false;
            }
        }
    }
}
```
