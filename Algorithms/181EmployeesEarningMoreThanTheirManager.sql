# Write your MySQL query statement below
SELECT a.Name as Employee
FROM Employee a
WHERE a.Salary > (SELECT e.Salary FROM Employee e Where a.ManagerId = e.Id);