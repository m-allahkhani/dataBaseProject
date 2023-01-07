CREATE DEFINER=`root`@`localhost` PROCEDURE `findAdmin`(in userName varchar(20), in pass varchar(30))
BEGIN
select * from staff,siteadmin
where staff.idStaff=siteadmin.idStaff 
and siteadmin.site_login_code=pass 
and siteadmin.username=username;
END