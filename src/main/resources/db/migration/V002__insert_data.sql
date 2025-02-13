-- Inserção de dados na tabela event
INSERT INTO event (id, capacity, description, name) VALUES
                                                        ('550e8400-e29b-41d4-a716-446655440000', 100, 'Evento de tecnologia', 'Tech Summit'),
                                                        ('550e8400-e29b-41d4-a716-446655440001', 200, 'Festival de música', 'Music Fest');

-- Inserção de dados na tabela event_info
INSERT INTO event_info (id, address, event_end, event_start) VALUES
                                                                 ('660e8400-e29b-41d4-a716-446655440000', 'Rua A, 123', '2025-06-12 18:00:00', '2025-06-12 10:00:00'),
                                                                 ('660e8400-e29b-41d4-a716-446655440001', 'Rua B, 456', '2025-07-15 23:00:00', '2025-07-15 15:00:00');

-- Inserção de dados na tabela event_date
INSERT INTO event_date (event_id, date_id) VALUES
                                               ('550e8400-e29b-41d4-a716-446655440000', '660e8400-e29b-41d4-a716-446655440000'),
                                               ('550e8400-e29b-41d4-a716-446655440001', '660e8400-e29b-41d4-a716-446655440001');

-- Inserção de dados na tabela modality
INSERT INTO modality (id, type) VALUES
                                    ('770e8400-e29b-41d4-a716-446655440000', 'Presencial'),
                                    ('770e8400-e29b-41d4-a716-446655440001', 'Online');

-- Inserção de dados na tabela field
INSERT INTO field (id, description, name, type, modality_id) VALUES
                                                                 ('880e8400-e29b-41d4-a716-446655440000', 'Nome do participante', 'Nome', 'Texto', '770e8400-e29b-41d4-a716-446655440000'),
                                                                 ('880e8400-e29b-41d4-a716-446655440001', 'Email do participante', 'Email', 'Texto', '770e8400-e29b-41d4-a716-446655440001');

-- Inserção de dados na tabela organizer
INSERT INTO organizer (id) VALUES
                               ('990e8400-e29b-41d4-a716-446655440000'),
                               ('990e8400-e29b-41d4-a716-446655440001');

-- Inserção de dados na tabela event_organizers
INSERT INTO event_organizers (event_id, organizers_id) VALUES
                                                           ('550e8400-e29b-41d4-a716-446655440000', '990e8400-e29b-41d4-a716-446655440000'),
                                                           ('550e8400-e29b-41d4-a716-446655440001', '990e8400-e29b-41d4-a716-446655440001');

-- Inserção de dados na tabela person
INSERT INTO person (id, birthday, cpf, email, name, password) VALUES
                                                                  ('110e8400-e29b-41d4-a716-446655440000', '1990-01-01', '12345678900', 'user1@email.com', 'Usuário 1', 'senha123'),
                                                                  ('110e8400-e29b-41d4-a716-446655440001', '1985-05-10', '98765432100', 'user2@email.com', 'Usuário 2', 'senha456');

-- Inserção de dados na tabela ticket
INSERT INTO ticket (id, event_id, event_date_id, modality_id, owner_id) VALUES
                                                                            ('220e8400-e29b-41d4-a716-446655440000', '550e8400-e29b-41d4-a716-446655440000', '660e8400-e29b-41d4-a716-446655440000', '770e8400-e29b-41d4-a716-446655440000', '110e8400-e29b-41d4-a716-446655440000'),
                                                                            ('220e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440001', '660e8400-e29b-41d4-a716-446655440001', '770e8400-e29b-41d4-a716-446655440001', '110e8400-e29b-41d4-a716-446655440001');
