-- show the three stores that have the lowest sales

CREATE DEFINER=`root`@`localhost` PROCEDURE `show_stores_with_loewst_sale`()
BEGIN
select idStore ,   sum(sales) as storeSales
from storestaff sf inner join  salespermonth spm 
on sf.idStaff = spm.idStaff
group by idStore
order by storeSales;
END
