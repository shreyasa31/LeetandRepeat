# Write your MySQL query statement below
select project_id, Round(sum(experience_years)/count(a.employee_id),2) as average_years

from Project as a
inner join Employee as b
on a.employee_id=b.employee_id
group by project_id