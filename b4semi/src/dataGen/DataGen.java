package dataGen;

import java.io.File;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;

import common.JDBCTemplate;

//더미 데이터 자동 생성을 위한 클래스 - DB 데이터 삭제 후 이용해주세요!
public class DataGen {
	
	private static final int memberCount = 500;  //생성 회원수
	private static final long howOld = 31536000000L; //마켓 오픈시점과 현재의 밀리초 차이
	private static final double priceInc = 0.2; //마켓 오픈시점부터 현시점까지의 물가상승률
	
	public static void main(String[] args) {

		
		int memberSeqStart = 1;
		int dpListSeqStart = 1;

	 
		Connection cn = JDBCTemplate.getConnection();
		
		memberSeqStart = getMemberSeq(cn)+1;
		
		System.out.println("회원 생성중");
		createMember(memberCount, memberSeqStart, cn); //매개변수 : 생성 인원수, 시퀀스 시작 번호, 커넥션
		System.out.println("회원 생성 완료");
		System.out.println("배송지 생성중");
		createAddressList(memberCount, memberSeqStart, cn);
		System.out.println("배송지 생성 완료");
		if(getProductCount(cn)>0)
		{
			System.out.println("상품 판매 데이터 초기화중");
			deleteDPOption(cn);
			deleteProduct(cn);
			JDBCTemplate.commit(cn);
			System.out.println("상품 판매 데이터 초기화 완료");
		}
		else
		{
			System.out.println("공급사 생성중");
			createSupplier(cn);
			System.out.println("공급사 생성 완료");
		}
		System.out.println("상품마스터 생성중");
		ArrayList<ProductPrice> plist = ProductGen.createProduct(cn);
		System.out.println("상품마스터 생성 완료");
		dpListSeqStart = getDPListSeq(cn);
		System.out.println("판매상품리스트, 이미지DB 생성중");
		createDPList(plist, dpListSeqStart, cn);
		System.out.println("판매상품리스트, 이미지DB 생성 완료");
		System.out.println("판매세부옵션 생성중");
		createDPOption(plist, dpListSeqStart, cn);
		System.out.println("판매세부옵션 생성완료");
		
		

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
			

		ps=cn.prepareStatement("INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL,?,'NEW',?,?,?,?,null,?,null,0,'N')");
		
			//관리자 추가 : id = admin, pw = 1234
			ps.setString(1, "admin");
			ps.setString(2, "1ARVn2Auq2/WAqx2gNrL+q3RNjAzXpUfCXrzkA6d4Xa22yhRLy4AC50E+6UTPoscbo31nbOoq51gvkuXzJ6B2w==");
			ps.setString(3, "관리자");
			ps.setString(4, "admin@admin.co.kr");
			ps.setString(5, "01012345678");
			ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()-howOld));
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
				ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()-(long)(Math.random()*howOld)));
				
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
				int addressCount = (int)(1+Math.random()*Math.random()*4);
				
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
	
	public static void deleteProduct(Connection cn)
	{
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			ps1=cn.prepareStatement("DELETE FROM PRODUCT CASCADE");
			ps1.executeUpdate();
			ps2=cn.prepareStatement("DELETE FROM IMAGES CASCADE");
			ps2.executeUpdate();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
				ps1.close();
				ps2.close();

			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void deleteDPOption(Connection cn)
	{
		PreparedStatement ps3 = null;
		try {
			ps3=cn.prepareStatement("DELETE FROM DPOPTION CASCADE");
			ps3.executeUpdate();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
				ps3.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static int getProductCount(Connection cn)
	{
		String sql = "SELECT COUNT(*) FROM PRODUCT";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result =0;
		try {
			
			ps=cn.prepareStatement(sql);
			rs = ps.executeQuery();
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
	
	public static int getDPListSeq(Connection cn)
	{
		PreparedStatement ps =null;
		ResultSet rs = null;
		int result = 1;
		try {
			ps=cn.prepareStatement("SELECT DISPLAY_LIST_SEQ.NEXTVAL FROM DUAL");
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
	
	public static void createDPList(ArrayList<ProductPrice> plist, int dpListSeqStart, Connection cn)
	{
		PreparedStatement ps1 =null;
		PreparedStatement ps2 =null;
		
		String sql1 = "INSERT INTO DPLIST VALUES (DISPLAY_LIST_SEQ.NEXTVAL,?,?,'Y',?)";
		String sql2 = "INSERT INTO IMAGES VALUES (?,?,'BL',?)";
		try {
		String[] prefixs = {"","신선한 ","맛있는 ","깨끗한 ","고급 ","실속있는 ","오리지널 ","친환경 ","부드러운 ","찰진 ","푸짐한 ", "향긋한 "};
		String prefix = prefixs[(int)(Math.random()*prefixs.length)];
		String title = prefix;
		String html = "";
		ProductPrice p;
		
		int listSize = plist.size();
		
		//판매글 추가
		ps1=cn.prepareStatement(sql1);
		//이미지 추가
		ps2=cn.prepareStatement(sql2);
		
		
			for(int i=0; i<listSize; i++)
			{
				p = plist.get(i);
				
				
				title +=p.getProductName();
				
				
				if("default".equals(p.getUrl()))
				{
					html +="<div class='DPListImages'><p>"+ prefix + p.getProductName() +
					"</p><img src='...imgpath..."+p.getProductName()+".jpg'></div>";

					//저장파일명
					ps2.setString(1, p.getProductName()+".jpg");
					//원본파일명
					ps2.setString(2, p.getProductName()+".jpg");
					//게시번호
					ps2.setInt(3, dpListSeqStart+p.getDpNo());
					ps2.executeUpdate();
				}
				else if(p.getUrl() != null)
				{
					html +="<div class='DPListImages'><p>"+ prefix + p.getProductName() +
					"</p><img src='...imgpath..."+p.getUrl()+"'></div>";
					
					//저장파일명
					ps2.setString(1, p.getUrl());
					//원본파일명
					ps2.setString(2, p.getUrl());
					//게시번호
					ps2.setInt(3, dpListSeqStart+p.getDpNo());
					ps2.executeUpdate();
				}

				
				if(i+1 == listSize || p.getDpNo() != plist.get(i+1).getDpNo())
				{

					//타이틀
					ps1.setString(1, title);
					//내용
					ps1.setString(2, html);
					//작성일
					ps1.setTimestamp(3, new Timestamp(System.currentTimeMillis()-howOld));
					ps1.executeUpdate();
					
					
					prefix = prefixs[(int)(Math.random()*prefixs.length)];
					title = prefix;
					html ="";
				}
				else
				{
					title +=", ";
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
				ps1.close();
				ps2.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void createDPOption(ArrayList<ProductPrice> plist, int dpListSeqStart, Connection cn)
	{
		PreparedStatement ps3 =null;
		String sql3 = "INSERT INTO DPOPTION VALUES (?,?,null,?,'Y')";
		
		try {
		ProductPrice p;
		
		int listSize = plist.size();
		
		//세부옵션 추가
		ps3=cn.prepareStatement(sql3);
		
			for(int i=0; i<listSize; i++)
			{
				p = plist.get(i);
				
				ps3.setString(1, p.getProductCode());
				ps3.setInt(2, dpListSeqStart+p.getDpNo());
				ps3.setInt(3, (int)(p.getOutPrice()*(0.01*Math.random()+0.1))*10   );
				ps3.executeUpdate();
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
				ps3.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}
