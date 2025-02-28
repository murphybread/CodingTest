/**
 * @param {string} word1
 * @param {string} word2
 * @return {string}
 */
var mergeAlternately = function(word1, word2) {
    let answer = ""
    const n1 = word1.length
    const n2 = word2.length
    const m = Math.min(n1, n2)
    let count = 0
    while (count <m){
        answer += word1[count] + word2[count]
        count++
    }

    if(n1 === n2){

    } else if (n1 > n2){
        answer += word1.slice(m)
    } else if (n2 > n1){
        answer += word2.slice(m)
    }


    return answer
};