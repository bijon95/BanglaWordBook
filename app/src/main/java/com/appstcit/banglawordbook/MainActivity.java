package com.appstcit.banglawordbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;
    AdRequest adRequest;
    int addCount = 1 ;
    AdView mAdView;
    String[] educationenglish={"Admission","Answer","Atlas","Bell","Bench","Blackboard","Book","Chair","Chancellor","college","Demonstrator","Examination","Exercise book","Fee","Fine","Fountain pen","Globe","Gymnasium","Hall","Headmaster","Hostel","Ink","Leave","Lesson","Library","Map","Medal","Nib","Paper","Pen","Pencil","Playground","Poem","Poetry","Principal","Prize","Professor","Prose","Pupil","Question","Recess","Result","School","Slate","Student","Subject","Table","Transfer","Tution","Tutor","University","Vacation","Vice-chancellor"};
    String[] educationbangla={"প্রবেশাধিকার","উত্তর,জবাব","মানচিত্রাবলী","ঘণ্টাধ্বনি","কাঠের বা পাথরের তৈরি লম্বা আসন,বিচারকের আসন","বিদ্যালয়ে লিপির জন্য তক্তা","বই","কেদারা,সভাপতির পদ","আচার্য","কলেজ,মহাবিদ্যালয়","সক্রিয় অংশগ্রহণকারী,প্রদর্শনকারী","পরীক্ষা,অনুসন্ধান","অনুশীলনের বই","পারিশ্রমিক","জরিমানা","ঝর্ণা কলম","পৃথিবী","ব্যায়ামাগার","ছাত্রাবাস","বিদ্যালয়ের প্রধানশিক্ষক","ছাত্রাবাস","কালি","ত্যাগ","পাঠ","গ্রন্থাগার","মানচিত্র","পদক","কলমের নিব","কাগজ","লেখনী","পেন্সিল","খেলার মাঠ","কবিতা","কবিতা","অধ্যক্ষ","পুরস্কার","অধ্যাপক","গদ্য","চক্ষুর তারা","প্রশ্ন","ছুটি","ফল","বিদ্যালয়","সিলিট্-পাথর","শিক্ষার্থী","বিষয়","ডেস্ক,সারণী","হস্তান্তর","শিক্ষাদান","গৃহশিক্ষক","বিশ্ববিদ্যালয়","অবকাশ","উপাচার্য"};
    String[] Cornsenglish={"Autumn paddy","Bran","Corn","Dust","Ear","Grain","Gram","Greengram","Husk","Lentil","Linseeds","Maize","Millet","Mustard" ,"Paddy","Pea","Pigeon pea","Pulse","Rape seed","Seasame" ,"Wheat","Winter paddy"};

    String[] Cornsbangla = {"শ্রত ধান","ভুষি","শস্য,ভুট্টা","ধুলি,গুড়া","কান","শস্য,শস্যের দানা","ছোলা ","কলাই" ,"শস্যের খোসা,তুষ","মসূর" ,"তিসি","ভূট্টা" ,"জোয়ার জনাব","রাই-সরষে","ধান","মট্‌কলাই", "অরহর ডাল", "কলাই ডাল","রাইসরিষা", "তিল", "গম", "শীতকালীন ধান"};

    String[] mathbangla = {"সংকলন,যোগ","বীজগণিত","দশমিক","যে বা যাহা ভাগ করে",
        "বিভাগ","ভগ্নাংশ","জ্যামিতি","পূণ সংখ্যা","গুনণ,গুন","শতকরা হার","জটিল সমস্যা","ভাগফল","অনুপাত,হার","অবশিষ্ট,বাকী,ভাগশেষ","সরল","বিয়োগ","উপপাদ্য বা প্রতিজ্ঞা"};
    String[] mathenglish = {"Addition","Algebra","Decimal","Divider","Division","FractionGeometry","Integer","Multiplication","Percentage","Problem","Quotient","Ratio","Remainder","Simplex","Substruction","Theorem"};

    String[] shaprebangla={"পাশবতী,আসন্ন","বৃত্ত,পরিধি","ঘনক","সমদূরবতী", "জেএফকে", "সমদূরবত্রী","সমদ্বিবাহু","অস্টভূজ এবং অস্টকোণ সমতল ক্ষেত্র",
            "ডিম্বাকার","সমান্তরাল","পঞ্চভূজ সমতল ক্ষেত্র","বহুভূজ-ক্ষেত্র",
            "বহুতলক","মিসরদেশীয় ত্রিপাশ্ব বিশিষ্ট প্রাচীন পিরামিড",
            "চতুভূজ","আয়তক্ষেত্র","সামান্তরিক","অসমভূজ","গোলাকার","পাক-খাওয়া,পেচাল","বগাকার ক্ষেত্র","যে চতুভূজের মাত্র দুইটি বাহু সমান্তরাল","ত্রিভূজ"};
    String[] shapeenglish={"Adjacent","Circle","Cube","Equiangular","Equidistance","Equidistant","Isosceless","Octagon","Oval","Parallel","Pentagon","Polygon","Polyhedron","Pyramid","Quadrilateral","Rectangle","Rhombus","Scalene","Spherical","Spiral","Square","Trapezium","Triangle"};
String[] fruitbangla={"Apple","Banana","Berry","Blackberry","Citron","Coconut","Date","Fig","Flesh","Grape","Guava","Jackfruit","Mango","Olive","Orange","Palm","","Papaw","Peach","Pear","Pineapple","Pistachio","Plantain","Plum","Pomegranate","Raisin","Rind","Stone","Tamarind","Walnut","Watermelon"};
    String[] fruitenglish={"আপেল ফল","্কলা","বেরি","কালজামজাতীয় ফল", "জামির","নারিকেল","তারিখ","ডুমুর বা ডুমুর গাছ","প্রানীদেহের মাংস", "আঙ্গুর","পেয়ারা","পনস","আম","জলপাই","কমলালেবু","তাল জাতীয় গাছ","পেঁপে গাছ","পীচ ফল ও গাছ","নাশপাতি ফল", "আনারস","পেস্তা","কলা","কুল","ডালিম","কিসমিস","খোসা","পাথর","তেঁতুল","আখরোট","","তরমুজ"};

String[] Spicesbangla={"গোলমরিচ","কপূর","এলাচি","খয়ের","লংকা","দরুচিনি","রাঁধুনি","কাবাবচিনি","জিরা বীজ","রসুন","আদা","কাঁচা মরিচ","একজাতীয় গুল্ম","প্রভূত্বের চিহ্ন স্বরুপ দন্ড","কস্তুরী","জায়ফল","পেঁয়াজ","পোস্তদানা","জাফরান","হলুদ"};
    String[] Spicesenglish= {"Black pepper","Camphor","Cardamom","Catechu","Chili","Cinnamon","Cook","Cubeb","Cumin seed","Garlic","Ginger","Green chili","Liiquorice","Mace","Musk","Nutmeg","Onion","Poppy seed","Saffron","Turmeric"};
String[] geographybangla={"অ্যান্টাকটিকা","সুমেরু সম্বন্ধীয়",
        "অক্ষ","জলপাত্র,গামলা","উপসাগর","সমুদ্রতীর","ক্রত্তিম খাল","গুহা","খাল","খাড়া উঁচু পাহাড়","সমুদ্রতীর উপকূল","ফলের শাঁস",
        "ষাঁড়ি","প্রবাহমান","প্লাবন","মরুভূমি","ভূমিকম্প","ঘূনিজল","বিষুবরেখা","উবে যাওয়া",
        "বন","ভূগোলবিদ্যা উপসাগর","পাহাড়","টিলা","দিগন্ত হি্মশৈল","দ্বীপ","হ্রদ","ভূমি", "অক্ষাংশ","বিদ্যুত বিজলী","দ্রাঘিমা","জলাভূমি","তৃণবহুল পশুচারণভূমি",
        "আকর","পর্বত","কোদা","সমাবরণ","মহাসাগর","কক্ষ","শিখর","সহজ","মালভূমি",
        "দীর্ঘ নলাকার","সমুদ্রে ডোবা পাহাড়ের চূড়া",
        "আবতন","মহাসাগর","উপকূল","পলিমাটি","তুষার","লাফিয়ে ওটা","নদী প্রবাহ","উপমহাদেশ","বাজ", "করদ","উপত্যাকা","আগ্নেয়গিরি","জল্প্রপাত","বনভূমি","সু-বিন্দু"};
    String[] geographyeglish={"Antarctica","Arctic","Axis","Basin","Bay","Beach","Canal","Cave","Channel","Cliff","Coast","Core","Creek","Current","Delta","Desert","Earhquake","Eddy","Equator","Evaporate","Forest","Geography","Gulf","Hill","Hillock","Iceberg","Island","Lake","Land","Land","Latitude","Lighting", "Longitude","Marsh","Meadow","Mine","Mountain","Mud","Occultation","Ocean","Orbit","Peak","Plain","Plateau","Pole","Reef","Revolution","Rock","Rotation","Sea","Shore","Silt","Snow","Spring","Stream","Subcontinent","Thunder", "Thunder","Tributary","Valley","Volcano","Waterfall", "Woodland","Zenith"};
String[] weatherenglish={"Air","Autumn","Climate","Cloud","Cold","Draught","Fog","Frost","Gale","Hail","Humid","Lighting","Monsoon","Rain","Smog","Snow","Spring","Strom","Summer","Thunder","Weather","Wind","Winter"};
    String[] weathebangla={"বায়ু","শরতকাল","আবহাওয়া","মেঘ","শীতল","একচুমুক","ঘন কুয়াশা","তুষারকণা","ঝড়","অভিবাদন","আদ্র, ভিজা","বিদ্যুত বিজলী","মৌসুমি বায়ু","বষ্টি","ধোয়া ও কুয়াশার মিশ্রন","তুষার","লাফিয়ে ওটা","ঝড়","গ্রীষ্মকাল","বাজ","আভহাওয়া","বাতাস","শীতকাল"};

String[] sciencebangla={"ফলিত জোতিষশাস্র","রোগ জীবানু","জীব বিদ্যা","যে উপাদানে পাতার রং সবুজ হয়","ক্লোন","সারস","ক্রমবিকাশ","যন্ত্রবিশেষ","ঘর্ষন","রসায়ানাগার","আয়নাযুক্ত যন্ত্রবিশেষ","াআলোকরেখা","বিকর্ষন","গবেষনা","যন্ত্রমানব","উপগ্রহ","জলের নিচে চলাচল ্করতে পারে এমন","শব্দের গতি অপেক্ষাও বেশি গতিশীল এমন ","প্রযুক্তিবিদ্যা","কিছুর ব্যাখ্যা,তত্ত্ব","গবেষনামূলক প্রবন্ধ"};
    String[] scienceenglish={"Astrology","Bactria","Biology","Chlorophyll","Clone","Crane","Evalution","Forceps","Friction","Laboratory","Periscope","Ray","Repulsion","Research","Robot","Satellite","Submarine","Supersonic","Technology","Theory","Thesis"};
String[] stateandGovtBangla={"শাসক","রাজদূত","অরাজকতা","বিধানসভা","একনায়কতন্ত্র","মন্ত্রিসভা","প্রধান","নাগরিক","নগর","পাহারাওয়ালা","সংবিধান","কাউন্সিলর","দেশ","রাজসভাসদ","গনতন্ত্র","আমানতকারী","জেলা","বিভাগ","নির্বাচন","সম্রাট","সাম্রাজ্য","সম্রাজ্ঞী","অর্থমন্ত্রী","সরকার","রাজ্যপাল","রাজা","রাজ্য","সদস্য","সরকারপক্ষীয়","মন্ত্রীবর্গ","রাষ্ট্রশাসক", "রাজতন্ত্র","রাজবাড়ি","সংসদ লোকসভা","আত্মরক্ষা বাহিনী","প্রধান প্রথম","রাষ্ট্রপতি","রাজকুমার","রাজকুমারীদের","প্রচার","প্রদেশ","রানী","গনরাজ্য","রাষ্ট্রবিপ্লব","শাসক","সচিব","অবস্থা","উপ-মহাদেশ","প্রজা","রাজাসন","শহর","মিলন","বড়লাট","গ্রাম","ভোটদাতা"};
    String[] stateAndGovEnglish={"Administrator","Ambassador","Anarchy","Assembly","Autocracy","Cabinet","Capital","Citizen","City","Constable","Constitution","Councillor","Country","Coutier","Democracy","Deposition","District","Division","Election","Emperor"," Empire","Empress","Finance Minister","Government","Governor","King","Kingdom","Member","Minister","Ministry","Monarch"," Monarchy", "Palace","Parliament","Police","Premier","President","Prince","Princesses","Proclamation","Province","Queen","Republic","Revolution","Ruler","Secretary","State","Subcontinent","Subdivision","Subject","Throne","Town","Union","Vicroy","Village","Voter"};
String[] lawandcoartenglish={"Accused","Acquittal","Advocate","Appeal","Arbitrator","Argument","Attachment","Attorney","Auction","Bail","Banishment","Barrister","Bond","Bribe","Case","Charge","Cheating","Claim","Client","Complainant","Compromise","Contact","Court","Dacoity","Decision","Decree","Defenant","Deposition","Dismissal","Dock","Document","Fine","Forgery","Fraud","Hanging","Hearing","Homicide","Imprisonment","Injunction","Injury","Issue","Jail","Judgement","Juror","Justice","Law","Lease","Limitation","Murder","Oath","Offence","Office","Officer","Party","Peon","Perury","Persection","Petition","Plaint","Pleader","Prisoner","Prosecution","Punishment","Record","Right","Riot",
        "Robbery","Secuirity","Sentence","Session","Statement","Suicide","Summons","Surety","Theft","Transportation","Trial","Warrant","Whipping","Witness" };
    String[] lowandcoartbangla={"অভিযুক্ত","আদালতের বিচারে খলাস","উকিল","আবেদন করা","সালিশ","যুক্তি","আসক্তি","আমমোক্তার","নিলাম","জামিন","বিতাড়িতন","ব্যারিস্টার","বন্ধনি","ঘুঁষ","আদালতে নালিশ","আক্রমন করা","ছেঁচড়ামি","দাবি","খরিদ্দার","বাদী","মীমাংসা","চুক্তিবদ্ধ করা","বিচারালয়","ডাকাতি","সিদ্ধান্ত","রায়","প্রতিবাদী","নিবাসিত করা","আমানতকারী","অপসারণ","জাহাজ ঘাট","দলিল", "সুন্দর","জালবাজি","জুয়াচুরি","ফাঁসি","শ্রবণ","নরহত্যা","কারাবাস","্নিষাধাথক  হুকুম","আঘাত","নির্গত বা বহির্গত", "কারাগার","বিচার","জুরিবর্গ", "ন্যায়বিচার","নিয়ম,আইন","ইজারা","সীমানা","খুন","হলফ","পাপ","দফতর","াআধিকারিক","দল","পেয়াদা","", "াআদালতে মিথ্যা সাক্ষদান","নিগ্রহ","দরখাস্ত","আরজি","উকিল","কারাবন্দী","বিচার","শাস্তি","লিপিবদ্ধ্","সঠিক","হট্টগুল","লুঠন","জামিন","বাক্য","অধিবেশন","উক্তি","আত্মহত্তা","সমন","নিশ্চয়","চুরি","নির্বাসন", "বিচার","হুকুমনামা","চাবুকের আঘাত","প্রমাণ"} ;
String[] measurmentbangla={"অঞ্চল","আঁড়","গভীরতা","পায়ের পাতা","দুইশ বিশ গজ","ছোলা","উচ্চতা","ইঞ্চি","দৈঘ্য মাপ","মণ","আকার","পরিমাপক","দুরত্বের পরিমাপ","ওজন পরিমা","সের","বেধ","ওজন","প্রস্থ","এক গজ"};
    String[] measurmentenglish={"Area","Breadth","Depth","Foot","Furlong","Gram","Height","Inch","Length","Maund","Measure","Meter","Mile","Pound","Seer","Thickness","Weight","Width","Yard"};
String[] postalTermsEnglish={"Address","Addressee","Envelope","Letter","Mail","Packet","Parcel","Payee","Post","Post office","Post-man","Postage","Posting","Postmaster","Registration","Remitter","Telegram"};
    String[] postalTermsBangla={"ঠিকানা","প্রাপক","খাম","চিঠি","ডাকে পাঠানো চিঠিপত্র","প্যাকেট","মোড়ক","পাওনাদার","খুঁটি","ডাকঘর","পিয়ন","ডাক মাশুল","ডাকে দেওয়া","পোস্টমাস্টার","নথিভূক্তিকরন","অর্থপ্রেরক", "টেলিগ্রাম"};
