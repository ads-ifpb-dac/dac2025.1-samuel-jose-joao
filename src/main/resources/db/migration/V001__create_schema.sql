-- Criação da tabela flyway_schema_history
DROP TABLE IF EXISTS flyway_schema_history;

CREATE TABLE IF NOT EXISTS flyway_schema_history (
    installed_rank INTEGER NOT NULL PRIMARY KEY,
    version VARCHAR(50),
    description VARCHAR(200) NOT NULL,
    type VARCHAR(20) NOT NULL,
    script VARCHAR(1000) NOT NULL,
    checksum INTEGER,
    installed_by VARCHAR(100) NOT NULL,
    installed_on TIMESTAMP DEFAULT now() NOT NULL,
    execution_time INTEGER NOT NULL,
    success BOOLEAN NOT NULL
);

ALTER TABLE flyway_schema_history
    OWNER TO postgres;

CREATE INDEX IF NOT EXISTS flyway_schema_history_s_idx
    ON flyway_schema_history (success);

-- Criação da tabela event
CREATE TABLE IF NOT EXISTS event (
   id UUID NOT NULL PRIMARY KEY,
   capacity INTEGER,
   description VARCHAR(255),
   name VARCHAR(255)
);

ALTER TABLE event
    OWNER TO postgres;

-- Criação da tabela event_info
CREATE TABLE IF NOT EXISTS event_info (
     id UUID NOT NULL PRIMARY KEY,
     address VARCHAR(255),
     event_end TIMESTAMP(6),
     event_start TIMESTAMP(6)
);

ALTER TABLE event_info
    OWNER TO postgres;

-- Criação da tabela event_date
CREATE TABLE IF NOT EXISTS event_date (
   event_id UUID NOT NULL REFERENCES event,
   date_id UUID NOT NULL UNIQUE REFERENCES event_info
);

ALTER TABLE event_date
    OWNER TO postgres;

-- Criação da tabela field_response
CREATE TABLE IF NOT EXISTS field_response (
   id UUID NOT NULL PRIMARY KEY,
   content VARCHAR(255)
);

ALTER TABLE field_response
    OWNER TO postgres;

-- Criação da tabela modality
CREATE TABLE IF NOT EXISTS modality (
   id UUID NOT NULL PRIMARY KEY,
   type VARCHAR(255)
);

ALTER TABLE modality
    OWNER TO postgres;

-- Criação da tabela field
CREATE TABLE IF NOT EXISTS field (
   id UUID NOT NULL PRIMARY KEY,
   description VARCHAR(255),
   name VARCHAR(255),
   type VARCHAR(255),
   modality_id UUID REFERENCES modality,
   response_id UUID UNIQUE REFERENCES field_response
);

ALTER TABLE field
    OWNER TO postgres;

-- Criação da tabela field_response_field
CREATE TABLE IF NOT EXISTS field_response_field (
   field_response_id UUID NOT NULL REFERENCES field_response,
   field_id UUID NOT NULL UNIQUE REFERENCES field
);

ALTER TABLE field_response_field
    OWNER TO postgres;

-- Criação da tabela organizer
CREATE TABLE IF NOT EXISTS organizer (
   id UUID NOT NULL PRIMARY KEY
);

ALTER TABLE organizer
    OWNER TO postgres;

-- Criação da tabela event_organizers
CREATE TABLE IF NOT EXISTS event_organizers (
    event_id UUID NOT NULL REFERENCES event,
    organizers_id UUID NOT NULL REFERENCES organizer
);

ALTER TABLE event_organizers
    OWNER TO postgres;

-- Criação da tabela organizer_events
CREATE TABLE IF NOT EXISTS organizer_events (
   organizer_id UUID NOT NULL REFERENCES organizer,
   events_id UUID NOT NULL REFERENCES event
);

ALTER TABLE organizer_events
    OWNER TO postgres;

