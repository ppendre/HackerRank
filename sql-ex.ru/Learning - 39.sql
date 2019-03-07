/* Problem Description: 
	Find the ships that `survived for future battles`; that is, after being damaged in a battle,
	they participated in another one, which occurred later.
*/

/* MySQL */

SELECT DISTINCT O.ship
FROM Outcomes O
INNER JOIN Battles B ON B.name = O.battle
WHERE O.result = 'damaged' 
  AND EXISTS
   (SELECT O1.ship
    FROM Outcomes O1
    INNER JOIN Battles B1 ON B1.name = O1.battle   
    WHERE O.ship = O1.ship AND B1.date > B.date
   )

