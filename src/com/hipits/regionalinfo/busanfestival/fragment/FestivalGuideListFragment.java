package com.hipits.regionalinfo.busanfestival.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hipits.regionalinfo.busanfestival.R;
import com.hipits.regionalinfo.busanfestival.adapter.SectionListAdapter;
import com.hipits.regionalinfo.busanfestival.model.Program;

public class FestivalGuideListFragment extends ListFragment {

	private class StandardArrayAdapter extends ArrayAdapter<Program> {
		private final List<Program> items;
		private Context context;
		private int layoutId;
		private LayoutInflater layoutInflater;

		public StandardArrayAdapter(final Context context, final int textViewResourceId, final List<Program> exampleArray) {
			super(context, textViewResourceId, exampleArray);
			this.context = context;
			this.items = exampleArray;
			this.layoutId = textViewResourceId;
			layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public View getView(final int position, final View convertView, final ViewGroup parent) {
			View view = convertView;

			if (view == null) {
				view = layoutInflater.inflate(layoutId, null);
			}

			final Program currentItem = items.get(position);

			if (currentItem != null) {

				TextView titleTextView = (TextView)view.findViewById(R.id.titleTextView);
				TextView dateTextView = (TextView)view.findViewById(R.id.dateTextView);
				TextView placeTextView = (TextView)view.findViewById(R.id.placeTextView);
				ImageView imageView = (ImageView)view.findViewById(R.id.imageView1);

				titleTextView.setText(currentItem.getTitle());
				imageView.setBackgroundResource(currentItem.getImageViewId());
				
				if (MSG.equals("rock")) {
					dateTextView.setText("내용:" + currentItem.getDate());
				} else {
					dateTextView.setText("일시:" + currentItem.getDate());
					placeTextView.setText("장소:" + currentItem.getPlace());
				}
			}
			return view;
		}
	}

	public static String MSG;
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		showPrograms(inflater);
		return inflater.inflate(R.layout.listview_program, null);

	}

	public void showPrograms(LayoutInflater layoutInflater) {
		List<Program> programs = null;

		if (MSG.equals("port")) {
			programs = getPortDatas();
		} else if (MSG.equals("sea")) {
			programs = getSeaDatas();
		} else if (MSG.equals("sun")) {
			programs = getSunDatas();
		} else if (MSG.equals("rock")) {
			programs = getRockDatas();
		} else if (MSG.equals("flame")) {
			programs = getPortDatas();
		}

		StandardArrayAdapter arrayAdapter = new StandardArrayAdapter(getActivity(),
				R.layout.listview_program_item, programs);
		SectionListAdapter sectionListAdapter = new SectionListAdapter(layoutInflater, arrayAdapter, MSG);
		setListAdapter(sectionListAdapter);
	}

