-- Inserção na tabela event
INSERT INTO event (id, name, description, capacity) VALUES
                                                        ('550e8400-e29b-41d4-a716-446655440000', 'Tech Conference', 'A conference about technology', 500),
                                                        ('550e8400-e29b-41d4-a716-446655440001', 'Music Festival', 'An outdoor music festival', 1000);

-- Inserção na tabela event_info
INSERT INTO event_info (id, event_start, event_end, address) VALUES
                                                                 ('660e8400-e29b-41d4-a716-446655440000', '2025-06-15 09:00:00', '2025-06-15 18:00:00', '123 Main St'),
                                                                 ('660e8400-e29b-41d4-a716-446655440001', '2025-07-10 12:00:00', '2025-07-10 23:00:00', '456 Park Ave');

-- Inserção na tabela event_date
INSERT INTO event_date (event_id, date_id) VALUES
                                               ('550e8400-e29b-41d4-a716-446655440000', '660e8400-e29b-41d4-a716-446655440000'),
                                               ('550e8400-e29b-41d4-a716-446655440001', '660e8400-e29b-41d4-a716-446655440001');

-- Inserção na tabela modality
INSERT INTO modality (id, type) VALUES
                                    ('770e8400-e29b-41d4-a716-446655440000', 'Online'),
                                    ('770e8400-e29b-41d4-a716-446655440001', 'In-person');

-- Inserção na tabela field
INSERT INTO field (id, name, type, description, is_unique, is_not_null, modality_id) VALUES
                                                                                         ('880e8400-e29b-41d4-a716-446655440000', 'Email', 'String', 'User email field', TRUE, TRUE, '770e8400-e29b-41d4-a716-446655440000'),
                                                                                         ('880e8400-e29b-41d4-a716-446655440001', 'Phone Number', 'String', 'User phone number', FALSE, FALSE, '770e8400-e29b-41d4-a716-446655440001');

-- Inserção na tabela field_response
INSERT INTO field_response (id, content, field_id) VALUES
                                                       ('990e8400-e29b-41d4-a716-446655440000', 'user@example.com', '880e8400-e29b-41d4-a716-446655440000'),
                                                       ('990e8400-e29b-41d4-a716-446655440001', '555-1234', '880e8400-e29b-41d4-a716-446655440001');

-- Inserção na tabela person
INSERT INTO person (id, name, email, password, cpf, birthday) VALUES
                                                                  ('aa0e8400-e29b-41d4-a716-446655440000', 'John Doe', 'johndoe@example.com', 'hashedpassword', '12345678900', '1990-05-20'),
                                                                  ('aa0e8400-e29b-41d4-a716-446655440001', 'Jane Smith', 'janesmith@example.com', 'hashedpassword', '98765432100', '1985-08-15');

-- Inserção na tabela ticket
INSERT INTO ticket (id, event_id, owner_id, event_date_id, modality_id) VALUES
                                                                            ('bb0e8400-e29b-41d4-a716-446655440000', '550e8400-e29b-41d4-a716-446655440000', 'aa0e8400-e29b-41d4-a716-446655440000', '660e8400-e29b-41d4-a716-446655440000', '770e8400-e29b-41d4-a716-446655440000'),
                                                                            ('bb0e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440001', 'aa0e8400-e29b-41d4-a716-446655440001', '660e8400-e29b-41d4-a716-446655440001', '770e8400-e29b-41d4-a716-446655440001');

/*
-- Inserção na tabela promo_ticket
INSERT INTO promo_ticket (id, modalityId, eventId, event_date_id) VALUES
                                                                        (1, '770e8400-e29b-41d4-a716-446655440000', '550e8400-e29b-41d4-a716-446655440000', '660e8400-e29b-41d4-a716-446655440000'),
                                                                        (2, '770e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440001', '660e8400-e29b-41d4-a716-446655440001');

-- Inserção na tabela ticket_package
INSERT INTO ticket_package (id, type) VALUES
                                          ('cc0e8400-e29b-41d4-a716-446655440000', 'VIP Package'),
                                          ('cc0e8400-e29b-41d4-a716-446655440001', 'Standard Package');*/
