package common;

import java.util.TimeZone;

// 시간 경과에 따른 회원 등급 조정, 쿠폰 만료, 유통기한 만료 처리를 위한 클래스 
public class TimeSystem extends Thread {
	
	
	private static final int OFFSET = TimeZone.getDefault().getRawOffset(); // 실행국가에 따른 시간 차이를 밀리초단위로 환산한 값 
	private static boolean isInitialized = false;
	private long day=0; //날짜단위의 변화를 감지하기 위한 값
	
	private TimeSystem() { // 외부 생성 불가능
		setDaemon(true);
	} 
	
	public synchronized static void initialize() {
		if(!isInitialized)
		{
			isInitialized = true;
			new TimeSystem().start();
		}
	}
	
	//시간 경과에 따른 쓰레드 로직
	public void run()
	{
		try {
			for(;;)
			{
				sleep(1000);
				if(dayChangeCheck())
				{
					System.out.println("타임시스템 - 시스템 날짜 변경 및 데이터 갱신");
					// 데이터 갱신 로직
				}
			}
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	//날짜가 바뀌면 true 리턴
	public boolean dayChangeCheck () {
		if(day != day(System.currentTimeMillis()))
		{
			day = day(System.currentTimeMillis());
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static long day(long date) // UMT 밀리초 시간을 한국시간으로 환산 후 날짜 단위값으로 리턴하는 메소드
	{
		return (date + OFFSET)/86400000L;
	}
	
	public static long dayInv(long day) //위 메소드의 역함수 - 이때 시간 단위는 버려진다
	{
		return (day*86400000L) - OFFSET;
	}
	

}
