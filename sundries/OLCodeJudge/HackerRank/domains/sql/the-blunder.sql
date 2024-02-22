/*
Enter your query here.
*/

SELECT
    CEIL(
        AVG(salary)
        - AVG(REPLACE(salary, "0", ""))
    )
FROM EMPLOYEES;

