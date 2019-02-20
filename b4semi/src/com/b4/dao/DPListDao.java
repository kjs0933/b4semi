package com.b4.dao;


import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.b4.model.vo.DPList;

public class DPListDao {
	
	Properties prop = new Properties();
	
	public DPListDao () {
		try {
			String fileName = MemberDao.class.getResource("/sql/DPList/DPList-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public int searchListCount(Connection conn, String type, String keyword, String category, String sortType)
	{
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql=null;
		int result = 0;
		/* 실행 쿼리문 참고
		 * 
SELECT * FROM (SELECT ROWNUM AS "RNUM", A.* FROM
(select * from dplist left join
    (select displayListSeq, min(displayOptionPrice) as "MINPRICE", min(discountRate) as "DISCOUNTRATE",  min(subCategoryCode) as "SUBCATEGORYCODE", min(majorCategoryCode) as "MAJORCATEGORYCODE" , trunc(avg(reviewScore),2) as "AVGREVIEWSCORE" from DPOption
        left join discount using(discountCode)
        join product using(productCode)
        join subCategory using(subCategoryCode)
        left join review using(productCode, displayListSeq)
        group by displayListSeq
        ) using(displayListSeq) where 
            검색컬럼명 like ? -- 키워드 + 검색어
        AND (SUBCATEGORYCODE like ? OR MAJORCATEGORYCODE like ?) -- 소분류 카테고리 혹은 대분류 카테고리 구분
        order by dplistavailable DESC, 정렬컬럼명 (DESC,ASC) -- 정렬방식 + 정렬순서
) A WHERE ROWNUM <= ? ) WHERE RNUM >= ?; -- 표시 최대번호, 표시 최소번호
		*/
		return result;
	}
	
	public List<DPList> selectList(Connection conn, int cPage, int numPerPage)
	{
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		List<DPList> list = new ArrayList<>();
		String sql=prop.getProperty("selectList");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				DPList d = new DPList();
				d.setDisplayListSeq(rs.getInt("diplayListSeq"));
				d.setDisplayListTitle(rs.getString("diplayListTitle"));
				d.setDisplayListContents(rs.getString("displayListContents"));
				d.setDPListAvailable(rs.getString("DPListAvailable"));
				d.setDisplayDate(rs.getTimestamp("displayDate"));
				d.setDPListOriginalFileName(rs.getString("dplistoriginalfilename"));
				d.setDPListRenameFilename(rs.getString("DPListRenameFilename"));
			}
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(rs);close(pstmt);}
		return list;	
	}
	
	public int displayListSeq(Connection conn)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		String sql=prop.getProperty("displayListSeq");
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				result=rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {close(rs);close(pstmt);}
		return result;
	}
	
	public int insertDPList(Connection conn, DPList d)//입력
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertDPList");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDisplayListSeq());
			pstmt.setString(2, d.getDisplayListTitle());
			pstmt.setString(3, d.getDisplayListContents());
			pstmt.setString(4, d.getDPListAvailable());
			pstmt.setTimestamp(5, d.getDisplayDate());
			pstmt.setString(6, d.getDPListOriginalFileName());
			pstmt.setString(7, d.getDPListRenameFilename());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public int updateDPList(Connection conn, DPList d)//수정
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updateDPList");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,d.getDisplayListSeq());
			pstmt.setString(2, d.getDisplayListTitle());
			pstmt.setString(3, d.getDisplayListContents());
			pstmt.setString(4, d.getDPListAvailable());
			pstmt.setTimestamp(5, d.getDisplayDate());
			pstmt.setString(6, d.getDPListOriginalFileName());
			pstmt.setString(7, d.getDPListRenameFilename());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public int deleteDPList(Connection conn, DPList d)//삭제
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("deleteDPList");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDisplayListSeq());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}

}
