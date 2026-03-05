
TRUNCATE TABLE products RESTART IDENTITY CASCADE;

-- local testing data for products
INSERT INTO products (name, description, price, image_url, category) VALUES
('Premium Makhana', 'Spicy and tangy roasted nuts. High in Protein, Gluten-Free.', 219.00, '/uploads/product2.jpg', 'Flavored'),
('Salted Makhana', 'Lightly roasted with Himalayan Pink Salt. Perfect daily healthy snack.', 179.00, '/uploads/product1.jpg', 'Roasted'),
('Crunch Makhana', 'Got a sweet tooth? Enjoy our golden caramel coated makhana for a premium dessert snack.', 299.00, '/uploads/makhana.jpg', 'Flavored');


-- Dummy user data for testing
INSERT INTO users (name, email, password, role, phone, address) VALUES ('Tech Evendri', 'user@evendri.com', 'user@123', 'ROLE_USER', '9993291765', 'Bhopal') ON CONFLICT (email) DO NOTHING;

-- Admin user for testing
INSERT INTO users (name, email, password, role, phone, address) VALUES ('Evendri Admin', 'evendriadmin@evendri.com', 'admin2123', 'ROLE_ADMIN', '0000000000', 'Head Office') ON CONFLICT (email) DO NOTHING;