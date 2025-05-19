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


T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.



for test_case in range(1, T + 1):

    
    N = int(input())
    original = list(input().split())
    M = int(input())
    orders = list(input().split())
    
    l  = len(orders)
    arr = []
    
    for i in range(l):
        if orders[i].isalpha():
            if orders[i] == 'I':
                x = int(orders[i+1])
                y = int(orders[i+2])
                li = orders[i+3:i+3+y]
                arr.append(['I',x,y,li])
                
            elif orders[i] == 'D':
                x = int(orders[i+1])
                y = int(orders[i+2])
                arr.append(['D',x,y])
                
            else:
                y = int(orders[i+1])
                s = orders[i+2:i+2+y]
                arr.append(['A',y,s])
    # print(arr)
    
    
    cnt = 0
    for o in arr:
        cnt +=1
        # print(cnt, original[:50])
        command = o[0]
        if command == 'I':
            start  = o[1]  
            
            front = original[:start]
            mid = o[3]
            # print("mid", mid)
            back = original[start:]
            original = front + mid + back
            # print("Insers", original[:100])
            
        elif command == 'D':
            
            start = o[1]
            end = o[2]
            # print("start, end",start,end)
            front = original[:start]
            back  = original[start+end:]
            original = front + back
            
            # print("after before", original[start: start+10])
            # print("delete", original[:20])
            
        else:
            # print("before", original[-10:])
            original = original + o[2]
            # print("after",original[-10:])
    

    print(f'#{test_case} ', end='')
    print(*original[:10])
    
    
    # ///////////////////////////////////////////////////////////////////////////////////
    '''

        이 부분에 여러분의 알고리즘 구현이 들어갑니다.

    '''
    # ///////////////////////////////////////////////////////////////////////////////////
