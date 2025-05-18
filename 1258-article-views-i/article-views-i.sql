# Write your MySQL query statement below
Select Distinct viewer_id  as id from Views
where author_id=viewer_id
Order by viewer_id Asc