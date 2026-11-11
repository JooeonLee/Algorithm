select
    c.CAR_ID,
    c.CAR_TYPE,
    FLOOR(c.DAILY_FEE * 30 * (100 - p.DISCOUNT_RATE) / 100) AS FEE
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
on c.CAR_TYPE = p.CAR_TYPE
and p.DURATION_TYPE = '30일 이상'
where c.CAR_TYPE IN ('세단', 'SUV')
and not exists (
    select 1
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    where h.CAR_ID = c.CAR_ID
    and h.START_DATE <= '2022-11-30'
    and h.END_DATE >= '2022-11-01'
)
having FEE >= 500000 and FEE < 2000000
order by FEE desc, CAR_TYPE asc, CAR_ID desc;