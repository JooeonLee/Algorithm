-- 코드를 입력하세요
select
    ao.ANIMAL_ID,
    ao.NAME
from ANIMAL_OUTS ao
where not exists(
    select 1
    from ANIMAL_INS ai
    where ai.ANIMAL_ID = ao.ANIMAL_ID
)
order by ANIMAL_ID;