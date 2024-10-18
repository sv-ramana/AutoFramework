package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class utilities {
    public static void Button_click(WebDriver driver_init, By element) {
        driver_init.findElement(element).click();
    }

    public static void Sendvalues(WebDriver driver_init, By element, String Values) {
        driver_init.findElement(element).sendKeys(Values);
    }

    public static void pressenter(WebDriver driver_init, By element){
        driver_init.findElement(element).sendKeys(Keys.ENTER);
    }
}
