function solution(friends, gifts) {
    var answer = [];
    const info = {}
    
    for(let f of friends){
        info[f] = Array(friends.length).fill(0)
    }
    
    for(let g of gifts){
        const [give, taken] = g.split(" ")
        
        info[give][friends.indexOf(taken)] += 1
        
    }
    
    const presentArr = []
    // 선물 지수

    for (let [key,value] of Object.entries(info)){
        const name = key
        const idx = friends.indexOf(name)
        
        const allGive = value.reduce((acc,cur)=> acc+cur,0)
        let allTaken = 0
        for (let KeyName in info){
            allTaken += info[KeyName][idx]
        }
        const presentNum = allGive - allTaken
        presentArr.push(presentNum)
    }
    
    for (let [key,value] of Object.entries(info)){
        const name = key
        const idx = friends.indexOf(name)
        let present = 0
     

    for(let i = 0 ; i < value.length; i++){
            if(i === idx ) continue
            
            if(value[i] > info[friends[i]][idx] ){
                //현재 사람 더하기
                present +=1
            } else if ((value[i] === info[friends[i]][idx])  || (value[i] + info[friends[i]][idx]) <=0 ) {
                 // 그사람 더하기
                if(presentArr[idx] === presentArr[i]) {
                    continue
                } else if( presentArr[idx] > presentArr[i]){
                    present+=1
                }
                
            }
        }
        answer.push(present)
        
    }
    
    
    return Math.max(...answer);
}
