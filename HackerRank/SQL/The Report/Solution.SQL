/* MySQL */

SELECT IF(Grades.grade >= 8, Students.name, NULL), Grades.grade, Students.marks
FROM Grades, Students
WHERE Students.marks BETWEEN Grades.min_mark AND Grades.max_mark
ORDER BY Grades.grade DESC, Students.name, Students.marks;