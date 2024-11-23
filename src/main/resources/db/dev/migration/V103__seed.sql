-- Insert Standard Products
INSERT INTO productdb.product (name, description, price, final_price, type)
VALUES ('Wireless Bluetooth Headphones', 'High-quality wireless headphones with noise-cancelling feature.', 99.99, null, 'Standard'),
       ('Smart Watch', 'Multifunctional smart watch with heart rate monitor and GPS.',199.99, null, 'Standard');

-- Insert Basic Products
INSERT INTO productdb.product (name, description, price, final_price, type)
VALUES ('USB Flash Drive 32GB', 'Portable USB 3.0 flash drive with 32GB storage capacity.', 9.99, null,'Basic'),
       ('Wireless Mouse', 'Ergonomic wireless mouse with 2.4GHz connectivity.', 14.99, null, 'Basic');

-- Insert Default Products
INSERT INTO productdb.product (name, description, price, final_price, type)
VALUES ('Eco-Friendly Water Bottle', 'Reusable water bottle made from sustainable materials.', 19.99, null, 'Default'),
       ('Yoga Mat', 'Non-slip yoga mat with extra thickness for comfort.', 24.99, null, 'Default');