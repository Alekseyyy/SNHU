import sys
import math

def g(n):
    def i(x):
        if x <= 3:
            return x > 1
        if x % 2 == 0 or x % 3 == 0:
            return False
        w = 5
        while w**2 <= x:
            if x % w == 0 or x % (w + 2) == 0:
                return False
            w += 6
        return True
    p = []
    y = 2
    while len(p) < n:
        if i(y):
            p.append(y)

a = int(input())
b = 10000

p_a = g(a)
p_a = p_a[len(p_a) - 1]

print(sum([p_a * math.exp(10, -sum(a + math.abs(math.log(p_a, 10)))) for r in range(b)]))

