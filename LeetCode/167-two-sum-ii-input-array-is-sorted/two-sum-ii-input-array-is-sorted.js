/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
    let left = 0
    let right = numbers.length -1
    let sum = numbers[left] + numbers[right]

    while(sum !== target){
        if (sum < target){
            sum -= numbers[left]
            left += 1
            sum += numbers[left]
        } else{
            sum -= numbers[right]
            right -=1
            sum += numbers[right]
        }
    }
    
    return [left+1, right+1]
};