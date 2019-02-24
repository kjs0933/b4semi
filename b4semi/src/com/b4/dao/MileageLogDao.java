package com.b4.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.b4.model.vo.MileageLog;
import static common.JDBCTemplate.close;

public class MileageLogDao {
	
	private Properties prop = new Properties();
	
	public MileageLogDao (){
		try {
			String fileName = MileageLogDao.class.getResource("/sql/mileage/mileage-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public int selectMileageLogCount(Connection conn, int memberSeq)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectMileageLogCount");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = rs.getInt("CN");
			}
		} 
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			close(pstmt);
			close(rs);
		}
		return result;
	}
	
	
	public List<MileageLog> selectMileageLogList(Connection conn, int cPage, int numPerPage, int memberSeq)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MileageLog> list = new ArrayList<MileageLog>();
		String sql = prop.getProperty("selectMileageLogList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				MileageLog ml = new MileageLog();
				ml.setMileageLogSeq(rs.getInt("mileageLogSeq"));
				ml.setMemberSeq(rs.getInt("memberSeq"));
				ml.setLogDate(rs.getTimestamp("logDate"));
				ml.setPreMileage(rs.getInt("preMileage"));
				ml.setNextMileage(rs.getInt("nextMileage"));
				ml.setLogTypeName(rs.getString("logTypeName"));
				list.add(ml);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	public List<MileageLog> selectAllMileageLogList(Connection conn, int memberSeq)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectAllMileageLogList");
		List<MileageLog> result = new ArrayList<MileageLog>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				MileageLog ml = new MileageLog();
				ml.setMileageLogSeq(rs.getInt("mileageLogSeq"));
				ml.setMemberSeq(rs.getInt("memberSeq"));
				ml.setLogDate(rs.getTimestamp("logDate"));
				ml.setPreMileage(rs.getInt("preMileage"));
				ml.setNextMileage(rs.getInt("nextMileage"));
				result.add(ml);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
			close(rs);
		}
		return result;
	}

}
