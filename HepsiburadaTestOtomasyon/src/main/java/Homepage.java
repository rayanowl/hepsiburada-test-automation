import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Homepage {

    private WebDriver driver;
    private static Logger log = Logger.getLogger(Homepage.class);

    public Homepage(WebDriver driver){
        this.driver = driver;
    }
    public void clickLogin(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);
        WebElement loginSpace = driver.findElement(By.xpath(loginXpath));
        loginSpace.click();
        WebElement loginSpace2 = driver.findElement(By.xpath(loginAreaXpath));
        loginSpace2.click();
        Log.info("Giriş Yapıldı.");
    }
    public void setEmail(String emailAsString){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);
        WebElement emailSpace = driver.findElement(By.xpath(emailXpath));
        emailSpace.click();
        emailSpace.sendKeys(emailAsString);
        Log.info("E-mail alanı dolduruldu.");
    }
    public void setPassword(String passwordAsString){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);
        WebElement passwordSpace = driver.findElement(By.xpath(passwordXpath));
        passwordSpace.click();
        passwordSpace.sendKeys(passwordAsString);
        Log.info("Parola alanı dolduruldu.");
    }
    public void clickLoginButton(){
        WebElement loginButtonSpace = driver.findElement(By.id(loginButtonXpath));
        loginButtonSpace.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.info("Giriş yap butonuna tıklandı.");
    }
    public String getEmail(){
        WebElement emailSpace = driver.findElement(By.xpath(emailXpath));
        return emailSpace.getAttribute("value");
    }
    public String getPassword(){
        WebElement passwordSpace = driver.findElement(By.xpath(passwordXpath));
        return passwordSpace.getAttribute("value");
    }
    public void clickElectronicMenuArea(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);
        WebElement electronicMenuSpace = driver.findElement(By.xpath(electronicMenuButtonXpath));
        electronicMenuSpace.click();
        Log.info("Elektronik menüsüne tıklandı.");
    }
    public void computerCategoryArea(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);
        WebElement computerCategorySpace = driver.findElement(By.xpath(computerCategoryXpath));
        computerCategorySpace.click();
        Log.info("Bilgisayar alt menüsüne tıklandı.");
    }
    public void selectComputerBrand(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,550)");
        WebElement computerBrand = driver.findElement(By.xpath(selectMSIXpath));
        computerBrand.click();
        Log.info("Bilgisayar modeli MSI seçildi.");
    }
    public void secondPage(){
        driver.get(secondPageXpath);
        Log.info("İkinci sayfa açıldı.");
    }
    public void selectSecondPrice(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,550)");
        WebElement secondPriceSpace = driver.findElement(By.xpath(secondPageSecondPriceXpath));
        secondPriceSpace.click();
        Log.info("İkinci sayfadaki ikinci ürüne tıklandı.");
    }
    public void favoriteButton(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,550)");
        WebElement favoriteSpace = driver.findElement(By.xpath(favoriteButtonXpath));
        favoriteSpace.click();
        Log.info("İkinci ürün favorilere eklendi.");
    }
    public void favoriteList(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,0)");
        driver.navigate().refresh();
        driver.navigate().refresh();
        WebElement hesabim = driver.findElement(By.xpath(myAccountXpath));
        hesabim.click();
        WebElement clickFavoriteList = driver.findElement(By.xpath(favoriteListXpath));
        clickFavoriteList.click();
        Log.info("Favori liste sayfası açıldı.");
    }
    public void selectAllButton(){
        WebElement clickSelectAllButton = driver.findElement(By.id(selectAllId));
        clickSelectAllButton.click();
        Log.info("Favori listesine eklenen ürün seçildi.");
    }
    /* Bu pencere bazen çıkmaktadır.Bu durumda yorum satırı kaldırılmalı.
    public void closePopUp(){
        WebElement clickSelectAllButton = driver.findElement(By.xpath(closePopUp));
        clickSelectAllButton.click();
    }*/
    public void deletePriceButton(){
        WebElement deletePrice = driver.findElement(By.xpath(deletePriceButtonXpath));
        deletePrice.click();
        Log.info("Eklenen ürün favorilerden silindi.");
    }
    public void deletePrice(){
        WebElement deletePriceSpace = driver.findElement(By.id(deletePriceId));
        deletePriceSpace.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.info("Eklenen ürünü favori listesinden silme işlemi onaylandı.");
    }
    public void clickProfile(){
        driver.navigate().refresh();
        WebElement clickProfileSpace = driver.findElement(By.xpath(profileXpath));
        clickProfileSpace.click();
        Log.info("Profilim penceresi açıldı.");
    }
    public void logOutButton(){
        WebElement clickLogOut = driver.findElement(By.xpath(logOutXpath));
        clickLogOut.click();
        Log.info("Üye çıkış işlemi yapıldı.");
    }
    public WebElement findElement(By by){
        return driver.findElement(by);
    }
    public String getText(By by){
        return findElement(by).getText();
    }
    public String computerPageControl(){
        return getText(By.xpath(computerControlXpath));
    }
    public String computerBrandControl(){
        return getText(By.xpath(computerBrandControlXpath));
    }
    public String favoriteListPriceNumberControl(){
        return getText(By.xpath(favoriteListPriceNumberXpath));
    }
    public String deletePriceControl(){
        return getText(By.xpath(favoriteListPriceNumberXpath));
    }
    public String logOutControl(){
        return getText(By.xpath(loginXpath));
    }

}
