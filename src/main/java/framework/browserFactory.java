/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

import static helperUtils.ConfigPropertyReader.getProperty;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class browserFactory {
	private static String browser;
	// \Selenium_Tests\seleniumConfigs
	private static final DesiredCapabilities capabilities = new DesiredCapabilities();

	private static String RunningEnvironment = System.getProperty("RunEnv");

	String environment = System.getProperty("env", getProperty(
			System.getProperty("user.dir") + File.separator + "Config." + RunningEnvironment + ".properties", "env"));

	String seleniumServer = System.getProperty("seleniumServer",
			getProperty(
					System.getProperty("user.dir") + File.separator + "Config." + RunningEnvironment + ".properties",
					"seleniumServer"));
	private static String chromeDriverPath;
	private static String geckoDriverPath;
	private static String edgeDriverPath;
	private static String ieDriverPath;
	private static String phantomDriverPath;

	public browserFactory() {
		if (environment.equalsIgnoreCase("local")) {

			if (System.getProperty("os.name").toLowerCase().contains("windows")) {
				phantomDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
						+ File.separator + "resources" + File.separator + "Drivers" + File.separator + "Windows"
						+ File.separator + "phantomjs.exe";
				chromeDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
						+ File.separator + "resources" + File.separator + "Drivers" + File.separator + "Windows"
						+ File.separator + "chromedriver.exe";
				geckoDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
						+ File.separator + "resources" + File.separator + "Drivers" + File.separator + "Windows"
						+ File.separator + "geckodriver.exe";
				edgeDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
						+ File.separator + "resources" + File.separator + "Drivers" + File.separator + "Windows"
						+ File.separator + "MicrosoftWebDriver.exe";
				ieDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
						+ File.separator + "resources" + File.separator + "Drivers" + File.separator + "Windows"
						+ File.separator + "IEDriverServer.exe";

			} else if (System.getProperty("os.name").toLowerCase().contains("linux")) {
				chromeDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
						+ File.separator + "resources" + File.separator + "Drivers" + File.separator + "Linux"
						+ File.separator + "chromedriver";
				geckoDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
						+ File.separator + "resources" + File.separator + "Drivers" + File.separator + "Linux"
						+ File.separator + "geckodriver";

			} else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
				chromeDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
						+ File.separator + "resources" + File.separator + "Drivers" + File.separator + "Mac"
						+ File.separator + "chromedriver";
				geckoDriverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
						+ File.separator + "resources" + File.separator + "Drivers" + File.separator + "Mac"
						+ File.separator + "geckodriver";

			}
		}

	}

	// C:\Program Files (x86)\Microsoft Web Driver
