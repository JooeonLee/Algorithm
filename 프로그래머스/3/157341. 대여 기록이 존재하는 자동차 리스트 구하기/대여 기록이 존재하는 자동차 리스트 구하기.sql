-- 코드를 입력하세요
/*
options 컬럼에서 세단 구분 필요
how? -> like 떠올림, 더 좋은 방법?
*/
select
    distinct(crcrh.CAR_ID)
from CAR_RENTAL_COMPANY_RENTAL_HISTORY crcrh
join CAR_RENTAL_COMPANY_CAR crcc
on crcrh.CAR_ID = crcc.CAR_ID
where month(crcrh.START_DATE) = 10
and crcc.CAR_TYPE = '세단'
order by CAR_ID desc;