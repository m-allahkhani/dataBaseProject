
insert into Store (
    idStore,
    phone_number,
    S_name,
    city,
    street,
    address_details
) values
(2000, '09152000000', 'taha', 'mashhad', 'emamat', 'pelak 25' ),
(2001, '09152000001', 'mohammad', 'mashhad', 'vakil', 'pelak 125' ),
(2002, '09152000002', 'ali', 'mashhad', 'moalem', 'pelak 225' ),
(2003, '09122000000', 'reza', 'tehran', 'jordan', 'pelak 525' ),
(2004,'09122000001', 'hasan', 'tehran', 'gheytariye', 'pelak 325' ); -- must be commented


insert into ProductionWorkshop (
    idProductionWorkshop,
    phone_number,
    PW_name,
    city,
    street,
    address_details
) values
(3000, '05131000000', 'zarin', 'mashhad', 'vakil', 'pelak 23' );

insert into GeneralManager (
	idGeneralManager ,
	idStore,
    idProductionWorkshop,
    first_name,
    last_name,
    phone_number
) value
(1000, 2000, 3000, 'taha', 'tahaee', '09151000000');






insert into Staff (
    idStaff, SSN, first_name , last_name, day_off_in_month,
    day_off_in_year, job_type, salary, phone_number,
    address, date_of_employeement, type_of_employeement
) values

(4000, '0921000000', 'yas', 'hamedi', 2, 5, 'store_manager', 
300000000, '09301000000', 'jalal 50 - pelak 5',
13900202, 'gharardadi'),

(4001, '0921000001', 'yaser', 'hamedian', 4, 10, 'store_manager', 
350000000, '09301000001', 'emamat 50 - pelak 10',
13911001, 'gharardadi'),


(4002, '0921000002', 'yasaman', 'hamedzadeh', 1, 15, 'store_manager', 
400000000, '09301000002', 'emamat 5 - pelak 15',
13920801, 'gharardadi'),

(4003, '0921000003', 'yasin', 'mohammadi', 2, 20, 'store_manager', 
450000000, '09301000003', 'jalal 10 - pelak 20',
13931001, 'gharardadi'),

(4004, '0921000004', 'mohammad', 'hamedi', 2, 15, 'store_manager', 
500000000, '09301000004', 'jalal 42 - pelak 25',
13941001, 'gharardadi'),
(4005, '0921000005', 'mahdi', 'hamedi', 2, 25, 'website_photographer', 
5000000, '09301000005', 'jalal 41 - pelak 30',
13951001, 'gharardadi'),

(4006, '0921000006', 'ali', 'hamedi', 2, 5, 'website_photographer', 
100000000, '09301000006', 'jalal 40 - pelak 35',
13961001, 'gharardadi'),

(4007, '0921000007', 'adel', 'hamedi', 2, 5, 'site_admin', 
100000000, '09301000007', 'jalal 39 - pelak 40',
13971001, 'gharardadi'),

(4008, '0921000008', 'farzad', 'hamedi', 2, 5, 'accountant', 
100000000, '09301000008', 'jalal 38 - pelak 45',
13981001, 'gharardadi'),

(4009, '0921000009', 'reza', 'hamedi', 2, 5, 'accountant', 
100000000, '09301000009', 'jalal 37 - pelak 50',
13991001, 'gharardadi'),

(4010, '0921000010', 'milad', 'hamedi', 2, 5, 'accountant', 
5000000, '09301000010', 'jalal 36 - pelak 55',
13901001, 'gharardadi'),

(4011, '0921000011', 'mohsen', 'hamedi', 2, 5, 'accountant', 
100000000, '09301000011', 'jalal 35 - pelak 60',
13911001, 'gharardadi'),

(4012, '0921000012', 'mahdiyar', 'hamedi', 2, 5, 'accountant', 
100000000, '09301000012', 'jalal 20 - pelak 65',
13921001, 'gharardadi'),

(4013, '0921000013', 'hasan', 'hamedi', 2, 5, 'shop_saleman', 
100000000, '09301000013', 'jalal 19 - pelak 70',
13931001, 'gharardadi'),

