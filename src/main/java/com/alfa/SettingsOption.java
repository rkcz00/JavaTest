package com.alfa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

import static java.util.Collections.singletonMap;


public class SettingsOption {


//    public static HashMap<String, Boolean> getExcludedSchemes() {
//        HashMap<String, Boolean> allowedProtocolKeys = new HashMap<>();
//        allowedProtocolKeys.put("alfadirect-sign-insecure", false);
//        allowedProtocolKeys.put("alfadirect-sign", false);
//        allowedProtocolKeys.put("adir-test-insecure", false);
//        allowedProtocolKeys.put("adir-test", false);
//        return allowedProtocolKeys;
//    }
//
//    public static HashMap<String, Boolean> getAllowedProtocolKeys() {
//        HashMap<String, Boolean> allowedProtocolKeys = new HashMap<>();
//        allowedProtocolKeys.put("alfadirect-sign-insecure", true);
//        allowedProtocolKeys.put("alfadirect-sign", true);
//        allowedProtocolKeys.put("adir-test-insecure", true);
//        allowedProtocolKeys.put("adir-test", true);
//        return allowedProtocolKeys;
//    }
//
//    public static HashMap<String, Object> getAllowedOriginProtocols() {
//        HashMap<String, Object> allowedProtocols = new HashMap<>();
//        allowedProtocols.put("http://localhost:56491", getAllowedProtocolKeys());
//        allowedProtocols.put("https://ip12.alfadirect.ru", getAllowedProtocolKeys());
//        allowedProtocols.put("https://ip16.alfadirect.ru", getAllowedProtocolKeys());
//        allowedProtocols.put("https://lkpreprod.alfadirect.ru", getAllowedProtocolKeys());
//        return allowedProtocols;
//    }


    public static ChromeDriver getChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();

        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put(
                "protocol_handler.allowed_origin_protocol_pairs",
                singletonMap("https://ip12.alfadirect.ru", singletonMap("adir-test", true))
        );
        chromeOptions.setExperimentalOption("prefs", singletonMap("protocol_handler.allowed_origin_protocol_pairs", singletonMap("https://ip12.alfadirect.ru", singletonMap("adir-test", true))));

        chromeOptions.addArguments("window-size=1280,720");
//        chromeOptions.addArguments("--headless");
//
//
//        chromeOptions.addArguments("--safebrowsing-disable-download-protection");
//        chromeOptions.addArguments("--safebrowsing-disable-extension-blacklist");
//        chromeOptions.addArguments("--disable-extensions");
//        chromeOptions.addArguments("--disable-dev-shm-usage");
//        chromeOptions.addArguments("--no-sandbox");


//        chromeOptions.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.113 Safari/537.36");
//        chromeOptions.addArguments("user-agent=Windows");
//        chromeOptions.addArguments("--ignore-certificate-errors");
//        chromeOptions.addArguments("--use-fake-ui-for-media-stream");
//        chromeOptions.addArguments("--disable-user-media-security");
//        chromeOptions.addArguments("--disable-web-security");
//        chromeOptions.addArguments("--reduce-security-for-testing");
//        chromeOptions.addArguments("--use-fake-device-for-media-stream");
//        chromeOptions.addArguments("--allow-file-access-from-files");
//
//        chromeOptions.addArguments("--start-maximized");
//        chromeOptions.addArguments("--no-sandbox");
//        chromeOptions.addArguments("--disable-gpu");
//        chromeOptions.addArguments("--incognito");
//        chromeOptions.addArguments("--disable-popup-blocking");
//        chromeOptions.addArguments("--safebrowsing-disable-download-protection");
//        chromeOptions.addArguments("safebrowsing-disable-extension-blacklist");
//        chromeOptions.addArguments("--kiosk-printing");
//        chromeOptions.addArguments("--disable-extensions");
//
//        chromeOptions.addArguments("--disable-infobars");
//        chromeOptions.addArguments("--enable-infobars");
//        chromeOptions.addArguments("--kiosk-printing");
//        chromeOptions.addArguments("--disable-notifications");
//        chromeOptions.addArguments("--disable-infobars");
        return new ChromeDriver(chromeOptions);
    }


}
