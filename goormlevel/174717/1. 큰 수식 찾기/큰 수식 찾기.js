// Run by Node.js
const readline = require('readline');

(async () => {
    const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
    let lineCount = 0;
    let exprA = "", exprB = "";

    for await (const line of rl) {
        const parts = line.trim().split(" ");
        exprA = parts[0];
        exprB = parts[1];
        rl.close();
    }

    const valA = eval(exprA);
    const valB = eval(exprB);


    console.log(Math.max(valA, valB));
    process.exit();
})();
