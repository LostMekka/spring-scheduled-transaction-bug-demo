create table test_table
(
    id           binary(16)   not null,
    name         varchar(255) not null,
    last_changed datetime     not null,
    primary key (id)
);

insert into test_table (id, name, last_changed) VALUES (uuid_to_bin('8c857fd3-5e3f-45b4-9d1a-925705496b3d'), 'foobar', now());
