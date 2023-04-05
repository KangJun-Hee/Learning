package Interface_Printer;

public class LgPrinter implements PrintColour{
	@Override
	public void print(String p) {
		System.out.println("Lg 흑백 프린터");
	}

	@Override
	public void colourPrint(String p) {
		// TODO Auto-generated method stub
		
	}
}
//3D프린터
class Lg3D_Printer implements Print3D{

	@Override
	public void print(String p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colourPrint(String p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void D3() {
		// TODO Auto-generated method stub
		
	}
	
}
