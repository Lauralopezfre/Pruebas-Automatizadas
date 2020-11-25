/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sel01_lauralopez_00000204820;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author laura
 */
public class PruebasSignupTest {
    
    private static WebDriver driver;
    
    @BeforeClass
    public static void setUpClass() {
        
        //Cambiar la ubicación del driver con la ubicación en su computadora
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laura\\Google Drive\\ITSON\\Semestre 5\\Pruebas de Software\\Pruebas Automatizadas\\chromedriver.exe");
        //Se crea la instancia para poder utilizar el buscador Chrome
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        //Maxi miza el tamaño de la ventana
        driver.manage().window().maximize();
        //Regla otorgada para esperar 20 segundos (máximo) en lo que carga la página
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    
    
    @AfterClass
    public static void tearDownClass() {
        //Cierra la ventana del buscador
        driver.quit();        
    }
    
    @Before
    public void setUp() {
        driver.get("https://ritwickdey.github.io/sample-login-signup-form/#/signup");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void pruebaPagina(){
        System.out.println("Prueba el título de la página web");        
        
        String titulo = driver.getTitle();
        
        System.out.println("El título es : " + titulo);
        assertEquals("Basic login & Signup with Angular", titulo);
    }
    
    @Test
    public void registroCorrecto(){
        System.out.println("Prueba de un registro correcto");
        
        //Envía datos válidos a todos los campos
        driver.findElement(By.id("name")).sendKeys("Mario Parra");  
        driver.findElement(By.id("phone")).sendKeys("1234567890");
        driver.findElement(By.id("email")).sendKeys("ejemplo@correo.com");
        driver.findElement(By.id("password")).sendKeys("password");
        
        //Click en el botón signup
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
        
        //Verifica que se abre la nueva url
        String ligaLogin = driver.getCurrentUrl();  
        assertEquals("https://ritwickdey.github.io/sample-login-signup-form/#/login", ligaLogin);
        
        
    }
    
    @Test
    public void verificarVacios(){
        System.out.println("Verifica que ningún campo pueda quedar vacío");

        //Envía datos vacíos
        driver.findElement(By.id("name")).sendKeys("");  
        driver.findElement(By.id("phone")).sendKeys("");
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        
        //Regresa al primer elemento para que muestre el último mensaje de error
        driver.findElement(By.id("name")).sendKeys("");
        
        //Obtiene los elementos con los mensajes de Error
        List<WebElement> listaErrores = driver.findElements(By.className("form-error"));
        
        //Lista para agregar los mensajes de errores
        List<String> msjErrores = new ArrayList<>();
        
        //Obtiene cada uno de los errores y los agrega a la lista
        for (WebElement elementoError : listaErrores) {
            String msj = elementoError.findElement(By.tagName("div")).getText();
            msjErrores.add(msj);
        }
        
        //Verifica todos los mensajes de error
        assertEquals("Name is required", msjErrores.get(0));
        assertEquals("Phone is required", msjErrores.get(1));
        assertEquals("Email is required", msjErrores.get(2));
        assertEquals("Password is required", msjErrores.get(3));    
    }
    
    @Test
    public void pruebaNombre(){
        System.out.println("Prueba la validación de la longitud del nombre");
        
        //Envía datos en el registro
        driver.findElement(By.id("name")).sendKeys("Laura");  
        driver.findElement(By.id("phone")).sendKeys("6871579434");
        driver.findElement(By.id("email")).sendKeys("laurafregoso3@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345");
        
        WebElement nombre = driver.findElement(By.id("name"));
        
        //Validar la longitud minima
        System.out.println(nombre.getTagName().length()>= 3);
    }
    
    @Test
    public void pruebaPhoneNumber(){
        System.out.println("Prueba la validación del número telefónico");
        
        //Envía datos en el registro
        driver.findElement(By.id("name")).sendKeys("Laura");  
        driver.findElement(By.id("phone")).sendKeys("6871579434");
        driver.findElement(By.id("email")).sendKeys("laurafregoso3@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345");
        
        
        //IMPLEMENTAR AQUÍ
    }
       
    @Test
    public void pruebaValidacionCorreo(){
        System.out.println("Prueba de validación del correo electrónico");
        
        //Envía datos en el registro
        driver.findElement(By.id("name")).sendKeys("Laura");  
        driver.findElement(By.id("phone")).sendKeys("6871579434");
        driver.findElement(By.id("email")).sendKeys("laurafregoso3@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345");
        
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        
        Matcher mather = pattern.matcher(driver.findElement(By.id("email")).getTagName());
        
        assertTrue(mather.find());
    }
       
    @Test
    public void verificaPassword(){
        System.out.println("Prueba la validación de la contraseña");
        
        //Envía datos en el registro
        driver.findElement(By.id("name")).sendKeys("Laura");  
        driver.findElement(By.id("phone")).sendKeys("6871579434");
        driver.findElement(By.id("email")).sendKeys("laurafregoso3@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345");
        
        WebElement nombre = driver.findElement(By.id("password"));
        
        //Validar la longitud minima
        System.out.println(nombre.getTagName().length()>= 4);
    }
    
    @Test
    public void pruebaLinkAccount(){
        System.out.println("Prueba el funcionamiento del link");
        driver.findElement(By.tagName("div")).click();
        
        System.out.println("Prueba que se abra la página correctamente");
        
        driver.get("https://ritwickdey.github.io/sample-login-signup-form/#/login");
        String titulo = driver.getTitle();
        
        if("Basic login & Signup with Angular".equalsIgnoreCase(titulo)){
            System.out.println("correcto");
        }
    }
}
