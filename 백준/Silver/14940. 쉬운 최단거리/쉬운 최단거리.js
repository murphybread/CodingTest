const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input.shift().split(" ").map(Number);
const board = [];
let [targetX, targetY] = [0, 0];
input.forEach((line) => {
  board.push(line.split(" ").map(Number));
});

const move = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

for (let i = 0; i < n; i++) {
  for (let j = 0; j < m; j++) {
    if (board[i][j] === 2) {
      targetX = i;
      targetY = j;
      break;
    }
  }
}

const distanceMap = Array.from({ length: n }, () => Array(m).fill(0));

const queue = [[targetX, targetY, 0]];
const visited = Array.from({ length: n }, () => Array(m).fill(false));
visited[targetX][targetY] = true;

while (queue.length > 0) {
  const [x, y, count] = queue.shift();

  if (board[x][y] === 0) continue;

  if (board[x][y] === 1) {
    distanceMap[x][y] = count;
  }

  for (let moving of move) {
    let nx = x + moving[0];
    let ny = y + moving[1];

    if (
      nx >= 0 &&
      nx < n &&
      ny >= 0 &&
      ny < m &&
      !visited[nx][ny] &&
      board[nx][ny] !== 0
    ) {
      visited[nx][ny] = true;
      queue.push([nx, ny, count + 1]);
    }
  }
}

for (let i = 0; i < n; i++) {
  for (let j = 0; j < m; j++) {
    if (visited[i][j] === false && board[i][j] === 1) {
      distanceMap[i][j] = -1;
    }
  }
}


distanceMap.forEach((line) => {
  console.log(line.join(" "));
});

