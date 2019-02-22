package dataGen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DiscountGen {

	public static void createDiscount(Connection cn)
	{
		String sql = "INSERT INTO DISCOUNT VALUES (?,?,?)";
		PreparedStatement ps = null;
		
		try {
			
		ps=cn.prepareStatement(sql);
		ps.setString(1, "05M02-30");
		ps.setString(2, "한우 최대 30% 할인");
		ps.setDouble(3, 0.3);
		ps.executeQuery();
		
		ps.setString(1, "02F01-25");
		ps.setString(2, "신선 과일 최대 25% 할인");
		ps.setDouble(3, 0.25);
		ps.executeQuery();
		
		ps.setString(1, "07C02-10");
		ps.setString(2, "따뜻한 음식 & 필수품 모음전");
		ps.setDouble(3, 0.1);
		ps.executeQuery();
		
		ps.setString(1, "04-20");
		ps.setString(2, "삼삼해물 최대 20% 할인");
		ps.setDouble(3, 0.2);
		ps.executeQuery();
		
		ps.setString(1, "10H03-20");
		ps.setString(2, "해통령 천연 분말 전 상품 20% 할인");
		ps.setDouble(3, 0.2);
		ps.executeQuery();
		
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
				ps.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
