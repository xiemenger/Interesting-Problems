# Write your MySQL query statement below
SELECT FirstName, LastName, City, State FROM Person left JOIN Address on Person.PersonId = Address.PersonId;