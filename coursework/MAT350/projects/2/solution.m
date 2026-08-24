%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Applied Linear Algebra (MAT-350): Project 2 Solution  %
% By Alexander Ahmann <alexander.ahmann@snhu.edu>       %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%
% Part 1: Toy problems
%

%
% Q1: Consider the following 3 x 3 matrix:
%     
%         ⎡1  2  3⎤
%         ⎢       ⎥
%     A = ⎢3  3  4⎥
%         ⎢       ⎥
%         ⎣5  6  7⎦
%
% Use the svd() function in MATLAB to compute A_1, the rank-1 app-
%  -roximation of A. Clearly state what A_1 is, rounded to 4 deci-
%  -mal places. Also, compute the root mean square error (RMSE)
%  between A and A_1.
%

A = [1 2 3; 
    3 3 4; 
    5 6 7]

[U, S, V] = svd(A)

A_1 = U(:, 1:1) * S(1:1, 1:1) * V(:, 1:1)'
A_norm1 = norm(A - A_1, 'fro') / 3
A_rmse1 = sqrt(mean((A - A_1).^2, 'all'))
A_rank1 = rank(A_1)
  % General format of "root mean square error" formula 
  %   ``sqrt(mean((A - B).^2, 'all'))``
  % where A and B are matrices of the same n x n.

%
% Q2: Use the svd() function in MATLAB to compute A_2, the rank-2
%   approximation of A. Clearly state what A_2 is, rounded to 4
%   decimal places. Also, compute the root mean square error (RMSE)
%   between A and A_2. Which approximation is better, A_1 or A_2?
%   Explain.
%

A_2 = A_1 + U(:, 1:2) * S(1:2, 1:2) * V(:, 1:2).'
A_norm2 = norm(A - A_2, 'fro') / 3
A_rmse2 = sqrt(mean((A - A_2).^2, 'all'))
A_rank2 = rank(A_2)

%
% Q3: For the given arbitrary 3 x 3 matrix A, the singular decomp-
%   -osition is "A = USV'" where "U = [u_1, u_2, u_3]". Use MATLAB to
%   compute the dot product "d_1 = dot(u_1, u_2)". Also, use MATLAB
%   to compute the cross product "c = cross(u_1, u_2)" and dot prod-
%   -uct d_2 = dot(c, u_3). Clearly state the values for each of the
%   -se computations. Do these values make sense? Explain.
%

u_1 = U(:,1)
u_2 = U(:,2)
u_3 = U(:,3)

d_1 = dot(u_1, u_2)
c = cross(u_1, u_2)
d_2 = dot(c, u_3)

%
% Q4: Using the matrix "U = [u_1, u_2, u_3]", determine whether or
%   not the columns of U span [R]^3. Explain your approach.
%

U_rref = rref(U) % returns three (3)
  % pivots, therefore it spans.

%
% Part 2: Image Compression
%

clearvars

%
% Q5: Use the MATLAB "imshow()" function to load and display the
%   image A stored in the provided MATLAB "image.mat" file. For
%   the loaded image, derive the value of "k" that will result in
%   a compression ratio of "CR ~= 2". For this value of "k", con-
%   -struct the rank-k approximation of the image. 
%

load image.mat

imshow(A)
title("Given Image (No Compression)");

[m, n] = size(A) % NOTE: special thanks to K. B. Gardner for her advices
  % given in "Project 2 Tips," which I references when coding the sol-
  % -ution to this given question item.

image2matrix = im2double(double(A));
[U S V] = svd(image2matrix);

CR = 2
k_2 = round( (m * n) / (CR * (m + n + 1)))
  % Derived by solving for "k" in:
  % CR = (m * n) / (k * (m + n + 1))
Ak_CR2 = U(:, 1:k_2) * S(1:k_2, 1:k_2) * V(:, 1:k_2)';

Ak_CR2_rank = rank(Ak_CR2)
Ak_CR2 = uint8(round(Ak_CR2));

%
% Q6: Display the image and compute the root mean square error (RMSE)
%   between the approximation and the original image. Make sure to
%   include a copy of the approximate image in your report.
%

figure;
imshow(Ak_CR2);
title("Given Image (CR ~= 2)");

rmse_CR2 = sqrt(mean((A - Ak_CR2).^2, 'all'))

%
% Q7: Repeat steps and 5 and 6 for "CR ~= 10", "CR ~= 25", "CR = ~= 75" 
%   Explain what trends you observe in the image approximation as CR the 
%   compression ratio increases and provide your recommendation for the 
%   best CR the compression ratio based on your observations. Make sure 
%   to include a copy of the approximate images in your report.
%

%%
% Case CR ~= 10
%%

CR = 10
k_10 = round( (m * n) / (CR * (m + n + 1)))
  % Derived by solving for "k" in:
  % CR = (m * n) / (k * (m + n + 1))
Ak_CR10 = U(:, 1:k_10) * S(1:k_10, 1:k_10) * V(:, 1:k_10)';

Ak_CR10_rank = rank(Ak_CR10)
Ak_CR10 = uint8(round(Ak_CR10));

figure;
imshow(Ak_CR10);
title("Given Image (CR ~= 10)");

rmse_CR10 = sqrt(mean((A - Ak_CR10).^2, 'all'))

%%
% Case CR ~= 25
%%

CR = 25
k_25 = round( (m * n) / (CR * (m + n + 1)))
  % Derived by solving for "k" in:
  % CR = (m * n) / (k * (m + n + 1))
Ak_CR25 = U(:, 1:k_25) * S(1:k_25, 1:k_25) * V(:, 1:k_25)';

Ak_CR25_rank = rank(Ak_CR25)
Ak_CR25 = uint8(round(Ak_CR25));

figure;
imshow(Ak_CR25);
title("Given Image (CR ~= 25)");

rmse_CR25 = sqrt(mean((A - Ak_CR25).^2, 'all'))

%%
% Case CR ~= 75
%%

CR = 75
k_75 = round( (m * n) / (CR * (m + n + 1)))
  % Derived by solving for "k" in:
  % CR = (m * n) / (k * (m + n + 1))
Ak_CR75 = U(:, 1:k_75) * S(1:k_75, 1:k_75) * V(:, 1:k_75)';

Ak_CR75_rank = rank(Ak_CR75)
Ak_CR75 = uint8(round(Ak_CR75));

figure;
imshow(Ak_CR75);
title("Given Image (CR ~= 75)");

rmse_CR75 = sqrt(mean((A - Ak_CR75).^2, 'all'))

%%%%%%%%%%%%%%
% References %
%%%%%%%%%%%%%%

clearvars

%
% 1. "Jessica" (Feb. 20, 2024). How to do a rank-1 approximation?. MATLAB Help Center. Retrieved on Aug. 13, 2026 from: 
%   https://www.mathworks.com/matlabcentral/answers/2084643-how-to-do-a-rank-1-approximation
% 2. Retrieved on Aug. 13, 2024 from: https://en.wikipedia.org/wiki/Low-rank_approximation
% 3. Retrieved on Aug. 13, 2024 from: https://www.mathworks.com/matlabcentral/answers/4064-rmse-root-mean-square-error
%
