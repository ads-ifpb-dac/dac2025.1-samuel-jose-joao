-- Inserts for "event"
INSERT INTO event (id, capacity, description, name)
VALUES
    ('e1d0c600-8d57-4e9f-b1e6-2f5e4d64823a', 200, 'Tech Conference 2025', 'AI Innovations'),
    ('a3c1f7a2-41ed-4b8b-b555-5c1a44567912', 100, 'Music Festival', 'Rock in Rio');

-- Inserts for "event_info"
INSERT INTO event_info (id, address, event_end, event_start)
VALUES
    ('d2e7f1b5-0b42-4ae5-8eb5-d4f3f56cbfa6', '123 Main Street, Tech City', '2025-05-20 18:00:00', '2025-05-20 09:00:00'),
    ('c0a8e60b-3e8f-4628-802e-d2f5f8b6bf7b', '456 Music Avenue, Festival Town', '2025-06-15 23:59:00', '2025-06-15 12:00:00');

-- Inserts for "event_date"
INSERT INTO event_date (event_id, date_id)
VALUES
    ('e1d0c600-8d57-4e9f-b1e6-2f5e4d64823a', 'd2e7f1b5-0b42-4ae5-8eb5-d4f3f56cbfa6'),
    ('a3c1f7a2-41ed-4b8b-b555-5c1a44567912', 'c0a8e60b-3e8f-4628-802e-d2f5f8b6bf7b');

-- Inserts for "field_response"
INSERT INTO field_response (id, content)
VALUES
    ('f0c81df6-1e79-4dc3-a759-d90a5f8f6387', 'Yes'),
    ('b3a4c172-0f9c-4e47-9a85-f7d5394d12f3', 'No');

-- Inserts for "modality"
INSERT INTO modality (id, type)
VALUES
    ('c8f6bcd1-59d8-40a6-9d2e-fb8c6b93598f', 'Online'),
    ('a23cd85e-29c7-451a-b04c-bc47e63a0f2e', 'In-Person');

-- Inserts for "field"
INSERT INTO field (id, description, name, type, modality_id, response_id)
VALUES
    ('b9c68a5f-d90d-41b4-b928-d3f9cdb7ef50', 'Do you need special assistance?', 'Special Assistance', 'Checkbox', 'a23cd85e-29c7-451a-b04c-bc47e63a0f2e', 'f0c81df6-1e79-4dc3-a759-d90a5f8f6387'),
    ('e3f6a184-b8de-44ad-a62d-d5b39a0f3c98', 'Would you like to receive updates?', 'Receive Updates', 'Checkbox', 'c8f6bcd1-59d8-40a6-9d2e-fb8c6b93598f', 'b3a4c172-0f9c-4e47-9a85-f7d5394d12f3');

-- Inserts for "field_response_field"
INSERT INTO field_response_field (field_response_id, field_id)
VALUES
    ('f0c81df6-1e79-4dc3-a759-d90a5f8f6387', 'b9c68a5f-d90d-41b4-b928-d3f9cdb7ef50'),
    ('b3a4c172-0f9c-4e47-9a85-f7d5394d12f3', 'e3f6a184-b8de-44ad-a62d-d5b39a0f3c98');

-- Inserts for "organizer"
INSERT INTO organizer (id)
VALUES
    ('8f3c2be5-6d85-4dc1-93b1-cf6c08c21b9a'),
    ('b5e8a93c-2dc2-453c-bf98-d823cf7f5013');

-- Inserts for "event_organizers"
INSERT INTO event_organizers (event_id, organizers_id)
VALUES
    ('e1d0c600-8d57-4e9f-b1e6-2f5e4d64823a', '8f3c2be5-6d85-4dc1-93b1-cf6c08c21b9a'),
    ('a3c1f7a2-41ed-4b8b-b555-5c1a44567912', 'b5e8a93c-2dc2-453c-bf98-d823cf7f5013');

-- Inserts for "organizer_events"
INSERT INTO organizer_events (organizer_id, events_id)
VALUES
    ('8f3c2be5-6d85-4dc1-93b1-cf6c08c21b9a', 'e1d0c600-8d57-4e9f-b1e6-2f5e4d64823a'),
    ('b5e8a93c-2dc2-453c-bf98-d823cf7f5013', 'a3c1f7a2-41ed-4b8b-b555-5c1a44567912');

-- Inserts for "ticket_package"
INSERT INTO ticket_package (id, type)
VALUES
    ('9a8e7b4f-6f3c-4f9c-b321-a79d68d8a87b', 'Standard'),
    ('e7c5d9a3-4d4e-469b-b318-1f1e682f78bc', 'VIP');

-- Inserts for "person"
INSERT INTO person (id, birthday, cpf, email, name, password)
VALUES
    ('1f9c2d84-b7a8-4d6c-82c9-3a7f9d5f64f2', '1990-05-15', '12345678901', 'john.doe@example.com', 'John Doe', 'password123'),
    ('2c7f8b19-d3a8-4e7d-a8b7-4c9f3d2e6f1b', '1985-09-22', '98765432109', 'jane.smith@example.com', 'Jane Smith', 'securepassword');

-- Inserts for "ticket"
INSERT INTO ticket (id, event_id, event_date_id, modality_id, owner_id)
VALUES
    ('ad9f1b6e-c3f4-4e7a-8d2b-9f6c2d7e9b1f', 'e1d0c600-8d57-4e9f-b1e6-2f5e4d64823a', 'd2e7f1b5-0b42-4ae5-8eb5-d4f3f56cbfa6', 'c8f6bcd1-59d8-40a6-9d2e-fb8c6b93598f', '1f9c2d84-b7a8-4d6c-82c9-3a7f9d5f64f2'),
    ('c5f7b3e8-4d8a-4f7c-b9d8-6f3a2b7d5c1e', 'a3c1f7a2-41ed-4b8b-b555-5c1a44567912', 'c0a8e60b-3e8f-4628-802e-d2f5f8b6bf7b', 'a23cd85e-29c7-451a-b04c-bc47e63a0f2e', '2c7f8b19-d3a8-4e7d-a8b7-4c9f3d2e6f1b');

-- Inserts for "ticket_response_list"
INSERT INTO ticket_response_list (ticket_id, response_list_id)
VALUES
    ('ad9f1b6e-c3f4-4e7a-8d2b-9f6c2d7e9b1f', 'f0c81df6-1e79-4dc3-a759-d90a5f8f6387'),
    ('c5f7b3e8-4d8a-4f7c-b9d8-6f3a2b7d5c1e', 'b3a4c172-0f9c-4e47-9a85-f7d5394d12f3');

-- Inserts for "ticket_package_tickets"
INSERT INTO ticket_package_tickets (ticket_package_id, tickets_id)
VALUES
    ('9a8e7b4f-6f3c-4f9c-b321-a79d68d8a87b', 'ad9f1b6e-c3f4-4e7a-8d2b-9f6c2d7e9b1f'),
    ('e7c5d9a3-4d4e-469b-b318-1f1e682f78bc', 'c5f7b3e8-4d8a-4f7c-b9d8-6f3a2b7d5c1e');
