# Write your MySQL query statement below
select s.student_id, s.student_name, s1.subject_name, count(e.student_id) as attended_exams
from Students as s 
cross join Subjects s1 
left join examinations as e on s.student_id=e.student_id and s1.subject_name=e.subject_name
group by s.student_id, s.student_name, s1.subject_name
order by s.student_id,s1.subject_name