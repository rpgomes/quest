package com.roybean.client;

import java.util.HashMap;
import java.util.Set;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.roybean.resources.QuestResources;

public class MainPanel extends Composite{

	private static MainPanelUiBinder uiBinder = GWT
			.create(MainPanelUiBinder.class);

	interface MainPanelUiBinder extends UiBinder<Widget, MainPanel> {
	}
	
	HashMap<Integer, String> mapURL = new HashMap<Integer, String>();
	HashMap<Integer, String> mapRating = new HashMap<Integer, String>();
	int randomValue = 0;

	@UiField Button button1, button2, button3, button4, button5, button6, button7, button8;
	@UiField Button button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20;
	@UiField Button button21, button22, button23, button24, button25, button26, button27, button28, button29;
	@UiField Button button30;
	@UiField SimplePanel center;
	@UiField FlowPanel inanimeshadow;
	@UiField Image bannerImage, blogImage;

	QuestDO quest1 = new QuestDO("Snow White", "Book (eng)");
	QuestDO quest2 = new QuestDO("Batman vs Superman","Movie (eng)");
	QuestDO quest3 = new QuestDO("Puss in Boots","Movie (eng)");
	QuestDO quest4 = new QuestDO("Sliders","TV Series (eng)");
	QuestDO quest5 = new QuestDO("Deadpool","Movie (eng)");
	QuestDO quest6 = new QuestDO("The Dressmaker","Movie (eng)");
	QuestDO quest7 = new QuestDO("Kung Fu Panda 3","Movie (eng)");
	QuestDO quest8 = new QuestDO("Rumpelstiltskin","Fictional Character (eng)");

	QuestDO quest9 = new QuestDO("The Rolling Stones","Music Band (eng)");
	QuestDO quest10 = new QuestDO("Victor Frankenstein","Movie (eng)");
	QuestDO quest11 = new QuestDO("Star Wars: Episode VII","Movie (eng)");
	QuestDO quest12 = new QuestDO("Feios, Porcos e Maus","Movie (pt)");
	QuestDO quest13 = new QuestDO("One Punch Man","Anime Series (eng)");
	QuestDO quest14 = new QuestDO("Men In Black","Movie (eng)");
	QuestDO quest15 = new QuestDO("Toy Story","Movie (pt)");
	QuestDO quest16 = new QuestDO("The Sisterhood of the Traveling Pants","Movie (eng)");
	QuestDO quest17 = new QuestDO("The Sisterhood of the Traveling Pants 2","Movie (eng)");
	QuestDO quest18 = new QuestDO("Robin Hood","Movie (eng)");
	QuestDO quest19 = new QuestDO("Dark Souls","Game (eng)");
	QuestDO quest20 = new QuestDO("Finding Nemo","Movie (eng)");	
	QuestDO quest21 = new QuestDO("A Knight's Tale","Movie (eng)");
	QuestDO quest22 = new QuestDO("Ice Age","Movie (eng)");
	QuestDO quest23 = new QuestDO("Dumbo","Movie (eng)");
	QuestDO quest24 = new QuestDO("Arbitro","Profissão (pt)");
	QuestDO quest25 = new QuestDO("The Princess Diaries","Movie (eng)");
	QuestDO quest26 = new QuestDO("FNAC","Store (pt/eng)");
	QuestDO quest27 = new QuestDO("Murder on the Orient Express","Movie/book (eng)");
	QuestDO quest28 = new QuestDO("Race to Witch Mountain","Movie (eng)");
	QuestDO quest29 = new QuestDO("She's the Man","Movie (eng)");
	QuestDO quest30 = new QuestDO("The Hateful Eight","Movie (eng)");
	
	public MainPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		
		bannerImage.setUrl(QuestResources.INSTANCE.getBanner().getSafeUri());
		
