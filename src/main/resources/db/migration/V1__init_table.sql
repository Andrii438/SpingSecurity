create table people(
    id serial primary key,
    username text unique,
    password text,
    authorities text,
    enabled boolean
);