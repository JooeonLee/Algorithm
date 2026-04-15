-- 코드를 입력하세요
select re.REST_ID, re.REST_NAME, re.FOOD_TYPE, re.FAVORITES, re.ADDRESS, round(rr.SCORE, 2) as SCORE
from REST_INFO re
join (
    select rr.REST_ID, avg(rr.REVIEW_SCORE) as SCORE
    from REST_REVIEW rr
    group by rr.REST_ID
) rr
on re.REST_ID = rr.REST_ID
where re.ADDRESS like '서울%'
order by rr.SCORE desc, re.FAVORITES desc;