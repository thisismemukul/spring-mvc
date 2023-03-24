--create table person
--(
--   id integer not null,
--   name varchar(255) not null,
--   location varchar(255),
--   primary key(id)
--);

INSERT INTO user_details (ID, BIRTH_DATE, NAME) 
VALUES(10001,  current_date(), 'Ranga');
INSERT INTO user_details (ID, BIRTH_DATE, NAME) 
VALUES(10002,  current_date(), 'Ranga 1');
INSERT INTO user_details (ID, BIRTH_DATE, NAME) 
VALUES(10003,  current_date(), 'Ranga 2');

--POST
INSERT INTO post(ID, DESCRIPTION, USER_ID) 
VALUES(20001,'I want  to learn  AWS', 10001);

INSERT INTO post(ID, DESCRIPTION, USER_ID) 
VALUES(20002,'I want  to learn  DevOps', 10002);
INSERT INTO post(ID, DESCRIPTION, USER_ID) 
VALUES(20003,'I want to get AWS certificate', 10002);
INSERT INTO post(ID, DESCRIPTION, USER_ID) 
VALUES(20004,'I want  to learn  AWS', 10002);