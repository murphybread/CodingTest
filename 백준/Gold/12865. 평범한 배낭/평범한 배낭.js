const input = require("fs")
  .readFileSync(process.platform === "win32" ? "./input.txt" : "/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((line) => line.split(" ").map(Number));

const [n, k] = input[0];
const items = [[0, 0]];
const dp = Array.from({ length: n + 1 }, () => Array(k + 1).fill(0));

input.slice(1).forEach((item) => items.push(item));

for (let i = 1; i <= n; i++) {
  const [weight, value] = items[i];

  for (j = 0; j <= k; j++) {
    if (j < weight) {
      dp[i][j] = dp[i - 1][j];
    } else {
      dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
    }
  }
}

console.log(dp[n][k]);
