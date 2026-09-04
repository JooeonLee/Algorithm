-- 코드를 입력하세요
select
    b.BOOK_ID,
    a.AUTHOR_NAME,
    b.PUBLISHED_DATE
from BOOK b
join AUTHOR a
on b.AUTHOR_ID = a.AUTHOR_ID
where b.CATEGORY = '경제'
order by b.PUBLISHED_DATE asc;
