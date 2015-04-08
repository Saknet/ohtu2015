package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
        unsuccesfulLoginWrongPassword(driver);
        unsuccesfulLoginNoUsername(driver);
        creatingNewUser(driver);
        createUserAndLogout(driver);
    }
    
    public static void unsuccesfulLoginWrongPassword(WebDriver driver) {
        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("aep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );        
    }
    
    public static void unsuccesfulLoginNoUsername(WebDriver driver) {
        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekkasdfsdfs");
        element = driver.findElement(By.name("password"));
        element.sendKeys("aep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );         
    }
    
    public static void creatingNewUser(WebDriver driver) {
        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("jeesus");
        element = driver.findElement(By.name("password"));
        element.sendKeys("testpass1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("testpass1");
        element = driver.findElement(By.name("add"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );    
    }
    
    public static void createUserAndLogout(WebDriver driver) {
        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("peasdfsdfs");
        element = driver.findElement(By.name("password"));
        element.sendKeys("testpass1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("testpass1");
        element = driver.findElement(By.name("add"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() ); 
        
        element = driver.findElement(By.linkText("continue to application mainpage"));  
        element.click();  
        System.out.println("==");
        element = driver.findElement(By.linkText("logout"));       
        element.click(); 
        
        System.out.println("==");
        System.out.println( driver.getPageSource() ); 
    }
}
