package ru.qa.ucs.temp.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TempCompareTest extends TestBase {

@DataProvider(name = "cities")

public static Object[] params() {
    return new Object[] {  "Москва","Омск","Якутск" };
}

@Test(dataProvider = "cities")
public void cityComp(String cityName) throws InterruptedException {

    app.goTo().gisMeteo();
    List<String>gmList= app.gisMeteoPage()
            .selectTenDays()
            .withCity(cityName)
            .getTempList();

    app.goTo().ya();
    List<String>yaList=app.yaPage()
            .withCity(cityName)
            .getTempList();

    Assert.assertEquals(gmList,yaList);

}

}
