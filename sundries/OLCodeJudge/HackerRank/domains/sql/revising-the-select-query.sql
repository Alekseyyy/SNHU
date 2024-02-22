
/*
 * Domain: SQL
 * A solution to "Revising the Select Query I"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted circa 2021
 *   Link: https://www.hackerrank.com/challenges/revising-the-select-query/problem
 */

/*
 *Enter your query here.
*/

SELECT * 
FROM City 
WHERE 
    Population > 100000 
    AND CountryCode = "USA";
