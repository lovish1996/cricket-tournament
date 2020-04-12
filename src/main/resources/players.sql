create table player_details(
    id bigint(20) not null auto_increment,
    created_at bigint(20) default null,
    updated_at bigint(20) default null,
    player_shirt_id int(11) not null,
    player_name varchar(60) not null,
    player_type varchar(30) not null,
    position_of_responsibility varchar(30),
    team_name varchar(30),
    primary key(id),
    unique key uni_shirt_id_team_name (player_shirt_id,team_name)
);

