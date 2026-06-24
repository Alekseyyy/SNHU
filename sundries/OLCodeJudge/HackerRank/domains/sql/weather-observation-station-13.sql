/*
Enter your query here.
*/

SELECT ROUND(SUM(LAT_N), 4)
FROM station
WHERE
    LAT_N > 38.7880
    AND LAT_N < 137.2345;

