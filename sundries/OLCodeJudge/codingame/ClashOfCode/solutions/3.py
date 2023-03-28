from math import floor
x = input()
print(int(floor(sum([ord(k) for k in list(x)])/len(x))))
