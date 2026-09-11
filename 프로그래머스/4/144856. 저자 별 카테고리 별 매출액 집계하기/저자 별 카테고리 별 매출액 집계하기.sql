-- 코드를 입력하세요
select
    b.AUTHOR_ID,
    a.AUTHOR_NAME,
    b.CATEGORY,
    sum(bs.SALES * b.PRICE) as TOTAL_SALES
from BOOK b
join BOOK_SALES bs
on b.BOOK_ID = bs.BOOK_ID
join AUTHOR a
on b.AUTHOR_ID = a.AUTHOR_ID
where bs.SALES_DATE >= '2022-01-01' and bs.SALES_DATE <= '2022-01-31'
group by b.CATEGORY, b.AUTHOR_ID
order by b.AUTHOR_ID, b.CATEGORY desc;
