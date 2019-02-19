package common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper{

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getParameter(String key) {
		// TODO Auto-generated method stub
		String value="";
		if(key!=null && (key.equals("memberPw") || key.equals("memberPw_new")))
		{
			value = getSha512(super.getParameter(key));
		}
		else
		{
			value = super.getParameter(key);
		}
		return value;
	}
	
	private String getSha512(String value)
	{
		String encryPw = "";
		
		MessageDigest md = null;
		try
		{
			md = MessageDigest.getInstance("SHA-512");
		}
		catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		byte[] bytes = value.getBytes(Charset.forName("UTF-8"));
		md.update(bytes);
		
		encryPw = Base64.getEncoder().encodeToString(md.digest());
		return encryPw;
	}
	

}
