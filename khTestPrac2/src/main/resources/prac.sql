CREATE TABLE IF NOT EXISTS rentcar(
	no INT,
    name VARCHAR(20),
    category INT,
    price INT,
    use_people INT,
    company VARCHAR(50),
    img VARCHAR(50),
    info VARCHAR(500)
);

<!-- 테이블 하나 더 만들려면 클래스 하나 더 만들고 Entity어노테이션 붙여서~ 그래야 '이거구나'하고 인식함-->