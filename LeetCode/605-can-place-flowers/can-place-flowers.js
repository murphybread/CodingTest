/**
 * @param {number[]} flowerbed
 * @param {number} n
 * @return {boolean}
 */
var canPlaceFlowers = function(flowerbed, n) {
    const width = flowerbed.length
    
    let count  = 0 

    if(width <=2 ){
        if ( Math.max(...flowerbed) < n) count +=1
        return count >= n
    }
    if (flowerbed[0] === 0 && flowerbed[1] === 0){
        flowerbed[0] = 1
        count +=1
    }

    for(let i =1 ; i < width-1; i++){
        let left = i-1
        let right = i +1
        if (flowerbed[left] === 0 && flowerbed[right] === 0 && flowerbed[i] === 0) 
        {   flowerbed[i] = 1
            count += 1
            }
    }
    
    if (flowerbed[width-1] === 0 && flowerbed[width-2] === 0){
        flowerbed[width] = 1
        count +=1
    }


    
    let answer = count >= n
    return answer
};