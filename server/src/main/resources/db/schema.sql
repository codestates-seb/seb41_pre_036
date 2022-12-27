drop table if exists answer;

drop table if exists member;

drop table if exists question;

drop table if exists question_tag;

drop table if exists tag;

drop table if exists answerVote;

create table answer (
                        answer_id bigint not null auto_increment,
                        created_at datetime(6),
                        last_modified_at datetime(6),
                        answer_content varchar(1000) not null,
                        is_voted bit,
                        member_id bigint,
                        question_id bigint,
                        primary key (answer_id)
);

create table member (
                        member_id bigint not null auto_increment,
                        nickname varchar(255) not null,
                        primary key (member_id)
);

create table question (
                          question_id bigint not null auto_increment,
                          created_at datetime(6),
                          last_modified_at datetime(6),
                          question_content varchar(1000) not null,
                          question_image varchar(255),
                          question_title varchar(1000) not null,
                          views bigint,
                          member_id bigint,
                          primary key (question_id)
);

create table question_tag (
                              question_tag_id bigint not null auto_increment,
                              created_at datetime(6),
                              last_modified_at datetime(6),
                              question_id bigint,
                              tag_id bigint,
                              primary key (question_tag_id)
);

create table tag (
                     tag_id bigint not null auto_increment,
                     created_at datetime(6),
                     last_modified_at datetime(6),
                     tag_word varchar(255) not null,
                     primary key (tag_id)
);

create table answerVote (
                      answer_id bigint not null,
                      member_id bigint not null,
                      opinion integer,
                      primary key (answer_id, member_id)
);

alter table answer
    add constraint FKn2sp5pa6h0u2kixjl2r4vfluf
        foreign key (member_id)
            references member (member_id);

alter table answer
    add constraint FK8frr4bcabmmeyyu60qt7iiblo
        foreign key (question_id)
            references question (question_id);

alter table question
    add constraint FK1nuuke7olg7b9fkyp2ba9d5bx
        foreign key (member_id)
            references member (member_id);

alter table question_tag
    add constraint FK44ydihbi2qk8k96175quf5q63
        foreign key (question_id)
            references question (question_id);

alter table question_tag
    add constraint FKnacet7y1n8llxvrbmm3xdq13j
        foreign key (tag_id)
            references tag (tag_id);

alter table answerVote
    add constraint FKa3aku0wi48fisg9cwprvmhy76
        foreign key (answer_id)
            references answer (answer_id);

alter table answerVote
    add constraint FKgkbgl6xp2rpgwghb7mtyuv48h
        foreign key (member_id)
            references member (member_id);