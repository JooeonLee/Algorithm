select
    c.CAR_ID,
    case 
        when
            max(
                '2022-10-16' between c.START_DATE and c.END_DATE
            ) = 1
        then '대여중'
    else '대여 가능'
    end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY c
group by c.CAR_ID
order by c.CAR_ID desc;