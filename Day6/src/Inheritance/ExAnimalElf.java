package Inheritance;
class Animal{
	String name;
	
	void cry() {
		System.out.println("월월!");
	}
}
class Pet extends Animal{
	int age;
	int price;
	
	void play() {
		System.out.println("공놀이를 한다.");
	}
}

class Elf{
	String name;
	int hp;
}
class HighElf extends Elf{
	int mp;
}
class ElfLord extends HighElf{
	int sh;
}

public class ExAnimalElf {
	public static void main(String[] args) {

		Pet 차우차우 = new Pet();
		차우차우.name = "차우차우";
		차우차우.age = 3;
		차우차우.price = 2200000;
		System.out.println("Pet{ name:" + 차우차우.name + ", age:"+ 차우차우.age + "세, " + "price:" + 차우차우.price + "원}");
		System.out.println();
		
		
		Elf elf = new Elf();
		elf.name = "티란데";
		elf.hp = 100;
		HighElf helf = new HighElf();
		helf.name = "말퓨리온";
		helf.hp = 160;
		helf.mp = 100;
		ElfLord el = new ElfLord();
		el.name = "마이에브";
		el.hp = 230;
		el.mp = 140;
		el.sh = 100;
		System.out.println("[엘프] Name:"+elf.name+ ", HP: "+elf.hp);
		System.out.println("[하이엘프] Name:"+helf.name+ ", HP: "+helf.hp+ ", MP: "+helf.mp);
		System.out.println("[엘프로드] Name:"+el.name+ ", HP: "+el.hp+", MP: "+el.mp+ ", SH: "+el.sh);
}}
