create table if not exists event
(
    id          uuid not null
    primary key,
    capacity    integer,
    description varchar(255),
    name        varchar(255)
    );

alter table event
    owner to postgres;

create table if not exists event_info
(
    id          uuid not null
    primary key,
    address     varchar(255),
    event_end   timestamp(6),
    event_start timestamp(6)
    );

alter table event_info
    owner to postgres;

create table if not exists event_date
(
    event_id uuid not null
    constraint fkqf8645cgwgppcgi8slidnmcsx
    references event,
    date_id  uuid not null
    constraint uk5rdn9ebk5rg36k9qs9jqwvpt4
    unique
    constraint fko2dax173hhhjd7m5wei7fj9xp
    references event_info
);

alter table event_date
    owner to postgres;

create table if not exists modality
(
    id   uuid not null
    primary key,
    type varchar(255)
    );

alter table modality
    owner to postgres;

create table if not exists field
(
    id          uuid not null
    primary key,
    description varchar(255),
    name        varchar(255),
    type        varchar(255),
    modality_id uuid
    constraint fke47fa24ij40sf6du3qsf1pnxu
    references modality,
    response_id uuid
    constraint ukcepldbksu3vk0we69yyv4tkxn
    unique
    );

alter table field
    owner to postgres;

create table if not exists field_response
(
    id       uuid not null
    primary key,
    content  varchar(255),
    field_id uuid
    constraint uk2dklrm2cgbnayfhv41odw2xw3
    unique
    constraint fkmr41bw9nkleeencib5pnuhgdm
    references field
    );

alter table field_response
    owner to postgres;

alter table field
    add constraint fkpfxe6v47vrj3qkd3eai05ldwk
        foreign key (response_id) references field_response;

create table if not exists organizer
(
    id uuid not null
    primary key
);

alter table organizer
    owner to postgres;

create table if not exists event_organizers
(
    event_id      uuid not null
    constraint fkjwljnmkgtwkdohqc5f3g7utdg
    references event,
    organizers_id uuid not null
    constraint fk39gbn0fqkwf532r9rpvalfbpp
    references organizer
);

alter table event_organizers
    owner to postgres;

create table if not exists organizer_events
(
    organizer_id uuid not null
    constraint fks396jb4gy70ucl2nkeluat5id
    references organizer,
    events_id    uuid not null
    constraint fkk3ri60bw2y54cpa7vpx7ptl39
    references event
);

alter table organizer_events
    owner to postgres;

create table if not exists ticket
(
    id            uuid not null
    primary key,
    event_id      uuid
    constraint fkfytuhjopeamxbt1cpudy92x5n
    references event,
    event_date_id uuid
    constraint fkh0ow2ndgtrka7wecakvsc9u3n
    references event_info,
    modality_id   uuid
    constraint fk3toai7i0bg15cesdqvfxejec0
    references modality,
    owner_id      uuid
);

alter table ticket
    owner to postgres;

create table if not exists ticket_response_list
(
    ticket_id        uuid not null
    constraint fktedyub9hhl0kmacr9pk2ex5ge
    references ticket,
    response_list_id uuid not null
    constraint uksi91rey6avs0316j814de14eu
    unique
    constraint fk2dmn1lema414d16fdxytx8lav
    references field_response
);

alter table ticket_response_list
    owner to postgres;

create table if not exists ticket_package
(
    id   uuid not null
    primary key,
    type varchar(255)
    );

alter table ticket_package
    owner to postgres;

create table if not exists ticket_package_tickets
(
    ticket_package_id uuid not null
    constraint fkopdbc41ne0o28qdo4y94fxrgr
    references ticket_package,
    tickets_id        uuid not null
    constraint uk8a0ietj2tdg53r8bl1tikor4o
    unique
    constraint fksj20w112cub0vj0n8q2bg6tpi
    references ticket
);

alter table ticket_package_tickets
    owner to postgres;

-- Insert into event table
insert into event (id, capacity, description, name)
values ('123e4567-e89b-12d3-a456-426614174000', 100, 'Show do Linking Park', 'Linking Park');

-- Insert into event_info table
insert into event_info (id, address, event_end, event_start)
values ('123e4567-e89b-12d3-a456-426614174001', 'Rio de Janeiro', '2023-12-31 23:59:59', '2023-12-31 18:00:00');

-- Insert into event_date table
insert into event_date (event_id, date_id)
values ('123e4567-e89b-12d3-a456-426614174000', '123e4567-e89b-12d3-a456-426614174001');

-- Insert into modality table
insert into modality (id, type)
values ('123e4567-e89b-12d3-a456-426614174002', 'Estudante');

-- Insert into field table
insert into field (id, description, name, type, modality_id, response_id)
values ('123e4567-e89b-12d3-a456-426614174003', 'Matrícula para universitários', 'Matrícula', 'Modalidade', '123e4567-e89b-12d3-a456-426614174002', '123e4567-e89b-12d3-a456-426614174004');

-- Insert into field_response table
insert into field_response (id, content, field_id)
values ('123e4567-e89b-12d3-a456-426614174004', '2021220012234', '123e4567-e89b-12d3-a456-426614174003');

-- Insert into organizer table
insert into organizer (id)
values ('123e4567-e89b-12d3-a456-426614174005');

-- Insert into event_organizers table
insert into event_organizers (event_id, organizers_id)
values ('123e4567-e89b-12d3-a456-426614174000', '123e4567-e89b-12d3-a456-426614174005');

-- Insert into organizer_events table
insert into organizer_events (organizer_id, events_id)
values ('123e4567-e89b-12d3-a456-426614174005', '123e4567-e89b-12d3-a456-426614174000');

-- Insert into ticket table
insert into ticket (id, event_id, event_date_id, modality_id, owner_id)
values ('123e4567-e89b-12d3-a456-426614174006', '123e4567-e89b-12d3-a456-426614174000', '123e4567-e89b-12d3-a456-426614174001', '123e4567-e89b-12d3-a456-426614174002', '123e4567-e89b-12d3-a456-426614174007');

-- Insert into ticket_response_list table
insert into ticket_response_list (ticket_id, response_list_id)
values ('123e4567-e89b-12d3-a456-426614174006', '123e4567-e89b-12d3-a456-426614174004');

-- Insert into ticket_package table
insert into ticket_package (id, type)
values ('123e4567-e89b-12d3-a456-426614174008', 'Estudante');

-- Insert into ticket_package_tickets table
insert into ticket_package_tickets (ticket_package_id, tickets_id)
values ('123e4567-e89b-12d3-a456-426614174008', '123e4567-e89b-12d3-a456-426614174006');
