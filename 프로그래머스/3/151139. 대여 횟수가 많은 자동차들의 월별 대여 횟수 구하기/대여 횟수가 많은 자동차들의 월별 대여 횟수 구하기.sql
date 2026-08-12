-- 코드를 입력하세요
/**

*/
# with MONTH_CTE as (
#     select
#         *,
#         case
#             when START_DATE between '2022-08-01' and '2022-08-31' then 8
#             when START_DATE between '2022-09-01' and '2022-09-30' then 9
#             when START_DATE between '2022-10-01' and '2022-10-31' then 10
#             else 0
#         end as MONTH
#     from CAR_RENTAL_COMPANY_RENTAL_HISTORY crcrh
# ),
# MONTH_CNT as (
#     select
#         CAR_ID
#     from MONTH_CTE
#     group by MONTH
#     having count(*) >= 5
# )
# select 
#     MONTH_CNT.MONTH,
#     CAR_ID,
#     MONTH_CNT.RECORD
# from MONTH_CTE
# join MONTH_CNT
# on MONTH_CTE.MONTH = MONTH_CNT.CAR_ID
# where MONTH_CNT.RECORD >= 5
# group by MONTH, CAR_ID
# order by MONTH asc, CAR_ID desc;

WITH MONTH_CTE AS (
    SELECT
        *,
        CASE
            WHEN START_DATE BETWEEN '2022-08-01' AND '2022-08-31' THEN 8
            WHEN START_DATE BETWEEN '2022-09-01' AND '2022-09-30' THEN 9
            WHEN START_DATE BETWEEN '2022-10-01' AND '2022-10-31' THEN 10
        END AS MONTH
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
),
CAR_CNT AS (
    SELECT
        CAR_ID
    FROM MONTH_CTE
    GROUP BY CAR_ID
    HAVING COUNT(*) >= 5
)
SELECT
    mc.MONTH,
    mc.CAR_ID,
    COUNT(*) AS RECORDS
FROM MONTH_CTE mc
JOIN CAR_CNT cc
    ON mc.CAR_ID = cc.CAR_ID
GROUP BY mc.MONTH, mc.CAR_ID
ORDER BY mc.MONTH ASC, mc.CAR_ID DESC;