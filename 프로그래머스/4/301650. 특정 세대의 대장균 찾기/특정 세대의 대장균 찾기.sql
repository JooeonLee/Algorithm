-- 코드를 작성해주세요
with recursive cte as (
    select ID, PARENT_ID, 1 as DEPTH
    from ECOLI_DATA
    where PARENT_ID is null
    
    union all
    
    select e.ID, e.PARENT_ID, c.DEPTH + 1
    from ECOLI_DATA e
    inner join cte c
    on e.PARENT_ID = c.ID
)
select ID
from cte
where cte.DEPTH = 3;