String[] tradebangla={"দাড়ি পাল্লা","বস্তা","ব্যবসায়ী","নগদ","বানিজ্য","চুক্তিবদ্ধ করা","ঠিকাদার","দাম","জমা","জমা রাখা","দ্বন্ধ যুদ্ধ","ব্যয় খরচ","মালপত্র","মুদি","য়াআমদানী করা","আয়","ধার দেওয়া জিনিস","বাজার","বেতন","ক্রয় করা","বিক্রয়","নমুনা","মাপনী","দোকান"," দোকানদার","ছোট দোকান","কাগজ,কলম ইত্যাদি","কাগজ,কলম","ব্যবসায়","ব্যবসায়ী"};
    String[] tradeenglish={"Balance","Bale","Businessman","Cash","Commerce","Contract","Contractor","Cost","Credit","Deposit","Due","Expenditure","Goods","Grocer","Import","Income","Loan","Market","Pay","Purchase","Sale","Sample","Scale","Shop","Shopkepeer","Stall","Stationer","Stationary","Trade","Trader"};
String[] dayMonthEnglish={"Afternoon","Age","Birthday","Country","Date","Dawn","Day","Decade","Dusk","Era","Evening","Everyday","Forenoon","Fornight","Hour","instant","Midday","Midnight","Minute","Moment","Month","Morning","Morrow","Night","Noon","Proximo","Second","Sundown","Sunrise","Sunset","Time","Today", "Tomorrow","Twilight","Ultimo","Week","Year","Yesterday"};
    String[] dayMonthBangla={"বিকালবেলা","বয়স","জন্মদিন","দেশ","তারিখ","ঊষা","দিন","দশক","গোধূলি","যুগ","সন্ধাকাল","প্রতিদিন","পূর্বাহ্ন", "দু’স্পতাহ","ঘন্টা","তাৎক্ষনিক", "দুপুর","মধ্যরাত্রি","মিনিট","নিমেষ","মাস","প্রভাত","পরদিন","রাত","দুপুরবেলা","আগামী মাসের","মধ্যম","সূর্যাস্ত", "সূর্যোদয়","সূর্যাস্ত", "সময়","আজ", "আগামীকাল","ঊষাকাল","গত মাসের","সপ্তাহ","বছর","গতকাল"};
String[] medicineBangla={"ক্ষত স্থানাদি বাঁধার পট্রি","বোতল","ঔষধ মিশ্রনকারী","আরোগ্য,প্রতিকার,ঔষধ","দাঁতের চিকিৎসক","দাঁতের চিকিৎসকের পেশা বা বিদ্যা","পথ্য","ঔষধালয়,ঔষধ-বিতরন কেন্দ্র","ডাক্তার","বস্র","ফোঁটা,যাবনিকা","ভেষজ","টেনে বা নিংড়ে তোলা","কবল","দাগ,চিহ্ন,নিশানা","ঔষধ,ভেষজ,চিকিৎসাশাস্র","ধাত্রী,ধাই","ধাত্রীবিদ্যা,প্রসুতিশাস্র","কাজ বা সক্রিয়তা,অস্ত্রপচার","সহিষ্ণু ধৈর্যশীল,রোগী","শিশি","চিকিৎসক,বৈদ্য,ডাক্তার","ঔষধের বড়ি","পুলটিস,ক্ষত বাঁধার নরম ও গরম প্রলেপ","গুঁড়া,পাউডার","রেচক","অস্রচিকিৎসক,সার্জন","অস্রচিকিৎসা,অস্রচিকিৎ্কের রোগী দেখার ঘর","তক্তা বা ফলক,চাকতি,(ঔষধের)বড়ি(লেখা ইত্যাদি খোদাই করা)","তাপমাত্রাযন্ত্র,থার্মমিটার","আচরণ,চিকিৎসা"};
    String[] medicineEnglish={"Bandage","Bottle", "Compounder", "Cure", "Dentist", "Dentistry", "Diet", "Dispensary", "Doctor", "Dressing", "Drop", "Drug", "Extracth","Gurgling", "Mark", "Medicine", "Midwife", "Midwifery", "Operation", "Patient", "Phial", "Physician", "Pill", "Poultice", "Powder", "Purgative", "Surgeon", "Surgery", "Tablet", "Thermometer", "Treatment"};
String[] globalPoliticsEnglish={"Cabinet", "Centrist", "Chauvinist", "Community", "Consensus", "Constitution", "Critic", "Depose", "Dictatorship", "Diplomat", "Disarmament", "Domain", "Elite", "Espionage", "Gnash", "Illiteracy", "Imperialist", "Impose", "Infrastructure", "Intellectual", "Manipulate", "Massacre", "Monarchy", "Opposition", "Pessimisms", "Polls", "Rebellion", "Recession", "Regime", "Slum", "Slum", "Throne", "Totalitarian", "Tyrant", "Utopia", "Veto", "Volunteer", "Vote"};
    String[] globalPoliticsBangla={"মন্ত্রিসভা,দেরাজ-আলমারি,ছোট কামরা গৃহ","মধ্যস্থতাবাদী","উগ্র জাতীয়তাবাদী,উৎ্‌কট স্বদেশভক্ত","সম্প্রদায়,যৌথ অধিকার","অধিকাংশের মত,ঐক্যমত্য,সংখ্যাগরিষ্ঠের মত,সর্বসম্মতি","গঠন বা ধাত,সংবিধান,শাসনতন্ত্র","সমালোচক,নিন্দুক","গদিচ্যুত করা","একনায়কতন্ত্র","কূটনীতি বিদ","নিরস্ত্রীকরণ","রাজ্য","পসেরা লোকজন,উচ্চবর্গের লোক","গোয়েন্দাগিরি,গোয়েন্দা নিয়োজন","কিডমিড করা(দাঁত)","নিরক্ষরতা,পটনের অক্ষমতা","সাম্রাজ্যবাদী","স্তাপন করা (কারও ওপর কোন কিছু)","পরিকাঠামো,সামরিক বা অন্যান্য সক্রিয় উদ্যোগের বনেদসরূপ স্তায়ি কাঠামো","বুদ্ধিগত,বুদ্ধিমান","নিপুণভাবে নাড়াচড়া করা,কৌশল বশে আনা","বাছবিচার না করে নৃশংস","রাজতন্ত্র","প্রতিরোধ,প্রতিকূলতা,বিরোধী দল","হতাশা","মাথার চুল","বিদ্রোহচারণ,বিদ্রোহ(সশস্ত্র)","পিছনদিকে সরে যাওয়া,বাজারের ক্রিয়াক্রকর্মে শিথিলভান","শাসনতন্ত্র,সরকার","ঘিসি,বস্তি","সিংহাসন,রাজাসন","যে রাষ্ঠ্রে কোন প্রতিদ্বন্দী রাজনৈতিক দলের স্থান নাই এইরূপ,সর্বগ্রাসী","অত্যাচারী শাসন,প্রজাপীড়ক,উৎপীড়ক","আদর্স সামাজিক এবং রাজনৈতিক ব্যবস্তা সমন্বিত কাল্পনিক স্তান,কল্পরাজ্য","কল্পস্বর্গ,রামরাজ্য,স্বপ্নরাজ্য","প্রতিষেধ,নিষেধ","স্বেচ্ছাসেবক","নির্বাচনে মতামত দেওয়া,ভোট দেওয়া"};
String[] warWeaponBangla={"তীর","কামান বাহিনী","খেলার বল,এক প্রকার নাচ","যুদ্ধ করা,কঠোর প্রচেষ্ঠা করা","নত করা","শিঙ্গা","সমিতি,ক্লাব","ছোরা,ছোরা চিহ্ন","পরাভূত করা","প্রতিরক্ষা","ঢাক","পতাকা","দুর্গ,গড়","পদাতিক সৈন্যবাহিনী","রাষ্ট্রীয় নৌ বাহিনী,নৌশক্তি","পিস্তল","তৃণ,শিহরিত হওয়া","পশ্চাদপসরণ করা,হটে যাওয়া","উন্মত্ত জনতা,ছত্রভঙ্গ","যন্ত্র-ত্রাণ","খোলা,কামানের গোলা","গুলি ছোঁড়ার শব্দ,নিক্ষিপ্ত গুলি","গুপ্তচর,গোয়েন্দা","তরবারি,অসি","পুকুর,জলাধার","তাঁবু","জয় করা"};
    String[] warWeaponEnglish={"Arrow","Artillery","Ball","Battle","Bow","Bigle","Club","Dagger","Defeat","Defence","Drum","Flag","Fort","Infantry","Navy","Pistol","Quiver","Retreat","Rout","Sheild","Shell","Shot","Spy","Sword","Tank","Tent","Win"};
String[] menandWomanBangla={"অবিবাহিত পুরুষ,বিশ্ববিদ্যালয়ের স্নাতক","বালক","ঘুঁষ","বিয়ের পাত্র","ছেলেমেয়ে,শিশুরা,সন্তানরা","কাপুরুষ","সম্ভ্রান্তা বা সদবংশীয় ব্যক্তি","বালিকা,কুমারী মেয়ে","নিমন্ত্রিত ব্যাক্তি,অতিথি","বীরপুরুষ,নায়ক","নায়িকা","ভদ্রমহিলা","বালিকা,মেয়ে","পুরুষ জাতীয় পুরুষ মানুষ","মানুষ","প্রভু,শিক্ষক","কৃপণ","গৃহকর্মী,গৃহিনী","ব্যক্তি লোক","চাকর,ভৃত্য","ক্রীতদাস","অবিবাহিতা মেয়ে,কুমারী","বিধবা","বিপত্নীক,মৃতদার পুরুষ","নারী,রমণী,স্ত্রীলোক"};
    String[] menAndWomenEnglish={"Bachelor","Boy","Bribe","Nridegroom","Children","Coward","Gentleman","Girl","Guest","Hero","Heroine","Lady","Maid","Male","Man","Master","Miser","Mistress","Person","Servant","Slave","Virgin","Widow","Windower","Woman"};
String[] limbsMenBangla={"উদর,তলপেট","মল,পায়ের গোছ","পায়ু,মলদ্বার","বৃহৎ নৌকা বিশেষ","বগল","ধমনী","পিঠ,পশ্চাদ্দিক","শিরদাড়া,মেরুদন্ড","দাড়ি,শ্মশ্রু","উদর,তলপেট","পাচকরস","মূত্রাশয়","হাঁড়","নাড়ি ভুড়ি","মগজ","বুক","নিঃশ্বাস-প্রঃশ্বাস","গাল,গন্ড","সিন্দুক,বক","চিবুক,থুতনি","কান,কর্ণ","কনুই","মলমূত্রাদি","চোখ,অক্ষি","মুখমন্ডল,মুখোমুখি","মোটা,স্থুলকায়","মুঠো,মুষ্টি","প্রাণিদেহের মাংস,দৈহিক কামনা","পায়ের পাতা,দৈঘ্যের পরিমাণ","কপাল","দৃঢ়মুষ্টি,হাতল","কটিসন্ধি,কুঁচকি","দাঁতেরমাড়ি,আঠা","চুল,লোম","মাথা,কর্তা,শীর্ষদেশ","হৃৎপিন্ড,হৃদয়","গোড়ালি","নাড়িভূঁড়ি","চোয়াল,চোয়ালের হাড়","জোড়,গাঁট","মূত্রগ্রন্থি,বৃক্ক","কোল,ক্রোড়া","পা","অঙ্গ,প্রতঙ্গ","অধর,ঠোটঁ","কলিজা,যকৃত","কোমর","শ্বাসযন্ত্র","মজ্জা,শ্বাঁস","মন,স্মৃতি","গোঁফ,মোচ","মখগহবর,মুখ","মাংসপেশী","নখ,পেরেক","মধ্যস্থল,কেন্দ্র বিনু","নাক,নাসিকা","নাসারন্ধ্র","তালু,টাকরা","নাড়ীর স্পন্দন নাড়ী,কলাইডাল","শিষ্য,ছাত্র","পুঁজ,ঘা","মলনালী,গুহ্যদ্বার","পাঁজরার দমত বস্তু","বামহাতের অনামিকা","লালা,থুথু","পা,পায়ের নলা","কাঁধ","কঙ্কাল","ত্বক,চামড়া","মাথার খুলি,করোটি","কফ,শিকনি","পদতল,জুতার তলি","আত্মা,অহং","থুক,থুথু","প্লীহা,পিলে","পাকস্থলী,পেট","বসার টুল,চৌকি","ঘাম,কঠোর শ্রম","চোখের জল,অশ্রু","উরু বা উরুদেশ","কন্ঠ,কন্ঠনালী,কল্লা","পায়ের আঙুল","জিহবা ভাষা","দাঁত","প্রস্রাব,মূত্র","আলজিহবা","কন্ঠস্বর,স্বর","কোমর,কটি","গর্ভ,জরায়ু"};
    String[] limbsMenEnglissh={"Abdomen","Ankle","Anus","Arm","Armpit","Artery","Back","Backbone","Beard","Belly","Bile","Bladder","Bone","Bowels","Brain","Breast","Breath","Cheek","Chest","Chain","Ear","Elbow","Excrete","Eye","Face","Fat","Fish","Flesh","Foot","Forehead","Grip","Groin","Gum","Hair","Head","Heart","Heel","Intestine","Jaw","Joint","Kidney","Lap","Leg","Limp","Lip","Liver","Loin","Lungs","Marrow","Mind","Moustache","Mouth","Muscle","Nail","Navel","Nose","Nostril","Palate","Pulse","Pupil","Pus","Rectum","Rip","Ringfinger","Saliva","Shank","Shoulder","Skeleton","Skin","Skull","Snot","Sole","Soul","Spittle","Spleen","Stomatch","Stool","Sweat","Tear","Thigh","Throat","Toe","Tomgue","Tooth","Urine","Uvula","Voice","Waist","Womp"};
String[] nationEnglish={"Afgan","African","American","Aranian","Australian","Bangladeshi","Buddhism","Burmese","Chinese","Christian","Czech","Danish","Dutch","English","European","Frenches","Indian","Indonesia","Italian","Japanese","Nation","Persian","Russian","Swedish","Syrian","Turkish"};
    String[] nationBangla={"আফগানিস্তানের অধিবাসী","আফ্রিকার অধিবাসী","আমেরিকার অধিবাসী","আরবীয়","অস্ট্রেলিয়াবাসী","বাংলাদেশী","বৌদ্ধ ধর্ম","বর্মি","চীনদেশীয়,চীনা","খ্রীষ্টধর্মাবলম্বী","চেকোশ্লোভাকিয়াবাসী স্লাভজাতির একটি শাখার লোক","ডেনমার্ক দেশীয়","ওলন্দাজ ভাষা","ইধহমষধ","ইউরোপবাসী","ফরাসী","ভারতীয়","ইন্দোনেশিয়া","ইটালীদেশীয়","জাপানী","জাতি","পারসিক","রুশদেশের ভাষা বা তাহার অধিবাসী","সুইডিশ","সিরিয়াবাসী,সিরিয়ার লোক","তুর্কি"};
String[] stateofManEnglish={"Anxiety","Bachelor","Blindness","Boy","Boyhood","Childhood","Dandy","Deaf","Dumb","Dwarf","Eunuch","Girl","Infancy","Maid","Man","Manhood","Orphan","Puberty","Reckless","Saucy","Savage","Stammerer","State","Stylish","Virgin","Widower","Young","Youth"};
    String[] stateofManBangla={"উদ্বেগ","অবিবাহিত পুরুষ","অন্ধত্ব","বালক","বাল্যকাল","শৈশব","ফুলবাবু","কালা,বধির","ব্যামের জন্য ব্যবহৃত ডাম্বেল","বামন,খর্বাকৃত","খোজা,হিজড়া","বালিকা","শৈশব,শৈশবাবস্থা","মেয়ে,চাকরানী ঝি","মানুষ","সাবালকত্ব,পুরুষত্ব","অনাথ বা পিতৃমাতৃহীন(শিশু)","বয়ঃসন্ধি","বেপরোয়া","ধৃষ্ট,গর্বিত","বন্য,অসভ্য","তোতলা","অবস্থা,হালচাল","ফিটফাট","অবিবাহিত মেয়ে,কুমারী","বিপত্নীক,মৃতদার পুরুষ","অল্পবয়স্ক,তরুণ","তারুণ্য,যৌবন"};
  String[] religionBangla={"পূণ্যস্নান,আচমন","আল্লাহ","খ্রীষ্টের বাণী প্রচারক","কঠোর তপস্বি","অধার্মিক,নাস্তিক","ঘুঁটি","যাদু,তাবিজ","গির্জা","পাদরি,পাদ্রি","শিষ্য,ভক্ত","দেবতা,ভক্তির পাত্র","দেবী","আকাশ,স্বর্গ","নরক","ঋষি,সন্ন্যাসী","সন্ন্যাসীর আশ্রম","প্রতিমা","প্রতিবিম্ব,প্রতিমূর্তি","মিনার সমজিদেও চূড়া","মসজিদ","স্বর্গ পরম সুখের জায়গা","পাদরি","তীর্থযাত্রী","প্রার্থনা","ধর্মোপদেশ দেওয়া","ধর্মোপ্রদেষ্টা,প্রচারক","গরু,শিক্ষক","ধর্মযাজক,পাদরী","পয়গম্বর","শায়িতকরণ","মিতব্যয়িতা","প্রচারবেদী","ধর্ম","ধার্মিক ব্যাক্তি,সাধু","শয়তান","ধর্মগ্রন্থ,ধর্ম-শ্বাস্ত্র","ধর্মীয় উপদেশ বা বক্তৃতা","পাপ,অন্যায়","আত্না,অহং","মন্দির","উচু অট্রালিকা মিনার বা বুরুজ","মিনার,চূড়া","কবিতা,পদ্য","ধর্ম,সদগুন"};
    String[] religionEnglish={"Ablution","Allah","Apostle","Ascetic","Atheist","Bead","Charm","Church","Clergyman","Disciple","God","Goddess","heaven","Hell","Hermit","Hermitage","Idol","Image","Minaret","Mosque","Paradise","Parson","Pilgrim","Prayer","Preach","Preachr","Preceptor","Priest","Prophet","Prostration","Providence","Pulpit","Religion","Saint","Satan","Scripture","Sermon","Sin","Soul","Temple","Tower","Turret","Verse","Virtue"};
