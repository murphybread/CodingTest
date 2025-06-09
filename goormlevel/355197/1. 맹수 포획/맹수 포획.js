// Run by Node.js
const readline = require('readline');

(async () => {
  const rl = readline.createInterface({ input: process.stdin });
  const lines = [];

  for await (const line of rl) {
    lines.push(line.trim().split(' ').map(Number));
  }
  rl.close();

  const [Bx, By] = lines[0];
  const [Gx, Gy] = lines[1];
  const N = lines[2][0];
  const traps = lines.slice(3, 3 + N);

  // 1) 맨해튼 거리 검사 (거리가 5 미만이면 실패)
  const manh = Math.abs(Bx - Gx) + Math.abs(By - Gy);
  if (manh < 5) {
    console.log('NO');
    return;
  }

  // 2) 유효한 덫의 개수 세기
  const xMin = Math.min(Bx, Gx);
  const xMax = Math.max(Bx, Gx);
  const yMin = Math.min(By, Gy);
  const yMax = Math.max(By, Gy);
  let effectiveTrapCount = 0;

  for (const [Tx, Ty] of traps) {
    // 덫이 사각형 내부에 있는지 확인
    const isInBox = Tx >= xMin && Tx <= xMax && Ty >= yMin && Ty <= yMax;

    if (isInBox) {
      // 덫이 맹수(B)와 구름(G)을 잇는 직선 위에 있는지 확인 (공선성 체크)
      // 외적(cross-product) 원리: (Ty - Gy) * (Bx - Gx) == (By - Gy) * (Tx - Gx)
      // 위 식이 참이면 세 점은 한 직선 위에 있음
      const isOnLine = (Ty - Gy) * (Bx - Gx) === (By - Gy) * (Tx - Gx);

      // 직선 위에 있지 않은 경우에만 유효한 덫으로 카운트
      if (!isOnLine) {
        effectiveTrapCount++;
      }
    }
    
    // 유효한 덫이 3개 이상이면 더 이상 탐색할 필요 없음
    if (effectiveTrapCount >= 3) {
      break;
    }
  }

  // 3) 결과 출력 (유효한 덫이 3개 이상이면 YES)
  console.log(effectiveTrapCount >= 3 ? 'YES' : 'NO');
})();