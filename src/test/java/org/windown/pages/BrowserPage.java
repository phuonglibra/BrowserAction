package org.windown.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.google.com.vn")
public class BrowserPage extends PageObject {

	public void switchtoParent() {
		String Parent_Window = getDriver().getWindowHandle();
		getDriver().switchTo().window(Parent_Window);
	}
}