(4014, '0921000014', 'hamed', 'hamedi', 2, 5, 'shop_saleman', 
100000000, '09301000014', 'jalal 18 - pelak 75',
13941001, 'gharardadi'),

(4015, '0921000015', 'homayon', 'hamedi', 2, 5, 'shop_saleman', 
100000000, '09301000015', 'jalal 17 - pelak 80',
13951001, 'gharardadi'),

(4016, '0921000016', 'hesam', 'hamedi', 2, 5, 'shop_saleman', 
100000000, '09301000016', 'jalal 16 - pelak 85',
13961001, 'gharardadi'),

(4017, '0921000017', 'hadi', 'hamedi', 2, 5, 'shop_saleman', 
100000000, '09301000017', 'jalal 15 - pelak 90',
13971001, 'gharardadi'),

(4018, '0921000018', 'hosein', 'hamedi', 2, 5, 'shop_saleman', 
100000000, '09301000018', 'jalal 14 - pelak 95',
13981001, 'gharardadi'),

(4019, '0921000019', 'alireza', 'hamedi', 2, 5, 'shop_saleman', 
100000000, '09301000019', 'jalal 13 - pelak 100',
13991001, 'gharardadi'),

(4020, '0921000020', 'mohammadhosein', 'hamedi', 2, 5, 'shop_saleman', 
100000000, '09301000020', 'jalal 12 - pelak 105',
13901001, 'gharardadi'),

(4021, '0921000021', 'firooz', 'firoozi', 2, 5, 'shop_saleman', 
100000000, '09301000021', 'jalal 11 - pelak 110',
13911001, 'gharardadi'),

(4022, '0921000022', 'sina', 'hamedi', 2, 5, 'shop_saleman', 
100000000, '09301000022', 'jalal 10 - pelak 115',
13921001, 'gharardadi'),

(4023, '0921000023', 'siyamak', 'hamedi', 2, 5, 'purchasing_manager', 
100000000, '09301000023', 'jalal 67 - pelak 120',
13931001, 'gharardadi'),

(4024, '0921000024', 'saman', 'hamedi', 2, 5, 'purchasing_manager', 
100000000, '09301000024', 'jalal 66 - pelak 125',
13941001, 'gharardadi'),

(4025, '0921000025', 'sasan', 'hamedi', 2, 5, 'purchasing_manager', 
100000000, '09301000025', 'jalal 65 - pelak 130',
13951001, 'gharardadi'),

(4026, '0921000026', 'samad', 'hamedi', 2, 5, 'purchasing_manager', 
100000000, '09301000026', 'jalal 64 - pelak 135',
13961001, 'gharardadi'),

(4027, '0921000027', 'naser', 'hamedi', 2, 5, 'purchasing_manager', 
100000000, '09301000027', 'jalal 63 - pelak 140',
13971001, 'gharardadi'),

(4042, '0921000042', 'hasan', 'hasani', 2, 5, 'site_admin', 
100000000, '09301000042', 'moalem 20 - pelak 40',
13971001, 'gharardadi'),

(4043, '0921000043', 'hosein', 'hoseini', 2, 5, 'site_admin', 
100000000, '09301000043', 'moalem 21 - pelak 41',
13971001, 'gharardadi'),

(4044, '0921000044', 'yaser', 'hamediyan', 2, 5, 'site_admin', 
100000000, '09301000044', 'moalem 22 - pelak 42',
13971001, 'gharardadi'),

(4045, '0921000045', 'yaser', 'hamedzadeh', 2, 5, 'site_admin', 
100000000, '09301000045', 'moalem 23 - pelak 43',
13971001, 'gharardadi'),

-- production workshop

(4028, '0921000028', 'yasin', 'hamedpoor', 2, 5, 'receptionist', 
100000000, '09301000028', 'jalal 62 - pelak 145',
13981001, 'gharardadi'),

