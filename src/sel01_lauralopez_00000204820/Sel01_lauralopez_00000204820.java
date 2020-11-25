/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sel01_lauralopez_00000204820;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author laura
 */
public class Sel01_lauralopez_00000204820 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\laura\\Google Drive\\ITSON\\Semestre 5\\Pruebas de Software\\Pruebas Automatizadas\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://ritwickdey.github.io/sample-login-signup-form/#/signup");
        
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        
        System.out.println("Prueba la validación de la longitud del nombre");
        
        //Envía datos en el registro
        driver.findElement(By.id("name")).sendKeys("Laura");  
        driver.findElement(By.id("phone")).sendKeys("6871579434");
        driver.findElement(By.id("email")).sendKeys("laurafregoso3@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345");
        
        WebElement nombre = driver.findElement(By.id("name"));
        
        //Validar la longitud minima
        System.out.println(nombre.findElement(By.tagName("input")).getText());
        
        
//        System.out.println("Prueba de validación del correo electrónico");
//        
//        //Envía datos en el registro
//        driver.findElement(By.id("name")).sendKeys("Laura");  
//        driver.findElement(By.id("phone")).sendKeys("6871579434");
//        driver.findElement(By.id("email")).sendKeys("laurafregoso3@gmail.com");
//        driver.findElement(By.id("password")).sendKeys("12345");
//        
//        // Patrón para validar el email
//        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
//        
//        Matcher mather = pattern.matcher(driver.findElement(By.id("email")));
//        
//        if(mather.find()){
//            System.out.println("es valido");
//        }
        
//        assertTrue(mather.find());
        
        
        
        
    }
    
}
