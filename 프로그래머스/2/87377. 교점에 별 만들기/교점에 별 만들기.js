function solution(line) {
    var answer = [];
    

    function getCord(p1, p2){
        const [a,b,e]= p1
        const [c,d,f]=p2
        
        if(a*d -b*c == 0){
            return null
        }
        
        else{
            let x=(b*f -e*d)/(a*d-b*c)
            let y=(e*c-a*f)/(a*d-b*c)
            if(Number.isInteger(x) && Number.isInteger(y)){
               return [x,y]
               }
            
            
        }
       return null
    }
    
    function containsCoordinate(coordsArray, coord) {
        if (!coord) return false;
      for (const existingCoord of coordsArray) {

          if ( existingCoord[0] === coord[0] && existingCoord[1] === coord[1]) {
          return true;
        }
      }
      return false;
}

    for (let i=0 ;i<line.length-1;i++){
        for (let j=i+1; j<line.length;j++){
            
           let cors = getCord(line[i], line[j])
           if(!containsCoordinate(answer,cors) && cors){answer.push(cors)}
        }
    }
    let xSet = answer.map((a)=> a[0])
    let ySet = answer.map(a=> a[1])
    
    
    let minX = Math.min(...xSet);
    let maxX = Math.max(...xSet);
    let minY = Math.min(...ySet);
    let maxY = Math.max(...ySet);
    
    
    let width = maxX - minX + 1;
    let height = maxY - minY + 1;
    
    let grid = Array(height).fill().map(() => Array(width).fill('.'));
    
    for(let [x, y] of answer){
        let gridX = x - minX;
        let gridY = maxY - y;
        
        grid[gridY][gridX] = '*';
    }
    
    return grid.map(row => row.join(''));
}