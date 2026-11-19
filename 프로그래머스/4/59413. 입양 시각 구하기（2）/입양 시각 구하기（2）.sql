-- 코드를 입력하세요
with recursive base as(
    select 0 as HOUR
    
    union all
    
    select
        b.HOUR + 1 
    from base b
    where b.HOUR < 23
)
select
    b.HOUR,
    count(ao.ANIMAL_ID) as COUNT
from base b
left join ANIMAL_OUTS ao
on b.HOUR = hour(ao.DATETIME)
group by b.HOUR
order by b.HOUR