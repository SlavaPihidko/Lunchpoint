package restaurants.tests.MainPageOfRestTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import restaurants.tests.TestBase;
import restaurants.utils.MainPgUtils;
import restaurants.utils.VariantsOfNameUtils;

import static org.testng.Assert.assertEquals;
import static restaurants.utils.MainPgUtils.*;
import static restaurants.utils.VariantsOfNameUtils.*;

/**
 * Created by Slava on 29.03.2017.
 */
public class VariantsOfNameTests extends TestBase {
  @Test
  public void variantsOfNameTest() throws InterruptedException {
    app.getSessionHelper().login(usernameAdmin, passwordAdmin);
    Thread.sleep(2000);

    app.getAdminHelper().getAddressMainUrl("manager/restaurants/update?id=2219");
    Thread.sleep(2000);
    // проверяем в админке на главной страничке ресторана что варианты названий сохранились
    assertEquals(app.getMainPgHelper()
            .attribute(By.cssSelector("div.input-outer span.select2-selection.select2-selection--multiple li.select2-selection__choice:first-of-type"),"title"), variantsOfName.getVarName1());
    assertEquals(app.getMainPgHelper()
            .attribute(By.cssSelector("div.input-outer span.select2-selection.select2-selection--multiple li.select2-selection__choice:nth-of-type(2)"),"title"), variantsOfName.getVarName2());
    assertEquals(app.getMainPgHelper()
            .attribute(By.cssSelector("div.input-outer span.select2-selection.select2-selection--multiple li.select2-selection__choice:nth-of-type(3)"),"title"), variantsOfName.getVarName3());
  }
}