	public List<Program> getSeaDatas() {
		List<Program> retDatas = new ArrayList<Program>();

		String[] seaTitles = {"썸머 빅 콘서트","부산국제 록 페스티벌","부산국제힙합페스티벌","부산국제매직페스티벌 개막쇼",
				"해양레포츠체험","장애인한바다축제","시민참여수박화채콘테스트","썸머 살사의 밤","핀수영 무료 강습회",
				"나도 스타King!","물의난장 워터카니발","몸짱대회 - 다이나믹 바디 콘테스트","현인가요제","열린바다 열린음악회",
				"추억의 7080콘서트","송정해변콘서트","비키 바다영화상영","한국해양문학제","광안비치콘서트","힙합갈라쇼",
				"상해시 기예단 특별공연","부산 Sea & Jazz의 밤","부산스타토크콘서트","한＊일 코미디페스티벌",
				"카스 썸머 콘서트","썸머 치어리더 페스티벌","부산바다콘서트","바다축제 축하비행","부산시장배 전국요트대회",
				"부산시장배 전국윈드서핑대회","부산시장기 시민비치발리볼대회","부산시장배 바다핀수영대회","다대포 해양래프팅대회",
				"부산시장배 조정대회","부산시장배 카누*래프팅대회","부산장애인해양래프팅대회","정운장군배 카이트보딩대회"};

		String[] seaPlaces = {"해운대 해수욕장 특설무대 ","사상구 삼락생태공원",
				"다대포 해수욕장 특설무대","8.2(목):해운대 해변 특설무대,8.2(목)~5(일) 영화의 전당 ","수영만 요트경기장 등",
				"광안리해수욕장","송도 해수욕장","해운대 해수욕장 이벤트 광장","광안리 해수욕장",
				"해운대 해수욕장 이벤트광장","해운대 해수욕장 시민참여무대","해운대 해수욕장 시민참여무대","송도 해수욕장 특설무대",
				"광안리 해수욕장 특설무대","다대포 해수욕장 특설무대","송정 해수욕장 특설무대","광안리 해수욕장",
				"부산예술회관","광안리 해수욕장 특설무대","해운대 해수욕장 특설무대","해운대 해수욕장 이벤트광장",
				"광안리 해수욕장 특설무대","해운대 해수욕장 특설무대","해운대 해수욕장 특설무대","해운대 해수욕장 특설무대",
				"해운대 해수욕장 특설무대","해운대 해수욕장 특설무대","해운대 해수욕장 상공","요트경기장","광안리 해수욕장",
				"광안리해수욕장","광안리해수욕장","다대포해수욕장","광안리해수욕장","서낙동강 카누경기장","광안리해수욕장",
		"다대포해수욕장"};

		String[] seaPates = {"8.1(수)"+"\n시간:" +" 20:00 " ,"8.3(금) ~ 8.5(일)"+"\n시간:" +" 15:00","8.3(금)"+"\n시간:" +" 19:00",
				"8.2(목)"+"\n시간:" +" 20:00 개막행사","8.4(토) ~ 5(일)"+"\n시간:" +" 13:00","8.2(화)"+"\n시간:" +" 11:00",
				"8.2(화)"+"\n시간:" +" 14:00","8.3(금) ~ 4(토)"+"\n시간:" +" 19:30","8.3(금)"+"\n시간:" +" 10:00","8.5(일) ~ 8.6(월)"+"\n시간:" +" 20:00","8.6(월) ~ 8.7(화)"+"\n시간:" +" 13:00, 15:00",
				"8.2(목) ~ 8.5(일)"+"\n시간:" +" 13:00","8.4(토) ~ 8.5(일)"+"\n시간:" +" 20:00","8.9(목) "+"\n시간:" +"19:30","8.4(토)"+"\n시간:" +" 19:00","8.3(금)"+"\n시간:" +" 19:00",
				"8.6(월) ~ 8.7(화)"+"\n시간:" +" 20:00","8.2(목) ~ 8.3(금)"+"\n시간:" +" 19:00","8.8(수)"+"\n시간:" +" 19:30","8.4(토)"+"\n시간:" +" 19:30","8.2(목)"+"\n시간:" +" 20:00",
				"8.4(토) ~ 8.5(일)"+"\n시간:" +" 19:00","8.5(일)"+"\n시간:" +" 19:30","8.9(목)"+"\n시간:" +" 19:30","8.3(금)"+"\n시간:" +" 19:00","8.6(월)"+"\n시간:" +" 19:30",
				"8.7(화)"+"\n시간:" +" 19:30","8.4(토) ~ 8.5(일)"+"\n시간:" +" 14:00","7.28(토) ~ 7.29(일)","7.28(토) ~ 7.29(일)",
				"8.5(일)","8.4(토)","8.4(토)","8.5(일)","8.4(토)","8.9(목)","8.4(토) ~ 8.5(일)"};

		int[] imageViwIds ={R.drawable.s0, R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5, R.drawable.s6, R.drawable.s7,
				R.drawable.s8, R.drawable.s9, R.drawable.s10, R.drawable.s11, R.drawable.s12, R.drawable.s13, R.drawable.s14, R.drawable.s15,
				R.drawable.s16, R.drawable.s17, R.drawable.s18, R.drawable.s19, R.drawable.s20, R.drawable.s21, R.drawable.s22,R.drawable.s23, 
				R.drawable.s24, R.drawable.s25, R.drawable.s26, R.drawable.s27, R.drawable.s28, R.drawable.s29, R.drawable.s30, R.drawable.s31,
				R.drawable.s32, R.drawable.s33, R.drawable.s34, R.drawable.s35, R.drawable.s36};

		for (int i = 0; i < 1 ; i++) {
			retDatas.add(new Program(seaTitles[i], seaPlaces[i], seaPates[i] , imageViwIds[i], "개막행사"));
		}
		for (int i = 1; i < 4 ; i++) {
			retDatas.add(new Program(seaTitles[i], seaPlaces[i], seaPates[i] , imageViwIds[i], "국제행사"));
		}
		for (int i = 4; i < 12 ; i++) {
			retDatas.add(new Program(seaTitles[i], seaPlaces[i], seaPates[i] , imageViwIds[i], "체험행사"));
		}
		for (int i = 12; i < 28 ; i++) {
			retDatas.add(new Program(seaTitles[i], seaPlaces[i], seaPates[i] , imageViwIds[i], "공연행사"));
		}
		for (int i = 28; i < 37 ; i++) {
			retDatas.add(new Program(seaTitles[i], seaPlaces[i], seaPates[i] , imageViwIds[i], "해양스포츠행사"));
		}
		return retDatas;
	}