String[] relativsBangla={"পিসি মা,মাসী মা","ভাই","শিশু সন্তান","চাচাতো,মামাতো,ফুফাতো ভাই বা ভাগিনি","বাবা","কন্যাসন্তান,কন্যা","বংশধর","শ্ত্রু,প্রতিপক্ষ","পরিবার,সংসার","পিতা","শত্রু","পূর্বপুরুষ","বন্ধু","অভিভাবক","অতিথি","উত্তারাধিকারী","স্বামী","আত্নীয়","মাতা","ধাত্রী,ধাই","প্রতিবেশী","ভাইপো,ভাগনে","ভাইঝি,ভাগনি","বাবা,পিতা","গুরু,শিক্ষক","বোন","পুত্র,ছেলে","শিক্ষক,গৃহশিক্ষক","কাকা,মামা","চৌকি,পাহারা","স্ত্রী,পত্নী"};
    String[] relativesEnglish={"Aunt","Brother","Child","Cousin","Dad","Daughter","Descedant","Enemy","Family","Father","Foe","Forefather","Friend","Gurdian","Guest","Heir","Husband","Kinsman","Mammy","Midwife","neighbor","Nephew","Niece","Papa","Preceptor","Sister","Son","Tutor","Uncle","ward","Wife"};
String[] peopleBangla={"অধার্মিক,নাস্তিক","নববিবাহিত পুরুষ","সাহসী","যে স্ত্রী লোকের চামড়া,চোখ ও চুল কাল","কাপুরুষ","বাঁকা জিনিস","শিশ্ন","মদ্যপফ","ফুল্বাবু,শহরবাসী","খামখেয়ালী","আত্মপর,স্বার্থপর ব্যাক্তি","গোঁড়া","নির্বোধ লোক","নির্বোধ","ক্লান্ত,উদভ্রান্ত","বিশ্বাসঘাতক লোক","আশাবাদী,সুখবাদী","একঘরে বা সমাজচুযত","উৎকর্সের আদর্স","লোক,দেশবাসী","নিরাশাবাদী ব্যাক্তি","অর্থেও যে ব্যাক্তি শক্তিশালী","কার্যকর,ব্যবহারিক","হামবড়া লোক","রোমিও","অধীরচিত্ত","সচেতন,বিচক্ষন","স্বপ্নচারী","অবাধ্য,দুর্দান্ত","যে ব্যক্তি ছাপার হরফ ঢালাই করে","কলহপ্রিয় স্ত্রীলোক","রুচি অমার্জিত ব্যক্তি","বেশ্যা,অসতি রমণি","সন্ন্যাসীনীর ঘোমটাবিশেষ"};
    String[] peopleEnglish= {"Atheist","Benedick","Bold","Brunette","Coward","Crook","Dickhead","Drunkard","Dude","Ecentric","Egoist","Fanatic","Fool","Goofy","haggard","Judas","Optimist","Outcast","Paragon","People","Pessimist","Plutocrat","Practical","Pring","Romeo","Scatterbrained","Sensible","Somnambulist","Stubborn","Tyro","Virago"};
String[] dieasesEnglish={"Ache","Acne","Asthma","Blister","Boil","Cholera","Cold","Constipaton","Cough","Diabetes","Diarrhoea","Disease","Dropsy","Dysentery","Elephantiasis","Fever","Germ","Gout","Headache","Hurt","Hysteria","Illness","Indigestion","Influenza","Insanity","Itch","Jaundice","Leprosy","Malaria","Measles","Ophthalmia","Pain","Piles","Pimple","plague","Pus","Ringworm","Scabies","sore","Spleen","Symptom","Tumour","Vomiting","Weakness","Worm","Wound"};
    String[] dieasesBangla={"বেদনা","ব্রণ","হাঁপানি রোগ","ফোসকা","উত্তাপে ফুটানো সিদ্দ করা","ওলাউঠা রোগ,কলেরা","শীতল,ঠান্ডা","কোষ্ঠবদ্ধতা","কাশি","বহুমূত্র রোগ","উদারময়","ব্যাধি,পীড়া","শোথ,রোগ","আমাশয় রোগ","গোদ,শ্লীপদ","জ্বর,উত্তেজনা","বীজ,মূল","গেঁটেবাত","মাথাধরা","আঘাত বা আহত করা","বায়ূরোগবিশেষ,মৃগীরোগ","পীড়া,অসুস্থ্যতা","অজীর্ণতা,বদহজম","সংক্রামক সর্দিজ্বর","পাগলামী","চুলকানি","পান্ডু রোগ","কুষ্ঠরোগ","জ্বররোগ বিশেষ,ম্যালেরিয়া","হাম","চোখ ওঠা রোগ","ব্যথা","অর্শরোগ","ব্রণ","মহামারী","পুঁজ,ঘা","দদ্রু","চুলকানি,খোস","কালশিটে,ক্ষতপূর্ণ","পিলে,প্লীহা","লক্ষণ,চিহ্ন","আব","বমি","কমজোরি","পোকা,কীট","ক্ষত,ঘা"};
String[] birdsBangla={"সেনা বিভাগের সহকারী কর্মচারী","বাদুড়,ক্রিকেট খেলার ব্যাট","পাখি","খাচা","পটুতা","মোরগ","সারস,এক জাতীয় বক","কাক,মোরগের ডাক","কোকিল","ঘু ঘু পাখি","পাতি হাস","পাতি হাসের ছানা","সূক্ষন নালী","ঈগল পাখি","ডিম","বাজপাখি","মরাল,রাজহংস","যে কোন পাখি","রাজহাঁস","রাজহংসী","গাংচিল","বাজপাখি","মুরগি","বক,সারস","পাতিকাক","মাছরাঙা পাখি","ঘুড়ি,চিল","এক জাতের পাখি","কিচির মিচিরকারী দৃষ্ঠ পাখিবিশেষ","পক্ষিবিশেষ","শালিক","পাখির বাসা,নীড়","বুলবুল বা পাপিয়া পাখি","উটপাখি","পেঁচা","টিয়া","তোতা পাখি","ময়ূর","পায়রা,কবুতর","দাড়কাক","দাড়কাক,প্রতারক","চাতক পক্ষী","চড়াই পাখি","বক,সারস","ভরত পাখি","শকুনি,গৃধ্র"};
    String[] birdsEnglish={"Adjutant","Bat","Bird","Cage","Chicken","Cock","Crane","Crow","Cuckoo","Dove","Drake","Duck","Duckling","eagle","Egg","Falcon","Flamingo","Fowl","Gander","Goose","Gull","Hawk","Hen","Heron","Jackdaw","Kingfisher","Kite","Lark","Magpie","Martin","Myna","Nest","Nightingale","ostrich","Owl","Parakeet","Parrot","Peakcock","Pigeon","Raven","Rook","Skylark","Sparrow","Storl","Swallow","Trap","Vulture"};
String[] wormandInsectsBangla={"পিপড়ে","মৌমাছি","মৌচাক","গুবরে পোকা","ছার পোকা","প্রজাপতি","আরসোলা","ক্রিকেট খেলা","মাছি","গো-মাছি,দংশ","ডাশ","ফড়িং","ভিমরুল","কীট","উকুন","মশা","উকুনের ডিম,নিকি","মাকড়সা","হুল ফুটান","বোলতা","বৃদ্ধি পাওয়া","পোকা,কৃমি"};
    String[] wormandInsectsEnglish={"Ant","Bee","Beehive","beetle","Bug","Butterfly","Cockroach","Cricket","Fly","Gadfly","Gnat","Grasshopper","Hornet","Insects","Louse","Mosquito","Nit","Spider","Sting","Wasp","wax","Worm"};
String[] reptilesBangla={"এক জাতীয় আমেরিকান কুমীর","গিরগিটি","গুটিপোকা","কেউটে সাপ","বাদ্যশঙ্খ","কেঁচো","বিষদাঁত","ব্যাঙ","গোধা,গোসাপ","জোঁক","টিকটিকি","ভোঁদর","শিশুমার","ময়াল সাপ","সারীসৃপ","কাঁকড়াবিছা","হাঙ্গর","শামুক","সাপ","বেঙ্গাচি","কচ্ছপ,কাছিম"};
    String[] reptilesEnglish={"Alligator","Cameleon","CAterpillar","Cobra","Conch","Earthworm","Fangs","Frog","Iguana","Leech","Lizard","Otter","Porpoise","python","Reptile","Scorpion","Shark","Snail","Snake","Trdpole","Tortoise"};
String[] animalBangla={"গর্দব", "ভাল্লুক", "পশু", "এক জাতীয় বন্য মহিষ", "কুকু্রী", "বুনো শুয়োর", "পুরুষ জাতীয় মৃগ", "মহিষ", "ষাড়", "বলদ", "গরু হাতি বা তিমির বাচ্ছা,বাছুর,পায়ের মাংস পেশী", "উট", "বিড়াল", "গৃহপালিত গবাদি পশু", "শিম্পাজ্ঞি,বনমানুষ বিশেষ", "ঘোড়ারবাচ্চা", "কুমির", "বাঘ,সিংহ,শিয়াল প্রভূতির শাবক",  "হরিণ", "হরিণী", "কুকুর","গাধা","গর্দভ", "স্ত্রী-ভেড়া,ভেড়ী", "হরিণ শিশু,হালকা হলুদ বাদামী রঙ", "খেঁক শিয়াল,পাতিশিয়াল", "ব্যাঙ", "জিরাফ", "ছাগল", "বনমানুষ", "খরগোশ,শশক", "হরিণী,পিছনের", "জলহস্তি", "শুকর", "ঘোড়া", "শিকারী কুকুর", "শেয়াল", "ক্যাজ্ঞারু", "ছাগল ছানা", "বিড়াল চানা", "মেষশাবক", "সিংহরাশি", "চিতাবাঘ", "সিংহ", "সিংহী", "ঘোটকী", "ছুঁচা", "বেজি", "বানর", "নেংটি ইদুঁর", "খচচর", "ওরাং", "ষাঁড়", "শূকর", "টাটু ঘোড়া", " শজারু ", "কুকুরছানা", "খারগোশ", "ভেড়া", "বড় ইঁদুর", "গন্ডার", "মেষ", "শামুক", "সাপ", "কাঠবিড়াল", "পুরুষ হরিণ", "বাঘ", "ব্যাঘ্রী", "কচ্ছপ","কাছিম", "তিমি", "নেকড়েবাঘ", "জেবরা", };
    String[] animalEnglish={"Ass", "bear", "Beast", "Bison", "Bitch", "Buck", "Boar",  "Buffalo", "Bull", " Bullock", "Calf", "Camel", "Cat", "Cattle", "Chimpanzee", "Colt", "Crocodile", "Cub", "Deer", "Doe", "Dog", "Donkey", "Ewe", "Fawn", "Fox", "Frog", "Giraffe", "Goat", "Gorilla", "Hare", "Hind", "Hippopotamus", "Hog", "Horse", "Hound", "Jackal", "Kangaroo", "Kid", "Kitten", "Lamb", "Leo", "Leopard", "Lion", "Lioness", "Mare", "Mole", "Mongoose", "Monkey", "Mouse", "Mule", "Orang", "Ox", "Pig", "Pony", "Porcupine", "Puppy", "Rabbit", "Ram", "Rat", "Rhinoceros", "Sheep", "Snail", "Snake", "Squirrel", "Stag", "Tiger", "Tigress", "Tortoise", "Turtle", "Whale", "Wolf", "Zebra"};
String[] limbsOfAnimalsBangla= { "পাখির চোখ", "গোমাংশ", "পাখির নখর", "নিচের দিকে", "যে সহজে প্রতারিত হয়", " পাখির পালক", "পশম", "গোপন করা", "সাপের ফণা", " পশুর পায়ের খুর ক্ষুর", "শিং", "পাকা চামড়া", "কেশর", "থাবা মারা", "জলাভূমি", "লেজ", "বান্ড", "হাতির দাঁত", "ডানা"} ;
    String[] limbsOfAnimalsEnglish={ "Beak", "Beef", "Claw", "Down", "Dung", "Feather", "Fur", "Hide", "Hood", "Hoof", "Horn", "Leather", "Mane", "Paw", "Slough", "Tail", "Trunk", "Tusk", "Wing"};
String[] criesOfAnimalsBangla={"গাছের ছাল", "ভেড়া", "গাধার ডাক", "মুরগীর ডাক", "কাকের ডাক", "ভজন গীত", "পাখির কিচিরমিচির", "পায়রা", "ব্যাজ্ঞের ডাক", "কাক", "কুকুরের মত গো গো করা", "শুকরের ডাক", "হিস হিস শব্দ করা", "পেচাঁর ডাক", "নেকরে বাঘের ডাক", "বিড়ালের ডাক"," হ্রেষাধুনিকরা", "পাতি হাসেঁর ডাক","গর্জন", "তীক্ষ্ণ কন্ঠে চেঁচানো", "কিচমিচ শব্দ", "কথা বলা", "পাখির ক্ষীন কিচির মিচির শব্দ", "গলা কাপিঁয়ে গান করা", "তীব্র চিৎকার করা"};
    String[] criesOfAnimalEnglish={"Brak", "Bleat", "Bray", "Cackle", "Caw", "Chant", "Chirp", "Coo", "Crock", "Crow", "Growl", "Grunt", "Hiss", "Hoot", "Howl", "Mew", "Neigh", "Quack", "Roar", "Scream", "Squeak", "Talk", "Twitter", "Warble", "Yell"};
String[] cultivationBangla= {"বলদ", "ফসল", "চাষী", "", "মাটি", "বাঁধ", "চাষী", "ললাট", "মাট", "মই", "ফসল", "নিড়ানী দিয়ে আগাছা উপরে ফেলা", "জলসেচন", "মই", "মাটি", "জমির সার", "বিল অনুপ", "বর্ষাকালের আরম্ভ", "ক্ষুদ্র কৃষক", "হাল", "বারিপাত", "শস্যচ্ছেদন", "বীজ", "কাস্তে", "মাটি", "বপন", "ট্রাস্টর", "আগাছা", "নিড়ানি", "জুয়াল"} ;
    String[] cultionEnglish={"Bullock", "crop", "Cultivator", "Earth", "Embankment", "Farmer", "Furrow", "Ground", "Harrow", "Harvest", "Hoe", "Irrigation", "Ladder", "Land", "Manure", "Marsh", "Monsoon", "Peasant", "Plough",
            "Rainfall", "Reaping", "Seed", "sickle", "Soil", "Sowing", "Tractor", "Weed", "Weeding", "Yoke"};
String[] naturalObjectBangla={"বায়ু", "উপসাগর", "ছিদ্র করা", "বাতাস", "গুহা", "কাদা", "আব হাওয়া", "ধূমকেতু", "দেশ", "চূড়া", "প্রবল ঘূর্ণিঝড়", "প্লাবন"," জেলা", "বিভাগ"," ধুলি", "মাটি", "গ্রহণ", "আগুন", "চকমকি পাথর", "বন্যা", "ঘন কুয়াশা", "আকস্মিক দমকা বাতাস", "পল্লী", "বন্দর", "পাহাড়", "হ্যারিকেন", "বরফ", "দ্বীপ", "বিদ্যুৎ", "উল্কা", "ছঁচের মাটি", "চাঁদ", "পাহাড়", "পর্বত", "বরুণদের", "ছাড়িয়ে যাওয়া", "শিখর", "নুড়ি", "উপদ্বীপ", "গ্রহ", "যম", "ডোবা", "বন্দর", "প্রদেশ", "সারি",
        "নদী", "বালি", "উপগ্রহ",  "আকাশ", "তুষার", " উৎস", "লাফিয়ে ওঠা", "তারা", "ঝর", "জল প্রনালী", "গ্যাস", "বাজ", "স্রোত", "প্রবল", "উপত্যকা", "গ্রাম", "আগ্নেয়গিরি", "জল", "ঝরনা" };
    String[] naturalObjectEnglish={ "Air", "Bay", "Bore", "Breeze", "Cave", "Clay", "Climate", "Comet", "Country", "Crest", "Cyclone", "Delta", "District", "Division", "Dust", "Earth", "Eclipse", "Fire", "Flint", "Flood", "Fog", "Gust", "Hemlet", "Harbour", "Hill", "Hurricane", "Ice", "Island", "Lightning", "Metor", "Molehill", "Moon", "Mount", "Mountain", "Neptune", "Pass", "Peak", "Pebble", "Penissula", "Planet", "Pluto", "Port", "Province", "Range",  "River",
            "Sand", "Satellite", "Sky", "Snow", "Source", "Spring", "Star", "Storm", "Strait", "Stream", "Thunder", "Tite", "Tornado", "Valley", "Village", "Volcano", "Water", "Waterfalls", "Weather", "Wind"};

    String[] flowerEnglish={"Bastard teak", "Blossom", "Bouquet", "Bud", "Bunch", "Chaina rose", "Chameli", "Champak", "Flamboyant", "Gardener", "Garland", "Guardenia", "Jessamine", "Lily", "Lotus", "Oleander", "Passion flower", "Petal", "Rose", "Screwpine", "Smell", "Thorn apple", "Tuilip",};
    String[] flowerBangla={"সেগুন", "পুষ্পবিকাশ", "ফুলের তোড়া", "কুঁড়ি", "গুচ্ছ", "জবা", "চামেলি", "দূরবর্তী", "সুসজ্জিত", "মালী", "মালা", "গন্ধরাজ ফুল", "নবমালিকা", "পদ্মফুল", "পন্মফুল", "গাঁদাফুল", "করবী", "ঝুমকো লতা", "ফুলের পাপড়ি", "গোলাপ ফুল", "কেয়া", "গন্ধ", "ধুস্তর", "গাছবিশেষ ও তার সুন্দর ফুল",};
