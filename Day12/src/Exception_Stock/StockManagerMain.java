package Exception_Stock;

public class StockManagerMain {

	public static void main(String[] args) {
		//내가 만든 예외처리를 실행 클래스!
		//수량을 관리하는 클래스!
		//
		try {
			StockManager st = new StockManager(200);
			st.updateStock();
			
		}catch(MyException e) {
			System.out.println("에러발생");
			System.out.println(e);
		}
		
	}

}
