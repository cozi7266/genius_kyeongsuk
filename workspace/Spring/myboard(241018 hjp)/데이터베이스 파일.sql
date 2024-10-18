CREATE DATABASE IF NOT EXISTS examdb;

use examdb;

/*
	private int no;
	private String title;
	private String writer;
	private String content;
	private int viewCnt;
*/

-- CREATE TABLE board(
-- 	no int auto_increment, # 번호를 자동으로 증가시켜줌
--     title varchar(200) NOT NULL,
--     writer varchar(30) NOT NULL,
--     content varchar(1000) NOT NULL,
--     view_cnt int DEFAULT 0,
--     reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, # 시간과 날짜 정보를 같이 가지고 있음
--     PRIMARY KEY(no)
-- );

-- INSERT INTO board(title, writer, content)
-- VALUES ('연습2', 'ssafy2', '연습2입니다');
-- commit;

-- SELECT * FROM board;
SELECT * FROM board;

CREATE TABLE board_file (
	file_no int AUTO_INCREMENT,
    file_path VARCHAR(100) NOT NULL,
    ori_name VARCHAR(100) NOT NULL,
    system_name VARCHAR(100) NOT NULL,
    no int,
    FOREIGN KEY(no) REFERENCES board(no) ON DELETE CASCADE,
    PRIMARY KEY(file_no)
);

INSERT INTO board(title, writer, content)
VALUES('aaa', 'bbb', 'ccc');

SELECT last_insert_id();

SELECT * FROM board_file;

INSERT INTO board_file(file_path, ori_name, system_name, no)
VALUES('aaa','bbb','ccc',last_insert_id());

DELETE FROM board;