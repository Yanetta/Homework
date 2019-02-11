
SELECT
    rep,
    AVG(amount)
FROM
    orders
GROUP BY
    rep;

SELECT
    rep_office,
    MIN(quota),
    MAX(quota)
FROM
    salesreps
GROUP BY
    rep_office;

SELECT
    rep_office,
    COUNT(*)
FROM
    salesreps
GROUP BY
    rep_office;

SELECT
    COUNT(DISTINCT cust_num),
    'customers for salesreps',
    cust_rep
FROM
    customers
GROUP BY
    cust_rep;

SELECT
    rep,
    cust,
    SUM(amount)
FROM
    orders
GROUP BY
    rep,
    cust;

SELECT
    rep,
    cust,
    SUM(amount)
FROM
    orders
GROUP BY
    rep,
    cust
ORDER BY
    rep,
    cust;

SELECT
    sa.name,
    SUM(ord.amount)
FROM
    orders      ord
    INNER JOIN salesreps   sa ON ord.rep = sa.empl_num
GROUP BY
    sa.name;

SELECT
    product,
    SUM(qty)
FROM
    orders
GROUP BY
    product;

SELECT
    hair,
    eyes,
    COUNT(*)
FROM
    coloris
GROUP BY
    hair,
    eyes;

SELECT
    product,
    MIN(qty)
FROM
    orders
GROUP BY
    product;

SELECT
    product,
    sort,
    SUM(qty)
FROM
    orders
GROUP BY
    product,
    sort;

SELECT
    rep,
    AVG(amount),
    SUM(amount)
FROM
    orders
GROUP BY
    rep
HAVING
    SUM(amount) > 300;

SELECT
    off.city,
    SUM(sal.quota),
    SUM(sal.sales)
FROM
    offices     off
    INNER JOIN salesreps   sal ON off.office = sal.rep_office
GROUP BY
    off.city
HAVING
    COUNT(*) >= 2;

SELECT
    description,
    price,
    qty_on_hand,
    SUM(qty)
FROM
    products   pr
    INNER JOIN orders     ord ON ord.mfr = pr.mfr_id
GROUP BY
    mfr_id,
    product_id,
    description,
    price,
    qty_on_hand
HAVING
    SUM(qty) > ( 0.75 * qty_on_hand )
ORDER BY
    qty_on_hand DESC;

SELECT
    description,
    price,
    qty_on_hand,
    SUM(qty)
FROM
    products   pr
    INNER JOIN orders     ord ON ord.mfr = pr.mfr_id
GROUP BY
    mfr_id,
    product_id,
    description,
    price,
    qty_on_hand
HAVING
    SUM(qty) > ( 0.75 * qty_on_hand )
ORDER BY
    qty_on_hand DESC;

SELECT
    product,
    sort,
    SUM(qty)
FROM
    orders
GROUP BY
    product,
    sort;

--скільки яких товірів купляли (скільки штук і чого купили всього)

SELECT
    product,
    SUM(qty)
FROM
    orders     ord
    INNER JOIN products   pr ON ord.product = pr.product_id
GROUP BY
    pr.product_id
ORDER BY
    pr.product_id;

SELECT
    description,
    SUM(qty)
FROM
    orders     ord
    INNER JOIN products   pr ON ord.product = pr.product_id
GROUP BY
    pr.description;


    -- Вивести товари, які купили більше 3-оьх разів (були в трьох і більше замовленнях)

SELECT
    product,
    COUNT(product)
FROM
    orders
GROUP BY
    product
HAVING
    COUNT(product) > 3;


-- Вивести офіси в яких працює більше трьох менеджерів

SELECT
    rep_office,
    COUNT(rep_office)
FROM
    salesreps
GROUP BY
    rep_office
HAVING
    COUNT(rep_office) > 3;

    -- Вивести середній вік по офісу

SELECT
    rep_office,
    COUNT(rep_office),
    AVG(age)
FROM
    salesreps
GROUP BY
    rep_office;

      --на табличках girls|boys зробить insert|update|delete. По два запити кожного типу з різною логікою

INSERT INTO boys (
    nm,
    name,
    city
) VALUES (
    '8',
    'Tom',
    'London'
);

INSERT INTO boys VALUES (
    '10',
    'Ted',
    'Liverpool'
);

SELECT
    *
FROM
    boys;

UPDATE girls
SET
    name = 'Tanya'
WHERE
    name = 'Tom';

SELECT
    *
FROM
    girls;

UPDATE girls
SET
    name = 'Alfred',
    city = 'Frankfurt'
WHERE
    nm = 2;

SELECT
    *
FROM
    girls;

DELETE FROM girls
WHERE
    nm = 3;

SELECT
    *
FROM
    girls;

DELETE FROM boys
WHERE
    nm = 8
    AND name = 'Tom';

SELECT
    *
FROM
    boys;

-- підзапити

SELECT
    *
FROM
    products
WHERE
    price = (
        SELECT
            MIN(price)
        FROM
            products
    );

SELECT
    *
FROM
    products
WHERE
    price > (
        SELECT
            AVG(price)
        FROM
            products
    );

SELECT
    *
FROM
    products
WHERE
    price < ALL (
        SELECT
            price
        FROM
            products
        WHERE
            mfr_id = 'IMM'
    );

--Дати перелік виробників що виготовляють більше 4-ьох товарів

SELECT
    mfr_id,
    COUNT(mfr_id)
FROM
    products
GROUP BY
    mfr_id
HAVING
    COUNT(mfr_id) > 4;

--Дати загальну кільсть товарів, що зберігаються на складі по виробникам що виготовляють більше 4-ьох товарів

SELECT
    mfr_id,
    SUM(qty_on_hand)
FROM
    products
GROUP BY
    mfr_id
HAVING
    COUNT(mfr_id) > 4;


-- Вивести імя компанії, скільки вона тратила в середньому на покупки товарів виробників, котрі виготовляють більше 4-ьох товарів

SELECT
    mfr_id,
    company,
    SUM(amount)
FROM
    products
    INNER JOIN orders ON orders.mfr = products.mfr_id
    INNER JOIN customers ON customers.cust_num = orders.cust
GROUP BY
    mfr_id,
    company
HAVING
    COUNT(mfr_id) > 4;
    
    
    
    
    
SELECT
    AVG(amount)
FROM
    orders;

SELECT
    s.empl_num,
    s.name,
    SUM(amount)
FROM
    orders      o
    INNER JOIN salesreps   s ON s.empl_num = o.rep
GROUP BY
    s.empl_num,
    s.name;

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Cindy',
    'Brown',
    'Blue'
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Louise',
    NULL,
    'Blue'
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Harry',
    NULL,
    'Blue'
);


INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Samantha',
    NULL,
    NULL
);


INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Joanne',
    NULL,
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'George',
    'Brown',
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Mary',
    'Brown',
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Paula',
    'Brown',
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Kevin',
    'Brown',
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Joel',
    'Brown',
    'Brown'
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Susan',
    'Blonde',
    'Blue'
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Marie',
    'Blonde',
    'Blue'
);
        
    
SELECT
    description
FROM
    products
WHERE
    description LIKE '%а%а%а%';
