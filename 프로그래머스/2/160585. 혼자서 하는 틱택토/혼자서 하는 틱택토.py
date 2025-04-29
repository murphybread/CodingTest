def solution(board):
    answer = -1
    # O의개수 X의개수 비교 다르다면? return 0
    
    o = 0
    x = 0
    for row in board:
        for check in row:
            if (check == 'O'):
                o +=1
            if (check == 'X'):
                x +=1
    # 가능한경우는 o==x이거나 o == x+1
    if (o != x):
        if (o != x+1):
            return 0
        
    # 완성여부판단
    
    t_board = [list(line) for line in zip(*board)]
    
    answer_O = ['O','O','O']
    answer_X = ['X','X','X']
    
    o_flag = False
    x_flag = False
    
    # cross case
    c1=[]
    rc1=[]
    for i in range(3):
        c1.append(board[i][i])
        rc1.append(board[i][2-i])
    
    if (c1 == answer_O or rc1 == answer_O):
        o_flag = True
    if (c1 == answer_X or rc1 == answer_X):
        x_flag = True
    
    for i in range(3):
        check_row = list(board[i])
        check_col = t_board[i]
        if (check_row == answer_O or check_col == answer_O):
            o_flag = True
        if (check_row == answer_X or check_col == answer_X):
            x_flag = True
            
    
    if (o_flag == True and (o != x+1)): return 0
    if (x_flag == True and (x != o)): return 0
    # 완성여부판단 O완성했는데 X도 완성이면 return 0
    if (o_flag == True and x_flag == True): return 0



    return 1