CREATE DEFINER=`root`@`localhost` PROCEDURE `show_order_list`()
BEGIN
SELECT idOrders, price, F_date  FROM dbproject.factor;
END
