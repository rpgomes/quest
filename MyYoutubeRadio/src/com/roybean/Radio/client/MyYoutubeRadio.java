package com.roybean.Radio.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyYoutubeRadio implements EntryPoint {

	public static String APIKEY = "AIzaSyDmtt-Pc-2O-3auGDocWYyyGsuvVhpnGqE";

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		RootLayoutPanel.get().add(new MainPanel());

	}
}