package base_class;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sir_copy {
	WebDriver driver;

	public void switchToFrameByIdName(String idName) {
		driver.switchTo().frame(idName);
	}

	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameByWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToChildWindow() {
		String pWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String eachWindow : allWindows) {
			if (!pWindow.equals(eachWindow)) {
				driver.switchTo().window(eachWindow);
			}

		}
	}

	public List<String> getAllOptionsTextDD(WebElement element) {
		List<String> allOptionsText = new ArrayList<String>();
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			allOptionsText.add(text);

		}
		return allOptionsText;
	}

	public String getProjectPath() {
		String property = System.getProperty("user.dir");
		return property;
	}

	public void screenshot(String name) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(getProjectPath() + "\\screenshot\\" + name + ".png"));
	}

	public void visiblityOf(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOf(element));

	}
	public void visiblityOf(List<WebElement>  element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOf((WebElement) element));

	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
	public void elementclick(WebElement element) { 
		 element.click();
		 }

	public void implicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));

	}

	public void elementSendKeysJS(WebElement element, String data) {
		visiblityOf(element);

		if (isEnabled(element) && isDisplayed(element)) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
		}
	}

	public void selectOptionByText(WebElement element, String text) {
		visiblityOf(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectOptionByIndex(WebElement element, int index) {
		visiblityOf(element);
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectOptionByattribute(WebElement element,String value) {
		visiblityOf(element);
		Select select=new Select(element);
		select.selectByValue(value);
	}

	public void browserLaunch(String browserType) {
		switch (browserType) {
		case "CHROME":																																																													
			driver = new ChromeDriver();
			break;
		case "IE":
			driver = new InternetExplorerDriver();
			break;
		case "EDGE":
			driver = new FirefoxDriver();
			break;
		case "FIREFOX":
			driver = new ChromeDriver();
			break;

		default:
			break;
		}

	}

	public void enterApplnUrl(String url) {
		driver.get(url);

	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void elementSendKeys(WebElement element, String data) {
		visiblityOf(element);

		if (isEnabled(element) && isDisplayed(element)) {
			element.sendKeys(data);
		}
	}

	public void elementClick(WebElement element) {
		visiblityOf(element);
		if (isEnabled(element) && isDisplayed(element)) {

			element.click();
		}
	}

	public String getApplnTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}

	public WebElement findLocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}

	public WebElement findLocatorByXpath(String xpathExp) {
		WebElement element = driver.findElement(By.xpath(xpathExp));
		return element;
	}

	public boolean isDisplayed(WebElement element) {
		visiblityOf(element);
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public boolean isEnabled(WebElement element) {
		visiblityOf(element);
		boolean displayed = element.isEnabled();
		return displayed;
	}

	public String elementGetText(WebElement element) {
		visiblityOf(element);
		String text = null;
		if (isDisplayed(element)) {
			text = element.getText();
			
		}
		return text;
	}

	public String elementGetAttribute(WebElement element) {
		visiblityOf(element);
		String attribute = null;
		if (isDisplayed(element)) {
			attribute = element.getAttribute("value");
			
		}
		return attribute;
	}
	//(OR)

	public String elementGetAttribute(WebElement element, String attributeName) {
		visiblityOf(element);
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}
	public String getcellData(String sheetname,int rownum,int cellnum) throws IOException {
		String res="";
		File file=new File("D:\\maven\\maven work spsce\\base_class\\exc\\Book1.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook book=new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			res=cell.getStringCellValue();
			break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateformat=new SimpleDateFormat("dd-mm-yy");
				res= dateformat.format(dateCellValue);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if(numericCellValue==round) {
					res=String.valueOf(round);
				}else {
					res=String.valueOf(numericCellValue);
				}
			}break;

		default:
			break;
		}
		return res;
		
		}
	public void threadsleep(int i) throws InterruptedException {
		Thread.sleep(i);
	}
	
	public void creatCellAndSetCellData(String sheetname,int rownum,int cellnum,String data) throws IOException {
		File file=new File("D:\\maven\\maven work spsce\\base_class\\exc\\Book1.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook book=new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell createCell = row.createCell(cellnum);
		createCell.setCellValue(data);
		FileOutputStream output=new FileOutputStream(file);
		book.write(output);
	}
	
	public List<WebElement> List_findLocatorByXpath1(String xpath) {
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		return elements;
	}
	

	 

}



