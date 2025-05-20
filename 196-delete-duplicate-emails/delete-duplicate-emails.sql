# Write your MySQL query statement below
WITH duplicates AS (
  SELECT *,
         ROW_NUMBER() OVER (PARTITION BY email ORDER BY id) AS rn
  FROM Person
)
delete from Person
where id in (select id from duplicates where rn>1)
