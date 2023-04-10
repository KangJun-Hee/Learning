package Thread_wait_notity;

public class Cook implements Runnable{
	private final Dish dish;//객체 생성할 때 동시에 저장
	//기본생성자가 생기지 않는다!
	//public Cook() {} final 덕에 기본생성자 작성하면 에러남.
	
	
	//매개변수 있는 생성자
	public Cook(Dish dish){
		this.dish = dish;
	}
	
	//주방장의 고유권한
	private void cook(int i) throws InterruptedException {
		
		
		synchronized (dish) {
			while(!dish.isEmpty()) {
				
				dish.wait();//음식을 먹을때까지 기다린다.
			}
			dish.setEmpty(false);
			System.out.println(i+"번째 음식이 준비되었다람쥐");
			dish.notify();
		}
	}
	
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			
			try {
				cook(i);
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
