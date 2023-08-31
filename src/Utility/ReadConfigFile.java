package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ReadConfigFile 
{
	Properties pro;

	public ReadConfigFile(String path)
	{
		FileInputStream file;
		try {
			file = new FileInputStream(path);
			pro = new Properties();
			pro.load(file);
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getApplicationURL()
	{
	
		String url = pro.getProperty("baseURL");
		return url; 
	}
	
	public String getUserName() 
	{
		String username = pro.getProperty("username");
		return username;
		
	}
	
	public String getPassword() 
	{
		String pass = pro.getProperty("passwords");
		return pass;
		
	}
	
	public String clickLoginButton() 
	{
		String clickLoginButton = pro.getProperty("clickLoginButton");				
		return clickLoginButton;		
	}
	
	public String addtoCartbutton() 
	{
		String addtoCartbutton =pro.getProperty("AddtoCarts");
		return addtoCartbutton;
		
	}
}
