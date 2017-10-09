package com.roybean.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class GamePanel extends Composite {

	private static GamePanelUiBinder uiBinder = GWT
			.create(GamePanelUiBinder.class);

	interface GamePanelUiBinder extends UiBinder<Widget, GamePanel> {
	}

	public GamePanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button buttonShowTip, buttonGuess;
	@UiField
	Label labelTip;
	@UiField
	SimplePanel imageContainer;
	@UiField
	TextBox guessBox;
	@UiField
	FlowPanel panelShow;
	
	private QuestDO questDO;

	public GamePanel(QuestDO questDO) {
		initWidget(uiBinder.createAndBindUi(this));
		this.questDO = questDO;
		SafeUri sfu;
		if (questDO.isAnswered()) {
			buttonShowTip.setVisible(false);
			sfu = questDO.getUrlQuest();
		} else {
			sfu = questDO.getUrlClue();
		}
		Image im = new Image(sfu);
		im.setSize("100%", "100%");
		imageContainer.add(im);
	}

	@UiHandler("buttonShowTip")
	void onClick(ClickEvent e) {
		labelTip.setVisible(true);
		labelTip.setText(questDO.getTitle());
		buttonShowTip.setVisible(false);
	}

	@UiHandler("buttonGuess")
	void onClickbuttonGuess(ClickEvent e) {
		String guessSTR = guessBox.getText().toUpperCase();
		if (guessSTR.equals(questDO.getAnswer().toUpperCase())) {
			panelShow.getElement().getStyle().setBackgroundColor("green");
			imageContainer.clear();
			Image im = new Image(questDO.getUrlQuest());
			im.setSize("100%", "100%");
			imageContainer.add(im);
			questDO.setAnswered(true);
		}else{
			panelShow.getElement().getStyle().setBackgroundColor("red");
		}
		Timer t = new Timer() {
			
			@Override
			public void run() {
				panelShow.getElement().getStyle().setBackgroundColor("white");
			}
		};
		t.schedule(10000);
	}

}
