package MVC_ColGene;

import java.util.ArrayList;
import java.util.HashMap;

public class FarmController {
	HashMap<Farm, Integer> h = new HashMap<>();
	ArrayList<Farm> list = new ArrayList<>();
	
	boolean addNewKind(Farm f, int amount) {
		return false;
		
	}
	boolean removeKind(Farm f) {
		return true;
	}
	boolean changeAmount(Farm f, int amount) {
		return true;
	}
	HashMap<Farm, Integer> printFarm(){
		return h;}
	boolean buyFarm(Farm f) {
		return true;
	}
	boolean removeFarm(Farm f) {
		return true;
	}
	ArrayList<Farm> printBuyFarm(){
		return list;
		
	}
}
