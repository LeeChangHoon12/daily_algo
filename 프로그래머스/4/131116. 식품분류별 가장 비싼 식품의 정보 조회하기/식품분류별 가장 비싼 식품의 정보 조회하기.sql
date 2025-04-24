select CATEGORY,price as MAX_PRICE, PRODUCT_NAME from FOOD_PRODUCT 
where price in (select max(price) price from FOOD_PRODUCT group by category)
and category in ('과자','국','김치','식용유')
order by MAX_PRICE desc;