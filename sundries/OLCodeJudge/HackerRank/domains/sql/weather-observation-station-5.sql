/*
Enter your query here.
*/

SELECT CITY, LENGTH(CITY) FROM STATION WHERE LENGTH(CITY) IN (
    SELECT MAX(LENGTH(CITY)) FROM STATION
    UNION
    SELECT MIN(LENGTH(CITY)) FROM STATION
) ORDER BY LENGTH(CITY) DESC, CITY ASC LIMIT 2;

