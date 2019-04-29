package kr.patago.dao;

import java.util.List;

import kr.patago.vo.OmokVO;

public interface IOmokDao {
	public int insert(OmokVO vo);
	
	public List<OmokVO> selectList();
	
	public OmokVO selectMax();
	
	public List<OmokVO> selectListPan();
	
	public List<OmokVO> selectListPans(OmokVO vo);
	
	public List<OmokVO> selectListHist(OmokVO vo);
	
	public List<OmokVO> selectListHistNext2(OmokVO vo);
}