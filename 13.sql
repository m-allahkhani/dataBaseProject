select idStore ,   sum(sales_amount) as storeSales
from storestaff sf inner join  salespermonth spm 
on sf.idStaff = spm.idStaff
group by idStore
order by storeSales;