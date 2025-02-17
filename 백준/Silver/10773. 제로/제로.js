const input = require("fs").readFileSync("/dev/stdin").toString().split("\n").map(Number)


const  k = input[0]
const arr = input.slice(1,k+1)

const stack = []

for (let el of arr){
    if(el === 0) {
        stack.pop()
    }
    else {
        stack.push(el)
    }
}

console.log(stack.reduce((acc,cur) => acc+cur,0))
