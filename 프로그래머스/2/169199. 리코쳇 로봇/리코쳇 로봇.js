function solution(board) {
    
    // 행,렬 초기위치 , directions 초기화
    const [rows, cols] = [board.length, board[0].length]
    const directions= [[-1,0], [1,0], [0,-1], [0,1],];
    let start = [0,0]
    let goal = [0,0]
    
    for (let i = 0; i< rows; i++){
        for (let j= 0 ; j<cols; j++){
            if (board[i][j] === 'R') start = [i,j]
            if (board[i][j] === 'G') goal = [i,j]
        }
    }

    // 초기 BFS visited초기화, queue초기화
    const visited = Array.from({length: rows} , () => Array(cols).fill(Infinity))
    const queue = []
    queue.push([start[0],start[1], 0])
    visited[start[0]][start[1]] = 0 
    
    
    // queue가 빌때까지
    while (queue.length > 0) {
        let [x,y,cnt] = queue.shift()
        
        // 만약 G만나면 return
        if (x === goal[0] && y === goal[1]) return cnt
        
        // for directions 초기화
        for (let [dx,dy] of directions){
            let nx = x, ny = y
            // sliding moving
            while (true){

                let nextX = nx + dx
                let nextY = ny + dy
                if (nextX < 0 || nextX >=rows || nextY <0 || nextY >=cols ) break
                if (board[nextX][nextY] === 'D') break

                nx = nextX
                ny = nextY
            }
                            
        // if 제자리가 아니고, 기존 visitied 보다 cnt가 작다면
            // visited 업데이트 및 queue추가
            
            if ((nx !==x || ny!==y) && visited[nx][ny] > cnt+1 ){
                
                visited[nx][ny] = cnt+1
                queue.push([nx,ny,cnt+1])
            }   
        }

    }
    return -1
}