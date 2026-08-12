%
% zyBooks practice problems 
% 4.6 MATLAB: Basis
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Enter vectors v1, v2, v3, and v4.

v1 = [1 -2 2 -1]
v2 = [-3 5 -2 2]
v3 = [-1 1 2 0]
v4 = [0 -1 4 -1]

%Create a matrix A with the given vectors placed in the columns of A.

A = [v1.' v2.' v3.' v4.']

%Create the appropriately sized identity matrix, storing it in I.

I = eye(4)

%Augment A with the identity matrix, storing it in augA.

augA = [A I]

%Row reduce augA, storing it in reduced_augA.

[reduced_augA pivot_augA] = rref(augA)

%Use the pivot colulmns in reduced_augA to identify which of the original vectors are 
%included in the basis, along with which columns of the identity matrix are included in 
%the basis. Create a matrix containing the basis vectors, storing it in BasisMatrix.

BasisMatrix = [v1.' v2.' I(:,1) I(:,2)]

