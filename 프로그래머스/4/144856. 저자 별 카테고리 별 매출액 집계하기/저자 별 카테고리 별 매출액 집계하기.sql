-- 코드를 입력하세요
/*
2022년 1월의 도서 판매 데이터 기준
between '2022-01-01' and '2022-01-31'

저자별, 카테고리별 총액
group by AUTHOR_ID, CATEGORY
*/
select b.AUTHOR_ID,
    a.AUTHOR_NAME,
    b.CATEGORY,
    sum(b.PRICE * bs.SALES) as TOTALPRICE
from BOOK b
join AUTHOR a
on b.AUTHOR_ID = a.AUTHOR_ID
join BOOK_SALES bs
on b.BOOK_ID = bs.BOOK_ID
where bs.SALES_DATE between '2022-01-01' and '2022-01-31'
group by b.AUTHOR_ID, b.CATEGORY
order by b.AUTHOR_ID, b.CATEGORY desc;
