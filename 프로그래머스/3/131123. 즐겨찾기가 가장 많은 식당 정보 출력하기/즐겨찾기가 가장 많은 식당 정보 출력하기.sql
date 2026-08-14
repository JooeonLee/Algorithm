-- 코드를 입력하세요
with cte as(
    select
        ri.FOOD_TYPE,
        max(ri.FAVORITES) as MAX_FAVORITES
    from REST_INFO ri
    group by ri.FOOD_TYPE
)
select
    ri.FOOD_TYPE,
    ri.REST_ID,
    ri.REST_NAME,
    ri.FAVORITES
from REST_INFO ri
join cte
on ri.FOOD_TYPE=cte.FOOD_TYPE and ri.FAVORITEs=cte.MAX_FAVORITES
order by ri.FOOD_TYPE desc;