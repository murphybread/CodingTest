/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
    let left = 0
    let right = 1
    let sum = numbers[left] + numbers[right]

    let time = 0
    for(let i = 0;  i <numbers.length -1 ; i++){
        for(let j = i+1; j<numbers.length ;j++){
            if(numbers[i] + numbers[j] === target )  return [i+1,j+1]
        }
    }

    
    
};