
public class CafeVO {
	//cafe에 대한 내용 저장하는 클래스
	//생성자,toString
	//getter,setter선언
	
	
	//StatementTest클래스에서 ArrayList클래스에 저장 후 출력!
	//HashMap<cafeid,CafeVO>로도 해 봐라
	private String cafeid;
	private String cafename;
	private String corporation;
	private String price;
	
	public CafeVO() {};
	public CafeVO(String cafeid, String cafename, String corporation, String price) {
		super();
		this.cafeid = cafeid;
		this.cafename = cafename;
		this.corporation = corporation;
		this.price = price;
	}
	
	public String getCafeid() {
		return cafeid;
	}
	public void setCafeid(String cafeid) {
		this.cafeid = cafeid;
	}
	public String getCafename() {
		return cafename;
	}
	public void setCafename(String cafename) {
		this.cafename = cafename;
	}
	public String getCorporation() {
		return corporation;
	}
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "[ "+cafeid + ""+cafename+"" +corporation +""+price+"]";
	}
}
