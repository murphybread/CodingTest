def solution(clothes):
    answer = 0
    collect = {}
    
    for cloth in clothes:
        # print(cloth)
        category =  cloth[1]
        name = cloth[0]
        collect.get(category,0)
        
        if (collect.get(category,0) == 0):
            collect[category]   =1
        else:
            collect[category] +=1
        

        # print(collect)
    
    result = 1
    for c in collect.values():
        result *= (c+1)
        
    result -=1
    return result