import heapq
def solution(scoville, K):
    answer = 0
    # 이미 K이상인것은 섞을 필요없음
    
    # 섞을때 n개의 K미만의 개수를 n-1번으로 섞는것이 최선
    
    # 가장작은수와 그다음 가장작은 수를 뽑는것이 메인 ->heapq
    
    # 가장 작은 값이 K 이상이 될 때까지 반복
    heapq.heapify(scoville)
    while len(scoville) >= 2 and scoville[0] < K:
        # 가장 작은 두 개 뽑기
        first = heapq.heappop(scoville)   # 가장 작은 수
        second = heapq.heappop(scoville)  # 두 번째로 작은 수
        
        # 새로운 스코빌 지수 계산
        new_scoville = first + (second * 2)
        
        # 다시 힙에 추가
        heapq.heappush(scoville, new_scoville)
        answer += 1
    
    # 모든 음식의 스코빌 지수가 K 이상인지 확인
    
    if ( scoville and scoville[0] >= K):
        return answer
    return  -1
    
    
    
    