//	private static final String edgeDriverPath = System.getProperty("C://Program Files (x86)//Microsoft Web Driver//MicrosoftWebDriver.exe");
	public WebDriver getDriver(String browserName) {
		browser = browserName;
		System.out.println("Test Browser is :" + browser);
		if (environment.equalsIgnoreCase("local")) {
			if (browser.equalsIgnoreCase("firefox")) {
				return getFirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				return getChromeDriver(chromeDriverPath);
			} else if ((browser.equalsIgnoreCase("ie")) || (browser.equalsIgnoreCase("internetexplorer"))
					|| (browser.equalsIgnoreCase("internet explorer"))) {
				return getInternetExplorerDriver(ieDriverPath);

			} else if ((browser.equalsIgnoreCase("edge")) || (browser.equalsIgnoreCase("Edge"))) {
				return getEdgeDriver(edgeDriverPath);
			}
		} else if (environment.equalsIgnoreCase("remote")) {
			return getRemoteWebDriver(seleniumServer);
		}

		return new FirefoxDriver();
	}

	private WebDriver getRemoteWebDriver(String serverAddress) {
		WebDriver driver = null;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);

		try {
			driver = new RemoteWebDriver(new URL(serverAddress), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println("Initiating remote web driver at :" + serverAddress);
		return driver;
	}

//	private static WebDriver getChromeDriver(String driverpath) {
//		System.setProperty("webdriver.chrome.driver", driverpath);
//		System.setProperty("webdriver.chrome.logfile", System.getProperty("user.dir") + File.separator + "chromedriver.log");
//		System.setProperty("webdriver.chrome.verboseLogging", "true");
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "target");
//		prefs.put("profile.content_settings.exceptions.clipboard", getClipBoardSettingsMap(1));
//		prefs.put("profile.default_content_setting_values.notifications", 1);
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--lang=en");  
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-extensions");
//		options.addArguments("test-type");
//		if (System.getProperty("headless", "no").equalsIgnoreCase("yes")) { // specially for linux graphicless
//																			// environments
//			options.addArguments("--headless");
//			options.addArguments("--window-size=1920,1080");
//		}
//
//		options.setExperimentalOption("prefs", prefs);
//		options.addArguments("--disable-dev-shm-usage");
//		System.out.println("Browser options enabled");
//		System.out.println(options.getCapabilityNames());
//		return new ChromeDriver(options);
//	}
	
	private static WebDriver getChromeDriver(String driverpath) {

	    WebDriverManager.chromedriver().setup();

	    System.setProperty("webdriver.chrome.logfile",
	            System.getProperty("user.dir") + File.separator + "chromedriver.log");

	    System.setProperty("webdriver.chrome.verboseLogging", "true");

	    Map<String, Object> prefs = new HashMap<String, Object>();

	    prefs.put("download.default_directory",
	            System.getProperty("user.dir") + File.separator + "target");

	    prefs.put("profile.content_settings.exceptions.clipboard",
	            getClipBoardSettingsMap(1));

	    prefs.put("profile.default_content_setting_values.notifications", 1);

	    ChromeOptions options = new ChromeOptions();

	    options.addArguments("--lang=en");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-extensions");
	    options.addArguments("--disable-dev-shm-usage");

	    // FIX WINDOW SIZE
	    options.addArguments("--window-size=1920,1080");

	    // FIX WINDOWS SCALING ISSUE
	    options.addArguments("--force-device-scale-factor=1");
	    options.addArguments("--high-dpi-support=1");

	    // REQUIRED FOR WINDOWS HEADLESS
	    options.addArguments("--disable-gpu");

	    // HEADLESS MODE
	    if (System.getProperty("headless", "no").equalsIgnoreCase("yes")) {

	        options.addArguments("--headless=new");
	    }

	    options.setExperimentalOption("prefs", prefs);

	    System.out.println("Browser options enabled");
	    System.out.println(options.getCapabilityNames());

	    WebDriver driver = new ChromeDriver(options);

	    // FORCE SIZE
	    driver.manage().window().setSize(
	            new org.openqa.selenium.Dimension(1920, 1080));

	    // VERIFY SIZE IN JENKINS LOG
	    System.out.println("Browser Size : "
	            + driver.manage().window().getSize());

	    return driver;
	}
	private static WebDriver getInternetExplorerDriver(String driverpath) {
		System.setProperty("webdriver.ie.driver", driverpath);
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability("ignoreZoomSetting", true);
		options.setAcceptInsecureCerts(true);
//		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		// ---> Add this capability only if your execution is backed down due to network
		// policies
		return new InternetExplorerDriver(options);
	}

	private static WebDriver getFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		// Uncomment above statement if selenium version in project POM file is greater
		// than 2.53
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxOptions options = new FirefoxOptions();

		options.addPreference("browser.cache.disk.enable", false);
		options.addPreference("browser.tabs.remote.autostart", false);
		options.addPreference("browser.tabs.remote.autostart.1", false);
		options.addPreference("browser.tabs.remote.autostart.2", false);
		options.addPreference("network.proxy.type", 4);
		return new FirefoxDriver(options);
	}

	private static WebDriver getEdgeDriver(String driverpath) {
		System.setProperty("webdriver.edge.driver", driverpath);
		EdgeOptions options = new EdgeOptions();

		return new EdgeDriver(options);
	}

	private static Map<String, Object> getClipBoardSettingsMap(int settingValue) {
		Map<String, Object> map = new HashMap<>();
		map.put("last_modified", String.valueOf(System.currentTimeMillis()));
		map.put("setting", settingValue);
		Map<String, Object> cbPreference = new HashMap<>();
		cbPreference.put("[*.],*", map);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = null;
		try {
			json = objectMapper.writeValueAsString(cbPreference);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("clipboardSettingJson: " + json);
		return cbPreference;
	}

}
