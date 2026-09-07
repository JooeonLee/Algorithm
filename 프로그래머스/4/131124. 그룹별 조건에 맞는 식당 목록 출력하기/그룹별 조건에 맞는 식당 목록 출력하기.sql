-- 코드를 입력하세요
/**

*/
with max_id as (
        select rr.MEMBER_ID,
            count(*) as REVIEW_CNT
        from REST_REVIEW rr
        group by rr.MEMBER_ID
        order by REVIEW_CNT desc
        limit 1
)
select
    mp.MEMBER_NAME,
    re.REVIEW_TEXT,
    re.REVIEW_DATE
from max_id
join MEMBER_PROFILE mp
on max_id.MEMBER_ID = mp.MEMBER_ID
join REST_REVIEW re
on mp.MEMBER_ID = re.MEMBER_ID
order by REVIEW_DATE asc, REVIEW_TEXT asc;