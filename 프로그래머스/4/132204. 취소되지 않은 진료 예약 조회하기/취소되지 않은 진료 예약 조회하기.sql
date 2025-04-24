-- 코드를 입력하세요
SELECT APNT_NO, PT_NAME, c.PT_NO, c.MCDP_CD, DR_NAME, APNT_YMD from PATIENT  a, DOCTOR b, APPOINTMENT c 
where a.PT_NO = c.PT_NO
and b.DR_ID = c.MDDR_ID
and month(APNT_YMD) = 4
and year(APNT_YMD) = 2022
and day(APNT_YMD) = 13
and APNT_CNCL_YN = 'N'
order by APNT_YMD;