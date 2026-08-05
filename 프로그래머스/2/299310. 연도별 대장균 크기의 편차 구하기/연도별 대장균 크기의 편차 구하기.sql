-- 코드를 작성해주세요
select
    year(ed.DIFFERENTIATION_DATE) as YEAR,
    max(ed.SIZE_OF_COLONY) over (partition by (year(ed.DIFFERENTIATION_DATE))) - ed.SIZE_OF_COLONY as YEAR_DEV,
    ed.ID
from ECOLI_DATA ed
order by YEAR asc, YEAR_DEV asc;