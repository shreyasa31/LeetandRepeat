# Write your MySQL query statement below
select query_name, round(sum(rating/position)/count(query_name),2) as quality, 
round(SUM(CASE WHEN rating < 3 THEN 1 ELSE 0 END) * 1.0 / COUNT(rating) * 100,2) as poor_query_percentage
from Queries
group by query_name
/*u cant put select inside sum*/