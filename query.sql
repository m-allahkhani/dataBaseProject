/*Create database DBProject;*/
Use DBProject;
/*
Mohaddese Madanikhah   9722762155
Fateme Soltani         9922762195
Fateme khavari         9922762208
Maryam Allahkhani      9912762154
Yasaman Hamedtabei     9912762198
*/

CREATE TABLE Store (
    idStore INT NOT NULL PRIMARY KEY,
    phone_number CHAR(11),
    S_name VARCHAR(60),
    city VARCHAR(40),
    street VARCHAR(40),
    address_details VARCHAR(60)
);


CREATE TABLE ProductionWorkshop (
    idProductionWorkshop INT NOT NULL PRIMARY KEY,
    phone_number CHAR(11),
    PW_name VARCHAR(40),
    city VARCHAR(40),
    street VARCHAR(40),
    address_details VARCHAR(60)
);
CREATE TABLE GeneralManager (
    idGeneralManager INT NOT NULL PRIMARY KEY,
    idStore INT,
    FOREIGN KEY (idStore)
    REFERENCES Store (idStore),
    idProductionWorkshop INT,
    FOREIGN KEY (idProductionWorkshop)
        REFERENCES ProductionWorkshop (idProductionWorkshop),
    first_name VARCHAR(20),
    last_name VARCHAR(50),
    phone_number VARCHAR(11)
);

CREATE TABLE Staff (
    idStaff INT NOT NULL PRIMARY KEY,
    SSN CHAR(10) UNIQUE,
    first_name VARCHAR(30),
    last_name VARCHAR(50),
    day_off_in_month INT,
    day_off_in_year INT,
    job_type VARCHAR(30),
    salary BIGINT,
    phone_number CHAR(11),
    address VARCHAR(250),
    date_of_employeement DATE,
    type_of_employeement VARCHAR(60)
);

CREATE TABLE Overtime (
    idStaff INT NOT NULL,
    FOREIGN KEY (idStaff)
        REFERENCES staff (idStaff),
    OTdate DATE,
    start_time TIME,
    end_time TIME,
    PRIMARY KEY (idStaff , OTdate)
);

CREATE TABLE ProductionWorkshopEmployees (
    idStaff INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idStaff)
        REFERENCES staff (idStaff),
    idProductionWorkshop INT,
    FOREIGN KEY (idProductionWorkshop)
        REFERENCES ProductionWorkshop (idProductionWorkshop)
);

CREATE TABLE Manager (
    idStaff INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idStaff)
        REFERENCES productionworkshopemployees (idStaff),
    idProductionWorkshop INT,
    FOREIGN KEY (idProductionWorkshop)
        REFERENCES ProductionWorkshop (idProductionWorkshop)
);

CREATE TABLE Designer (
    idStaff INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idStaff)
        REFERENCES productionworkshopemployees (idStaff),
    number_of_projects_in_progress INT,
    number_of_designs_drawn INT
);

CREATE TABLE Design (
    design_code INT NOT NULL PRIMARY KEY,
    idStaff INT,
    FOREIGN KEY (idStaff)
        REFERENCES designer (idStaff),
    D_name VARCHAR(60),
    D_price BIGINT
);

CREATE TABLE Goldsmith (
    idStaff INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idStaff)
        REFERENCES productionworkshopemployees (idStaff),
    skill CHAR(1)
);
    
CREATE TABLE NumberOfGoldsMadePerMonth (
    idStaff INT NOT NULL,
    FOREIGN KEY (idStaff)
        REFERENCES goldsmith (idStaff),
    GM_date DATE,
    GM_number INT,
    PRIMARY KEY (idStaff , GM_date)
);
    
    
CREATE TABLE ManualWorker (
    idStaff INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idStaff)
        REFERENCES productionworkshopemployees (idStaff),
    reponsibility VARCHAR(30)
);

CREATE TABLE Receptionist (
    idStaff INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idStaff)
        REFERENCES productionworkshopemployees (idStaff)
);

CREATE TABLE SellerOfRequiredItems (
    SI_name VARCHAR(100) NOT NULL PRIMARY KEY,
    address VARCHAR(250),
    phone_number VARCHAR(11)
);

