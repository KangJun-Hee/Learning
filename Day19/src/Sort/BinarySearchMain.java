package Sort;

public class BinarySearchMain {

	public static boolean bsearch(int[]arr, int key) {
		
		int left = 0;
		int right = arr.length -1;
		int mid; //반복을 하면 중간값이 계속 변경
		
		while(left <= right) {
			mid = (left + right)/2;
			
			
			
			//중간값보다 크다
			if(arr[mid] < key) {
				left = mid+1;
			}else if(arr[mid] > key) {
				right = mid -1;
			}else {
				//값을 찾았다.
				return true;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {

		//이진탐색
		// - 조건! 무조건 정렬이 도어있어야 함.
		// - 인덱스의 길이를 반으로 나눈다.
		// - 중간 기준점을 찾는다.
		// - 중간 기점으로 비교값이 작으면 기준점 보다
		// 앞의 범위에서 찾는다.
		// 기준점보다 크다! 오른쪽 범위 검사
		// 이분법이라고도 부름.
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		int key = 15;
		//정렬들을 함수로 작성할 떄
		//원하는 값으로 index 숫자 리턴값 int 
		boolean res = bsearch(arr,key);
		if(res) {
			System.out.println("값이 있다!");
		}else {
			System.out.println("값이 없다!");
		}
		
		int res2 = 14;
		if(res2 != -1) {
			System.out.println(key+res2+"번째 있습니다.");
		}else {
			System.out.println("해당값 없다!");
		}
	}

}
