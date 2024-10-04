CREATE DATABASE prj4;

USE prj4;

CREATE TABLE Video(
	video_no INT PRIMARY KEY AUTO_INCREMENT,
    video_URL VARCHAR(300) UNIQUE,
    video_title VARCHAR(50),
    category VARCHAR(50),
    part VARCHAR(50),
    channel_name VARCHAR(50)
);

CREATE TABLE Review(
	review_no int PRIMARY KEY AUTO_INCREMENT,
    video_no INT,
    review_content VARCHAR(50),
    writer VARCHAR(50),
    view_cnt INT DEFAULT 0,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (video_no) REFERENCES Video(video_no)
);

CREATE TABLE Member(
	id VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50),
    name VARCHAR(50),
    nick_name VARCHAR(50) UNIQUE,
    phone_num VARCHAR(15) UNIQUE,
    addr_num CHAR(5),
    add_basic VARCHAR(50),
    addr_detail VARCHAR(50)
);

CREATE TABLE Inquiry (
    inquiry_id INT AUTO_INCREMENT PRIMARY KEY,  -- 고유 ID, 자동 증가
    member_id VARCHAR(50) NOT NULL,              -- 회원 ID (Member 테이블의 id와 연관)
    title VARCHAR(100) NOT NULL,                 -- 문의 제목
    message TEXT NOT NULL,                       -- 문의 내용
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 작성 일시 (기본값: 현재 시각)
    status VARCHAR(20) DEFAULT '대기 중',        -- 상태 (기본값: 대기 중)
    FOREIGN KEY (member_id) REFERENCES Member(id) -- 회원 ID를 외래키로 설정
);

INSERT INTO Video 
VALUES
(1, "https://www.youtube.com/embed/50WCSpZtdmA?si=YYrQCe5tfK7FBNs9", "심으뜸 매일 아침 10분 스트레칭", "요가", "전신", "심으뜸"),
(2, "https://www.youtube.com/embed/Kk7TQGqQ3nA?si=9naoHt8kGsxpLuHi", "하루 두 번🧘🏻‍♀️반드시 해야하는 20분 전신순환 스트레칭", "요가", "전신", "빵느"),
(3, "https://www.youtube.com/embed/D3yExRi7EME?si=BoWbkjhRG096F_Ip", "뭉친 어깨, 뻣뻣한 골반 풀어주는 요가", "요가", "전신", "에일린"),
(4, "https://www.youtube.com/embed/02K-k6daPb4?si=xKoo3YEocujZ6LcF", "빠르게 칼로리 버닝 - 서서하는 유산소 - 다이어트 운동", "유산소", "전신", "빅씨스 Bigsis"),
(5, "https://www.youtube.com/embed/swRNeYw1JkY?si=Fl2gaE1QjrnJLsgf", "하루 15분! 전신 칼로리 불태우는 다이어트 운동", "유산소", "전신", "ThankyouBUBU"),
(6, "https://www.youtube.com/embed/gMaB-fG4u4g?si=tPZehYaEmT-rwMA7", "전신 다이어트 최고의 운동 [칼소폭 찐 핵핵 매운맛]", "유산소", "전신", "ThankyouBUBU"),
(7, "https://www.youtube.com/embed/KXYi6bI-UPE?si=SKfraEr1DNE0myff", "Lv.5 13분만에 하체 마비시키는 루틴! 근육통100% 옵니다.", "근력운동", "하체", "권혁TV"),
(8, "https://www.youtube.com/embed/uTmsvZOAh5U?si=yI-7mMTroNORvT6j", "Lv.3 8분만에 상체전체를 탈탈 털어버리는 홈트루틴", "근력운동", "상체", "권혁TV"),
(9, "https://www.youtube.com/embed/DJPBglSOC88?si=jWur4cPrYtHU1q9s", "Lv.4.5 10가지 푸쉬업으로 10분안에 가슴완성하기! ", "근력운동", "상체", "권혁TV"),
(10, "https://www.youtube.com/embed/DWYDL-WxF1U?si=6onTqiz4XEcCLMAh", "하체 날, 딱 10분 밖에 없다면 - 스쿼트 10가지 동작 - 하체운동 홈트 루틴", "근력운동", "하체", "빅씨스 Bigsis"),
(11, 'https://www.youtube.com/embed/2dail5Imi04?si=qswWCBwhlOYcmzPf', '하루 10분! 빠르게 살 빠지는 전신 운동 l 홈트레이닝', '근력운동', '전신', 'Allblanc TV'),
(12, 'https://www.youtube.com/embed/N-15wUPnqpc?si=wD1kW0hK9RccaCpE', '하루 10분! 전신 칼로리 불태우는 다이어트 홈트레이닝', '근력운동', '전신', 'Allblanc TV'),
(13, 'https://www.youtube.com/embed/L1kS5I99dlM?si=nNl6UP0e5bUEPl-8', '10분 전신 타바타 (지방 태우기 홈트)', '유산소', '전신', 'Allblanc TV');

