# Write your MySQL query statement below
delete
  from Person
  where id not in (select * from (SELECT MIN(id) 
  FROM Person GROUP BY email) a )