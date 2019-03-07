package ru.qa.ucs.temp.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;


public class YandexWeather {
protected WebDriver wd;


@FindBy(xpath = "//*[@id='header2input']")
private WebElement cityField;


@FindBy(xpath = "//*[@class='suggest2-item suggest2-item_type_weather suggest2-item_interact_link i-bem suggest2-item_js_inited']")
private List<WebElement> places;

@FindBy(xpath = "//*[@class='forecast-briefly__days']//div[@class='temp forecast-briefly__temp forecast-briefly__temp_day']/span[@class='temp__value']")
private List<WebElement> tempsList;

public YandexWeather(WebDriver wd) {
  PageFactory.initElements(wd, this);
  this.wd = wd;
}

public YandexWeather withCity(String city) throws InterruptedException {
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

