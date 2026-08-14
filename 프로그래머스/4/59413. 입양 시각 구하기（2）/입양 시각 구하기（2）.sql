with recursive HOURS as(
    select 0 as HOUR
    
    union all 
    
    select HOUR+1
    from HOURS
    where HOUR < 23
)
select
    h.HOUR,
    count(ao.ANIMAL_ID) as `COUNT`
from HOURS h
left join ANIMAL_OUTS ao
on h.HOUR = hour(ao.DATETIME)
group by h.HOUR
order by HOUR;