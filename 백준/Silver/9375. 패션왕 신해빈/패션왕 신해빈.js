const input = require("fs").readFileSync("/dev/stdin").toString().split("\n")

const t = Number(input[0]);
let currentIdx = 1;

for (let i = 0; i < t; i++) {
  let n = Number(input[currentIdx]);
  let cloths = new Map();

  for (j = 1; j <= n; j++) {
    const [name, type] = input[currentIdx + j].split(" ");
    cloths.set(type, (cloths.get(type) || 0) + 1);
  }

  let answer = 1;
  for (let count of cloths.values()) {
    answer *= count + 1;
  }
  console.log(answer - 1);

  currentIdx += n + 1;
}
