# [Silver I] 공 색칠하기 - 13021 

[문제 링크](https://www.acmicpc.net/problem/13021) 

### 성능 요약

메모리: 11652 KB, 시간: 64 ms

### 분류

수학, 애드 혹, 조합론

### 제출 일자

2025년 7월 31일 14:47:32

### 문제 설명

<p>공 N개가 한 줄로 놓여져 있다. 공은 검정색 또는 흰색으로 칠할 수 있으며, 처음에 모든 공의 색은 흰색이다. 공은 가장 왼쪽이 1번이고, 순서대로 번호가 매겨져 있다.</p>

<p>오늘은 공을 칠해보려고 한다. 공은 기계를 이용해서 칠할 수 있는데, 기계는 두 정수 L과 R을 입력으로 받는다. 기계는 L번째 공부터 R번째 공까지를 흰색이나 검정색으로 모두 칠한다.</p>

<p>기계를 총 M번 사용했고, 이때 입력한 L과 R을 모두 알고있다. 하지만, 어떤 색으로 칠했는지는 까먹고 말았다. </p>

<p>기계를 모두 M번 사용했을 때, 나올 수 있는 색 조합의 경우의 수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 공의 개수 N과 기계를 사용한 횟수 M이 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ M ≤ 50)</p>

<p>둘째 줄부터 M개의 줄에는 기계를 사용할 때 입력한 L과 R이 기계를 사용한 순서대로 주어진다. (1 ≤ L ≤ R ≤ N)</p>

### 출력 

 <p>첫째 줄에 나올 수 있는 색 조합의 수를 출력한다. 정답은 2<sup>63</sup>-1보다 작거나 같다.</p>