(4029, '0921000029', 'reza', 'hamediyan', 2, 5, 'manual_worker', 
100000000, '09301000029', 'jalal 61 - pelak 150',
13991001, 'gharardadi'),

(4030, '0921000030', 'sasan', 'hamedzadeh', 2, 5, 'manual_worker', 
100000000, '09301000030', 'jalal 60 - pelak 155',
13901001, 'gharardadi'),

(4031, '0921000031', 'saman', 'hamedzadeh', 2, 5, 'manual_worker', 
100000000, '09301000031', 'jalal 59 - pelak 160',
13911001, 'gharardadi'),

(4032, '0921000032', 'reza', 'hamedzadeh', 2, 5, 'manual_worker', 
100000000, '09301000032', 'jalal 58 - pelak 165',
13921001, 'gharardadi'),

(4033, '0921000033', 'mohammadreza', 'hamedpoor', 2, 5, 'manual_worker', 
100000000, '09301000033', 'jalal 57 - pelak 170',
13931001, 'gharardadi'),

(4034, '0921000034', 'mahdi', 'hamedpoor', 2, 5, 'gold_smith', 
100000000, '09301000034', 'jalal 56 - pelak 175',
13941001, 'gharardadi'),

(4035, '0921000035', 'hasan', 'hoseini', 2, 5, 'gold_smith', 
100000000, '09301000035', 'jalal 55 - pelak 180',
13951001, 'gharardadi'),

(4036, '0921000036', 'yaser', 'hoseinzadeh', 2, 5, 'gold_smith', 
100000000, '09301000036', 'jalal 54 - pelak 185',
13961001, 'gharardadi'),

(4037, '0921000037', 'yasin', 'hoseinzadeh', 2, 5, 'gold_smith', 
100000000, '09301000037', 'jalal 53 - pelak 190',
13971001, 'gharardadi'),

(4038, '0921000038', 'milad', 'hamedpoor', 2, 5, 'gold_smith', 
100000000, '09301000038', 'jalal 52 - pelak 195',
13981001, 'gharardadi'),

(4039, '0921000039', 'mobin', 'hamedi', 2, 5, 'designer', 
100000000, '09301000039', 'jalal 5 - pelak 200',
13991001, 'gharardadi'),

(4040, '0921000040', 'moeen', 'hamedi', 2, 5, 'designer', 
100000000, '09301000040', 'jalal 15 - pelak 205',
13901001, 'gharardadi'),

(4041, '0921000041', 'mahdiyar', 'hamedpoor', 2, 10, 'manager', 
100000000, '09301000041', 'jalal 20 - pelak 210',
13911001, 'gharardadi');



insert into ProductionWorkshopEmployees (
    idStaff,
    idProductionWorkshop
) values
(4028, 3000),
(4029, 3000),
(4030, 3000),
(4031, 3000),
(4032, 3000),
(4033, 3000),
(4034, 3000),
(4035, 3000),
(4036, 3000),
(4037, 3000),
(4038, 3000),
(4039, 3000),
(4040, 3000),
(4041, 3000); -- :)


insert into StoreStaff (
    idStaff,
    idStore
) values
-- store manager
(4000, 2000),
(4001, 2001),
(4002, 2002),
(4003, 2003),
(4004, 2004),-- :)

-- website_photographer
(4005, 2000),
(4006, 2004),-- :)

-- site_admin
(4007, 2000),
(4042, 2001),
(4043, 2002),
(4044, 2003),
(4045, 2004),-- :)

-- accountant
(4008, 2000),
(4009, 2001),
(4010, 2002),
(4011, 2003),
(4012, 2004),-- :)

-- shop man
(4013, 2000),
(4014, 2000),
(4015, 2001),
(4016, 2001),
(4017, 2002),
(4018, 2002),
(4019, 2003),
(4020, 2003),
(4021, 2004),
(4022, 2004),-- :)

-- purchasing_manager
(4023, 2000),
(4024, 2001),
(4025, 2002),
(4026, 2003),
(4027, 2004);-- :)

insert into PurchasingManager (idStaff ) values
(4023),
(4024),
(4025),
(4026),
(4027); -- :)

