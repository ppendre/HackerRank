/* MySQL */

SELECT CONCAT(name, "(", LEFT(occupation,1), ")")
FROM Occupations
ORDER BY name;

SELECT CONCAT("There are a total of ", COUNT(occupation), " ", LOWER(occupation), "s.")
FROM Occupations
GROUP BY occupation
ORDER BY COUNT(occupation), occupation;
