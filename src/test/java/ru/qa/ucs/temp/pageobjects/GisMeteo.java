package ru.qa.ucs.temp.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;


public class GisMeteo {
protected WebDriver wd;

@FindBy(xpath = "//a[contains(text(),'10 дней')]")
private WebElement tenDays;

@FindBy(xpath = "//*[@class='search_input']")
private WebElement cityField;


@FindBy(xpath = "//*[@class='founditem__link']")
private List<WebElement> places;

@FindBy(xpath = "//*[@class='maxt']/span[@class='unit unit_temperature_c']")
private List<WebElement> tempsList;

public GisMeteo(WebDriver wd) {
  PageFactory.initElements(wd, this);
  this.wd = wd;
}

public GisMeteo selectTenDays() {
  tenDays.click();
  return this;
}
public GisMeteo withCity(String city) throws InterruptedException {
 cityField.sendKeys(city);
 sleep(1000);
 places.get(0).click();
 return this;
}

public List<String> getTempList(){
List<String> tempItem = new ArrayList();
for(WebElement element:tempsList){
  tempItem.add(element.getText());
}
return tempItem;
}

}

