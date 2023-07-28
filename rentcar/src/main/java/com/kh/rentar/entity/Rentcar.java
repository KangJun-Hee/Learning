package com.kh.rentar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//JPA를 사용해서 테이블과 매핑할 클래스는 @Entity 어노테이션을 필수로 붙여야 하고 엔티티라 부른다.
//@Entity 어노테이션이 붙은 클래스 이름으로 SpringBoot가 자동으로 테이블을 만들고 클래스 내부에 선언한 필드 이름으로
//테이블을 구성하는 컬럼을 만들어준다.
@Entity

@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든변수 사용하는 생성자
@EqualsAndHashCode // equals()hashcode()메서드 자동완성

@ToString
@Getter
public class Rentcar {
	//	기본키로 사용할 필드 선언
	//	키본키를 자동으로 생성하려면 @Id와 @GeneratedValue 어노테이션을 
	// 함께 사용해야 한다.
	private int no;
	
	@Column// 필드를 테이블 컬럼과 매핑한다.
	private String name;
	@Column
	private int category;
	@Column
	private int price;
	@Column
	private int use_people;
	@Column
	private String company;
	@Column
	private String img;
	@Column
	private String info;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
