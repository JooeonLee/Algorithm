-- 코드를 작성해주세요
select parent.ID, count(child.PARENT_ID)  as CHILD_COUNT
from ECOLI_DATA parent
left outer join ECOLI_DATA child
on parent.ID = child.PARENT_ID
group by parent.ID
order by parent.ID asc