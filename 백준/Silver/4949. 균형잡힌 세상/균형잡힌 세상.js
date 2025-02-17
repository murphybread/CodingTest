const input = require("fs").readFileSync("/dev/stdin").toString().split("\n")

const arr = input.slice(0, input.length - 1);
const result = [];

for (let sentence of arr) {
  if (sentence === ".") continue;
  const stack = [];
  for (let word of sentence) {
    if (word === "(") {
      stack.push(1);
    }
    if (word === ")") {
      if (stack.length && stack[stack.length - 1] === 1) {
        stack.pop();
      } else {
        stack.push("break");
        break;
      }
    }

    if (word === "[") {
      stack.push(2);
    }
    if (word === "]") {
      if (stack.length && stack[stack.length - 1] === 2) {
        stack.pop();
      } else {
        stack.push("break");
        break;
      }
    }
  }

  if (stack.length === 0) {
    result.push("yes");
  } else {
    result.push("no");
  }
}

for (let answer of result) {
  console.log(answer);
}
