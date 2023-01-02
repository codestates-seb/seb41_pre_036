--기본 태그 데이터
INSERT INTO `test`.`tag` (TAG_WORD, CREATED_AT, LAST_MODIFIED_AT) VALUES ('JavaScript', current_timestamp, current_timestamp);
INSERT INTO `test`.`tag` (TAG_WORD, CREATED_AT, LAST_MODIFIED_AT) VALUES ('Java', current_timestamp, current_timestamp);
INSERT INTO `test`.`tag` (TAG_WORD, CREATED_AT, LAST_MODIFIED_AT) VALUES ('SQL', current_timestamp, current_timestamp);
INSERT INTO `test`.`tag` (TAG_WORD, CREATED_AT, LAST_MODIFIED_AT) VALUES ('Spring', current_timestamp, current_timestamp);
INSERT INTO `test`.`tag` (TAG_WORD, CREATED_AT, LAST_MODIFIED_AT) VALUES ('React', current_timestamp, current_timestamp);
INSERT INTO `test`.`tag` (TAG_WORD, CREATED_AT, LAST_MODIFIED_AT) VALUES ('C', current_timestamp, current_timestamp);
INSERT INTO `test`.`tag` (TAG_WORD, CREATED_AT, LAST_MODIFIED_AT) VALUES ('C++', current_timestamp, current_timestamp);

--회원 2명 가입시켜두기
-- INSERT INTO `test`.`member` (`email`, `created_at`, `last_modified_at`, `password`, `user_nickname`) VALUES ('eqweq@gmail.com', '2022-12-31', '2022-12-31', '654312eqw', 'asfewqe1');
INSERT INTO `test`.`member` (email, password, USER_NICKNAME, created_at, last_modified_at) VALUES ('treeegreen@gmail.com', '1111', 'appletree', '2022-12-31', '2022-12-31');
INSERT INTO `test`.`member` (email, password, USER_NICKNAME, created_at, last_modified_at) VALUES ('cloud-blu@gmail.com', '2222', 'lalalala', '2023-01-01', '2023-01-01');

--질문 1개 등록해둠
INSERT INTO `test`.`question` (`question_id`, `created_at`, `last_modified_at`, `question_content`, `question_title`, `member_id`) VALUES ('1', '2022-12-31', '2022-12-31', 'skdjfahsjkfhsajfkahlskfshfjklsahfjfdks', 'hqkejhwqjekhqwkqhkjhewq', '1');

--답변 1개 등록해둠
INSERT INTO `test`.`answer_entity` (`answer_id`, `answer_content`, `answer_created_at`, `answer_last_modified_at`, `member_id`, `question_id`) VALUES ('1', 'ewqeqeqeq', '2022-12-31', '2022-12-31', '1', '1');

--투표 내역 1개 등록해둠
INSERT INTO `test`.`vote_entity` (`member_id`, `answer_id`, `opinion`) VALUES ('1', '1', '-1');

--INSERT INTO `test`.`members` (`email`, `password`, `user_nickname`) VALUES ('cloud@gmaill.com', '1234', 'EWRQRQEW');
--INSERT INTO QUESTION (MEMBER_ID, QUESTION_TITLE, QUESTION_CONTENT) VALUES(1, 'FADFADFADFADFADFASDFASFAJSDFHJKASHDFJKASHFJWEQRRWQQEWRRQWKDHJKDSAFHJKDF', 'ASDFASDFASDFADSFADFSADSFAEQEWQEQEQEQWQEQEQDFADFADF');
--INSERT INTO `test`.`answer_entity`  (`answer_content`, `answer_created_at`, `answer_last_modified_at`, `member_id`, `question_id`) VALUES ( 'RQEWRWQREW', '2022-12-27', '2022-12-27', '1', '1');
