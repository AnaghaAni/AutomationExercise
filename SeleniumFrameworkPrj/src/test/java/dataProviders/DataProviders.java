package dataProviders;

import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class DataProviders {
	
	//login data from excel
	
	@DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        String path = "src\\test\\resources\\testData\\LoginData.xlsx";
        List<Map<String, String>> list = ExcelUtils.getData(path, "Login");

        Object[][] data = new Object[list.size()][1]; // one Map per test case
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i);  // put each Map into Object[][]
        }
        return data;
    }
	
	
	//Signup data

	@DataProvider(name="signupData")
	public Object[][] getSignUpData()
	{
		String path = "src\\test\\resources\\testData\\SignUpData.xlsx";
        List<Map<String, String>> list = ExcelUtils.getData(path, "Signup");

        Object[][] data = new Object[list.size()][1]; // one Map per test case
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i);  // put each Map into Object[][]
        }
        return data;
		
	}
	
	//ContactUs data
    @DataProvider(name="contactusData")  
    public Object[][] getContactData() 
    {
            Object[][] data ={
                {"Anu", "anu@gmail.com", "Regarding Service", "Packing should be improved", "C:\\Users\\HP\\OneDrive\\Documents\\msg.docx"},
                {"Ravi", "ravi@yahoo.com", "Payment Issue", "Payment gateway failed", ""},
                {"Meera", "meera@hotmail.com", "Delivery Delay", "Delivery was delayed by 3 days", ""}
            };
            
            return data;
    }
    
    
    //SearchProduct
    @DataProvider(name = "searchProducts")
    public Object[][] getSearchProducts()
    {
        return new Object[][] {
            {"Jeans"},
            {"Cotton"}
        };
    }
}
