package base_class;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Grocery_project extends sir_copy{
    public void Booking() throws IOException, Exception {
    	
    	browserLaunch("CHROME");
    	
    	enterApplnUrl("https://omrbranch.com/");
    	
    	maximizeWindow();
    	
    	implicitWait();
    	
    	WebElement txtusername = findLocatorByXpath("//input[@id='email']");
    	elementSendKeys(txtusername,getcellData("grocery", 1, 0) );
    	
    	WebElement txtpass = findLocatorByXpath("//input[@id='pass']");
    	elementSendKeys(txtpass, getcellData("grocery", 1, 1));
    	
    	WebElement btnlogin = findLocatorByXpath(""	+ "+");
    	elementClick(btnlogin);
    	
    	
    	
//     	WebElement element_cart = findLocatorByXpath("//span[@class='cart badge badge-xs badge-danger position-relative mr-0 cart_count']");
//   	    String string = elementGetText(element_cart);
//   	    
//    	String c="0";
//    	if(string!=c) {
//    	WebElement btncart = findLocatorByXpath("//i[@class='fa fa-shopping-cart']");
//    	elementClick(btncart);
//    	List<WebElement> btn_cancell = List_findLocatorByXpath1("//div[@class='scheduleClose']");
//    	
//    	threadsleep(5000);
//    	//visiblityOf(btn_cancell);
//    	for (WebElement X:btn_cancell) {
//    		elementclick(X);
//    	visiblityOf(X);
//			
//		}
//    	}
    	
    	WebElement gettextwelcome = findLocatorByXpath("//a[@data-testid='username']");
    	String text = elementGetText(gettextwelcome);
    	System.out.println(text);
    	
    	WebElement txtsearch = findLocatorByXpath("//input[@id='search']");
    	elementSendKeys(txtsearch, getcellData("grocery", 1, 2));
    	String searchedtext = elementGetAttribute(txtsearch);
    	System.out.println(searchedtext);
    	
    	visiblityOf(txtsearch);
    	WebElement searchclick = findLocatorByXpath("(//button[@type='submit'])[1]");
    	elementClick(searchclick);
    	
    	Thread.sleep(3000);
    	WebElement txtserchnut = findLocatorByXpath("//h5[contains(text(),'Search Result')]");
    	String text7 = txtserchnut.getText();
    	System.out.println(text7);
    	
    	
    	WebElement btnaddnuts = findLocatorByXpath("(//a[text()='Add'])[1]");
    	elementClick(btnaddnuts);
    	
    	WebElement btn_addnut_variant = findLocatorByXpath("(//button[text()='Add'])[1]");
    	elementClick(btn_addnut_variant);
    	
    	threadsleep(3000);
    	WebElement btngo_to_cart = findLocatorByXpath("//a[@class='hover1']");
    	elementclick(btngo_to_cart);
    	
    	getApplnTitle();
    	
    	WebElement delivery_add_title = findLocatorByXpath("//div[text()='Delivery Address']");
        String text2 = elementGetText(delivery_add_title);
        System.out.println(text2);
    	
    	WebElement btn_add_address = findLocatorByXpath("//div[@data-toggle='modal']");
    	elementclick(btn_add_address);
    	
    	
    	WebElement  ddn_adress_type= findLocatorByXpath("//select[@name='address_type']");
    	selectOptionByText(ddn_adress_type, "Work ");
    	
    	WebElement txtfirstname = findLocatorByXpath("(//input[@name='first_name'])[1]");
    	elementSendKeys(txtfirstname, getcellData("grocery", 1, 3));
    	
    	WebElement txtlastname = findLocatorByXpath("(//input[@name='last_name'])[1]");
    	elementSendKeys(txtlastname, getcellData("grocery", 1, 4));
    	
    	WebElement txt_contact_no = findLocatorByXpath("//input[@name='mobile']");
    	elementSendKeys(txt_contact_no, getcellData("grocery", 1, 5));
    	
    	WebElement txt_door_no = findLocatorByXpath("//input[@name='apartment']");
    	elementSendKeys(txt_door_no, getcellData("grocery", 1, 6));
    	
    	WebElement txt_address = findLocatorByXpath("//input[@name='address']");
    	elementSendKeys(txt_address, getcellData("grocery", 1, 7));
    	
    	WebElement ddn_state = findLocatorByXpath("//Select[@name='state']");
    	selectOptionByattribute(ddn_state, "35");
    	
    	WebElement ddn_city = findLocatorByXpath("//Select[@name='city']");
    	selectOptionByattribute(ddn_city, "3659");
    	
    	WebElement txt_pin_no = findLocatorByXpath("//input[@name='zipcode']");
    	elementSendKeys(txt_pin_no, getcellData("grocery",1, 8));
    	
    	WebElement btn_save = findLocatorByXpath("(//button[@type='submit'])[3]");
    	elementclick(btn_save);
    	
    	Thread.sleep(2000);
    	WebElement ddn_payment_method = findLocatorById("payment_type");
    	selectOptionByIndex(ddn_payment_method, 1);
    	
    	WebElement btnvisa = findLocatorByXpath("//label[text()=' Visa ']");
    	elementClick(btnvisa);
    	
    	WebElement txt_cardnum = findLocatorByXpath("//input[@placeholder='Card Number']");
    	elementSendKeys(txt_cardnum, getcellData("grocery", 1, 9));
    	
    	WebElement ddn_month = findLocatorByXpath("//select[@id='month']");
    	selectOptionByIndex(ddn_month, 2);
    	
    	WebElement ddnyear = findLocatorById("year");
    	selectOptionByattribute(ddnyear, "2027");
    	
    	WebElement txt_cvv = findLocatorByXpath("//input[@name='cvv']");
    	elementSendKeys(txt_cvv,getcellData("grocery", 1, 10));
    	
    	WebElement  text_printtdet= findLocatorByXpath("//div[text()='Price Details']");
    	String text3 = elementGetText(text_printtdet);
    	System.out.println(text3);
    	
    	WebElement text_total = findLocatorByXpath("(//div[@class='d-flex justify-content-between align-items-center mb-2'])[1]");
    	String text4 = elementGetText(text_total);
    	System.out.println(text4);
    	
    	WebElement txt_grandtotal = findLocatorByXpath("//div[@class='d-flex justify-content-between align-items-center mb-2 borderTop2 borderBottom2 py-2']");
    	String text5 = elementGetText(txt_grandtotal);
    	System.out.println(text5);
    	
    	WebElement btn_placeorder = findLocatorByXpath("//button[@id='placeOrder']");
    	elementClick(btn_placeorder);
    	
    	WebElement txt_ordernum = findLocatorByXpath("//p[contains(text(),'Order No: ')]");
    	String text6 = elementGetText(txt_ordernum);
    	System.out.println(text6);
    	creatCellAndSetCellData("grocery", 1,11, text6);
	
	}

	public static void main(String[] args) throws Exception {
		Grocery_project a=new Grocery_project();
		a.Booking();

	}

}
