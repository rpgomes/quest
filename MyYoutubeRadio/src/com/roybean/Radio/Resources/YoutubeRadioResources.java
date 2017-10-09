package com.roybean.Radio.Resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface YoutubeRadioResources extends ClientBundle {
	
	public static YoutubeRadioResources INSTANCE = GWT.create(YoutubeRadioResources.class);
	
	//icons
	@Source("icons/searchIcon.gif")
	ImageResource getSearchIcon();
}

