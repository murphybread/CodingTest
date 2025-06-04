n, m = map(int, input().split())
arr = list(map(int, input().split()))

for i in range(len(arr)):
	if arr[i] % m != 0:
		arr[i] *= m

print(*arr)