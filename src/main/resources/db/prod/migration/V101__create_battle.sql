drop table if exists "battle";

create table  "battle" (
    "id" integer primary key AUTOINCREMENT,     
    "monster_a_id" bigint not null, 
    "monster_b_id" bigint not null, 
    "monster_winner" bigint not null     
);