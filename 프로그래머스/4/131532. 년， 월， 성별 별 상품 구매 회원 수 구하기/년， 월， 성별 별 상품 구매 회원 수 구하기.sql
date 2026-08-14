-- 코드를 입력하세요
/**
GENDER 컬럼 처리 null, 0, 1

*/
with cte as(
    select 
        *,
        year(os.SALES_DATE) as YEAR,
        month(os.SALES_DATE) as MONTH
    from ONLINE_SALE os
)
select
    cte.YEAR,
    cte.MONTH,
    ui.GENDER,
    count(distinct cte.USER_ID) as USERS
from USER_INFO ui
join cte
on ui.USER_ID = cte.USER_ID
where ui.GENDER is not null
group by cte.YEAR, cte.MONTH, ui.GENDER
order by YEAR, MONTH, GENDER;