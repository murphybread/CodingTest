import math
from collections import deque

def solution(progresses, speeds):
    answer = []
    
    # 1단계: 각 기능의 완료 시간 계산 (이 부분은 완벽!)
    times = deque()
    for i in range(len(progresses)):
        days_needed = math.ceil((100 - progresses[i]) / speeds[i])
        times.append(days_needed)
    
    # 2단계: 배포 그룹별로 처리
    while times:
        current_time = times.popleft()  # 현재 배포할 기능의 시간
        count = 1  # 현재 기능 포함해서 1개부터 시작
        
        # 현재 시간에 함께 배포 가능한 기능들 찾기
        while times and times[0] <= current_time:
            times.popleft()
            count += 1
        
        answer.append(count)
    
    return answer