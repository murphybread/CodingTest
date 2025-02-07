const input = require("fs")
  .readFileSync(process.platform === "win32" ? "./input.txt" : "/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((line) => line.split(" ").map(Number));

const dp = Array.from({ length: 21 }, () =>
  Array.from({ length: 21 }, () => Array(21).fill(0))
);

function w(a, b, c) {
  if (a <= 0 || b <= 0 || c <= 0) {
    return 1;
  }
  if (a > 20 || b > 20 || c > 20) {
    return w(20, 20, 20);
  }
  if (dp[a][b][c] !== 0) {
    return dp[a][b][c];
  }

  if (a < b && b < c) {
    dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
    return dp[a][b][c];
  }

  dp[a][b][c] =
    w(a - 1, b, c) +
    w(a - 1, b - 1, c) +
    w(a - 1, b, c - 1) -
    w(a - 1, b - 1, c - 1);

  return dp[a][b][c];
}

const test = input.filter(
  (line) => !(line[0] === -1 && line[1] === -1 && line[2] === -1)
);

for (let [a, b, c] of test) {
  console.log(`w(${a}, ${b}, ${c}) = ${w(a, b, c)}`);
}
