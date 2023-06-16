package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implimentation to ITestListener Interface
 * @author vinuv
 *
 */
public class ListenersImplimentation implements ITestListener
{
	ExtentReports report;
	ExtentTest test ;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		 System.out.println(methodname+"......Test Execution Started.......");
		
		test = report.createTest(methodname);
		test.log(Status.INFO,methodname+"->Execution started");
		
		 
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
	     System.out.println(methodname+"......Test Execution Successful.......");
	     test.log(Status.PASS, methodname+"->PASS");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		 System.out.println(methodname+"......Test Execution Failed.......");
		 System.out.println(result.getThrowable());
		 test.log(Status.FAIL,methodname+"-> FAIL");
		 test.log(Status.WARNING, result.getThrowable());
		 
		 
		 //Take Screenshot
		 String screenshotName=methodname+"-"+new JavaUtility().getSystemDateInFormat();
		 WebDriverUtility wutil=new WebDriverUtility();
		 try {
			 String path = wutil.takeScreenShot(BaseClass.sDriver, screenshotName);
			 test.addScreenCaptureFromPath(path);
			  
		 }catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		 System.out.println(methodname+"......Test Execution Skipped.......");
		 System.err.println(result.getThrowable());
		 test.log(Status.SKIP, methodname+"-> SKIPPED");
		 
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Execution Started");
		
		//Configure the extent reports (The format in which you want ot dispaly the report)
		//We get report in HTML format                                                   Foldername    Filename
		ExtentSparkReporter html=new ExtentSparkReporter(".\\ExtentReports\\Reports-"+new JavaUtility().getSystemDateInFormat()+".html");
		html.config().setDocumentTitle("Vtiger Execution Report");
		html.config().setReportName("Execution Report BuildV2.3/1");
		html.config().setTheme(Theme.DARK);      //There are different setters available can make use of any
		
		report=new ExtentReports();   //Main class
		report.attachReporter(html);
		report.setSystemInfo("Base Browser","Chrome");
		report.setSystemInfo("Base URL", "http://TestEnv.com");
		report.setSystemInfo("Base Platform", "Windows-Family");
		report.setSystemInfo("Reporter Name", "Vinutha");
		 
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		 System.out.println("......Test Execution Finished......");
		 
		 report.flush();  //Responsible for report generation is a end point where report will be generated
		
	}
	
	
	

}
