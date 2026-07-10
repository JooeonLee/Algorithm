-- 코드를 작성해주세요
select ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO
where ITEM_ID in
(select it.ITEM_ID
from ITEM_INFO ii
join ITEM_TREE it
on ii.ITEM_ID = it.PARENT_ITEM_ID
where ii.RARITY = 'RARE')
order by ITEM_ID desc;