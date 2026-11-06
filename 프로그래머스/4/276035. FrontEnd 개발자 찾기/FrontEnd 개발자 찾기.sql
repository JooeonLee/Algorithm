-- 코드를 작성해주세요
select d.ID,
    d.EMAIL,
    d.FIRST_NAME,
    d.LAST_NAME
from developers d
where exists(
    select 1
    from skillcodes s
    where category = 'Front End'
    and d.skill_code & s.code = s.code
)
order by d.ID asc;