	public List<Program> getPortDatas() {
		List<Program> datas = new ArrayList<Program>();

		String[] portTitles = {" 부산항 콘서트", "범선 나제다호 공개행사", "넌버벌퍼포먼스 비빔밥 공연", "부산국제힙합페스티벌 예선대회",
				"2012국민체육진흥공단 이사장배 모터보트대회", "부산항 투어(북항)", "세계인의 날 축하행사", "해군-해경 함정 승선체험",
				"부산항가족사랑걷기대회", "크루저 요트 승선체험", "세계민속의상 및 음식체험", "즉석 기념촬영 서비스", "갯마을 바다연극",
				"수상페달보트 체험 & 유로번지 체험", "해양애니메이션 상영","부산항 골든벨","글짓기, 그림대회","해양자연사 탐험","선박항해시뮬레이터 체험", 
				"해양사이언스 체험전", "부산항축제 발전방안 시민 대토론회", "부산항 백과사전", "해양환경 홍보전","모형배&등대만들기", "치어방류체험", 
				"See & Sea 갤러리 특별기획 미술전", "등대체험교실", "시인과 함께 기장 등대길 걷기", "부산항 홍보관", "영남씨그랜트와 함께하는 부산바다전", 
				"유관기관 홍보관", "여수EXPO 홍보관", "부산항의 밤", "항만 직업체험 홍보관", "수산물 명품전 & 사회적기업 제품 홍보전", "항만가족 축구대회",
				"부산항 퍼레이드", "해상특수작전 시연"};

		String[] portPlaces = {"크루즈터미널 특설무대", "크루즈 터미널 부두", "크로즈 터미널 특설무대", "크루즈 터미널 상설무대", "크루즈 터미널 해상",
				"크루즈 터미널 / 해경부두", "크루즈터미널 특설무대", "크루즈터미널,해경부두", "태종대 -> 크루즈 터미널", "한국해양대학교 선착장",
				"크루즈 터미널", "크루즈 터미널", "영도등대 해양문화공간", "크루즈 터미널", "해양환경개발교육원 내 강당", "크루즈 터미널 특설무대",
				"해양경찰서 잔디광장, 해사고등학교 강당", "크루즈 터미널 1층", "한국해양수산연수원 실습관", "크루즈 터미널", "해양환경개발교육원 강당, 누리마루호 선상",
				"해양환경개발교육원 내 강당", "해양환경개발교육원", "크루즈터미널", "크루즈 터미널 친수공간", "영도등대 해양문화공간", "영도등대 해양문화공간",
				"기장 등대길", "크루즈 터미널", "크루즈터미널 2층", "크루즈 터미널", "크루즈 터미널", "범선 나제즈다호 선상", "크루즈 터미널", "크루즈 터미널",
				"영도 마린축구장", "크루즈 터미널 일원", "남해지방해경청, 해경특공대"};

		String[] portDates = {"2012.6.1(금)" + "\n시간:" +" 19:30 ~ 21:45", "2012.6.1(금) 3(일)", "2012.6.2(토)" + "\n시간:" +" 19:30 ~ 21:00",
				"2012.6.3(일)" + "\n시간:" +" 12:00 ~ 17:00", "2012.6.2(토)" + "\n시간:" +" 11:00 ~ 18:00", "2012.6.1(금) ~ 3(일)" + "\n시간:" +"11:00 ~ 19:00",
				"2012.6.2(토)" + "\n시간:" +" 13:00 ~ 15:30", "2012.6.1(금) ~ 3(일)" + "\n시간:" +" 11:00 ~ 18:00", "2012.6.3(일)" + "\n시간:" +" 10:00 ~ 13:00",
				"2012.6.1(금) ~ 3(일) " + "\n시간:" + "11:00 ~ 17:00", "2012.6.2(토)" + "\n시간:" +" 14:00 ~ 18:00", "2012.6.1(금) ~ 3(일)" + "\n시간:" +" 11:00 ~ 18:00",
				"2012.6.2(토)" + "\n시간:" +" 11:00 ~ 12:00, 14:00 ~ 15:00", "2012.6.1(금) ~ 3(일)" + "\n시간:" +" 11:00 ~ 19:00", "2012.6.1(금) ~ 3(일)" + "\n시간:" +" 11:00 ~ 18:00",
				"2012.6.3(일) " + "\n시간:" +" 15:30 (13:00 투어)", "2012.6.2(토)" + "\n시간:" +" 11:00 ~ 15:00","2012.6.1(금) ~ 3(일)" + "\n시간:" +" 13:00 ~ 19:00", "2012.6.2(토) ~ 3(일)" + "\n시간:" +" 13:00 ~ 18:00",
				"2012.6.1(금) ~ 3(일) " + "\n시간:" +" 11:00 ~ 18:00", "2012.6.2(토) " + "\n시간:" +"10:00 ~ 15:50", "2012.6.1(금)" + "\n시간:" +" 14:00 ~ 16:00",
				"2012.6.1(금) ~ 3(일) 11:00 ~ 18:00", "2012.6.1(금) ~ 3(일) 11:00 ~ 18:00", "2012.6.1(금) " + "\n시간:" +"14:30 ~ 15:00",
				"2012.6.1(금) ~ 3(일)", "2012.6.2(토) ~ 3(일)" + "\n시간:" +" 14:00 ~ 16:00", "2012.6.2(토)" + "\n시간:" +" 08:30 ~ 14:30",
				"2012.6.1(금) ~ 3(일)" + "\n시간:" + "11:00 ~ 18:00", "2012.6.1(금) ~ 3(일)"+ "\n시간:" + "11:00 ~ 18:00", "2012.6.1(금) ~ 3(일)"+ "\n시간:" + "11:00 ~ 18:00",
				"2012.6.1(금) ~ 3(일)" + "\n시간:" + "11:00 ~ 18:00", "2012.6.1(금)"+ "\n시간:" + "18:00 ~ 19:20", "2012.6.1(금) ~ 3(일)", "2012.6.1(금) ~ 3(일)"+ "\n시간:" +
						"13:00 ~ 21:00", "2012.6.2(토)"+ "\n시간:" +"10:00 ~ 17:30", "2012.6.1(금)~3(일)", "2012.6.1(금)"+ "\n시간:" + "18:30 ~ 18:50"};

		int[] imageViwIds ={ R.drawable.p0, R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5, R.drawable.p6, R.drawable.p7,
				R.drawable.p8, R.drawable.p9, R.drawable.p10, R.drawable.p11, R.drawable.p12, R.drawable.p13, R.drawable.p14, R.drawable.p15, R.drawable.p16
				,R.drawable.p17, R.drawable.p18, R.drawable.p19, R.drawable.p20, R.drawable.p21, R.drawable.p22, R.drawable.p23, R.drawable.p24, R.drawable.p25
				,R.drawable.p26, R.drawable.p27, R.drawable.p28, R.drawable.p29, R.drawable.p30, R.drawable.p31, R.drawable.p32, R.drawable.p33, R.drawable.p34
				,R.drawable.p35, R.drawable.p36, R.drawable.p37 };

		for (int i = 0; i < 15 ; i++) {
			datas.add(new Program(portTitles[i], portPlaces[i], portDates[i], imageViwIds[i], "부산항 즐기기"));
		}

		for (int i = 15; i < 28 ; i++) {
			datas.add(new Program(portTitles[i], portPlaces[i], portDates[i], imageViwIds[i], "부산항 배우기"));
		}

		for (int i = 28; i < 32; i++) {
			datas.add(new Program(portTitles[i], portPlaces[i], portDates[i], imageViwIds[i], "부산항의역사와미래"));
		}

		for (int i = 32; i < 36; i++) {
			datas.add(new Program(portTitles[i], portPlaces[i], portDates[i], imageViwIds[i], "부산항의 밤"));
		}

		for (int i = 36; i < 38; i++) {
			datas.add(new Program(portTitles[i], portPlaces[i], portDates[i], imageViwIds[i], "부산항 퍼레이드"));
		}
		return datas;
	}
	
