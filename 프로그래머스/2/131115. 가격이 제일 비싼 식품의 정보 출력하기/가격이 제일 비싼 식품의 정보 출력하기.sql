-- 코드를 입력하세요
SELECT fp.PRODUCT_ID,
        fp.PRODUCT_NAME,
        fp.PRODUCT_CD,
        fp.CATEGORY,
        fp.PRICE
from FOOD_PRODUCT fp
where fp.PRICE = (select max(PRICE) from FOOD_PRODUCT);