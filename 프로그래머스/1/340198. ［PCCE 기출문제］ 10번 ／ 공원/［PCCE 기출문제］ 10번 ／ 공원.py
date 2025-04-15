def solution(mats, park):
    answer = -1
    
    s = set()
    row = len(park)
    col = len(park[0])
    n = min(row,col)
    
    def getSize(i,j):
        arr = []

        for size in range(1,n+1):

            
            for w in range(i,i+size):
                for h in range(j, j+size):
                    if(park[w][h] != '-1'):
                        return arr
            arr.append(size)
            
            if(i+size >=row or j+size >=col):
                return arr
            
    # ij에 대해 1size체크
    # ij에 대해 2size체크
    for i in range(row):
        for j in range(col):
            s.update(getSize(i,j))
    if(len(s) <1):
        return answer
    s_list =list(s)
    s_list =sorted(s_list, reverse=True)
    for num in s_list:
        if num in mats:
            return num
    return -1
        
