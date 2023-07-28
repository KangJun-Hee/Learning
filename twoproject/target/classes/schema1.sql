CREATE TABLE IF NOT EXISTS article (
    id int NOT NULL AUTO_INCREMENT,
    title varchar(100) NOT NULL,
    content varchar(1000) NOT NULL,
    PRIMARY KEY (id)
);
<!-- 테이블 하나 더 만들려면 클래스 하나 더 만들고 Entity어노테이션 붙여서~ 그래야 '이거구나'하고 인식함-->