/* Problem Description: 
	Under the assumption that receipts of money (inc) and payouts (out) are 
	registered not more than once a day for each collection point 
	[i.e. the primary key consists of (point, date)], write a query displaying 
	cash flow data (point, date, income, expense).
	Use Income_o and Outcome_o tables. 
*/

/* MySQL */

SELECT I.point, I.date, I.inc AS income, O.out AS expense
FROM Income_o I
LEFT JOIN Outcome_o O ON I.point = O.point AND I.date = O.date

UNION

SELECT O.point, O.date, I.inc AS income, O.out AS expense
FROM Outcome_o O
LEFT JOIN Income_o I ON I.point = O.point AND I.date = O.date