-- Criação da tabela ticket
CREATE TABLE IF NOT EXISTS ticket (
     id UUID NOT NULL PRIMARY KEY,
     event_id UUID REFERENCES event,
     event_date_id UUID REFERENCES event_info,
     modality_id UUID REFERENCES modality,
     owner_id UUID
);

ALTER TABLE ticket
    OWNER TO postgres;

-- Criação da tabela ticket_response_list
CREATE TABLE IF NOT EXISTS ticket_response_list (
   ticket_id UUID NOT NULL REFERENCES ticket,
   response_list_id UUID NOT NULL UNIQUE REFERENCES field_response
);

ALTER TABLE ticket_response_list
    OWNER TO postgres;

-- Criação da tabela ticket_package
CREATE TABLE IF NOT EXISTS ticket_package (
   id UUID NOT NULL PRIMARY KEY,
   type VARCHAR(255)
);

ALTER TABLE ticket_package
    OWNER TO postgres;

-- Criação da tabela ticket_package_tickets
CREATE TABLE IF NOT EXISTS ticket_package_tickets (
    ticket_package_id UUID NOT NULL REFERENCES ticket_package,
    tickets_id UUID NOT NULL UNIQUE REFERENCES ticket
);

ALTER TABLE ticket_package_tickets
    OWNER TO postgres;


-- Inserindo dados na tabela flyway_schema_history
INSERT INTO flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success)
VALUES
    (1, '1.0', 'Inicialização do banco de dados', 'SQL', 'V1__init_schema.sql', 123456, 'admin', now(), 100, true),
    (2, '1.1', 'Alteração do esquema para adicionar nova tabela', 'SQL', 'V2__add_new_table.sql', 654321, 'admin', now(), 120, true);

-- Inserindo dados na tabela event
INSERT INTO event (id, capacity, description, name)
VALUES
    ('b8f8f7c7-dfcb-4c67-9c1f-1d531e6fcb56', 200, 'Evento de Tecnologia', 'Tech Conference'),
    ('5b96bb68-b6b2-4a0f-bb8a-dfcd35a7b4db', 500, 'Evento de Música', 'Music Festival');

-- Inserindo dados na tabela event_info
INSERT INTO event_info (id, address, event_end, event_start)
VALUES
    ('dc4316f0-cf47-433b-91d9-8b8a527f9d59', 'Rua 123, São Paulo, SP', '2025-02-01 18:00:00', '2025-02-01 08:00:00'),
    ('b278f65c-6e8d-4fae-bde0-980b48151235', 'Avenida Central, Rio de Janeiro, RJ', '2025-03-15 20:00:00', '2025-03-15 10:00:00');

-- Inserindo dados na tabela event_date
INSERT INTO event_date (event_id, date_id)
VALUES
    ('b8f8f7c7-dfcb-4c67-9c1f-1d531e6fcb56', 'dc4316f0-cf47-433b-91d9-8b8a527f9d59'),
    ('5b96bb68-b6b2-4a0f-bb8a-dfcd35a7b4db', 'b278f65c-6e8d-4fae-bde0-980b48151235');

-- Inserindo dados na tabela field_response
INSERT INTO field_response (id, content)
VALUES
    ('7ac8f6b4-5d61-44e6-8fcb-8c7d2b477d67', 'Resposta 1'),
    ('e3d973fc-cab5-4a60-a788-b2de5a2a7e69', 'Resposta 2');

-- Inserindo dados na tabela modality
INSERT INTO modality (id, type)
VALUES
    ('90217a76-7b77-4f60-8b58-12e74b647320', 'Virtual'),
    ('e60d4268-9fcf-4c4a-b831-8b378e320ab0', 'Presencial');

-- Inserindo dados na tabela field
INSERT INTO field (id, description, name, type, modality_id, response_id)
VALUES
    ('5b28dcbf-bd87-49fc-a72f-d8cbf120682d', 'Campo de inscrição', 'Inscrição', 'Texto', '90217a76-7b77-4f60-8b58-12e74b647320', '7ac8f6b4-5d61-44e6-8fcb-8c7d2b477d67'),
    ('69e7b421-b16f-44c5-b271-4f62fe8ff9c5', 'Campo de feedback', 'Feedback', 'Texto', 'e60d4268-9fcf-4c4a-b831-8b378e320ab0', 'e3d973fc-cab5-4a60-a788-b2de5a2a7e69');

