TRUNCATE TABLE
    product_prices,
    sizes,
    products
    RESTART IDENTITY
    CASCADE;

INSERT INTO products (name, description)
VALUES
    ('Breloc cu capsuna', 'acrylic, wool'),
    ('Iepuraș de pluș cu pălărie', 'micropolyester'),
    ('Iepuraș de pluș croșetat', 'polyester'),
    ('Cardigan alb cu dungi albastru închis, cu mâneci scurte', 'bumbac, acrylic'),
    ('Top cu panglică albastră', 'bumbac, acrylic'),
    ('Geantă croșetată', 'bumbac'),
    ('Breloc broscuță', 'acrylic'),
    ('Breloc pisică cu căști', 'acrylic, wool, alpaca wool'),
    ('Geantă cu fundițe', 'micropolyester'),
    ('Fustă midi cu șliț', 'bumbac, mătase'),
    ('Iepuraș de pluș cu salopetă', 'poliacryl'),
    ('Bolero croșetat', 'acrylic, mohair'),
    ('Rochie de plajă', 'lână, bumbac, poliacril'),
    ('Breloc inimioară', 'acrylic'),
    ('Geantă albă', 'polyester'),
    ('Fundiță roșie de păr', 'acrylic'),
    ('Decorațiune cu Lăcrămioare', 'bumbac, polyester'),
    ('Cute daisy flower coaster', 'acrylic'),
    ('Leaf Sprout | Headphone accessory & Cable tie', 'acrylic'),
    ('Heart Mesh Top', 'acrylic'),
    ('Reversible top for spring', 'bumbac, acrylic'),
    ('Pink Paw', 'x'),
    ('Lily of the Valley', 'bumbac, polyester'),
    ('Cardigan croșetat', 'bumbac, acrylic'),
    ('Winter mask with pink braids', 'acrylic'),
    ('Fundiță de păr', 'acrylic'),
    ('Floare croșetată', 'bumbac, acrylic'),
    ('Căciulă neagră cu galben', 'acrylic, mohair'),
    ('Pink Scrunchie', 'bumbac'),
    ('Bluză croșetată', 'alpaca'),
    ('Sad Hamster', 'bumbac'),
    ('Stretchy Wool Crop Top', 'lână, alpaca, acrylic'),
    ('Grapefruit', 'bumbac'),
    ('Crochet Top', 'bumbac, acrylic');

INSERT INTO sizes (id, label)
VALUES
    (1, 'XS'),
    (2, 'S'),
    (3, 'M'),
    (4, 'L'),
    (5, 'XL'),
    (6, '-');


INSERT INTO product_prices (product_id, size_id, price)
VALUES
    (1,6,28),
    (2,6,95),
    (5,1,65),
    (6,1,80),
    (6,2,80),
    (6,3,80),
    (7,2,70),
    (7,3,70),
    (7,4,70),
    (8,6,97),
    (9,6,30),
    (10,6,40),
    (11,6,310),
    (12,3,350),
    (12,4,350),
    (13,6,160),
    (14,2,200),
    (14,3,200),
    (15,2,210),
    (15,3,210),
    (15,4,210),
    (16,6,42),
    (17,6,200),
    (18,6,40),
    (19,6,40),
    (20,6,30),
    (21,6,17),
    (22,6,56),
    (23,6,40),
    (24,6,40),
    (25,6,40),
    (26,6,40);
