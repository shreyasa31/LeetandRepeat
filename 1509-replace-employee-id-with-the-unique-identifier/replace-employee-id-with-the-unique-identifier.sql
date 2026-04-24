# Write your MySQL query statement below
select e2.unique_id,e1.name
from Employees as e1
Left Join EmployeeUNI as e2 On e1.id=e2.id;