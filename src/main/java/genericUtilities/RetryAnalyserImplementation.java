package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will provide implementation for IRetryAnalyser
 * @author vinuv
 *
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count=0;
	int retryCount=4;
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		while(count<retryCount)
		{
			count++;		
		return true;
	}
	
	return false;
}

}
