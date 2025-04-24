-- 코드를 입력하세요
SELECT a.ANIMAL_ID ANIMAL_ID, a.ANIMAL_TYPE ANIMAL_TYPE, a.NAME NAME from ANIMAL_INS a, ANIMAL_OUTS b 
where a.ANIMAL_ID = b.ANIMAL_ID 
and SEX_UPON_INTAKE in ('Intact Male','Intact Female') 
and SEX_UPON_OUTCOME in ('Neutered Male','Spayed Female')
order by ANIMAL_ID;