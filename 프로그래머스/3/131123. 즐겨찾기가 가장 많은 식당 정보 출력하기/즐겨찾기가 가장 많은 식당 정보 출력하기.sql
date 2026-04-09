-- 코드를 입력하세요
select
    rf.FOOD_TYPE,
    rf.REST_ID,
    rf.REST_NAME,
    rf.FAVORITES
from REST_INFO rf
join
    (
        select FOOD_TYPE,
            max(FAVORITES) as FAVORITES
        from REST_INFO
        group by FOOD_TYPE
    ) m
on m.FOOD_TYPE = rf.FOOD_TYPE and m.FAVORITES = rf.FAVORITES
order by rf.FOOD_TYPE desc;