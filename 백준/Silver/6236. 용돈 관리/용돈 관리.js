const input = require("fs").readFileSync("/dev/stdin").toString().split("\n").map(line => line.split(" ").map(Number))


const [n,m] = input[0];
const expenses = input.slice(1).flat();

let start = Math.max(...expenses)
let end = expenses.reduce((acc,cur) => acc+cur, 0 )
let result = end
let possible = true
    while (start <= end){
        mid = Math.floor((start + end) / 2)
        
        let withdraw_count = 1  
        let current_balance = mid 

        
        for (let expense of expenses){
            if (current_balance >= expense){
                current_balance -= expense
            }
                
            else {
                withdraw_count += 1
                current_balance = mid - expense
                if (current_balance < 0){
                    possible = false
                    break                         
                }

            }
                
            
        }

        
        if (!possible){
            start = mid + 1
            continue
        }
        if (withdraw_count <= m){
            result = mid
            end = mid - 1
        }
            
        else {
            start = mid + 1
        }
    }
  console.log(result)
