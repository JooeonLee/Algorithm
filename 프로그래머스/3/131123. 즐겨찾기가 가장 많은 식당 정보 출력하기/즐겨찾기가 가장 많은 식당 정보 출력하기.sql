-- 코드를 입력하세요
/**

*/
select
    rio.FOOD_TYPE,
    rio.REST_ID,
    rio.REST_NAME,
    rio.FAVORITES
from REST_INFO rio
where (rio.FOOD_TYPE, rio.FAVORITES) in (
    select
        rii.FOOD_TYPE,
        max(rii.FAVORITES)
    from REST_INFO rii
    group by rii.FOOD_TYPE)
order by rio.FOOD_TYPE desc;