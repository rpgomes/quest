package com.roybean.Radio.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.roybean.Radio.util.YoutubeSearchDO;

public class VideoSelector extends Composite implements HasClickHandlers {

	private static VideoSelectorUiBinder uiBinder = GWT
			.create(VideoSelectorUiBinder.class);

	interface VideoSelectorUiBinder extends UiBinder<Widget, VideoSelector> {
	}

	@UiField
	SimplePanel imageContainer;
	@UiField Label titleContainer;
	@UiField SimpleCheckBox test;
	@UiField FlowPanel searchPanel;
//	@UiField Button test;
	
	private YoutubeSearchDO searchDO;
	private int id = 0;
	private boolean toPlay = true;
	private int relativePosition = 0;

	public VideoSelector(YoutubeSearchDO searchDO, int id) {
		this.searchDO = searchDO;
		this.id = id;
		
		initWidget(uiBinder.createAndBindUi(this));
		Image videoPreview = new Image(searchDO.getJpegURL());
		videoPreview.setSize("60px", "60px");
		imageContainer.add(videoPreview);
		titleContainer.setText(searchDO.getVideoTitle());
		titleContainer.setTitle(searchDO.getVideoTitle());
		//		button.setText(firstName);
		
		test.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				event.stopPropagation();
//				Window.alert("click in button");
			}
		});
		test.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				toPlay = event.getValue();
				Window.alert("click in button, value is " + event.getValue());
			}
		});
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		{
			return addDomHandler(handler, ClickEvent.getType());
		}
	}

	public String getVideoID() {
		// TODO Auto-generated method stub
		return searchDO.getVideoID();
	}

	public int getid() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public boolean isToPlay() {
		return toPlay;
	}

	public int getRelativePosition() {
		return relativePosition;
	}

	public void setRelativePosition(int relativePosition) {
		this.relativePosition = relativePosition;
	}
	
	public void removeHighLighrStyle(){
		searchPanel.getElement().getStyle().clearBackgroundColor();
		searchPanel.getElement().getStyle().clearColor();
	}
	
	public void setHighLighrStyle(){
		searchPanel.getElement().getStyle().setBackgroundColor("blue");
		searchPanel.getElement().getStyle().setColor("white");
	}
	
//	delete.addClickHandler(new ClickHandler() {
//		@Override
//		public void onClick(ClickEvent event) {
//			event.stopPropagation();
//			onRemove();
//		}
//	});

	//	@UiHandler("button")
	//	void onClick(ClickEvent e) {
	//		Window.alert("Hello!");
	//	}
	//
	//	public void setText(String text) {
	//		button.setText(text);
	//	}
	//
	//	public String getText() {
	//		return button.getText();
	//	}

}
