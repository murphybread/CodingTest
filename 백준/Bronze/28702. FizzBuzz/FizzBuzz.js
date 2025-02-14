// Fizz인경우 Buzz 인경우 Fizz Buzz인경울르 통해 i가 어디인지 파악하기

const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

let pos = 0;
let num = 0;

for (let i = 0; i < input.length; i++) {
  if (!isNaN(input[i])) {
    pos = i;
    break;
  }
}

num = Number(input[pos]) + 3 - pos;


function check(n) {
  if (n % 3 === 0 && n % 5 === 0) {
    return "FizzBuzz";
  } else if (n % 3 === 0) {
    return "Fizz";
  } else if (n % 5 === 0) {
    return "Buzz";
  } else {
    return n;
  }
}

console.log(check(num));
