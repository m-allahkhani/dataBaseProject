-- show best designer 14

CREATE DEFINER=`root`@`localhost` PROCEDURE `best_designer`()
BEGIN
UPDATE factor SET idStaff = 4039 WHERE (idFactor = 9901);
UPDATE factor SET idStaff = 4039 WHERE (idFactor = 9902);
UPDATE factor SET idStaff = 4040 WHERE (idFactor = 9903);
UPDATE factor SET idStaff = 4040 WHERE (idFactor = 9904);
UPDATE factor SET idStaff = 4040 WHERE (idFactor = 9905);

select designer.idStaff,factor.idStaff,COUNT(*)as ctr
from factor ,designer
where factor.idStaff = designer.idStaff
 Order By ctr DESC, designer.idStaff asc
LIMIT 10 ;
END
