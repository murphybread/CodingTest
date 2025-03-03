/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
    const vowels = ['a','e','i','o','u']
    const temp = []
    let answer = ""

    for(let c of s){
        if (vowels.includes(c.toLowerCase())) temp.push(c)
    }
    temp.reverse()


    for(let c of s){
        if (vowels.includes(c.toLowerCase())) c = temp.shift()

        answer += c
    }
    
    return answer
};