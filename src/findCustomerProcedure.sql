CREATE DEFINER=`root`@`localhost` PROCEDURE `findCustomer`(in userName varchar(20), in pass varchar(30))
BEGIN
	select * from customer , onlinecustomer
    where customer.idCustomer=onlinecustomer.idCustomer
    and onlinecustomer.userName=userName and 
    onlinecustomer.pass=pass;
END