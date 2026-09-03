-- 코드를 입력하세요
/**

*/

select
    fp.PRODUCT_ID,
    fp.PRODUCT_NAME,
    sum(fp.PRICE * fo.AMOUNT) as TOTAL_SALES
from FOOD_PRODUCT fp
join FOOD_ORDER fo
on fp.PRODUCT_ID = fo.PRODUCT_ID
where fo.PRODUCE_DATE like '2022-05-%'
group by fp.PRODUCT_ID
order by TOTAL_SALES desc, fp.PRODUCT_ID asc;