CREATE TABLE StoreStaff (
    idStaff INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idStaff)
        REFERENCES staff (idStaff),
    idStore INT,
    FOREIGN KEY (idStore)
        REFERENCES Store (idStore)
);


CREATE TABLE PurchasingManager (
    idStaff INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idStaff)
        REFERENCES storestaff (idStaff)
);

CREATE TABLE ShopSalesman (
    idStaff INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idStaff)
        REFERENCES storestaff (idStaff)
);

CREATE TABLE SalesPerMonth (
    idStaff INT NOT NULL,
    FOREIGN KEY (idStaff)
        REFERENCES shopsalesman (idStaff),
    sales_date DATE,
    sales_amount BIGINT,
    PRIMARY KEY (idStaff , sales_date)
);

CREATE TABLE Accountants (
    idStaff INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idStaff)
        REFERENCES storestaff (idStaff)
);

CREATE TABLE SiteAdmin (
    idStaff INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idStaff)
        REFERENCES storestaff (idStaff),
    site_login_code VARCHAR(32)
);

CREATE TABLE NumOfReportsPerMonth (
    idStaff INT NOT NULL,
    FOREIGN KEY (idStaff)
        REFERENCES siteadmin (idStaff),
    RM_date DATE,
    RM_number INT,
    PRIMARY KEY (idStaff , RM_date)
);

CREATE TABLE WebsitePhotographer (
    idStaff INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idStaff)
        REFERENCES storestaff (idStaff),
    number_of_photos INT
);

CREATE TABLE StoreManager (
    idStaff INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idStaff)
        REFERENCES storestaff (idStaff),
    idStore INT,
    FOREIGN KEY (idStore)
        REFERENCES Store (idStore)
);


CREATE TABLE Customer (
    idCustomer CHAR(10) PRIMARY KEY,
    city VARCHAR(40),
    street VARCHAR(40),
    province VARCHAR(40),
    phone_number char(11),
    suggests VARCHAR(100)
);

CREATE TABLE Orders (
    idOrders INT PRIMARY KEY,
    idCustomer CHAR(10),
    FOREIGN KEY (idCustomer)
        REFERENCES Customer (idCustomer),
    receiving_status VARCHAR(20)
); 
CREATE TABLE Product (
    idProduct INT NOT NULL PRIMARY KEY,
    idOrders INT,
    FOREIGN KEY (idOrders)
        REFERENCES Orders (idOrders),
    discount FLOAT,
    price BIGINT,
    type_name VARCHAR(40)
);

CREATE TABLE Provide_R (
    idStaff INT NOT NULL,
    FOREIGN KEY (idStaff)
        REFERENCES receptionist (idStaff),
    SI_name VARCHAR(100) NOT NULL,
    FOREIGN KEY (SI_name)
        REFERENCES sellerofrequireditems (SI_name),
    idProduct INT NOT NULL,
    FOREIGN KEY (idProduct)
        REFERENCES product (idProduct),
    PRIMARY KEY (idStaff , SI_name , idProduct)
);

CREATE TABLE PriceRecord (
    idProduct INT NOT NULL,
    FOREIGN KEY (idProduct)
        REFERENCES product (idProduct),
    PR_date DATE,
    price BIGINT,
    discount FLOAT,
    PRIMARY KEY (idProduct , PR_date)
);

CREATE TABLE Jewlery (
    idProduct INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idProduct)
        REFERENCES product (idProduct),
    making_charge INT,
    weight float,
    country VARCHAR(20)
);

CREATE TABLE Stone (
    S_type VARCHAR(20),
    idProduct INT NOT NULL,
    FOREIGN KEY (idProduct)
        REFERENCES jewlery (idProduct),
    S_number INT,
    price BIGINT,
    weight FLOAT,
    PRIMARY KEY (idProduct , S_type)
);

CREATE TABLE Gold (
    idProduct INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idProduct)
        REFERENCES product (idProduct),
    purity FLOAT,
    weight FLOAT,
    country VARCHAR(20)
);

CREATE TABLE OldGold (
    idProduct INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idProduct)
        REFERENCES gold (idProduct),
    construction_date YEAR
);

