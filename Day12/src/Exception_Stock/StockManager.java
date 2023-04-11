package Exception_Stock;

public class StockManager {

	int stockNum; //재고수량
	
	//기본생성자
	public StockManager() {}
	
	//매개변수를 받는 생성자
	public StockManager(int stockNum) {
		super();
		this.stockNum = stockNum;
	}
	//수량을 업데이트 하는 함수
	void updateStock() throws MyException {
		
		subStock(110);
		
	}//수량을 관리해서 확인하는 함수
	void subStock(int amount) throws MyException {
		if(this.stockNum<amount) {
			throw new MyException("재고수량이 부족합니다~");
		}else {
			this.stockNum -= amount;
			System.out.println("현재 재고수량:"+this.stockNum);
		}
	}
	
	
	
}