		bannerImage.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.open("http://inanimeshadow.blogspot.com", "_blank", "");
			}
		});
		
		//Kamisama Gods
		mapURL.put(0, "http://4.bp.blogspot.com/-KpOEUKeAOFE/UoSAhGhSjmI/AAAAAAAAAKM/tXUiOa0IMak/s1600/kamisama+dolls.jpg");
		mapRating.put(0, "http://inanimeshadow.blogspot.pt/2013/07/kamisama-dools-anime-review.html");
		//TWOGK 3
		mapURL.put(1, "http://3.bp.blogspot.com/-_CSCkoYOzRc/UkcKr44ISNI/AAAAAAAAAHg/x5DleC8laGc/s1600/images.jpg");
		mapRating.put(1, "http://inanimeshadow.blogspot.pt/2013/09/the-world-god-only-knows-goddesses-arc.html");
		//Attack On Titan
		mapURL.put(2, "http://3.bp.blogspot.com/-Y5KAjYhvrVw/UkgUu6vFzMI/AAAAAAAAAIA/SCWGFy2b1EA/s1600/attackoontitan.jpg");
		mapRating.put(2, "http://inanimeshadow.blogspot.pt/2013/10/attack-on-titan.html");
		//Danganrompa
		mapURL.put(3, "http://4.bp.blogspot.com/-4vIMuX4A34Y/UkgB2KrLNpI/AAAAAAAAAHw/JlPWL5oU41U/s1600/29060-20121206_danganronpa02.jpg");
		mapRating.put(3, "http://inanimeshadow.blogspot.com/2013/10/danganronpa-trigger-happy-havoc-anime.html﻿");
		//Watamote
		mapURL.put(4, "http://www.deculture.es/wp-content/uploads/2013/07/Watamote-OP1-Large-01.jpg");
		mapRating.put(4, "http://inanimeshadow.blogspot.com/2013/10/watamote-no-matter-how-i-look-at-it-its.htm");
		//Devil Survivor 2
		mapURL.put(5, "http://4.bp.blogspot.com/-KDVLddndqS4/UmWmS_QmvnI/AAAAAAAAAJg/zUiROSrarkY/s1600/devil_survivor_2.jpg");
		mapRating.put(5, "http://inanimeshadow.blogspot.com/2013/11/devil-survivor-2-anime-review.html");
		//Aku no Hanna
		mapURL.put(6, "http://3.bp.blogspot.com/-N7Z331mIogI/UpO2vhgxytI/AAAAAAAAAKw/j2OsI1DxIko/s1600/HAki+no+Ana.jpg");
		mapRating.put(6, "http://inanimeshadow.blogspot.com/2013/11/aku-no-hana-anime-review.html﻿");
		//Sekai Wrestling
		mapURL.put(7, "http://4.bp.blogspot.com/-UjktGrOhR3c/UsCpBCg-YeI/AAAAAAAAALM/heVl9yxzjQg/s1600/idol+Vs+Wrestler.jpg");
		mapRating.put(7, "http://inanimeshadow.blogspot.com/2013/12/sekai-de-ichiban-tsuyoku-naritai.htm");
		//Kyokai no Kanata
		mapURL.put(8, "http://3.bp.blogspot.com/-bRHm8r9gGhY/UtO8RaXlq4I/AAAAAAAAAMY/leH2QDF_7wE/s1600/Kyoukai+no+Kanata.jpg");
		mapRating.put(8, "http://inanimeshadow.blogspot.com/2014/01/kyokai-no-kanata-anime-review.html﻿");
		//Monogatari 2nd Season
		mapURL.put(9, "http://2.bp.blogspot.com/-btfsZNqBKB0/UuWOo5WQxAI/AAAAAAAAAMs/u1VWskbpu6k/s1600/Monogatari+Second+Season.jpg");
		mapRating.put(9, "http://inanimeshadow.blogspot.com/2014/02/monogatari-series-second-season-anime.html");
		//Blood Lad
		mapURL.put(10, "http://3.bp.blogspot.com/-lJLTnu8bt3k/UvlFmEG7qzI/AAAAAAAAANI/IdxZsx7rcsI/s1600/blood+lad.png");
		mapRating.put(10, "http://inanimeshadow.blogspot.com/2014/02/blood-lad-anime-review.html");
		//IS2
		mapURL.put(11, "http://1.bp.blogspot.com/-JAdr1YMaIX8/Uzshr-Hl_aI/AAAAAAAAARE/1cqNC0tYExI/s1600/infinite+stratos_2.jpg");
		mapRating.put(11, "http://inanimeshadow.blogspot.com/2014/03/infinite-statos-2-anime-review.html");
		//Coopelion
		mapURL.put(12, "http://3.bp.blogspot.com/-707tbmDlYhY/U4ucY5-5kGI/AAAAAAAAAR0/GzQq1-f3wKs/s1600/coopelion.png");
		mapRating.put(12, "http://inanimeshadow.blogspot.com/2014/06/coppelion-anime-review.html");
		//Golden Time
		mapURL.put(13, "http://4.bp.blogspot.com/-HYPI-tiZuYg/U6ablv0ZTHI/AAAAAAAAASU/1wExXbygJi4/s1600/Golden+Time.jpg");
		mapRating.put(13, "http://inanimeshadow.blogspot.com/2014/07/golden-time-anime-review.html");
		//School Days
		mapURL.put(14, "http://3.bp.blogspot.com/-ooH5HCXV-3M/U-d-RLGxAJI/AAAAAAAAAUQ/zv2C4fX2QME/s1600/school+Days+inanimeshadow.JPG");
		mapRating.put(14, "http://inanimeshadow.blogspot.pt/2014/08/school-days-anime-review.html﻿");
		//Clannad
		mapURL.put(15, "http://2.bp.blogspot.com/-wb6svxKCKpY/U_43b-_novI/AAAAAAAAAVo/KCPrb_JstkM/s1600/clannad_score.png");
		mapRating.put(15, "http://inanimeshadow.blogspot.com/2014/08/clannad-review.html");
		//From the New World
		mapURL.put(16, "http://2.bp.blogspot.com/-wv-rAmS8NIk/VIDKthBP-XI/AAAAAAAAAXQ/vwO9FLoAkOE/s1600/score%2B2.png");
		mapRating.put(16, "http://inanimeshadow.blogspot.com/2014/12/from-new-world-anime-review.html");
		//Log Horizon
		mapURL.put(17, "http://2.bp.blogspot.com/-h5ziXRITIBE/VKgAbFV2lEI/AAAAAAAAAao/40ltc5Dbsgs/s1600/log-horizon-score.png");
		mapRating.put(17, "http://inanimeshadow.blogspot.com/2015/01/log-horizon-review.html");
		//Hanmonogatari
		mapURL.put(18, "http://1.bp.blogspot.com/-_C1g__Xhbl8/VOz6TxABbRI/AAAAAAAAAbE/7VhxDnC-Pmc/s1600/Kanburu_score_2.png");
		mapRating.put(18, "http://inanimeshadow.blogspot.pt/2015/02/hanamonogatari-review-anime-review.html");
		//SAO 2
		mapURL.put(19, "http://2.bp.blogspot.com/-QRvDulGj4jQ/VRCO32msBFI/AAAAAAAAAeA/5TXVTZ9GIFE/s1600/SAO_2_SCORE_.jpg");
		mapRating.put(19, "http://www.inanimeshadow.blogspot.com/2015/03/SAO2.html");
		
		Timer t = new Timer() {
			
			@Override
			public void run() {
				Set<Integer> kset = mapURL.keySet();
				randomValue=Random.nextInt(kset.size());
				System.out.println(randomValue);
				blogImage.setUrl(mapURL.get(randomValue));
				
				
			}
		};
		t.scheduleRepeating(10000);
		
		Set<Integer> kset = mapURL.keySet();
		randomValue=Random.nextInt(kset.size());
		blogImage.setUrl(mapURL.get(randomValue));
		blogImage.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.open(mapRating.get(randomValue), "_blank", "");
			}
		});
