const input = require("fs").readFileSync("/dev/stdin").toString().trim().split('\n');

const n = Number(input[0]);
const ns = input[1].split(' ').map(Number);
const m = Number(input[2]);
const ms = input[3].split(' ').map(Number);

const h = new Set(ns)
const result = []
for (let num of ms){
    if (h.has(num)){
        result.push(1)
    }else {
        result.push(0)
    }
}

console.log(result.join(' '))