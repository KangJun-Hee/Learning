package Interface_Printer;

//인터페이스 상속
//인터페이스 계속 만들다 보면 중복적 메서드 계속생김
//인터페이스는 다중상속이 된다.

public interface Print{
	//프린터
	void print(String p);	//흑백
 }
 interface PrintColour extends Print{
	 
	 void print(String p);
	 void colourPrint(String p);
 }
 interface Three_dimensional{
	 void D3();
 }
 
 interface Print3D extends PrintColour, Three_dimensional{
	 
 }
 
