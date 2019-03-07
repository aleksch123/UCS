package ru.qa.ucs.temp.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qa.ucs.temp.pageobjects.GisMeteo;
import ru.qa.ucs.temp.pageobjects.YandexWeather;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

WebDriver wd;
private final Properties properties;
private SessionHelper sessionHelper;
private GisMeteo gisMeteo;
private YandexWeather yandexWeather;
private String browser;

public ApplicationManager(String browser) {
  this.browser = browser;
  properties = new Properties();

}

public void init() throws IOException {

  wd = new ChromeDriver();
  properties.load(new FileReader(new File("src/test/resources/test.properties")));
  wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  gisMeteo = new GisMeteo(wd);
  yandexWeather = new YandexWeather(wd);
  sessionHelper = new SessionHelper(wd);

}

public void stop() {
  wd.quit();
}

public Properties getProp() {
  return properties;
}

public SessionHelper goTo() {
  return sessionHelper;
}

public GisMeteo gisMeteoPage() {
  return gisMeteo;
}

public YandexWeather yaPage() {
  return yandexWeather;
}

}
