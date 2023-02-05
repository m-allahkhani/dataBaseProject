 SELECT * FROM project_fas3.factor;
select * 
from factor
where '1400-09-21'<F_date<'1400-09-30'
group by idCustomer 
having sum(price-price*discount)>some(	
					select sum(price) 
					from factor as f
                    where factor.idCustomer <> f.idCustomer
					group by idCustomer 
                    )
limit 10
