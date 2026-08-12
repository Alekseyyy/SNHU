%
% zyBooks practice problems 
% 4.3 MATLAB: Span
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Enter vectors v1, v2, v3, and v4 as row vectors.

v1 = [1 0 1 1]
v2 = [2 -2 3 2]
v3 = [1 -1 1 0]
v4 = [0 -1 1 1]

%Create a matrix A consisting of these vectors as column vectors.

A = [v1.' v2.' v3.' v4.']

%For vectors in 4-space, the reduced matrix will have four pivot columns if the vectors span 4-space.
%Find the reduced matrix, storing it in reducedA.  Do the vectors span 4-space?

reducedA = rref(A)

%Create the vector w=[2 1 1 1].

w = [2 1 1 1]

%Create an augmented matrix [A|w], storing it in Aw.

Aw = [A w.']

%Find the reduced matrix, storing it in reducedAw.  Is w is in the span of the vectors?

reducedAw = rref(Aw)

