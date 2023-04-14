package ArrayList;

import java.util.Objects;

public class Music {

	private String title;
	private String singer;

	//객체 생성시 매개변수 받는 생성자.
	Music(){}
	Music(String title, String singer){
		this.title = title;
		this.singer = singer;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	@Override
	public String toString() {//멤버변수들을 정리해서 문자열로 변환
		return "Music [title=" + title + ", singer=" + singer + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(singer, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		else if(this == null)
			return false;
		
		Music other = (Music) obj;
		return Objects.equals(singer, other.singer) && Objects.equals(title, other.title);
	}
}
