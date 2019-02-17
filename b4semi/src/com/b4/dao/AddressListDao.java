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

import com.b4.model.vo.AddressList;
import com.b4.model.vo.Member;

import oracle.jdbc.proxy.annotation.Pre;

public class AddressListDao {

	private Properties prop = new Properties();
	
	public AddressListDao() {
		try {
			String fileName = MemberDao.class.getResource("/sql/AddressList/AddressList-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<AddressList> selectByMember(Connection conn, Member m)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AddressList> list = new ArrayList<>();
		String sql = prop.getProperty("selectByMember");
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m.getMemberSeq());
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				AddressList al = new AddressList();
				al.setAddressSeq(rs.getInt("addressSeq"));
				al.setMemberSeq(rs.getInt("memberSeq"));
				al.setAddressTag(rs.getString("addressTag"));
				al.setAddress(rs.getString("address"));
				al.setAddressPhone(rs.getString("addressPhone"));
				list.add(al);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int insertAddressList(Connection conn, AddressList al)
	{
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertAddressList");
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, al.getAddressTag());
			pstmt.setString(2, al.getAddress());
			pstmt.setString(3, al.getAddressPhone());
			pstmt.setInt(4, al.getMemberSeq());
			result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			close(pstmt);
		}
		return result;
	}
	
	public int updateAddressList(Connection conn, AddressList al)
	{
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateAddressList");
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, al.getAddressTag());
			pstmt.setString(2, al.getAddress());
			pstmt.setString(3, al.getAddressPhone());
			pstmt.setInt(4,al.getMemberSeq());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteAddressList(Connection conn, AddressList al)
	{
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteAddressList");
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,al.getMemberSeq());
			pstmt.setString(2, al.getAddressTag());

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
}
