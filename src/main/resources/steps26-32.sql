
SELECT DISTINCT
    company
FROM
    orders      ord
    INNER JOIN products    pr ON ord.product = pr.product_id
    INNER JOIN customers   cus ON ord.cust = cus.cust_num
WHERE
    pr.description LIKE '%a%'
    OR pr.description LIKE '%A%'
    OR pr.description LIKE '%А%'
    OR pr.description LIKE '%а%';

SELECT DISTINCT
    *
FROM
    orders      ord
    INNER JOIN products    pr ON ord.product = pr.product_id
    INNER JOIN customers   cus ON ord.cust = cus.cust_num
WHERE
    pr.description LIKE '%a%'
    OR pr.description LIKE '%A%'
    OR pr.description LIKE '%А%'
    OR pr.description LIKE '%а%';

SELECT
    order_num,
    amount,
    company,
    credit_limit
FROM
    orders      ord
    INNER JOIN customers   cu ON ord.cust = cu.cust_num;

SELECT
    sort,
    city,
    region
FROM
    salesreps   s
    INNER JOIN offices     o ON s.rep_office = o.office;

SELECT
    sort,
    city,
    title
FROM
    salesreps   s
    INNER JOIN offices     o1 ON s.empl_num = o1.mgr;

SELECT
    sort,
    city,
    title
FROM
    salesreps   s
    INNER JOIN offices     o1 ON s.empl_num = o1.mgr
WHERE
    target > 600.00;

SELECT
    order_num,
    amount,
    description
FROM
    orders     ord
    INNER JOIN products   pr ON ord.mfr = pr.mfr_id
                              AND ord.product = pr.product_id;

SELECT
    order_num,
    amount,
    company,
    sort
FROM
    orders      ord
    INNER JOIN customers   cu ON ord.cust = cu.cust_num
    INNER JOIN salesreps   sal ON sal.empl_num = ord.rep
WHERE
    amount > 700;

SELECT
    order_num,
    amount,
    company,
    sort
FROM
    orders      ord
    INNER JOIN customers   cu ON ord.cust = cu.cust_num
    INNER JOIN salesreps   sal ON sal.empl_num = cu.cust_rep
WHERE
    amount > 700;

SELECT
    order_num,
    amount,
    company,
    sort,
    city
FROM
    orders      ord
    INNER JOIN customers   cu ON ord.cust = cu.cust_num
    INNER JOIN salesreps   sal ON sal.empl_num = cu.cust_rep
    INNER JOIN offices     off ON off.office = sal.rep_office
WHERE
    amount > 700;

SELECT
    order_num,
    amount,
    order_date,
    sort
FROM
    orders      ord
    INNER JOIN salesreps   sal ON ord.order_date = sal.hire_date;

SELECT
    sort,
    quota,
    city,
    target
FROM
    salesreps   sal
    INNER JOIN offices     off ON sal.quota > off.target;

SELECT
    sort,
    sal.sales,
    city
FROM
    salesreps   sal
    INNER JOIN offices     o1 ON sal.rep_office = o1.office;

SELECT
    *
FROM
    salesreps   sal
    INNER JOIN offices     off ON sal.rep_office = off.office;

SELECT
    sal.*,
    city,
    region
FROM
    salesreps   sal
    INNER JOIN offices     off ON sal.rep_office = off.office;

SELECT
    sort
FROM
    salesreps
WHERE
    manager = empl_num;

SELECT
    emps.sort,
    mgrs.sort
FROM
    salesreps   emps 
    INNER JOIN salesreps   mgrs on emps.manager = mgrs.empl_num;

SELECT
    salesreps.sort,
    mgrs.sort
FROM
    salesreps
    INNER JOIN salesreps mgrs ON salesreps.manager = mgrs.empl_num;

SELECT
    sal.sort,
    mgrs.sort
FROM
    salesreps sal 
    INNER JOIN salesreps mgrs on sal.manager = mgrs.empl_num;

SELECT
    salesreps.sort,
    salesreps.quota,
    mgrs.quota
FROM
    salesreps
    INNER JOIN salesreps mgrs ON salesreps.manager = mgrs.empl_num
                                 AND salesreps.quota > mgrs.quota;

SELECT
    emps.sort,
    emp_office.city,
    mgrs.sort,
    mgr_office.city
FROM
    salesreps   emps
    INNER JOIN salesreps   mgrs ON emps.manager = mgrs.empl_num
    INNER JOIN offices     emp_office ON emps.rep_office = emp_office.office
    INNER JOIN offices     mgr_office ON mgrs.rep_office = mgr_office.office
                                     AND emps.rep_office <> mgrs.rep_office;

SELECT
    salesreps.sort,
    offices.city
FROM
    salesreps,
    offices;

SELECT
    sort,
    city
FROM
    salesreps,
    offices;

SELECT
    AVG(quota),
    AVG(sales)
FROM
    salesreps;

SELECT
    AVG(100 *(sales / quota))
FROM
    salesreps;

SELECT
    AVG(100 *(sales / quota)) procent
FROM
    salesreps;

SELECT
    SUM(quota),
    SUM(sales)
FROM
    salesreps;

SELECT
    SUM(amount)
FROM
    orders      ord
    INNER JOIN salesreps   sa ON sa.sort = 'Дима Маликов'
                               AND ord.rep = sa.empl_num;

SELECT
    AVG(price)
FROM
    products
WHERE
    mfr_id = 'ACI';

SELECT
    AVG(amount)
FROM
    orders
WHERE
    cust = 2103;

SELECT
    MIN(quota),
    MAX(quota)
FROM
    salesreps;

SELECT
    MIN(order_date)
FROM
    orders;

SELECT
    MAX(100 *(sales / quota))
FROM
    salesreps;

SELECT
    COUNT(cust_num)
FROM
    customers;

SELECT
    COUNT(sort)
FROM
    salesreps
WHERE
    sales > quota;

SELECT
    COUNT(amount)
FROM
    orders
WHERE
    amount > 250;

SELECT
    COUNT(*)
FROM
    orders
WHERE
    amount > 250;

SELECT
    AVG(amount),
    SUM(amount),
    ( 100 * AVG(amount / credit_limit) ),
    ( 100 * AVG(amount / quota) )
FROM
    orders      ord
    INNER JOIN customers   cu ON ord.cust = cu.cust_num
    INNER JOIN salesreps   sa ON sa.empl_num = ord.rep;

SELECT
    amount,
    amount,
    amount / credit_limit,
    amount / quota
FROM
    orders      ord
    INNER JOIN customers   cu ON ord.cust = cu.cust_num
    INNER JOIN salesreps   sa ON sa.empl_num = ord.rep;
