-- 코드를 입력하세요
select ons.SALES_DATE, ons.PRODUCT_ID, ons.USER_ID, ons.SALES_AMOUNT
from ONLINE_SALE ons
where ons.SALES_DATE like '2022-03%'
union
select ons.SALES_DATE, ons.PRODUCT_ID, null as USER_ID, ons.SALES_AMOUNT
from OFFLINE_SALE ons
where ons.SALES_DATE like '2022-03%'
order by SALES_DATE, PRODUCT_ID, USER_ID;