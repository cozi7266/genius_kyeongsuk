
# 팀명 : 채동욱
## 프로젝트 명 : ssafit_prj

### 1. 메인화면
- 게시글(board) 정보를 가져와서 영상, 제목, 운동종류, 조회수, 찜 등의 정보를 화면에 출력
![alt text](image-4.png)
#### 2. 회원가입
- 아이디는 DB에 접근해서 비동기식으로 중복처리, 비밀번호는 js로 정규식 검증, 다음 맵 API를 이용해서 주소 입력
![alt text](joinForm.png)
![alt text](<주소 api.png>)
#### 3. 로그인
- 아이디와 비밀번호를 DB에서 찾아서 같은 member가 있는지 체크해서 로그인, 세션으로 로그인 상태 유지
![alt text](<주소 api-1.png>)
![alt text](afterLogin.png)
#### 4. 게시글 상세화면
- 유튜브 영상, 제목, 조회수, 등록일, 콘텐츠 내용, 댓글 등의 내용을 화면에 출력
![alt text](<게시글 상세 페이지.PNG>)
#### 5. 리뷰 등록
- 사용자 정보를 세션에서 가져와서 회원이 등록한 댓글을 DB에 등록
![alt text](<댓글 작성.PNG>)
#### 6. 찜
- 찜 버튼을 누르면 ajax 처리를 통해 회원이 그 게시글에 대해 찜을 눌렀는지 체크해서 찜을 이미 눌렀다면 취소, 누르지 않았다면 DB에 등록
![alt text](<찜 추가.png>)
![alt text](<찜 추가1.png>)
#### 7. 게시글 작성
- 제목, 작성자, 운동 정보, 유튜브 URL, 내용을 작성하고, 작성완료 버튼을 누르면 게시글 등록
![alt text](<게시글 작성.PNG>)
![alt text](<게시글 작성 완료.PNG>)
#### 8. 마이페이지
- 댓글, 작성글, 찜목록 등을 확인할 수 있는 화면
![alt text](image-1.png)
#### 9. 댓글보기
- 회원이 등록한 모든 댓글 화면에 출력
![alt text](image-2.png)
#### 10. 작성글보기
- 회원이 등록한 모든 게시글 화면에 출력
![alt text](image-3.png)
#### 11. 찜목록보기
- 회원이 찜을 누른 게시글 모두 확인가능
![alt text](saveList.png)
# DB 
- ERD 다이어그램 
![alt text](image.png)

#DB DATA
![alt text](Member테이블.png)
![alt text](Review테이블.png)
![alt text](<Board 테이블.png>)
![alt text](Save(찜)테이블.png)

