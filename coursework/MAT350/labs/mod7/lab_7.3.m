%
% zyBooks practice problems 
% 7.3 MATLAB: Norms and Distances
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%To find the Euclidean distance between two vectors, find the 2-norm of the difference of 
%those vectors.  Enter column vectors u and v.  Then use the norm() command to find d(u,v), storing 
%it in dist_uv.

u = [4; 3]
v = [-4; -12]

dist_uv = norm(u - v, 2)

%To find the distance between two matrices with respect to the Frobenius inner product, 
%find the Frobenius norm of the difference of those matrices.  Enter matrices A and B.  
%Then use the norm() command to find d(A,B), storing it in dist_AB.

A = [
    3 -7 4 3;
    -2 4 -5 0
]

B = [
    1 -7 2 5;
    0 0 -5 2
]

dist_AB = norm(A - B, 'fro')

