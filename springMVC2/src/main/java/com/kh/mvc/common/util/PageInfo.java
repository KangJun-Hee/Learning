package com.kh.mvc.common.util;

import lombok.Getter;

@Getter
public class PageInfo {
	private int currentPage;
	private int pageLimit;
	private int listCount;
	private int listLimit;

	public PageInfo(int currentPage, int pageLimit, int listCount, int listLimit) {
		super();
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.listCount = listCount;
		this.listLimit = listLimit;
	}

	/*
	 * @param currentPage 현재페이지
	 * 
	 * @param pageLimit 한 페이지에 보여질 페이지의 수
	 * 
	 * @param listCount 전체 리스트의 수
	 * 
	 * @param listLimit 한 페이지에 표시될 리스트의 수
	 */

	/*
	 * @return 전체 페이지 중 가장 마지막 페이지 리스트의 총 개수를 가지고 몇페이지 인지 계산하는 명령문!
	 * 
	 * listcount = 100 listLimit = 10
	 * 
	 * 100/10 = 10.0 => 10페이지
	 */

	public int getMaxPage() {
		// ceil(0):실수값을 계산해 줌. 뒷자리있으면 무조건 올림
		return (int) Math.ceil((double) this.listCount / this.listLimit);
	}

	/*
	 * 
	 * @return 페이징 된 페이지 중 시작페이지
	 * 
	 */
	public int getStartPage() {

		return 0;
	}

	/*
	 * 
	 * @return 페이징 된 페이지 중 마지막 페이지
	 * 
	 */

	public int getEndPage() {

		return 0;
	}

	/*
	 * 
	 * @return 이전 페이지
	 * 
	 */

	public int getPrevPage() {
		int prevPage = this.getCurrentPage() - 1;

		// 0보다 작은숫자 오면 쪽수가 없으니 조건연산자 사용해 데이터를 에러없이 출력가능
		return prevPage < 1 ? 1 : prevPage;
	}

	/*
	 * 
	 * @return 다음페이지
	 * 
	 */
	public int getNextPage() {
		int nextPage = this.getCurrentPage() + 1;

		// 0보다 작은숫자 오면 쪽수가 없으니 조건연산자 사용해 데이터를 에러없이 출력가능
		return nextPage  < getMaxPage() ? getMaxPage() : nextPage;
	}

	/*
	 * 
	 * @return 페이지의 시작 리스트
	 * 
	 */

	public int getStratList() {

		return 0;
	}

	/*
	 * @return 페이지의 마지막 리스트
	 * 
	 */

	public int getEndList() {

		return 0;
	}

}
