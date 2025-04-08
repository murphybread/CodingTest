function solution(expressions) {
    // 주어진 문자열이 특정 진법에서 유효한지 확인
    function isValid(numStr, base) {
        if (numStr === "X") return true;
        for (const digit of numStr) {
            if (isNaN(parseInt(digit, base))) {
                return false;
            }
        }
        return true;
    }
    
    // 특정 진법에서 수식이 성립하는지 확인
    function validateEquation(a, op, b, result, base) {
        if (result === "X") return true;
        
        const aDecimal = parseInt(a, base);
        const bDecimal = parseInt(b, base);
        const resultDecimal = parseInt(result, base);
        
        if (op === "+") {
            return aDecimal + bDecimal === resultDecimal;
        } else { // op === "-"
            return aDecimal - bDecimal === resultDecimal;
        }
    }
    
    // 가능한 진법 찾기
    let possibleBases = [];
    
    // 처음에는 모든 진법이 가능하다고 가정
    for (let base = 2; base <= 9; base++) {
        let isValidBase = true;
        
        // 모든 수식에 대해 검증
        for (const exp of expressions) {
            const parts = exp.split(" ");
            const a = parts[0];
            const op = parts[1];
            const b = parts[2];
            const result = parts[4];
            
            // 문자열이 유효하고 계산이 맞는지 확인
            if (!isValid(a, base) || !isValid(b, base) || !isValid(result, base) || 
                !validateEquation(a, op, b, result, base)) {
                isValidBase = false;
                break;
            }
        }
        
        if (isValidBase) {
            possibleBases.push(base);
        }
    }
    
    // 결과 생성
    const answers = [];
    
    for (const exp of expressions) {
        if (!exp.includes("= X")) continue;  // X가 없는 수식은 건너뛰기
        
        const parts = exp.split(" ");
        const a = parts[0];
        const op = parts[1];
        const b = parts[2];
        
        // 여러 진법에서 계산해본 결과 저장
        const results = new Set();
        
        for (const base of possibleBases) {
            const aDecimal = parseInt(a, base);
            const bDecimal = parseInt(b, base);
            
            let resultDecimal;
            if (op === "+") {
                resultDecimal = aDecimal + bDecimal;
            } else { // op === "-"
                resultDecimal = aDecimal - bDecimal;
            }
            
            // 결과를 해당 진법으로 변환
            results.add(resultDecimal.toString(base));
        }
        
        if (results.size === 1) {
            // 모든 진법에서 결과가 같은 경우
            answers.push(`${a} ${op} ${b} = ${[...results][0]}`);
        } else {
            // 진법에 따라 결과가 다른 경우
            answers.push(`${a} ${op} ${b} = ?`);
        }
    }
    
    return answers;
}