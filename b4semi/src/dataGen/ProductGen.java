package dataGen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductGen {
	
	public static ArrayList<ProductPrice> createProduct(Connection cn)
	{
		String sql = "INSERT INTO PRODUCT VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ArrayList<ProductPrice> plist = new ArrayList<ProductPrice>();
		ProductPrice p = null;
		try {
			
		ps=cn.prepareStatement(sql);
		
		//제품코드, 상품명, 입고가, 출고가, 유통기한(날짜수), 판매게시글번호
		p= new ProductPrice("01V01001","상추",400,1000,7,1);
		//제품코드, 공급사코드, 상품명, 원산지, 소분류카테고리, 상품단위
		ps.setString(1,"01V01001");
		ps.setString(2,"b4farm");
		ps.setString(3,"상추");
		ps.setString(4,"국내산");
		ps.setString(5,"V01");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		
		p= new ProductPrice("01V01002","배추",800,2000,30,2);
		ps.setString(1,"01V01002");
		ps.setString(2,"b4farm");
		ps.setString(3,"배추");
		ps.setString(4,"국내산");
		ps.setString(5,"V01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V01003","양상추",700,1500,30,3);
		ps.setString(1,"01V01003");
		ps.setString(2,"b4farm");
		ps.setString(3,"양상추");
		ps.setString(4,"국내산");
		ps.setString(5,"V01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V01004","깻잎",600,1500,30,4);
		ps.setString(1,"01V01004");
		ps.setString(2,"b4farm");
		ps.setString(3,"깻잎");
		ps.setString(4,"국내산");
		ps.setString(5,"V01");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V02001","마늘",500,1200,60,5);
		ps.setString(1,"01V02001");
		ps.setString(2,"b4farm");
		ps.setString(3,"마늘");
		ps.setString(4,"국내산");
		ps.setString(5,"V02");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V02002","파",1400,3000,30,6);
		ps.setString(1,"01V02002");
		ps.setString(2,"b4farm");
		ps.setString(3,"파");
		ps.setString(4,"국내산");
		ps.setString(5,"V02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V02003","양파",300,800,30,7);
		ps.setString(1,"01V02003");
		ps.setString(2,"b4farm");
		ps.setString(3,"양파");
		ps.setString(4,"국내산");
		ps.setString(5,"V02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V03001","당근",450,1200,30,8);
		ps.setString(1,"01V03001");
		ps.setString(2,"b4farm");
		ps.setString(3,"당근");
		ps.setString(4,"국내산");
		ps.setString(5,"V03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V03002","감자",300,600,60,9);
		ps.setString(1,"01V03002");
		ps.setString(2,"b4farm");
		ps.setString(3,"감자");
		ps.setString(4,"국내산");
		ps.setString(5,"V03");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V03003","고구마",400,700,60,10);
		ps.setString(1,"01V03003");
		ps.setString(2,"b4farm");
		ps.setString(3,"고구마");
		ps.setString(4,"국내산");
		ps.setString(5,"V03");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V03004","무",1500,3500,30,11);
		ps.setString(1,"01V03004");
		ps.setString(2,"b4farm");
		ps.setString(3,"무");
		ps.setString(4,"국내산");
		ps.setString(5,"V03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V03005","자른 무",1500,3500,30,11,"01V03005.jpg");
		ps.setString(1,"01V03005");
		ps.setString(2,"b4farm");
		ps.setString(3,"자른 무");
		ps.setString(4,"국내산");
		ps.setString(5,"V03");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V04001","홍고추",1000,2500,60,12,"고추.jpg");
		ps.setString(1,"01V04001");
		ps.setString(2,"b4farm");
		ps.setString(3,"홍고추");
		ps.setString(4,"국내산");
		ps.setString(5,"V04");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V04005","청고추",1000,2500,60,12,"01V04005.jpg");
		ps.setString(1,"01V04005");
		ps.setString(2,"b4farm");
		ps.setString(3,"청고추");
		ps.setString(4,"국내산");
		ps.setString(5,"V04");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V04002","호박",2200,5000,90,13);
		ps.setString(1,"01V04002");
		ps.setString(2,"b4farm");
		ps.setString(3,"호박");
		ps.setString(4,"국내산");
		ps.setString(5,"V04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V04003","오이",300,750,30,14);
		ps.setString(1,"01V04003");
		ps.setString(2,"b4farm");
		ps.setString(3,"오이");
		ps.setString(4,"국내산");
		ps.setString(5,"V04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V04004","가지",600,1700,30,15);
		ps.setString(1,"01V04004");
		ps.setString(2,"b4farm");
		ps.setString(3,"가지");
		ps.setString(4,"국내산");
		ps.setString(5,"V04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V05001","콩나물",170,400,15,16);
		ps.setString(1,"01V05001");
		ps.setString(2,"b4farm");
		ps.setString(3,"콩나물");
		ps.setString(4,"국내산");
		ps.setString(5,"V05");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V05002","숙주나물",230,500,15,17);
		ps.setString(1,"01V05002");
		ps.setString(2,"b4farm");
		ps.setString(3,"숙주나물");
		ps.setString(4,"국내산");
		ps.setString(5,"V05");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V05003","시금치",400,900,30,18);
		ps.setString(1,"01V05003");
		ps.setString(2,"b4farm");
		ps.setString(3,"시금치");
		ps.setString(4,"국내산");
		ps.setString(5,"V05");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V05004","고사리",450,1100,30,19);
		ps.setString(1,"01V05004");
		ps.setString(2,"b4farm");
		ps.setString(3,"고사리");
		ps.setString(4,"국내산");
		ps.setString(5,"V05");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V06001","표고버섯",1000,2400,60,20);
		ps.setString(1,"01V06001");
		ps.setString(2,"b4farm");
		ps.setString(3,"표고버섯");
		ps.setString(4,"국내산");
		ps.setString(5,"V06");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V06002","팽이버섯",300,700,60,21);
		ps.setString(1,"01V06002");
		ps.setString(2,"b4farm");
		ps.setString(3,"팽이버섯");
		ps.setString(4,"국내산");
		ps.setString(5,"V06");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V06003","새송이버섯",400,850,60,22);
		ps.setString(1,"01V06003");
		ps.setString(2,"b4farm");
		ps.setString(3,"새송이버섯");
		ps.setString(4,"국내산");
		ps.setString(5,"V06");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("01V07001","브로콜리",950,2500,30,23);
		ps.setString(1,"01V07001");
		ps.setString(2,"b4farm");
		ps.setString(3,"브로콜리");
		ps.setString(4,"미국산");
		ps.setString(5,"V07");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("02F01001","사과",600,1500,30,24,"default","02F01-25");
		ps.setString(1,"02F01001");
		ps.setString(2,"dalmont");
		ps.setString(3,"사과");
		ps.setString(4,"국내산");
		ps.setString(5,"F01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("02F01002","바나나",1400,3000,30,25,"default","02F01-25");
		ps.setString(1,"02F01002");
		ps.setString(2,"dalmont");
		ps.setString(3,"바나나");
		ps.setString(4,"필리핀산");
		ps.setString(5,"F01");
		ps.setString(6,"송이");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("02F01003","딸기",1300,2700,30,26,"default","02F01-25");
		ps.setString(1,"02F01003");
		ps.setString(2,"dalmont");
		ps.setString(3,"딸기");
		ps.setString(4,"국내산");
		ps.setString(5,"F01");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("02F01004","토마토",550,1400,30,27,"default","02F01-25");
		ps.setString(1,"02F01004");
		ps.setString(2,"dalmont");
		ps.setString(3,"토마토");
		ps.setString(4,"국내산");
		ps.setString(5,"F01");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("02F02001","냉동딸기",3300,6000,3600,28);
		ps.setString(1,"02F02001");
		ps.setString(2,"bonovo");
		ps.setString(3,"냉동딸기");
		ps.setString(4,"칠레산");
		ps.setString(5,"F02");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("02F02002","냉동블루베리",3000,5500,3600,29);
		ps.setString(1,"02F02002");
		ps.setString(2,"bonovo");
		ps.setString(3,"냉동블루베리");
		ps.setString(4,"미국산");
		ps.setString(5,"F02");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("02F03001","건포도",2000,4500,720,30);
		ps.setString(1,"02F03001");
		ps.setString(2,"bonovo");
		ps.setString(3,"건포도");
		ps.setString(4,"중국산");
		ps.setString(5,"F03");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("02F03002","건크랜베리",2000,4000,720,31);
		ps.setString(1,"02F03002");
		ps.setString(2,"bonovo");
		ps.setString(3,"건크랜베리");
		ps.setString(4,"미국산");
		ps.setString(5,"F03");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		
		p= new ProductPrice("02F04001","딸기잼",1900,3800,1080,32,"잼.jpg");
		ps.setString(1,"02F04001");
		ps.setString(2,"dalmont");
		ps.setString(3,"딸기잼");
		ps.setString(4,"국내산");
		ps.setString(5,"F04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("02F04002","포도잼",1900,3800,1080,32,null);
		ps.setString(1,"02F04002");
		ps.setString(2,"dalmont");
		ps.setString(3,"포도잼");
		ps.setString(4,"국내산");
		ps.setString(5,"F04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("02F04005","망고백향과잼",2600,4800,1080,32,null);
		ps.setString(1,"02F04005");
		ps.setString(2,"dalmont");
		ps.setString(3,"망고백향과잼");
		ps.setString(4,"수입산");
		ps.setString(5,"F04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("02F04003","오렌지주스",1700,3500,180,33);
		ps.setString(1,"02F04003");
		ps.setString(2,"dalmont");
		ps.setString(3,"오렌지주스");
		ps.setString(4,"미국산");
		ps.setString(5,"F04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("02F04004","복숭아 통조림",1500,3000,720,34);
		ps.setString(1,"02F04004");
		ps.setString(2,"dalmont");
		ps.setString(3,"복숭아 통조림");
		ps.setString(4,"수입산");
		ps.setString(5,"F04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		
		p= new ProductPrice("03G01001","쌀",20200,39800,720,35);
		ps.setString(1,"03G01001");
		ps.setString(2,"b4farm");
		ps.setString(3,"쌀");
		ps.setString(4,"국내산");
		ps.setString(5,"G01");
		ps.setString(6,"20kg");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("03G02001","현미",11500,22000,720,36);
		ps.setString(1,"03G02001");
		ps.setString(2,"b4farm");
		ps.setString(3,"현미");
		ps.setString(4,"국내산");
		ps.setString(5,"G02");
		ps.setString(6,"10kg");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("03G02002","찹쌀",13000,24000,720,37);
		ps.setString(1,"03G02002");
		ps.setString(2,"b4farm");
		ps.setString(3,"찹쌀");
		ps.setString(4,"국내산");
		ps.setString(5,"G02");
		ps.setString(6,"10kg");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("03G02003","팥",6000,11000,720,38);
		ps.setString(1,"03G02003");
		ps.setString(2,"b4farm");
		ps.setString(3,"팥");
		ps.setString(4,"국내산");
		ps.setString(5,"G02");
		ps.setString(6,"5kg");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("03G03001","땅콩",2300,4500,720,39);
		ps.setString(1,"03G03001");
		ps.setString(2,"bonovo");
		ps.setString(3,"땅콩");
		ps.setString(4,"중국산");
		ps.setString(5,"G03");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("03G03002","호두",4900,9900,720,40);
		ps.setString(1,"03G03002");
		ps.setString(2,"bonovo");
		ps.setString(3,"호두");
		ps.setString(4,"미국산");
		ps.setString(5,"G03");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("03G03003","아몬드",4500,8900,720,41);
		ps.setString(1,"03G03003");
		ps.setString(2,"bonovo");
		ps.setString(3,"아몬드");
		ps.setString(4,"미국산");
		ps.setString(5,"G03");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("04S01001","고등어",2000,3300,15,42,"default","04-15");
		ps.setString(1,"04S01001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"고등어");
		ps.setString(4,"노르웨이산");
		ps.setString(5,"S01");
		ps.setString(6,"마리");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("04S02001","굴",1600,3500,15,43,"default","04-15");
		ps.setString(1,"04S02001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"굴");
		ps.setString(4,"국내산");
		ps.setString(5,"S02");
		ps.setString(6,"봉");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("04S03001","김",6000,11000,90,44,"default","04-15");
		ps.setString(1,"04S03001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"김");
		ps.setString(4,"국내산");
		ps.setString(5,"S03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("04S03002","미역",2000,4200,90,45);
		ps.setString(1,"04S03002");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"미역");
		ps.setString(4,"국내산");
		ps.setString(5,"S03");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("04S04001","멸치",8000,14000,180,46,"default","04-15");
		ps.setString(1,"04S04001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"멸치");
		ps.setString(4,"국내산");
		ps.setString(5,"S04");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("04S05001","오징어",2000,4000,15,47,"default","04-15");
		ps.setString(1,"04S05001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"오징어");
		ps.setString(4,"국내산");
		ps.setString(5,"S05");
		ps.setString(6,"마리");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("04S05002","낙지",1900,3800,15,48);
		ps.setString(1,"04S05002");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"낙지");
		ps.setString(4,"국내산");
		ps.setString(5,"S05");
		ps.setString(6,"마리");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("04S05003","문어",4500,9000,15,49,"default","04-15");
		ps.setString(1,"04S05003");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"문어");
		ps.setString(4,"국내산");
		ps.setString(5,"S05");
		ps.setString(6,"마리");
		ps.executeUpdate();plist.add(p);
	
		p= new ProductPrice("04S06001","새우",700,1400,15,50,"default","04-15");
		ps.setString(1,"04S06001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"새우");
		ps.setString(4,"국내산");
		ps.setString(5,"S06");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("04S06002","꽃게",1050,2100,15,51);
		ps.setString(1,"04S06002");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"꽃게");
		ps.setString(4,"국내산");
		ps.setString(5,"S06");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		
		p= new ProductPrice("04S06003","랍스터",17000,31000,15,52,"default","04-15");
		ps.setString(1,"04S06003");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"랍스터");
		ps.setString(4,"캐나다산");
		ps.setString(5,"S06");
		ps.setString(6,"마리");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("05M01001","삼겹살",900,1800,15,53);
		ps.setString(1,"05M01001");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"삼겹살");
		ps.setString(4,"국내산");
		ps.setString(5,"M01");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("05M01002","한돈 앞다리",600,1200,15,54);
		ps.setString(1,"05M01002");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한돈 앞다리");
		ps.setString(4,"국내산");
		ps.setString(5,"M01");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("05M01003","한돈 안심",800,1600,15,55);
		ps.setString(1,"05M01003");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한돈 안심");
		ps.setString(4,"국내산");
		ps.setString(5,"M01");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("05M02001","한우 등심",4500,9500,15,56,"default","05M02-30");
		ps.setString(1,"05M02001");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한우 등심");
		ps.setString(4,"국내산");
		ps.setString(5,"M02");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("05M02002","한우 앞다리",2200,4400,15,57,"default","05M02-30");
		ps.setString(1,"05M02002");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한우 앞다리");
		ps.setString(4,"국내산");
		ps.setString(5,"M02");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("05M02003","한우 차돌박이",2700,5400,15,58,"default","05M02-30");
		ps.setString(1,"05M02003");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한우 차돌박이");
		ps.setString(4,"국내산");
		ps.setString(5,"M02");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("05M03001","생닭",2800,4800,15,59);
		ps.setString(1,"05M03001");
		ps.setString(2,"haerim");
		ps.setString(3,"생닭");
		ps.setString(4,"국내산");
		ps.setString(5,"M03");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("05M03002","닭 볶음용",3300,5800,15,60);
		ps.setString(1,"05M03002");
		ps.setString(2,"haerim");
		ps.setString(3,"닭 볶음용");
		ps.setString(4,"국내산");
		ps.setString(5,"M03");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("05M03003","훈제오리",4000,7700,180,61);
		ps.setString(1,"05M03003");
		ps.setString(2,"haerim");
		ps.setString(3,"훈제오리");
		ps.setString(4,"국내산");
		ps.setString(5,"M03");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("05M04001","달걀",2700,5400,30,62);
		ps.setString(1,"05M04001");
		ps.setString(2,"haerim");
		ps.setString(3,"달걀");
		ps.setString(4,"국내산");
		ps.setString(5,"M04");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("05M04002","메추리알",2000,3600,30,63);
		ps.setString(1,"05M04002");
		ps.setString(2,"haerim");
		ps.setString(3,"메추리알");
		ps.setString(4,"국내산");
		ps.setString(5,"M04");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("05M05001","한돈 불고기",800,1400,15,64);
		ps.setString(1,"05M05001");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한돈 불고기");
		ps.setString(4,"국내산");
		ps.setString(5,"M05");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("05M05002","한우 불고기",1600,3300,15,65);
		ps.setString(1,"05M05002");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한우 불고기");
		ps.setString(4,"국내산");
		ps.setString(5,"M05");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("06D01001","매달우유 1.8L",2400,4400,15,66);
		ps.setString(1,"06D01001");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"매달우유 1.8L");
		ps.setString(4,"국내산");
		ps.setString(5,"D01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("06D01002","매달우유 1L",1500,2700,15,66);
		ps.setString(1,"06D01002");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"매달우유 1L");
		ps.setString(4,"국내산");
		ps.setString(5,"D01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("06D02001","체다치즈",3000,6000,60,67);
		ps.setString(1,"06D02001");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"체다치즈");
		ps.setString(4,"국내산");
		ps.setString(5,"D02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("06D02002","피자치즈",4400,9900,60,68);
		ps.setString(1,"06D02002");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"피자치즈");
		ps.setString(4,"국내산");
		ps.setString(5,"D02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("06D03001","버터",3500,6300,90,69);
		ps.setString(1,"06D03001");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"버터");
		ps.setString(4,"국내산");
		ps.setString(5,"D03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("06D04001","떠먹는 요거트",2200,4300,30,70);
		ps.setString(1,"06D04001");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"떠먹는 요거트");
		ps.setString(4,"국내산");
		ps.setString(5,"D04");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("06D04002","마시는 요거트",1600,3300,30,71);
		ps.setString(1,"06D04002");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"마시는 요거트");
		ps.setString(4,"국내산");
		ps.setString(5,"D04");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("07C01001","명란젓",3400,7000,60,72);
		ps.setString(1,"07C01001");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"명란젓");
		ps.setString(4,"러시아산");
		ps.setString(5,"C01");
		ps.setString(6,"100g");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("07C02001","사골곰탕",2500,5000,7,73,"default","07C02-10");
		ps.setString(1,"07C02001");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"사골곰탕");
		ps.setString(4,"국내산");
		ps.setString(5,"C02");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("07C02002","김치찌개",3000,5000,7,74,"default","07C02-10");
		ps.setString(1,"07C02002");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"김치찌개");
		ps.setString(4,"국내산");
		ps.setString(5,"C02");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("07C02003","된장찌개",2900,5000,7,75,"default","07C02-10");
		ps.setString(1,"07C02003");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"된장찌개");
		ps.setString(4,"국내산");
		ps.setString(5,"C02");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("07C03001","베이컨",4400,7700,180,76);
		ps.setString(1,"07C03001");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"베이컨");
		ps.setString(4,"국내산");
		ps.setString(5,"C03");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("07C03002","수제소시지",6400,12800,180,77);
		ps.setString(1,"07C03002");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"수제소시지");
		ps.setString(4,"국내산");
		ps.setString(5,"C03");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("07C04001","국산콩 두부",1700,3300,30,78);
		ps.setString(1,"07C04001");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"국산콩 두부");
		ps.setString(4,"국내산");
		ps.setString(5,"C04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("07C04002","국산콩 순두부",1150,2300,30,79);
		ps.setString(1,"07C04002");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"국산콩 순두부");
		ps.setString(4,"국내산");
		ps.setString(5,"C04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("07C04003","어묵바",1750,3300,30,80);
		ps.setString(1,"07C04003");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"어묵바");
		ps.setString(4,"국내산");
		ps.setString(5,"C04");
		ps.setString(6,"팩");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("07C05001","참치캔",1300,2200,1080,81);
		ps.setString(1,"07C05001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"참치캔");
		ps.setString(4,"원양산");
		ps.setString(5,"C05");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("08P01001","멸치액젓",3210,6660,1080,82);
		ps.setString(1,"08P01001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"멸치액젓");
		ps.setString(4,"국내산");
		ps.setString(5,"P01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("08P01002","까나리액젓",3450,6780,1080,83);
		ps.setString(1,"08P01002");
		ps.setString(2,"maeddugi");
		ps.setString(3,"까나리액젓");
		ps.setString(4,"국내산");
		ps.setString(5,"P01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("08P02001","된장",4320,7890,360,84);
		ps.setString(1,"08P02001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"된장");
		ps.setString(4,"국내산");
		ps.setString(5,"P02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("08P02002","고추장",4000,7650,360,85);
		ps.setString(1,"08P02002");
		ps.setString(2,"maeddugi");
		ps.setString(3,"고추장");
		ps.setString(4,"국내산");
		ps.setString(5,"P02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("08P03001","토마토케첩",1450,2760,360,86);
		ps.setString(1,"08P03001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"토마토케첩");
		ps.setString(4,"국내산");
		ps.setString(5,"P03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("08P03002","마요네즈",1760,3060,360,87);
		ps.setString(1,"08P03002");
		ps.setString(2,"maeddugi");
		ps.setString(3,"마요네즈");
		ps.setString(4,"국내산");
		ps.setString(5,"P03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("09I01001","식용유",1900,3500,720,88);
		ps.setString(1,"09I01001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"식용유");
		ps.setString(4,"국내산");
		ps.setString(5,"I01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("09I01002","참기름",2900,5500,720,89);
		ps.setString(1,"09I01002");
		ps.setString(2,"maeddugi");
		ps.setString(3,"참기름");
		ps.setString(4,"국내산");
		ps.setString(5,"I01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("09I01003","올리브유",2400,4500,720,90);
		ps.setString(1,"09I01003");
		ps.setString(2,"maeddugi");
		ps.setString(3,"올리브유");
		ps.setString(4,"이탈리아산");
		ps.setString(5,"I01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("09I02001","사과식초",1410,2500,720,91);
		ps.setString(1,"09I02001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"사과식초");
		ps.setString(4,"국내산");
		ps.setString(5,"I02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("09I02002","발사믹식초",3890,6500,720,92);
		ps.setString(1,"09I02002");
		ps.setString(2,"maeddugi");
		ps.setString(3,"발사믹식초");
		ps.setString(4,"이탈리아산");
		ps.setString(5,"I02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("09I03001","스파게티면",950,1980,720,93);
		ps.setString(1,"09I03001");
		ps.setString(2,"darkSnow");
		ps.setString(3,"스파게티면");
		ps.setString(4,"이탈리아산");
		ps.setString(5,"I03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("09I03002","소면",1350,2980,720,94);
		ps.setString(1,"09I03002");
		ps.setString(2,"darkSnow");
		ps.setString(3,"소면");
		ps.setString(4,"미국산");
		ps.setString(5,"I03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("09I03003","밀가루",1660,3190,720,95);
		ps.setString(1,"09I03003");
		ps.setString(2,"darkSnow");
		ps.setString(3,"밀가루");
		ps.setString(4,"미국산");
		ps.setString(5,"I03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("10H01001","천일염",5050,8080,720,96);
		ps.setString(1,"10H01001");
		ps.setString(2,"darkSnow");
		ps.setString(3,"천일염");
		ps.setString(4,"국내산");
		ps.setString(5,"H01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("10H01002","구운소금",3030,5790,720,97);
		ps.setString(1,"10H01002");
		ps.setString(2,"darkSnow");
		ps.setString(3,"구운소금");
		ps.setString(4,"국내산");
		ps.setString(5,"H01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		
		p= new ProductPrice("10H02001","바질",2230,4790,720,98);
		ps.setString(1,"10H02001");
		ps.setString(2,"bonovo");
		ps.setString(3,"바질");
		ps.setString(4,"수입산");
		ps.setString(5,"H02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("10H02002","로즈마리",2240,4800,720,99);
		ps.setString(1,"10H02002");
		ps.setString(2,"bonovo");
		ps.setString(3,"로즈마리");
		ps.setString(4,"수입산");
		ps.setString(5,"H02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("10H02003","후추",1550,3210,720,100);
		ps.setString(1,"10H02003");
		ps.setString(2,"bonovo");
		ps.setString(3,"후추");
		ps.setString(4,"수입산");
		ps.setString(5,"H02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("10H02004","커민",3100,6220,720,101);
		ps.setString(1,"10H02004");
		ps.setString(2,"bonovo");
		ps.setString(3,"커민");
		ps.setString(4,"수입산");
		ps.setString(5,"H02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("10H03001","카레분말",2220,3770,720,102,"default","10H03-20");
		ps.setString(1,"10H03001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"카레분말");
		ps.setString(4,"수입산");
		ps.setString(5,"H03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		
		p= new ProductPrice("10H03002","멸치분말",2000,4000,720,103,"천연분말.jpg","10H03-20");
		ps.setString(1,"10H03002");
		ps.setString(2,"darkSnow");
		ps.setString(3,"멸치분말");
		ps.setString(4,"국내산");
		ps.setString(5,"H03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		
		p= new ProductPrice("10H03003","새우분말",2500,5000,720,103,null,"10H03-20");
		ps.setString(1,"10H03003");
		ps.setString(2,"darkSnow");
		ps.setString(3,"새우분말");
		ps.setString(4,"국내산");
		ps.setString(5,"H03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		p= new ProductPrice("10H03004","다시마분말",3000,6000,720,103,null,"10H03-20");
		ps.setString(1,"10H03004");
		ps.setString(2,"darkSnow");
		ps.setString(3,"다시마분말");
		ps.setString(4,"국내산");
		ps.setString(5,"H03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
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
		return plist;
	}

}
