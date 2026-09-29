/**
식품분류별 가격이 제일 비싼 식품
*/
with MAXFOOD as (
    select 
        fp.CATEGORY,
        MAX(fp.PRICE) as PRICE
    from FOOD_PRODUCT fp
    where fp.CATEGORY in ('과자', '국', '김치', '식용유')
    group by fp.CATEGORY
)
select
    fp.CATEGORY,
    fp.PRICE,
    fp.PRODUCT_NAME
from FOOD_PRODUCT fp
join MAXFOOD mf
on fp.CATEGORY = mf.CATEGORY
where fp.PRICE = mf.PRICE
order by fp.PRICE desc;