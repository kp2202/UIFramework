package library;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {


	
	
	
	public static void renameTestReport(String filepath) {
		System.out.println("File Path :"+filepath);
		File folder= new File(filepath);
		File[] listOfFiles=folder.listFiles();
		String newFileName=filepath+"TestAutomationReport_"+returnCurrentDateTime();
		System.out.println("New File Name :"+ newFileName);
		for(File file:listOfFiles) {

			if(file.isFile() && file.getName()=="Spark.html") {
				file.renameTo(new File (newFileName));
			}
		}
	}

	public static String returnCurrentDateTime() {
		/*
		 * SimpleDateFormat formatter= new SimpleDateFormat("ddMMyyyy_HHmmss"); Date
		 * date = new Date(System.currentTimeMillis()); return formatter.format(date);
		 */
		
		/* String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		* return timeStamp; 
		*/
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
		
		
	}
	


	public static void highlightElement(WebElement element,WebDriver driver) {
        for (int i = 0; i <2; i++) {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 2px solid yellow;");
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
            }
        }
}
