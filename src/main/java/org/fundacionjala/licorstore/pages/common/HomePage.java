import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.util.ScenarioContext;

@Component
public class HomePage extends AbstractPage{

    @FindBy(xpath = "/html/body/center/h1")
    private WebElement titleLabel;

    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

}