CREATE TABLE NewGold (
    idProduct INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idProduct)
        REFERENCES gold (idProduct),
    making_charge INT
);

CREATE TABLE Coins (
    idProduct INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (idProduct)
        REFERENCES product (idProduct),
    C_year YEAR,
    weight FLOAT
);

CREATE TABLE factor (
    idFactor INT NOT NULL PRIMARY KEY,
    idStaff INT NOT NULL,
    FOREIGN KEY (idStaff)
        REFERENCES Accountants (idStaff),
    idCustomer CHAR(10),
    FOREIGN KEY (idCustomer)
        REFERENCES Customer (idCustomer),
    idOrders INT,
    FOREIGN KEY (idOrders)
        REFERENCES Orders (idOrders),
    price BIGINT,
    discount FLOAT,
    type_of_shopping VARCHAR(20),
    number_of_products INT,
    F_date DATE
);

CREATE TABLE CustomerInPerson (
    idCustomer CHAR(10) PRIMARY KEY,
    FOREIGN KEY (idCustomer)
        REFERENCES Customer (idCustomer),
    service_date DATE
);

CREATE TABLE OnlineCustomer (
    idCustomer CHAR(10) PRIMARY KEY,
    FOREIGN KEY (idCustomer)
        REFERENCES Customer (idCustomer),
    userName VARCHAR(20),
    pass VARCHAR(30),
    email VARCHAR(30),
    postal_code CHAR(10)
);

CREATE TABLE SellingUsedGold_R (
    idCustomer CHAR(10),
    FOREIGN KEY (idCustomer)
        REFERENCES customerinperson (idCustomer),
    idStaff INT,
    FOREIGN KEY (idStaff)
        REFERENCES purchasingmanager (idStaff),
    idProduct INT,
    FOREIGN KEY (idProduct)
        REFERENCES product (idProduct),
    PRIMARY KEY (idCustomer , idStaff , idProduct)
);

CREATE TABLE Reserve (
    idReserve INT PRIMARY KEY,
    idCustomer CHAR(10),
    FOREIGN KEY (idCustomer)
        REFERENCES OnlineCustomer (idCustomer),
    reservationDate DATE,
    deposit BIGINT
);

CREATE TABLE listofSuggestionProducts (
    idCustomer CHAR(10),
    FOREIGN KEY (idCustomer)
        REFERENCES onlinecustomer (idCustomer),
    update_date DATE,
    PRIMARY KEY (idCustomer , update_date),
    num_list INT,
    conditions VARCHAR(10)
);

CREATE TABLE SugestionInclude_R (
    idCustomer CHAR(10),
    update_date DATE,
    FOREIGN KEY (idCustomer , update_date)
        REFERENCES listofsuggestionproducts (idCustomer , update_date),
    idProduct int ,
    FOREIGN KEY (idProduct)
        REFERENCES product (idProduct),
    PRIMARY KEY (idCustomer , update_date , idProduct)
);

CREATE TABLE listOfInterestPruducts (
    update_date DATE,
    idCustomer CHAR(10),
    FOREIGN KEY (idCustomer)
        REFERENCES onlinecustomer (idCustomer),
    PRIMARY KEY (idCustomer , update_date),
    num_list INT,
    conditions VARCHAR(10)
);

CREATE TABLE InterestInclude_R (
    idCustomer CHAR(10),
    update_date DATE,
    FOREIGN KEY (idCustomer,update_date)
        REFERENCES listofinterestpruducts (idCustomer,update_date),
    idProduct INT,
    FOREIGN KEY (idProduct)
        REFERENCES product (idProduct),
    PRIMARY KEY (idCustomer , update_date , idProduct)
);
   
CREATE TABLE OnlineOrder (
    idOrders INT PRIMARY KEY,
    FOREIGN KEY (idOrders)
        REFERENCES orders (idOrders),
    referral_status VARCHAR(30),
    sending_status VARCHAR(30),
    record_status VARCHAR(30)
);

CREATE TABLE OrderInPerson (
    idOrders INT PRIMARY KEY,
     FOREIGN KEY (idOrders)
        REFERENCES orders (idOrders),
    date_of_order DATE
);
