-- 코드를 작성해주세요
# select *
# from ITEM_INFO ii
# join ITEM_TREE it
# on ii.ITEM_ID = it.ITEM_ID
# where 

select 
    ii.ITEM_ID,
    ii.ITEM_NAME,
    ii.RARITY
from ITEM_INFO ii
where ii.ITEM_ID not in(
    select PARENT_ITEM_ID
    from ITEM_TREE it
    group by it.PARENT_ITEM_ID
    having PARENT_ITEM_ID is not null
)
order by ii.ITEM_ID desc;