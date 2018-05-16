# Write your MySQL query statement below
SELECT 
FROM Employee e1 JOIN Department d ON e1.DepartmentId = d.Id
WHERE(
    3 > (SELECT count(distinct e2.Salary)
         FROM Employee e2
         WHERE e2.Salary > e1.Salary 
         AND e2.DepartmentId = e1.DepartmentId)
);