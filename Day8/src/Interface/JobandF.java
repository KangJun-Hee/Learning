package Interface;

public class JobandF {

	public static void main(String[] args) {
		Mus m = new Mus("뮤지션", "김씨");
		Achi a = new Achi("건축가", "이씨");
		Dev d = new Dev("개발자", "박씨");
		Law l = new Law("변호사", "우영우");
		m.say();
		a.say();
		d.say();
		l.say();
	}

}
interface Say{
	void say();
}
class total{
	@Override
	public String toString() {
		
		return "";
	}
}
class Mus extends Friends implements Say{
	public Mus(String job, String fname) {
		super(name, job);
	}

	@Override
	public void say() {
		System.out.println(job+" "+fname+ " 칭구 아이가!");
	}
}
class Achi extends Friends implements Say{
	public Achi(String job, String fname) {
		this.job = job;
		this.fname = fname;
	}

	@Override
	public void say() {
		System.out.println(job+" "+fname+ " 칭구 아이가!");
	}
}
class Dev extends Friends implements Say{
	public Dev(String job, String fname) {
		super(name, job);
	}

	@Override
	public void say() {
		System.out.println(job+" "+fname+ " 칭구 아이가!");
	}
}
class Law extends Friends implements Say{
	public Law(String job, String fname) {
		this.job = job;
		this.fname = fname;
	}

	@Override
	public void say() {
		System.out.println(job+" "+fname+ " 칭구 아이가!");
	}
}
class Friends{
	String job;
	String fname;
	
	
	}
