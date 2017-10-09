package com.roybean.Radio.util;

public class YoutubeSearchDO {
	private String videoID;
	private String jpegURL;
	private String description;
	private String channelID;
	private String videoTitle;
	
	public String getVideoID() {
		return videoID;
	}
	public void setVideoID(String videoID) {
		this.videoID = videoID;
	}
	
	public String getJpegURL() {
		return jpegURL;
	}
	public void setJpegURL(String jpegURL) {
		this.jpegURL = jpegURL;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getChannelID() {
		return channelID;
	}
	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}
	
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
}
