-- 코드를 입력하세요
select CAR_TYPE, COUNT(CAR_ID) as CARS
from CAR_RENTAL_COMPANY_CAR
where FIND_IN_SET('통풍시트', OPTIONS) > 0
    or FIND_IN_SET('열선시트', OPTIONS) > 0
    or FIND_IN_SET('가죽시트', OPTIONS) > 0
group by CAR_TYPE
order by CAR_TYPE asc;
