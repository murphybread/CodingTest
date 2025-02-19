const input = require('fs').readFileSync("/dev/stdin").toString().split("\n").map(Number)


const n = input[0]
const arr = input.slice(1,n+1)

const heap =[]
const result = []

function insertHeap (num){
    
    heap.push(num)
    let current = heap.length -1
    
    while( current > 0){
        let parent = Math.floor((current-1)/2)
        if (heap[parent] > heap[current]){
            [heap[parent] , heap[current] ] = [heap[current] , heap[parent] ]
        }  else{
            break
        }
        
        current = parent
        
    }
}

function deleteHeap() {
  if (heap.length === 0) return 0;
  if (heap.length === 1) return heap.pop();

  const min = heap[0];
  heap[0] = heap.pop();

  let current = 0;

  while (true) {
    let smallest = current;
    let left = smallest * 2 + 1;
    let right = smallest * 2 + 2;

    if (left < heap.length && heap[left] < heap[smallest]) {
      smallest = left;
    }

    if (right < heap.length && heap[right] < heap[smallest]) {
      smallest = right;
    }

    if (smallest === current) break;
    [heap[current], heap[smallest]] = [heap[smallest], heap[current]];
    current = smallest;
  }

  return min;
}


for (let i = 0; i <arr.length;i ++){
    let target = arr[i]
    if (arr[i] === 0){
        result.push(deleteHeap())
    } else {
        insertHeap(target)
    }
}



console.log(result.join('\n'))