String[] treeAndPlantsBangla={"বাঁশ", "বেনিয়া", "গাছের ছাল", "পান", "গাছের ছাল", "ঝোপ", "লতা", "তন্ত",
        "বন", "ঘাস", "গাছের পাতা", "চারাগাছ", "মজ্জা", "শর", "শিকড়", "ঝোপ", "পাতা ফুল", "খড়", "আখ", "গাছ", "বান্ড", "পল্লব", "দ্রাক্ষলতা", "আগাছা",
        "বন"};
    String[] treeAndPlantsEnglish={"Bamboo", "Banyan", "Bark", "Betel",
            "Branch", "Bush", "Creeper", "Fibre", "Forest", "Grass", "Leaf", "Plant", "Pricker", "Pulp", "Reed", "Root", "Shrub", "Stalk", "Stem", "Straw", "Sugarcane", "Tree", "Trunk", "Twig", "Vine", "Weed", "Wood" };
String[] clothAndGarmentsEnglish={"Belt", "Blanket", "Blouse", "Bodice", "Boot", "Breeches", "Button", "Cap", "Chemise", "Cloth", "Collar", "Drawers", "Dress", "Frock", "Garb", "Garment",
        "Garter", "Glove", "Gown", "Guise", "Handkerchief", "Hat", "Lace", "Mantle", "Napkin", "Pantaloons","Pants", "Pocket", "Sandal", "Sari", "Scarf", "Shawl", "Shirt", "Shoe", "Slipper", "Socks", "Spectacles", "Stocking", "Trousers", "Turban", "Underwear", "Veil"};
    String[] clothAndGarmentsBangla={"কোমরবন্ধ", "কম্বল", "মেয়েদের জামা", "কাচুলি", "বুট জুতা", "আটো পাজামা", "বোতাম", "টুপি", "শেমিজ", "কাপড়", "জামার কলার", "দেরাজ", "পরিধান করা", "মেয়েদের পোশাক বিশেষ", "পোশাক", "পরিচ্ছদ", "মোজা বাঁধার ফিতা", "দস্তানা", "লম্বা ও ঢিলা পোশাক", "ভান", "রূমাল", "পরপর তিনটি গোলা করা", "কারুকাযময় ",
            "আবরন জালিকাটা আলোর ঢাকনা", "গামছা", "পাজামা", "প্যনট", "পকেট জেব", "চটি", "শাড়ি", "ওড়না", "শাল", "জামা", "জুতা", "চটিজুতা", "মোজা", "উপনেএ ", "মোজা", "তোয়ালে", "পাজামা", "পাগড়ি", "অধোবাস"};
String[] houseHoldBangla={ "আলমারী", "কম্বল", "গালিচা", "চেয়ার", "বড় ঘড়ি", "চিরুনি", "খাট", "বিছানার চাদর", "আয়না", "বিরোধী হওয়া কর্কশ শব্দ করা", "কুজা", "কেটলি", "তালা", "আয়না", "ছবি", "কলসী", "তাক", "চালুনি", "চামচ", "ছড়ি",
        "টেবিল", "চা-চামচ", "গামলা", "ছাতা"};
    String[] householdEnglish={"Almirah", "Blanket", "Carpet", "Chair", "Clock", "Comb", "Cot", "Coverlet", "Glass", "Jar", "Jug",
            "Kettle", "Lock", "Mirror", "Picture",
            "Pitcher", "Shelf", "Sieve", "Spoon", "Stick", "Table", "Teaspoon", "Tub", "Umbrella"};
String[] dwellingsHouseBangla={"ছোট কক্ষ", "কড়ি কাঠ", "অন্ধ", "হুড়কো", "ইট", "অট্রালিকা", "শিবির", "ঘরের ছাদের ভিতরের দিক", "সিমেন্ট", "গির্জা", "কুটির", "গোয়াল", "গম্বুজ", "দরজা", "নালা", "খামার", "বেড়া", "ঘরের মেজে", "গড়", "প্রতিষ্টা", "বাগান",  "গুগামঘর", "বড়ঘর", "কবজা", "আবাশ", "বারিঘর", "কারাগার", "রান্নাগর", "খিল", "লন",
        "বাসভবন",  "চুন", "মসজিদ", "নখ", "দফতর", "রং", "বাজবাড়ি", "থাম", "নল", "তক্তা", "ডোবা", "পদ", "জেল", "গোপনীয়", "আবাস", "ছাদ", "ঘর", "কাছি", "বালি", "চালাঘর", "দোকান", "নলমুখ", "অটল", "সিড়ির ধাপ" ,"তার", "পুকুর", "আল কাতরা", "মন্দির", "তাঁবু", "খোলা", "ধনাগার", "বারান্দা", "দেওয়াল",  "এক গজ"};
    String[] dwellingHouseEnglish={"Apartment", "Beam", "Bilind", "Bolt", "Brick", "Building", "Camp", "Ceilling", "Cement", "Church", "Cottage", "Cowshed", "Dome", "Door", "Drain", "Farm", "Fence", "Floor", "Fort", "Foundation", "Garden", "Godown", "Hall", "Hinge", "Home", "Jail", "Kitchen", "Latch", "Lawn", "Mansion", "Mortar", "Mosque", "Nail", "Office", "Paint", "Palace", "Pillar", "Pipe", "Plank", "Pond", "Post", "Prison", "Privy", "Residence", "Roof", "Room", "Rope",
            "Sand", "Shed", "Shop", "Spout", "Stable", "Stair",  "String", "Tank", "Tar", "Temple", "Tent", "Tile", "Treasury", "Veranda", "Wall", "Yard"};
String[] gameAndSportsEnglish= {"Badminton", "Ball", "Bat", "Chess", "Cricket", "Dice", "Doll", "Exercise", "Football", "Game", "Goal", "Jump", "Kick", "Kite", "Marble", "Playing Card", "Reference", "Tennis", "Throw", "Top", "Toy"};
    String[] gameAndSportsBangla={"ব্যাডমিন্টন খেলা", "খেলার বল", "বাদুড়", "দাবাখেলা", "ক্রিকেট খেলা", "পাশা", "পুতুল", "অনুশীলন করা", "ফুটবল", "খেলা", "লক্ষ", "ঝাঁপ দেওয়া", "লাথি মারা", "ঘুড়ি",
            "মার্বেল পাথর", "যে খেলে", "খেলিবার তাস", "বিচারক", "টেনিস খেলা", "হাত পা ছোড়া", "লাটিম", "খেলনা" };
String[] metalsAndMineralsBangla={"পিতল", "খড়ি", "কয়লা", "কোক-কয়লা", "তামা", "পান্না", "রত্ন", "কাচেঁর বাসনপএ", "ধাতুনির্মিত দব্রাদি", "লোহা", "জহরত", "জহুরী", "কেরোসিন", "লেবু", "চুম্বুকীয়", "ধাতু", "আমার খনি", "আকরিক", "অয়েল", "মুক্ত", "চীনামাটির বাসপএ", "নুন", "রুপা", "ইস্পাত", "পাথর ", "সালফার", "আলকাতরা", "টিন", "দস্তা "};
    String[] metalsAndMineralsEnglish= {"Brass", "Chalk", "Coal", "Coke", "Copper", "Emerald", "Gem", "Glassware", "Hardware", "Iron", "Jewel", "Jeweeler", "Kerosene", "Lime", "Magnet", "Metal", "Mine", "Mineral", "Oil", "Porcelain", "Salt", "Silver", "Stone", "Sulphur", "Tar", "Tin", "Zinc"} ;
String[] colorBangla={"নীলিমা", "কালো", "নীল রঙ", "বাদামী", "রঙ", "টক টকে লাল", "মেলা ",
        "সবুজ", "পরিপক্ক", "নীল গাছ", "দ্বীপে নিরবাসন দেওয়া", "কমলালেবু",
        "বেড়া", "গোলাপী রঙ" ," বেগুনী রঙ", "লাল", " গোলাপী উজ্জ্বল",
        "উজ্জ্বল লাল রঙ", "পরিষ্কার কাষ্টবিশিষ্ট", "বেগুনী রঙ্গের ছোট ফুল বিশেষ",
        "সাদা", "হলদে"};
    String[] colorEnglish={"Azure", "Black", "Blue", "Brown", "Color", "Crimson", "Fair", "Green", "Grey", "Indigo", "Maroon", "Orange", "Pale", "Pink",
            "Purple", "Red", "Rosy", "Scarlet", "Silvery", "Violet", "White", "Yellow"};
String[] ornamentsEnglish={"Amulet", "Anket", "Armlet", "Bangle", "Caul", "Chine", "Collar", "Crown", "Diamond", "Hairpin", "Jewel", "Necklace", "Ornament", "Pendant", "Ring", "Wristlet"};
    String[] ornamentsBAngla= {"কবজ ", "মল", "তাগা", "বালা", "মাথা ডাকিবার জন্য জাল বিশেষ", "শেকল", "জামার কলার", "মুকুট"," হীরা ", "মাথার কাঁটা", "জহরত", "নেকলেস", "শুভাবুদ্ধি", "মুক্ত", "গলার হার প্রভূতি লকেট", "ঘেরাও করা", "হাতকড়া"};

String[] musicalInstruMentBangla={"ধ্বনি সম্প্রসারক যন্ত্র বিশেষ","ঘন্টা","শিঙ্গা","গায়কদল","ঢাক","পিয়ানোর আদিরুপ","বাঁশি","গিটার","বীণা বাজানো","সঙ্গীত","পরেডিও","গান,গীত","নাগরা বা ঢোল","টেলিভিশন","বেহালা"};
    String[] musicalInstrumentEnglish={"Amplifier","Bell","Bugle","Chorus","Drum","Dulcimer","Flute","Guitar","Harp","Music","Radio","Song","Tabor","Television","Violin"};

String[] vicalesBangla={"বিমান ঘাটি","উড়োজাহাজ","নোঙ্গর","বজরার","নৌকা","বাস গাড়ী","কামরা-ঘর","ডোঙ্গা বা ছোট নৌকা","গাড়ি","ঘোড়ার গাড়ি,রেলের কামরা","জাহাজের পাটাতন","ফেরি জাহাজ","টুকরা,আবর্জনা","মালবাহী মোটর গাড়ী লরি","দাঁত,বৈটা","বৈটা","পালকি","লাগাম বলম রাশ","নাবিক,খালাসী","জাহাজ","ভারাটে মোটর-গাড়ি","মাল বহন করার মোটর লবি"};
    String[] vicalesEnglish={"Aerodrome","Aeroplane","Anchor","Barge","Boat","Bus","Cabin","Canoe","Car","carriage","Deck","Launch","Litter","Lorry","Oar","Paddle","Palanquin","Rein","Sailor","Ship","Taxi","Truck"};

String[] branchOfEducationBangla={"হিসাবরক্ষনের কার্য বা পদ","কৃষি চাষ","বিজগণিত",
        "পাটিগণিত","হওয়া,থাকা","গলিত জ্যোতিষশাস্ত্র","গ্রহ বিজ্ঞান","জিব বিদ্যা","উদ্ভিদ বিজ্ঞান","রাসায়নবিদ্যা","চিত্র","গতিবিজ্ঞান","ভূগোলবিদ্যা","ভূতত্ত্ব","জ্যামিতি","ইতিহাস","স্বাস্থ্য","শিল্প,শ্রমশিল্প","সাহিত্য","যুক্তিবিদ্যা","গাণিতিক,গণিতশাস্ত্র দ্বারা কৃত","পরিমিত বিদ্যা","দর্শনশাস্ত্র","পদার্থবিদ্যাগত,আরোগ্যকর বস্তু","মনোবিজ্ঞান","বিজ্ঞান","সমাজবিদ্যা","স্থিতিবিদ্যা","পরিসংখ্যান","ধর্মতত্ত্ব","ত্রিকোণমিতি","প্রাণিবিদ্যা"};
    String[] branchOfEduEnglish={"Accountancy","Agriculture","Algebra","Arithmetic","Art","Astrology","Astronomy","Biology","Botany","Chemistry","Drawing","Dynamics","Geography","Geology","Geometry","History","Hygiene","industry","Literature","Logic","Mathematic","Mensuration","Philosophy","Physic","Psychology","Science","Sociology","Statics","Statistic","Theology","Trigonometry","Zoology"};
String[] directionBangla={"উপরে","পিঠ","নিচে","কোণ","পূর্ব্দিক","সামনে","অভ্যন্ত","উত্তরপূর্বকোণ","বায়ুকোণ","পার্শ্ব,ধার","দক্ষিণ দিক","পূর্বদক্ষিণ","নৈঋর্ত","তলে,নিচে","পশ্চিমদিক"};
    String[] directonEnglish={"Above","Back","Below","Corner","East","Front","Inside","North-east","North-west","Side","South","South-east","South-west","Under","West"};
String[] dayMonthSeasonBangla={"ইংরেজী বছরের চতুর্থ মাসের নাম","ইংরেজী বছরের অষ্টম মাসের নাম","শরৎকাল","দিন","ইংরেজী বছরের শেষ মাসের নাম","ইংরেজী বছরের দ্বিতীয় মাসের নাম","শুক্রবার","তাৎক্ষণিক","ইংরেজী বছরের প্রথম মাসের নাম","ইংরেজী বছরের সপ্তম মাসের নাম","জুন মাস","হেমন্তকাল","মার্চ মাস","পারা,মে মাস","সোমবার","মাস","ইংরেজী বছরের একাদশ মাসের নাম","আগামী মাসের","ঘনকাল,জলদকাল","শনিবার","ঋতু","ইংরেজী বছরের নবম মাসের নাম","লাফিয়ে ওঠা","গ্রীষ্মকাল","রবিবার","বৃহস্পতিবার","মঙ্গলবার","গত মাসের","বুধবার","শীতকাল"};
    String[] dayMonthSeasonEnglish={"April","August","Autumn","Day","December","February","Friday","Instant","January","July","June","Late autumn","March","Monday","Month","November","Proximo","Rainy season","Saturday","Season","September","Spring","Summer","Sunday","Thursday","Tuesday","Ultimo","Wednesday","Winter"};
String[] feelingBangla={"অনুরাগ","রাগ","সাহস","ভিক্ষাদান","পরিচ্ছন্নতা","আরাম","সাহস,বীরত্ব","সাহসী,নির্ভীক","ভদ্রতা","কাপুরুষতা","নিষ্ঠুরতা","শোভনতা,ভদ্রতা","অসাধুতা","শ্ত্রুতা","হিংসা করা","ভুল","ভয়","বন্ধুত্ব","উপহার","গৌরব","বিশালতা","কষ্ঠ বা ক্লেশ","ঘৃণা","স্বাস্থ্য শারীরিক সুস্থ অবস্থা","পবিত্রতা","সাধুতা,সত্যবাদিতা","ক্ষুধা","অপমান করা","উল্লাস,আনন্দ","ন্যায়পরতা,ন্যায়বিচার","দয়া,পরোপকার","জ্ঞান","পরিশ্রম","উদারচিত্ততা","স্বাধীনতা","ভালবাসা","বিদ্বেষ","নীচতা","দয়া,সহানুভুতি","দারিদ্র,অভাব","শুদ্ধতা,পবিত্রতা","গুণ,ধর্ম","গন্যকরা","উপশম,বদলি","সম্মানন বা ভক্তি করা","প্রতিহিংসা","অশিষ্ঠতা","লাজুক ভাব","দুঃখ","সহানুভূতি","ভীরু ভাব,সাহসের অভাব","কুদর্শনতা,কদর্যতা","কমজোরি,দৌর্বল্য"};
    String[] feelingEnglish={"Affection","Anger","Bravery","Charity","Cleanliness","Comfort","Courage","Courageous","Courtesy","Cowardice","Cruelty","Decency","Dishonesty","Enmity","Envy","Error","Fear","Friendship","Gift","Glory","Hardship","Hatred","Health","Honesty","Hunger","Insult","Joy","Justice","Kindness","Knowledge","Labour","Liberality","Liberty","Love","Malice","Meanness","Pity","Poverty","Purity","Quality","Regard","Relief","Respect","Revenge","Rudeness","Shyness","Sorrow","Sympathy","Timidity","Ugliness","Weakness"};
