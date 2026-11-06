-- 코드를 작성해주세요
select d.ID,
    d.EMAIL,
    d.FIRST_NAME,
    d.LAST_NAME
from developers d
where (
    select bit_or(s.CODE)
    from SKILLCODES s
    where s.CATEGORY = 'Front End'
) & d.SKILL_CODE != 0
order by d.ID asc;