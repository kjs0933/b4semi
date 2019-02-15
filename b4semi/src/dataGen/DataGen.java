package dataGen;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;

import common.JDBCTemplate;

//더미 데이터 자동 생성을 위한 클래스
public class DataGen {
	
	
	public static void main(String[] args) {
		int memberCount = 500;
		int memberSeqStart = 1;

	 
		Connection cn = JDBCTemplate.getConnection();
		
		memberSeqStart = getMemberSeq(cn)+1;
		
		System.out.println("회원 생성중");
		createMember(memberCount, memberSeqStart, cn); //매개변수 : 생성 인원수, 시퀀스 시작 번호, 커넥션
		System.out.println("회원 생성 완료");
		System.out.println("배송지 생성중");
		createAddressList(memberCount, memberSeqStart, cn);
		System.out.println("배송지 생성 완료");
		System.out.println("공급사 생성중");
		createSupplier(cn);
		System.out.println("공급사 생성 완료");
		System.out.println("상품마스터 생성중");
		createProduct(cn);
		System.out.println("상품마스터 생성 완료");
		

		
		
		JDBCTemplate.commit(cn);
		JDBCTemplate.close(cn);

	}
	
	public static int getMemberSeq(Connection cn)
	{
		PreparedStatement ps =null;
		ResultSet rs = null;
		int result = 1;
		try {
			ps=cn.prepareStatement("SELECT MEMBER_SEQ.NEXTVAL FROM DUAL");
			rs=ps.executeQuery();
			if(rs.next())
			{
				result = rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
				rs.close();
				ps.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static void createMember(int memberCount, int memberSeqStart, Connection cn)
	{
		
		String[] firstNames = {"k강","k권","k김","n나","m문","p박","s손","s신","w왕","y유","y윤","l이","i임","j정","h한"};
		String[] lastNames = {"bs병승","yw영우","wj우진","js지섭","sh성희","ig일교","jh장현","jm재민","mr미리","jw진우","sh성화",
				"hj혜진","ys윤석","ma민아","dh동현","sg순규","cw찬웅","ja지안","ss성식","jb정복","dw도원","sl솔","jh준혁"};
		PreparedStatement ps =null;
		try {
			

		ps=cn.prepareStatement("INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL,?,'NEW',?,?,?,?,null,?,null,0)");
		
			//관리자 추가 : id = admin, pw = 1234
			ps.setString(1, "admin");
			ps.setString(2, "1ARVn2Auq2/WAqx2gNrL+q3RNjAzXpUfCXrzkA6d4Xa22yhRLy4AC50E+6UTPoscbo31nbOoq51gvkuXzJ6B2w==");
			ps.setString(3, "관리자");
			ps.setString(4, "admin@admin.co.kr");
			ps.setString(5, "01012345678");
			ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()-31536000000L));
			ps.executeUpdate();
		
			for(int i=memberSeqStart+1; i<memberSeqStart+memberCount;i++)
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
	
	public static void createAddressList(int memberCount, int memberSeqStart, Connection cn)
	{
		String[] address = AddressData.getAddress();
		int addressSize = address.length;
		
		String sql = "INSERT INTO ADDRESSLIST VALUES (ADDRESS_SEQ.NEXTVAL,?,?,?,?)";
		PreparedStatement ps =null;
		try {
			
		ps=cn.prepareStatement(sql);
		
			for(int i=memberSeqStart; i<memberSeqStart+memberCount;i++)
			{
				int addressCount = (int)(Math.random()*Math.random()*5);
				
				if(addressCount <1)
				{
					continue;
				}
				
				for(int j=1; j<=addressCount; j++)
				{
					//회원 번호 참조값
					ps.setInt(1,i);
					
					//태그명
					ps.setString(2, "주소"+j);
					
					//주소설정
					ps.setString(3, address[(int)(Math.random()*addressSize)]);
					
					//폰번호설정
					ps.setString(4, "010"+String.format("%08d",(int)(Math.random()*100000000)));
					
					ps.executeUpdate();
					
				}
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
	
	public static void createSupplier(Connection cn) {
		String[] address = AddressData.getAddress();
		int addressSize = address.length;
		
		String sql = "INSERT INTO SUPPLIER VALUES (?,?,?,?,?)";
		PreparedStatement ps =null;
		try {
			
		ps=cn.prepareStatement(sql);
		
		//공급사코드, 공급사이름, 공급사폰, 공급사주소, 공급사이메일
		ps.setString(1,"b4farm");
		ps.setString(2,"비포농산");
		ps.setString(3,"010"+String.format("%08d",(int)(Math.random()*100000000)));
		ps.setString(4,address[(int)(Math.random()*addressSize)]);
		ps.setString(5,"b4farm@naver.com");
		ps.executeUpdate();
		
		ps.setString(1,"ajaxFish");
		ps.setString(2,"에이작스수산");
		ps.setString(3,"010"+String.format("%08d",(int)(Math.random()*100000000)));
		ps.setString(4,address[(int)(Math.random()*addressSize)]);
		ps.setString(5,"ajaxFish@naver.com");
		ps.executeUpdate();
		
		ps.setString(1,"rainbowMeat");
		ps.setString(2,"무지개축산");
		ps.setString(3,"010"+String.format("%08d",(int)(Math.random()*100000000)));
		ps.setString(4,address[(int)(Math.random()*addressSize)]);
		ps.setString(5,"rainbowMeat@naver.com");
		ps.executeUpdate();
		
		ps.setString(1,"haerim");
		ps.setString(2,"해림");
		ps.setString(3,"010"+String.format("%08d",(int)(Math.random()*100000000)));
		ps.setString(4,address[(int)(Math.random()*addressSize)]);
		ps.setString(5,"haerim@naver.com");
		ps.executeUpdate();
		
		ps.setString(1,"dalmont");
		ps.setString(2,"달몬트");
		ps.setString(3,"010"+String.format("%08d",(int)(Math.random()*100000000)));
		ps.setString(4,address[(int)(Math.random()*addressSize)]);
		ps.setString(5,"dalmont@naver.com");
		ps.executeUpdate();
		
		ps.setString(1,"maedalMilk");
		ps.setString(2,"매달유업");
		ps.setString(3,"010"+String.format("%08d",(int)(Math.random()*100000000)));
		ps.setString(4,address[(int)(Math.random()*addressSize)]);
		ps.setString(5,"maedalMilk@naver.com");
		ps.executeUpdate();
		
		ps.setString(1,"darkSnow");
		ps.setString(2,"흑설");
		ps.setString(3,"010"+String.format("%08d",(int)(Math.random()*100000000)));
		ps.setString(4,address[(int)(Math.random()*addressSize)]);
		ps.setString(5,"darkSnow@naver.com");
		ps.executeUpdate();
		
		ps.setString(1,"maeddugi");
		ps.setString(2,"메뚜기");
		ps.setString(3,"010"+String.format("%08d",(int)(Math.random()*100000000)));
		ps.setString(4,address[(int)(Math.random()*addressSize)]);
		ps.setString(5,"maeddugi@naver.com");
		ps.executeUpdate();
		
		ps.setString(1,"sandeulchan");
		ps.setString(2,"산들반찬");
		ps.setString(3,"010"+String.format("%08d",(int)(Math.random()*100000000)));
		ps.setString(4,address[(int)(Math.random()*addressSize)]);
		ps.setString(5,"sandeulchan@naver.com");
		ps.executeUpdate();
		
		ps.setString(1,"bonovo");
		ps.setString(2,"보노보유통");
		ps.setString(3,"010"+String.format("%08d",(int)(Math.random()*100000000)));
		ps.setString(4,address[(int)(Math.random()*addressSize)]);
		ps.setString(5,"bonovo@naver.com");
		ps.executeUpdate();
		
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
	
	public static void createProduct(Connection cn)
	{
		String sql = "INSERT INTO PRODUCT VALUES (?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			
		ps=cn.prepareStatement(sql);
		
		//제품코드, 공급사코드, 상품명, 원산지, 소분류카테고리
		ps.setString(1,"01V01001");
		ps.setString(2,"b4farm");
		ps.setString(3,"상추");
		ps.setString(4,"국내산");
		ps.setString(5,"V01");
		ps.executeUpdate();
		
		ps.setString(1,"01V01002");
		ps.setString(2,"b4farm");
		ps.setString(3,"배추");
		ps.setString(4,"국내산");
		ps.setString(5,"V01");
		ps.executeUpdate();
		
		ps.setString(1,"01V01003");
		ps.setString(2,"b4farm");
		ps.setString(3,"양상추");
		ps.setString(4,"국내산");
		ps.setString(5,"V01");
		ps.executeUpdate();
		
		ps.setString(1,"01V01004");
		ps.setString(2,"b4farm");
		ps.setString(3,"깻잎");
		ps.setString(4,"국내산");
		ps.setString(5,"V01");
		ps.executeUpdate();
		
		ps.setString(1,"01V02001");
		ps.setString(2,"b4farm");
		ps.setString(3,"마늘");
		ps.setString(4,"국내산");
		ps.setString(5,"V02");
		ps.executeUpdate();
		
		ps.setString(1,"01V02002");
		ps.setString(2,"b4farm");
		ps.setString(3,"파");
		ps.setString(4,"국내산");
		ps.setString(5,"V02");
		ps.executeUpdate();
		
		ps.setString(1,"01V02003");
		ps.setString(2,"b4farm");
		ps.setString(3,"양파");
		ps.setString(4,"국내산");
		ps.setString(5,"V02");
		ps.executeUpdate();
		
		ps.setString(1,"01V03001");
		ps.setString(2,"b4farm");
		ps.setString(3,"당근");
		ps.setString(4,"국내산");
		ps.setString(5,"V03");
		ps.executeUpdate();
		
		ps.setString(1,"01V03002");
		ps.setString(2,"b4farm");
		ps.setString(3,"감자");
		ps.setString(4,"국내산");
		ps.setString(5,"V03");
		ps.executeUpdate();
		
		ps.setString(1,"01V03003");
		ps.setString(2,"b4farm");
		ps.setString(3,"고구마");
		ps.setString(4,"국내산");
		ps.setString(5,"V03");
		ps.executeUpdate();
		
		ps.setString(1,"01V03004");
		ps.setString(2,"b4farm");
		ps.setString(3,"무");
		ps.setString(4,"국내산");
		ps.setString(5,"V03");
		ps.executeUpdate();
		
		ps.setString(1,"01V04001");
		ps.setString(2,"b4farm");
		ps.setString(3,"고추");
		ps.setString(4,"국내산");
		ps.setString(5,"V04");
		ps.executeUpdate();
		
		ps.setString(1,"01V04002");
		ps.setString(2,"b4farm");
		ps.setString(3,"호박");
		ps.setString(4,"국내산");
		ps.setString(5,"V04");
		ps.executeUpdate();
		
		ps.setString(1,"01V04003");
		ps.setString(2,"b4farm");
		ps.setString(3,"오이");
		ps.setString(4,"국내산");
		ps.setString(5,"V04");
		ps.executeUpdate();
		
		ps.setString(1,"01V04004");
		ps.setString(2,"b4farm");
		ps.setString(3,"가지");
		ps.setString(4,"국내산");
		ps.setString(5,"V04");
		ps.executeUpdate();
		
		ps.setString(1,"01V05001");
		ps.setString(2,"b4farm");
		ps.setString(3,"콩나물");
		ps.setString(4,"국내산");
		ps.setString(5,"V05");
		ps.executeUpdate();
		
		ps.setString(1,"01V05002");
		ps.setString(2,"b4farm");
		ps.setString(3,"숙주나물");
		ps.setString(4,"국내산");
		ps.setString(5,"V05");
		ps.executeUpdate();
		
		ps.setString(1,"01V05003");
		ps.setString(2,"b4farm");
		ps.setString(3,"시금치");
		ps.setString(4,"국내산");
		ps.setString(5,"V05");
		ps.executeUpdate();
		
		ps.setString(1,"01V05004");
		ps.setString(2,"b4farm");
		ps.setString(3,"고사리");
		ps.setString(4,"국내산");
		ps.setString(5,"V05");
		ps.executeUpdate();
		
		ps.setString(1,"01V06001");
		ps.setString(2,"b4farm");
		ps.setString(3,"표고버섯");
		ps.setString(4,"국내산");
		ps.setString(5,"V06");
		ps.executeUpdate();
		
		ps.setString(1,"01V06002");
		ps.setString(2,"b4farm");
		ps.setString(3,"팽이버섯");
		ps.setString(4,"국내산");
		ps.setString(5,"V06");
		ps.executeUpdate();
		
		ps.setString(1,"01V06003");
		ps.setString(2,"b4farm");
		ps.setString(3,"새송이버섯");
		ps.setString(4,"국내산");
		ps.setString(5,"V06");
		ps.executeUpdate();
		
		ps.setString(1,"01V07001");
		ps.setString(2,"b4farm");
		ps.setString(3,"브로콜리");
		ps.setString(4,"미국산");
		ps.setString(5,"V07");
		ps.executeUpdate();
		
		ps.setString(1,"02F01001");
		ps.setString(2,"dalmont");
		ps.setString(3,"사과");
		ps.setString(4,"국내산");
		ps.setString(5,"F01");
		ps.executeUpdate();
		
		ps.setString(1,"02F01002");
		ps.setString(2,"dalmont");
		ps.setString(3,"바나나");
		ps.setString(4,"필리핀산");
		ps.setString(5,"F01");
		ps.executeUpdate();
		
		ps.setString(1,"02F01003");
		ps.setString(2,"dalmont");
		ps.setString(3,"딸기");
		ps.setString(4,"국내산");
		ps.setString(5,"F01");
		ps.executeUpdate();
		
		ps.setString(1,"02F01004");
		ps.setString(2,"dalmont");
		ps.setString(3,"토마토");
		ps.setString(4,"국내산");
		ps.setString(5,"F01");
		ps.executeUpdate();
		
		ps.setString(1,"02F02001");
		ps.setString(2,"bonovo");
		ps.setString(3,"냉동딸기");
		ps.setString(4,"칠레산");
		ps.setString(5,"F02");
		ps.executeUpdate();
		
		
		ps.setString(1,"02F02002");
		ps.setString(2,"bonovo");
		ps.setString(3,"냉동블루베리");
		ps.setString(4,"미국산");
		ps.setString(5,"F02");
		ps.executeUpdate();
		
		ps.setString(1,"02F03001");
		ps.setString(2,"bonovo");
		ps.setString(3,"건포도");
		ps.setString(4,"중국산");
		ps.setString(5,"F03");
		ps.executeUpdate();
		
		ps.setString(1,"02F03002");
		ps.setString(2,"bonovo");
		ps.setString(3,"건크랜베리");
		ps.setString(4,"미국산");
		ps.setString(5,"F03");
		ps.executeUpdate();
		
		
		ps.setString(1,"02F04001");
		ps.setString(2,"dalmont");
		ps.setString(3,"딸기잼");
		ps.setString(4,"국내산");
		ps.setString(5,"F04");
		ps.executeUpdate();
		
		ps.setString(1,"02F04002");
		ps.setString(2,"dalmont");
		ps.setString(3,"포도잼");
		ps.setString(4,"국내산");
		ps.setString(5,"F04");
		ps.executeUpdate();
		
		ps.setString(1,"02F04003");
		ps.setString(2,"dalmont");
		ps.setString(3,"오렌지주스");
		ps.setString(4,"미국산");
		ps.setString(5,"F04");
		ps.executeUpdate();
		
		ps.setString(1,"02F04004");
		ps.setString(2,"dalmont");
		ps.setString(3,"복숭아 통조림");
		ps.setString(4,"수입산");
		ps.setString(5,"F04");
		ps.executeUpdate();
		
		
		ps.setString(1,"03G01001");
		ps.setString(2,"b4farm");
		ps.setString(3,"쌀");
		ps.setString(4,"국내산");
		ps.setString(5,"G01");
		ps.executeUpdate();
		
		ps.setString(1,"03G02001");
		ps.setString(2,"b4farm");
		ps.setString(3,"현미");
		ps.setString(4,"국내산");
		ps.setString(5,"G02");
		ps.executeUpdate();
		
		ps.setString(1,"03G02002");
		ps.setString(2,"b4farm");
		ps.setString(3,"찹쌀");
		ps.setString(4,"국내산");
		ps.setString(5,"G02");
		ps.executeUpdate();
		
		ps.setString(1,"03G02003");
		ps.setString(2,"b4farm");
		ps.setString(3,"팥");
		ps.setString(4,"국내산");
		ps.setString(5,"G02");
		ps.executeUpdate();
		
		
		ps.setString(1,"03G03001");
		ps.setString(2,"bonovo");
		ps.setString(3,"땅콩");
		ps.setString(4,"중국산");
		ps.setString(5,"G03");
		ps.executeUpdate();
		
		ps.setString(1,"03G03002");
		ps.setString(2,"bonovo");
		ps.setString(3,"호두");
		ps.setString(4,"미국산");
		ps.setString(5,"G03");
		ps.executeUpdate();
		
		ps.setString(1,"03G03003");
		ps.setString(2,"bonovo");
		ps.setString(3,"아몬드");
		ps.setString(4,"미국산");
		ps.setString(5,"G03");
		ps.executeUpdate();
		
		ps.setString(1,"04S01001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"고등어");
		ps.setString(4,"노르웨이산");
		ps.setString(5,"S01");
		ps.executeUpdate();
		
		ps.setString(1,"04S02001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"굴");
		ps.setString(4,"국내산");
		ps.setString(5,"S02");
		ps.executeUpdate();
		
		ps.setString(1,"04S03001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"김");
		ps.setString(4,"국내산");
		ps.setString(5,"S03");
		ps.executeUpdate();
		
		ps.setString(1,"04S03002");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"미역");
		ps.setString(4,"국내산");
		ps.setString(5,"S03");
		ps.executeUpdate();
		
		ps.setString(1,"04S04001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"멸치");
		ps.setString(4,"국내산");
		ps.setString(5,"S04");
		ps.executeUpdate();
		
		ps.setString(1,"04S05001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"오징어");
		ps.setString(4,"국내산");
		ps.setString(5,"S05");
		ps.executeUpdate();
		
		ps.setString(1,"04S05002");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"낙지");
		ps.setString(4,"국내산");
		ps.setString(5,"S05");
		ps.executeUpdate();
		
		ps.setString(1,"04S05003");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"문어");
		ps.setString(4,"국내산");
		ps.setString(5,"S05");
		ps.executeUpdate();
		
		ps.setString(1,"04S06001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"새우");
		ps.setString(4,"국내산");
		ps.setString(5,"S06");
		ps.executeUpdate();
		
		ps.setString(1,"04S06002");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"꽃게");
		ps.setString(4,"국내산");
		ps.setString(5,"S06");
		ps.executeUpdate();
		
		ps.setString(1,"04S06003");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"랍스터");
		ps.setString(4,"캐나다산");
		ps.setString(5,"S06");
		ps.executeUpdate();
		
		ps.setString(1,"05M01001");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"삼겹살");
		ps.setString(4,"국내산");
		ps.setString(5,"M01");
		ps.executeUpdate();
		
		ps.setString(1,"05M01002");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한돈 앞다리");
		ps.setString(4,"국내산");
		ps.setString(5,"M01");
		ps.executeUpdate();
		
		ps.setString(1,"05M01003");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한돈 안심");
		ps.setString(4,"국내산");
		ps.setString(5,"M01");
		ps.executeUpdate();
		
		ps.setString(1,"05M02001");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한우 등심");
		ps.setString(4,"국내산");
		ps.setString(5,"M02");
		ps.executeUpdate();
		
		ps.setString(1,"05M02002");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한우 앞다리");
		ps.setString(4,"국내산");
		ps.setString(5,"M02");
		ps.executeUpdate();
		
		ps.setString(1,"05M02003");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한우 차돌박이");
		ps.setString(4,"국내산");
		ps.setString(5,"M02");
		ps.executeUpdate();
		
		ps.setString(1,"05M03001");
		ps.setString(2,"haerim");
		ps.setString(3,"생닭");
		ps.setString(4,"국내산");
		ps.setString(5,"M03");
		ps.executeUpdate();
		
		ps.setString(1,"05M03002");
		ps.setString(2,"haerim");
		ps.setString(3,"닭 볶음용");
		ps.setString(4,"국내산");
		ps.setString(5,"M03");
		ps.executeUpdate();
		
		ps.setString(1,"05M03003");
		ps.setString(2,"haerim");
		ps.setString(3,"훈제오리");
		ps.setString(4,"국내산");
		ps.setString(5,"M03");
		ps.executeUpdate();
		
		ps.setString(1,"05M04001");
		ps.setString(2,"haerim");
		ps.setString(3,"달걀");
		ps.setString(4,"국내산");
		ps.setString(5,"M04");
		ps.executeUpdate();
		
		ps.setString(1,"05M04002");
		ps.setString(2,"haerim");
		ps.setString(3,"메추리알");
		ps.setString(4,"국내산");
		ps.setString(5,"M04");
		ps.executeUpdate();
		
		
		ps.setString(1,"05M05001");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한돈 불고기");
		ps.setString(4,"국내산");
		ps.setString(5,"M05");
		ps.executeUpdate();
		
		ps.setString(1,"05M05002");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한우 불고기");
		ps.setString(4,"국내산");
		ps.setString(5,"M05");
		ps.executeUpdate();
		
		
		ps.setString(1,"06D01001");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"매달우유 1.8L");
		ps.setString(4,"국내산");
		ps.setString(5,"D01");
		ps.executeUpdate();
		
		ps.setString(1,"06D01002");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"매달우유 1L");
		ps.setString(4,"국내산");
		ps.setString(5,"D01");
		ps.executeUpdate();
		
		ps.setString(1,"06D02001");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"체다치즈");
		ps.setString(4,"국내산");
		ps.setString(5,"D02");
		ps.executeUpdate();
		
		ps.setString(1,"06D02002");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"피자치즈");
		ps.setString(4,"국내산");
		ps.setString(5,"D02");
		ps.executeUpdate();
		
		ps.setString(1,"06D03001");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"버터");
		ps.setString(4,"국내산");
		ps.setString(5,"D03");
		ps.executeUpdate();
		
		ps.setString(1,"06D04001");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"떠먹는 요거트");
		ps.setString(4,"국내산");
		ps.setString(5,"D04");
		ps.executeUpdate();
		
		ps.setString(1,"06D04002");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"마시는 요거트");
		ps.setString(4,"국내산");
		ps.setString(5,"D04");
		ps.executeUpdate();
		
		ps.setString(1,"07C01001");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"명란젓");
		ps.setString(4,"러시아산");
		ps.setString(5,"C01");
		ps.executeUpdate();
		
		ps.setString(1,"07C02001");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"사골곰탕");
		ps.setString(4,"국내산");
		ps.setString(5,"C02");
		ps.executeUpdate();
		