-- Inserindo dados na tabela field_response_field
INSERT INTO field_response_field (field_response_id, field_id)
VALUES
    ('7ac8f6b4-5d61-44e6-8fcb-8c7d2b477d67', '5b28dcbf-bd87-49fc-a72f-d8cbf120682d'),
    ('e3d973fc-cab5-4a60-a788-b2de5a2a7e69', '69e7b421-b16f-44c5-b271-4f62fe8ff9c5');

-- Inserindo dados na tabela organizer
INSERT INTO organizer (id)
VALUES
    ('bb5f3e62-3d0f-4aaf-a9d7-9d510bf2a30f'),
    ('7f348d99-ff57-4e16-b5a9-e7a4c5d981d6');

-- Inserindo dados na tabela event_organizers
INSERT INTO event_organizers (event_id, organizers_id)
VALUES
    ('b8f8f7c7-dfcb-4c67-9c1f-1d531e6fcb56', 'bb5f3e62-3d0f-4aaf-a9d7-9d510bf2a30f'),
    ('5b96bb68-b6b2-4a0f-bb8a-dfcd35a7b4db', '7f348d99-ff57-4e16-b5a9-e7a4c5d981d6');

-- Inserindo dados na tabela organizer_events
INSERT INTO organizer_events (organizer_id, events_id)
VALUES
    ('bb5f3e62-3d0f-4aaf-a9d7-9d510bf2a30f', 'b8f8f7c7-dfcb-4c67-9c1f-1d531e6fcb56'),
    ('7f348d99-ff57-4e16-b5a9-e7a4c5d981d6', '5b96bb68-b6b2-4a0f-bb8a-dfcd35a7b4db');

-- Inserindo dados na tabela ticket
INSERT INTO ticket (id, event_id, event_date_id, modality_id, owner_id)
VALUES
    ('f8b99c6e-5380-4512-b36c-4cd4d8b6e2f3', 'b8f8f7c7-dfcb-4c67-9c1f-1d531e6fcb56', 'dc4316f0-cf47-433b-91d9-8b8a527f9d59', '90217a76-7b77-4f60-8b58-12e74b647320', 'a87d58b6-1b87-4f16-9f6f-357bde85b7f2'),
    ('d396b1b9-bbbc-49e1-98a0-b39fca9c0a17', '5b96bb68-b6b2-4a0f-bb8a-dfcd35a7b4db', 'b278f65c-6e8d-4fae-bde0-980b48151235', 'e60d4268-9fcf-4c4a-b831-8b378e320ab0', '73d4c1d1-d149-4288-b7ba-20ac8ccac4a2');

-- Inserindo dados na tabela ticket_response_list
INSERT INTO ticket_response_list (ticket_id, response_list_id)
VALUES
    ('f8b99c6e-5380-4512-b36c-4cd4d8b6e2f3', '7ac8f6b4-5d61-44e6-8fcb-8c7d2b477d67'),
    ('d396b1b9-bbbc-49e1-98a0-b39fca9c0a17', 'e3d973fc-cab5-4a60-a788-b2de5a2a7e69');

-- Inserindo dados na tabela ticket_package
INSERT INTO ticket_package (id, type)
VALUES
    ('71b4a6cf-b420-4fba-9c91-dfa771b67616', 'VIP'),
    ('32f33264-5b33-4765-9a74-5f0c51e746c8', 'Padrão');

-- Inserindo dados na tabela ticket_package_tickets
INSERT INTO ticket_package_tickets (ticket_package_id, tickets_id)
VALUES
    ('71b4a6cf-b420-4fba-9c91-dfa771b67616', 'f8b99c6e-5380-4512-b36c-4');

