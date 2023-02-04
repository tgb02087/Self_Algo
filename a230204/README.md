# 📘 1283 (단축키 지정)

## 소요시간, 메모리

112ms, 13024KB

## 풀이 방법

## Code

```Java
import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		boolean[] alp = new boolean[26];
		sc.nextLine();
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = sc.nextLine();
		}

		for(int i=0;i<arr.length;i++)
		{
			if(arr[i].contains(" ")) { //여러 단어로 이루어진 문자열
				boolean flag = false; //단어의 첫번째 글자가 단축키로 이미 지정되었는지 검사
				String[] s = arr[i].split(" "); //띄어쓰기 기준으로 단어 나눠주고
				for(int j=0;j<s.length;j++)
				{
					if(alp[Character.toUpperCase(s[j].charAt(0)) - 65] == false) { //단어의 첫번째 글자만 검사
						alp[Character.toUpperCase(s[j].charAt(0)) - 65] = true;
						s[j] = "[" + s[j].substring(0,1) + "]" + s[j].substring(1);
						flag = true;
						break;
					}
				}
				arr[i] = String.join(" ", s);

				if(!flag) { //단어의 첫번째 글자가 모두 단축키로 지정되있으면
					for(int j=0;j<arr[i].length();j++)
					{
						if(arr[i].charAt(j) != ' ') {
						if(alp[Character.toUpperCase(arr[i].charAt(j)) - 65] == false) { //왼쪽부터 검사
							alp[Character.toUpperCase(arr[i].charAt(j)) - 65] = true;
							arr[i] = arr[i].substring(0,j) + "[" + arr[i].substring(j,j+1) + "]" + arr[i].substring(j+1);
							break;
						}
						}
					}
				}
			}
			else { //하나의 단어로 이루어진 문자열
				for(int j=0;j<arr[i].length();j++)
				{
					if(alp[Character.toUpperCase(arr[i].charAt(j)) - 65] == false) { //왼쪽부터 검사
						alp[Character.toUpperCase(arr[i].charAt(j)) - 65] = true;
						arr[i] = arr[i].substring(0,j) + "[" + arr[i].substring(j,j+1) + "]" + arr[i].substring(j+1);
						break;
					}
				}
			}
		}
		for(String i : arr)
		{
			System.out.println(i);
		}


	}
}
```
