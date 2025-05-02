# 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
# 아래 표준 입출력 예제 필요시 참고하세요.

# 표준 입력 예제
'''
a = int(input())                        정수형 변수 1개 입력 받는 예제
b, c = map(int, input().split())        정수형 변수 2개 입력 받는 예제 
d = float(input())                      실수형 변수 1개 입력 받는 예제
e, f, g = map(float, input().split())   실수형 변수 3개 입력 받는 예제
h = input()                             문자열 변수 1개 입력 받는 예제
'''

# 표준 출력 예제
'''
a, b = 6, 3
c, d, e = 1.0, 2.5, 3.4
f = "ABC"
print(a)                                정수형 변수 1개 출력하는 예제
print(b, end = " ")                     줄바꿈 하지 않고 정수형 변수와 공백을 출력하는 예제
print(c, d, e)                          실수형 변수 3개 출력하는 예제
print(f)                                문자열 1개 출력하는 예제
'''




'''
아래의 구문은 input.txt 를 read only 형식으로 연 후,
앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
아래 구문을 이용하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 구문을 사용하셔도 좋습니다.
아래 구문을 사용하기 위해서는 import sys가 필요합니다.
단, 채점을 위해 코드를 제출하실 때에는 반드시 아래 구문을 지우거나 주석 처리 하셔야 합니다.
'''
# import sys
# sys.stdin = open("input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N,K  = map(int, input().split())
    board = []
    for _ in range(N):
        line = list(map(int, input().split()))
        board.append(line)
    
    
    
    answer =set()
    arrow = [[-1,0], [1,0], [0,-1], [0,1]]
    
    def backtracking(x, y, depth, count, Case, visited):
        global answer
        
        visited[x][y] = 1
        

        
        # if (len(answer) > 0 and depth > max(answer)-1):
        #     for row in Case:
        #         print(*row)
        #     print(f'x {x},y {y},depth{depth},count{count}')
        for dx,dy in arrow:
            
            nx = x + dx
            ny = y + dy
            
            
            # 방문 체크

            # 범위 체크
            if ( (nx < 0 or nx >=N ) or (ny < 0 or ny >= N) ):
                answer.add(depth)

                continue
            # 땅을 파도 안되는 경우
            if (Case[nx][ny] > Case[x][y] + count):
                answer.add(depth)

                continue
            if (visited[nx][ny] == 1):
                answer.add(depth)
                continue
            # 땅 안파다고 내려갈 수 있는 경우
            elif (Case[x][y] > Case[nx][ny]):
                # for line in visited:
                #     print(*line)
                # print("---------")
                backtracking(nx,ny, depth+1, count, Case,visited)
            # 땅을 파면 되는 경우, 땅판 후 backtraacking
            elif (Case[x][y] + count > Case[nx][ny] ):
                if (count != K):
                    continue
                # for line in visited:
                #     print(*line)
                # print("---------")
                diff = (Case[nx][ny]-  Case[x][y]  + 1)
                Case[nx][ny] -= diff
                backtracking(nx,ny, depth+1, count - diff, Case, visited)
                Case[nx][ny] += diff
            
        visited[x][y] = 0

    # 최고점 찾기
    
    high =0
    for i in range(N):
        high = max(high, max(board[i]))
    
    start = []
    for i in range(N):
        for j in range(N):
            if (board[i][j] == high):
                start.append((i,j))
                
                

        
    for i,j in start:

        case = [row[:] for row in board]
        visits = [[0]*N for _ in range(N)]
        backtracking(i,j, 0,K,case,visits)
        # print(f'answer {answer}')  
    print(f'#{test_case} {max(answer)+1}')
    
        
    # ///////////////////////////////////////////////////////////////////////////////////
    '''
    백트래킹 dfs
    1. 가장 높은 수 구하기(시작점)
    2. 시작점마다 새로운 배열 생성 bfs 수행
    3. k를통해 높이 난추기. 만약 가능한경우 진행을 위해.
    	4. 백트래킹 종료에서 높이 낮춘거 반환하기

        이 부분에 여러분의 알고리즘 구현이 들어갑니다.

    '''
    # ///////////////////////////////////////////////////////////////////////////////////
