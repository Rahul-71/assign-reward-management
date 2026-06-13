INSERT INTO customer (id, name, email) VALUES (1, 'Clark', 'clark@gmail.com');
INSERT INTO customer (id, name, email) VALUES (2, 'Kartos', 'kartos@gmail.com');
INSERT INTO customer (id, name, email) VALUES (3, 'Harry', 'harry@gmail.com');

INSERT INTO transaction_record (transaction_id, customer_id, amount, transaction_date) VALUES (1,  1, 120.00, TIMESTAMP '2026-04-05 10:30:00');
INSERT INTO transaction_record (transaction_id, customer_id, amount, transaction_date) VALUES (2,  1,  75.00, TIMESTAMP '2026-04-20 14:00:00');
INSERT INTO transaction_record (transaction_id, customer_id, amount, transaction_date) VALUES (3,  1, 200.00, TIMESTAMP '2026-05-10 09:15:00');
INSERT INTO transaction_record (transaction_id, customer_id, amount, transaction_date) VALUES (4,  1,  45.00, TIMESTAMP '2026-05-25 16:45:00');
INSERT INTO transaction_record (transaction_id, customer_id, amount, transaction_date) VALUES (5,  1, 110.00, TIMESTAMP '2026-06-05 11:00:00');

INSERT INTO transaction_record (transaction_id, customer_id, amount, transaction_date) VALUES (6,  2,  80.00, TIMESTAMP '2026-04-15 13:30:00');
INSERT INTO transaction_record (transaction_id, customer_id, amount, transaction_date) VALUES (7,  2, 150.00, TIMESTAMP '2026-05-08 10:00:00');
INSERT INTO transaction_record (transaction_id, customer_id, amount, transaction_date) VALUES (8,  2,  60.00, TIMESTAMP '2026-05-22 15:20:00');
INSERT INTO transaction_record (transaction_id, customer_id, amount, transaction_date) VALUES (9,  2, 120.00, TIMESTAMP '2026-06-01 09:45:00');
INSERT INTO transaction_record (transaction_id, customer_id, amount, transaction_date) VALUES (10, 2,  35.00, TIMESTAMP '2026-06-10 17:00:00');

INSERT INTO transaction_record (transaction_id, customer_id, amount, transaction_date) VALUES (11, 3, 250.00, TIMESTAMP '2026-04-03 08:00:00');
INSERT INTO transaction_record (transaction_id, customer_id, amount, transaction_date) VALUES (12, 3, 100.00, TIMESTAMP '2026-05-15 12:30:00');
INSERT INTO transaction_record (transaction_id, customer_id, amount, transaction_date) VALUES (13, 3,  55.00, TIMESTAMP '2026-06-08 14:15:00');
