package restaurants.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.model.RestDataOfMainPage;
import restaurants.model.VariantsOfNameOfMainPage;

import static org.testng.Assert.assertEquals;

/**
 * Created by Slava on 23.02.2017.
 */
public class SearchTests extends TestBase {

  @Test(enabled = true)
  public void searchTestVariantsOfNames() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    app.getAdminHelper().gotoAdminPanel();
    app.getAdminHelper().initOfEditRest("Slava");
    RestDataOfMainPage restDataOfMainPageAllField = new RestDataOfMainPage(
            "Slava2",
            "вул.Жолудєва 8");
    app.getMainPageHelper().enterNameOfRestMainPage(restDataOfMainPageAllField);
    VariantsOfNameOfMainPage variantsOfNameOfMainPage = new VariantsOfNameOfMainPage("Masha\n", "Dima\n", "Саша123\n");
    String[] variantsOfNameOfMainPageMas = {"Masha\n", "Dima\n", "Саша123\n"};
    app.getMainPageHelper().enterVariantsOfNameOfRestMainPage(variantsOfNameOfMainPage);
    app.getMainPageHelper().saveRestMainPage();
    app.getMainPageHelper().confirmChangesOfRestMainPage();
    app.getAdminHelper().getAddressMainUrl();
        for(int i=0;i<variantsOfNameOfMainPageMas.length;i++) {
          app.getSiteHelper().searchRestOnTheSite("Київ", variantsOfNameOfMainPageMas[i]);
          // проверяем на сайте в списке что имя ресторана такое как ему изменили
          assertEquals(app.getMainPageHelper()
                  .text(By.cssSelector("div[lng='30.39818839999998'] div.title")), restDataOfMainPageAllField.getNameOfRest());
}
  }
}
