INSERT INTO event (id, capacity, description, name)
VALUES ('123e4567-e89b-12d3-a456-426614174000', 100, 'Tech Conference', 'TechCon 2025');

INSERT INTO event_info (id, address, event_end, event_start)
VALUES ('123e4567-e89b-12d3-a456-426614174001', '123 Tech Street', '2025-12-01 18:00:00', '2025-12-01 09:00:00');

INSERT INTO event_date (event_id, date_id)
VALUES ('123e4567-e89b-12d3-a456-426614174000', '123e4567-e89b-12d3-a456-426614174001');

INSERT INTO field_response (id, content, field_id)
VALUES ('123e4567-e89b-12d3-a456-426614174002', 'Response Content', '123e4567-e89b-12d3-a456-426614174003');

INSERT INTO modality (id, type)
VALUES ('123e4567-e89b-12d3-a456-426614174004', 'Online');

INSERT INTO field (id, description, name, type, modality_id, response_id)
VALUES ('123e4567-e89b-12d3-a456-426614174003', 'Field Description', 'Field Name', 'Text', '123e4567-e89b-12d3-a456-426614174004', '123e4567-e89b-12d3-a456-426614174002');

INSERT INTO field_response_field (field_response_id, field_id)
VALUES ('123e4567-e89b-12d3-a456-426614174002', '123e4567-e89b-12d3-a456-426614174003');

INSERT INTO organizer (id)
VALUES ('123e4567-e89b-12d3-a456-426614174005');

INSERT INTO event_organizers (event_id, organizers_id)
VALUES ('123e4567-e89b-12d3-a456-426614174000', '123e4567-e89b-12d3-a456-426614174005');

INSERT INTO organizer_events (organizer_id, events_id)
VALUES ('123e4567-e89b-12d3-a456-426614174005', '123e4567-e89b-12d3-a456-426614174000');

INSERT INTO ticket_package (id, type)
VALUES ('123e4567-e89b-12d3-a456-426614174006', 'VIP');

INSERT INTO person (id, birthday, cpf, email, name, password)
VALUES ('123e4567-e89b-12d3-a456-426614174007', '1990-01-01 00:00:00', '12345678900', 'john.doe@example.com', 'John Doe', 'password123');

INSERT INTO ticket (id, event_id, event_date_id, modality_id, owner_id)
VALUES ('123e4567-e89b-12d3-a456-426614174008', '123e4567-e89b-12d3-a456-426614174000', '123e4567-e89b-12d3-a456-426614174001', '123e4567-e89b-12d3-a456-426614174004', '123e4567-e89b-12d3-a456-426614174007');

INSERT INTO ticket_response_list (ticket_id, response_list_id)
VALUES ('123e4567-e89b-12d3-a456-426614174008', '123e4567-e89b-12d3-a456-426614174002');

INSERT INTO ticket_package_tickets (ticket_package_id, tickets_id)
VALUES ('123e4567-e89b-12d3-a456-426614174006', '123e4567-e89b-12d3-a456-426614174008');