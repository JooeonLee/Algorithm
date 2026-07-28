-- 코드를 입력하세요
with JOIN_TABLE as (
    select 
        fh.FLAVOR,
        fh.TOTAL_ORDER + sum(j.TOTAL_ORDER) as TOTAL
    from FIRST_HALF fh
    join JULY j
    on fh.FLAVOR = j.FLAVOR
    group by fh.FLAVOR
)
select
    jt.FLAVOR
from JOIN_TABLE jt
order by jt.TOTAL desc
limit 3;