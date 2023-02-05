select cid 
from customer, factor,orders , product
where customer.idCustomer = factor.idCustomer 
	and factor.idOrders = orders.idOrders
    and orders.idOrders = product.idOrders
    