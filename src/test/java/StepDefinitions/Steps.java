package StepDefinitions;

import Base.BaseUtil;
import io.cucumber.java.DataTableType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Steps extends BaseUtil {

    private BaseUtil base;
    private LoginPage loginPage;
    public Steps(BaseUtil base) {
        this.base = base;
        loginPage = new LoginPage(base.Driver);
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        base.Driver.navigate().to("https://demosite.executeautomation.com/Login.html");
        System.out.println("The user is on the login page");
    }

    @When("the user enter valid credentials")
    public void the_user_enter_valid_credentials(List<User> users) {
        for (User user : users) {
            loginPage.Login(user.username, user.password);
        }
        System.out.println("Entered valid username and password");
    }

    @When("hits the enter key")
    public void hits_the_enter_key() {
        loginPage.Submit();
        System.out.println("Hits submit");
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        Assert.assertTrue(base.Driver.findElement(By.id("Initial")).isDisplayed(), "Its not displayed");
        System.out.println("Logged in successfully");
    }

    public static class User {
        public String username;
        public String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    @DataTableType
    public User userEntryTransformer(Map<String, String> row) {
        return new User(row.get("username"),
                row.get("password"));
    }
}