INSERT INTO Review
VALUES(1,1,'정말 좋아요','김싸피',0,'2024-10-04 11:58:58'),
(2,9,'4556',NULL,0,'2024-10-04 12:04:18'),
(3,4,'admin',NULL,0,'2024-10-04 12:09:27'),
(4,1,'ad','ad',0,'2024-10-04 13:03:00'),
(5,6,'asdasdfasf','fasdfa',0,'2024-10-04 13:09:59'),
(6,5,'ss','ss',0,'2024-10-04 13:13:06'),
(7,3,'ㅁㅇ','ㅁㅇ',0,'2024-10-04 13:53:15'),
(8,2,'ad','aad',0,'2024-10-04 14:10:17'),
(9,6,'aa','aaa',0,'2024-10-04 14:11:58'),
(10,6,'bb','어드민',0,'2024-10-04 14:12:05'),
(11,6,'ㄴㄴㄴ','admin',0,'2024-10-04 14:12:12'),
(12,10,'adad','ad',0,'2024-10-04 14:12:47'),
(13,10,'aaa','어드민',0,'2024-10-04 14:13:04'),
(14,10,'머마마','어드민',0,'2024-10-04 14:15:06'),
(15,2,'aa','어드민',0,'2024-10-04 14:15:34'),
(16,5,'ㅇㅇ','어드민',0,'2024-10-04 14:29:14'),
(20,2,'qwedad','어드민',0,'2024-10-04 14:45:42'),
(23,4,'ㅇㄴㅇ','ㅇ',0,'2024-10-04 14:56:34'),
(24,4,'ㄺㄹ','어드민',0,'2024-10-04 14:57:22'),
(27,1,'aaaa','어드민',0,'2024-10-04 15:30:34'),
(29,1,'ds','어드민',0,'2024-10-04 15:32:58'),
(30,1,'sddsdssd','어드민',0,'2024-10-04 15:33:09'),
(31,1,'ㄴㅇㄹㄴㅇ','어드민',0,'2024-10-04 15:34:11');


INSERT INTO Member
VALUES("ssafy", "ssafy", "김띵균", "김싸피", "01012341234", 15321, "대전시 유성구 구암동", "빌라 301호");

	
INSERT INTO Inquiry (member_id, title, message)
VALUES
('ssafy', '계정 관련 문의', '계정 비밀번호를 잊어버렸습니다. 재설정 방법을 알려주세요.'),
('admin', '회원 탈퇴 문의', '회원 탈퇴를 하고 싶습니다. 절차가 어떻게 되나요?'),
('admin', 'gfd', '회원 탈퇴를 하고 싶습니다. 절차가 어떻게 되나요?');

SELECT * FROM Video;
SELECT * FROM Review;
SELECT * FROM Member;
SELECT * FROM Inquiry;

COMMIT;