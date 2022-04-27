package stepDefinitions;

import io.cucumber.java.en.And;

public class closeBrowser extends BaseClass {
    @And("^Close the browser$")
    public void closeTheBrowser()
    {
driver.close();
    }
}
