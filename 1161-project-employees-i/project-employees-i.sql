# Write your MySQL query statement below
Select project_id, round(AVG(experience_years),2) as average_years
from Project as p
inner join employee as e on e.employee_id=p.employee_id
group by project_id