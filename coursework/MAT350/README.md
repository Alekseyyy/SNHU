
<img width="750px" src="./img/banner.png" />

## Introduction

* Course Syllabus: [syllabus.pdf](./img/syllabus.pdf)

## Projects

* [Project 1: Matrix Theory Applied to Computer Network Engineering](./projects/1/3-4_project1.pdf)
* Project 2: TBA

## Coursework (by module)

The "official" course textbook is a _zyBooks_ eTextbook entitled _MAT-350: Linear Algebra_ for the Jul.--Aug. 2026 semester at Southern New Hampshire University. The course was eight (8) weeks long, divided into eight (8) modules. Here, I list the topics covered, along with the course labs which involve me writing the MATLAB source code. 

### Module 1: System of Linear Equations

__Topics covered:__ (§1.1) Systems of linear equations, (§1.2) Matrices and linear systems, (§1.4) Elementary row operations, (§1.5) Echelon forms of a matrix, (§1.7) Solution set of a system of linear equations, (§1.9) Gaussian Elimination, (§1.10) Gauss-Jordan elimination, (§1.11) Application to Matrices in Chemistry, (§1.12) Application to Electric circuits.

<details>
<summary>MATLAB Programming Labs</summary>

* [lab_1.3.m](./labs/mod1/lab_1.3.m): On defining matricies, working out their dimensions, the identity matrix via ``eye(Matrix)``, and the matrix transpose
* [lab_1.6.m](./labs/mod1/lab_1.6.m): Row reduction echelon form via ``rref(Matrix)``, and expressing the ``rref(Matrix`` in terms of its elements as ratios via ``format rat``.
* [lab_1.8.m](./labs/mod1/lab_1.8.m): Augmented matricies, and the arithmetic solution to the number of free variables in an ``rref(Matrix)`` solution

</details>

### Module 2: Matrix Algebra

__Topics covered:__ (§2.1) Matrix addition and scalar multiplication, (§2.2) Matrix multiplication, (§2.4) Matrix equations and linear systems, (§2.5) Inverse of a matrix, (§2.7) Solving a system using an inverse matrix, (§2.9) Elementary matrices, (§2.10) Block matrices, (§2.11) LU Decomposition, (§2.13) Application to Markov Chains.

<details>
<summary>MATLAB Programming Labs</summary>

* [lab_2.3.m](./labs/mod2/lab_2.3.m): Scalar Product, Matrix Multiplication, and More Identity Matricies and Transpose Matricies in the context of Matrix Arithmetic.
* [lab_2.6.m](./labs/mod2/lab_2.6.m): Matrix operations involving the identity matrix, and more inverted matricies.
* [lab_2.8.m](./labs/mod2/lab_2.8.m): Solution to a system of equations with matrix arithmetic.
* [lab_2.12.m](./labs/mod2/lab_2.12.m): Lower triangular matrix and Upper triangular matrix decomposition via the ``lu(Matrix)`` function, and a solution to a system of equations with the LU-decomposition method.

</details>

### Module 3: Vectors and Determinants

__Topics covered:__ (§3.1) Introduction to Vectors, (§3.2) Vector operations, (§3.3) Dot product, (§3.5) Cross product, (§3.7) Applications to 3D coordinate geometry, (§3.8) Applications of vectors to physics, (§3.9) Introduction to determinants, (§3.11) Cofactor expansions, (§3.12) Applications to calculating Area and Volume, (§3.13) Properties of determinants, (§3.14) Invertibility and determinants, (§3.15) Cramer's rule, (§3.17) Permutations and determinants. 

<details>
<summary>MATLAB Programming Labs</summary>

* [lab_3.4.m](./labs/mod3/lab_3.4.m): On the Dot Product, and working with it via transpose matricies.
* [lab_3.6.m](./labs/mod3/lab_3.6.m): On the Cross Product, and the volume of a parallelepiped.
* [lab_3.10.m](./labs/mod3/lab_3.10.m): Calculating the determinant of the matrix via the ``det(Matrix)`` function.
* [lab_3.16.m](./labs/mod3/lab_3.16.m): On Cramer's Rule, "slicing" matricies and replacing one column with another, and applications of the ``det(Matrix)`` function to solve the system via Cramer's rule.

</details>

### Module 4: Vector Spaces

__Topics covered:__ (§4.1) Vector spaces and subspaces, (§4.2) Spanning sets, (§4.4) Linear independence and dependence, (§4.5) Basis and dimension, (§4.7) General vector spaces, (§4.8) Subspaces, (§4.9) Coordinatization, (§4.11) Four fundamental subspaces, (§4.12) Rank and nullity.

<details>
<summary>MATLAB Programming Labs</summary>

* [lab_4.3.m](./labs/mod4/lab_4.3.m): On the span of a matrix, construction a matrix from vectors, and working out its pivot columns with ``rref(Matrix)`` (along with an example with an augmented matrix).
* [lab_4.6.m](./labs/mod4/lab_4.6.m): On the basis of a matrix: like with the previous lab, creating a matrix from vectors, and computing its basis matrix by augmenting the matrix and ``eye(dimensions of given matrix)``, reducing the ``[Matrix | eye(dims)]`` into its row echelon form, and finally constructing a basis matrix with the inverse of the the first two vectors, and those vectors respective columns from the identity matrix computed by ``eye(dimensions of given matrix)``
* [lab_4.10.m](./labs/mod4/lab_4.10.m): On changing the coordinates of a matrix: doing so by augmenting matrix B and C as ``[C B]``, reducing the augmented matrix to row echelon form via ``rref([C B])``, and then working out the change of coordinates with the appropriate columns from the ``rref([C B])`` matrix. 
* [lab_4.13.m](./labs/mod4/lab_4.13.m): On the rank and null of a matrix via the ``rank()`` and ``null()`` functions. 

</details>

### Module 5: Linear Transformations

__Topics covered:__ (§5.1) Linear transformations between Euclidean spaces, (§5.3) General linear transformations, (§5.4) Isomorphisms, (§5.5) Rank and nullity of a linear transformation, (§5.6) Composition of linear transformations, (§5.7) Change of bases and matrices of linear transformations, (§5.9) Applications of transformations to 2D coordinate geometry.

<details>
<summary>MATLAB Programming Labs</summary>

* [lab_5.2.m](./labs/mod5/lab_5.2.m): On linear transformations by rotating a standard matrix 60-degrees counterclockwise, and multiplying said rotated matrix by another matrix containing its triangular coordinates represented by the columns. A plot of the triangular coordinates are plotted against their respective transforms with the built-in ``plot()`` function.
* [lab_5.8.m](./labs/mod5/lab_5.8.m): On the changing of basis: procedure involves augmenting matrix ``C`` and matrix ``B``, and then performing a row reduction to echelon form where the cells are to be formatted as ratios. Relevant cells in its transform is later displayed.

</details>

### Module 6: Eigenvalues and Eigenvectors

__Topics covered:__ (§6.1) Eigenvalues and Eigenvectors, (§6.3) Eigenspaces, (§6.4) Similarity and diagonalization, (§6.6) Complex eigenvalues and eigenvectors, (§6.7) Applications to Inertia tensors.

<details>
<summary>MATLAB Programming Labs</summary>

* [lab_6.2.m](./labs/mod6/lab_6.2.m): Demonstration of Eigenvalue and Eigenvector problems: the identification of eigenvalues of a matrix with the built-in ``poly(Matrix)`` command, the identification of eigenvalues of a matrix with the built-in ``roots(Matrix)`` command, and finally the construction of an eigenvector matrix with the built-in ``eig(eigenvalues)`` command. 
* [lab_6.5.m](./labs/mod6/lab_6.5.m): On diagonalization: its demonstration by the use of the ``eig(Matrix)`` to find a matrix that diagonalizes the input matrix, and another matrix that is the resulting diagonal. 

</details>

### Module 7: Inner Product Spaces

__Topics covered:__ (§7.1) Inner product spaces, (§7.2) Norms and distances, (§7.4) Orthogonal bases, (§7.5) Orthogonal complements, (§7.6) Orthogonal matrices, (§7.8) Singular Value Decomposition, or "SVD."

<details>
<summary>MATLAB Programming Labs</summary>

* [lab_7.3.m](./labs/mod7/lab_7.3.m): On norms and distances: the application of the built-in ``norm()`` function to work out the 2-norm distance between the difference of two vectors: ``norm(u - v, 2)``, and the application  of the very same ``norm()`` function to find the Frobenius norm of two matrices: ``norm(A - B, 'fro')``.
* [lab_7.7.m](./labs/mod7/lab_7.7.m): On QR factorization: the application of the ``qr(B)`` to run a QR-factorization of an arbitrary matrix, and checking it by multiplying the resulting orthogonal matrix by the resulting upper triangular matrix.
* [lab_7.9.m](./labs/mod7/lab_7.9.m): On the Singular Value Decomposition: the use of the ``svd()`` function to work out the singular value decomposition of an arbitrary matrix, and checking the results by computing the ``U*S*V.'``, which is the product of the three components of an SVD, with the latter ``n × n`` SVD matrix being transposed, of course. 

</details>

### Module 8: Additional Topics

[todo]

## Resources

### MATLAB Reference Sheet

<a href="./img/matlab-cheatsheet.pdf"><img src="./img/matlab-cheatsheet.png" width="650px" /></a>

