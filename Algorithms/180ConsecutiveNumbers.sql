# Write your MySQL query statement below
SELECT DISTINCT l1.Num as ConsecutiveNums 
FROM Logs l1, 
     Logs l2,
     Logs l3
WHERE l1.id = l2.id - 1
      and l2.id = l3.id - 1
      and l1.Num = l2.Num and l2.Num = l3.Num;