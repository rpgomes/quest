package com.roybean.Radio.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class SearchSelector extends Composite implements HasText {

	private static SearchSelectorUiBinder uiBinder = GWT
			.create(SearchSelectorUiBinder.class);

	interface SearchSelectorUiBinder extends UiBinder<Widget, SearchSelector> {
	}

	public SearchSelector() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button;

	public SearchSelector(String search) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(search);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

	
}
