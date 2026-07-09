-- 코드를 입력하세요
select ol.SALES_DATE, ol.PRODUCT_ID, ol.USER_ID, ol.SALES_AMOUNT
from ONLINE_SALE ol
where ol.SALES_DATE like '2022-03%'
union
select fl.SALES_DATE, fl.PRODUCT_ID, NULL as USER_ID, fl.SALES_AMOUNT
from OFFLINE_SALE fl
where fl.SALES_DATE like '2022-03-%'
order by SALES_DATE asc, PRODUCT_ID asc, USER_ID asc;