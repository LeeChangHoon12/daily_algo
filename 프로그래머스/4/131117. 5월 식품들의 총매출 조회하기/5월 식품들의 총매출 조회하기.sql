select a.PRODUCT_ID, b.PRODUCT_NAME, sum(amount * price) TOTAL_SALES from FOOD_ORDER a join FOOD_PRODUCT b on a.PRODUCT_ID= b.PRODUCT_ID
where month(PRODUCE_DATE) =5 and year(PRODUCE_DATE) = 2022 group by PRODUCT_ID
order by TOTAL_SALES desc, a.PRODUCT_ID ;