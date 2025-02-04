const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ').map(Number);

const [m, n] = input;
const result = [];

function isPrime(num) {
    if(num === 1) {
        return false;
    }
    
    for(let i = 2; i <= Math.sqrt(num); i++) {
        if(num % i === 0) {
            return false;
        }
    }
    
    return true;
}

for(let i = m; i <= n; i++) {
    if(isPrime(i)) {
        result.push(i);
    }
}

console.log(result.join('\n')); // 각 숫자를 줄바꿈으로 구분하여 출력