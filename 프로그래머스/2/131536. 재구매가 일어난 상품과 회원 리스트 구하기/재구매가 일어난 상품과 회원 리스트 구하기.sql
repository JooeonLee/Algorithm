-- 코드를 입력하세요
select ol.USER_ID, ol.PRODUCT_ID
from ONLINE_SALE ol
group by ol.USER_ID, ol.PRODUCT_ID
having count(*) > 1
order by ol.USER_ID asc, ol.PRODUCT_ID desc;