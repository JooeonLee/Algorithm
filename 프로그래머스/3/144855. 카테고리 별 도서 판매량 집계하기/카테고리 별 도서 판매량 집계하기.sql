-- 코드를 입력하세요
select b.CATEGORY, sum(v.TOTAL_SALES) as TOTAL_SALES 
from BOOK b
join
(select BOOK_ID, sum(SALES) as TOTAL_SALES
from BOOK_SALES
where SALES_DATE like '2022-01%'
group by BOOK_ID) v
on b.BOOK_ID = v.BOOK_ID
group by b.CATEGORY
order by b.CATEGORY asc;
