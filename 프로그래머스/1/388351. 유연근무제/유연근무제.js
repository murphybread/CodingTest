function solution(schedules, timelogs, startday) {
    var answer = 0;
    
    
    
    for (let i =0 ; i < schedules.length; i ++){
        let flag = false;
        let limitTime = schedules[i]

        let minutes = limitTime % 100;
        let hours = Math.floor(limitTime / 100);
        
        minutes += 10;
        if (minutes >= 60) {
            hours += 1;
            minutes -= 60;
        }
        limitTime = hours * 100 + minutes;
        
        for (let j= 0 ; j <7; j++){
            let day = (startday + j - 1) % 7 + 1
            let time = timelogs[i][j]
            
            if(day === 6 || day === 7) continue
                   
            if (time > limitTime) {
                flag = true
                break
            }

        }
        
        if(!flag){
            answer +=1
        }
        
        
    }
    return answer;
}