insert into ShopSalesman (
    idStaff
) values
(4013),
(4014),
(4015),
(4016),
(4017),
(4018),
(4019),
(4020),
(4021),
(4022);-- :)

insert into SalesPerMonth (
    idStaff,
    sales_date,
    sales_amount
) values
(4013,13990225,1000000000),
(4013,13990325,1500000000),
(4014,13990225,1000000000),
(4014,13900426,2000000000),
(4015,13990225,1333000000),
(4015,13990727,2593000000),
(4016,13990225,1333000000),
(4016,13990925,1333000000); -- :)

insert into Accountants (
    idStaff
) values
(4008),
(4009),
(4010),
(4011),
(4012);-- :)

insert into SiteAdmin (
    idStaff,
    site_login_code
) values
(4007, '12345543217'),
(4042, '66255515001'),
(4043, '20252102'),
(4044, '20062523'),
(4045, '2985004'); -- :)

insert into NumOfReportsPerMonth (
    idStaff,
    RM_date,
    RM_number
) values
(4007, 14000305, 70),
(4007, 14000405, 72),
(4042, 14000305, 71),
(4042, 14000405, 81),
(4044, 14000305, 73),
(4044, 14000405, 74),
(4043, 14000305, 74),
(4043, 14000405, 94); -- :)

insert into WebsitePhotographer (
    idStaff,
    number_of_photos
) values
(4005, 61),
(4006, 60); -- / :)

insert into StoreManager (
    idStaff,
    idStore
) values
(4000, 2000),
(4001, 2001),
(4002, 2002),
(4003, 2003),
(4004, 2004);-- //:)




insert into Receptionist (
    idStaff
) values
(4028);  -- :)

insert into SellerOfRequiredItems (
    SI_name,
    address,
    phone_number
) values
('AndisheGostar','Mahhad-ShahrakSanati','09363333333'),
('Andishe','Mahhad-ShahrakSanati2','09363333332'),
('AndisheSaz','Mahhad-ShahrakSanati5','09363333330'),
('AndisheBin','Mahhad-ShahrakSanati3','09363333338'),
('zarin', 'mashhad-vakil-pelak 23','05131000000' );-- :)




insert into Customer ( idCustomer, city, street,  province,  phone_number, suggests)
values
('1131102500','mashhad','kosar','khorasan razavi','12305623231',''),
('1131100100','mashhad','abkoh','khorasan razavi','15874692515',''),
('1131100025','mashhad','hashemiye','khorasan razavi','65342561589',''),
('1131100652','mashhad','piroozi','khorasan razavi','58954758965',''),
('1131100008','tehran','moalem','tehran','05482459856',''),
('1131100000','mashhad','kosar','khorasan razavi','12300003231',''),
('1131105100','mashhad','abkoh','khorasan razavi','15004692515',''),
('1131100125','mashhad','hashemiye','khorasan razavi','65342500589',''),
('1131100650','mashhad','piroozi','khorasan razavi','58954758900',''),
('1131100108','tehran','moalem','tehran','05400009856','');

insert into Orders (
    idCustomer ,
    idOrders ,
    receiving_status  )
    values('1131100000',1,'received'),
		  ('1131100100',2,'received'),
          ('1131100025',5,'received'),
          ('1131100650',3,'waiting'),
          ('1131100008',8,'received');
          

insert into Orders (
    idCustomer ,
    idOrders ,
    receiving_status  )
    values('1131100000',4,'received'),
		  ('1131100100',6,'received'),
          ('1131100025',7,'received'),
          ('1131100650',9,'waiting'),
          ('1131100008',10,'received');

