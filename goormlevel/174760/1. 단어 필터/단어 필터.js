const readline = require('readline');

(async () => {
  const rl = readline.createInterface({ input: process.stdin });
  const lines = [];
  for await (const line of rl) {
    lines.push(line.trim());
  }
  rl.close();


  const [_, __] = lines[0].split(" ").map(Number);
  const S = lines[1];   
  const E = lines[2];  

  const targetLen = S.length;
  const stack = [];

  for (let i = 0; i < E.length; i++) {
    stack.push(E[i]);

    if (stack.length >= targetLen) {
      let match = true;
      const start = stack.length - targetLen;
      for (let k = 0; k < targetLen; k++) {
        if (stack[start + k] !== S[k]) {
          match = false;
          break;
        }
      }
      if (match) {
        // 금지어랑 일치하면 pop()을 |S|번 실행
        for (let k = 0; k < targetLen; k++) {
          stack.pop();
        }
      }
    }
  }

  const answer = stack.join("");
  console.log(answer.length ? answer : "EMPTY");
})();
