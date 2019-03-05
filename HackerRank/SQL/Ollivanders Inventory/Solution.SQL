/* MySQL */

SELECT W.id, P.age, W.coins_needed, W.power
FROM Wands AS W
INNER JOIN Wands_Property AS P ON W.code = P.code
WHERE (W.power, P.age, W.coins_needed) IN 
( 
    SELECT W.power, P.age, MIN(W.coins_needed) AS min_price
    FROM Wands AS W
    INNER JOIN Wands_Property AS P ON W.code = P.code
    WHERE P.is_evil = 0
    GROUP BY W.power, P.age
)
Order BY W.power DESC, P.age DESC;