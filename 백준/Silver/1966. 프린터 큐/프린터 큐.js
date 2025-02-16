const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const t = Number(input[0]);
const result = [];
for (let i = 1; i < 2 * t; i += 2) {
  let [n, m] = input[i].split(" ").map(Number);
  const arr = input[i + 1].split(" ").map(Number);
  let cnt = 0;

  while (arr.length > 0) {
    if (arr[0] === Math.max(...arr)) {
      arr.shift();
      cnt++;
      if (m === 0) {
        result.push(cnt);
        break;
      }
      m--;
    } else {
      arr.push(arr.shift());
      if (m !== 0) {
        m--;
      } else {
        m = arr.length - 1;
      }
    }
  }

}

result.forEach((el) => console.log(el));