String[] administratorEnglish={"Act","Army","Board","Budget","Cabinet","Capital","Chairman","Clerk","Commissioner","Court","Election","Gazette","Goverment","Governor","King","Kingdom","Minister","Minster","Nomination","Opposition","Parliament","Police","Police Constable","Port","President","Prime minister","Province","Republic","Ruler","Secretary","Soldier","Subject","Throne","Vice-president"};
    String[] administratorBangla={"কাজ","সৈন্যদল","কাঠের ফলক","আয় ব্য","মন্ত্রি সভা","প্রধান","সভাপতি","কেরাণী","ভারপ্রাপ্ত উচ্চপ্রদস্থ ব্যাক্তি","উঠান","নির্বাচন","ইসতেহার","সরকার","রাজ্যপাল","রাজা","রাজ্য","সরকারপক্ষীয়","মঠের গির্জা","মনোনয়ন","প্রতিরোধ","সংসদ লোকসভা","আত্নরক্ষা","পুলিশ হাবিলদার","বন্দর","সভাপতি","অমাত্য-প্রধান","প্রদেশ","রাষ্ঠ্র","শাসক","সচিব","সৈনিক","প্রজা","রাজাসন","উপরাষ্ঠ্রপতি"};
String[] commerceEnglish={"Bank","Bank balance","Banker","Banking","Borrower","Cardholder","Cashback","Chips","Collateral","Commission","Debit","Depositor","Discount rate","Draft","Interest rate","Money market","Mortgage","Overdraft","Overdrawn","Passbook","Saver","Saving","Standing order","Strongroom","Unsecured"};
    String[] commerceBangla={"তীর,কিনার","ব্যাংকে জমানো টাকা","মহাজন","মহাজনী","যে ধার করে","কার্ডধারীর","নগদ ফেরত","ভাজা আলুর কুচি","সহায়ক","কর্মসম্পাদনের তদন্তকার্যে নিযুক্ত ব্যাক্তি","দেনা","ভান্ডার","বাটার হার","হুন্ডি","সুদের হার","টাকার বাজার","বন্ধক","বেশি ওঠানো টাকা","অঙ্কনে বাড়াবাড়ি করা","যে খাতায় ব্যাংকে জমানো টাকার হিসাব থাকে","সঁচয় উপায়","সঁচয়","স্থায়ি নির্দেশাবলী","নিরাপদ ঘর","অসুরক্ষিত"};
  String[] marinBangla={"নিবিষ্ট করা","প্রাচুর্য","দ্রুততর করা","উপযোগী করা","পরিবর্তন সাধন করা","অগভীর জলের তলায় আবদ্ধ","শেওলাগুলি","নোঙর","হ্রদ","জলজ","সুমেরু সম্বন্ধীয়","বৃহৎ বাণিজ্যপোত","খাজনা ধার্য করা","অতলান্তিক","বায়ুমন্ডল","উপহ্রদপরিবেষ্টক বলয়াকার প্রবালদ্বীপ","রোগ জীবানু","দাড়ি পাল্লা","বাধা","বজরার","অগ্নিয়গিরিজাত শিলা","গামলা","গভীর সমুদ্রতলে অনুসন্ধান চালাবার জন্য বিশেষভাবে নির্মিত মনুষ্যবাহী জলযান","গভীর সমুদ্রে প্রাণী","সৈকত","তলদেশে","তল","দানশীলতা","ভঙ্গ","তরঙ্গের বেগ রোধ করিবার জন্য নির্মিত বাঁধ","লোনা জল","বয়া","পরিবর্তন","খাড়া উঁচু পাহাড়","আবহাওয়া","তটরেখা","ধাক্কা খাওয়া","বাণিজ্য","যোগাযোগ","সম্প্রদায়","বাদ্যশংখ","জয়","সংক্রমণ","মহাদেশ","প্রবাল","জীব","কবচা","প্রবাহমান","সাইকেল গাড়ি","উপায়","গভীর","কমনীয়","জমা করা","গভীরতা","লবণমুক্ত করা","বিনাশক","আবিষ্কৃত বিষয় বস্তু","ভেঙ্গে দেওয়া","দূরত্ব","বিভেদ","জলের ডুবা","জাহাজ ঘাট","দলিল রচনা","রাজ্য","নদীর তলা দেশ হতে কর্দমাদি তুলবার যন্ত্র","বাতাসে ভেসে চলা","বাস করা","গতিবিজ্ঞান-সংক্রান্ত","এখানে সূচনা করুন","বাস্তু","কাজের ফলাফল","আবহাওয়া","আপদগ্রস্ত","উদ্যম","ক্ষয়","নদীমুখ","পর্যটন","আবিস্কারের জন্য খোজ","সুবিধা-সুযোগ","প্রতিপালন","সার","মাছ ধরিবার কৌশল","সমুদ্রের খাঁড়ি","ভাসা","পুষ্পোদ্গম","উন্নতি লাভ করা","ওঠানামা","তরল বা বাস্পীয়","সশস্ত্রবাহিনী","দৈত্য","পৃথিবী","ভার","উপসাগর","চক্রগতি","জন্তুর জন্মস্থান","ঘোড়ার সাজ বর্মভূষিত করা","চাপিয়ে","গোলার্ধ","নিয়ন্ত্রণকর্তা","বাসোপযোগি নৌকা","হ্যারিকেন","হিমশৈল","বিপন্ন","প্রবেশ","ভারতীয়","শিল্প","তদন্ত","মিথস্ক্রিয়া","পরস্পরের উপর নির্ভরতা","আক্রমণকর","অমেরুদন্ডী","কেলপ","গতিময়","গাঁট","উপহ্রদ","ভূমি","কোল","শুককীট","সমতল","সমুদ্র-দানব","জীবন","আলো","লঘুকরণ","সীমা","তরল পদার্থ","জীবিকা","ম্যাগমা","আচরণ","গরানগাছ","ম্যাপিং","সামুদ্রিক","সমুদ্রতীরবর্তী","বিল অনুপ","অভিপ্রয়ন","সংযুক্ত করা","খোলকী","গতিবেগ","সর্দার","গতি","চলন","অন্ধকারময়","প্রাণিবিজ্ঞানী","নাবিক সম্মন্ধীয়","নাবিকবিদ্যা","লঘু স্ফীতি","খাদ্য ২","পুষ্ঠিকর পরিপোষক","মহাসাগর","মহাসাগরীয়","সমুদ্রবিদ্যা","সাগরমুখী","অস্রপ্রচার","দেহী","বিদায়ী","অক্সিজেন","প্রশান্ত","নমুনা","শান্তিপূর্ন","মোতি","মহাসাগরে","ঘটনা","ফাইটোপ্ল্যাঙ্কটন","গ্রহ","সমুদ্র নদী প্রভৃতির জলে ভাসন্ত","দূষক","ওজন পরিমা","প্রাণীদের","ভবিষ্যদ্বাণী","চাপ","শিকার ধরা","উৎপাদন","রক্ষা","পবিত্র করা শোধন করা","পরিমাণ","অনুসন্ধান","রাজ্য","চিত্তবিনোদন","সমুদ্রে ডোবা পাহাড়ের চূড়া","নতুনকরণ","গবেষণা","উপায় সম্ভাবনা","পুনরুদ্ধার","তাল","নিরাপত্তা","জলযাত্রা","লবণতা","কিঞত লবণাক্ত","বালি","বিজ্ঞান","বিজ্ঞানী","জলফুসফুস","মহাসাগর","সমুদ্রচিত্র","মরশুমী","নোনা জল","সমুদ্র উদ্ভিদ","অন্ধিসন্ধি","গাদ","ভুমিকম্প সম্বন্ধীয়","সেকসট্যান্ট","আন্তরিক নয় এমন ভালবাসা","নিরাপদ আশ্রম","দলসমূহ","কঙ্কাল","ঢাল","সোনার","শব্দ","কুল","তরলপদার্থ শোষক দ্রব্য","স্কুইড","শক্তি","জলের নিচে চলাচল করতে পারে এমন","জলে ডুবিয়ে রাখা","যোগানো","তল","সার্ফিং","ঊর্মি","উদ্বর্তন","ফোলা","প্রযুক্তিবিদ্যা","ফলধারণ","তাপের মাত্রা","উঁচু চত্তর","উন্নতি করা","বেলোর্মি","স্রোত","নির্বাসন","পরিখা খনন করা","পশুকে জাবনা","সুনামি","কোলাহল","সর্বব্যাপি","চোখ মারা","সমুদ্রগর্ভপথে","একমাত্র","সার্বিক","সীমাশূন্য","উপত্যকা","অসার বস্তু","ভিন্নতা","বিশাল","গতিবেগ","আগ্নেয়গিরি","তড়িৎপ্রবাহ পরিমাপের একক","আন্তরিক","জল","জলপূর্ণ","জলবায়ু","তিমিশিকার","বাতাস","প্রতিযোগিতা","একধরনের ছোট মাছ ধরা নৌকা","আঁকাবাঁকা রেখা"};
    String [] marinEnglish={"Absorb","Abundance","Accelerate","Adaptation","Affect","Aground","Algae","Anchor","Aphotic","Aquatic","Arctic","Argosy","Assess","Atlantic","Atmosphere","Atoll","Bacteria","Balance","Bar","Barge","Basalt","Basin","Bathyscaphe","Bathysphere","Beach","Beneath","Bottom","Bounty","Breaking","Breakwater","Brine","Buoy","Changing","Cliff","Climate","Coastine","Collide","Commerce","Communication","Community","Conch","Conquest","Contamination","Continent","Coral","Creature","Crustacen","Current","Cycle","Data","Deep","Delicate","Deposit","Depth","Desalt","Destructive","Discovery","Dissolve","Distance","Diversity","Diving","Dock","Documentation","Domain","Dredge","Drift","Dwell","Dynamic","Echinoderm","Ecosystem","Effect","Elements","Endangered","Energy","Erosion","Estuary","Excursion","Exploration","Facilities","Feeding","Fertilizer","Fishing","Fjord","Float","Florescence","Flourish","Fluctuation","Fluid","Force","Giant","Globe","Gravity","Gulf","Gyre","Habitat","Harness","Heave","hemisphere","Host","Houseboat","Hurricane","Iceberg","Imperiled","Incoming","Indian","Industry","Inquiry","Interaction","Interdependence","Invasive","Invertebrate","Kelp","Kinetic","knot","Lagoon","Land","Lap","Larvae","Level","Leviathan","Life","Light","Lightening","Limit","Liquid","Living","Magma","Majesty","Mangrove","Mapping","Marine","Maritime","Marsh","Migration","Mix","Mollusk","Momentum","Monitor","Motion","Movement","Murky","Naturalist","Nautical","Navigation","Neaptide","Nekton","Nutrient","Ocean","Oceanic","Oceanography","Offshore","Operation","Organism","Outgoing","Oxygen","Pacific","Pattern","Peaceful","Pearl","Pelagic","Phenomena","Phytoplankton","Planet","Plankton","Pollutant","Pound","Predator","Prediction","Pressure","Prey","Production","Protection","Purify","quantity","Quest","Realm","Recreation","Reef","Renewal","Research","resource","restoration","Rhythm","Safety","Sailing","Salinity","Salty","Sand","Science","Scientist","Scuba","Sea","Seascape","Seasonal","Seawater","Seaweed","Secrets","Sediment","Scismic","Sextant","Shallow","Shelter","Shoreline","skeleton","Slope","Sonar","Sound","Species","Sponge","Swuid","Strength","Submarine","Submerge","Supply","Surface","Surfing","Surge","Survival","Swell","Technology","Teeming","Temperature","Terrace","Thrive","Tidalwave", "Tide","Transportation","Trench","Trough","Tsunami","Turbulence","Ubiquitous","Undertow","Underwater","Unique","Universal","Unlimited","Valley","Vapor","Variation","Vast","Velocity","Volcano","Volt","Warm","Water","Watery","Weather","Whaling","Wind","Yacht","Yawl","Zigzag"};
