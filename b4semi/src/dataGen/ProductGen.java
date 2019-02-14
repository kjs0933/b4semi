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
		
		p= new ProductPrice("01V04001","고추",1000,2500,60,12);
		ps.setString(1,"01V04001");
		ps.setString(2,"b4farm");
		ps.setString(3,"고추");
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
		
		ps.setString(1,"01V05001");
		ps.setString(2,"b4farm");
		ps.setString(3,"콩나물");
		ps.setString(4,"국내산");
		ps.setString(5,"V05");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"01V05002");
		ps.setString(2,"b4farm");
		ps.setString(3,"숙주나물");
		ps.setString(4,"국내산");
		ps.setString(5,"V05");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"01V05003");
		ps.setString(2,"b4farm");
		ps.setString(3,"시금치");
		ps.setString(4,"국내산");
		ps.setString(5,"V05");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"01V05004");
		ps.setString(2,"b4farm");
		ps.setString(3,"고사리");
		ps.setString(4,"국내산");
		ps.setString(5,"V05");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"01V06001");
		ps.setString(2,"b4farm");
		ps.setString(3,"표고버섯");
		ps.setString(4,"국내산");
		ps.setString(5,"V06");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"01V06002");
		ps.setString(2,"b4farm");
		ps.setString(3,"팽이버섯");
		ps.setString(4,"국내산");
		ps.setString(5,"V06");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"01V06003");
		ps.setString(2,"b4farm");
		ps.setString(3,"새송이버섯");
		ps.setString(4,"국내산");
		ps.setString(5,"V06");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"01V07001");
		ps.setString(2,"b4farm");
		ps.setString(3,"브로콜리");
		ps.setString(4,"미국산");
		ps.setString(5,"V07");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"02F01001");
		ps.setString(2,"dalmont");
		ps.setString(3,"사과");
		ps.setString(4,"국내산");
		ps.setString(5,"F01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"02F01002");
		ps.setString(2,"dalmont");
		ps.setString(3,"바나나");
		ps.setString(4,"필리핀산");
		ps.setString(5,"F01");
		ps.setString(6,"송이");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"02F01003");
		ps.setString(2,"dalmont");
		ps.setString(3,"딸기");
		ps.setString(4,"국내산");
		ps.setString(5,"F01");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"02F01004");
		ps.setString(2,"dalmont");
		ps.setString(3,"토마토");
		ps.setString(4,"국내산");
		ps.setString(5,"F01");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"02F02001");
		ps.setString(2,"bonovo");
		ps.setString(3,"냉동딸기");
		ps.setString(4,"칠레산");
		ps.setString(5,"F02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"02F02002");
		ps.setString(2,"bonovo");
		ps.setString(3,"냉동블루베리");
		ps.setString(4,"미국산");
		ps.setString(5,"F02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"02F03001");
		ps.setString(2,"bonovo");
		ps.setString(3,"건포도");
		ps.setString(4,"중국산");
		ps.setString(5,"F03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"02F03002");
		ps.setString(2,"bonovo");
		ps.setString(3,"건크랜베리");
		ps.setString(4,"미국산");
		ps.setString(5,"F03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		
		ps.setString(1,"02F04001");
		ps.setString(2,"dalmont");
		ps.setString(3,"딸기잼");
		ps.setString(4,"국내산");
		ps.setString(5,"F04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"02F04002");
		ps.setString(2,"dalmont");
		ps.setString(3,"포도잼");
		ps.setString(4,"국내산");
		ps.setString(5,"F04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"02F04003");
		ps.setString(2,"dalmont");
		ps.setString(3,"오렌지주스");
		ps.setString(4,"미국산");
		ps.setString(5,"F04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"02F04004");
		ps.setString(2,"dalmont");
		ps.setString(3,"복숭아 통조림");
		ps.setString(4,"수입산");
		ps.setString(5,"F04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		
		ps.setString(1,"03G01001");
		ps.setString(2,"b4farm");
		ps.setString(3,"쌀");
		ps.setString(4,"국내산");
		ps.setString(5,"G01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"03G02001");
		ps.setString(2,"b4farm");
		ps.setString(3,"현미");
		ps.setString(4,"국내산");
		ps.setString(5,"G02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"03G02002");
		ps.setString(2,"b4farm");
		ps.setString(3,"찹쌀");
		ps.setString(4,"국내산");
		ps.setString(5,"G02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"03G02003");
		ps.setString(2,"b4farm");
		ps.setString(3,"팥");
		ps.setString(4,"국내산");
		ps.setString(5,"G02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		
		ps.setString(1,"03G03001");
		ps.setString(2,"bonovo");
		ps.setString(3,"땅콩");
		ps.setString(4,"중국산");
		ps.setString(5,"G03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"03G03002");
		ps.setString(2,"bonovo");
		ps.setString(3,"호두");
		ps.setString(4,"미국산");
		ps.setString(5,"G03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"03G03003");
		ps.setString(2,"bonovo");
		ps.setString(3,"아몬드");
		ps.setString(4,"미국산");
		ps.setString(5,"G03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"04S01001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"고등어");
		ps.setString(4,"노르웨이산");
		ps.setString(5,"S01");
		ps.setString(6,"마리");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"04S02001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"굴");
		ps.setString(4,"국내산");
		ps.setString(5,"S02");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"04S03001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"김");
		ps.setString(4,"국내산");
		ps.setString(5,"S03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"04S03002");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"미역");
		ps.setString(4,"국내산");
		ps.setString(5,"S03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"04S04001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"멸치");
		ps.setString(4,"국내산");
		ps.setString(5,"S04");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"04S05001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"오징어");
		ps.setString(4,"국내산");
		ps.setString(5,"S05");
		ps.setString(6,"마리");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"04S05002");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"낙지");
		ps.setString(4,"국내산");
		ps.setString(5,"S05");
		ps.setString(6,"마리");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"04S05003");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"문어");
		ps.setString(4,"국내산");
		ps.setString(5,"S05");
		ps.setString(6,"마리");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"04S06001");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"새우");
		ps.setString(4,"국내산");
		ps.setString(5,"S06");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"04S06002");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"꽃게");
		ps.setString(4,"국내산");
		ps.setString(5,"S06");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		
		ps.setString(1,"04S06003");
		ps.setString(2,"ajaxFish");
		ps.setString(3,"랍스터");
		ps.setString(4,"캐나다산");
		ps.setString(5,"S06");
		ps.setString(6,"마리");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"05M01001");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"삼겹살");
		ps.setString(4,"국내산");
		ps.setString(5,"M01");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"05M01002");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한돈 앞다리");
		ps.setString(4,"국내산");
		ps.setString(5,"M01");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"05M01003");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한돈 안심");
		ps.setString(4,"국내산");
		ps.setString(5,"M01");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"05M02001");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한우 등심");
		ps.setString(4,"국내산");
		ps.setString(5,"M02");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"05M02002");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한우 앞다리");
		ps.setString(4,"국내산");
		ps.setString(5,"M02");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"05M02003");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한우 차돌박이");
		ps.setString(4,"국내산");
		ps.setString(5,"M02");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"05M03001");
		ps.setString(2,"haerim");
		ps.setString(3,"생닭");
		ps.setString(4,"국내산");
		ps.setString(5,"M03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"05M03002");
		ps.setString(2,"haerim");
		ps.setString(3,"닭 볶음용");
		ps.setString(4,"국내산");
		ps.setString(5,"M03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"05M03003");
		ps.setString(2,"haerim");
		ps.setString(3,"훈제오리");
		ps.setString(4,"국내산");
		ps.setString(5,"M03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"05M04001");
		ps.setString(2,"haerim");
		ps.setString(3,"달걀");
		ps.setString(4,"국내산");
		ps.setString(5,"M04");
		ps.setString(6,"판");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"05M04002");
		ps.setString(2,"haerim");
		ps.setString(3,"메추리알");
		ps.setString(4,"국내산");
		ps.setString(5,"M04");
		ps.setString(6,"판");
		ps.executeUpdate();plist.add(p);
		
		
		ps.setString(1,"05M05001");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한돈 불고기");
		ps.setString(4,"국내산");
		ps.setString(5,"M05");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"05M05002");
		ps.setString(2,"rainbowMeat");
		ps.setString(3,"한우 불고기");
		ps.setString(4,"국내산");
		ps.setString(5,"M05");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		
		ps.setString(1,"06D01001");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"매달우유 1.8L");
		ps.setString(4,"국내산");
		ps.setString(5,"D01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"06D01002");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"매달우유 1L");
		ps.setString(4,"국내산");
		ps.setString(5,"D01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"06D02001");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"체다치즈");
		ps.setString(4,"국내산");
		ps.setString(5,"D02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"06D02002");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"피자치즈");
		ps.setString(4,"국내산");
		ps.setString(5,"D02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"06D03001");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"버터");
		ps.setString(4,"국내산");
		ps.setString(5,"D03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"06D04001");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"떠먹는 요거트");
		ps.setString(4,"국내산");
		ps.setString(5,"D04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"06D04002");
		ps.setString(2,"maedalMilk");
		ps.setString(3,"마시는 요거트");
		ps.setString(4,"국내산");
		ps.setString(5,"D04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"07C01001");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"명란젓");
		ps.setString(4,"러시아산");
		ps.setString(5,"C01");
		ps.setString(6,"g");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"07C02001");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"사골곰탕");
		ps.setString(4,"국내산");
		ps.setString(5,"C02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"07C02002");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"김치찌개");
		ps.setString(4,"국내산");
		ps.setString(5,"C02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"07C02003");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"된장찌개");
		ps.setString(4,"국내산");
		ps.setString(5,"C02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"07C03001");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"베이컨");
		ps.setString(4,"국내산");
		ps.setString(5,"C03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"07C03002");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"수제소시지");
		ps.setString(4,"국내산");
		ps.setString(5,"C03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		
		ps.setString(1,"07C04001");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"국산콩 두부");
		ps.setString(4,"국내산");
		ps.setString(5,"C04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"07C04002");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"국산콩 순두부");
		ps.setString(4,"국내산");
		ps.setString(5,"C04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		
		ps.setString(1,"07C04003");
		ps.setString(2,"sandeulchan");
		ps.setString(3,"어묵바");
		ps.setString(4,"국내산");
		ps.setString(5,"C04");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"07C05001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"참치캔");
		ps.setString(4,"원양산");
		ps.setString(5,"C05");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"08P01001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"멸치액젓");
		ps.setString(4,"국내산");
		ps.setString(5,"P01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"08P01002");
		ps.setString(2,"maeddugi");
		ps.setString(3,"까나리액젓");
		ps.setString(4,"국내산");
		ps.setString(5,"P01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"08P02001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"된장");
		ps.setString(4,"국내산");
		ps.setString(5,"P02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"08P02002");
		ps.setString(2,"maeddugi");
		ps.setString(3,"고추장");
		ps.setString(4,"국내산");
		ps.setString(5,"P02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"08P03001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"토마토케첩");
		ps.setString(4,"국내산");
		ps.setString(5,"P03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"08P03002");
		ps.setString(2,"maeddugi");
		ps.setString(3,"마요네즈");
		ps.setString(4,"국내산");
		ps.setString(5,"P03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"09I01001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"식용유");
		ps.setString(4,"국내산");
		ps.setString(5,"I01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"09I01002");
		ps.setString(2,"maeddugi");
		ps.setString(3,"참기름");
		ps.setString(4,"국내산");
		ps.setString(5,"I01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"09I01003");
		ps.setString(2,"maeddugi");
		ps.setString(3,"올리브유");
		ps.setString(4,"이탈리아산");
		ps.setString(5,"I01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"09I02001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"사과식초");
		ps.setString(4,"국내산");
		ps.setString(5,"I02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"09I02002");
		ps.setString(2,"maeddugi");
		ps.setString(3,"발사믹식초");
		ps.setString(4,"이탈리아산");
		ps.setString(5,"I02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"09I03001");
		ps.setString(2,"darkSnow");
		ps.setString(3,"스파게티면");
		ps.setString(4,"이탈리아산");
		ps.setString(5,"I03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"09I03002");
		ps.setString(2,"darkSnow");
		ps.setString(3,"소면");
		ps.setString(4,"미국산");
		ps.setString(5,"I03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		
		ps.setString(1,"09I03003");
		ps.setString(2,"darkSnow");
		ps.setString(3,"밀가루");
		ps.setString(4,"미국산");
		ps.setString(5,"I03");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		
		ps.setString(1,"10H01001");
		ps.setString(2,"darkSnow");
		ps.setString(3,"천일염");
		ps.setString(4,"국내산");
		ps.setString(5,"H01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"10H01002");
		ps.setString(2,"darkSnow");
		ps.setString(3,"구운소금");
		ps.setString(4,"국내산");
		ps.setString(5,"H01");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		
		ps.setString(1,"10H02001");
		ps.setString(2,"bonovo");
		ps.setString(3,"바질");
		ps.setString(4,"수입산");
		ps.setString(5,"H02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"10H02002");
		ps.setString(2,"bonovo");
		ps.setString(3,"로즈마리");
		ps.setString(4,"수입산");
		ps.setString(5,"H02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		ps.setString(1,"10H02003");
		ps.setString(2,"bonovo");
		ps.setString(3,"후추");
		ps.setString(4,"수입산");
		ps.setString(5,"H02");
		ps.setString(6,"개");
		ps.executeUpdate();plist.add(p);
		
		
		ps.setString(1,"10H03001");
		ps.setString(2,"maeddugi");
		ps.setString(3,"카레분말");
		ps.setString(4,"수입산");
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
