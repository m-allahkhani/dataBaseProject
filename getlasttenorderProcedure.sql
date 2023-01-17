CREATE DEFINER=`root`@`localhost` PROCEDURE `getlasttenorder`(in customerID varchar(10))
BEGIN
select product.type_name,product.idProduct,product.price,product.idOrders,factor.f_date
from factor ,orders,product 
where factor.idOrders=orders.idOrders and
 product.idOrders=orders.idOrders and
 customerID=factor.idCustomer
 order by factor.f_date desc
 LIMIT 10;
END