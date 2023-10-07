create table applicant
(
    applicant_id bigint auto_increment
        primary key,
    is_deleted   varchar(255) default 'N' null,
    name         varchar(255)             null
);

create table application
(
    applicant_id   bigint                   null,
    application_id bigint auto_increment
        primary key,
    recruitment_id bigint                   null,
    is_deleted     varchar(255) default 'N' null,
    constraint FKp6pay5d5qymslgxs3d7ukepib
        foreign key (recruitment_id) references preonboarding.recruitment (recruitment_id),
    constraint FKrc3gxkxtsq5jqx764drr3wug5
        foreign key (applicant_id) references preonboarding.applicant (applicant_id)
);

create table company
(
    company_id bigint auto_increment
        primary key,
    country    varchar(255)             null,
    is_deleted varchar(255) default 'N' null,
    name       varchar(255)             null,
    region     varchar(255)             null
);

create table recruitment
(
    signing_bonus  int          default 0   null,
    tech_stack     tinyint                  null,
    company_id     bigint                   null,
    recruitment_id bigint auto_increment
        primary key,
    content        varchar(255)             null,
    is_deleted     varchar(255) default 'N' null,
    position       varchar(255)             null,
    constraint FKc8ro055m1iceebbktg9epdci9
        foreign key (company_id) references preonboarding.company (company_id),
    check (`tech_stack` between 0 and 5)
);


