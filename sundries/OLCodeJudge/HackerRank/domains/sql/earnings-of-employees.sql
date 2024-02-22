
/*
 * Domain: SQL
 * A solution to "Top Earners"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted circa 2021
 *   Link: https://www.hackerrank.com/challenges/earnings-of-employees/problem
 */

/*
Enter your query here.
*/

SELECT
    MAX(salary * months), COUNT(*)
FROM Employee
WHERE
    (salary * months) = (
        SELECT MAX(salary * months) 
        FROM Employee
    );

