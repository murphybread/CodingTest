def solution(line):
    # 교점 구하기
    points = []
    for i in range(len(line)):
        for j in range(i+1, len(line)):
            A, B, E = line[i]
            C, D, F = line[j]
            
            if A*D - B*C == 0:  # 평행 또는 일치
                continue
                
            x = (B*F - E*D) / (A*D - B*C)
            y = (E*C - A*F) / (A*D - B*C)
            
            if x.is_integer() and y.is_integer():
                points.append((int(x), int(y)))
    
    # 최소 사각형 구하기
    min_x = min(p[0] for p in points)
    max_x = max(p[0] for p in points)
    min_y = min(p[1] for p in points)
    max_y = max(p[1] for p in points)
    
    # 별 그리기
    width = max_x - min_x + 1
    height = max_y - min_y + 1
    
    grid = [['.'] * width for _ in range(height)]
    
    for x, y in points:
        # 좌표계 변환
        grid[max_y - y][x - min_x] = '*'
    
    # 결과 반환
    return [''.join(row) for row in grid]