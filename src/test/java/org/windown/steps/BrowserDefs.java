package org.windown.steps;

import net.thucydides.core.annotations.Steps;

import org.junit.Assert;
import org.windown.steps.serenity.BrowserSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BrowserDefs {

	@Steps
	BrowserSteps browser;

	@Given("^the home page is visited$")
	public void the_home_page_is_visited() throws Throwable {
		browser.openHomePage();
	}

	@Given("^the page \"([^\"]*)\" is visited$")
	public void the_page_is_visited(String linkPageVisit) throws Throwable {
		browser.openHomePage(linkPageVisit);
	}

	@Given("^the page is refreshed$")
	public void the_page_is_refreshed() throws Throwable {
		browser.refreshPage();
	}

	@Given("^maximize the window$")
	public void maximize_the_window() throws Throwable {
		browser.maxWindow();
	}

	@Given("^go backward one page$")
	public void go_backward_one_page() throws Throwable {
		browser.backwardPage();
	}

	@Given("^go forward one page$")
	public void go_forward_one_page() throws Throwable {
		browser.forwardPage();
	}

	@Given("^the page \"([^\"]*)\" is opened on another window$")
	public void the_page_is_opened_on_another_window(String anotherWindow)
			throws Throwable {
		browser.openAnotherWindow(anotherWindow);
	}

	@Then("^assert that the \"([^\"]*)\" text is present$")
	public void assert_that_the_text_is_present(String verifyContentPresent)
			throws Throwable {
		browser.getStringPresent(verifyContentPresent);

	}

	@Then("^assert that the \"([^\"]*)\" text is not present$")
	public void assert_that_the_text_is_not_present(
			String verifyContentNotPresent) throws Throwable {
		browser.getStringNotPresent(verifyContentNotPresent);
	}

	@Then("^assert that the page title is \"([^\"]*)\"$")
	public void assert_that_the_page_title_is(String pageTitle)
			throws Throwable {
		Assert.assertEquals(browser.getPageTitle(), pageTitle);
	}

	@Then("^assert that the page title is not \"([^\"]*)\"$")
	public void assert_that_the_page_title_is_not(String NotpageTitle)
			throws Throwable {
		Assert.assertNotEquals(browser.getStringNotTitle(), NotpageTitle);
	}

	@Then("^assert that the page title has \"([^\"]*)\"$")
	public void assert_that_the_page_title_has(String hasPageTitle)
			throws Throwable {
		browser.getStringHasPageTitle(hasPageTitle);
	}

	@Then("^assert that the page title does not have \"([^\"]*)\"$")
	public void assert_that_the_page_title_does_not_have(String notHavePageTitle)
			throws Throwable {
		browser.getStringNotHavePageTitle(notHavePageTitle);
	}

	@Then("^assert that the url is \"([^\"]*)\"$")
	public void assert_that_the_url_is(String currentUrl) throws Throwable {
		Assert.assertEquals(browser.getUrl(), currentUrl);
	}

	@Then("^assert that the url is not \"([^\"]*)\"$")
	public void assert_that_the_url_is_not(String wrongUrl) throws Throwable {
		Assert.assertNotEquals(browser.getWrongUrl(), wrongUrl);
	}

	@When("^window dimension is changed with size \\((\\d+),(\\d+)\\)$")
	public void window_dimension_is_changed_with_size(int width, int height)
			throws Throwable {
		browser.chageSizeWindow(width, height);
	}

	@When("^scroll up or down in screen with value \\((\\d+),(\\d+)\\)$")
	public void scroll_up_or_down_in_screen_with_value(int scrollUp,
			int scrollDown) throws Throwable {
		browser.scrollScreen(scrollUp, scrollDown);
	}

	@When("^window is moved to location with coordinates \\((\\d+),(\\d+)\\)$")
	public void window_is_moved_to_location_with_coordinates(int point1,
			int point2) throws Throwable {
		browser.movedLocationWindow(point1, point2);
	}

	@When("^close current window$")
	public void close_current_window() throws Throwable {
		browser.getDriver().close();
	}

	@When("^switch back to the original window$")
	public void switch_back_to_the_original_window() throws Throwable {
		browser.getWindowHandleBefore();

	}

	@When("^open \"([^\"]*)\" link in new window and switch to it$")
	public void open_link_in_new_window_and_switch_to_it(String linkInNewWindow)
			throws Throwable {
		browser.openLinkInNewWindow(linkInNewWindow);
	}

	@When("^open \"([^\"]*)\" dialog and switch to it$")
	public void open_dialog_and_switch_to_it(String elementDialog)
			throws Throwable {
		browser.openElementDialog(elementDialog);
	}
}
