
/*
 * Domain: SQL
 * A solution to "Top Earners"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted circa 2021
 *   Link: https://www.hackerrank.com/challenges/revising-the-select-query-2/problem
 */

SELECT Name 
FROM City 
WHERE 
    Population > 120000 
    AND CountryCode = "USA";

