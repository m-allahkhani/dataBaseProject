-- updating salespermonth table

update salespermonth
set sales_date = '1399-03-25'
where sales_date = '1390-04-26' and idStaff = 4014;

update salespermonth
set sales_date = '1399-03-25'
where sales_date = '1399-07-27' and idStaff = 4015;

update salespermonth
set sales_date = '1399-03-25'
where sales_date = '1399-09-25' and idStaff = 4016;


insert into salespermonth
values (4017, '1399-02-25',2555000000),
(4017 , '1399-03-25',1555000000),

 (4018, '1399-02-25',1234000000),
(4018 , '1399-03-25',2225000000),

 (4019, '1399-02-25',3005000000),
(4019 , '1399-03-25',905000000),

 (4020, '1399-02-25',395000000),
(4020 , '1399-03-25',1925000000),

 (4021, '1399-02-25',2335000000),
(4021 , '1399-03-25',1705000000),

 (4022, '1399-02-25',2111000000),
(4022 , '1399-03-25',1965000000)
;