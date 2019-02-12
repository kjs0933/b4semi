package dataGen;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;

import common.JDBCTemplate;

//더미 데이터 자동 생성을 위한 클래스
public class DataGen {
	
	public static void main(String[] args) {
		int memberCount = 500;
		
		Connection cn = JDBCTemplate.getConnection();
		
		System.out.println("회원 생성중");
		createMember(memberCount, cn); //매개변수 : 생성 인원수
		System.out.println("회원 생성 완료");
		
		
		JDBCTemplate.commit(cn);
		JDBCTemplate.close(cn);

	}
	
	public static void createMember(int count, Connection cn)
	{
		
		String[] firstNames = {"k강","k권","k김","n나","m문","p박","s손","s신","w왕","y유","y윤","l이","i임","j정","h한"};
		String[] lastNames = {"bs병승","yw영우","wj우진","js지섭","sh성희","ig일교","jh장현","jm재민","mr미리","jw진우","sh성화",
				"hj혜진","ys윤석","ma민아","dh동현","sg순규","cw찬웅","ja지안","ss성식","jb정복","dw도원","sl솔","jh준혁"};
		String sql = "INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL,?,'NEW',?,?,?,?,null,?,null,0)";
		PreparedStatement ps =null;
		try {
			

		ps=cn.prepareStatement(sql);
		
			for(int i=0; i<count;i++)
			{
				String str1 = firstNames[(int)(Math.random()*firstNames.length)];
				String str2 = lastNames[(int)(Math.random()*lastNames.length)];
				String str3 = String.valueOf((int)(Math.random()*10))+String.valueOf(i);
				if(Math.random()>0.5 && str2.length()>3)
				{
					str2=str2.substring(1, 2) + str2.substring(0, 1)+  str2.substring(3) + str2.substring(2,3);
				}
				//id설정
				ps.setString(1,str1.substring(0,1)+str2.substring(0,2)+str3);
		
				//비밀번호 설정 - 아이디 뒤에 붙은 숫자를 비밀번호로 설정
				MessageDigest md = null;
					try
					{
						md = MessageDigest.getInstance("SHA-512");
					}
					catch(NoSuchAlgorithmException e)
					{
						e.printStackTrace();
					}
				byte[] bytes = str3.getBytes(Charset.forName("UTF-8"));
				md.update(bytes);
				ps.setString(2, Base64.getEncoder().encodeToString(md.digest()));
				
				//이름설정
				ps.setString(3,str1.substring(1)+str2.substring(2));
				
				//이메일설정
				ps.setString(4, str1.substring(0,1)+str2.substring(0,2)+str3+(Math.random()<0.7?"@naver.com":(Math.random()<0.7?"@google.com":"@daum.net")));
				
				//폰번호설정
				ps.setString(5, "010"+String.format("%08d",(int)(Math.random()*100000000)));
				
				//가입일설정
				ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()-(long)(Math.random()*31536000000L)));
				
				ps.executeUpdate();
			}
		
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
