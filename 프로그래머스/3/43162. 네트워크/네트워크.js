function solution(n, computers) {    
    const visited = Array(n).fill(false)
    let networkCount = 0; 
    
    function dfs(computerId, visited, computers) {
        visited[computerId] = true; // 현재 컴퓨터 방문 처리
        for (let nextComputerId = 0; nextComputerId < computers.length; nextComputerId++) { // 연결된 컴퓨터 찾기
            if (computers[computerId][nextComputerId] === 1 && !visited[nextComputerId]) {
                dfs(nextComputerId, visited, computers); // 재귀 호출
            }
        }
    }

    
    for (let i = 0; i < n; i++) { // 모든 컴퓨터 순회
        if (!visited[i]) { // 아직 방문하지 않은 컴퓨터라면
            dfs(i, visited, computers); // dfs 호출
            networkCount++; // 네트워크 개수 증가
        }
    }
    return networkCount; // 결과 반환

}