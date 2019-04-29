package kr.patago.service;

import java.util.List;

import kr.patago.dao.OmokDaoImpl;
import kr.patago.vo.OmokVO;

public class OmokServiceImpl implements IOmokService{
	// 사용할 DAO의 객체변수를 선언한다.
	private OmokDaoImpl dao;
	
	//싱글톤패턴을 이용하여 객체생성
	private static OmokServiceImpl service;
	
	private OmokServiceImpl() {
		dao = OmokDaoImpl.getInstance(); // Dao객체 생성
	}
	public static OmokServiceImpl getInstance() {
		if(service == null) {
			service = new OmokServiceImpl();
		}
		return service;
	}

	@Override
	public int insert(OmokVO vo) {
		return dao.insert(vo);
	}

	@Override
	public List<OmokVO> selectList() {
		return dao.selectList();
	}
	
	@Override
	public OmokVO selectMax() {
		return dao.selectMax();
	}
	
	@Override
	public List<OmokVO> selectListPan() {
		return dao.selectListPan();
	}
	
	@Override
	public List<OmokVO> selectListPans(OmokVO vo) {
		return dao.selectListPans(vo);
	}
	
	@Override
	public List<OmokVO> selectListHist(OmokVO vo) {
		return dao.selectListHist(vo);
	}
	
	@Override
	public List<OmokVO> selectListHistNext2(OmokVO vo) {
		return dao.selectListHistNext2(vo);
	}
}