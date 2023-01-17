CREATE DEFINER=`root`@`localhost` PROCEDURE `getproducts`()
BEGIN
select type_name,product.idproduct,weight,country,price,discount from product , gold
    where product.idProduct=gold.idProduct
    order by type_name; 
    select type_name,product.idproduct,weight,country,price,discount from product , jewlery
    where product.idProduct=jewlery.idProduct
    order by type_name;
    select type_name,C_year,weight,price,discount from product, coins
    where coins.idProduct=product.idProduct
    group by type_name , C_year, weight
    order by type_name;
END