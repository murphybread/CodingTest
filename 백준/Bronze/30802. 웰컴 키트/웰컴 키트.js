const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n").map(line => line.split(" ").map(Number))

const n = input[0]
const numbers = input[1]
const [t,p] = input[2]
let cloths = 0

const total = numbers.reduce((acc,cur) => acc+cur , 0)
// 의상
for (let size of numbers){
    cloths += Math.floor(size/t)
    if ( Math.floor(size/t)* t - size < 0) cloths +=1
    
}
console.log(cloths)
// 펜수
console.log( Math.floor(total/p) , (total % p))