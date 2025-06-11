const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  // output: process.stdout // stdout을 직접 제어할 것이므로 주석 처리하거나 제거
});

let isFirstLine = true;
let isFirstOutput = true; // 첫 번째 숫자인지 판별하여 앞쪽 공백을 제어
let M = 0;

rl.on('line', (line) => {
  const trimmedLine = line.trim();
  if (trimmedLine === '') return;

  // 1. 첫 줄에서 M 값만 저장합니다. N은 스트리밍 방식이라 굳이 저장할 필요 없습니다.
  if (isFirstLine) {
    M = Number(trimmedLine.split(/\s+/)[1]);
    isFirstLine = false;
    return;
  }

  // 2. 그 이후의 모든 줄에 대해, 숫자를 하나씩 처리합니다.
  const numberStrings = trimmedLine.split(/\s+/);

  for (const numStr of numberStrings) {
    if (numStr === '') continue;
    const num = Number(numStr);

    let result;
    if (num % M !== 0) {
      result = num * M;
    } else {
      result = num;
    }
    
    // 3. 첫 번째 출력이면 그냥 출력, 아니면 앞에 공백을 붙여서 출력
    if (isFirstOutput) {
      process.stdout.write(String(result));
      isFirstOutput = false;
    } else {
      process.stdout.write(' ' + String(result));
    }
  }
});

rl.on('close', () => {
  // 모든 입력이 끝나면 프로그램 종료
  process.exit(0);
});