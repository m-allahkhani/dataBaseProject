CREATE DEFINER=`root`@`localhost` PROCEDURE `addCustomer`(in username varchar(20) , in pass varchar(30),
in city varchar(40),in province varchar(40) ,in street varchar(40), in phone_number char(11),in postal_code char(10)
,in email varchar(30))
BEGIN
declare id char(10);
repeat 
set id = convert ( Floor( RAND()*(10000000000-1000000000)+1000000000 ), char(10));
until  not exists (select idCustomer from customer 
where id=customer.idCustomer)
end repeat;
insert into customer(idCustomer,city,street,province,phone_number) value(id,city,street,province,phone_number);
insert into onlinecustomer(idCustomer,userName,pass,email,postal_code) value
(id,userName,pass,email,postal_code);
END