-- 코드를 입력하세요
SELECT a.AUTHOR_ID, a.AUTHOR_NAME, CATEGORY, sum(b.PRICE * s.SALES) TOTAL_SALES FROM BOOK b, author a, book_sales s
where 
    b.AUTHOR_ID = a.AUTHOR_ID 
and 
    b.BOOK_ID = s.BOOK_ID
and
    month(SALES_DATE) = '1'
and 
    year(SALES_DATE) = '2022'
group by a.AUTHOR_ID,CATEGORY
order by a.AUTHOR_ID, CATEGORY desc;