-- 코드를 작성해주세요
with MAX_FISH as (
    select
        fi.FISH_TYPE,
        MAX(fi.LENGTH) as LENGTH,
        fni.FISH_NAME
    from FISH_INFO fi
    join FISH_NAME_INFO fni
    on fi.FISH_TYPE = fni.FISH_TYPE
    group by fi.FISH_TYPE
)
select 
    fi.ID,
    mf.FISH_NAME,
    mf.LENGTH
from MAX_FISH mf
join FISH_INFO fi
on mf.FISH_TYPE = fi.FISH_TYPE
where fi.LENGTH = mf.LENGTH
order by fi.ID;