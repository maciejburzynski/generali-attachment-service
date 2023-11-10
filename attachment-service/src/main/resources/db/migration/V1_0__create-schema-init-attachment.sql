create table Attachments (
    id bigint not null auto_increment primary key,
    name varchar,
    content varchar,
    created_at timestamp default current_timestamp);



insert into Attachments(name, content)
values ('Janusz', 'Kowalski');
insert into Attachments( name, content)
values ('Janusz', 'Korwin');
insert into Attachments(name, content)
values ('Andrzej', 'Duda');