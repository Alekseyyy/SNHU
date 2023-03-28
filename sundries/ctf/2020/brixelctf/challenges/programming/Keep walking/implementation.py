
# implementation.py
# this was written to solve the "Keep walking..." challenge

# By Aleksey
#  - github.com/Alekseyyy
#  - medium.com/@EpsilonCalculus

x, y, p = 1, 1, 1
a = None

while x <= 525:
	a = x * y + p + 3
	p = a
	x += 1
	y += 1

print("brixelCTF{" + str(a) + "}")
