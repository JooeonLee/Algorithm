-- 코드를 입력하세요
select
    ugb.WRITER_ID as USER_ID,
    ugu.NICKNAME,
    concat(ugu.CITY, ' ', ugu.STREET_ADDRESS1, ' ', ugu.STREET_ADDRESS2) as '전체주소',
    concat(substring(ugu.TLNO, 1, 3), '-', substring(ugu.TLNO, 4, 4), '-', substring(ugu.TLNO, 8, 4)) as '전화번호'
from USED_GOODS_BOARD ugb
join USED_GOODS_USER ugu
on ugb.WRITER_ID = ugu.USER_ID
group by ugb.WRITER_ID
having count(*) >= 3
order by ugb.WRITER_ID desc