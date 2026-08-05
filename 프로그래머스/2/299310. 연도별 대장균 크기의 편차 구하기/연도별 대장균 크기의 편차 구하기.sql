-- 코드를 작성해주세요
with MAX_YEAR as (
    select 
        YEAR(ed.DIFFERENTIATION_DATE) as YEAR,
        MAX(ed.SIZE_OF_COLONY) as MAX_COLONY
    from ECOLI_DATA ed
    group by substr(ed.DIFFERENTIATION_DATE, 1, 4)
)
select
    YEAR(ed.DIFFERENTIATION_DATE) as YEAR,
    my.MAX_COLONY - ed.SIZE_OF_COLONY as YEAR_DEV,
    ed.ID
from ECOLI_DATA ed
join MAX_YEAR my
on substr(ed.DIFFERENTIATION_DATE, 1, 4) = my.YEAR
order by YEAR asc, YEAR_DEV asc