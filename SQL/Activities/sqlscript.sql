REM   Script: all activities
REM   ALL ACTIVITIES
-----------Activity1--------------
CREATE TABLE salesman  
(salesman_id int,  
    salesman_name varchar2(32),  
    salesman_city varchar2(32),  
    commission int);

 DESCRIBE salesman

-----------Activity2--------------
INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;
-----------Activity3--------------
SELECT salesman_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';
-----------Activity4--------------
ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;
SELECT * FROM salesman;
-----------Activity5--------------

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';


create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;
-----------Activity6--------------
select distinct salesman_id from orders;

select order_no, order_date from orders order by order_date;

select order_no, purchase_amount from orders order by purchase_amount DESC;

select * from orders where purchase_amount < 500;

select * from orders where purchase_amount between 1000 and 2000;
-----------Activity7--------------
select SUM(purchase_amount) AS "Total sum" from orders;

select AVG(purchase_amount) AS "Average" from orders;

select MAX(purchase_amount) AS "Maximum" from orders;

select MIN(purchase_amount) AS "Minumum" from orders;

select COUNT(distinct salesman_id) AS "Total count" from orders;
-----------Activity8--------------

SELECT customer_id, MAX(purchase_amount) AS "Max Amount" FROM orders GROUP BY customer_id;

SELECT salesman_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders  
WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id, order_date;

SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders 
GROUP BY customer_id, order_date 
HAVING MAX(purchase_amount) IN(2030, 3450, 5760, 6000);

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

INSERT ALL 
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) 
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) 
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) 
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) 
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;
-----------Activity10--------------
SELECT * FROM orders 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT * FROM orders  
WHERE salesman_id IN (SELECT salesman_id FROM customers WHERE city='New York');

SELECT GRADE, COUNT(*) FROM customers 
GROUP BY GRADE HAVING GRADE>(SELECT AVG(GRADE) FROM customers WHERE CITY='New York');

SELECT * FROM orders 
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE SALESMAN_CITY='New York');

SELECT * FROM orders;

SELECT salesman_id FROM salesman WHERE SALESMAN_CITY='London';

SELECT * FROM salesman;

SELECT salesman_id FROM salesman WHERE salesman_city='Paris';

SELECT * FROM orders 
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE salesman_city='Paris');

SELECT grade, COUNT(*) FROM customers 
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='Paris');

SELECT ORDER_NO, PURCHASE_AMOUNT, ORDER_DATE, SALESMAN_ID FROM orders 
WHERE SALESMAN_ID IN( SELECT SALESMAN_ID FROM salesman 
WHERE COMMISSION=( SELECT MAX(COMMISSION) FROM salesman));

SELECT CUSTOMER_ID, CUSTOMER_NAME FROM customers a  
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.CUSTOMER_ID = b.CUSTOMER_ID)  
UNION  
SELECT SALESMAN_ID, SALESMAN_NAME FROM salesman a  
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.SALESMAN_ID = b.SALESMAN_ID)  
ORDER BY CUSTOMER_NAME;

SELECT COUNT(*) FROM customers a,orders b WHERE a.CUSTOMER_ID = b.CUSTOMER_ID;
-----------Activity9--------------
SELECT a.CUSTOMER_NAME, a.CITY, b.SALESMAN_NAME, b.COMMISSION FROM customers a  
INNER JOIN salesman b ON a.SALESMAN_ID=b.SALESMAN_ID;

SELECT a.CUSTOMER_NAME, a.CITY, a.GRADE, b.SALESMAN_NAME, b.SALESMAN_CITY FROM customers a  
LEFT OUTER JOIN salesman b ON a.SALESMAN_ID=b.SALESMAN_ID WHERE a.GRADE<300  
ORDER BY a.CUSTOMER_ID;

SELECT a.CUSTOMER_NAME,a.CITY, b.SALESMAN_NAME, b.COMMISSION FROM customers a  
INNER JOIN salesman b ON a.SALESMAN_ID=b.SALESMAN_ID  
WHERE b.COMMISSION>12;

SELECT a.ORDER_NO, a.ORDER_DATE, a.PURCHASE_AMOUNT, b.CUSTOMER_NAME, b.GRADE, c.SALESMAN_NAME, c.COMMISSION FROM orders a  
INNER JOIN customers b ON a.CUSTOMER_ID=b.CUSTOMER_ID 
INNER JOIN salesman c ON a.SALESMAN_ID=c.SALESMAN_ID;
-----------Activity11--------------
SELECT CUSTOMER_ID, CUSTOMER_NAME FROM customers a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.CUSTOMER_ID = b.CUSTOMER_ID) 
UNION 
SELECT SALESMAN_ID, SALESMAN_NAME FROM salesman a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.SALESMAN_ID = b.SALESMAN_ID) 
ORDER BY CUSTOMER_NAME;

SELECT a.SALESMAN_ID, SALESMAN_NAME, ORDER_NO,ORDER_DATE FROM salesman a, orders b 
WHERE a.SALESMAN_ID=b.SALESMAN_ID 
AND b.PURCHASE_AMOUNT=(SELECT MAX(PURCHASE_AMOUNT) FROM orders c WHERE c.ORDER_DATE = b.ORDER_DATE) 
UNION 
SELECT a.SALESMAN_ID, SALESMAN_NAME, ORDER_NO, ORDER_DATE FROM salesman a, orders b 
WHERE a.SALESMAN_ID=b.SALESMAN_ID 
AND b.PURCHASE_AMOUNT=(SELECT MIN(PURCHASE_AMOUNT) FROM orders c WHERE c.ORDER_DATE = b.ORDER_DATE);

