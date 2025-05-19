# Write your MySQL query statement below
select name , bonus
from Employee as a
left join Bonus as b
on a.empId=b.empId
where bonus<1000 or bonus is null;