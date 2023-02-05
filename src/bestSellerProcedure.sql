CREATE DEFINER=`root`@`localhost` PROCEDURE `bestSeller`(in startDate date,in endDate date)
BEGIN
select product.type_name,product.idProduct,orders.idOrders, product.price,COUNT(*)as count
from factor ,orders,product 
where factor.idOrders=orders.idOrders and product.idOrders=orders.idOrders
and factor.F_date>= startDate and factor.F_date<=endDate
 group by idProduct 
 Order By count DESC, product.idProduct asc
LIMIT 10 ;
END