package org.fundacionjala.pivotal.pages.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import org.fundacionjala.core.ui.AbstractPage;

/**
 * Header page.
 **/
@Component
public class Header extends AbstractPage {
    @FindBy(css = ".tc_header_item tc_header_logo")
    private WebElement goDashboard;

    @FindBy(css = ".tc_projects_dropdown_link.tc_context_name")
    private WebElement projecMenu;

    @FindBy(css = ".raw_context_name")
    private WebElement titleOnHeader;

    @FindBy(css = ".tc_header_project_name")
    private WebElement titleOnWSHeader;

    @FindBy(css = ".Dropdown__button _2Oy9G__NotificationsBell__button")
    private WebElement notifications;

    @FindBy(css = ".div[data-aid='ProfileDropdown'] .zWDds__Button")
    private WebElement profile;

    @FindBy(css = ".div[data-aid='ProductUpdatesDropdown__indicator--newHeader'] .zWDds__Button")
    private WebElement whatsNew;

    @FindBy(css = "a[data-aid='CreateProject']")
    private WebElement createProjectLink;

    /**
     * Go to dashboard page.
     *
     * @return Dashboard page.
     */
    public Dashboard goToDashBoard() {
        this.action.click(this.goDashboard);
        return new Dashboard();
    }

    /**
     * This method open project menu.
     */
    public void openProjectMenu() {
        this.action.waitVisibility(this.projecMenu);
        this.action.click(this.projecMenu);
    }

    /**
     * This method open profile.
     */
    public void openProfile() {
        this.action.click(this.profile);
    }

    /**
     * This method open whats new.
     */
    public void openWhatsNew() {
        this.action.click(this.whatsNew);
    }

    /**
     * This method open help.
     */
    public void openHelp() {
        final List<WebElement> buttons = this.driver.findElements(By.cssSelector(
                ".zWDds__Button.TtSTu__Button--header.Dropdown__button"));
        for (final WebElement element : buttons) {
            if (element != this.profile && element != this.whatsNew) {
                element.click();
                return;
            }
        }
    }

    /**
     * Option over header menu.
     */
    public void clickCreateNewProject() {
        this.action.click(this.createProjectLink);
    }

    /**
     * Capture project/workspace name on header.
     *
     * @return title text displayed on header
     */
    public String getTitleName() {
        this.action.waitPresenceOfElement(By.className("raw_context_name"));
        return this.titleOnHeader.getAttribute("innerHTML");
    }

    /**
     * Capture workspace name on header.
     *
     * @return title text displayed on header
     */
    public String getTitleWSName() {
        this.action.waitPresenceOfElement(By.className("tc_header_project_name"));
        return this.titleOnWSHeader.getAttribute("innerHTML");
    }

    /**
     * This method open menu.
     **/
    public void openMenu() {
        this.action.click(this.projecMenu);
        final int timeToWait = 3000;
        this.action.pause(timeToWait);
    }
}
