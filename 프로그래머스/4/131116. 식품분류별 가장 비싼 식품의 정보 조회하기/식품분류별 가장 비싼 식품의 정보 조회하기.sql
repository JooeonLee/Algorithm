/**
식품분류별 가격이 제일 비싼 식품
*/
select 
    fpo.CATEGORY,
    fpo.PRICE,
    fpo.PRODUCT_NAME
from FOOD_PRODUCT fpo
where (fpo.CATEGORY, fpo.PRICE) in (
    select 
        fp.CATEGORY,
        max(fp.PRICE)
    from FOOD_PRODUCT fp
    where fp.CATEGORY in ('과자', '국', '김치', '식용유')
    group by fp.CATEGORY
)
order by fpo.PRICE desc;
