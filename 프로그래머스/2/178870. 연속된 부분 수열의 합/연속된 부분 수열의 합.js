function solution(sequence, k) {
    var answer = [0, 1000000];
    const n = sequence.length

    let left = 0
    let right = 0
    let sum = sequence[0]

    while(right < n ){

        if (sum < k){

            right +=1
            if (right > n) break
            sum  += sequence[right]
        }

        else if (sum > k){
            sum -= sequence[left]
            left +=1
        }

        else if (sum === k){
            if (answer[1] - answer[0] > right - left) {
            answer[0] = left;
            answer[1] = right;
            }

            sum -= sequence[left++];
            sum += sequence[++right];
        }
    }

    return answer;
}