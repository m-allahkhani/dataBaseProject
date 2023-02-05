SELECT * FROM project_fas3.pricerecord;
select count(*) 
from  pricerecord 
where '1401-04-01'<= PR_date <='1401-04-30'and idProduct='1234'