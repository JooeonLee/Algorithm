-- 코드를 작성해주세요
select
    fio.ID,
    fn.FISH_NAME,
    fio.LENGTH
from FISH_INFO fio
join FISH_NAME_INFO fn
on fio.FISH_TYPE = fn.FISH_TYPE
where (fio.FISH_TYPE, fio.LENGTH) in (
    select 
    fi.FISH_TYPE,
    max(fi.LENGTH) as MAX_L
    from FISH_INFO fi
    group by fi.FISH_TYPE
)
order by fio.ID asc;
