package com.roybean.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TheQuest implements EntryPoint {
	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {		
		RootLayoutPanel.get().add(new MainPanel());
	}
}
