package com.rupeek.web.locator;

import com.rupeek.web.LocatorType;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.MalformedURLException;

public class Locator {
    private String locatorValue;
    private LocatorType locatorType;

    public Locator(LocatorType locatorType, String locatorValue){
        this.locatorValue = locatorValue;
        this.locatorType = locatorType;
    }

    public String getLocatorValue() {
        return locatorValue;
    }

    public LocatorType getLocatorType() {
        return locatorType;
    }

    public void setLocatorType(LocatorType locatorType) {
        this.locatorType = locatorType;
    }

    public static Locator getLocatorFromXML(String pageName, LocatorType locatorType ,String locatorValue) throws MalformedURLException, DocumentException {
        File directory = new File("");
        String s = directory.getAbsolutePath() + "/src/main/java/com/rupeek/web/locator/locators.xml";
        File file = new File(s);
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        String locator = document.selectSingleNode("//pages/"+pageName+"/"+locatorValue).getText();
        Locator loc = new Locator(locatorType,locator);
        return loc;
    }

}
