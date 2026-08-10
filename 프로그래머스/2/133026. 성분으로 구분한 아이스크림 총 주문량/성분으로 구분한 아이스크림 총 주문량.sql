-- 코드를 입력하세요
/**

**/
select
    ii.INGREDIENT_TYPE,
    sum(fh.TOTAL_ORDER) as TOTAL_ORDER
from FIRST_HALF fh
join ICECREAM_INFO ii
on fh.FLAVOR = ii.FLAVOR
group by ii.INGREDIENT_TYPE
order by TOTAL_ORDER;