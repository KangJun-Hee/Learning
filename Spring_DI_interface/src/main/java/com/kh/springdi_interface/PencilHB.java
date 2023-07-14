package com.kh.springdi_interface;

public class PencilHB implements Pencil{
	@Override
	public void use() {
		System.out.println("지우개가 달린 HB연필로 그린다~");
	}
}
