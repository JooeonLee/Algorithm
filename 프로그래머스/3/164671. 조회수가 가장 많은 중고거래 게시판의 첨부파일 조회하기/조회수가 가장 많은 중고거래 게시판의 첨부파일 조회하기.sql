-- 코드를 입력하세요
select concat("/home/grep/src/", ugb.BOARD_ID, "/", ugf.FILE_ID, ugf.FILE_NAME, ugf.FILE_EXT) as FILE_PATH
from USED_GOODS_BOARD ugb
join USED_GOODS_FILE ugf
using(BOARD_ID)
where ugb.VIEWS = (
    select max(VIEWS) 
    from USED_GOODS_BOARD
)
order by ugf.FILE_ID desc;