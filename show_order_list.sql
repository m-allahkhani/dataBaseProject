CREATE DEFINER=`root`@`localhost` PROCEDURE `show_order_list`(in idOrders )
BEGIN
SELECT idOrders, price, F_date  FROM dbproject.factor;
END
