-- 코드를 작성해주세요
with MAX_LENGTH_INFO as (
    select fi.FISH_TYPE,
        fni.FISH_NAME,
        max(fi.LENGTH) as LENGTH
    from FISH_INFO fi
    join FISH_NAME_INFO fni
    on fi.FISH_TYPE = fni.FISH_TYPE
    group by fi.FISH_TYPE
    order by fi.ID
)
select 
    fi.ID,
    mli.FISH_NAME,
    mli.LENGTH
from MAX_LENGTH_INFO mli
join FISH_INFO fi
on mli.FISH_TYPE = fi.FISH_TYPE
where fi.LENGTH = mli.LENGTH
order by fi.ID;