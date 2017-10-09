package com.roybean.Radio.client;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.bramosystems.oss.player.core.client.PlayException;
import com.bramosystems.oss.player.core.client.PlayerUtil;
import com.bramosystems.oss.player.core.client.PluginNotFoundException;
import com.bramosystems.oss.player.core.client.PluginVersionException;
import com.bramosystems.oss.player.core.event.client.PlayStateEvent;
import com.bramosystems.oss.player.core.event.client.PlayStateEvent.State;
import com.bramosystems.oss.player.core.event.client.PlayStateHandler;
import com.bramosystems.oss.player.youtube.client.ChromelessPlayer;
//import com.google.gdata.client.youtube.YouTubeManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.RequestTimeoutException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.roybean.Radio.Resources.YoutubeRadioResources;
import com.roybean.Radio.util.YoutubeSearchDO;

public class MainPanel extends Composite{

	private static MainPanelUiBinder uiBinder = GWT
			.create(MainPanelUiBinder.class);

	interface MainPanelUiBinder extends UiBinder<Widget, MainPanel> {
	}

	@UiField SimplePanel videocontainer, you, headerPanel;
	@UiField Button buttonGet, searchButton, buttonPause, buttonPlay, buttonAdjust;
	@UiField TextBox searchBox;
	@UiField FlowPanel searchVideo;
	@UiField Image im;
	@UiField Label videoTitle;
	@UiField ScrollPanel searchVideoScroll;

	private String searchQuery = "";
	private String youtubeVideoID = "";
	private int playIndex = 0;
	List<YoutubeSearchDO> listSearch;
	SimplePanel fp ;
	int playIndexLast = 0;
	
	//Storage Variables
	int numberOfSearchs = 0;
	//nameOfSearch,nameofTag
	HashMap<String,String> searchVideoMap = new HashMap<String,String>() ;
	private static String TAGNAME = "searchTag";

	private ChromelessPlayer player;

	public MainPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		 
		headerPanel.add(new Label("SearchRadio: Play the Search!!!"));
		
		Storage stockStore = Storage.getLocalStorageIfSupported();
		String numberSearchStr = stockStore.getItem("numberOfSearchs");
		if(numberSearchStr != null){
			numberOfSearchs = Integer.valueOf(numberSearchStr);
		}
		
		//Fill Oracle
		if(numberOfSearchs > 0){
			Collection<String> searchValues = searchVideoMap.values();
			for(String val : searchValues){
				System.out.println(val);
			}			
		}
		
		im.setUrl(YoutubeRadioResources.INSTANCE.getSearchIcon().getSafeUri());
		im.setSize("22px", "15px");
		searchButton.getElement().appendChild(im.getElement());
		//		searchButton.getElement().getStyle().setBackgroundImage(YoutubeRadioResources.INSTANCE.getSearchIcon().getSafeUri().toString());

