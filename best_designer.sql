-- select idStaff 
UPDATE factor SET idStaff = 4039 WHERE (idFactor = 9901);
UPDATE factor SET idStaff = 4039 WHERE (idFactor = 9902);
UPDATE factor SET idStaff = 4040 WHERE (idFactor = 9903);
UPDATE factor SET idStaff = 4040 WHERE (idFactor = 9904);
UPDATE factor SET idStaff = 4040 WHERE (idFactor = 9905);

select designer.idStaff,factor.idStaff,COUNT(*)as ctr
from factor ,designer
where factor.idStaff = designer.idStaff
 Order By ctr DESC, designer.idDesigner asc
LIMIT 10 ;

-- SELECT idStaff FROM factor
-- where 
-- select
-- where 
-- select product.type_name,product.idProduct,orders.idOrders, product.price,COUNT(*)as count
-- from factor ,orders,product 
-- where factor.idOrders=orders.idOrders and product.idOrders=orders.idOrders
-- and factor.F_date>= startDate and factor.F_date<=endDate
--  group by idProduct 
--  Order By count DESC, product.idProduct asc
-- LIMIT 10 ;
