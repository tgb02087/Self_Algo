# 📘 10814 (나이순 정렬)

## 소요시간, 메모리

680ms, 50088KB

## 풀이 방법

- 입력에 해당하는 커스텀 클래스를 만들고 정렬하여 품

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    static class Person {
        int age;
        String name;
        public Person(int a, String n) {
            age = a;
            name = n;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[] person = new Person[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            person[i] = new Person(Integer.parseInt(st.nextToken()),st.nextToken());
        }
        Arrays.sort(person, (o1,o2)-> Integer.compare(o1.age,o2.age));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(person[i].age).append(" ").append(person[i].name).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}
```