String[] physicBangla={"নিম্নতম সম্ভাব্য তাপমাত্রা","বেগবর্ধন","নিখুঁতভাব","স্বনবিদ্যা ও শ্রুতিবিদ্যা","কার্য","সংলগ্নতা","পরিবর্তন সাধন করা","পরিবর্তন করা","বিস্তার","কোণযুক্ত","আপাতপ্রতিয়মান","ব্যবহারিক","প্রয়োগ করা","প্রবণতা","অ্যারিস্টটল","চাহনি","বায়ুমন্ডল","পরমাণু","পরমাণু সম্মন্ধীয়","মূল্য কমা","আকর্ষণ শক্তি","বিমান চালনা বিজ্ঞান ও কৌশল","অক্ষ","ভারসাম্য","মৌলিক","সংস্থা","বোসনের","গাছের ডাল","পাথরি","সামর্থ্য","অপকেন্দ্র","বিশৃঙ্খলা","আক্রমণ করা","রাসায়নিক দ্রব্য","গোল","ধাক্কা খাওয়া","উপাদান","চাপন","ঘনীভবন","পদার্থের তাপ ও তড়িৎ সঞ্চালন শক্তি","সংরক্ষন","স্থির","শাসন করা","পরিবর্তন","বিশ্বতত্ত্ব","কিউরী","স্যাঁতসেঁতে","ডেসীবেল","আঘাতের দ্বারা গর্ত করা","আশ্রিত","নকশা আকা","উন্নয়ন","বিপথে গমন","ডিওড","লক্ষ্য","সংযম","স্থানচ্যুতি","দুরত্ব","বিকৃতি","গোলমাল","উচ্চ উপাধী প্রাপ্ত ব্যক্তি","ঠানা","গতিবিজ্ঞান","কাজের ফলাফল","আইনস্টাইন","স্থিতিস্থাপকতা","বিজলী","তড়িচ্চুম্বকয়ি","বিদ্যুৎ পরমাণু","বিদ্যুতিন-সংক্রান্ত পদার্থবিদ্যা","নিক্ষেপ","কর্মশক্তি","চালকযন্ত্র","যন্ত্রবিদ","এনট্রপি","সমীকরণ","ভারসাম্য","তুল্য বস্তু","বিলোপ","প্রসারণ","গবেষণা","বিস্ফোরক","বহিরাগত","গুণনীয়ক","বিভিন্ন অংশে ভঙ্গকরন","পলায়ন","প্রবাহিত হওয়া","তরল বা বাস্পীয়","ধাবমান","আলোক রশ্মির মিলন কেন্দ্র","সশস্ত্রবাহিনী","কাঠামো","সূত্র","কম্পাঙ্ক","ঘর্ষন","অবলম্বন","বাষ্প","উৎপাদন করা","ভূপদার্থবিদ্যা","গিলবার্ট","নকশা","মহাকর্ষ","ভার","পথনির্দেশক","যে বস্ত্র আবর্তনের নিয়ম প্রদর্শন করে","অর্ধেক জীবন","ঘোড়ার সাজ বর্মভূষিত করা","উত্তাপ","হের্তস","ধারণ","অভিন্ন","বল","ঝোক","জ্বলিয়ে শ্বেতবর্ণ ধারণ করে এমন","জড়তা","প্রভাব","পাল্টানো","তদন্ত","মিথস্ক্রিয়া","মধ্যস্থ","উদ্ভাবন","বিপরীত উলটা","তদন্ত","অদৃশ্য","বিশদ করা","আইসোটোপ","গতিবিদ্যা","লেজার","সমতল","ওঠানো","আলো","চিলে কোঠা","নালিকাগহবর","যন্ত্রপাতি","চুম্বকিয়","চৌম্বকীয়","বিরাটত্ব বিশালতা","পিন্ড","অঙ্কবিদ্যা","বিষয়","আকার","বিদ্যা","বায়ুবিজ্ঞান","শব্দ পরিবর্তন করা","অণু","গতি","চলন","নাবিকবিদ্যা","অস্বীকারমূলক","নিউটন","পারমাণবিক","কোষকেন্দ্র","আলোক বিদ্যা","দোলন","ভার","লম্বন","সমমর্যাদা","কণা অণু","সম্পাদন","বিস্ময়কর বস্তু","আলোককণা","চাপদন্ড","তাঁর গাড়া","রক্তরস","অবস্থা","ভবিষ্যদ্বাণী","চাপ","প্রধান","সবেগে নিক্ষিপ্ত গুলি","প্রসারণ","বৈশিষ্ঠ্য","আকার","সাই","কলাইডাল","গুণ","বিহুলতা","কোয়ান্টা","পরিমাণগত","সমষ্টি","তত্ত্ব-অনুমিত একধরণের অতি ক্ষুদ্র মৌল কণা","তাপ বিকিরণের সরঞ্জাম","তেজস্ক্রিয়তা","পরিগ্রহ","জাতিত্ব","সম্পর্কিত","আপেক্ষিকতা","বিতাড়ন","গবেষণা","প্রতিরোধ","সংকল্প","অনুনাদ","বিরাম","উলটানো","রোবোটিক্স","আবর্তন","পরিপৃক্তি","স্কালে","বিজ্ঞান","বৈজ্ঞানিক","ভূকম্পবিদ্যা","অর্ধপরিবাহী","আকার","স্থান পরিবর্তন করানো","ফাপা নয় এমন","ধ্বনিত","শব্দ","জায়গা","বর্ণালী","দুতি","স্থায়ি","অনড়","সংখ্যাদ্বারা প্রমাণিত তথ্যাবলি","মেলে ধরা","জোর","গঠন","পড়ার ঘর","পরমানন্দ","বস্তু","তল","ঝুলন্ত অবস্থা","প্রতিসাম্য","পদ্ধতি","তাপের মাত্রা","প্রসারণসাধ্য","চাপা উত্তেজনা","বাদীয়","মতবাদ","উত্তাপ-সম্বন্ধীয়","তাপগতিবিদ্যা","ধাক্কা দেওয়া","সোনার হেঁসো","হাতে কলমে শিক্ষা","গোলা-গুলি","পরিবর্তন","ট্রানজিস্টর রেডিও","অবস্থার পরিবর্তন","পশুকে জল দেবার লম্বা চৌকানো পাত্র","রাস্তার মোড়","অতিধবনক","অনিশ্চয়তা","একরুপ সর্বত্র সমান","এক করা","অনুপম","হিসাবের মান","সার্বজনিন","বিশ্ববিদ্যালয়","শূন্যস্থান","দাম","অস্থায়ি বস্তু","পরিবর্তনশীলতা","ভিন্নতা","একটি একমাত্রিক সারি","গতিবেগ","সান্দ্রতা","উদ্বায়ি","ভোল্ট একক দ্বারা পরিমিত তড়িৎ প্রবাহ","পুস্তক","ঢেউ","ওজন","এক্স-রশ্মি,এক্সরে"};
    String[] physicEnglish={"Absolute zero","Acceleration","Accuracy","Acoustics","Action","Adhesion","Affect","Altration","Amplitude","Angular","Apparent","Applied","Apply","Aptitude","Aristotle","Aspect", "Atmosphere","Atom","Atomic","Attenuate","Attraction","Aviation","Axis","Balance","Basic","Bodies","Boson","Branch","Calculus","Capacity","Centrifugal","Chaos", "Charge","Chemical","Circular","Collide","Component","Compression","Condensation","Conductivity","Conservation","Constant","Control","Conversion","Cosmology","Curie","Damping","Decibel", "Density","Dependence","Design","Developement","Deviation","Diode","Direction","Discipline","Displacement","Distance","Distortion","Disturbance","Doctorate","Drag","Dynamics","Effect","Einstein","Elasticity","Electricity","Electromagnetic","Electron","Electronics","Emission","Energy","Engine", "Engineer","Entrophy","Equation","Equilibrium","Equivalent","Evaporation","Expansion","Experiment","Explosion","External","Factor","Fission","Flight","Flow","Fluid","Flying", "Focus","Force","Form","Formula","Frequency","Fiction","Fulcrum","Gas","Generate","Geophysics","Gilbert","Graph","Graviation","Gravity","Guide","Gyroscope","Half-life","Harness","Heat"," Hertz","Hold","Identical","Impact","Impulse","Incandescent","Inertia","Influence","Innovate","Inquiry","Interaction","Intervening","Invention","Inverse","Investigation","Invisible","Irradiate","Isotope","Kinetics","Laser","Level","Lift","Light","Loft","Lumen","Machinery","Magnet","Magnetism","Magnitude","Mass","Mathematics","Matter","Measure","Mechanics","Meterology","Modulate","Molecule","Motion","Movement","Navigation","Negative","Newton","Nuclear","Nucleus","Optics","Oscillation","Overload","Parallax","Parity","Particle","Performance","Phenomenon","Photon","Piston","Pitch","Plasma","Position","Prediction","Pressure","Principle","Projectile","Propagation","Properties","Proportion","Psi","Pulse","Quality","Quandary","Quanta","Quantitative","Quantity","Quark","Radiation","Radioactivity","Reception","Relationship","Relative","Relativity","Repulsion","Research","Resistance","Resolution","Resonance","Rest","Reversal","Robotic","Rotation","Saturation","Scalar","Science","Scintific","Seismology","Semiconductor","Shape","Shift","Solid","Sonic","Sound","Space","Spectrum","Speed","Standing","Stationary","Statistics","Strain","Stress","Structure","Study","Sublimation","Substance","Surface","Suspension","Symmetry","System","Temperature","Tension","Theoritical","Theory","Thermal","Thermodynamics","Thrust","Torque","Training","Trajectory","Transformation","transistor","Transition","Trough","Turning","Ultrasonic","Uncertainty","Uniform","Unity","Unify","Unique","Unit","Universal","University","Vacuum","Value","Vapor","Variable","Variation","vector","Velocity","Viscosity","Volatile","Voltage","Volume","Wave","Weight", "X-ray"};
String[] cHEMISTRYBangla={"টক","আম্লিক","পরিবর্তন সাধন করা","অপরাসায়নবিদ","ক্ষারীয়","বহুরুপ","পরিবর্তন করা","বিশেষন","অনিয়ম","রক্তস্রোতের মধ্যে বাইরের থেকে প্রবিষ্ঠ পদার্থ","যন্ত্রপাতি","দরখাস্ত","বিনাশ","ফিল্টার বহির্ভূত নির্বাচন","পরমাণু সম্বন্ধীয়","পতন","ভারসাম্য","বনিয়াদ","আলকাতরা হইতে উৎপন্ন তরল পদার্থ","বন্ধনে","ব্রোমিন","জলন্ত","অঙ্গার","ক্যান্সারজনক পদার্থ","অনুঘটক","একজনের জন্য ক্ষুদ্র কক্ষ","তাপমাত্রা যন্ত্র","শেকল","বিনিময় করা","ক্লোরিন","মসলা","সংযুক্তি","রচনা","মিশ্রিত করা","এলকাগ্রতা","অবসান","অপচয়","কাঁচ","চলতি","উপায়","পচানি","নির্লবণীকরন","সংকল্প","রাবিশ","আবিস্কৃত বিষয়বস্তু","প্রদর্শ্ন করা","পাতন ","গতিবিজ্ঞান","পুস্পায়ন","বৈদ্যুতিক","তড়িৎ বিশ্লেষন","ইলেকট্রন","আবহাওয়া","উৎসেচক","সমতা","ইস্টার","পরীক্ষা","খামি","বিভিন্ন অঙ্গে ভঙ্গকরণ","তরল","ফ্লোরিন","সূত্র","বাস্প","হ্যালোজেন","উত্তাপ","গ্যাস বিশেষ","উদজান ও অঙ্গারজানের যৌগিক পদার্থ","স্বাদ গন্ধ ও বর্ণহিন গ্যাস","জলের সহিতে রাসায়নিক ক্রিয়ার ফলে বিয়োজন","একটি হাইড্রক্সিল গ্রুপ হিসাবে অক্সিজেন এবং হাইড্রোজেন ধারণকারী যৌগ","আগে থেকেই যা সত্য বলে মেনে নেওয়া হয়েছে","অবিশুদ্ধতা","অলস","জড়","দময়িতা","অজৈব","তদন্ত","আদেশ","মিথস্ক্রিয়া","পরস্পরের উপর ক্রিয়াশীল","তদন্ত","রাসায়নিক মৌলিক পদার্থবিশেষ","পরমাণু","আইসোমার","আইসোটোপ","গতিবিদ্যা","লেজার","আলো","লিপিড","তরল পদার্থ","আকর্ষণ করা","বিষয়","আকার","গলানো","রোগ জীবানু","মিশ্রিত","অণু","বায়ুমন্ডলের গ্যাসবিশেষ","ব্যর্থ করা","অধাতব","পারমাণবিক","কোষকেন্দ্র","বচন","কক্ষ","জৈব","অভিস্রাবন","জারণ","অক্সিজেন","কণা অণু","পর্যায়-সারণী","ঔষধসংক্রান্ত বিজ্ঞান","ঘটনা","কায়িক","পিপেট","অবিশুদ্ধতা","পলিমার","বল","কার্যকর","পরোয়ানা","বৈশিষ্ঠ্য","প্রোটিন","বিশুদ্ধ","তত্ত্ব অনুমিত একধরনের অতি ক্ষুদ্র কণা","তাপ বিকিরণের সরঞ্জাম","সমুলগত","তেজস্ক্রিয়তা","প্রতিঘাত","বিকারক","সংশোধন করা","হ্রাস","শোধন করা","খালাস করা","প্রকাশ","পূর্ব অবস্থায় ফিরে যাওয়া","নুন","বিজ্ঞানি","অর্ধপরিবাহী","বিচ্ছিন্নভাবে","সমাধানযোগ্য","দ্রাবক","দুতি","বস্তু","ঝুলন্ত অবস্থা","মিথোজীবিত্ব","চিহ্ন","ঐকতান","সংশ্লেষণ করা","টেবিল","তাপের মাত্রা","অধিবিষ","পরিবর্তন","অবস্থার পরিবর্তন","হিসাবের মান","ররর","সাদা তেজস্ক্রিয় ধাতব পদার্থবিশেষ","যোজ্যতা সংখ্যা","হাঁ-সূচক বাক্য","চিত্তবিকার","বদলানো","বহুমুখী","সান্দ্রতা","জল","ওজন","গ্যাসবিশেষ","দস্তা","হরিণ"};
    String [] cHEMISTRYEnglish={"Acid","Acidic","Affect","Alchemist","Alaline","Allotrope","Alteration","Analysis","Anomaly","Antigen","Apparatus","Application","Arrangement","Astatine","Atomic","Antrophy","Balance","Base","Benzene", "Bonding","Bonding","Bromine","Burning","Carbon","Carcinogen","Catalyst","Cell","Centigrade",
            "Chain","Change","Chlorine","Collid","Combination","Composition","Compound","Concentration","Conclusion","Consumption","Crystal","Current","Data","Decomposition","Desalination","Determination","Detritus","Discovery","Display", "Distillation","Dynamics","Efflorscence","Electrical","Electrolysis","Electron","Elements","Enzyme","Equilibrium","Ester","Examination","Ferment","Fission","Fluid","Fluorine","Formula","Gas","Halogen","Heat","Helium","Hydrocarbon","Hydrogen","Hydrolysis","Hydroxide","Hypothesis","Impurity","inactive","Inert", "Inhibitor","Inorganic","Inquiry","Insruction","Interaction","Interactive","Investigation","Iodine","Ion",
            "Isomer","Isotope","Kinetics","Laser","Light","Lipid","Liquid","Magnetic","Matter","Measure","Melt","Microbe","Mixture","Molecule","Neon","Neutralize","Nonmetallic","Nuclear","Nucleus", "Number","Orbit","Organic","Osmosis","Oxidation","Oxygen","Particle","Periodic table","Pharmacology","Phenomena","Physical","Pipette","Pollution","Polymer","Power","Practical", "Process","Properties","Protein","Pure","Quark","Radiation","Radical","Radioactivity","Reaction","Reagent","Rectify","Reuction","Refine","Release","Revelation","Revert", "Salt","Scientist","Semiconductor","Separation","Soluble","Solvent","Speed","Substance","Suspension","Symbiosis","Symbol","Synergy","Synthesize","Table","Temperature","Toxin", "Transformation","Transition","Unit","Unreative","Uranium","Valency","Validation","Vapor","Validation", "Vapor","Vary","Versatile","Viscosity","Water","Weight","Xenon","Zinc","Zirconium"};
    String[] biologyBangla={"পরিশোষণ", "বর্ণ কারবিহীন", "উপোযোগী করা", "বায়ুজীবী", "শেওলাগুলি", "খাদ্য সংক্রান্ত", "রোগ বিশেষ", "আদ্য প্রাণী", "ঊভচর প্রানী", "শব্দ", "শরীরবিদ্যা", "পূর্ব পুরুষ", "প্রোটিনজাতিও পদার্থ যা ক্ষতিকর পদার্থ কে নিষ্কিয় করে", "লেজুড়", "জলচর", "ব্রাক্ষ", "অযৌন", "পরিপাক", "অবক্ষয়", "শ্রোত বর্গ", "শিঢ়দাতা", "রোগ জীবানু",  "দাড়িপাল্লা", "বেড়া", "প্রশন্ন", "জীববিদ্যা", "বায়োম",
            "দুই ভাগে ভাগ করা", "উদ্ভিদ বিজ্ঞান", "শ্বাস-প্রশ্বাস নেওয়া", "মাংসাসী", "অনুঘটক", "খোল", "জেলে", "যে উপাদানে পাতার রঙ সবুজ হয়", "কলেস্টেরল", "বর্ণ ময়", "ক্রোমোসোম",  "নেত্তলোম", "শ্রেনী বিভাগ", "সংযোজনশীল", "কোলাজেন", "জ্ঞাপনীয়", "সম্প্রদায়", "সংকোচন", "দমন করা", "মোচড়ানো", "হৃৎপিণ্ড রক্ত সঞ্চালক শিরা", "ইংরেজী প্রকৃতিবাদী", "অপম্রিয়মান", "পচানি", "অন্তস্ত্বক", "বেড়ে উঠা", "বিররীত মুখি", "পথ্য সম্বন্ধীয়", "বিভেদ", "প্রচার প্রশারন", "পরিপাক","প্রাগ্রেতিহাসিক অতিকায় সরীসৃপ", "সংযম", "স্থানচ্যুতি", "বিভাগ", "ডিএনএ", "কৃতিত্বপুণ্য", "সুপ্ত", "বাস্তব বিদ্যা", "বাস্ত", "জীবকোষের বরিরারনণ", "শোথ", "ভ্রুন", "আপন্ন",
            "দেশগত", "শক্তি", "পরিবেশ", "প্রাচীর জীবন্ত কোষে উৎপন্ন রাসায়নিক পদাওরথবিশেষ", "বহিত্বক", "ক্ষয়", "অতযাবশ্যকীয়", "ইস্টজেন", "ক্রমবিকাশ", "উস্নুলন", "অধুনালুপ্ত", "অন্যতম হেতু", "পুনর্নিবেশ", "গর্ভাধান", "ভ্রুন", "সুক্ষ", "মাছ", "বিভিন্ন অংশের ভজ্ঞকরন", "জীবাশ্ম", "বিশেষ", "জননকোষ", "গ্যাস পূর্ণ", "প্রজননশাস্র", "জিনোম", "মহাজাতি",
            "বীজ", "গর্ভ ধারনকাল", "কোদাল", "জন্ম", "জন্তর", "হিমোগ্লোবিন", "তৃণভোজীপ্রানী", "বংশের ধারা", "বিবিধ জাতীয় পদার্থ", "শীতযাপনতা", "ঘাজকগন", "সমজাতীয়", "শরীরের ভেতরের যে রশ রক্তের সাথে মিশে শরীর কে কার্যক্রম করে", "উদ্যান পালন বিদ্যা", "নিয়ন্ত্রণ কর্তা", "সহুদয়", "দোঁআশলা", "রোগসুংক্রামন থেকে নিরাপত্তা", "অন্তর্ভুক্তি", "ডিমের উপর বসা", "আহার", "টিকা দেওয়া", "তদন্ত", "অদ্রবনীয়", "প্রেরনা", "ইন্সুলিন", "পরস্পর নির্ভয়শীল","অমেরুদণ্ডী", "ইচ্ছা নয় এমন", "বিচ্ছিন্ন করা", "আইসো্টোপ", "সন্ধিক্ষন", "রাজ্য", "অক্ষরেখা", "গাছের পাথা", "জীবনচক্র", "দুটো ঘটনার", "জীবিকা", "আলোকউৎসাহী", "লসিকা", "বিদ্বেশপূর্ণ",
            "স্তন্যপায়ী", "সামুদ্রিক", "একশ্রেণীর অর্থালংকার", "প্রানী", "স্মরনকাল", "জীবদেহের রাসায়নিক রুপান্তর", "জীবার্ণুবিজ্ঞান", "অণুবিক্ষণ যন্ত্র", "অভিপ্রয়অণ", "চিতা", "ঝরান", "মাংসপেশী", "নামজার", "পারস্পরিক মজ্ঞলজনক সহ্যবস্থান", "স্বাভাবিক", "স্লায়ু", "স্নায়ুকোষ ও তার শাখাপ্রশখা", "নাইট্রোজেন",  "কোষকেন্দ্র যে কেন্দ্রী অংশের চারপাশে অপরাপর অংশ গুলো জড়ো হয়", "সর্বভোগ", "দৃষ্ট্রি", "ক্রম", "অভিস্রাবণ", "অস্মীভবণ", "অগুপ্রসূ", "জারণ", "জীবাশ্মবিদ", "পরাভুক প্রানী", "রোগজনক শক্তি",

            "প্রবেশ্য ভেদ্য", "সালোকসংশ্লেষন", "সমুদ্র নদী জলে ভাসন্ত", "রক্তরস", "প্লেটলেট", "পরাগ", "অবিশুদ্ধতা", "অংশ", "প্রানীদের", "সংরক্ষণ করা", "চাপ", "পন্যদ্রব্য উৎপাদত্তপাদক", "প্রোটিন", "জীবনের মূলীভূত উপাদান", "ফুসফুস সংক্রান্ত", "প্রাচীন পিরামিড", "অনুসন্ধান", "প্রশ্ন", "অরীয়", "রিসেপটর", "পিছু হটে যাবার", "পূর্ণব্যবহারযোগ্য", "প্রতিফলিত", "নবপ্রেরণা লাভ", "বিধি", "উল্টোদিকে মুড়ানো", "দমন করা", "যে সব প্রাণী বুকে ভর দিয়ে চলে", " অবশিষ্ট", "উপায় সম্ভাবনা", "শ্বাস", "বাধা", "শিকড়", "কর্ম পরিধি", "গোপন করা", "বীজ", "সেন্সর", "কঙ্কাল", "খোসা", " সৌর", "দূরত্ব সংক্রান্ত", "কুল", "নমুনা","প্রমানিত তথ্যাবলী","উদ্দীপনা",
            "জোর", "গঠন"," জীবনযাপন", "প্রতিসাম্য", "পান্ত সন্নিকর্ষ", "পদ্ধতি", "স্বাদ", "শ্রেনীবিন্যাস", "শূয়া", "পার্থিব", "তত্ত্ব", "সহনশীলতা", "উপবিষ", "রুপান্তর", "ত্বক দিয়া নিঃসরণ", "উত্তর মেরু অঞ্চলের বরফ্রাই", "স্ফীট", "অপরিপৃক্ত", "দেহাবয়বে বায়ু", "ভিন্নতা", "বায়ু চলাচল করানো", "মেরুদন্ডী","টিকে থাকতে সক্ষম এমন","সংক্রামক রোগের অদৃশ্য জীবানু বিশেষ",

            "প্রোয়োজনীয়", "ভিটামিন","ডিমের বদলে শাবক প্রসবকারিণী", "পুস্তক", "স্বেচ্ছাকৃত", " অকেজো", "জলবায়ু", "মেখলা", "প্রাণীবিদ্যা"};
    String[] biologyEnglish={"Absorption","Achromatic","Adaptation","Aerobic","Algae","Alimentary","Allergy","Amoeba","Amphibian","Analogue","Anatomy","Ancestor","Antibody","Appendage","Aquatic","Arboreal","Asexual","Assimilation","Atrophy","Auditory","Backbone","Bacteria","Balance","Barrier","Benign","Biology","Biome","Bisect","Botany","Branch","Breathe","Carnivorous","Catalyst","Cavity","Cell","Chlorophyll","Cholesterol","Chromatic","Choromosome","Cilia","Classification","Cohesive","Collagen","Communicable","Community","Contraction","Control","Convolution","Coronary","Cyclic","Darwin","Deciduous","Decomposition","Dermis","Develop","Dichotomous","Dietary","Differentiation","Diffusion","Digestion","Dinosaur","Discipline","Displacement","Division","Dna","Dominent","Dormant","Ecology","Ecosystem","Ectoplasm","Edema","Embryo","Endengered", "Endemic","Energy","Environment","Enzyme","Epidermis","Erosion","Essential","Estrogen","Evolution","Extermination","Extinct","Factor","Feedback","Fertilization","Fetus","Filament", "Fish","Fission","Fossil","Function","Gamete","Gaseous","Genetics","Genome","Genus","Germ","Gestation","Grafting","Growth","Habitat","Hemoglobin","Herbivore", "Heredity","Heterogenous","Hibernation","Hierarchy","Homogeneous","Hormone","Horticulture","Host","Human","Human","Hybrid","Immunity","Inclusion","Incubate","Ingestion","Inoculate","Inquiry","Insoluble","Instinct","Insulate","Insulin","Interdependent","Invertebrate","Involuntary","Isolate","Isotope","Juncture","Kingdom","Latitude","Leaf","Lifecycle","Linkage","Living","Luminescent","Lymph","Malignant","Mammal","Marine","Meiosis","Membrane","Memory", "Metabolism","Microbiology","Microscope","Migration","Mildew","Molt","Muscle","Mutation","Mutualism","Natural","Nerve","Neuron","Nitrogen","Nucleus","Omnivorous","Optic","Order","Osmosis","Ossification","Oviparous","Oxidation","Paleontologist","Parasite","Pathogen","Permeable", "Photosynthesis","Plankton","Plasma","Platlet","Pollen"," Pollution","Portion","Predator","Preserve","Pressure","Producer","protein","Protoplasm","Pulmonary","Pyramid","Quest", "Question","Radial","Receptor","Recessive","Recycling","Reflex","Regeneration","Regulate","Replicate","Repress","Reptile","Residual","Resource","Respiration","Restriction","Root", "Scope","Secrete","Seed","Sensor","Shelter","Skeleton","Skin","Soler","Spatial","Species","Specimen","Statistics","Stimulus","Stress","Structure","Symbiosis","Symmetry","Synapse","System","Taste","Taxonomy","Tendril","Terrestrial","Tissue","Tolerance", "Toxin","Transformation","Transpiration","Tundra","Turgid","Unsaturated","vacuole","Variation","Ventilate","Vertebrate","Viable","Virus","Vital","Vitamin","Viviparous","Volume", "Voluntery","Waste","Weather","Z","Zone","Zoology"};

