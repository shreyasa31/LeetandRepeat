# Write your MySQL query statement below
select query_name, round(avg(rating/position),2) as quality,round(SUM(if (rating < 3 ,1,0))*100 / COUNT(rating),2) as poor_query_percentage 
from Queries as q
group by query_name
