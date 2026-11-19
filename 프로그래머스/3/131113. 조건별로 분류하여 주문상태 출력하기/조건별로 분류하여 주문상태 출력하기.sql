-- 코드를 입력하세요
/**

*/
select
    fo.ORDER_ID,
    fo.PRODUCT_ID,
    # ifnull(fo.OUT_DATE, '') as OUT_DATE,
    fo.OUT_DATE,
    case
        when fo.OUT_DATE is null then '출고미정'
        when fo.OUT_DATE > '2022-05-01' then '출고대기'
        else '출고완료'
    end as '출고여부'
from FOOD_ORDER fo
order by fo.ORDER_ID;