	public List<Program> getRockDatas() {
		List<Program> datas = new ArrayList<Program>();
		
		String[] artists = {"James walsh of Star Sailor - 영국",
				"Firehouse - 미국","부활","김경호밴드","갈네리우스 - 일본",
				"노브레인","이한철밴드","검정치마","몽니","내귀에 도청장치(Wiretap)",
				"슈퍼키드(Super Kidd)","Hilary Grist - 케나다","밴드톡식(Bandtoxic)",
				"로맨틱펀치(Romantic Punch)","에브리싱글데이(Evert Single Day)","토다(TODA)",
				"네바다51(NEVADA#51)","게이트플라워즈(Gate Flowers)","과메기(GWAMEGI)",
				"바쇼(The Bashow) - 일본","장미여관(Rose Motel)","포스 플로어 (4Th Floor)",
				"아이씨사이다(ICTCIDER)","엑시즈(AXLZ)","쿠바(CUBA)","휴먼레이스(HUMAN　RACE)",
				"스트라이커스(The Strikers)","야광토끼(Neon Bunny)","다운헬(Down Hell)",
				"고고보이스(GOGOBOYS)","예리밴드(Yery Band)","헤르츠(HERZ)","판다즈(Pandaz)",
				"스카웨이커스(Ska Wakers)","브로큰발렌타인(Broken Valentine)","퍼블릭스테리오(Public Stereo)"	};
		
		String[] contents = {"잉글랜드 위건에서 2000년에 결성된 밴드로써 OASIS와 더불어 최고의 감성모던록 밴드", "밴드결성 20년을 훌쩍 넘은 LA METAL의 교과서 파이어하우스 가장 완성도 있는 ‘LA METAL BAND'",
				"대한민국 록음악 역사의 큰 줄기, 국내의 대표 록발라드로서 새롭게 태어남을 강조하는 의미의 밴드", "보컬리스트, 연주가, 교육자, 프로듀서로서의 한국을 대표하는 두말이 필요가 없는 대한민국의 록 보컬리스트",
				"일본 헤비메탈 부분 부동의 1위 자리를 고수하고 있는 일본 오사카 출신의 밴드", "대중과의 소통을 중요하게 생각하는 4인조 인디펑크밴드, 그들은 록밴드다운 록밴드 ", "데뷔 18주년을 맞이하는 이젠 중견 가수이자 중견 록커로서 대한민국 인디뮤지션의 역사",
				"펑크 록밴드, 웰메이드 파워팝이라 불리는 조휴일이 이끌고 있는 이제는 원맨밴드", "혼성 4인조로 구성된 밴드 ‘몽니’ 감성적이면서 대중적인 브리티쉬 모던록밴드", 
				"록음악의 마술사, 관객들을 일으켜 세우고, 공연 속으로 한없이 빠져들게 만드는 그들만의 마력을 지닌 밴드", "신나고 재치 있는 음악으로 대중에게 다가서며 넓은 팬 층을 확보하고 있는 재치발랄 즐거운 록 밴드",
				"Blues와 Folk를 기반으로 한 다양한 장르와 Modern하고 감성적인 느낌을 표현하고 있는 케나다의 밴드 ", "‘탑밴드’에서 우승한 밴드로 기타와 드럼 2인조로 구성 되어 있다. 얼터너티브+디스코 게러지락을 지향",
				"정말 유쾌한 펀치를 선사하기위해 단순한 멜로디와 편안하고 쉬운 사운드로 일관하는 기분 좋은 밴드", "음악감독으로 활동하고 있는 진정한 실력파 뮤지션이자 성공한 음악가로서 자랑스러운 ‘부산의 싸나이’ 남자밴드",
				"Progressive rock이나 Art rock을 기반으로 한국적인 정서와 소리를 가미해서 독창적인 사운드를 만들어 내는 밴드", "2001년의 강변가요제의 대상을 수상하며 등장한 ‘맛있는 록큰롤 음악 파티’를 보증한 밴드",
				"처절하기도 한 그들의 가사와 멜로디를 시작으로 그 속의 억눌린 심정을 터뜨리는 통쾌한 사운드와 라이브로 이끌어가는 벤드", "한국의 어떠한 헤비뮤직보다도 원초적이고 공격적일 것 이라고 말하는 익스트림 하드코어밴드",
				"일본인 특유의 '간(틈새)이나 공간'을 표현하고자 하는 시의 미학을 추구하는 Japanese Rock", "탑밴드 최고의 이슈메이커, 뼈저린 공감 재미있는 가사로 인디밴드의 돌풍을 몰고 있는 '장미여관'",
				"빈틈없는 강한사운드로 가슴을 때리면서도 아름다운 멜로디와 애수에 젖은 보컬이 매력을 담아내는 대중과 소통 하는 록밴드", "톡톡쏘는 사이다의 거품처럼, 청량한 개그를 녹인 사운드, 장르와 틀을 벗고 관객들에게 서비스하는 밴드",
				"일본의 대형 소속사와 계약이 체결되어 19세 동갑내기로 이루어진 아이돌 밴드의 시작을 알리는 슈퍼루키 밴드", "송용진과 이정우를 주축으로 시작한 정교하고 화려한 기타플레이로 유명한 이정우의 플레이가 기대되는 밴드", "현시대의 인간적인 감성, 서로를 감동시키는 보이스, 실력으로 만들어진 안정감 있는 사운드와 감성을 지닌 밴드",
				"특유의 멜로디와 어그레시브한 사운드로 일본 전역에 뿌려진 데뷔작이 화제를 모은 멜로펑크 밴드", "밴드 검정치마의 건반 연주자였던 야광토끼, 심플한 비트에 쉽지만 단조롭지 않은 적당한 반복과 세련미를 가진 사운드의 매력", 
				"강렬한 질주의 정통 헤비메탈 밴드", "경쾌한 기타와 댄서블한 리듬으로 음악적 연출과 구성에 심혈을 기울인4인조 빈티지 개러지 록밴드", "대중성을 바탕으로 한 철저한 상업적인 음악으로 승부하겠다는 강한의지로 뭉친 걸그룹", "‘심장’이라는 뜻을 가진 이름의 부산 록음악의 기대주 밴드 ",
				"‘폭발 일보직전의 헤비함과 아름다운 감성의 공존‘ 파워그루브 헤비니스 밴드 ", "남녀노소 구분 없이 ‘시대의 철학을 소통하는,겉치레 보다는 함께하는 음악 스카’를 기본정신으로 항상 노력하는 8인조 부산밴드 ", "엄청난 무대 장악력을 가진 2008년 YAMAHA가 주최하는 Asianbeat Grand Final의 영애의 대상수상자",
				"일렉트로 댄스음악과 록음악의 다중성과 절대 부족하지 않은 비쥬얼과 완벽한 보컬구성으로 무장한 록밴드"};

		int[] imageViewIds = {R.drawable.r0, R.drawable.r1, R.drawable.r2, R.drawable.r3,
				R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7, R.drawable.r8,
				R.drawable.r9, R.drawable.r10, R.drawable.r11, R.drawable.r12, R.drawable.r13,
				R.drawable.r14, R.drawable.r15, R.drawable.r16, R.drawable.r17, R.drawable.r18,
				R.drawable.r19, R.drawable.r20, R.drawable.r21 ,R.drawable.r22, R.drawable.r23,
				R.drawable.r24, R.drawable.r25, R.drawable.r26, R.drawable.r27, R.drawable.r28,
				R.drawable.r29, R.drawable.r30, R.drawable.r31, R.drawable.r32, R.drawable.r33,
				R.drawable.r34, R.drawable.r35};
		
		for (int i = 0; i < 36; i++) {
			datas.add(new Program(artists[i], " ", contents[i], imageViewIds[i], "부산국제록페스티벌 라인업"));
		}
		return datas;
	}

	public List<Program> getSunDatas() {
		String[] titles = new String[]{"시민의 종 타종식", "임진년 해맞이"};
		String[] dates = new String[]{"2011.12.31(토)" + "\n시간" + "23:30 ~ 00:30", "2012.1.1(일)" + "\n시간" + "06:30 ~ 08:00"};
		String[] places = new String[]{"용두산 공원", "해운대 해수욕장"};
		Integer[] imageViewId = new Integer[]{R.drawable.sun0, R.drawable.sun1};

		List<Program> programs = new ArrayList<Program>();
		
		for (int i = 0; i < places.length; i++) {
			programs.add(new Program(titles[i], places[i], dates[i], imageViewId[i], "해맞이 축제"));
		}
		
		return programs;
	}

	public List<Program> getFlameDatas() {
		String[] titles = new String[]{};
		String[] dates = new String[]{};
		String[] places = new String[]{};
		Integer[] imageViewId = new Integer[]{};
		
		List<Program> programs = new ArrayList<Program>();
		
		for (int i = 0; i < titles.length; i++) {
			programs.add(new Program(titles[i], places[i], dates[i], imageViewId[i], "section"));
		}
		return programs;
	}
}

