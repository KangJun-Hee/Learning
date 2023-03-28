package Array;

public class ArrayEx03 {

	public static void main(String[] args) {

		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
		int[] scores = {87,    11,    45,   98,    23};
		
		//문제) 1등 학생의 학번과 성적 출력
		//정답) 1004번(98점)
		
		int index = 0; //각각의 공간에 접근할 때 사용 번호
		int findIdx = -1; //찾는 값이 없을 때 쓰는 것
		int max = 1;
		
		//이미 max값에 scores 첫번째 값 87을 저장
		//index 굳이 0부터 시작하라고 쓸 필요 없다~
		
		while(index < scores.length) {
			if(max < scores[index]) {
				max = scores[index];
				//학번도 같이 출력해야 되니까 findIdx가 -> 학번의 방법호를 저장
				findIdx = index;
			}
			
		}//다음 공간으로 넘어가기!
		index += 1; //index = index +1
		
	}//while문 끝

}
