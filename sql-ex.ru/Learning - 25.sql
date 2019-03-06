/* Problem Description: 
	Find the printer makers also producing PCs with the lowest RAM capacity and 
	the highest processor speed of all PCs having the lowest RAM capacity.
	Result set: maker. 
*/

/* MySQL */

WITH Max_Speed As (
  SELECT MAX(speed) AS speed
  FROM Pc
  WHERE ram IN (
    SELECT MIN(ram)
    From pc
  )
)

SELECT P.maker
FROM Product P
INNER JOIN Pc ON Pc.model = P.model
WHERE Pc.speed IN (SELECT speed 
                   FROM Max_Speed)
      AND ram IN (SELECT MIN(ram)
                  From pc)

INTERSECT

SELECT maker
From Product
WHERE type = 'Printer'
