function solution(bandage, health, attacks) {
    var answer = 0;
    const [ takenTime , noraml ,bonus] = bandage
    const times = []
    const maxHealth = health
    for(let [time, attack] of attacks){
        times.push(time)
        
    }
    
    const end = Math.max(...times)
    
    let t = 0

    let strike = 0
    while(t < end ){
        t++
        
        if(attacks[0][0] === t){
            health -= attacks[0][1]
            attacks.shift()
            strike = 0
            
            if(health <= 0) break
            
            continue
            
        }
        
        health += noraml
        strike +=1
        if (strike === takenTime) {
            health += bonus
            strike = 0
        }
        
        if (health >= maxHealth) health = maxHealth
        
    }
    
    return health > 0 ? health : -1;
}