-- 코드를 입력하세요
select os.USER_ID, os.PRODUCT_ID
from ONLINE_SALE os
group by os.USER_ID, os.PRODUCT_ID
having count(*) >= 2
order by os.USER_ID, os.PRODUCT_ID desc;
