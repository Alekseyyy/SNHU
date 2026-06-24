/*
Enter your query here.
*/

SELECT Name
FROM Students
WHERE
    Marks > 75
    ORDER BY 
        RIGHT(Name, 3) ASC,
        id ASC

