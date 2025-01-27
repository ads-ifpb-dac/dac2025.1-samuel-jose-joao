create table event
(
    id          uuid not null primary key,
    capacity    integer,
    description varchar(255),
    name        varchar(255)
);

create table event_info
(
    id          uuid not null primary key,
    address     varchar(255),
    event_end   timestamp(6),
    event_start timestamp(6)
);

create table event_date
(
    event_id uuid not null references event,
    date_id  uuid not null unique references event_info
);

create table field_response
(
    id       uuid not null primary key,
    content  varchar(255),
    field_id uuid
);

create table modality
(
    id   uuid not null primary key,
    type varchar(255)
);

create table field
(
    id          uuid not null primary key,
    description varchar(255),
    name        varchar(255),
    type        varchar(255),
    modality_id uuid references modality,
    response_id uuid unique references field_response
);

create table field_response_field
(
    field_response_id uuid not null references field_response,
    field_id          uuid not null unique references field
);

create table organizer
(
    id uuid not null primary key
);

create table event_organizers
(
    event_id      uuid not null references event,
    organizers_id uuid not null references organizer
);

create table organizer_events
(
    organizer_id uuid not null references organizer,
    events_id    uuid not null references event
);

create table ticket_package
(
    id   uuid not null primary key,
    type varchar(255)
);

create table person
(
    id       uuid not null primary key,
    birthday timestamp(6),
    cpf      varchar(255),
    email    varchar(255),
    name     varchar(255),
    password varchar(255)
);

create table ticket
(
    id            uuid not null primary key,
    event_id      uuid references event,
    event_date_id uuid references event_info,
    modality_id   uuid references modality,
    owner_id      uuid constraint fk6gcp2n23bvkav1okxc6i1jt63 references person
);

create table ticket_response_list
(
    ticket_id        uuid not null references ticket,
    response_list_id uuid not null unique references field_response
);

create table ticket_package_tickets
(
    ticket_package_id uuid not null references ticket_package,
    tickets_id        uuid not null unique references ticket
);