String[] astronomyBangla={"সত্যপথ হতে স্থলন","বিশুদ্ধ","ত্বরণ","অবদান","শাসন কার্য","ঝুকি","বায়ুগতিবিজ্ঞান","বিমান উড্ডয়ন এলাকা","মাধ্যম","বিমানবল","বিদেশীলোক","লম্বের উচ্চতা","পরিবেষ্টনকারী","উগ্র গন্ধযুক্ত গ্যাস বিশেষ","বিশেষন","অনিয়ম","চূড়া","অপসূর","অপভূ","চরম বিকাশ","বৃত্তের চাপ","প্রবল","গ্রহানু","মহাকাশযাত্রী","জ্যোতির্বিদ","গ্রহ বিজ্ঞান","বায়ুমন্ডল","অক্ষ","দিগ্বলয়","নাগালের বাইরে","দ্বিমূল","অন্ধকূপ","গনগনে","সংস্থা","যে টেবিলে খাদ্য ও পানিও রাখা হয়","পোড়ানো","ভেঙ্গে খুলে ফেলা","কোন দ্রব প্রস্তুত কালে উৎপন্ন দ্রব্য","স্বর্গীয়","বিবাহাদি","আহবানকারী","বিশৃঙ্খলা","গোল","আবহাওয়া","ঠান্ডা","প্রবল ধাক্কা","বিশাল","বিস্ফোরন ঘটাতে","ধূমকেতু","সেনাপতি","যোগাযোগ","রচনা","মিলন","ফলশ্রুতি","নক্ষত্রপুঞ্জ","কর","জ্যোতির্বলয়","মহাজাগতিক","সৃষ্টিতত্ত্ব","মহাকাশচারী","আগ্নেয়গিরির মুখ","নিবিকদল","জনতা","শিখর","বিপদ","উপায়","বিনতি","কোণ","আঘাতের দ্বারা গর্ত করা","যুদ্ধ করবার জন্য শ্রেণীর বিস্তার","বংশধর","অবরোহ","অনর্থ","আবিষ্কৃত বিষ্য বস্তু","অংশ গুলির বিযুক্ত করা","প্রদর্শন করা","দূরবর্তী","দলিল রচনা","শাসন কর্তৃত্ব","তারকাযুগল","বাতাসে ভেসে যাওয়া","গুড়া","গ্রহণ","অয়নবৃত্ত","আইনস্টাইন","ইলেকট্রন","ডিম্বাকার ক্ষেত্র","নিক্ষেপ","ঘেরাও করা","বাস্তুকার","যুগ","বিষুবরেখা","যে সময়ে দিবারাত্র সমান হয়","সাজসরঞ্জাম","চিহ্ন","বিবর্তন","অঞ্চল","অভিযান","পরীক্ষা","আবিস্কারের জন্য খোজ","আকস্মিক প্রবল বিস্ফোরক","অনাবৃতকরণ","বহিরাগত","অতিরিক্ত স্থলজ","উল্কাপিন্ড","পলায়ন","গঠন","খন্ড","পূর্ণিমা","ছায়াপথসংক্রান্ত","ছায়াপথ","গামারশ্মি","গ্যাসপূর্ণ","ভূকেন্দ্রী","ভূপ্রকৃতিবিদ্যা","গোলাকার","যশ","মহাকর্ষ","ভার","যে বস্ত্র আবর্তনের নিয়ম প্রদর্শন করে","বিপদ","সদর","উত্তাপ","গোলার্ধ","ইতিহাস অনুযায়ি","সম্মান","দিগন্ত","কোষ্ঠী","জলবাহী","আগে থেকেই সত্য বলে মেনে নেওয়া","খুব ঠান্ডা","আগুন ধরা","আঁচ","আলোকসজ্জা","প্রতিমা","আশূ","প্রভাহ","ঝোক","শিল্প","তদন্ত","পরিদর্শন","তদন্ত","আয়নমন্ডল","জাহাজ হইতে দ্রব্যাদি জলে নিক্ষেপ","ভ্রমণ","বৃহস্পতি গ্রহ","সমর্থন","রসায়নাগার","লঞ্চ","উইল","ঔজ্জ্বল্য","চন্দ্র","আকর্ষণ করা","বিশালতা","পরিকল্পিতভাবে পরিচালন","নকশা","ঘোটকী","মঙ্গলগ্রহ","বিস্ময়","উল্কা","উল্কা","এক প্রকারের বর্ণহীন গ্যাস","দৌতা","পরিমাপের প্রমাণ","সর্বনিম্ন","নাবিকবিদ্যা","ছায়াপথ","নিউটন","কেন্দ্রবিন্দু","যে নক্ষত্রের ঔজ্জ্বল্য হঠাত খুব বৃদ্ধি পেয়ে তারপর স্তিমিত হয়ে আসে","ঘাড় নাড়া","উদ্দেশ্য","পর্যবেক্ষনের উপযুক্ত","অস্রপচার","কক্ষ","উদ্ভব","মহাশূন্য","ঢোকিয়া অংশত","ঘনীভূত","লম্বন","পথ","বিদ্ধ করা","চন্দ্র বা সূর্য গ্রহনের সময় পূর্ণ ছায়ার চারদিকে আংশিক ছায়া","অনুভূ","চাঁদের কলা","অগ্রগামী","গ্রহ","তরাগ্রহ","গ্রহ সম্বন্ধীয়","ধ্রুবতারা","তৃপ্তি","অনুসন্ধান করা","উর্বর","কার্যক্রম","ছড়াবার","চালনশক্তি","রক্ষা","ধনাত্বক বিদ্যুতের একক","যন্ত্রপাতি","জনসাধারণ","পালসার","কোয়েসার","সারাংশ","তাপ বিকিরণের সরঞ্জাম","পুনরাধিকার","দর্পণ","বাতিল করা","আপেক্ষিকতা","নির্ভরযোগ্যতা","সমাবেশের পূর্ব নির্দিষ্ট স্থান","গবেষনা","দায়িত্ব","বাধা","আবর্তন","রকেট","ঘূর্ণন","উপগ্রহ","বৈজ্ঞানিক","বিজ্ঞানি","সিসমোমিটার","সংবেদন","বৈঠক","সেকসট্যান্ট","খসে-পড়া তারা","মাকু","অর্থযুক্ত","আদিখেত্যা","আকার","আকাশ","উচ্চে উড়া","অয়তান্ত-বিন্দু","জায়গা","ব্যোমযান","দূরত্বসংক্রান্ত","বর্ণালিবীক্ষণ","বর্ণালী","গোলাকার","কাটনা","স্টারডাস্ট","নক্ষত্র সম্বন্ধীয়","বায়ুমন্ডলের স্তর বিশেষ","অতিপারমাণবিক","সাফল্য","সৌরকলঙ্ক","আরেকটির উপরে স্থাপন করা","সহ্য করা","ভোগ করা","ঘূর্ণিত করা","প্রযুক্তিবিদ্যা","দূরবীন","তাপের মাত্রা","পৃথিবী","ধাক্কা দেওয়া","স্রোত","গতিপথ","বিয়োগান্ত নাটক","হাতে কলমে শিক্ষা","গোলা-গুলি","পরিবহণ করা","কোলাহল","মিটমিট করে জ্বলা","উপচ্ছায়া","একমাত্র","বিশ্বজগৎ","অজ্ঞাত","চঞ্চল","গ্রহবিশেষ","বাষ্পে পরিণত হওয়া","ভিন্নতা","বৈচিত্র্য","বিশাল","যানবাহন","গতিবেগ","ফোকর","স্পন্দন","নৈকট্য","দৃষ্টি","তীব্রতা","ফলতঃ বটে","সুস্পষ্ট","দর্শন","আগ্নেয়গিরি হইতে উৎপন্ন","স্ব্বেচ্ছাকৃত","সমুদ্রযাত্রা","উষ্ণতা","তরঙ্গদৈর্ঘ্য","আবহাওয়া","প্রভাবহীনতা","ঘূর্ণন","আগ্রহ","সু-বিন্দু","শূন্য","রাশিচক্র"};
    String[] astronomyEnglish={"Aberration","Absolute","Acceleration","Achievement","Administration","Adventure","Aerodynamics","Aerospace","Agency","Airforce","Alien","Altitude","Ambient","Ammonia","Analysis","Anomaly","Apex","Aphelion","Apogee", "Apotheosis","Arc","Ascendant","Asteroid","Astronaut","Astronomer","Astronomy","Atmosphere","Axis","Azimuth","Beyond","Binary","Black hole","Blazing","Bodies","Buffet", "Burn","Burst","Byproduct","Celestial","Ceremony","Challenger","Chaos","Circuler","Climate","Cold","Collision","Colossal","Combust","Comet","Commander","Communication", "Composition","Conjunction","Consequence","Constellation","Contribution","Corona","Cosmic","Cosmology","Cosmonaut","Crater","Crew","Crowd","Cusp","Danger","Data","Declination","Degree","Density","Deploy","Descendant","Descent","Disaster","Discovery","Disintergrate","Display","Distant","Documentation","Domination", "Double star","Drift","Dust","Eclipse","Ecliptic","Einstein"," Electron","Ellipse","Emission","Encircle","Engineer","Eon","Equator","Equinox","Equipment","Evidence", "Evolution","Expansion","Expedition","Experiment","Exploration","Explotion","Exposure","External","Extraterrestrial","Fireball","Flight","Formation","Fragment","Full moon","Galactic","Galaxy", "Gamma rays","Gaseous","Geocentric","Geophysics","Global","Glory","Gravitation","Gravity","Gyroscope","Hazarad","Head-quarters","Heat","Hemisphere","historic","Honor","Horizon","Horoscope","Hydraulic","Hypothesis","Icy","Ignite","Ignition","Illumination","Image","Immediate","Impact","Impulse","Industry","Inquiry","Inspection","Investigation","Ionosphere","Jettison","Journey","Jupiter","Justification","Laboratory","Launch","Legacy","Luminosity","Lunar","Magnetic","Magnitude","Maneuver","Map","Mare","Mars","Marvel","Meteor","Meteorite","Methane","Mission","Module","Nadir","Navigation","Nebula","Newton","Node","Nova","Nutation","Objective","Observable","Operation","Orbit","Origin","Outer space","Overlap","Ozone","Parallax","Path","Penetrate","Penetrate","Penumbra","Perigee","Phase","Pioneer","Planet","Planetarium","Planetary","Polestar","Praise","Probe","Productive","Program","Propellant","Propulsion","Protection","Proton","Prototype","Public","Pulsar","Quasar","Quintessence","Radiation","Re-entry","Reflector","Reject","Relativity","Reliability","Rendezvous","Research","Responsibility","Restriction","Revolution","Rocket","Rotation","satellite","Scientific","Scientist","Seismometer","Sensation","Session","Sextant","Shooting star","Shuttle","Significant","Simulation","Size","Sky","Soar","Solstice","Space","Space craft","Spatial","Spectrometry","Spectum","Spherical","Spinning","Star dust","Stellar","Stratosphere","Sbatomic","Success","Sunspot","Super nova","Support","Sustain","Swirling","Technology","telescope","Temperature","Terra","Thurst","Tide","Track","Tragedy","Training","Trajectory","Transport","Turbulence","Twinkle","Umbra","Unique","Universe","Unknown","Unstable","Uranus","Vaporize","Variation","Variety","Vast","Vehicle","Velocity","Vent","Vibration","Vicinity","View","Violence","Virtual","Visible","Vision","Volcanic","Voluntary","Voyage","Warming","Wavelength","Weather","Weightlessness","Whirl","Zeal","Zenith","Zero","Zodiac"};
