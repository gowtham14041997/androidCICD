package com.rupeek.web.pages;

import base.BaseTest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rupeek.web.LocatorType;
import com.rupeek.web.db.CoreDB;
import com.rupeek.web.locator.Locator;
import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

import org.bson.Document;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static base.BaseTest.getEnvironmentProperty;

public class LoanAdminDashboard extends BasePage{
    Waits wait;
    Swipes swipe = new Swipes(webDriver);

    public LoanAdminDashboard(WebDriver webDriver) {
        super(webDriver);
        this.wait = new Waits(webDriver);
    }
    public  boolean kycApproved(String agentName, String salutation, String gender, String marriageStatus, String pan) throws InterruptedException, MalformedURLException, DocumentException {
        String url = getEnvironmentProperty("LA_Dashboard");
        webDriver.get(url);
        String user = getEnvironmentProperty("LA_User");
        String password = getEnvironmentProperty("LA_password");
        Actions act = new Actions(webDriver);
        Thread.sleep(900);
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"AdminUserName")).sendKeys(user);
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"AdminPassword")).sendKeys(password);
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"Submit")).click();
        Thread.sleep(4000);
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"KYCTab")).click();
        Thread.sleep(5000);
        List<WebElement> agentNames = findWebElements(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"AgentNames"));
        try {
            for (WebElement agent : agentNames) {
                String name = agent.getText();
                if (name.equals(agentName)) {
                    webDriver.findElement(By.xpath("//p[normalize-space()='" + name + "']/following::div/div/button/span")).click();
                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println("Kyc Notification is not available");
        }
        Thread.sleep(6000);
        JavascriptExecutor js= (JavascriptExecutor) webDriver;
        WebElement name = findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"EnterCustomerName"));
        js.executeScript("arguments[0].scrollIntoView(true);",name);
        name.sendKeys("LM Automation");
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"ReEnterName")).sendKeys("LM Automation");
        WebElement reEnterDob =findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"ReEnterDob"));
        WebElement salutationMs=webDriver.findElement(By.xpath("//input[@type='radio' and @class='salutation mr-2 editableinput' and @value='"+salutation+"']"));
        js.executeScript("arguments[0].scrollIntoView(true);",salutationMs);
        webDriver.findElement(By.xpath("//input[@type='radio' and @class='salutation mr-2 editableinput' and @value='"+salutation+"']")).click();
        webDriver.findElement(By.xpath("//input[@type='radio' and @class='gendervalidation mr-2 editableinput' and @value='"+gender+"']")).click();
        webDriver.findElement(By.xpath("//input[@type='radio' and @class='gendervalidation mr-2 editableinput' and @value='"+marriageStatus+"']")).click();
        String dob = findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"Dob")).getText();

        reEnterDob.sendKeys("19/10/2023");

        WebElement house =findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"houseno"));
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);",house);
        Thread.sleep(2000);
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"houseno")).sendKeys("XYZ");
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"street")).sendKeys("XYZ");
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"locality")).sendKeys("XYZ");

        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"City")).sendKeys("Bangalore");

        WebElement locality = findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"locality"));
        WebElement state= findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"state"));
        Thread.sleep(1000);
        Select selectState = new Select(state);
        selectState.selectByVisibleText("Karnataka");
        Thread.sleep(2000);
        WebElement pincode= findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"pincode"));
        Thread.sleep(1000);
        pincode.sendKeys("560001");
        js.executeScript("arguments[0].scrollIntoView(true);",pincode);
        WebElement religion =findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"HinduReligion"));
        Thread.sleep(2000);
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"HinduReligion")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//input[@type='radio' and @class='gendervalidation editableinput mr-2' and @value='nonmatriculate']")).click();
        Thread.sleep(2000);
        WebElement income =findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"income"));
        income.sendKeys("55000");
        Thread.sleep(2000);
        WebElement bankName = webDriver.findElement(By.xpath("//input[@id='bankname']"));
        js.executeScript("arguments[0].scrollIntoView(true);",bankName);
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//input[@placeholder='Re-Enter Pan Card No.']")).sendKeys(pan);
        webDriver.findElement(By.xpath("//button[@class='btn btn-primary btn-blue px-1 text-uppercase fnt-12']")).click();
        Thread.sleep(3000);

        Set<String> windows = webDriver.getWindowHandles();
        String parentWindow = webDriver.getWindowHandle();
        for(String window:windows){
            if(!window.equals(parentWindow)){
                webDriver.switchTo().window(window).close();

            }
        }
        Thread.sleep(2000);
        webDriver.switchTo().window(parentWindow);
        Thread.sleep(100000);
        WebDriverWait wait = new WebDriverWait(webDriver,300);
        js.executeScript("arguments[0].scrollIntoView(true);",pincode);
        Thread.sleep(2000);
        selectState.selectByVisibleText("Karnataka");
        pincode.clear();
        pincode.sendKeys("560001");
        selectState.selectByVisibleText("Karnataka");

        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"Approve")).click();
        Thread.sleep(20000);
        return true;
    }
    public boolean JewelleryAppraisal(String agentName) throws MalformedURLException, DocumentException, InterruptedException {
        String url = getEnvironmentProperty("LA_Dashboard");
        webDriver.get(url);
        Thread.sleep(5000);
        String user = getEnvironmentProperty("LA_User");
        String password = getEnvironmentProperty("LA_password");
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"AdminUserName")).sendKeys(user);
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"AdminPassword")).sendKeys(password);
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"Submit")).click();
        wait.hardWait(15000);
        webDriver.navigate().refresh();
        wait.hardWait(9000);
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"AppraisalTab")).click();
        List<WebElement> agentNames= new ArrayList<>();
        WebElement singleAgent;
        String singleAgentName="";
        Thread.sleep(5000);
        agentNames= findWebElements(Locator.getLocatorFromXML("LoanAdmin", LocatorType.XPATH, "AgentNames"));
        singleAgentName=agentNames.get(0).getText();

        try {
            if(agentNames.size()>1) {
                for (WebElement agent : agentNames) {
                    String name = agent.getText();
                    if (name.equals(agentName)) {
                        String xpath = "//p[normalize-space()='" + name + "']/following::div/div/button/span";
                        System.out.println("xpath" + xpath);
                        webDriver.findElement(By.xpath("//p[normalize-space()='" + name + "']/following::div/div/button/span")).click();
                        break;
                    }
                }
            }
            else{
                webDriver.findElement(By.xpath("//p[normalize-space()='" + singleAgentName + "']/following::div/div/button/span")).click();
            }
        }
        catch (Exception e){
            System.out.println("Appraisal Notification is not available");
        }
        webDriver.navigate().refresh();
        wait.hardWait(6000);
        wait.implicitlyWait(60,webDriver);

        WebElement approve =findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"Approve"));
        approve.click();
        Thread.sleep(6000);
        WebElement selectAll = findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"ApproveAllUnSelect"));
        JavascriptExecutor js= (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);",selectAll);
        selectAll.click();
        wait.hardWait(5000);
        WebElement nbfc = findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"NBFC"));
        js.executeScript("arguments[0].scrollIntoView(true);",nbfc);
        nbfc.click();
        WebElement submit =  findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"Submit"));
        js.executeScript("arguments[0].scrollIntoView(true);",submit);
        submit.click();
        return true;
    }


    public boolean moneyTransferApprove(String agentName, String phone) throws MalformedURLException, DocumentException, InterruptedException {
        Document loanRequest = CoreDB.getInstance().getLoanRequest(phone);
        JsonObject loanInJson= new Gson().fromJson(loanRequest.toJson(), JsonObject.class);
        Integer loanAmount = loanInJson.get("disbursalamount").getAsInt();
        String url = getEnvironmentProperty("LA_Dashboard");
        webDriver.get(url);
        Thread.sleep(5000);
        String user = getEnvironmentProperty("LA_User");
        String password = getEnvironmentProperty("LA_password");
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"AdminUserName")).sendKeys(user);
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"AdminPassword")).sendKeys(password);
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"Submit")).click();
        Thread.sleep(9000);
        webDriver.navigate().refresh();
        wait.hardWait(9000);
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"PaymentTab")).click();
        List<WebElement> agentNames= new ArrayList<>();
        WebElement singleAgent;
        String singleAgentName="";
        Thread.sleep(13000);

        agentNames= findWebElements(Locator.getLocatorFromXML("LoanAdmin", LocatorType.XPATH, "AgentNames"));
        singleAgentName=agentNames.get(0).getText();
        try {
            if(agentNames.size()>1) {
                for (WebElement agent : agentNames) {
                    String name = agent.getText();
                    if (name.equals(agentName)) {
                        webDriver.findElement(By.xpath("//p[normalize-space()='" + name + "']/following::div/div/button/span")).click();
                        break;
                    }
                }
            }
            else{
                webDriver.findElement(By.xpath("//p[normalize-space()='" + singleAgentName + "']/following::div/div/button/span")).click();
            }
        }
        catch (Exception e){
            System.out.println("Appraisal Notification is not available");
        }
        Thread.sleep(10000);
        //wait.implicitlyWait(60,webDriver);
        String summaryTab = findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"SummaryTab")).getText();
        Assert.assertEquals("SUMMARY",summaryTab);
        Thread.sleep(2000);

        swipe.swipeDownByPageHeightUI("full");
        try {
            WebElement utr = findWebElement(Locator.getLocatorFromXML("LoanAdmin", LocatorType.XPATH, "UTR"));
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].scrollIntoView(true);", utr);
            WebElement mode = findWebElement(Locator.getLocatorFromXML("LoanAdmin", LocatorType.XPATH, "Mode"));
            Select select = new Select(mode);
            select.selectByVisibleText("Wire");
            utr.sendKeys(String.valueOf(loanAmount));
            findWebElement(Locator.getLocatorFromXML("LoanAdmin", LocatorType.XPATH, "Amount")).sendKeys(String.valueOf(loanAmount));
            findWebElement(Locator.getLocatorFromXML("LoanAdmin", LocatorType.XPATH, "Comment")).sendKeys("Comment");
        }
        catch (Exception e){
            System.out.println("UTR field is not editable");
        }

        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.ID,"Approve")).click();
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"FundTransfer")).click();

        return true;
    }


    public  boolean takeOverPayment(String agentName) throws InterruptedException, MalformedURLException, DocumentException {
        String url = getEnvironmentProperty("LA_Dashboard");
        webDriver.get(url);
        Thread.sleep(5000);
        String user = getEnvironmentProperty("LA_User");
        String password = getEnvironmentProperty("LA_password");
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"AdminUserName")).sendKeys(user);
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"AdminPassword")).sendKeys(password);
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"Submit")).click();
        Thread.sleep(10000);
        webDriver.navigate().refresh();
        wait.hardWait(9000);
        List<WebElement> agentNames = findWebElements(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"AgentNames"));
        try {
            for (WebElement agent : agentNames) {
                String name = agent.getText();
                if (name.equals(agentName)) {
                    webDriver.findElement(By.xpath("//p[normalize-space()='" + name + "']/following::div/div/button/span")).click();
                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println("Kyc Notification is not available");
        }
        wait.hardWait(9000);
        wait.implicitlyWait(60,webDriver);
        findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"TakeoverDoc")).click();
        Thread.sleep(2000);
        List<WebElement>docs=findWebElements(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"TODocuments"));
        String agreement = docs.get(0).getText();
        String toDocs = docs.get(1).getText();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement approve =findWebElement(Locator.getLocatorFromXML("LoanAdmin",LocatorType.XPATH,"Submit"));
        js.executeScript("arguments[0].scrollIntoView(true);",approve);
        Thread.sleep(2000);
        approve.click();

        return true;
    }



}
