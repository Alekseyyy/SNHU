%
% zyBooks practice problems 
% 3.4 MATLAB: Dot Product
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Create the row vectors a=[1, -2, 0, 7] and b=[-3, -1, 5, 0].

a = [1 -2 0 7]
b = [-3 -1 5 0]

%Create the column vectors c=[3, 1, 4, -2] and d=[0, -2, 2, 1].

c = [3; 1; 4; -2]
d = [0; -2; 2; 1]

%Use the dot() command to find the dot product of vectors a and b.  Store this value in g1. 

g1 = dot(a, b)

%Use matrix multiplication to find the dot product of vectors a and b.  Store this value in g2.

g2 = a * b.'

%Use the dot() command to find the dot product of vectors c and d.  Store this value in h1. 

h1 = dot(c, d)

%Use matrix multiplication to find the dot product of vectors c and d.  Store this value in h2.

h2 = c.' * d

