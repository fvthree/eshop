INSERT INTO user (
    id,
    name,
    username,
    email,
    password,
    date_created,
    last_updated,
    is_active,
    is_not_locked,
    street,
    apartment,
    city,
    zip,
    country,
    phone,
    is_admin
) VALUES (
    1200,
    'script',
    'script',
    'script@mail.com',
    '$2y$10$WQFJJNCqqo/Wb3gWo4APa.IKW5BCakkrmHNrcwtysNicPMc1c2srW',
    '2022-02-05 04:30:00',
    '2022-02-05 04:30:00',
    1,
    1,
    'Highstreet',
    'Jinga',
    'Manila',
    '4223',
    'PH',
    '+631231234',
    true
);

INSERT INTO category (
    id,
    name,
    color,
    icon,
    image,
    date_created,
    last_updated
) VALUES (
    2000,
    'Hats',
    'White',
    'icon.png',
    'image.png',
    '2022-02-12 04:30:00',
    '2022-02-12 04:30:00'
);

INSERT INTO product (
    id,
    name,
    description,
    rich_description,
    image,
    brand,
    price,
    category_id,
    count_in_stock,
    rating,
    num_reviews,
    is_featured,
    date_created,
    last_updated
) VALUES (
    1000,
    'Accessory',
    'White',
    'white accessory',
    'accesory.png',
    'Silver',
    100.00,
    2000,
    10,
    5.0,
    22,
    false,
    '2022-02-12 04:30:00',
    '2022-02-12 04:30:00'
);

INSERT INTO category (
    id,
    name,
    color,
    icon,
    image,
    date_created,
    last_updated
) VALUES (
    1000,
    'Hats',
    'White',
    'icon.png',
    'image.png',
    '2022-02-06 04:30:00',
    '2022-02-06 04:30:00'
);