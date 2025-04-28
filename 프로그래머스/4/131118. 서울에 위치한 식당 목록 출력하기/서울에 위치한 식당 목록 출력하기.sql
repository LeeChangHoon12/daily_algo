-- 코드를 입력하세요
SELECT i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS, round(AVG(r.REVIEW_SCORE),2) SCORE from REST_INFO i, REST_REVIEW r 
where 
    i.REST_ID = r.REST_ID
and 
    i.ADDRESS like '서울%'
group by i.REST_NAME 
order by SCORE desc,FAVORITES desc;