insert into product (idProduct, idOrders,discount,price,type_name) values
(1234,1,0.1,12000000,'necklace'),
(1235,2,0.0,230000000,'earrnigs'),
(1236,3,0.2,340000000,'half_coin'),
(1237,2,0.3,12000000,'full_coin_Old'),
(1238,4,0.1,12040000,'bracelet'),
(1239,8,0.0,43000000,'anklet'),
(1240,5,0.05,3490000,'quarter_coin'),
(1241,3,0.2,12000000,'full_coin_New'),
(1242,5,0.2,23500000,'pendant'),
(1243,7,0.15,63600000,'earrnigs'),
(1244,8,0.2,340000000,'half_coin'),
(1245,5,0.0,12300000,'full_coin_Old'),
(1246,6,0.2,12040000,'bracelet'),
(1247,6,0.1,4360000,'ring'),
(1248,4,0.05,3490000,'quarter_coin'),
(1249,2,0.2,12000000,'full_coin_New'),
(1250,8,0.2,23690000,'pendant'),
(1251,7,0.1,2460000,'anklet'),
(1252,3,0.05,3490000,'bracelet'),
(1253,10,0.2,72000000,'ring'),
(1254,7,0.2,99690000,'pendant'),
(1255,9,0.2,93040000,'bracelet'),
(1256,7,0.25,95490000,'quarter_coin'),
(1257,8,0.1,12000000,'full_coin_New'),
(1258,6,0.0,675000000,'pendant'),
(1259,9,0.1,12500000,'parsian_coin'),
(1260,10,0.1,2500000,'parsian_coin');

insert into Provide_R (
    idStaff,
    SI_name,
    idProduct
) values
(4028,'AndisheGostar',1234),
(4028,'Andishe',1235),
(4028,'AndisheSaz',1236),
(4028,'AndisheGostar',1237),
(4028,'AndisheGostar',1238),
(4028,'AndisheBin',1239),
(4028,'zarin',1240); -- :)


insert into Overtime (
    idStaff,
    OTdate,
    start_time,
    end_time
) values
(4020, 14010201, 10, 22),
(4021, 14010211, 10, 22),
(4022, 14010212, 10, 22),
(4023, 14010213, 10, 22),
(4023, 14010413, 10, 22);



insert into Manager (
    idStaff,
    idProductionWorkshop
) values
(4041, 3000);-- :)


insert into Designer (
    idStaff ,
    number_of_projects_in_progress,
    number_of_designs_drawn
) values

(4039, 2, 55),
(4040, 3, 55);-- :)

insert into Design (
    design_code,
    idStaff,
    D_name,
    D_price
) values
(7701,4040,'ziba',500000),
(7702,4039,'ziba',500000),
(7703,4039,'zib0a',800000),
(7704,4040,'ziba0',900000),
(7705,4040,'ziba4',400000); -- :)

insert into Goldsmith (
    idStaff,
    skill
) values
(4034,'A'),
(4035,'A'),
(4036,'B'),
(4037,'A'),
(4038,'B');-- :)
    
    
insert into NumberOfGoldsMadePerMonth (
    idStaff,
    GM_date,
    GM_number
) values
    (4034,14010327,12),
   (4034,14010427,12),
   (4035,14010327,12),
   (4035,14010427,12),
   (4036,14010327,12),
   (4036,14010427,12),
   (4037,14010327,12),
   (4037,14010427,12);-- :)
   
insert into ManualWorker (
    idStaff,
    reponsibility
) values
(4029,'cleaner'),
(4030,'cleaner'),
(4031,'cleaner'),
(4032,'cleaner'),
(4033,'cleaner'); -- :)
    

    insert into OnlineOrder (idOrders,
    referral_status ,
    sending_status ,
    record_status )
    values(1,'referralled','Final delivery','final recorded'),
		  (3,'not referralled','waiting','waiting');
          
    insert into OrderInPerson ( idOrders ,
    date_of_order )
    values(2,14000820),
          (5,14000920),
          (8,14000820);