		buttonAdjust.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if(player != null){
					System.out.println( videocontainer.getOffsetHeight());
					fp.setSize(videocontainer.getOffsetWidth()+"px", videocontainer.getOffsetHeight()+"px");
					player.setSize(videocontainer.getOffsetWidth()+"px", videocontainer.getOffsetHeight()+"px");
				}
			}
		});

		searchButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				//Window.alert("click");
				String url = "http://www.google.com/search?q=mkyong";
				searchQuery = searchBox.getText();
				
				//storeValue
				//check if is in hashMap
				String tagName = searchVideoMap.get(searchQuery);
				if(tagName == null){
					numberOfSearchs++;
					searchVideoMap.put(searchQuery, TAGNAME+numberOfSearchs);
				}
				
				searchQuery = searchQuery.replace(" ", "+");
				System.out.println("search Query = " + searchQuery);
				int maxReq = 50;
				url = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults="+maxReq+
						"&q="+searchQuery+"&key="+MyYoutubeRadio.APIKEY;
				try{
					RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);

					try {
						Request response = builder.sendRequest(null, new RequestCallback() {
							public void onError(Request request, Throwable exception) {
								System.out.println("onError");
							}

							public void onResponseReceived(Request request, Response response) {
								//				        	System.out.println("onResponseReceived" +response.getText());
								//				        	JavaScriptObject jsonObj = JsonUtils.safeEval(response.getText());
								searchVideo.clear();
								parseJsonData(response.getText());
							}
						});
					} catch (RequestException e) {
						System.out.println("fuckNAtive");
						e.printStackTrace();
					}
					//				System.out.println(response.toString());
				}catch (Exception e) {
					System.out.println("fuck");
					e.printStackTrace();
				}
			}
		});

	}

	private void addPlayer(String videoID) {
		try {
			//set Style of Search Pannel
			if(playIndexLast != -1 ){
				((VideoSelector)searchVideo.getWidget(playIndexLast)).removeHighLighrStyle();
			}
			playIndexLast = playIndex;
			((VideoSelector)searchVideo.getWidget(playIndex)).setHighLighrStyle();
			
			//Set Title Of Video
			videoTitle.setText(listSearch.get(playIndex).getVideoTitle());
			Label videoTitle = new Label();
			videoTitle.setText(videoID);			
			you.clear();
			you.setWidget(videoTitle);
			videoTitle.setSize("200px", "200px");
			
			//Create Player and set Size
			player = new ChromelessPlayer("http://www.youtube.com/v/"+videoID,videocontainer.getOffsetWidth()+"px", videocontainer.getOffsetHeight()+"px");
			fp = new SimplePanel();
			fp.getElement().setId("videoPanelFP");
			fp.clear();
			fp.setSize(videocontainer.getOffsetWidth()+"px", videocontainer.getOffsetHeight()+"px");
			fp.setWidget(player);			
			fp.setSize(videocontainer.getOffsetWidth()+"px", videocontainer.getOffsetHeight()+"px");
			player.setSize(videocontainer.getOffsetWidth()+"px", videocontainer.getOffsetHeight()+"px");

			player.addPlayStateHandler(new PlayStateHandler() {

				@Override
				public void onPlayStateChanged(PlayStateEvent event) {
					System.out.println(event.getPlayState().toString());

					if(event.getPlayState().equals(State.Finished)){
						System.out.println("video IN");
						while(true){
							
							playIndex++;
							if(playIndex == listSearch.size()){
								playIndex = 0;
								
//								ScrollPanel sdf = new ScrollPanel();
//								sdf.scrollToTop();
							}
							if(((VideoSelector)searchVideo.getWidget(playIndex)).isToPlay()){
								addPlayer(listSearch.get(playIndex).getVideoID());
								int pos = ((VideoSelector)searchVideo.getWidget(3)).getRelativePosition();
								System.out.println("pos = " + pos);
								searchVideoScroll.setVerticalScrollPosition(pos);
								
								break;
							}			
							
						}
						
					}
				}
			});

			videocontainer.setWidget(fp); // add player and custom control to panel.
			final com.google.gwt.user.client.Timer time = new com.google.gwt.user.client.Timer() {

				@Override
				public void run() {
					try {
						player.playMedia();
//						if(player.getPlayPosition()==0){
//							time.schedule(2000);
//						}
					} catch (PlayException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			};
			time.schedule(3000);

			buttonPause.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					player.pauseMedia();					
				}
			});

			buttonPlay.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					try {
						player.playMedia();
						//						player.setControllerVisible(false);
					} catch (PlayException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});

		} catch (PluginVersionException e) {
			// required Flash plugin version is not available,
			// alert user possibly providing a link to the plugin download page.
			videocontainer.setWidget(new HTML(".. some nice message telling the " + "user to download plugin first .."));
		} catch(PluginNotFoundException e) {
			// required Flash plugin not found, display a friendly notice.
			videocontainer.setWidget(PlayerUtil.getMissingPluginNotice(e.getPlugin()));
		}
		youtubeVideoID = "";
		/*Video player =  Video.createIfSupported();
		player.addSource("http://www.youtube.com/v/3sdnCOvRpRc",VideoElement.TYPE_MP4);
		player.addSource("http://www.youtube.com/v/3sdnCOvRpRc",VideoElement.TYPE_OGG);
		player.addSource("http://www.youtube.com/v/3sdnCOvRpRc",VideoElement.TYPE_WEBM);
		player.play();
		player.setControls(true);
		videocontainer.setWidget(player);*/
	}

	private void parseJsonData(String json) {

		JSONValue value = JSONParser.parseStrict(json);

		JSONObject productsObj = value.isObject();

		JSONArray itemssArray = productsObj.get("items").isArray();

		listSearch = new ArrayList<YoutubeSearchDO>();
		playIndex = 0;

		if (itemssArray != null) {
			System.out.println("Size = " + itemssArray.size());
			for (int i=0; i<=itemssArray.size()-1; i++) {

				String videoId = "";
				String title = "";
				String description = "";
				String channelTitle = "";
				String etag = "";
				String urlSnapshot = "";

				System.out.println("-----------------------//----------------------");
				JSONObject productObj = itemssArray.get(i).isObject();
				etag = productObj.get("etag").isString().stringValue();
				System.out.println("etag = " + etag);

				JSONObject idProduct = productObj.get("id").isObject();
				if(idProduct != null){

					try{
						videoId = idProduct.get("videoId").isString().stringValue();
					}catch(Exception e){
						//e.printStackTrace();
						System.out.println("Probably Playlist Rejecting");
						continue;
					}
					if(videoId == null){
						System.out.println("Probably Playlist Rejecting");
						continue;
					}
					if(youtubeVideoID.equals("")){
						youtubeVideoID = videoId;
					}
					System.out.println("videoId = " + videoId);
				}

				JSONObject snippetProduct = productObj.get("snippet").isObject();
				if(snippetProduct != null){

					try{
						title = snippetProduct.get("title").isString().stringValue();
					}catch(Exception e){
						e.printStackTrace();
						System.out.println("title Exception");
						continue;
					}
					if(title == null){
						System.out.println("title is null");
						continue;
					}
					System.out.println("title = " + title);

					try{
						description = snippetProduct.get("description").isString().stringValue();
					}catch(Exception e){
						e.printStackTrace();
						System.out.println("description Exception");
						continue;
					}
					if(description == null){
						System.out.println("description is null");
						continue;
					}
					System.out.println("description = " + description);

					try{
						channelTitle = snippetProduct.get("channelTitle").isString().stringValue();
					}catch(Exception e){
						e.printStackTrace();
						System.out.println("channelTitle Exception");
						continue;
					}
					if(channelTitle == null){
						System.out.println("channelTitle is null");
						continue;
					}
					System.out.println("channelTitle = " + channelTitle);



					JSONObject thubnailsProduct = snippetProduct.get("thumbnails").isObject();
					if(thubnailsProduct != null){
						JSONObject defaultProduct = thubnailsProduct.get("default").isObject();
						if(defaultProduct != null){
							try{
								urlSnapshot = defaultProduct.get("url").isString().stringValue();
							}catch(Exception e){
								//                				 e.printStackTrace();
								System.out.println("urlSnapshot Exception");
								continue;
							}
							if(urlSnapshot == null){
								System.out.println("urlSnapshot is null");
								continue;
							}
							System.out.println("urlSnapshot = " + urlSnapshot);
						}
					}

				}
				YoutubeSearchDO youSearch = new YoutubeSearchDO();
				youSearch.setVideoID(videoId);
				youSearch.setChannelID(channelTitle);
				youSearch.setDescription(description);
				youSearch.setVideoTitle(title);
				youSearch.setJpegURL(urlSnapshot);
				listSearch.add(youSearch);
				VideoSelector vs = new VideoSelector(youSearch, listSearch.size()-1);
				vs.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						VideoSelector vs = (VideoSelector) event.getSource();
						playIndex = vs.getid();
						addPlayer(vs.getVideoID());
						vs.setRelativePosition(event.getY());
						System.out.println(event.getX());
						System.out.println("yy" + event.getY());
					}
				});
				searchVideo.add(vs);
				//        		 System.out.println("-----------------------//----------------------");
			}//enf of for
			addPlayer(listSearch.get(0).getVideoID());
		}
	
	}

	public class RequestCallbackExample implements RequestCallback {

		private static final int STATUS_CODE_OK = 200;

		public void onError(Request request, Throwable exception) {
			if (exception instanceof RequestTimeoutException) {
				System.out.println("onError-RequestTimeoutException");
			} else {
				System.out.println("onError Generic");
			}
		}

		public void onResponseReceived(Request request, Response response) {
			if (STATUS_CODE_OK == response.getStatusCode()) {
				System.out.println("STATUS_CODE_OK");
			} else {
				System.out.println("STATUS_CODE_NNNOK");
			}
		}
	}

}
