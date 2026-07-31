-- 코드를 작성해주세요
select sum(ii.PRICE)
from ITEM_INFO ii
group by ii.RARITY
having ii.RARITY = 'LEGEND';