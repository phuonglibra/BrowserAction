package org.windown.steps.serenity;

import java.util.ArrayList;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.windown.pages.BrowserPage;

public class BrowserSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BrowserPage browserPage;

	// String defaultWindow = getDriver().getWindowHandle();
	@Step
	public void openHomePage() {
		browserPage.open();
	}

	@Step
	public void openHomePage(String linkPageVisit) {

		browserPage.openAt(linkPageVisit);
	}

	@Step
	public void refreshPage() {
		browserPage.getDriver().navigate().refresh();
	}

	@Step
	public void maxWindow() {
		browserPage.getDriver().manage().window().maximize();
	}

	@Step
	public void backwardPage() {
		browserPage.getDriver().navigate().back();
	}

	@Step
	public void forwardPage() {
		browserPage.getDriver().navigate().forward();
	}

	@Step
	public void openAnotherWindow(String anotherWindow) {
		// String defaultWindow = getDriver().getWindowHandle();
		browserPage.evaluateJavascript("window.open('" + anotherWindow
				+ "', 'myD', 'fullscreen=yes');");
		browserPage.getDriver().switchTo().window("myD");
	}

	@Step
	public void getStringPresent(String verifyContentPresent) {
		browserPage.getDriver().getPageSource()
				.contentEquals(verifyContentPresent);

	}

	@Step
	public void getStringNotPresent(String verifyContentNotPresent) {
		browserPage.getDriver().getPageSource()
				.compareTo(verifyContentNotPresent);
		/*
		 * Assert.assertThat(browserPage.containsText(verifyContentNotPresent),
		 * is(false));
		 */
	}

	@Step
	public String getPageTitle() {
		return browserPage.getTitle();
	}

	@Step
	public String getStringNotTitle() {

		return browserPage.getTitle();
	}

	@Step
	public void getStringHasPageTitle(String hasPageTitle) {

		browserPage.getTitle().contains(hasPageTitle);
	}

	@Step
	public void getStringNotHavePageTitle(String notHavePageTitle) {
		browserPage.getTitle().contains(notHavePageTitle);
	}

	@Step
	public String getUrl() {

		return browserPage.getDriver().getCurrentUrl();
	}

	@Step
	public String getWrongUrl() {

		return browserPage.getDriver().getCurrentUrl();
	}

	@Step
	public void chageSizeWindow(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		browserPage.getDriver().manage().window().setSize(dimension);
	}

	@Step
	public void scrollScreen(int scrollUp, int scrollDown) {
		browserPage.evaluateJavascript("window.scrollTo(" + scrollUp + ", "
				+ scrollDown + ");");
	}

	@Step
	public void movedLocationWindow(int point1, int point2) {
		browserPage.getDriver().manage().window()
				.setPosition(new Point(point1, point2));
	}

	@Step
	public void getWindowHandleBefore() {
		browserPage.switchtoParent();
	}

	@Step
	public void openLinkInNewWindow(String linkInNewWindow) {
		String defaultWindow = "";
		defaultWindow = getDriver().getWindowHandle();
		try {
			WebElement link = element(linkInNewWindow);
			browserPage.withAction().moveToElement(link).contextClick(link)
					.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
					.sendKeys(Keys.ENTER).perform();
			Thread.sleep(1000);
		} catch (MoveTargetOutOfBoundsException e) {
			e.getStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ArrayList<String> tabs = new ArrayList<String>(getDriver()
				.getWindowHandles());
		tabs.remove(defaultWindow);
		getDriver().switchTo().window(tabs.get(0));
	}

	private WebElement element(String elementDialog) {

		return null;
	}

	@Step
	public void openElementDialog(String elementDialog) {
		String defaultWindow = getDriver().getWindowHandle();
		element(elementDialog).click();
		defaultWindow = getDriver().getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(getDriver()
				.getWindowHandles());
		tabs.remove(defaultWindow);
		getDriver().switchTo().window(tabs.get(0));
	}

}
