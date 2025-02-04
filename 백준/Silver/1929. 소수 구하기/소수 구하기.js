const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];
let result = [];

readline.on('line', (line) => {
    input = line.split(' ').map(el => parseInt(el));
}).on('close', ()=>{
    const [m,n] = input
    
    function isPrime(num){
        if(num === 1){return false}
        
        for(let i =2; i <= Math.sqrt(num) ; i++ ){
            if(num % i === 0){
                return false
            }
        }
        
        return true
    }
    for(let i = m ; i <= n; i ++){
        if( isPrime(i)){
            result.push(i)
        }
        
    }

    
    result.forEach((r) => console.log(r))
    process.exit();
});