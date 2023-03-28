
# "Quick and dirty" tool to compare similarity between two executables.
# By Aleksey, https://alekseyyy.github.io
# - @EpsilonCalculus on Twitter
# - @EntropyThot on decompetition.io

# "Inspired" by Malware Data Science (2018, ch. 5)

import sys
J = lambda X, Y: float(len(X.intersection(Y))) / float(len(X.union(Y)))
d_J = lambda X, Y: 1 - J(X, Y)

if __name__ == "__main__":
	if len(sys.argv) < 2:
		print("please enter two disassembly strings as arguments")
		sys.exit()
	bin1 = sys.argv[1]
	bin2 = sys.argv[2]

	print("J(X, Y) =", J(bin1, bin2))
	print("dJ(X, Y) =", J(bin1, bin2))


