CREATE DEFINER=`root`@`localhost` FUNCTION `selltotal`( startDate date,endDate date) RETURNS int
    DETERMINISTIC
BEGIN
declare total bigint default 0;
select sum(factor.price) into total
from factor
where  factor.F_date>= startDate and factor.F_date<=endDate;
RETURN total;
END