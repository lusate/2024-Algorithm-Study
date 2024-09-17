## 🐬 코테 문제 알고리즘 스터디 <br>

<br>

### 🖇️ 인프런을 통해 나는 복습으로 빠르게 매주 2문제 풀기.
<br>

### 🖇️ 프로그래머스 (매주 2문제)
- 🖊️ [프로그래머스 문제 풀이](https://school.programmers.co.kr/learn/challenges?order=recent&statuses=unsolved%2Csolved&levels=1%2C2%2C3%2C4&languages=java&partIds=56388%2C56389%2C58464%2C37527%2C31236%2C25448%2C21366%2C20069%2C17214%2C12286%2C9317%2C22586%2C18498%2C17931%2C300%2C301%2C17615%2C6174%2C18952%2C21163%2C23708%2C6173%2C22941%2C49441%2C49442%2C44139%2C33882)

<br>

### 🖇️ 백준 매주 최소 1문제.
- 🖊️ [정답률이 높은 것들 위주로 풀기](https://github.com/tony9402/baekjoon/tree/main/data_structure)

**자바 2차원 배열 입력 방법1 (띄어쓰기 없이 숫자들이 모두 붙어있을 때)**
```java
for (int i = 0; i < M; i++) {
    String s = br.readLine();
    for (int j = 0; j < N; j++) {
        map[i][j] = s.charAt(j) - '0';
    }
}
```

<br>

**자바 2차원 배열 입력 방법2 (띄어쓰기 없이 문자들이 모두 붙어있을 때)**
```java
map = new char[N][M];
for (int i = 0; i < N; i++) {
    map[i] = br.readLine().toCharArray();
}

for (int i = 0; i < N; i++) {
    String S = br.readLine(); // RRRBB
    for (int j = 0; j < N; j++) {
        map[i][j] = S.charAt(j);
    }
}
```

<br>

**자바 2차원 배열 입력 방법3 (띄어쓰기 있이 숫자들이 모두 떨어져있을 때)**
```java
for (int i = 0; i < N; i++) {
    st = new StringTokenizer(br.readLine());
    for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
    }
}
```

<br>

**자바 1차원 배열 입력 방법1 (띄어쓰기 없이 문자들이 모두 붙어있을 때)**
```java
StringTokenizer st = new StringTokenizer(br.readLine());
arr = st.nextToken().toCharArray();
```

<br>

**자바 1차원 배열 입력 방법2 (띄어쓰기 있이 문자들이 모두 떨어져있을 때)**
```java
st = new StringTokenizer(br.readLine());
for (int i=0; i<C; i++) {
    wList[i] = st.nextToken().charAt(0);
}
```

<br>

**자바 1차원 배열 입력 방법3 (띄어쓰기 있이 숫자들이 모두 떨어져있을 때)**
```java
st = new StringTokenizer(br.readLine());
for (int i = 0; i < n; i++) {
    arr[i] = Integer.parseInt(st.nextToken());
}
```

<br>

### 🖇️몰랐던 함수 적기
- 날짜 비교하는 방법
  - ```java
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dt1 = LocalDateTime.parse(startTime, formatter);
    LocalDateTime dt2 = LocalDateTime.parse(endTime, formatter);
  
    Duration duration = Duration.between(dt1, dt2);
    ```
  - 단, Duration 클래스는 시간 단위가 초와 나노초 밖에 없습니다. 따라서 시간 계산이 필요합니다.
  - Period는 Years, Months, Days가 가능합니다.
  
- PriorityQueue에서 peek는 class에서 오름/내림차순으로 정의한 우선 순위를 나타냄.
- 리스트 내 요소 중복 체크는 Set으로 중복 여부를 확인할 수 있지만 Stream을 통해서도 가능 -> `arr.stream().distinct().count()`

<br>

### 🖇️ Commit Detail에 뭐 때문에 못 풀었고 어떻게 해결했는지 풀이 과정 적기.
