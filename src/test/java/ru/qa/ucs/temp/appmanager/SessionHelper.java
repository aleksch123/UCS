package ru.qa.ucs.temp.appmanager;

import org.openqa.selenium.WebDriver;
import ru.qa.ucs.temp.tests.TestBase;

public class SessionHelper {
WebDriver wd;

public SessionHelper(WebDriver wd) {
  this.wd = wd;
}


public void ya() {
  wd.navigate().to(TestBase.app.getProp().getProperty("ya.url"));
}

public void gisMeteo() {
  wd.navigate().to(TestBase.app.getProp().getProperty("gm.url"));

}
}
