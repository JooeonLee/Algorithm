-- 코드를 입력하세요
select
    ap.MCDP_CD as '진료과코드',
    count(*) as '5월예약건수'
from APPOINTMENT ap
where month(ap.APNT_YMD) = 5
group by ap.MCDP_CD
order by 5월예약건수, 진료과코드;
