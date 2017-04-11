package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.model.RestDataOfMainPage;
import restaurants.model.VariantsOfNameOfMainPage;
import restaurants.tests.TestBase;

import static org.testng.Assert.assertEquals;
//import static restaurants.utils.MainPgUtils.restDataOfMainPageAllField;
import static restaurants.utils.MainPgUtils.restEditDataOfMainPg;

/**
 * Created by Slava on 23.02.2017.
 */
public class SearchTests extends TestBase {

  @Test(priority = 1)
  public void searchTestVariantsOfNames() throws InterruptedException {

    String[] variantsOfNameOfMainPageMas = {"Masha\n", "Dima\n", "Саша123\n"};
        for(int i=0;i<variantsOfNameOfMainPageMas.length;i++) {
          app.getSiteHelper().searchRestOnTheSite("Київ", variantsOfNameOfMainPageMas[i]);
          // проверяем на сайте в списке что поиск нашел именно тот ресторан
          assertEquals(app.getMainPgHelper()
                  .text(By.cssSelector(String.format("div[lng='%s'] div.title", restEditDataOfMainPg.getLng()))), restEditDataOfMainPg.getNameOfRest());
        }
  }

  @Test(priority = 2)
  public void searchNameThatAbsent() throws InterruptedException {

    app.getSiteHelper().searchRestOnTheSite("Київ", "xxxyyy");

    assertEquals(app.getMainPgHelper()
              .text(By.cssSelector("div.results-line div.title > p")), "Показано 0 результатов");
    assertEquals(app.getMainPgHelper()
            .text(By.cssSelector("div.title-h1")), "Рестораны в Киеве");
    assertEquals(app.getMainPgHelper()
            .elementPresent(By.cssSelector("div.useful-info")),true);
    }
  }
