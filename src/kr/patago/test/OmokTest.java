package kr.patago.test;

import kr.patago.service.OmokServiceImpl;
import kr.patago.vo.OmokVO;

public class OmokTest {
	// Service객체 변수를 선언한다.
	private OmokServiceImpl service;

	public OmokTest() {
		service = OmokServiceImpl.getInstance(); // service객체 생성
		
		OmokVO vo = new OmokVO();
		vo.setPan("1");
		vo.setPan_order("1");
		vo.setHistory("1");
		vo.setWinner("1");
		
		service.insert(vo);
	}
	
	public static void main(String[] args) {
		new OmokTest();
	}
}