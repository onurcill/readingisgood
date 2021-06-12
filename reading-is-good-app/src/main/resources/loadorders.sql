INSERT INTO orders(id, date_created, last_updated, order_tracking_number, status, total_price, total_quantity, customer_id) VALUES (10, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1234, 'IN_PROGRESS', 3000, 3, 1);

INSERT INTO order_item(id, book_id, quantity, unit_price, order_id) VALUES (100, 1, 3, 3000, 10);