package StepDefinitions;

import Base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtil {

    private BaseUtil base;
    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {

        base.Driver = new ChromeDriver();
        System.out.println("Opening browser");
    }

    @After
    public void TearDownTest() {
        base.Driver.close();
        System.out.println("Closing browser");
    }
}
