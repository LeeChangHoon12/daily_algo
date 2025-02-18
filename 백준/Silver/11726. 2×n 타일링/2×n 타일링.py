MOD = 10_007

cache = [0]*1001
n = int(input())

cache[1] = 1
cache[2] = 2

for i in range(3,1001):
    cache[i] = (cache[i-2] + cache[i-1]) % MOD

print(cache[n])
