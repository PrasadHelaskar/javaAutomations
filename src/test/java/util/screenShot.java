//package organization;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.LocalDateTime;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.testng.annotations.Test;
//
//public class screenShot implements ITestListener
//{
//	@Test
//	public void onTestFailure(ITestResult arg0)
//	{
//		LocalDateTime ist=LocalDateTime.now();
//		String timeStamp = ist.toString().replace(":","");
//		TakesScreenshot tss= (TakesScreenshot) TC_30.driver;w
//		File scrshot = tss.getScreenshotAs(OutputType.FILE);
//		File desscrshot= new File("./ScreenShot/Vtiger"+timeStamp+".jpg");
//		try 
//		{
//			FileUtils.copyFile(scrshot, desscrshot);
//		} 
//		catch (IOException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}
//	}
//}
