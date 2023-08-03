INSERT INTO article(id, title, content) values (1, '홍길동', '천재');
INSERT INTO article(id, title, content) values (2, '임꺽정', '처언재');
INSERT INTO article(id, title, content) values (3, '장길산', '처어언재');
INSERT INTO article(id, title, content) values (4, '일지매', '처어어언재');

-- article 더미데이터
INSERT INTO article(id, title, content) values (5, '손오공', '좋아하는 드라마는?');
INSERT INTO article(id, title, content) values (6, '저팔계', '먹고싶은 음식은?');
INSERT INTO article(id, title, content) values (7, '사오정', '취미는?');

-- comment 더미데이터
-- 5번 게시물의 댓글
INSERT INTO comment(id, nickname, body, article_id) values (1, '한꼬마', '재벌집 막내아들', 5);
INSERT INTO comment(id, nickname, body, article_id) values (2, '두꼬마', '빈센조', 5);
INSERT INTO comment(id, nickname, body, article_id) values (3, '세꼬마', '태양의 후예', 5);

-- 6번 게시물의 댓글
INSERT INTO comment(id, nickname, body, article_id) values (4, '한꼬마', '짜장면', 6);
INSERT INTO comment(id, nickname, body, article_id) values (5, '두꼬마', '짬뽕', 6);
INSERT INTO comment(id, nickname, body, article_id) values (6, '세꼬마', '탕수육', 6);

-- 7번 게시물의 댓글
INSERT INTO comment(id, nickname, body, article_id) values (7, '한꼬마', '등산', 7);
INSERT INTO comment(id, nickname, body, article_id) values (8, '두꼬마', '바둑', 7);
INSERT INTO comment(id, nickname, body, article_id) values (9, '세꼬마', '낚시', 7);