insert into pricerecord (idProduct,PR_date,discount,price) values
(1234,14010409,0.1,12000000),
(1235,14010409,0.0,230000000),
(1236,14010409,0.2,340000000),
(1237,14010409,0.3,12000000),
(1238,14010409,0.1,12040000),
(1239,14010409,0.0,43000000),
(1240,14010409,0.05,3490000),
(1241,14010409,0.2,12000000),
(1242,14010409,0.2,23500000),
(1243,14010409,0.15,63600000),
(1244,14010409,0.2,340000000),
(1245,14010409,0.0,12300000),
(1246,14010409,0.2,12040000),
(1247,14010409,0.1,4360000),
(1248,14010409,0.05,3490000),
(1249,14010409,0.2,12000000),
(1250,14010409,0.2,23690000),
(1251,14010409,0.1,2460000),
(1252,14010409,0.05,3490000),
(1253,14010409,0.2,72000000),
(1254,14010409,0.2,99690000),
(1255,14010409,0.2,93040000),
(1256,14010409,0.25,95490000),
(1257,14010409,0.1,12000000),
(1258,14010409,0.0,675000000),
(1259,14010409,0.1,12500000),
(1260,14010409,0.1,2500000),
(1234,14010410,0.1,12000000),
(1235,14010410,0.0,230000000),
(1236,14010410,0.2,340000000),
(1237,14010410,0.3,12000000),
(1238,14010410,0.1,12040000),
(1239,14010410,0.0,43000000),
(1240,14010410,0.05,3490000),
(1241,14010410,0.2,12000000),
(1242,14010411,0.2,23500000),
(1243,14010411,0.15,63600000),
(1244,14010411,0.2,340000000),
(1245,14010411,0.0,12300000),
(1246,14010411,0.2,12040000),
(1247,14010411,0.1,4360000),
(1248,14010411,0.05,3490000),
(1249,14010411,0.2,12000000),
(1250,14010411,0.2,23690000),
(1251,14010411,0.1,2460000),
(1252,14010411,0.05,3490000),
(1253,14010411,0.2,72000000),
(1254,14010411,0.2,99690000),
(1255,14010412,0.2,93040000),
(1256,14010412,0.25,93090000),
(1257,14010413,0.1,12000000),
(1258,14010413,0.0,675000000),
(1259,14010413,0.1,13000000),
(1260,14010414,0.1,12500000);


insert into jewlery(idProduct,making_charge,weight,country) values
(1234,120000,15.0,'Iran'),
(1242,230000,14.0,'Iran'),
(1252,344000,12.6,'Italy'),
(1247,540000,6.5,'Italy'),
(1253,830000,8,'Italy'),
(1258,500000,15.5,'Iran');


insert into stone(S_type,idProduct,S_number,price,weight) values
('opal',1234,1,340000,4),
('topaz',1234,2,160000,3),
('peridot',1242,1,3000000,0.5),
('emerald',1252,1,2560000,1),
('diamond',1252,2,5600000,2),
('opal',1247,2,340000,2),
('emerald',1253,1,2560000,1),
('diamond',1253,3,5600000,0.5),
('topaz',1258,2,160000,4),
('diamond',1258,1,5600000,3);



insert into gold(idProduct,purity,weight,country) values
(1235,18,2.3,'Iran'),
(1238,18,5,'Italy'),
(1239,18,6.3,'Iran'),
(1243,18,4.5,'Iran'),
(1246,24,6.7,'Iran'),
(1247,24,16.0,'Italy'),
(1250,18,9,'Iran'),
(1251,24,6,'Iran'),
(1254,18,6.4,'Italy'),
(1255,18,12,'Iran'),
(1258,21,13,'Italy');


insert into oldgold(idProduct,construction_date) values
(1238,1998),
(1239,1999),
(1243,2000),
(1247,2002),
(1255,2012),
(1251,2014);


insert into newgold(idProduct,making_charge) values
(1235,1200000),
(1239,2000000),
(1246,900000),
(1250,2100000),
(1254,1900000),
(1258,800000);


insert into coins(idProduct,C_year) values
(1236,2010),
(1237,2021),
(1240,2020),
(1241,1998),
(1244,2016),
(1245,2018),
(1248,2018),
(1249,2020),
(1256,2011),
(1257,2022);
insert into coins(idProduct,C_year,weight) values
(1259,2020,0.8),
(1260,2012,0.5);

