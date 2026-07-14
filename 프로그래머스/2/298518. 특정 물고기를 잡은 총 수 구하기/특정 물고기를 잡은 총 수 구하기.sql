-- 코드를 작성해주세요
select count(*) as FISH_COUNT
from FISH_INFO fi
join FISH_NAME_INFO fni
on fi.FISH_TYPE = fni.FISH_TYPE
where fni.FISH_NAME in ('BASS', 'SNAPPER');