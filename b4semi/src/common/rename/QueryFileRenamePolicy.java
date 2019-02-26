package common.rename;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class QueryFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File oldFile) {
		
		File newFile = null;
		do {
			long currentTime = System.currentTimeMillis();//서버의 밀리세컨초의 시간을 가져오는 메소드
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");//중복이 될수없도록!
			int rndNum=(int)(Math.random()*1000);
			String oldName = oldFile.getName();//파일명만 가져오는 메소드
			String ext="";//확장자 보관하기 위한 변수
			int dot = oldName.lastIndexOf(".");
			if(dot>-1)
			{
				ext = oldName.substring(dot);
			}
			//새로운 파일명 선언
			String newName = sdf.format(new Date(currentTime))+"_"+rndNum+ext;
			
			newFile = new File(oldFile.getParent(),newName); //부모디렉토리에 새 파일명을 결합
			
		}while(!createNewFile(newFile));
		
		return newFile;		
	}
	
	private boolean createNewFile(File newFile)
	{
		try
		{
			return newFile.createNewFile();
		}
		catch(IOException e)
		{
			return false;
		}
	}
}