String[] vitaminsBangla={ "অভাব", "শোষন", "মোট পরিমাণ", "আবেদন করা", "উপস্থিতি",
        "ভারসাম্য", "দাড়িপাল্লা", "আচরন", "স্রোতের", "দেহ", "বোতল", "বিরতি", "সম্মেলন", "উপাদান", "হওয়া", "নষ্ট করা", "ধরে রাখা", "ধারন করে যে", "পরিবর্তন", "পরিবর্তন করা", "প্রত্যহ", "দুধ ও ঘি বিক্রয়ের স্থান", "বিয়োগব্যাথা", "পথ্য", "পথ্য সম্বন্ধীয়", "পীড়া", "ডাক্তার", "ডোজ", "অত্যাবশযকীয়", "দৃষ্টি", "সহজতর করা", "পালন করা", "খাদ্যদ্রব্য", "ফল", "জ্বালানি", "বিষেশ", "জন্ম"," আরোগ্য", "সুস্থ অবস্থা", "স্বাস্থ্য", "পাকস্তলীতে গ্রহন করা", "বিরোধী হওয়া", "পুরনো বাঝে জিনিষ", "সমতল", "তরল পদার্থ", "কলিজা", "বজায় রাখা", "পুষ্টির অভাব", "বিপাকীয়",
        "আকরিক", "স্বাভাবিক", "নার্ভতন্ত্র","পুষ্টি", "আজ্ঞিক", "ঔষধের বড়ি", "পাউডার", "ক্রম পএ", "উন্নীত করা", "আশ্রয়", "লক্ষ্য", "পরিমান", "সুপারিশ", "ব্যায়াম পদ্ধতি", "পূরণ করা", "প্রয়োজন", "সাড়া", "অভিনেতার ভূমিকা", "চামড়া", "উত্তপত্তিস্থল",  "গুদামজাত", "পড়ার ঘর", "বস্ত", "সংযোজন",
        "ভরত পাখি", "সমন্বয়", "ফলক", "গ্রহন করা", "সময়", "বাদা না দেওয়া", "অব্যবহিত", "মূল্য", "বিভিণ্ন বস্তুর সমষ্টি", "শাক সবজী", "ভিটামিন", "ওজন", "সুখ", "অনাময", "তারুণ্য"};
    String[] vitaminsEnglish= {"Absence", "Absorption", "Amount", "Appeal", "Apparence", "Balance", "Behavior", "Bloodsstream", "Body", "Cessation", "Combination", "Component", "Compound", "", "Consume", "Contain",
            "Container", "Conversion", "Convert", "Dairy",
            "Deprivation", "Diet", "Dietary", "Disease", "Doctor", "Dosage", "Dose", "Energy", "Essential", "Eyesight", "Facilitate", "Follow", "Food", "Fruit", "Fuel", "Function", "Growth", "Healing", "Health", "Hyginene", "Ingest", "Jar", "Junk", "Level", "Liquid", "Liver", "Maintain",
            "Metabolic", "Mineral", "Natural", "Nervous System", "Nutrition", "Organic", "Pill", "Powder", "Program", "Promote", "Protection", "Purpose", "Quantity", "Reaction", "Recommended", "Regimen", "Replenish", "Requirement", "Response", "Role", "Skin", "Source", "Stored", "Study", "Stustance", "Supplement", "Swallow", "Synthesis", "Tablet", "Take", "Time", "Tolerate", "Unused", "Value", "Variety", "Vrgetables", "Vitamin", "Weight", "Well being", "Wellness", "Youth"};


    LinearLayout education,food,vegetable,fish,corns,mathematics,shape,fruits,spices,geography, weather, scienceBtn, stateandgovt, lawandcourt, measurement, postal,tread,daymonth,medicine,
            globalpolitics,warandweapons,menandwomen,limbs,nation,stateofman,religion,relatives,people,birds,wormandinsect,diseases,reptiles,
            animals,limbsofanimals,criesofanimals,cultivation,naturalobject,flower,treeandplants,clothes,householdart,dwellinghouse,game,metalsandminerals,color,ornaments,musical,vehicle,
            branchesofedu, direction,daymonthseason,feeling, administration,commerce,marine,physics,chemistry,biology,astronomy,vitamins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         mAdView = (AdView) findViewById(R.id.adView);
         adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        interstitial = new InterstitialAd(MainActivity.this);
        // Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));


        // Prepare an Interstitial Ad Listener





        education = (LinearLayout) findViewById(R.id.education);
        food = (LinearLayout) findViewById(R.id.food);
        vegetable = (LinearLayout) findViewById(R.id.vegetable);
        fish = (LinearLayout) findViewById(R.id.fish);
        corns = (LinearLayout) findViewById(R.id.corn);
        mathematics = (LinearLayout) findViewById(R.id.math);
        shape = (LinearLayout) findViewById(R.id.shape);
        fruits = (LinearLayout) findViewById(R.id.fruits);
        spices = (LinearLayout) findViewById(R.id.spices);
        geography = (LinearLayout) findViewById(R.id.geography);
        weather = (LinearLayout) findViewById(R.id.weather);
        scienceBtn = (LinearLayout) findViewById(R.id.science);
        stateandgovt = (LinearLayout) findViewById(R.id.state);
        lawandcourt = (LinearLayout) findViewById(R.id.law);
        measurement = (LinearLayout) findViewById(R.id.measurement);
        postal = (LinearLayout) findViewById(R.id.postal);
            tread = (LinearLayout) findViewById(R.id.trade);
        daymonth = (LinearLayout) findViewById(R.id.day);
        medicine = (LinearLayout) findViewById(R.id.medicine);
        globalpolitics = (LinearLayout) findViewById(R.id.global);
        warandweapons = (LinearLayout) findViewById(R.id.war);
        menandwomen = (LinearLayout) findViewById(R.id.men);
        limbs = (LinearLayout) findViewById(R.id.limbs);
        nation = (LinearLayout) findViewById(R.id.nation);
        stateofman = (LinearLayout) findViewById(R.id.stateofman);
        religion = (LinearLayout) findViewById(R.id.Religion);
        relatives = (LinearLayout) findViewById(R.id.relatives);
        people = (LinearLayout) findViewById(R.id.people);
        birds = (LinearLayout) findViewById(R.id.bird);
        wormandinsect = (LinearLayout) findViewById(R.id.wormandinsect);
        diseases = (LinearLayout) findViewById(R.id.diseases);
        reptiles= (LinearLayout) findViewById(R.id.reptiles);
        animals = (LinearLayout) findViewById(R.id.animal);
        limbsofanimals = (LinearLayout) findViewById(R.id.limbsofAnimals);
        criesofanimals = (LinearLayout) findViewById(R.id.criesofanimal);
        cultivation = (LinearLayout) findViewById(R.id.cultivation);
        naturalobject = (LinearLayout) findViewById(R.id.naturalobject);
        flower = (LinearLayout) findViewById(R.id.flower);
        treeandplants = (LinearLayout) findViewById(R.id.treesandplants);
        clothes = (LinearLayout) findViewById(R.id.clothes);
        householdart = (LinearLayout) findViewById(R.id.household);
        dwellinghouse = (LinearLayout) findViewById(R.id.dwellings);
        game = (LinearLayout) findViewById(R.id.gameandsports);
        metalsandminerals = (LinearLayout) findViewById(R.id.metals);
        color = (LinearLayout) findViewById(R.id.colours);
        ornaments = (LinearLayout) findViewById(R.id.ornaments);
        musical = (LinearLayout) findViewById(R.id.musicalinstrument);
        vehicle = (LinearLayout) findViewById(R.id.vehicle);
        branchesofedu = (LinearLayout) findViewById(R.id.branches);
        direction = (LinearLayout) findViewById(R.id.direction);
        daymonthseason = (LinearLayout) findViewById(R.id.daymonth);
        feeling = (LinearLayout) findViewById(R.id.feelings);
        administration= (LinearLayout) findViewById(R.id.administrator);
        commerce= (LinearLayout) findViewById(R.id.commerce);
        marine = (LinearLayout) findViewById(R.id.marine);
        physics = (LinearLayout) findViewById(R.id.physics);
        chemistry = (LinearLayout) findViewById(R.id.chemistry);
        biology = (LinearLayout) findViewById(R.id.biology);
        astronomy = (LinearLayout) findViewById(R.id.astronomy);
        vitamins= (LinearLayout) findViewById(R.id.vitamins);


        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(educationenglish,educationbangla,"Education");
                viewAdd(addCount);
            }
        });

        corns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(Cornsenglish,Cornsbangla,"Corns");
                viewAdd(addCount);
            }
        });

        mathematics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(mathenglish,mathbangla,"Mathematics");
                viewAdd(addCount);
            }
        });

        shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(shapeenglish,shaprebangla,"Shape");
                viewAdd(addCount);
            }
        });

        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(fruitenglish,fruitbangla,"Fruit");
                viewAdd(addCount);

            }
        });

        spices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(Spicesenglish,Spicesenglish,"Spices");
                viewAdd(addCount);
            }
        });

        geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(geographyeglish,geographybangla,"Geography");
                viewAdd(addCount);

            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openListView(weatherenglish,weathebangla,"Weather");
                viewAdd(addCount);
            }
        });

        scienceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openListView(scienceenglish,sciencebangla,"Science");
                viewAdd(addCount);
            }
        });

        stateandgovt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openListView(stateAndGovEnglish,stateandGovtBangla,"State & Government");
                viewAdd(addCount);
            }
        });
        lawandcourt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        openListView(lawandcoartenglish,lowandcoartbangla,"Law & court");
                viewAdd(addCount);
            }
        });

        measurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openListView(measurmentenglish,measurmentbangla,"Measurement and Weight");
                viewAdd(addCount);
            }
        });

        postal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openListView(postalTermsEnglish,postalTermsBangla,"Postal Terms");
                viewAdd(addCount);
            }
        });
        tread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(tradeenglish,tradebangla,"Trade & Commerce");
                viewAdd(addCount);
            }
        });
        daymonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(dayMonthEnglish,dayMonthBangla,"Day,Month");
                viewAdd(addCount);
            }
        });

        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(medicineEnglish,medicineBangla,"Medicine");
                viewAdd(addCount);
            }
        });

        globalpolitics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(globalPoliticsEnglish,globalPoliticsBangla,"Global Politics");
                viewAdd(addCount);
            }
        });

        warandweapons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(warWeaponEnglish,warWeaponBangla,"War and Weapon");
                viewAdd(addCount);
            }
        });

        menandwomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(menAndWomenEnglish,menandWomanBangla,"Men and Women ");
                viewAdd(addCount);
            }
        });

        limbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(limbsMenEnglissh,limbsMenBangla,"Limbs of Man");
                viewAdd(addCount);
            }
        });

        nation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(nationEnglish,nationBangla,"Nation");
                viewAdd(addCount);
            }
        });

        stateofman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(stateofManEnglish,stateofManBangla,"State of Man");
                viewAdd(addCount);
            }
        });

        religion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(religionEnglish,religionBangla,"Religion");
                viewAdd(addCount);
            }
        });

        relatives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(relativesEnglish,relativsBangla,"Relatives");
                viewAdd(addCount);
            }
        });
        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(peopleEnglish,peopleBangla,"People");
                viewAdd(addCount);
            }
        });
        diseases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(dieasesEnglish,dieasesBangla,"Dieases");
                viewAdd(addCount);
            }
        });
        birds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(birdsEnglish,birdsBangla,"Birds");
                viewAdd(addCount);
            }
        });
        wormandinsect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(wormandInsectsEnglish,wormandInsectsBangla,"Worm and Insects");
                viewAdd(addCount);
            }
        });
        reptiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(reptilesEnglish,reptilesBangla,"Reptiles");
                viewAdd(addCount);
            }
        });
        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(animalEnglish,animalBangla,"Animal");
                viewAdd(addCount);
            }
        });
        limbsofanimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(limbsOfAnimalsEnglish,limbsOfAnimalsBangla,"Limbs of animals");
                viewAdd(addCount);
            }
        });
        criesofanimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(criesOfAnimalEnglish,criesOfAnimalsBangla,"Cries of animal");
                viewAdd(addCount);
            }
        });
        cultivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(cultionEnglish,cultivationBangla,"Cultivation");
                viewAdd(addCount);
            }
        });
        naturalobject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(naturalObjectEnglish,naturalObjectBangla,"Natural object");
                viewAdd(addCount);
            }
        });
        flower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(flowerEnglish,flowerBangla,"Flower");
                viewAdd(addCount);
            }
        });
        treeandplants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(treeAndPlantsEnglish,treeAndPlantsBangla,"Trees_and_Plants");
                viewAdd(addCount);
            }
        });
        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(clothAndGarmentsEnglish,clothAndGarmentsBangla,"Clothes_and_Garments");
                viewAdd(addCount);
            }
        });
        householdart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(householdEnglish,houseHoldBangla,"Household_Articles");
                viewAdd(addCount);

            }
        });
        dwellinghouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(dwellingHouseEnglish,dwellingsHouseBangla,"Dwellings_House");
                viewAdd(addCount);
            }
        });  game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openListView(gameAndSportsEnglish,gameAndSportsBangla,"Game_and_Sports");
                viewAdd(addCount);
            }
        });  metalsandminerals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openListView(metalsAndMineralsEnglish,metalsAndMineralsBangla,"Metals_and_Minerals ");
                viewAdd(addCount);
            }
        });
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(colorEnglish,colorBangla,"Metals_and_Minerals");
                viewAdd(addCount);
            }
        });
        ornaments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(ornamentsEnglish,ornamentsBAngla,"Colors");
                viewAdd(addCount);
            }
        });
        musical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(musicalInstrumentEnglish,musicalInstruMentBangla,"Ornaments");
                viewAdd(addCount);
            }
        });
        metalsandminerals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(metalsAndMineralsEnglish,metalsAndMineralsBangla,"Musical Intrument");
                viewAdd(addCount);
            }
        });
        vehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(vicalesEnglish,vicalesBangla,"Vehicle");
                viewAdd(addCount);
            }
        });
        branchesofedu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(branchOfEduEnglish,branchOfEducationBangla,"Branches of Education");
                viewAdd(addCount);
            }
        });
        direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(directonEnglish,directionBangla,"Direction");
                viewAdd(addCount);
            }
        });
        daymonthseason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListView(dayMonthSeasonEnglish,dayMonthSeasonBangla,"Day,Month and Season");
                viewAdd(addCount);
            }
        });
        feeling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openListView(feelingEnglish,feelingBangla,"Feelings and  Affection");
                viewAdd(addCount);
            }
        });
        administration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openListView(administratorEnglish,administratorBangla,"Administrator");
                viewAdd(addCount);
            }
        });
        commerce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openListView(commerceEnglish,commerceBangla,"Commerce");
                viewAdd(addCount);
            }
        });
        marine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openListView(marinEnglish,marinBangla,"Marine");
                viewAdd(addCount);
            }
        });
        physics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openListView(physicEnglish,physicBangla,"Physics");
                viewAdd(addCount);
            }
        });
        chemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openListView(cHEMISTRYEnglish,cHEMISTRYBangla,"CHEMISTRY");
                viewAdd(addCount);
            }
        });
        biology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openListView(biologyEnglish,biologyBangla,"Biology");
                viewAdd(addCount);
            }
        });
        astronomy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openListView(astronomyEnglish,astronomyBangla,"Astronomy ");
                viewAdd(addCount);
            }
        });
        vitamins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openListView(vitaminsEnglish,vitaminsBangla,"Vitamins" );
                viewAdd(addCount);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_fev) {
            Intent i = new Intent(MainActivity.this,Favorite.class);
            startActivity(i);
            return true;
        }
        else if (id == R.id.action_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is App link");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            return true;
        }
        else if (id == R.id.action_rate) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is App link");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            return true;
        }
        else if (id == R.id.action_feedbacks) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is App link");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            return true;
        }
        else if (id == R.id.action_more) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is App link");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_favorite) {
            Intent i = new Intent(MainActivity.this,Favorite.class);
            startActivity(i);
        } else if (id == R.id.nav_more) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is App link");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.nav_feedback) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is App link");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.nav_RateApp) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is App link");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.nav_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is App link");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.nav_send) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is App link");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openListView(String[] english, String[] bangla,String titel){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("english",english);
        intent.putExtra("bangla",bangla);
        intent.putExtra("titlebar",titel);
        startActivity(intent);
    }



    public void viewAdd(int addcount){
        interstitial.loadAd(adRequest);
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                if(addCount%3 == 0) {
                    displayInterstitial();
                }

            }
        });

        if (addcount%3 == 0) {
            displayInterstitial();
            addCount=0;
    }
    addCount++;
        Toast.makeText(MainActivity.this,addcount+"",Toast.LENGTH_LONG).show();
    }
    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}
