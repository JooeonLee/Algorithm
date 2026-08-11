-- 코드를 입력하세요
/**
식품 분류별로 가격이 제일 비싼 식품의 분류, 가격, 이름 조회

식품 분류별로 가격이 제일 비싼 것 추출
이걸 CTE로 나타내고 CTE의 ID를 이용해서 이름 조회
**/
with MPT as (
    select 
        max(fp.PRICE) as MAX_PRICE,
        fp.CATEGORY
    from FOOD_PRODUCT fp
    group by fp.CATEGORY
)
select
    MPT.CATEGORY,
    MPT.MAX_PRICE,
    fp.PRODUCT_NAME
from MPT
join FOOD_PRODUCT fp
on MPT.CATEGORY = fp.CATEGORY and MPT.MAX_PRICE = fp.PRICE 
where MPT.CATEGORY in ('과자', '국', '김치', '식용유')
order by MPT.MAX_PRICE desc;
