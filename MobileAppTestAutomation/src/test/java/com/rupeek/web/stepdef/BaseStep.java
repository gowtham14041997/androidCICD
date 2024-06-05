package com.rupeek.web.stepdef;

import base.BaseTest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;



public class BaseStep extends BaseTest {

    public static AppiumDriver<MobileElement> driver;
    static AppiumDriverLocalService service;
    public static WebDriver webDriver;

    public static void driverIsConfigured() throws Throwable {

        service = AppiumDriverLocalService
                .buildService(new AppiumServiceBuilder().withArgument(() -> "-pa", "/wd/hub"));
        service.start();
        service.start();
        if (!service.isRunning()){
            runCommandLine("pkill -9 -f appium");
            service.start();
       }
        //Waiting for the appium to start session
        Thread.sleep(10000);

        if(driver == null){
            String platform = getEnvironmentProperty("platform");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            switch (platform) {

                case "ANDROID_NATIVE":
                   // runCommandLine("adb kill-server");
                    //runCommandLine("emulator -apd Samsung SM-G935F API 26");
                    // Running emulator on physical device
                    //runCommandLine("emulator -avd Pixel_7_API_31");
                    //waiting for the emulator to turn on
                    Thread.sleep(7000);
                    capabilities.setCapability("newCommandTimeout",45000);
                   //capabilities.setCapability("apd","OnePlus CPH2381");
                    capabilities.setCapability("avd","nexus");
                    capabilities.setCapability("deviceName", "emulator-5554");
                    //capabilities.setCapability("ignoreHiddenApiPolicyError", true);
                    capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");

                    if (BaseStep.commonProperties.getProperty("appName").equals("AppraiserApp")){
                        capabilities.setCapability("appPackage", "com.rupeek.rupeek_agent_android.debug");
                        capabilities.setCapability("appActivity", "com.rupeek.rupeek_agent_android.activity.login_process.LaunchActivity");

                    } else if (BaseStep.commonProperties.getProperty("appName").equals("CustomerApp")) {
                        capabilities.setCapability("appPackage", "com.rupeek.customer.debug");
                        capabilities.setCapability("appActivity", "com.rupeek.app_main_apk.main.SplashActivity");
                    }
                    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                    //Waiting for rupeek application to come up
                    Thread.sleep(3000);
                    break;

                case "IOS_WEB":
                    runCommandLine("open -a Simulator.app");
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.5");
                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12");
                    capabilities.setCapability("wdaStartupRetries", 2);
                    capabilities.setCapability("iosInstallPause",2000 );
                    capabilities.setCapability("wdaStartupRetryInterval", 1000);
                    driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                    break;
                case "ANDROID_WEB":
                default:
//                    Process process = Runtime.getRuntime().exec("adb devices");
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//                    String line = "";
//                    while ((line = reader.readLine()) != null) {
//                        System.out.println(line);
//                    }
                    runCommandLine("emulator -avd Pixel_6_API_31");
                    //waiting for the emulator to turn on
                    Thread.sleep(7000);
                    capabilities.setCapability("avd","Pixel_6_API_31");
                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
                    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
                    capabilities.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
                    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                    break;
            }
        }
    }

    public static void webDriverConfigured() {
                    DriverManagerType chrome = DriverManagerType.CHROME;
                    WebDriverManager.getInstance(chrome).setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless"); 
                    options.addArguments("start-maximized");
                    options.addArguments("--window-size=1400,600");
                    options.addArguments("--whitelisted-ips=''");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-extensions");
                    options.addArguments("--remote-allow-origins=*");
                    webDriver = new ChromeDriver(options);
                    webDriver.manage().window().maximize();

    }



    public static void runCommandLine(String cmd) {
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void closeDriverAndAppiumSession() {

        if (getEnvironmentProperty("platform").equals("IOS_WEB")){
            driver.closeApp();
            runCommandLine("killall Simulator");

        } else if(getEnvironmentProperty("platform").equals("ANDROID_NATIVE")){
            runCommandLine("adb -s emulator-5554 emu kill");
        }
        else {

            driver.close();
            runCommandLine("adb -s emulator-5554 emu kill");
        }
        runCommandLine("killall node");
    }

//    public static void closeWebDriver() {
//
//        webDriver.quit();
//    }
    public void resetApp(){
        driver.resetApp();
    }
}