//		
		

		quest1.setUrlClue(QuestResources.INSTANCE.getQuestion1().getSafeUri());
		quest1.setUrlQuest(QuestResources.INSTANCE.getHouseMap1().getSafeUri());
		
		quest2.setUrlClue(QuestResources.INSTANCE.getQuestion2().getSafeUri());
		quest2.setUrlQuest(QuestResources.INSTANCE.getHouseMap2().getSafeUri());
		
		quest3.setUrlClue(QuestResources.INSTANCE.getQuestion3().getSafeUri());
		quest3.setUrlQuest(QuestResources.INSTANCE.getHouseMap3().getSafeUri());
		
		quest4.setUrlClue(QuestResources.INSTANCE.getQuestion4().getSafeUri());
		quest4.setUrlQuest(QuestResources.INSTANCE.getHouseMap4().getSafeUri());
		
		quest5.setUrlClue(QuestResources.INSTANCE.getQuestion5().getSafeUri());
		quest5.setUrlQuest(QuestResources.INSTANCE.getHouseMap5().getSafeUri());

		quest6.setUrlClue(QuestResources.INSTANCE.getQuestion6().getSafeUri());
		quest6.setUrlQuest(QuestResources.INSTANCE.getHouseMap6().getSafeUri());
		
		quest7.setUrlClue(QuestResources.INSTANCE.getQuestion7().getSafeUri());
		quest7.setUrlQuest(QuestResources.INSTANCE.getHouseMap7().getSafeUri());
		
		quest8.setUrlClue(QuestResources.INSTANCE.getQuestion8().getSafeUri());
		quest8.setUrlQuest(QuestResources.INSTANCE.getHouseMap8().getSafeUri());

		quest9.setUrlClue(QuestResources.INSTANCE.getQuestion9().getSafeUri());
		quest9.setUrlQuest(QuestResources.INSTANCE.getHouseMap9().getSafeUri());
		quest10.setUrlClue(QuestResources.INSTANCE.getQuestion10().getSafeUri());
		quest10.setUrlQuest(QuestResources.INSTANCE.getHouseMap10().getSafeUri());
		quest11.setUrlClue(QuestResources.INSTANCE.getQuestion11().getSafeUri());
		quest11.setUrlQuest(QuestResources.INSTANCE.getHouseMap11().getSafeUri());
		quest12.setUrlClue(QuestResources.INSTANCE.getQuestion12().getSafeUri());
		quest12.setUrlQuest(QuestResources.INSTANCE.getHouseMap12().getSafeUri());
		quest13.setUrlClue(QuestResources.INSTANCE.getQuestion13().getSafeUri());
		quest13.setUrlQuest(QuestResources.INSTANCE.getHouseMap13().getSafeUri());
		quest14.setUrlClue(QuestResources.INSTANCE.getQuestion14().getSafeUri());
		quest14.setUrlQuest(QuestResources.INSTANCE.getHouseMap14().getSafeUri());
		quest15.setUrlClue(QuestResources.INSTANCE.getQuestion15().getSafeUri());
		quest15.setUrlQuest(QuestResources.INSTANCE.getHouseMap15().getSafeUri());
		quest16.setUrlClue(QuestResources.INSTANCE.getQuestion16().getSafeUri());
		quest16.setUrlQuest(QuestResources.INSTANCE.getHouseMap16().getSafeUri());
		quest17.setUrlClue(QuestResources.INSTANCE.getQuestion17().getSafeUri());
		quest17.setUrlQuest(QuestResources.INSTANCE.getHouseMap17().getSafeUri());
		quest18.setUrlClue(QuestResources.INSTANCE.getQuestion18().getSafeUri());
		quest18.setUrlQuest(QuestResources.INSTANCE.getHouseMap18().getSafeUri());
		quest19.setUrlClue(QuestResources.INSTANCE.getQuestion19().getSafeUri());
		quest19.setUrlQuest(QuestResources.INSTANCE.getHouseMap19().getSafeUri());
		quest20.setUrlClue(QuestResources.INSTANCE.getQuestion20().getSafeUri());
		quest20.setUrlQuest(QuestResources.INSTANCE.getHouseMap20().getSafeUri());
		quest21.setUrlClue(QuestResources.INSTANCE.getQuestion21().getSafeUri());
		quest21.setUrlQuest(QuestResources.INSTANCE.getHouseMap21().getSafeUri());
		quest22.setUrlClue(QuestResources.INSTANCE.getQuestion22().getSafeUri());
		quest22.setUrlQuest(QuestResources.INSTANCE.getHouseMap22().getSafeUri());
		quest23.setUrlClue(QuestResources.INSTANCE.getQuestion23().getSafeUri());
		quest23.setUrlQuest(QuestResources.INSTANCE.getHouseMap23().getSafeUri());
		quest24.setUrlClue(QuestResources.INSTANCE.getQuestion24().getSafeUri());
		quest24.setUrlQuest(QuestResources.INSTANCE.getHouseMap24().getSafeUri());
		quest25.setUrlClue(QuestResources.INSTANCE.getQuestion25().getSafeUri());
		quest25.setUrlQuest(QuestResources.INSTANCE.getHouseMap25().getSafeUri());
		quest26.setUrlClue(QuestResources.INSTANCE.getQuestion26().getSafeUri());
		quest26.setUrlQuest(QuestResources.INSTANCE.getHouseMap26().getSafeUri());
		quest27.setUrlClue(QuestResources.INSTANCE.getQuestion27().getSafeUri());
		quest27.setUrlQuest(QuestResources.INSTANCE.getHouseMap27().getSafeUri());
		quest28.setUrlClue(QuestResources.INSTANCE.getQuestion28().getSafeUri());
		quest28.setUrlQuest(QuestResources.INSTANCE.getHouseMap28().getSafeUri());
		quest29.setUrlClue(QuestResources.INSTANCE.getQuestion29().getSafeUri());
		quest29.setUrlQuest(QuestResources.INSTANCE.getHouseMap29().getSafeUri());
		quest30.setUrlClue(QuestResources.INSTANCE.getQuestion30().getSafeUri());
		quest30.setUrlQuest(QuestResources.INSTANCE.getHouseMap30().getSafeUri());
		
		button1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest1);
				center.clear();
				center.add(gp);
			}
		});

		button2.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest2);
				center.clear();
				center.add(gp);
			}
		});

		button3.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest3);
				center.clear();
				center.add(gp);
			}
		});

		button4.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest4);
				center.clear();
				center.add(gp);
			}
		});

		button5.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest5);
				center.clear();
				center.add(gp);
			}
		});

		button6.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest6);
				center.clear();
				center.add(gp);
			}
		});

		button7.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest7);
				center.clear();
				center.add(gp);
			}
		});

		button8.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest8);
				center.clear();
				center.add(gp);
			}
		});

		button9.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest9);
				center.clear();
				center.add(gp);
			}
		});

		button10.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest10);
				center.clear();
				center.add(gp);
			}
		});

		button11.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest11);
				center.clear();
				center.add(gp);
			}
		});

		button12.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest12);
				center.clear();
				center.add(gp);
			}
		});

		button13.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest13);
				center.clear();
				center.add(gp);
			}
		});

		button14.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest14);
				center.clear();
				center.add(gp);
			}
		});

		button15.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest15);
				center.clear();
				center.add(gp);
			}
		});
		
		button16.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest16);
				center.clear();
				center.add(gp);
			}
		});

		button17.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest17);
				center.clear();
				center.add(gp);
			}
		});

		button18.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest18);
				center.clear();
				center.add(gp);
			}
		});

		button19.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest19);
				center.clear();
				center.add(gp);
			}
		});

		button20.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest20);
				center.clear();
				center.add(gp);
			}
		});

		button21.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest21);
				center.clear();
				center.add(gp);
			}
		});

		button22.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest22);
				center.clear();
				center.add(gp);
			}
		});

		button23.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest23);
				center.clear();
				center.add(gp);
			}
		});

		button24.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest24);
				center.clear();
				center.add(gp);
			}
		});

		button25.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest25);
				center.clear();
				center.add(gp);
			}
		});

		button26.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest26);
				center.clear();
				center.add(gp);
			}
		});
		
		button27.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest27);
				center.clear();
				center.add(gp);
			}
		});
		button28.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest28);
				center.clear();
				center.add(gp);
			}
		});
		button29.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest29);
				center.clear();
				center.add(gp);
			}
		});
		button30.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GamePanel gp = new GamePanel(quest30);
				center.clear();
				center.add(gp);
			}
		});
	}

	
	
}
