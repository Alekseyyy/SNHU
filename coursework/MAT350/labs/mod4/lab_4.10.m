%
% zyBooks practice problems 
% 4.10 MATLAB: Change of Coordinates
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Store the ordered basis vectors for the set B in the matrix B.

B = [
    1 2 1;
    1 4 2;
    2 -1 1
]

%Store the ordered basis vectors for the set C in the matrix C.

C = [
    1 2 1;
    -1 0 2;
    1 1 -1
]

%Store the augmented matrix [C | B] in tempCB.

tempCB = [C B]

%Row reduce the augmented matrix tempCB to get [I | P_BtoC].  Store the reduced matrix in temp_reduced.

temp_reduced = rref(tempCB)

%Store the change of coordinates matrix from basis B to basis C in P_BtoC.

P_BtoC = temp_reduced(:,4:6)

