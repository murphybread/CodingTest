def solution(players, m, k):
    answer = 0
    servers = []
    for time in range(len(players)):
        people = players[time]
        # 운용중인 서버가 있다면

        if (len(servers)>0):
            for i in range(len(servers)-1, -1, -1):
                servers[i] -= 1
                if (servers[i] <=0):
                    servers.pop(i)
                    
                
        if (people < (len(servers)+1)*m):
            continue
        else:
            count = (people - (len(servers) *m)) // m
            answer += count
            for _ in range(count):
                servers.append(k)

        
    # 인원 수 파악
    # 현재 운용 중인 서버 마감시한 업데이트 후 제거 [k]
    # 현재 운영중인 서버로 가능한지?
        # 불가능 하다면 증설하는데, 증설된 서버의 수는 필요한만큼 ,증설 횟수 += 증설된 서버의 수
    # k시간동안 유지
    return answer