insert into factor (idFactor, idStaff, idCustomer, idOrders, price , discount ,  type_of_shopping, number_of_products, F_date) 
values
(9901,4008,'1131100000',1,21000000,0.05,'online',1,14000917),
(9902,4009,'1131100100',2,51000000,0.1,'in person',2,14000918),
(9903,4010,'1131100025',5,30000000,2,'in person',2,14000918),
(9904,4008,'1131100650',3,17000000,0.7,'online',1,14000920),
(9905,4008,'1131100008',8,100000000,0.7,'in person',3,14000920);

insert into CustomerInPerson ( idCustomer,  service_date )
values
('1131102500',14000816),
('1131100100',14000820),
('1131100025',14000920),
('1131100652',14001020),
('1131100008',14000820)
;

insert into OnlineCustomer ( idCustomer, userName,  pass,  email, postal_code)
values
('1131100000','huyy','poiuyt158','jfok@gmail.com','1212121212'),
('1131105100','plo','ghgju525','raz2@gmail.com','1313131313'),
('1131100125','diazj','wareee9','kaj@gmail.com','1414141414'),
('1131100650','iijdpod','kglksp87','ops@gmail.com','5858585858'),
('1131100108','vcgdh','lolko64','pars@gmail.com','6969696969');

INSERT INTO listOfInterestPruducts (update_date ,idCustomer ,num_list ,conditions)
VALUE (13900705,1131100000, 1, "gift");
INSERT INTO listOfInterestPruducts (update_date ,idCustomer ,num_list ,conditions)
VALUE (13950410, 1131100125, 2, "favorite");
INSERT INTO listOfInterestPruducts (update_date ,idCustomer ,num_list ,conditions)
VALUE (13990201, 1131100650, 3, "gift");


insert into InterestInclude_R (
    idCustomer ,
    update_date ,
    idProduct)
    values('1131100000',13900705,1234),  
		  ('1131100125',13950410,1235),
		  ('1131100650',13990201,1236);
 
 
 INSERT INTO Reserve (idReserve, idCustomer, reservationDate ,deposit) VALUE 
(1,1131100000, 14000205, 59298);
INSERT INTO Reserve (idReserve, idCustomer, reservationDate ,deposit) VALUE 
(2,1131100108, 13980912, 25802);
INSERT INTO Reserve (idReserve, idCustomer, reservationDate ,deposit) VALUE 
(3,1131100125,13980925, 7894);
 INSERT INTO Reserve (idReserve, idCustomer, reservationDate ,deposit) VALUE 
(4,1131100025,13991203, 79567);
INSERT INTO Reserve (idReserve, idCustomer, reservationDate ,deposit) VALUE 
(5, 1131100650, 14010919, 20122);


INSERT INTO listofSuggestionProducts (idCustomer,update_date,num_list, conditions)
value(1131100650, 14001225, 1, "send");

INSERT INTO listofSuggestionProducts (idCustomer,update_date,num_list, conditions)
value(1131100650, 14010101, 2,"in progess");

INSERT INTO listofSuggestionProducts (idCustomer,update_date,num_list, conditions)
value(1131100000, 14011215, 5, "send");
INSERT INTO listofSuggestionProducts (idCustomer,update_date,num_list, conditions)
value(1131100108, 14010218, 4, "in progess" );
INSERT INTO listofSuggestionProducts (idCustomer,update_date,num_list, conditions)
value(1131100125, 13991127, 3, "send");

insert INTO SugestionInclude_R (idCustomer, update_date, idProduct)
VALUE(1131100650, 14001225,1236);
insert INTO SugestionInclude_R (idCustomer, update_date, idProduct)
VALUE(1131100650, 14010101,1246);
insert INTO SugestionInclude_R (idCustomer, update_date, idProduct)
VALUE(1131100000, 14011215,1239);
insert INTO SugestionInclude_R (idCustomer, update_date, idProduct)
VALUE(1131100125, 13991127,1235);
insert INTO SugestionInclude_R (idCustomer, update_date, idProduct)
VALUE(1131100108, 14010218, 1241);


