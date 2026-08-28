-- 코드를 입력하세요
select
    fw.WAREHOUSE_ID,
    fw.WAREHOUSE_NAME,
    fw.ADDRESS,
    case
        when isnull(fw.FREEZER_YN) then 'N'
        else fw.FREEZER_YN
    end as FREEZER_YN
from FOOD_WAREHOUSE fw
where fw.ADDRESS like '%경기도%'
order by fw.WAREHOUSE_ID asc;