		ps.setString(1,"07C02002");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"김치찌개");
		ps.setString(4,"국내산");
		ps.setString(5,"C02");
		ps.executeUpdate();
		
		ps.setString(1,"07C02003");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"된장찌개");
		ps.setString(4,"국내산");
		ps.setString(5,"C02");
		ps.executeUpdate();
		
		ps.setString(1,"07C03001");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"베이컨");
		ps.setString(4,"국내산");
		ps.setString(5,"C03");
		ps.executeUpdate();
		
		ps.setString(1,"07C03002");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"수제소시지");
		ps.setString(4,"국내산");
		ps.setString(5,"C03");
		ps.executeUpdate();
		
		
		ps.setString(1,"07C04001");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"국산콩 두부");
		ps.setString(4,"국내산");
		ps.setString(5,"C04");
		ps.executeUpdate();
		
		ps.setString(1,"07C04002");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"국산콩 순두부");
		ps.setString(4,"국내산");
		ps.setString(5,"C04");
		ps.executeUpdate();
		
		
		ps.setString(1,"07C04003");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"어묵바");
		ps.setString(4,"국내산");
		ps.setString(5,"C04");
		ps.executeUpdate();
		
		ps.setString(1,"07C05001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"참치캔");
		ps.setString(4,"원양산");
		ps.setString(5,"C05");
		ps.executeUpdate();
		
		ps.setString(1,"08P01001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"멸치액젓");
		ps.setString(4,"국내산");
		ps.setString(5,"P01");
		ps.executeUpdate();
		
		ps.setString(1,"08P01002");
		ps.setString(2,"maeddugi");
		ps.setString(3,"까나리액젓");
		ps.setString(4,"국내산");
		ps.setString(5,"P01");
		ps.executeUpdate();
		
		ps.setString(1,"08P02001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"된장");
		ps.setString(4,"국내산");
		ps.setString(5,"P02");
		ps.executeUpdate();
		
		ps.setString(1,"08P02002");
		ps.setString(2,"maeddugi");
		ps.setString(3,"고추장");
		ps.setString(4,"국내산");
		ps.setString(5,"P02");
		ps.executeUpdate();
		
		ps.setString(1,"08P03001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"토마토케첩");
		ps.setString(4,"국내산");
		ps.setString(5,"P03");
		ps.executeUpdate();
		
		ps.setString(1,"08P03002");
		ps.setString(2,"maeddugi");
		ps.setString(3,"마요네즈");
		ps.setString(4,"국내산");
		ps.setString(5,"P03");
		ps.executeUpdate();
		
		ps.setString(1,"09I01001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"식용유");
		ps.setString(4,"국내산");
		ps.setString(5,"I01");
		ps.executeUpdate();
		
		ps.setString(1,"09I01002");
		ps.setString(2,"maeddugi");
		ps.setString(3,"참기름");
		ps.setString(4,"국내산");
		ps.setString(5,"I01");
		ps.executeUpdate();
		
		ps.setString(1,"09I01003");
		ps.setString(2,"maeddugi");
		ps.setString(3,"올리브유");
		ps.setString(4,"이탈리아산");
		ps.setString(5,"I01");
		ps.executeUpdate();
		
		ps.setString(1,"09I02001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"사과식초");
		ps.setString(4,"국내산");
		ps.setString(5,"I02");
		ps.executeUpdate();
		
		ps.setString(1,"09I02002");
		ps.setString(2,"maeddugi");
		ps.setString(3,"발사믹식초");
		ps.setString(4,"이탈리아산");
		ps.setString(5,"I02");
		ps.executeUpdate();
		
		ps.setString(1,"09I03001");
		ps.setString(2,"darkSnow");
		ps.setString(3,"스파게티면");
		ps.setString(4,"이탈리아산");
		ps.setString(5,"I03");
		ps.executeUpdate();
		
		ps.setString(1,"09I03002");
		ps.setString(2,"darkSnow");
		ps.setString(3,"소면");
		ps.setString(4,"미국산");
		ps.setString(5,"I03");
		ps.executeUpdate();
		
		
		ps.setString(1,"09I03003");
		ps.setString(2,"darkSnow");
		ps.setString(3,"밀가루");
		ps.setString(4,"미국산");
		ps.setString(5,"I03");
		ps.executeUpdate();
		
		
		ps.setString(1,"10H01001");
		ps.setString(2,"darkSnow");
		ps.setString(3,"천일염");
		ps.setString(4,"국내산");
		ps.setString(5,"H01");
		ps.executeUpdate();
		
		ps.setString(1,"10H01002");
		ps.setString(2,"darkSnow");
		ps.setString(3,"구운소금");
		ps.setString(4,"국내산");
		ps.setString(5,"H01");
		ps.executeUpdate();
		
		
		ps.setString(1,"10H02001");
		ps.setString(2,"bonovo");
		ps.setString(3,"바질");
		ps.setString(4,"수입산");
		ps.setString(5,"H02");
		ps.executeUpdate();
		
		ps.setString(1,"10H02002");
		ps.setString(2,"bonovo");
		ps.setString(3,"로즈마리");
		ps.setString(4,"수입산");
		ps.setString(5,"H02");
		ps.executeUpdate();
		
		ps.setString(1,"10H02003");
		ps.setString(2,"bonovo");
		ps.setString(3,"후추");
		ps.setString(4,"수입산");
		ps.setString(5,"H02");
		ps.executeUpdate();
		
		
		ps.setString(1,"10H03001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"카레분말");
		ps.setString(4,"수입산");
		ps.setString(5,"H03");
		ps.executeUpdate();
		
		
		
		
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
