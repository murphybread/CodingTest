const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input.shift().split(" ").map(Number);
const unsee = new Map();
for (let i = 0; i < n; i++) {
  unsee.set(input[i], input[i]);
}
const result = [];

for (let j = n; j < n + m; j++) {
  let target = unsee.get(input[j]);
  if (target) result.push(target);
}

result.sort();
console.log(result.length);
console.log(result.join("\n"));
