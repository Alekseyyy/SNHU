/*
Enter your query here.
*/

SELECT DISTINCT city 
FROM station
WHERE
    city LIKE "%A"
    OR city LIKE "%E"
    OR city LIKE "%I"
    OR city LIKE "%O"
    OR city LIKE "%U";

