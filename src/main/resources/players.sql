create table player_details
(
    id                         bigint(20)  not null auto_increment,
    created_at                 bigint(20) default null,
    updated_at                 bigint(20) default null,
    player_shirt_id            int(11)     not null,
    player_name                varchar(60) not null,
    player_type                varchar(30) not null,
    position_of_responsibility varchar(30),
    team_id                    int(11),
    primary key (id),
    unique key uni_shirt_id_team_name (player_shirt_id, team_id),
    constraint for_key_team_id foreign key (team_id) references team_details (id)
);


create table team_details
(
    id         bigint(20)  not null auto_increment,
    created_at bigint(20) default null,
    updated_at bigint(20) default null,
    team_code int(11) not null unique,
    team_name  varchar(60) not null,
    ranking_id int(11),
    primary key (id),
    constraint for_key_ranking_id foreign key (ranking_id) references ranking_details (id)
);

create table ranking_details
(
    id           bigint(20) not null auto_increment,
    created_at   bigint(20) default null,
    updated_at   bigint(20) default null,
    team_id      int(11),
    test_ranking int(11) unique,
    odi_ranking  int(11) unique,
    t20_ranking  int(11) unique,
    primary key (id),
    constraint for_key_team_id foreign key (team_id) references team_details (id)
);
