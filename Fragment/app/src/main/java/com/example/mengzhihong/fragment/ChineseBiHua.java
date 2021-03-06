package com.example.mengzhihong.fragment;

import android.util.Log;

/**
 * Created by mengzhihong on 2016/9/1.
 */
public class ChineseBiHua {

    public int getWordsBihua(String words){

        int count=0;

        for (int i=0;i<words.length();i++){
            String singleChinese=words.substring(i,i+1);

            int num=getChinese(singleChinese);

            if (num>0){
                count+=num;
            }

        }


        return count;
    }

    public int getContentCount(String content){

        int count=0;

        for (int i=0;i<content.length();i++) {
            String singleChinese = content.substring(i, i + 1);
            int num=  getChinese(singleChinese);

            Log.i("sb", String.valueOf(num));


            if (num>0){
                count+=num;
            }
        }



        return count;

    }


    private int getChinese(String chinese){

        int index=-1;
        String[] chineseArray={
                "丨亅乀乁丿一乙乛乚丶\uE818\n" ,
                "丩乃乂乄九了丁七丂丆丄丅乜丷八勹匕冫卜厂刀刁刂儿二匚阝几卩冂力冖凵人亻入十厶亠匸讠廴又巜\uE815\uE816\uE817\uE819\uE81C\uE81D\uE81E",
                "丬丫亇久么乇乊乆丸万三上下与丈丌乞习乡也之义勺刃刄兀亍亏于亐凡凣凢卫卪劜个亾亼亽亿兦千卄卂亡叉及艹屮彳巛川辶寸大夨飞干工弓廾广己已彐彑巾口马门宀女犭山彡尸饣士才扌氵纟巳土囗夕小忄幺弋尢夂夊孑孓子孒兀\uE822",//3
                "卝丰中丮丯乏乌丹予书无不丑丐丏专丒乤乥乢乣为公六兮勾勼勿匀勽匂勻匁卞厄历厅厃分切刅刈兂允元互井亓五云亖区匹邓队阞邒兯凤卬冈冇内冄罓冃円办劝冗冘凶仓从介今仑以仄仌仒仐化仇仃仅仂仆仁仍什仉仈仏內卅升卐午卍卆厷厸厹亢亣订讣讥计认反双友収艺屯辷夭夫夬太天巨引弔弖开廿币巿帀闩屲尺尹壬扎巴圡圠少尐忆禸幻弌尤夃孔贝比灬长车歹斗方风父戈户戶戸火旡见斤耂毛木朩肀牛牜爿片攵攴气欠犬日氏礻手殳水瓦尣王韦文毌毋心牙爻曰月爫支止爪\uE823\uE826\uE82B\uE82C\uE838\n" ,//4
                "丱卡册玍乎乐乍丘业丙东且丕世丗丛丝乧乬主丼包匆匃匄匇北冯冮冭卟卢占厉厈厇刍刌刊刉刋兄亗匜匝匞匛邗邝邙阡邛阢邘邚阣邔邖阤邜阠兰処凥凧卯印卭冉冊冎冋功加劢务写冚凹出击凷凸令仝仺仧仚代付仡伋们仫仟仞仨仕他仙仪仔仗仢仛仦仠仜仭仩半卉卌去厼厺讧记讦讫让讱讪讨讯训议讬廵发叐叏艾艽节艻艿艼芁芀边辽辺辸込辻对夯失头央夲夰夳平巧左巪弗弘弁庀広庁庂归布市帅帄叭叱叨叼叮句古号叽叫可叩叻另叵叶史司台叹右召只叺叾叧叴驭闪宄宁它宂奶奴奵犯犰屶屵屷屴屳尻尼饤饥壭扒打扑扔扐払扏扖汈氾氿汉汇汃汀汁氻汅汄纠圣圧圦圥圤圢囚四囙囘囜外夘夗尔尕尒尓忉忊忇幼弍冬处孕轧卮戋戊戉戹灭斥本末术未札朮朰氕犮旦旧氐民礼氹永氷氶氺玌必曱肊正白癶歺甘瓜禾钅立龙矛皿母目疒鸟皮生石矢示罒电甲申田由甴玄穴疋衤甩用玉玊",//5
                "乓乒乔乑丢襾丟両丠丞乩买乫乪乮乯乭乨屰共兴兲匈冰冲冱决冴厍压厌厊刕争创刚划列刘刓刎刑刖则刐刏刔光先兊兇兆亘亚亙匠匡匟匢阨阪邦邠邡防阶阱阬那阮邬邪邢阳阴阵阧邨邞邟邩阫阰邥阩邷邤阭阦阥邧阯关凫凨凩凪再网动劣劤劥劦劧军农凼会企伞众仰伧伥伡传伐仿份伕伏伙伎价件伉伦仳佢任伤似佤伟伪伍仵伈休伢伊优伃伛仲伫伌仯伜伔仾伄伅仮仹仸伒仱伖伂伓伣仼仴伆伩伨伇伝伬伀全华协卋厾厽充产亥交亦讹访讽讳讲讵诀论讷讴设讼讻许讶廷延叒芏芨芒芃芑芊芍芄芗芎芋芝芆芉芐芇芕芌芅芖芓彴彶彵巡州巟达过迈迄迁迅迆迂辿迀迉迃导寺寻夺夹夸夼夷夶夻夵并年幵巩弛弚弜弙异庆庄庅当帆师帇吖吃吊合各吓后吉吏吕吗名同吐吸向吁吆吒吋叿吇吂吀吅吔驰驮驯闭闯闬问闫安守宇宅宆妃妇奸好妈如妁她妄妆奼奿妅妀奺奻奷奾犴犷犸犲犵犱犳岌岂屺岁屼屹屿屽岀岋屸屻屾岃尽饦饧壮扱扛扢扞扣扩扪扦扫托扤扬执扠扡扥扚扝扨扟扜扗扙汊池汏汗汲江汔汝汕汤汜汍污汐汛汙汚汎汓汌汣汒汘汋汢汑汷纥红级纪纩纤纫纨约纡纣场地圪圭圾圹圮圩圬圯在圳圵圶圱圲圸圷圫圴赱回囝囡团囟因団尧舛多夙夛尘尖尗忏忖忓忣忙忛忋忚忔忕弎式弐尥夅存孖孙字负贞贠毕轨死危爷成戏戌戎戍灯灰灮灳灱灲观考老朳朵机朴权杀朽杂朱朶朼朾朿朷朹朻朸朲杁牟牝牞收攷氘氖気次欢旮旯旭旬早旨旫旪氒祁礽汆氽氼瓧玎玑玐玏毎忈曲曳肌肋有肎肍攰此百癿钆钇甶穵甪艸臣虫而耳缶艮虍臼耒米糸齐肉色舌糹西覀行羽聿至舟竹自页衣血羊\uE844礼",//6
                "串亊乕两严丣丽乱乲兵羌兌匉冻况冷冶冺冹冸卤卣厑厐厎厏兏初刧免龟刨别刬刜刭利判删刦刪別刟刢刡刞刣兕兎児亜匣医匥匤阿陂邶邲邴陈邸阽阸附邯际邻陆陇邳邱邵邰陁陀陉邺邮邹阻阼陃阷阺邭阾阹兑凬即卵却卲冏助劫劲劳励努劬劭労劰劮劯罕冝佥佘余佁伯伴伻佊伺但低佃佛伽佝估何佧伶你伲佞伾佉伸体佟佗位佚佣佑住作佐佈佔佀佨佖佄佅伱伮伹佋佦伭佡伳伵佒伿佂伷佇克县亨亩亪诐词诋诂评诎识诉诇译诈诏诊证诌诅诃诒廸廹叓芺芭芘苄苍苌苁苊芳芾芬芙芣芥芴花芰苣芤苈芦芼苉芪芡芹芩芮芟苏苇芜苋芯芧芽芫苡芸芷苎芿芚芲苅苀芶芵芞苂茾苆芢芛芠苃彻彷役彺彸巠迟返还迒进近连违迕迓迎远运这迍迏迖迗迋迌迊迚寿対寽夿奀奂奁夾奆夽巫弝弟张弡弞弄弃弅庇床庋库庐庑序应庎庒庍庉庈庌帊帏希帐帋帎帉帍吧呗吡吥吵呈吹呆呔吨吪呃吠吩否呋告呙含吭吽吰吼君呖吝呒呐呕启呛吣吮听吞吻呜吾吴吷呀呓吟吲员吱呌吢吚吳呎吜吺吿吤呄吙呁呂呅吶吘呇呏呑咓呚呉咞呍驳驴驱驲闳间闶闷闵闰闱闲宏宋完宊宑宍宎宐宒妣妒妨妋妫妓妗妙妠妞妊姒妥妩妍妖妤妪妘姊姉妝妛妉姂妢妦妚妎妔妌姖妜妑妧妏妡妟妐妕狈狄犼狂狃犹狁犻犿犺狅狇犽犾狆岙岜岑岔岛岗岚岐岍岖岘岈岅岠岇岎岊岕岓岒岏岉岆岄彤形彣层局尿屁尾屃饬饭饪饨饩饮饫壳声壯売壱把扳扮报抃抄扯扽抖扼扶抚护技拒抉抗抠抡拟扭抛批抔抢扰折抒投抟抏抆抑抈找扺抓抝扷抜抌抙抅抇扴抸扻抂抐扲抋扸抁扵抎抣択抍汳汴沧沉沌泛汾沣沨沟汩沆沪汫泐沥沦没汶汨沔沐沤沛沏汽汧沁汭沙沈汰汪沩沃汹沂沅沄汦沚沍沘沖決汵汸汱沕汯汻沎汥泲洰汮沠沒汼沑沜泤沇汿沋沞沢纯纺纷纲纶纮纳纽纰纴纱纾纬纹纭纼纸纻纵巵坝坂坌坊坟坋坏坚均坎坑块坜圻坍坛坞址坠坐坒坘坔坆坖圿坓坕坙坈圽圼坅坉坃坄坁囱囤囮囫囥困囵围园囯囬囪囧囨囲図囦囩尫忭怅忱忡怆怀忾快忸怄忪忨怃忤忺忻忧忮忼忰忳忶忦怇忹忯忴忬忲忟忷尬尨尪夆夋孛孚孝孜孞财贡轪轫轩歼斘飏戒我戓芈戺戻灿灸灵灺炀灾灶灼災灻灴灹灷觃毜毝杓材杈村杕杜杆杠极来李杩杧杞杉束条杌杏杨杝杙杖杇杘杒杋杚杛杢杦杗杄杣杔杤杅杊杍牢牤牡牣牠改攻攸攼攺氚氙欤状旰旱旷时旸旵旳昅旲旴祃社祀祂礿汞求汖瓩瓨尦玚玓玕玖玛玘玙玔玒玗韧斈毐忌忍忐忑忒忘志忎応更曵肠肚肝肛肓肜肟肖肘肐肑肞肔肒肕肗肙步皀皂皁皃私秃秀秂禿钉钌钋钊针竌竍盀盁每盯疔疖疗疕疓鸡鸠矶矴矵矣甸町男甼甹究穷补甫甬虬耴良系糺臫貝釆镸車辰赤辵豆谷見角里麦身豕辛言訁邑酉豸走足\uE81B\uE827\uE82A",//7
                "羋丳卥事乖丧兩並乸乶乷乴乵乳鼡典其具匋匌匊净冽冼冿冾卦卧厕厔厓厒券刱刼兔刹刺到剁刮刿刽剂剀刻刳刲刷制刵刴刾刯剆兓兒亟些亞匦匼陌陔邽郃郈郇郏降郊郐郎陋陕郋郄限郁郓郑郅邾陒郕陊陏陑郍郂郉郆郀邼郘郱邿陎郔陓凯凭凮卹卶冐罔劾劼劻势効劷劵劶勆劽劺劸冞罙函侖侌佰侧侘侪侈佌佽侗佴供佹佫佷佪佶佳侥佼侃侉侩佬例侣侔侬佩侨佺侁使侍佻侹侂侠佯依佾侑侦侄侜侏來侚併侒侙侟侢佮侕佱侅侊佸侭侓侎佲侫侞価侤佭侀俢侐侇卑单卒卖卓協亝参叁叀京享兖诧诚诞该诟诖诡话诙诨诘诓诔诠诜诗试详诩询诣诤诛建廼廻变取受叔叕茇苞苯苾范苻茀苷苟苦茄茎苴苛苓茏茆茅茂苗苠茉苜茑苶苧苤苹苘茕苒若苫苕苔茓苢茚英茔苑苲茁茌苽苝苪苩茐苐苖苵苳苰苸苙苺苨苼茒苿苮苬苭苚茋茊彼徂径往征徃彿彽彾迨迪迭迩迦迥迫述迢迤迮迯迠迧迡迣迳迲迱迬尀奔奋奉奇奈奅奄奃奌奍幸幷弨弧弪弥弩弢弦弤弣弆底店废府庚庙庞庖庝庘录彔帛帘帕帔帑帖帜帙帚帗帒帓呵哎咑咚咄咈咐呷咖咕呱咍和呼咎咀咔呤咙呣命呶呢咛咆呸呿呥呻咝呫味呦咂咋周咒咼呪咊呝咏咇咘呬呮呹呾呧咁呴呺呟呡呠呯咅呞呩咜咃咉呭咗黾骀驸驾驹驽驶驷驼驿驵驻驺闹闸宝宠宕定官宓审实宛宜宙宗宖実宔姅妲姑姐姆妹妺妮妻妾姌姗始委姓姁妯妬妷姍妭妼妸妿姇姀姈姏姄妳妽妵妶姎妴妱姃妰狒狗狐狙狞狍狉狌狎狝狖狓狛狋狚狜狑狔狏狘狕岸岱岽岣岵岬岢岿岭峁岷岧峂岫峃岩峄岳岡岞岰峀峅岾岻岪岨岲岦岺岯岼岥岶岴岹岮岤岟岝屄届居屈屉屆屇饱饳饯饰饲饴拗拔拌抱拨拆抻抶抽担抵拂拊拐拣拘拉拦拎拢抹抿拇拈拧拍拚抨披抪拤拑拓抬拖押拥择拃招拄拙抴拋拕拝抦拀拞抲拁拠拡抺抩抳抷抾抭抰抯抧抮泌波泊沲法沸泭泔沽河泓浅泾泂泃沮泪沴泠泷泸泺泖沬沵泯沫泥泞泮泡泙泼泣泅沭泗沱泄泻泫沿泱泆泳油泽沾沼治注況泜泝泑泍泟沶泹沰沷泒泘泋泇泦泬泏泧泩泀沺泈泎绊绌绐绂绋绀经练绍绅细线绁绎织终绉组巶垇坳坢坼坻垂坫坩坷坤垃垄垆坭坯坪坡坦坨坿坵坺垈坲坸坬垀坥坽垅坴坶垊垉坮坣坹坱坧垁坾固国囹囷图囶囻囸囼尭夜夝尚忝尙怖怊怵怛怫怪怙怜怩怕怦怯怗性怏怡怿怔怳怍怑怉怭怶怲怞怚怟怢怐怾怋怽怓怌怬怴怰怮怈备夌孢孤季孟孥学孠孡孧败贬贩贯货贫贪贤责账质贮购炁轭轰轮软转殁殀歾歿歽卺卷於斻斺爸或戗戕戔房戽戾所戼炒炊炖炅炔炕炜炬炉炝炆炘炎炙炃炞炐炗炚炛炌炏炓炑炄炍炋炇炈烎炂规觅视现斧斩斨斦者毟毞枊杷板杯枨杻杵枞枓枋枌枫杲构柜果杭枑枧杰枥林枚杪枇枪枘枢杸松枉析枭杳枣枕枝杼東枏柹杴杮枈杽杶枤枙柉枎杹枅枃枦枆枬枡杫枀枩枂杺枔枒枖枍杬枟枛枠牥牦牧物牬牨牫牪牀版攽放玫氛氜氝欧欣欦欥狀昂昌昉昐昊昒昏昆旻明昙旺昔昕易昀昃昇昄昁旾昘昋昈昛旼昑旹旽旿昍昖昗氓祊祈祇祆祎祉祅祌祋祍祄承殴沓沊汬沀沝瓯瓮瓪瓭瓬瓰瓱瓫瓲尩玢玞环玠玦玭玱玩玮玡玥玨玤珁玬玜玪玟玣玧玝斉忿忽念怂态忠忩忞忢忥怺曶肮肪肥肺肤服肱股肩肼肯肭朋肷朊肾肽肸肹胁肴育胀肢肿肫肧肬肶朌肦胏肨肣肻肵肰肳爭歧武歨歩歫爬的癷甙瓝秉秆秄秊秈秇钗钏钓钒钔钕钎钐钍钖钑竎竏盂毑盲盱直盰盳盵疙疚疠疟疝疡疘疜疞疛鸣鸤鸢皯砀矾矸矼矻矿码矽矺砐矹矷知矤罗罖畀畅画甿甾畁畂畄甽畃空穹穸穻疌衩衬衫衦衱衪衧臥臤虮虱虲虯虰虭耵耶缷艰虎虏臾臽耓籴籵籶肏舍舏舎糾糼糿糽肃舠竻竺采軋豖長齿非阜金釒隶門靣靑青飠鱼雨隹顶顷表\uE828\uE82D秊\uE837" ,//8
                "临乗鳬乽乼乻乺乹举美羑羗兺匍凂凁凃厚厘厛厙厖厗剏剉剐剑剋剌前剃削剄則剎剅剈兘匽匨匩匧陛除陡郛郜郝郡郦陧郚郗郤险郢院郧陨陟陣陝陘陞郟郣陠陙陦郖郙郠郥陖郞陗陜陥兹养卸卻卽冒冑勃勉勋勇勅勁勂勀勊勄勈冠冟凾俞俎侴保便俦促俤俄俘俛侯俒俭侷俊俫俚俪俐俩俍俜俟俏侵俅俗侻侮信修俨俑俣俥俠俓係侼侲侱侸俌俇侰俈侶侽俖俔俕侺俆俬俀俉俙侾俋俁俧侳兪南単亮亲亭亱亰亯兗诶诰诲诫诳诮说诵诬误诱语诪廽叛叟叙叚叝叜荜草茬茶茺荈茈茨荙荅荡茯荄茖茛荭荁荒茴荟荤荠荚茧荐茳茭荩荆莒荖荔荦荬茫茗荨茜荞荍荃荛荏茸荣茹荪荑莛茼荥荇荀药茵荫荧荮茱茘茲荘荌茷荝茞荿荎茦茤荋荂茩茪茥茠茍茮荕荊茢荓茙荗茟莚茰荢茽茿茡待很徊律徇徉後徍徆徔迸逅迹迷迺逆逄适送逃退选逊迻追逈迵逇迴迼迾迿迶封将専奖奎契奕奓奏奐奒奊飛差巬巭弭弮弯弫弇弈度庭庠庥庡庰庛庣庢庤巹巻彖帮带帝帣帤帧帥帡帞帢帟帠哀哔咤呲哒咥哆哚咡咯哏咣咶哈咳哄哗咴哕咭哜哙哐咧咪咩哞哪哝哌品哂咷哇咸响哓咲咻哑咽咬咿咦哟哉咱咫咮咨呰咵哅咹唌哋咢咟咾哖哛咠咰哃哘咺哊骉骇骅骄骆骂骈骁骃阀阁闺阂闿闾闽闼闻宬宫宦客室宪宣宥宩宨姹姤姽姮姞姜娇姣姱姥娄娈娜姘娆姝娀娃威娅姚姨姻姿姪姙姦娍姕姛姶姟姯娂姡姼姧婙姢姰姴姳姩姵姾姺娰娗姭姠姲姸娫姷姫独狠狟狡狯狨狮狩狲狭狱狰狥狫狢狤狦狧狪狿狣峒峧峤峦峙峡峋峣峥峕峝峖峇峸峌峉峎峏峊峐峠峆峘峜峛峢峍峈峚峔峑峗峞峫峓峟彦彥屏屌屎屋屍饼饵饹饸饺饶饻饷壴壵按持挡挏挌拱挂挥挤挢拮拷挎括挠挪拼拾拭拴挞挑挺挖挝挦挟挜拽拶挓挣拯指挀挷拺拸拵挃挕挅挆挄拫拻挍挗挒挘挔捛拰挊拪挻拹捓挧挋测浐泚洞洏洱洑洸浔洪浒洹洄浍浑活济洎浃浇洁津浕洭洌浏洛洣洺浓派洴洽洳洒浉洮洟洼洈洧洿洗涎洨洫洵洋洇浈洲洙浊洩洶洝洆洊洉洃洚浄洘洡洠洀浌洦洓浀洤洂洬涏洐洢浂泿洕洅洔洷绑绖给绗绘绛绞结绝绔络绕绒统绚巷巼巺垵垞城垯垱垫垤垌垛垩垡垓垢垝垕垍坰垲垦垮垒垴垧型垭埏垟垚垠垣垜垹垪埩垑垐埅垖垘垙垳垎垬垰垏垨垥垔垗囿圀尝尜尛恻恫恨恒恍恢恛恺恪恇恼恲恰恃恬恌恸恟恤恂恹禺禹恽恉恓恠恆恡恜恎恑恗恔恅恾恈恘恮恦恀恄恊恞恱幽尮尯复変夈孩孪孨贲贷贰费贵贺贱贶贸贳贴贻毖毗毘点為炰轱轷轲轹轳轻轺轶轸轵轴残殂殆殇殄殃殅卼施斿旀斾飑飒飐战扁扃扂炮炳炽炟烀炯烂炼炻烁炱炭烃炫炸炷炧炤炦炪炥炾炣炩炶炲炵炠炨炴炡炿炢既觇觉览斫斪耇耉毡毠柏柈枹柲标柄查柽柢栋柮柂柎柑枸枷架柬柩柯枯栏栎柃柳栊栌某柰柅柠枰柒染柔栅柿树柁柝柙枵枻柚柞栈柘栀枳栉柣柊柱枲柟柺柵栁栆柪柭柸柀柨査枱柌柋柦柫柧枴柇柾柆栃桞栂枺枿桏栄栍桒柖柛枾柕柶柗枮柍柼枼栐柤柷牮牵牯牳牲牴牰牱牭牁牉牊敁故政敂敃敄敀氡氟氢氞氠欩欪欨狊昪昶春昳昽昴昧昵昰是显星昫昡映昱昝昭昼昨昞昺昬昹昻昸昲昦昿昤昩昷昢昚昜昣昮祠祓祔祜祢祛神祏祐祗祝祖祚祕祙祒祑拜拏段殶泵泉泶泴沗沯瓴瓳瓵珌玻玳玷珐珈珏珂玲珑珉珀珊珅珍珎玵玸玽玾珇珋玶珃玿珄珆玹玴韨怠怼急怒思怹怨怎总怱怤怘怷怸怣爼曷胈胞背胆胨朏胍胡胛胫胩胧胪脉胖胚胠朐胂胜胎胃胥胤胗胝胄胙胇胉胣胊胅胐胕胢朎胟胒胓胑胋朑胘胦爰爯攱歪爮皈皇皆皅皍癸癹発甚秕种秬科秒秋秭秗秔秖秌秅秎秏秐秓钯钣钡钚钞钭钝钫钙钢钩钬钜钧钪钠钮钤钦钛钨钘钥钟竖竐竕竓竗竔矜盆盈盅盇盃盄毒眈盹盾看眍眊眉眄眇盼省盻相眨眆盽眃盷盿眀眅眂県盺盶疤疢疮疯疥疬疧疫疣疭疪疺疩疦疨鸨鸧鸥鸦鸩甠砭砗砘砜砆砉砄砍砒砌砂砑研砚砖砏砃砈砎砛砊砅砇砕砙砓砋矩矧矦矨罚罘畈界畎畋畑畏畇畐畊畉畍畆畒畓玅窆穿窃突窀穽窂穼穾袄衭袆衿袂衲衽衴衯衸袀衹衻袇衵衼衳衶甭甮芔虿虼虾虹虺蚂虻蚀虽蚃蚁蚤虸虵虶虷虳虴耑耏耐耎耍耷缸虐臿舁耔类籹籼籽籸籿籺籾粁粂粀籷紃紆紅紂紇紈約級紀紉紁要衎衍羿羾舡舢舣舤笃竿笈竽竾笁笀竼笂貞負貟軍軌覌觔觓兙重訇訄計訂訃訆訅酊酋赴赳赵赲趴釔釓閂閁食風革骨鬼韭面首韋香頁音项顸须\uE863顺袅羏郎\uE82F衂" ,//9
                "羐乘羞匎凋凉凌凄凇准凍凈凎凅凊卨厝原厞厜剙剓剥剒剟剕剞剧剖剡剔剜剚剗剛剮剠剝剢剤剣剘剦党匪匿匫部郴陲郸都郭陵陪郫陴郪郯陶陷陬陸陳陰郰郵郳郩陼陮陫陚陱郲陯郬鄀陹険郷陭郮兼卿冓冔勐勍勑勌務勏勎冥冤冢冣冦冧冡倉倝俺倍倴俾俵倡倘俶倅倒俸俯倌候健倢借倞俱倨倦倔倥倮倷倪俳倩倾偌倏倜倭倖倻倚债值倬倳倀倆倈個俽倫倸俻俲倣們倂偖俿倕倓倲俷倱俰俴倹倃倶倰倗倛倿倽倐倯倠倎倇倵俹倄偀俼倁値倊倧亳谄调读诽课谅诺请谁谂谉谇诿谊谀诸谆诼诹谈叞荸茝莼莝荻莪莩莞荷获莙莰莱莨莉莅莲莽莓莫莆莎莘莳荼荽莴莶莺莹莜莸莠華莕莢莖莧莂荹莗莀莐莡荳荰莑荴莄莟莋莭荲莔莬莈莯莮莻莥菦莍菃荵莦莤荾莏莵莌莣荱茣莁莃荶荺莇莊徕徒徐徑徎従徏逋逞递逗逢逛逦逑逡逝速逖通透途逍造逐連逕這逓逧逥逎逘逤逜逌射尅尃套奚奘奙弱弳弰弲弬弉庯座庩庫庪庬庨庮帱帩帨席師帬帯帰帪啊唉哱哺唓哧唇唗哦哥哿哽唝唅哼唤唧哭唠哩哢唛唦哨唆唢唐唔唏哯哮唁唣哳哲哶唘唡員唄唑唕唚哵哣唙唖哹唂唃哻哠哬唊唟哴唥哰唎哷哤唜唴唒哾哸唞唋唍唈唀唨哫骋骏骊骎骍验阄阃阆阅宾宸家害宽宭容宵宴宧宰宲宮宺宼宻宷宯宱娭娖娣娿婀娥姬娟娌娩娘娉娠娑娲娓娴娱娝娕娊娐娢婲娔娳娏娒娚娞娦娋娧娪娨娎娙娮娛娯娡娤狴狷狼狸猁狻猃狺狳狾狹狽猂狶狵猐猀峬峨峰峻崁崃崀崂峱峭峪峽峴峩島峯峼峺崋峲崅峮峵峷峹峿崄峾峳彧彨屙屐屑展屘屔屗屖屓屒饽饾饿馂馁馀壶挨捌捕挫捣捍换捡捄挶捐捃捆捞捋捏挼捎损捅捝挽捂挹振捉捘挵挾挱挮捠挬捗挿捈挰捇捀捊挭揤挸捁捔挳挴捒挩捜捖捤捙捑捚浜浡涔涌涤涐浮涡海浬浛浩涣浣涧浸涓浚涞浪涝涖涟流浼涊涅浦润涩涉涘涑涛涕涂涠浯浠消浥浴涢涨浙浞浹涇浧浾浺浱浟浢涜淓浲浭浫涆涥浤涀浻涃浨浶涙浰浖涁浝浽浿涄浗涗涚洍浵涋涒浘洖涍浳淽绠继绢绥绦绨绤绡绣巸埃埔埕埂埚垾埌埒埋埆埘垿埙垽垸垻埄埗堲埊垺埖埉埐埛埍埈埓埁垷垶垼埇埑埀圂圃圄圆圅圁夞恭悖悍悎悔悁悝悃离悢悯悂悭悄悛悚悌悟悮悒悦悕悑悜悙悈悧悋悗悩悓悏悇悞悀悅夎夏孬孫孭赅贾贿赆赁赂赃贼贽赀资毙羔烈热烝烏烋轿较辂辁轼载轾辀珲殊殉殈料斚旁旅旄旆旂旃旊爹戙扇扅扆扄烦烘烩烬烤烙烧烫烜烟烊烨烛烉烖烔烠烢烥烡烆烣烄烗烮焒烞烇烻烒烶烪烓烚烍烌烅烕烑烐烵觊笕耄耆耊笔毪毨毦毩毣毧毢毤毥桉案梆栟柴档栭栿格根栱栝桄桂桧桁核桦桓桨校桔桀桕桊栲框栳栗栾栖桤桥桡桑栓桃梃桐桅栩栒桠样栘栽桢桎株桩桌條栔栢栧栰栞栤梴棦栦桘栜栨桗栮栫桝桍栛栵梠桙梛栠栣桇栻桋桛栙桖桪枽栺栶桜柡栯桚栴桟栕栚栥栬牶牷特牺牸牂敊敆敖敌敉效敇敋氨氦氩氧氤氥氣欱欬欮欯欴欫欰欭晁晃晖晋晒晌晟晓晅晏晔晕時晉晐晎晄晈晇晆晠晀晍晑晊祧祫祥祯祮祪祣祤祬祩挛拿挈拳挚挐拲挙殷殺浆洯泰洜瓷瓶瓸班琤玼珰珥珙珩珞珽珣珧珠珪琊珮珤珹珫珖珔珓珒珢珯珕珡珟珨珗珦珛珝珬珚珜珱珘斋斊恶恩恚恝恳恐恋恁恧恕息恙恣恥恴恏恵恖恷書曺曻胺胵脆胴胹胳胱胲胻脊胶胯脍朗脒脑能脓朒胼脐脎朔朓脡胸脩胭胰脏朕脂脇脈脃胷脋脠脀胿脄脌胮脁脅爱歭歬皋皊皌瓞瓟秘称秤积秣秦秫秧秩租秚秡秮秙秝秢秜秥秛秠秞秪秨铋钵钹铂钸钿铎钴钾钶铃铆钼铌铍钷铅钱钳铈铄铊钽铁铉铀钰钺钲钻铇竑竞站竚竝竘竛竜竒矝盎盍盉监盐益盏盌盋眧眩眬眛眠眜眚眙眢真眎眡眑眪眣眔眓眗眖眫眿眤眒眘眏眕眞眐眝病疸疳疾痂痉疽疴痆疱疲痁疼痃痈痄疹症疻疰疿痀疶疷鸱鸫鸪鸰鸬鸲鸶鸵鸮鸴鸭鸯鸳皱皰甡砹砵础砥砝砩砢硁砬砺砾砻砮砰砯破砷砼砣砸砟砧砫砤砲砨砠砿砳砱砞砪砶砽砡祟祘罢罡罛罟罝罞罠罜畚畜畟留畔畠畖畛畢畝畗畕畞畘玆窎窍窊窅窈窄窇窉窋疍丵被袯袢袜袍袪袒袖袗袟袊袐袚袩袛袝袧袔袓袦袮袙袡袑袉袘袥袨袕袎袣袏玺芻蚌蚕蚩蚪蚨蚣蚝蚧蚍蚋蚊蚬蚜蚓蚛蚄蚠蚈蚦蚟蚉蚏蚡蚑蚘蚆蚇蚅蚥蚢蚷蚗蚐蚞蚔蚚蚙蚒蚖蚎耻耽耿聂耸耼耾耹聁耺聀缻缺缹缼虑虔虒虓舀耙耖耕耗耘耟粑粉粔粃粇粄粊粆粋粐粎粈粏粅粌粍紧素索紊紥艳舐紞紟紕紜純紘納紗紛紝紙紋紡紐紖紦紣紑紒紤紌紓紏紎覂衏衐翅翀翃翁翄翆翂肂肁致般舨舭舱舫航舰舯舩舧舮舥舦笆笓笏笄笅笋笑笊笫笒笐笉笍笇笌笖笎臭臬貤貢財貣镹軏軒軑軔軓軕軎軐辱豇豈谸覍覎觙兛躬豗訏訑訚訐訌討訊訕訖託訓記訒訍訋訉訯訙訔邕酐酒配酏酎酌酑豹豺豻赶起赸趵趸趿趷趶龀釜釗針釘釙釕釛釟釖釡釠釢釚釞閃閄閅飣飤飢鱽隽难隼隻隺髟鬯鬥高鬲馬衾颀顾顽颁顿颃预顼衰袁衮衄衷羖\uE81F凉衃羓羙衺",//10
                "乾乿匐匏匒匓匙匘凑减凐厩厢厣厡厠剪剱亀副剳剶剫剬剨剰剭兜匾匮匭區匬鄂隍鄄隗隆郿鄃鄋隋随隈郾隐隅鄅隂陿陻隄陽隊階鄆鄉隌鄁隀陾鄇郹鄈隉郻隃隇鄊隁郼兽凰卾冕勘勒勔勖勚勗動勓冨偝偲偿偁偢偾偟偈假傀偻偭偶偏停偷偎偓偕偃偊偫偬偰偹做偪偵偘側偺偽偉偋偛偅偆偒偙偳偔偑偩傦偮偂偼傇偄偗傁傞偍偸偞偦偱偐偣偠偯偤偧偡卙參叄谙谗谌谛谍谔谎谏谜谋谝谓谐谞谖谑谚谒谕谘菝菢菶萆菠菜菖菙菆萃萏菪菂菲菔菰菇菓菡菏萑菅菨菁菊菌菻菱菉萝萌萘萍菩萋萁萨萐菽菘菼萄菾萜菟萚菀菵萎菋菥萧萤营萦菸萸著菑菹菴萇萅萊萡萞萗菭菗莿萕菿菧萣菄萉菒菮萖萂萀萈菺菫菳萛菤萒菎菈蓈菞菕莾菛萠菍萢菬菣萔蒁萵萓萟菚萙菷徜得徛徘徙徠從徖徤徣徢徝徟巢巣逴逮逭逵逯逻逶逸逩逷過進週逹逺逬逪逫逨逽逰逳尉將專奢奟奝奜奛奞弹弶弸張弴強庵庳康廊庼庶庹庸庾庻庿庺庱庴庲彗常帼帲帷帻帶帳帵帾帺帴帹唵啵唱啜啐啖啶啡唪啯啝啈唿唬唶唫啃啦唻啷唳啉啰喵啮喏啪啤啬啥啑唼商售唰啴啕唾啘喎唯啸唷啧啁啭啄啞啢唸啗啓啟問啀喯啚啋啛啇啲唲啹啒啩啳啱啂唭啔啌啨唺啍唩啎唽営唹喐啫啅啠骖骒骐骑骕骓骔阐阊阇阏阍阌阋阉阎阈寄寂寇密宿寅寀寃寉寈寁婢婊婵娼婼婳婚婕婧娵婪嫏婗婆娶婶婠婉婋婞婬婴媖娬婥媧婁婦娾婩婄婇婤婃婝婰娻婏婓婔婟婎婫媎婜婛婅婮婡婯婈娽婨婂媌婑娸婍婘婌娷婒婖婐娹婱婭娺猜猖猝猄猎猡猫猛猕猊猅猞猇猗猘猪猈猠猓猏猑猍猟猉猚猧猙猔崩崇崔崮崞崌崛崆崚崎崤崖崦崟崭崒崧崬崕崍崗崑崐崯崘崙崪崥崈崠崜崓崡崨崫崊崏崉崣崝崢崰彪彬彩彫屠屜屝屚屛馆馃馄馅壸壷捭掺捶措掸捯掂掉掇掆掼掴掎接捷掬据掘掯控捩掳掠描捺捻掿排捧掊掐掮掞授探掏掭推掀掩掖揶掷捴捽掛掗捱捵採捨掄捲掽捫掃捹掤捬掁掫掋掟掶掍掝揵掲掚掕捰掹捪掵掜捿掑捦掅捼掻掓掦捸捥捾捳掙湴淳淙淬淡淀渎淝涪淦涫涵淏涸淴淮混渐淋淩渌渑淖淠淇清渠深渗淑涮淞淌淘添淟涴淅淆涯淹液淫淤渔淯渊渚涿淄渍淚淶淒淺渦淪淛淊涼済渀淲淿淐淨淔涰淂淍渉涷渄淈淉渇渮涽淁湕涺淗淃涳淕淥渵淧渂淰淣淎淜渒渏淸淭渃渋涻渖涭涾涶涹渓涬淢渶渁渆渕涱绷绰绸绯绲绩绫绺绿绵绮绻绱绳绶绾维绪续综绽缀缁绹缍绬埯埠埭堵堆埵堕堌基堇堀堎埨堄埝培堋埤堑埽堂堍埸域堉埴埻埜埡堊堅埼堝埰埳堃執堓埿埲埫埱埞埬堏堈埧埾埢堁埪堒埥堔埶埣埮埦堐圈圊圉國圇够夠惭惨惝惆惙悰悴惮悼惦惇悱惯惚惛悸惊惧悾悽惬情惓惕惋惘惟惜悻禼悵惏惔悺惃惈惤惍惂悷惀惗惸悿惞惐愥孰孮孯孲赉赇赊赈焘烹焉焎焄焏辅辆辄殓殍殑殒殌殎殏殐斛斜旌旎旋族旇旉旍旈戛戚戝戜扈烽焓焊焕焗焌烺焖烷焐烯烴烱焅烲烾焍烰烸焃焀焆烳烿焫焂焑焁焈焇烼焔焋旣觋現断斬耈毫毬毭毮桮梐梣梵棻桴梗梏检梮桷梱梾桹梨梿梁棂梅梦桲桼梫桵梢梳桫梭梼梯桯桶梧械梽棁梓桺梘梩桿梟梔梎梖桳梹梌桭椘梊梑梪梤桻梻梒椛梙梡梞楖梜桱梷梋桾桰梸梇梈梂梕桬梥梀梚梶桽桸梺梬梄梍梉梲犁牽牿牼牻牾敍敝敕敚敢教救敛敏敔敗敐敓敎敘敒氪氫欸欷欲欵欳欶晡晨晗晧晦晚晤晞晛晢晣晝晘晥晙晜祷祸祲祶祴祰祵祱祳祦挲殻殸殹瓻瓺瓹瓼琀琎珺琅理琏琉球琐琇琍珼珵珿珶珴琒琈琌珻琷琁琑琓珳珸琋琄琂斍斏斎患您悫悉悬恿悠悤悪悡悆悐悘悥悊爽曹曼曽脖脭脞脰脯脝脚朘脸脟脶脢脲脬脤脦脱脘望脧脣脛脗朙脪脨脵朚脥朖脷脳脮脴脫脕脙脜皑皎皐皉皏甜甛瓠秽秸稆秾移秺秴秳秹秲秱秵秷秼秶铵铲铛铖铳铞铫铤铥铒铬铪铧铗铰铠铐铑铝铓铭铙铨铷铯铩铴铜铣铦铏铘铱铟银铕铡铮铚铢铔竟章竡竫龚龛笼盛盗盖盒盔盘盕盓眵眷眶眯眽眸眭眺眼着睁眦眥眾眱眰眳眲眴眮眻眹疵痕痎痊痏痒痍痔痌痐痓痋痑痖鸸鸽鸹鸻鸿鸾鸺鸷鸼皲產産硐硌硅硔硭硇硗硚硕硒硖硎砦硃硏硋硛硟碀硆硄硊硍硓硉硑硈硘硂硙矫矪祭票祡罣略畦畤異畧畣畨畡畩玈率窌窕窑窒窓窚窐窏窔裆袱袼袿袺裉袴裈袷裀袾袵袹袳袻袸袶裃袽裇裄蛏蛋蛄蛊蚶蛆蛎蛉蚲蚯蚺蛇蚰蚴蚱蛀蚫蚮蚵蚭蛍蛃蛁蚿蚳蛂蚾蚹蚼蛌蚸蚽蛈蚻蛅聃聊聆聋聍聉职聅聈聄聇缽虚虖處虘虙虗舂耞耜耛耝耚粗粝粒粘粕粜粛粣粚粓粖粙累紮胬艴舑紬絅絁紩紺紲紱組紳細紾終紵絃絆紿紼絀紹紴紨紭経絋紷絈紶絇絉紽紻紸絊衔衒術衑翎翈翊翌習翉翍翇翋翏翑翐舶船舵舸舲舻舷舴舳舺笨笾笞笪笛第符笰笴笱笳笺笠笭笢笯笸筇笙笥笤笮笩笣笧笚笗笲笵笟笷笽笝笡笻笘笶笹笜貪責貶貧貨販貫貮貥貦貭釈镺軛軟軙軚軣軖軠軞軜軝軡軗軘転赧赦赥豉谹谻谺規覔覓視覐覒覑觖觕觘觗兝兞野麸躯躭躮豝豜豚象豘豙豛訢詎訝訥訟訩許訛設訪訣訜訬訦訡訤訠訫訮訞訲訳訧訨訰邫酖酘酚酕酞酗酝酜酓酛酙酔豽豼赿赼趀赽赺赾赹赻趻趺趼距跂跄跃趾跀跁趽趹龁釱釭釫釷釬釦釺釧釤釣釩釵釹釪釰釼釥釯釮釻鈒釶釲釳釸釴釨閆閉閈閇閊飦飥飡鱾雪雩雫雭雀隿靪骩馗頂頃頄髙黒黄鹵鹿麻麥鳥魚颅羟颇领颈袭袤衅袋袈羝羚羕\uE85D袌袠" ,//11
                "羡匑凖凔凓凒凕厨厥厦厫厤厧割剩剴創兠隘隞隑隔鄗鄚鄏鄌隙隓隕隖鄖鄔鄒鄐鄍鄎鄕隒鄓鄑凲募勛勝勞勜凿傘傲傍傧储傣傎傅傢傕傈傉傩傥傒備傖傑傜傓傌僃傡傗偨傠傋傐傔僆傛傂傃傝傏傄傚傟傆傊傤博亁喪叅亵亴谤谠谧谟谦谥谡谢谣葆萹葧蒇葱蒂董萼葑葍葛蓇葓葫葭蒋蒈葵落蒌葎葩蒎葡葺葜萩葚葇葹蒐葶葖葳葸葈葙萱葬葉葢萬蒉葅葠萲蒍葷葒葦葤萻葊萯萴蒢萶蒫葮葐蒄葔葟萿葪蔇葌葏葥葁葝萭葰萪葀葻萰萺葿葞蒾葂萳蓱菐葴葋葲蒅萷蓃蓚蒊葨萫蒆葕葯葽萾蒏萮葾蒀葃蒃葘葼葄徨循御復徧徦徥徚徫逼遍遄道遁遌遏遑遒遂遆遗遐逾遇遉遊運違遃遅遚達逿遖遈遀尊尋尌奡奥奠奤奣巯弼强弻弾弽廂廁廄廃廀廆廋庽廐凱彘幅帽幂幈幄幇幃幉帿幆幁幀啽嗏喳啻喘嗒喋喊喝喉喤喙嗟喈啾喀喾喹喟喇喱喨喽喃喷善嗖啼嗢喂喔喜喧喭喓喑喁喻喌嗞啙喬喆喫單喦啣喒喲喺喰喢喠啿喥嘅喼嗗喛喖喚喞喕喸嗴啺喡喴喣喅喩喗骙骗骚骛骘阓阔阑阒阕富寒寐寔寓寍寕寎寏寋寑寊媕媪媠媿媢媒媚嫂婷媦婺媭婿媛媟媮婣媯媬媋媨媅婸媂媏媍媩媓媈婽媘媫嫅媡媄媔婻媆媥媊媇媝媣媶媃媞媤婾媁媙媉媗婹媀媜媑猹猲猴猢猾猸猱猥猬猩猰猨猶猵猭猦猤猳獇獀猯猣嵖嵯崿嵇嵁嵝嵋嵌嵚嵘崴嵬嵎嵛崽嵫嵗嵐嵳崵崼崶嵅嵈崲嵆嵑嵙嵂嵍嵄嵒嵜崷崹嵉嵔嵃嵓崸崾崺崳崱崻嵀嵏嵕彭屡属屟馇馋馉馈馊壹壻壺揞揙摒插搽搀揣搓搭提揥揲摡搁揈搰揃搅揭揪揩揢揆揦揽搂揿揉揌搔搜揻揾握揳揎揠揜揖揄援掾揸揍揀揕揹揚揷揑揮揊揨揰搥揼揯搄換揘揂揟揁揇搑揓揔揬揋揗揺揝搃渤滁湩渡溉港渹湖滑湟溅湔湫湝湨渴溃溇湄渼湎渺湣湃湓湿湜溲溚湠湉渟湍湾湋渭温渥湘渫湑溆渲湮渰湧游渝湲渣溠湛滞滋湊減湞湯渢測湌淵湻溈渾溾湢湐湹湁渧湺湂渪湗溄渱湀湼渙湏湷湱湒溂湅湸湰満湈渳渿湳渜湪溌湆湇溬渞湭湶渘溞渻湦湤湥渨溊渷湙湚溁溋湵湡渽湽编缏缔缎缑缓缋缉缄缂缆缕缅缈缗缌缇缐缃缘缊缒巽堡堛堾塔堤堞塅堩堠塃堪塄堧堶塆堰堙堦場堘塊報堖塟堨堢塠堮堸堼堚堭堿塂堺堻塁堜堥堳塀堷堗塭塈塇堯堣堬塦堹堟堫圌圐圍圏圎舜夡尞悲愊愎惼惵惰愕愤慌惶慨愦愧愣愀禽慅惺愔愉愠惴惾愐愜愒惻惲惽惱愺愖愓愅愲愌愘悶愞愢惿愄愇愃愋愝愑愡幾弑就尳尰孱孳赑赐赌赋赓赍赔赏赎赒赕琵焦然煮無焣辈辍辊辉辇辋辎辌殚殛殖殗殘殕殙殔斝斞旐旔旑飓爺戢戟戞戠扉扊焙焯焠焚煚焜焮焰焱煑焥焻焧焨焤焵焿焸煱焢焝焳煡焞焛焾焷焩焪焭焼焺焽焹煀焟焬焲煐焴旤觌觍斯斮斱耋毳毽毰毵毯毴毲毱毶棒棓椑楮棰椎棣椟棐棼棡棺棍椁楛棔棘楗椒椐椈椇棵榔棱椋椤棉棑棚椪棋棨椠棬森棯棠椭棪椰椅棫棹椥植椓棕棗椉棄琹棶棖棊棟椏棧棃椗椀極椝椕棅棌棎椙棽椆棇椊棤椡棏椣棥棴椨椩棝椢棞楇椃検椄椌棙椂棆椚椧棿椖棲棈棾椦楉椫椮棷棢椞楧棭椬棛棜楰棳椔棸犀犂犇犊犄犍犋犉犅犃犈犆牍牌牋敠敧敥敤敡敞敦敬散敩敟敪敜敨氮氯氰氬氭欻欿款欺欽欼歄欹猋猆猒猌晻晷晶景晾普晵晴暑晰暂智晬暎晳晿暏暃晽晲晱晪晩晼暀暁晹晭晫禅祼禄祺祹禆禇禂祻禍祾祿禃祽掰掣掱掌掔殽殼殾淼淾瓿瓽瓾甁甀琲琫琛琮琱琯琥琚琨琳琭琶琪琦琴琼琬珷琰瑛琢琖琺瑯琣琕琩琡琗琔琽琜琘琝琠琟瑘琙琸琻韩斑斌斐惫惩惠惑惎惄惹惪惡惥惌悳悹惒惢惖惁惉惣牚曾替最朁朂腌朝腚腓腑腘腱腈腒腊脾期腔腆腕腋腴腙脹腖腎腡腗脿腄腏脺腅腍腂脻腃脼腀腉腇腁朞脽朜朠爲攲歯歮皕皓皖皒皔登發程稃稇稂稍税稀稉稈秿稁稌稅稊稄锕锄锉锇锋锆锅锏锔锎铿铼锒铹锂链锍锊铺锓锐锁铽锑铻销锌锈铸锃竣竦童竢竤竧矟矞盜盙盚睇睋睅睆睑睊睐睄睃睎睍睏睈睉睌睂痤痘痪痨痢痗痞痡痧痠痛痦痫痣痙痥痾痝痩痜痚痟鹁鹅鹄鹃鹂鹈鹀鹇鹆皴皳甥甦甤硠硫硵确硪硝硬硨硯硤硜硶硥硳硩硲硡硴硷硞硱硦硰硧硣硢矬短罦罥罤畴番畯畬畲畫畱畮畳畭窗窜窖窘窝窛窙疏疎裎裥裤裢裣裙裋裕補裌裡裓裐裍裗裑裞裖甯茻蛤蛔蛱蛟蛞蛮蛑蛲蛴蛩蛐蛳蜓蛙蛧蜒蛘蛰蛭蛛蛕蛒蛯蛠蛪蛥蛡蛬蛓蜑蛗蛫蛣蛚蛨蛢蛝蛜蛦聒联聏聠聓聎聑聐缿缾罀虝虛舄舃耠粪粟粞粥粤粢粦粧粨粫粭粠粩粬粡絜絮絷紫絛絭絫脔胾胔艵舒絣絓結絡絪絑綁絨絝絰絚絏給絳絶絍絢絎絞統絲絠絔絾絒絘絩絧絥絯絙絵絗絕絖絽紪絟綎絤綖絴絬覃覄兟翚翙翘翕翔翛翗翖翓臷臵臶臸臹艇舾舽舼舿筆筚策答筜等筏筀筋筥筐筈笿筌筛筳筒筅筵筝筑筘筍筊筬筂筕筓筙筁筎筄筃筗臯臰臮貳貰賁貼貴買貺貸貿貯貽費賀貱貾貵貹释釉镻軱軲軻軹軸軤軫軼軺軪軷軰軧軩軶軬軵軥軦軨軳軯軽軮軴覗覘覚覕覙觚觞觝觛量躰豠豟豞辜辝訸詈詒詟詝評証詁訶詛詗診詐訴詆註詑詞詔詘詙詖詀訵詚詄詂詌訽詃詅詉詊詓訷詜訹詇詏詍詠詋酢酦酤酣酥酡酠酟貂貀豿貃豾貁超趁趄趋越趂趆趃趉趇趈跋跛跌跕跗跏践跔跞跑跚跎跅跖跘跈跙跍跉跊跜跒跆跇跓龂靟鈇鈜鈚釾鈆鈃鈣鈦鈈鉅鈍鈔鈉鈐鈞鈎鈑鈄鈁鈧鈥鈀鈕鈂鈟鈗鈬鈋鈖鈛釿鈌鈩鈪釽鈊鈙鈓鈤鈫鈢鈘鈠鉯鈏鈝鈨鈅鈡閑開閎間閒閔閌閗閍閏閐閖閕靓靔飧飨飩飪飫飭飯飲飱飰鲃鲂鲁鲀鱿雳雱雯雲雰雬雮雇集雄雅雁雋雈雃雂颩颪靬靸靰靭靱靫靮靯骭骫骪骮骬鬽韮韌項須頇順髠馭馮黃鳦鼎黑鼋黽黍黹颊颌颉颎颏颍颋题颂装裒衉街裁裂裏\uE81A褁羠袲衆羢衖" ,//12
                "亂亃亄羨義凗厯厪剺剿剽剷剹剾剻剼剸匯鄙鄜鄠隟鄢鄞鄘鄣障際隠鄛隝鄝鄤鄡鄥隡隚鄟兾兿厁厀勤勣勢勦勠勡勧勨僉傺催傫僇僄傻像債僅傾傴傳僂傷傯傭傰傪傮傸僀働僙傼傹僋僈傶傱僁傿僌傽亶亷谫谨谩谬谪叠蒡蓓蓖蔀蓧蒽蒿蒦蒺蓟蒹蒟蒯蓝蒗蓠蓏蒙蓂蓦蒳蓬蒱蒲蓉蓐蒻蒒蓍蒴蒜蓑蓨蓊蓄蓥蓣蓁蒸蓋蓮蓽蒼蒨蒞蓡蓆蓀蒓蔭蔜蓛蔯蒭蓫蓌蒧蒶蓕蓘蒝蒩蓢蒚蓤蒥蓅蓩蒘蒰蓜蒪蒛蔱蒔蒣蓎蓪蒤蓞蒠蒵蓒蓔蒑蒮蒬蒕蒷蒖蓗蓙微徯徭徬徰遨遘遛遣遝遢遥遞遡遜遟遳遤遙遠奨奧奦彀彂彃彁弿廒廓廉廈廕廍廅廇廌彚彙幌幕幙幊幏幎幋幍幐嗄嗳嗌嗷嗔嗤嗲嘟嗝嗨嗐嗥嗑嗯嗫嗙嗛嗪嗓嗜嗣嗉嗍嗦嗡嗅嗈嗇嗸嗬嘩嗊嗎嗩嗶嗆嗚嗁喍嗭嗰嗀嗃嗘嗧嗠嗹嗼嗱喿嗕嗮嗵嗋嗂骜骝骞骟阖阙阘阗寞寝寘寛寚寖寗寜寙嫒媸媾嫉嫁嫫媲嫔媳嫌媵嫄媽嫋媼嫯嫎嫑媰嬅媹媺嫇嫐嫟媻媐嫓嫀嫆媷嫊嫍嫈媱媴嫃猺猿獉獁獅猻獓猼獊獆獏猽獈獂嶅嵴嵲嵊嵩嵠嵦嵭嵢嵣嵮嵟嵥嵪嵧嵰嵤嵶嵵嵞嵡嵨嵱彮馎馏馍馐馌壼壾摆搬搒摈搏摛搊搐搋摁搞搳搛搢搕摸搦搉摋搡摄摅搠摊搪携摇搌搘損搨搶搇搗摀搤搧搾摑搹摓搆撶搩摃搚搮摙搣搱摂搙搝搼搈摉搷搎搯搲搵搟搖搸滗滨滀滇滏滆滚滈滉溷漷滘溘滥漓溧溜滦滤满漭溟漠溺滂溥溱溶溽滠溯溻滩溏滔溦滃溪滫溴滟溢溵滢滪源滍滓溝漣滙滅溼滭溳滛滄準滌溰滶漨溗滣滜滒溎澕滐溍溓滝溣溤溕溿滊溹溡溮溸滖溑溙溛溫溩滧潃溔溒溨溭缤缠缞缝缚缟缙缡缛缢缜缣塝塍堽塥塨塱塓墓塞塑塌塘填塕塮塬塤塏塢塗塙塋塚塧塡塖墎塰塉塪塛塯塻塜塳塒塐塩墷塎塣園圓圕圑圔舝夢尠尟慊慑慎愫慆慥愽慄愷愴愾愵慠慉愩愰愱慩慏慔愭愼愯慍慀愶慃愮愹愪弒尴尲孴孶赗赖煎煞煦照煭煕辏辐辑辔输辒琿殟殜斟旒旕旓飔飕戥戤戡戣戦煲煏煸煅煳煌煤煣煺煨煖煊煜煴煒煉煙煠煩煗煬煢煇煘煁煈煂煥煍煯煃煷煝煵煔熍煪煰煶煫煓煟煆煋煄觎新毷毸毹毼毺毻楂槎榇楚椽槌椿楤椴楯概榾槐楫楷楬榉榄楞楝楼榈楣楠楄榀楸椹楒榃椳楔楦椸楹楢榆楳業楊楥楩椶榘楓槩楍楅榋槆楱楴楪椯椱椷楁楜楻椲楎椵椾楐楶楏楑楋楽楙楘榌椺楾榵楺榊榁榙楟榳楕楲榅楃楿楈椻椼楌楆楀楡棩楨犎犐犏犌犑牃牒牐牎牑牏敯敮敫数敭氲氱歃歇歆歈歂歁歀歅献猷暗暅暌暋暖暐暇暄暍暈暉暘暙暕暓暔暒暛暊暆晸禘福禖禊禋禔禎禕禙禈禓禗禑禒禉禐禌揅揫揧揱殿毂毁毀湬甄甃甆甂甅瑳瑰瑚瑊瑁瑙瑞瑟瑕瑄瑒瑜瑀瑗瑑瑇瑏瑃瑖瑍瑝瑐琾瑓瑂瑉瑔瑈瑌瑅瑋瑥瑎瑆瑵韪韫斒愁慈感愍愆想意愚愈愛愙惷愂愗會腤腷腠腭腹腼腩腻腮腧腾腯腿腽腺腥腰膇腳腣腸腫腦腟腶腞腵腜腝腢腬膄腨腲腛腪朡歲歳歱皙皗皘甝甞瓡稗稖稠稞稔稣稙稚稜稟稒稘稛稑稤稐稝稡稥稏稢稕稓锛锤错锝锭锢锪键锦锯锩锞锟锣锚锰锘锫锖锬锡锨锳锗锧锥锱锜锠竪竨竩矠盝盟盞睥睬督睹睢睫睛睖睩瞄睦睨睒睡睟睚睞睠睪睔睧睷睝睙睰睤睘睗睓睕睜睭痹痴瘁瘅痱痼痯痵痲瘆痰痿瘀瘐瘃瘂痬痷痺痭痸瘄痶痽瘑瘔痳痻瘏痮鹌鹎鹑鹒鹋鹏鹐鹊鹔鹉鹓鹍皵碍碑碚碜碘碉碇碓硿碌硼碰碕碏碎碗碔碁碆碂硾碙碋碊碅硻碐碄碖碈硸碃硹碢硽碒碤硺矮禀禁署罨罭罩置罪罫罧罬畸畹畺當畵畷窦窠窟窥窣窩窞窤窢窡窧裨裱裯褚裰褂裾裲裸裼裷裺褃裶裪裧裮裭褀裩裬裿褄琧琞臦蜍蛾蜂蜉蜐蜊蛸蜃蜀蜕蜗蜈蛹蜇蜖蛽蛼蜔蛿蛻蜏蜣蜎蜆蛺蜋蛖蜌蜅蝍蛶蝆蛷蜹蜄蛵蜁聘聖聕聗虡虞號虜舅與耢耡粲粳粮粱粯糀粴粵綤綔絺絻綗綆綀經綃絸絹綑綏綉綌綈綐綘綍綒綋綄継綅絿綛綂綊綇続絼綕覅裚翝翜肆肄肅艀艄艉艅艂艆艃艈艁筧筴筹筻筦简筠筷筢签筲筮筭筱筼筯筰筞筩節筟筸筶筨筺筤筣筽筡筪筿筫賈賊賄賂賃賉資賅賌賎賋賆賍貲輀輂軿輋較軾載輊輇輈輅輁輄輆軭輌農赪赩赨豋豊谼覜覛触觥解觜觧觡觤觟觠觢兡躲躳躱豢豥豣豦豤辟辞辠誊誉詹訾誄誆試詿詩詰誇詼誠詮誅詵話誕詬詭詢詾諍詶詫該詳詸詣詡詧誁誀誃誂詷詻詥詪詤詯詺誔詴誈詨詽訿郌郒酬酱酪酩酮酰酯酧酫酭酨貉貆貊貅貈貇貄趔趑趍趐趎趓趏趌趒跸跐跺跟跪跻跲跤跨跬路跷跫跳跹跣跩跴跥跡跰跢跮跦跶跧跭跠踭跱龅龃龄龆鉴鉧鉮鉥鈺鉦鉗鈷鉢鉕鈳鈽鈸鉞鉏鉬鉭鈿鉀鈾鉠鈴鉑鉤鉛鉋鉚鉈鈰鉉鉍鈹鈮鉡鉳鈵鉆鉓鈶鉪鉘鉜鈲鉌鉫鉣鉲鉱鉝鈱銰鉨鉩鉟銏鉎鉂鉃鉇鉐鈻鉰鉄鉖鈯鉔鉙鉊鉁鉒鈼閟閠閘閙閞閜閝閛閚靖靕飾飽飼飿飴飹飶餀飷飬飻飳飮飵鲅鲍鲌鲋鲎鲈鲇鲏鲆鲐鲉鲊鲄雹雷零雾電雸雴雼雽雺雵雏雊雎雍雉颫颬靶靳靴靷靹靵靲骱骰骯魂魁魀鬾鬿馚頊頑頓頒頌頎頏預頋頍頉韵韴髢髡馱馴馳馰馯馺馲馵麂麀麁鳩鳯鳪鳭鳧鳮鳨鳰鳫魛魞魝魜鼌幹鼓鼔鼠颐颓颖颔频颒裔裏群裟衙裘颕\uE85F裛\uE824\uE82E嗀裝羧衘",//13
                "瑴凘厮厰厲厭厬劀劂劁劄劃兢匱匲匰鄱鄯隧隤隩隨鄩鄲鄭鄰鄧鄪隥隫隣鄮鄳隢鄬鄦鄫凳凴勩勱勥勭勫勪勬冩僰僝僢僜僭僬儆僦僚僶僧僳僮僖僔僊僥僨僡僕僑儁僱僠僤僘僞僫僟僣僒僪僗僯僛僐僓僩僲僴僷僎叆谲谰谱谯谭谮蔼蔽蔡蔟蔸蔊蔧蔻蔹蓼蔺蔓蔑蔫蔷蕖蔌蓷蔚蓰箫蓿蔗蓺蓴蔕蔂蔞蔥蔦蓯蔔蔆蔴蔣薌蓭蔈蔢蔵蓸蕏蔍蔖蔋蔐蓲蔉蔮蔛蔰蔒蔪蓵蓳蓻蔨薖蔲蕯蓾蔄蔝蔤蔳蔘蔏蔎蓶蔙蔅蔩蔶蔁蔠徴徱徶徳遭遮遯適遪遫遰遦遱遬遧對奩奪奬巰彄彆彉彅弊廑廖廏廣廗廔廘廎廜廙幖幔幛幘幣幗幚箒幑幓幒嘣嘈嘚嘀嘎嘏嘝嘒嘉嘞嘛嘧嘌嘁嘘嗾嗽嘡嘕嘐嘤嗻嘗嘖嘆嘜嘔嘑嘍嘓噉嘊嘇嘨嘃嘄嘢噑嘂嘦嘙嘥嗺嗿嘋骠骢骡阚察寡寥寤寨實寣寠寬寧寢嫦嫡嫪嫘嫠嫚嫩嫖嫳嫱嫣嫛嫕嫜嫰嫗嫧嫷嫢嫨嫭嫮嫤嫝嫲嫹嫥嫙嫞嫬獕獚獍獐獄獙獑獔獌獡嶍嶂嵸嵽嶄嶃嶇嶁嵾嶆嵼嶉嶋嶌嵿嶞嵺嵻嶐嶈嵷嶀嶑嶎嶊彰彯屣屢馑馒壽夀摽摴摐摧撖撂摞撇摔撄摘摭摶摳撦摣摟摠摺摻摜摬摲摖摌摷摚摤摏摢摕撗摫摦摪摎摼摝摱摵撁摗摍摥撱撾摿撯擆滮漕漘潀漼滴漧澉漍滹漶潢漈漖漤漯潋漏漉漫漰漂漆漱漙潍潇漩演漾漪潆漳潴潈漬漸漚漢滿滷漊濄漁滬滸滾滻滲漲澚漅滯漴漺漎漗潒滼漑潅潂漃滰漌漮滱潉漻漋滵漞潎滳漡潄漟漛潳漥漇漝漵潊漄漹漜潩滽滺潌缧缦缪缥缫缩缨墋墐境墈墚墁墘墙墒塾墅塽墟墕墉墴墍塹塼墊塲墖塵墜墬墮塴墂墄墔墆墑塿塶塷塺塸墏墭墛増墇墌墸圙團圖圗夥舞夤夣慕尡憏慷憀慢慓慵慪慳慚憜慟慽慴慘慣慒憆憁慛慖慬慻慺慲憈慯慡慱慞夐孵孷赙赛赚赘箦熬熙熊熏熈辗辖辕殡殠殞殝斡斠旗旖飖飗戬截戩戧戨戫熇熘熔煽熥熄燁熗熒熢熚煿煼煾熕煹熆熀煛熑熐熋熌煻熃熓熂熁熖熎熅熉觏斲氁毾榜槟榱榧榑槔槁槅榥槚槛榤榼榴榠模槃榷榕槊榫榻槄樋榲榭榍榨榛榰槠槖榦槑槇構榎槤槓榪樺榿槍槀槨榮榖榐樄樆槒槝槙槉榢榗樃槏槞榓槈榒槰樥榩槗槡榝榺榯榹榡槂榶樤榽樇様榚榣榏榞榬榸槜槕榟犖犒犕犓犗犔牄牓牔敲敱敳敻敶氳歌歉歍歊歋獒獃暧暠暨暝暮暢曅暱暤暞暟暦暯暜暣暡暥暚禢禚禛禡禣禞禝禠禟搿摹搴摮搫搻毄毃滎甍甈甉甇瑷璈瑨璃瑢瑭瑱瑶璉瑪瑣瑲瑠瑸璍瑮瑡瑹瑫瑦璓瑤瑧韬慁慝慇愿愨慂愬態慐愳愻愸爾朅朄膀膑膊膏膈膋膂膜膍膁朢膆膌膖膅膃膎膉爳歴歰稨穊稳稬稭稱種稫稲稪稩稵稧穁稰稦稯锿锸镀锻锷镄锾锽镌锴镂镅镁锵锹锲锶锼镃锺端竭竰竮竬監盡盠盢毓瞅睾瞆睽瞀睿瞍瞇睶瞂睴睺睳睯睸睼瞃睱睲瞁睻睮睵瘥瘈瘩瘊瘕瘌瘘瘙瘦瘟瘗瘋瘉瘖瘎瘍瘓瘣瘧瘒瘇鹚鹗鹘鹖鹕鹛鹜鹙皷皸皹皶甧碧碥碴磁磋碲碟碫碱碣磈碶碳碨碹碡碸碪碩碭碮碠磓碷磀磆碦碯碝碵碬碞罱罴罳罰罯畼畻畽窭窨窬窪窫疑疐褓褙褊褡褝褐褛褪褞褘褕褌褨褈褋褍複褔褆褅褖褉褗裫褑臧蝉蜚蝈蜾蜡螂蜽蜢蜜蜱蜞蜻蜷蜩蜿蜥蜴蝇蜮蜘蜯蝄蝅蜠蜫蝋蜝蜶蝊蜟蝂蝀蜰蜺蝕蜨蝸蝃蜳蝁蜬蜭蜛蜧蜦蜸蜤蜙蜪蜼蜲蝧蝫聚聝聛聡聜聢聙聣聞聟罂罁虠舆耥耤耣粹精粼糁粽粰粺粿粷粶粸粻綦綮緊緐腐舔舓舕綵綝綷緺緉綪緌綯緅綾緒綫綺緋緔綽綥網綱緄綬綸綳綹綢維綿綜綻綰綣綠緇綴緍綼緂総綞綶綟綡緑緢綨緀緕緁綩緆緈緓緎綧緃裳裹裴褏褎製裵裦裻翠翟翡翣翥翤翢翞肇肈臺艋艊艍艌箄箅箔箣箪箙箍管箕箘箜箩箧箐箬箑算箨箢箸箝箋箎箇箠箓箃箆箥箁箈箉箌箛箟箂箖箞箊箚箏箤賓賑賕賖賔賗賒賐賏賘輒輔輕輓輐輑輎輏輍赫谽覡覠覝覞覟觫觨觩觪躴躵豪豨豩豧辣辢辡誓誡語誌誣誖誚誤誥誘誨誑説誦認誝誧誗誎読誐誮誋誩誙誏誛誜說誒誢誟誫酲酵酷酹酶酿酺酾酸酴酽酻酼酳貌貋貍趖趙趕趗趚趘踌踆跽跼踉踅踊踁踄跾踀跿踋踎踇踂踃踍踈龈龇銮銎銐銞鈭鋋鉷銜銒鉶銠銬銍鋩鉺銪鋮銕鋣銅鋁銱銦銓鉿銚銖銑銩銛鋌銘鉻錚銫銨鉸銥銃銀銣銭鉼銟鉹銧銗銊銈銡銄銁銙銇鉾銤銆銔銢銋鉽銉銯鉵銝銂銌閤閧閨閩閭閥閣閡関閦閰閪閮静靗靘餂養餌餄餁餉餎餃餏餅飸餇餆鲕鲑鲘鲚鲛鲒鲙鲖鲔鲜鲞鲟鲗鲝鲓霁霆需雿雌雒雐雑颭颮颯颱颰靼靺鞅靿靽鞁鞆鞃鞂鞄鞀靾靻骳骶骷骲骵魃魄魅魆靤韍韎馝馛馜頔頗領頖頙頕頚韶韷髧髦髨髤髥髣髩髪鬦髚駃馹駄駁駂馾馸駏馿馷駇駆馶馼駅駀馻馽麽麼麧鳳鳶鳴鳲鳵鳱魟魢魡魥魠鼐鼑鼏鼻齊颗隣" ,//14
                "匔凛凙凜凚厱劈劎劐劌劇劍劊劉劅劋劆劏匳險鄴鄵鄷鄶鄸隦勰勲勯勮冪僾儋僵儌僻僿儇僽價儂儍儉儈億儀儏儃儊儅僼僸儚儙僺儎叇谴谳谵蕃蕡蕙蕺蕉蕨蕢蕲蕤蕊蔬蕣蕰蕈薁蕴蕞蕓蕘薘蕋蕚蕒蕪蕎蕕蕆蔾蕫蕩蕁蕔蕇薡蕟蕜蕧蕐蕀蕑蕳蔃蕝蕌蕄蕅蕠蕱蕂蕬蕵蕛蔿蕮蕸蕦蕥蓹蕍德徵徹徲徸徺巤遴遹遵遶邁遷遼遺選遲遻邆導奭奫彈廛廚廝廤廟廠廡廢廞幢幡幞幠幟幤幝幩幜幥噌嘲嘬噇噔噁噶嘿噍噘嘹噜噢嘭噗噙噎嘶嘻噏噀嘱噂噐噴嘵嘠噠嘽嘸嘷嘮噚噝嘰噃噆噄嘼噈嘾噵嘳噅噕噋噒嘪噛嘺嘫噓噧噖噊骣寯寮審寫寭寪嬎嫽嬉嬃嬈嬋嬀嫵嬌嫻嫺嫿嬁嬞嬏嫴嫶嬇嫾嬍嫼嬘嬆嬊嬄嫸嬂獗獠獋獖獛獤獦獜獞獟獢獝嶓嶒嶝嶙嶟嶢嶠嶴嶔嶗嶡嶯嵹嶕嶣嶜嶥嶱嶚嶛嶏嶖嶤嶘影屦履層屧馓馔壿播撤撑撺撮撴撝撅撧撩撸撵撚撬擒撒撕撷撰撞撙撡撳撓撻撐撲撣撫擕撟撈撥撏撪撜撘撢撌撔撠擖摾撹擑擏撛摨撍撋撨撊擛撎澳潺潮澈澄濆澔澒潓澜潦潾潖潘澎潽潜潵潸潲澍澌潠澾潭潼潫澫潕潝潟潔澆澘澐澁潛潿潰澂潷潨澇澗潑潯潤澠潹澊濎潡澓潙澏潶澋澅潗濈潐潏澑澛潣澝漒潬潻濍潥澻漽澙澖潱潪潧濐缭缮缬缯墺墀墫墩墦墨墝墠墡增墳墶墪墢墱墥墯墹墤墲墣墧墰墵圚夦懊憯憧懂憓憬憭憔憎憤憒憚憮憞憐憫慙憡憕憱憣憍憢憰懏憦憉憴憽憟憛憳憘憪尵赜熟熱辘殣殢殤殦殥斢飘戮戯戭熛熯熳熰熵熠熨熝熜熣熩熿熞熲熦熴熮熡熭熤熪熼熫熧觐觑斳毿氂氀槽樘樗樀樊橄横槲槥樫槿樛槺槷槭樯橡樱樟橥檛樂樁標樞樏樓樅樑樣槳橢槹槱樔樬槯槢樚槪樌槣槶槻槼槴槬槵樭樖樠樐槾橗樒樢槧樈槫権槮樧樉樎樕樰樮槸槦樍樝樜樦犛犘犚犙牅牖牕牗敺敷敵數敹歔歎歐歑歓歏歒獘獎暴暵暹曏暫曄暷暰曃暭曂暳暩暪暼暬暶暲禤禩禥摩摯撃撆摰撀毅毆漦滕潁漿漀漐甎甌甋甊瑽璁璀璜瑾璊璆璅璇璎璋璂璡瑺璄瑻璖璌瑼憋憃憨慧慜慼慰憂慶慤慮慾憇慫慗慸慦慿憅慭慹憄膘膗膵膛膝膣膞膚膕膓膠膔膢膟膒膷膤膡膼歶歵爴皝皚皞皜皛皣稻稿稾穀稽稷稹稺稴穃穂稸稶镑镈镐镉镓镏镆镎镊镍镋镒镇镔镕盤瞋瞌瞒瞢瞑瞎瞝瞊瞓瞏瞉瞐瞙瞈瞱瘢瘪瘛瘝瘠瘤瘼瘞瘡瘜瘫瘨瘚癊鹤鹣鹠鹟鹞鹝鹢鹡皺磅磙磕磊磏碾磐磉磔碼碻確磑磝碽磂磗磇磎磍磃碿磄磌磘磤磒禜罶罵罸罷罼畿畾窳窯窰窮窲窴窱褫褯褴褵褦褥褳褟褲襅褠褣褬褤瑩瑬蝙蝽蝶蝠蝮蝴蝗蝌蝰蝼蝥蝻蝤蝾螋蝎蝣蝓蝲螀蝿蝜蝘蝟蝨蝯蝱蝦蝹螁蝭蝩螆蝳螝螖蝔蝷蝐蝞蝒蝚蝵蝺蝡蝪蝏蝛蝑蝢蝖蜵蝝蝬聪聩聤聦聥聧聭聨聫虢耧耦糍糇糊糅糈糌糂糉糄糋糎糆糃糔緜緳齑舖舗縆緘緛緼緰緙緗練緬緲緹緝緦緩緞緶線緥縋緱締縂編緪縁緯緾緽緟縒緫緿緮縎緷緡縌緧縙縇縄緭縅縀緤緖縃緸緣緵褒褢褜翦翩翪翫翬翨翭翧艑艖艓艎艏艘艔艐艒箯篅篌篁箭篑篓篇箱篂箴篆篋範箲箷篨箺箹箽篈篐篊箶箿箻篃篎箳篏箾篍箵篒箰箼箮臱賧賢賣賞賡賨賦賛賬賭賫賚賤賜賙賠質賝賩賥賟镼輗輫輣輚輝輦輙輛輥輞輩輪輨輟輜輠輡輘輬輧輢輖辳赭豌豎豍谾覩覥覢覣覤觭觯觰觮觬麹躺躶躷躸躹躻躼豫豬辤諔諓諙請諾諸諏諑課誹諗論諉誰諛調諂誼誶諄諒談誾諀諘誯諃誺誴諎諌諣諕諅誱諊誳誽諚諩諆諐誻誷誸誵諈諁郶醇醋醌醂醁醅醄醊醉醃醆醈醏醀貓貏貎趣趟趠趡趤趞趝趜趢趛踣踩踟踔踧踮踝踑踺踞踡踦踏踢踠踒踯踬踪踖踐踫踜踓踤踻踕踘踛踚蹃踗踙踥踷踨龊龉靠鋬鋈鋆鋫銴鋚銺銶鋗鋜鋕鋙銾鋱鋪銷鋤鋰鋥鋇銼鋯鋝銹鋨鋒鋅鋶鋭銻鋃鋟鋦錒鋲鋍鋓鋑鋀銳錺銽銲鋎鋡鋐鋘錵鋏鋄鋞銵錓鋛鋢鋂銸鋠鋖鋉鋵鋔鋧銿鋊鋴鋳閫閴閲閬閳閯閱靚餔餗餍餈餑餖餒餘餓餕餝飺餋餙鲠鲧鲩鲫鲣鲪鲡鲤鲢鲨鲥鲦鲬霉霂霈霄霅震霃霊雓颳颲鞍鞑鞒鞋鞌鞏鞈鞎鞊鞐鞉鞗鞇骴骼骸骺骹骻骿魇韯靥韐韏韑頞頠頫頡頜頟頲頦頨頧頬頢頛頪頩頝頣髲髳髯髫髰髮髴髱髬鬧髛駜駉駓駔駛駟駈駙駒駝駐駘駑駕駖駠駍駊駞駚駌駋駗駎黆黅鹶麃麄麾麨麩麪麫鴃鳾鴈鴉鴇鴆鴁鳻鳷鴋鴌鴀鳺鴔鴂鳸鴅鳽鴎鴄鳹鳼鴍鳿魬魣魯魷魨魴魮魤魵魧魱魪鮔魲魩魹魶魸魦魫魳魭魰鼒黙黓黎齒颙颚颛羯额颜\uE861羰衝衛羬",//15
                "彛龜冀凝凞厳劒劔劓劑匴隰鄹鄺隯隭隮隬隱隲勵勳儜儒儓儛儔儕儐儗儘儑儫儣儖儞儝亸叡薆薄薜薋薅薨蕻蕾薐蕗薯薮薙薇薳蕹薤薢薪薛薏薔薑薟薈薊蕿薦蕭薩蕷薉薬薭薒薠薣薃薧薕蕶薍薎蕽薓薥蕼薞薚薀薂藇薫薗薝薽徼徻避遽邂邀邅還遾奮奯彊彋彇廪廨廩廥廦廧彜幨幪幧幯幦噫噩嚆嚄噭噤噱噼器噻噬噪噣嘴噸噦噹噥噯噲噰嘯噡噷嚃噺噞噟噳噮阛寰嬖嬗嬴嬙嬡嬔嬝嬠嬨嬒嬓嬐嬚嬢嬛嬕嬜嬑嬟嬩嬳獲獴獭獬獧獨獫獪獩獥嶰嶪嶩嶧嶼嶨嶮嶳嶭嶦嶶嶫嶬嶵夁操擀撼擐擓擂擗撽擅擞擋據擄擇撿擔擙擈擉擜擭擳擝擃擌擁濒澶澹澤澴激澽濑澧濂潞濛澼澨濉澥澡澣濇濃濁澱澦濭澯濸濋澬濨澸澢濩澮濊濅澰濓澟澪澷濗澿濏濖潚澲澺澭澞澵瀄缳缰缴缱缲壁墼壈壅墻壄壋墾壇壒墽壆壂壊壃壉壀壌墿圜圛懆憷憺憾懒懔懈懁懞懌憹憶懍懓懐憿懅懜懄懎憻懀憸懙學孹赝赟赞赠熹燕燞辚辙殪殨殫殩殧旙旘飙飚戰戱燔熸燎燋燃燊燧燖燠燏燄營熺燒燀燙熾燉燚燜燈燌燪熶燵燑燓燝燇燗燤燐燘燂燆燍熻燅熷斴氅氇氆氄氃橙橱樲橘橛橹橇樵檎檠橪橤檨橦橐樨檃橼樾檇樽橜橈樹樷樸檝橋機橺橴橧橕橖檙橻橁橽檤橂橝橷橔橃橎橨橰橭橫橞橶橌橏橸樻橑橯橉橊橮橅橣橠橬橩橍橵樿橳橓檧檖橆橀橲樳樴橒樼樶犟犜犞犝敽敼整敿敾歙歘歕歚歖獣曈暾曀曆曌曇曊曍曁暻曔暸暽曋暺暿曉禫禧禪禨禭撉擎毈毇澃甏甑甐甒璠璟璘璞璕璢璣璒璝璭璤璥璚璙璲璏璑璔斓憝憩憙憖憲憗憊憼憠憥憑憌朆膪膰膙膫膦膨膳膩臈朣膧膬膭膹膴膲臇朤朥膸膯膮膶膱攳歷皡皠皟瓢穇穄稼穆穑積穌穅穎穔穋穒穈穐穓镚镖镝镜镠镘镗镛镞镙镟竱盥盧盦瞠瞛瞰瞜瞟瞥瞚瞖瞞瞘瞗瞡瞣瞔瞕瘭瘳癀癃瘰瘸瘾瘿瘵瘴瘮瘯瘹瘺瘻瘽瘷瘶瘱瘬瘲鹨鹥鹦鹧皻磺磡磨碛磜磬磲磧磚磠磟磖磣磛磢磭磪磥磮磞磦磩磫罹罻罺疀疂疁窿窸窶窵窺窻窼窽窷窹褾襀褧褶襐褸襒褿襔褹襂褷瑿螯螭蟆螨蟒螟螃螓融螗螅螠螈蟇螌螕螙螛螊螧螎螦螩螡螣螉螞螘螄螥螴螒螜螏螶螚螇螔螐螑螢螤聱聮聬罃虣虤虥虦興舉耩耨耪糒糙糕糗糖糏糐糓糘糢糑糚縢縣縏縈膐舘縠縑縓縚縛縝縟緻縉縧縫縭縗縞縊縍縪縐縦縨縘縺縸縔縤縕縖縜縡縥褰襃褩褱褭褮翱翰翮翯翴臻艗艙艕篦篰篪篘篡篚篙篝篮篱篥篢篷篠簉篹篤築篳篩簑篛篬篴篕篧篯篭篞篣篟篖篔篗篜篫臲賴賵賲賰賮賯賱賳輴輹輮輶輷輳輻輭輯輼輲輸輵輱輤輰輺赬赮覦親覧覨觱兣鹾麺躾躽豮豭豱辨辩辦辧辥諴謏諠謊諶謀諜諫謔謁謂諤諢諼諭諡諷諦諳諺諮謎諞諱諝諧諰諟謉諨諽諻諵諬諿諪謃諹諲諥諯郺醐醚醛醍醎醒醑醖醜醕醔醝醗醙醓貒貐貑趥趧趦蹅踸踹踳蹉踶蹀踱踽蹁蹂蹄踵踴踾踰踲踼蹆踿錾鋻錖錅錃錱鋹錞錤鎯錡錔錣鍺錯鍩錨錆錛錸鋼鍀錁錫錮鍋錕錘鍃錐錦鍁錟錠錇錈鍆鍵鋸錳録錌錍錋錶鋿錩鋽錭鍅錀錷錎錧錿錢錬錽錹錑鍄錂錄錴錉錼錗鋷錜錰鋾錪鍂鋺錻錏鍈鎁錥鍣錙錝錊隷閾閹闍閶閿閻閽閼闁闂閸閵閷閺靛靜餐餤餩餦餠餞餜餛餚餧餡館餢餴餣餟鲳鲷鲱鲴鲸鲲鲮鲵鲯鲭鲺鲻鲰鲹鲶霏霍霖霓霎霙霑霐霗霋霕霒霌霔雕雔颵颴鞔鞘鞓鞕鞙鞖骾骽魉魈韰靦韒馞馠馟頮頹頼頭頤頰頸頻頷頴頳頶頯頱頺頽頥頵韸髻髹髭髵髶髸髺髷鬇鬨鬳駬駪駡駰駱駭駢駮駳駧駫駩駥駣駦駨駤駲駯黉黇黈鹷麇麅麈麆麬麭麮鴛鴣鴨鴞鴦鴒鴟鴝鴕鴥鴪鴱鴢鴓鵖鴘鴏鴠鴐鴚鴩鴡鴗鴖鴑鴫鴬鴧鴊鴙鴤鮅鮄鮈魾鮀鮇鮣鮁鮃鮎鮋鮓鮒鮊鮑鮌鮍鮐鮘鮉鮗魺鮕魽魿鮂魼鮖魻鮏黕默黔黗黖黿黺鼽鼼齓龍颟衡颞颠颡羲羱",//16
                "凟劕兤匵隳鄾鄽鄿鄻鄼勶勴儡儧優償儲儤儦儥儬儠儢儩儰儨藊藏藂薾藁藉藐薿薸藑薷薹藓薰藍薻薺薴藎薼薵藋藡薱藅藃藱藆藈薶藌薲藄藒藗藬藀徽徾邈邃邇邉彍彌幫幬幭嚓嚎嚅嚏嚮噽嚇嚐嚀嚌嚋嚁嚉嚂嚝嚍嚒嚊嚑嚈噾噿骤寱寲嬷嬲嬰嬭嬪嬶嬱嬦嬥嬧嬤嬵嬺嬣嬬嬫嬯嬮獯獮獰獷獱獳嶷嶽嶺嶹嶻巁嶸嶿嶾篸屨擦擩擿擤擢擡擣擰擯擠擴擱擬攃擮擟攁擨擫擲濞濲濠濮濡瀁濯濔濤濫濬濕濘濱濶濜澀濰濵瀞濢濧濻濟濪濿濹瀎濝瀡瀇濣濥濦濙濚濴壕壑壐壓壎壙壔壗壏壍壖尶懤懧懦懝懨懛懠懭懢懱懡懗懩懚懥尷孺孻赡赢毚殭殮殬斣旚戴戲燬燥燮燦燭燴燷燛燣燫燯燶燩燰燨熽燲燢燡燱燳斶斵氉氊氋氈檦檗檞櫆檑檩檬檀檄檐檥檉檣檔檢檜櫛檘檚檒檊檴檅檓檕檟橿橚檋檪櫣檁檂檏橾檆檡檈檍檌犠牆斀斁斃斂歟歗歜歛歝曚曙曐曖曒曓曑曕曗曎禬禮禯擘擧擊澩濌甔甓甕璨環璐璩璪璫璵璦璴瓂璯璬璱璛璮璳瓁懋懑懃應懇憵臂臌臁朦臊膻臀臆膺臃膿臉膾膽臅臄臒爵皤皥皢穗穟穉穛穖穚穞穙穕穘穜穏穝镩镫镦镢镧镣镥镤镨镪镡竲竴竳簋盨盩盪瞪瞭瞵瞧瞫瞤瞬瞳瞩瞶瞮瞯瞷瞴瞨瞦瞲瞸癌癍療癉癆癇癘癈癁癋癅癄癎鹪鹫鹩鹬皼磴磾礅磵礁磷磻礃磽礄磯磹磸礀礍磱磿磰磼磶礂礇磳礈矰矯禦羁罽罾罿疃疄窾竂竀竁竃襕襁襚襍襖襌襇襉襏襎襊襆襋襈襓褼襑璗臨螬蟥螺蟊螵螫蟀螳蟋蟓蟏蟑螽蟐蟍蠎蟂螮螲螾蟅蟌蟄蟎螻蟈蠁蟞螹螿蟉螰蟃螷螼蟝螪螱蟁螸聲聴聰聳聯罄罅罆艱虧虨舊耬耫糠糜糟糞糡糝糛繁縻繇繄縶繋繤膥縩繀縯績縹縷縵繃總縱縴縮繆繅繈縬繉縳縲繂縿繌縰繊繍縼褽襄褻褺翳翼翶翵翲艚艜艛艝簇篼簖簧簕簏篾簌篿簻篲簒簍簃簆篻簎簅篵簓簂簄簊簗簐篺簈簁簔簘篶簀購賹賻贅賽賺賶賷賸輿轂轅輾轄輽轋轁轀轃赯豏豁谿豀覯覬覭覫覮觳觲豳豰豲豯辫辪謷謋謇謟謌講譁謨謖謡謝謅謗謐謚謙謩謄謸謓謘謞謍謧謰謈謒謜謆謕謑謠謢醠醢醨醣醟醡醤醘醞貘貔貕貖趨蹈蹎蹐蹇蹓蹍蹑蹒蹊蹋蹕蹌蹏蹥龋龌鍪鍙鍳鍫鍌鎝鍮鍚鍿鍥鍊鍼鍇鍘鍶鍔鍰鍤鍬鍛鎪鍠鎄鍍鎂鎡鎇鍽鎈鍖鍉鎚鍴鍑鍢鎅鍧鍭鍸鍓鍻鍕鍞鍨鍷鍲鎃鎆鍒鍟鍦鎹鍗鍎鍐鍏鍡鎾鍜鍱鎀鍹鍝鍾鍯鎺隸闇闉闌闆闃闅闊闋闈闀闏闎闄餲餬餭餳餷餫餶餵餿餱餽餥餯餰餪餸饂鲾鳊鲿鲽鳄鲼鳆鳇鳉鳈鳃鳀鳂鳁鳅鳋霜霞霡霘霟霛霝霚霠雘雖雚颶颷鞞鞬鞠鞚鞟鞡鞝鞛鞜髀髁魋魍魏魊魎魌韱馘韔韓韕馣馡馢顆顇顀顁顄顈顂顅顉顃顊韺鬁髽髼鬀鬂髾髿鬴騃駹騁騂駿駸騀駴駻駶駺駵駷駼駾駽黊黋麋麉麊麿麰麯鵁鴷鴳鵂鴴鴯鴰鵃鴻鵄鴜鴭鵈鴿鵅鵆鴶鴼鵉鴾鵇鵧鵀鴽鴺鴮鴹鴵鴲鴸鮟鮰鮠鮨鮡鮺鮭鮚鮞鮪鮦鮆鮜鮫鮮鮝鮩鯎鯈鮙鮲鮥鮯鮳鮬鮱鮤鯅鮛鮧鮴鮢黜黛黝點黚鼂鼀鼁黏黻鼢鼤鼣鼾鼿齋齢齔龠\uE821" ,//17
                "彞酂酀冁羀儭儵儮儯叢藨藩藠藟藜藕藤藝藪藷藭藴藵藣藸藳藧藞藰藥藘藦藲藖藫藔藯藛藚藙藢邋邊邌奰廫彝幮嚣嚜嚚嚙嚕嚗嚡嚛嚖嚟嚠嚤嚢嚔嚘嚞嬸嬻嬼獵獶巂嶲巀屩屪攆擷攄擻擺擼攂攅擶擸擽擵擾擹瀑瀌瀍濽瀔瀆瀦濾濺濼瀏瀋瀉瀅瀓瀢瀈瀐瀂瀊瀒瀃瀀壘壝懵懴懪懳懰懮懫髊髄夓夑爇燾殯旛旞戳燹燻爗燿燼燽燺爀爌爁爄爃燸斷檫檵檰檷檯檮櫃檻檸檳檾櫂櫈櫉櫄檺櫊櫎櫅櫭櫔櫚櫗櫁檽櫙櫇檱櫀檶櫒檲檿檹檭檼櫡犡歞曛曜簪簮曠曞曘禱禰禲擥擪毉濷甖璿瓊璸璾璶璼瓀璹瓍瓋璻斔懕懟懣懘懬懖臑臏臍臓臎臗臐歸皦皧皨穡穫穢穠穣穥镮镬镭镰镱镯竵盫簠盬瞽矇瞿瞻瞾矁瞼瞹瞺矆矀矂癜癞癖癔癒癤癛癝癚癏癐癗癑癙癓癕鹱鹮鹭鹲鹰鹯皽礓礌礞礎礉礡礠礑礐礊礆礚礔礕礏礒礖礜礋矱羂羃疅竅竄竆襜襟襢襠襝襘襙襡襛襗璧臩蟪蟠蟛蟮蟵蟽蟡蟩蠄蠇蟟蟱蟚蟖蟘蟢蟫蠆蟯蟲蟬蟣蠅蟦蟜蟭蟼蟨蟧蟔蟗蠂蟴蟳蟙蟤聶聵職罈罇罉虩耮耭糨糧糦糥糣糤繠繛舙繟繨繙繦繐繸繞繚織繕繒繩繭繱繣繢繝繑繘繗繎繖繥繏繧繜繓覆翻翹翺翷翸艟艠艥艞簦簟簡簩簰簞簣簙簤簜簥簝簶簚簢簲簯簱簛簭簨篽賾贁贄贂賿贃贀轇轊轉轆轈轌豐豃豂覲覰覷観覱觴觵釐躿軀軁豵豴辬謦謹謳謼謾謫謬謲謤謵謻謥謴譀謭謯謱謪謶謣譃謮譇謺鄨醪醫醬醦醧醥醩貙貗趩趪蹦蹩躇蹙蹢蹛蹡蹚蹔蹟蹧蹣蹤蹠蹖躀蹞蹘蹗蹜蹝鏊鎏鎣鎜鎥鎞鎟鎓鏵鏌鎘鎭鎛鎖鎧鎗鎿鏈鎩鎸鎳鎢鎦鎌鎋鎵鎔鎊鎬鎰鎻鏎鎉鎽鏠鎠鎑鎶鎒鎤鎫鎎鎷鎍鎙鎨鎕鎲鎮鎼鎴鏅鎐鎱闖闔闐闓闒闕闘闗闑靝饆餮饁饃餺餼餾饈餻餹饀鳌鳏鳑鳍鳎鳐鳒霤霢霧霩霥霣雠雝雙雛雞雜離雟雗颺颸颼颾颹鞭鞮鞥鞨鞯鞫鞦鞧鞣鞤鞢鞪鞰鞩鞳髅髂髃韙韞韚韖韘韗馥馤馧顑顋題顒顎額顔顓顐顝顕顏頾頿韹鬅鬈鬃鬆鬄鬩髜鬶鬵騑騧騏騎騍騐騅騆騉騋騄騈騝騒騇騊験騌麐麎麏麍麌麱麲鵏鵙鵎鵐鵓鵑鵒鵠鵝鵞鵟鵜鵣鵍鵋鵊鵤鵛鵔鵕鵘鵥鵢鵌鵚鵗鮸鯁鯉鯀鯊鯇鯒鮶鯽鯆鮵鯌鯏鯍鮾鮼鯄鯋鮹鯓鯂鮻鮷鯃鯑鯗鮽鮿鯐黠黡黟鼃鼄鼕鼖鼥鼩鼪鼫鼧鼬鼦鼨齀齌齕颢颣羴\uE862",//18
                "厴劖匶酃隴酁酄隵勷勸儱儴儳谶蘅藿蘑蘧藻蘀藶蘆蘋蘓蘇藹蘐蘂藺蘁蘕蘄蘎蘏蘔藾蘉藮藽蘒蘃蘣蘈蘊藼蘍蘟邍廭廬彟幰幱嚯嚬嚭嚥嚦嚴嚫嚪嚧嚰嚩骥寳寴嬾嬹嬿嬽獺獹巅巆巌屫攒攉攌攈攋攊攎攐攑攇攍攚瀚瀣瀛瀨瀝瀕瀟瀘瀯瀠瀩瀫瀤瀖瀳瀬瀮濳瀙瀜瀭瀗瀥缵壢壚壜壞壡壛懷懶懻夒孽孼殰殱旝旟旜爊爆爕爍爂爑爉爎爈爅氌櫕櫜櫞櫝櫫櫧櫟櫓櫥櫖櫠櫘櫤櫵櫐櫑櫋櫏櫦櫢櫌櫲櫍犢犦犣犤犥牘斄歠獸曝曡曟曢攀瓅瓈瓄璷瓃瓇瓉瓆懲懯臕臘臔皩瓣穨穤穩穪穧穬穦镲矎矃矌矋矈矊矉矄矅癣癟癡癢癠礤礪礙礦礘礛礣礟礗礝礢羅羆羄疆疇襣襦襪襤襥襨襧璽蟾蠖蠊蠓蟹蠃蟸蠏蠞蟰蟕蠋蟶蠍蟻蟺蠀蟷蟿蠉蠌蠈聸聼罋罊耯糪糫糭糩糬繴繫臋艶舚繮繯繾繰繪繳繡繵繲繷纄繬繺繹繶覈覇襞翾翽艨艢艣艤艡艧簸簿籁籀籆簹簽簾簫簳簼籈簴簬簵簺籂簷籅贉贋贇贊贈贆贌贎镽轒轕轎轍轔轐轓轑轏辴覵覴覸覶觶觹軃軂軅軄豶豷辭警譊譔謿譆譚譖譙譌識譜譎譪譒譂譈譓譏謽譑譋譕譝譢譛譄譗證譐醭醮醰醯醱貚趫趭趬蹭蹰蹴蹿蹲蹬蹾蹯蹶蹻蹽蹼蹷躉蹺蹵蹳蹱躂蹫蹸蹨蹹蹪蹮靡鏖鐅鏨鏧鐆鏦鐄鏚鐯鏗鏢鏤鏜鏝鏰鏡鏑鏟鏞鏃鏇鏘鏁鏐鏕鏒鏪鏛鏙鏆鐹鏩鏮鏂鏫鏀鏍鏋鏲鏉鏣鏯鏄鏏鏭鏬鐌鏥鐊鏔鏱鏓闚闝闞關闛闙饉饅饄饇鳔鳖鳗鳘鳚鳕鳓鳙鳛霭霨霪霫霦霳霬難雡颿飀颽颻鞴鞲鞶鞾鞵鞱鞹鞸鞷髋髈髆髌髉髇魑魓魐韲韛韡韝韜韠韟馦顜顗顛願類顙顖顚韻韼鬌鬋鬏鬎鬍鬉鬊鬷騞騠騢騣騲騭騟騙騷騤騖騘騛騔騩騜騗騚騡騥騦騪騨騕鹸麖麓麑麒麕麗麔黀麴麳鵩鶄鵾鶂鵬鶆鵡鵲鶓鶇鵶鵪鵰鵮鵯鵷鶉鶊鵽鶏鵳鶁鵴鶋鶌鵼鵹鵦鵱鶜鵸鶀鶈鵭鵿鵨鶐鵵鶑鵺鶃鶍鶧鵻鵫鶅鶎鯖鯪鯕鯫鯝鯤鯧鯡鯰鯢鯨鯔鯴鯦鯵鯙鯳鯛鯟鯱鯚鯯鰎鯠鯬鯥鯩鯭鯘鯜鰙鯣鯲鯞鯺鯮黢黣黼鼗鼭鼮齁齍齘齗齖龎羸颤羹" ,//19
                "匷酆酅儶蘩蘖蘘蘡蘢蘤蘞蘚蘭蘪蘗蘯蘫蘳蘮蘜蘝蘦蘰蘠蘶蘨蘙蘌蘛蘥忁徿忀廰廯廮嚾嚼嚷嚲嚨嚶嚳嚵嚽嚸嚿嚹嚺嚱骦骧寵寶孀孅孃孉孂孄孁孆獾獼獽巉巍巇巈巃巄巏巊攘攖攔攙攕攗攓瀵灌瀽瀼瀹瀧瀰瀺瀻瀿瀱瀸灂瀾灆瀲瀶灀瀷瀴灁壤壟壠壥壣壦懽懺懹孾爓爔爐爘爏爒爋櫶櫱櫽櫨櫪櫸櫬欂櫮櫰櫷櫴櫹櫯櫩櫿犨犧斅斆獻曦曤曥曧曣瀪甗瓒瓑瓌瓎瓐懸臛臜臙臚臖皪皫穮穭穯镴镳競竷盭矍矒矏癥癦皾礧礬礫礨礥礩矲疉疈竈竇襮襫襭襬襩璺蠚蠛蠕蠒蠘蠙蠣蠐蠔蠑蠗聹聻聺罌舋糯糰糲糮纂纀繻纁繽纊繼繿纃耀翿艦艩籍籋籊籎籌籇籄籃籏籉籕贏贍釋轘轖轚轗轙轝豑覻覺覹觷觸軆辮譬譞譟護譴譯譭譫議譡譍譽譮譤譥譧譨譲譱譠譣譩醵醴醲醷醶醸醳趮躄躈躁躅躃躆鐜鐢鐍鏻鏺鐥鐒鐃鐐鐔鐝鏷鐫鐘鐠鐓鐋鐦鐧鐗鐨鐙鏹鐼鏳鏿鐽鐡鐤鐇鐞鏸鏶鐖鐎鐀鐂鐈鐑鐉鏾鏼鐁鐩鐟鐷鐚鐛鐭鐕鐣鐏闠闡闥闟饐饗饒饋饍饊饌饑饓饎饏饙鳜鳞鳝鳟霰霴霮霵霯霱飂飄飃飁鞻鞺髎髏髍魔魒魖馨顣顠顢顟顡響韽韾鬓鬑鬐鬒鬕鬔鬪鬸驀騫驁驊騮騶騸騰騯驆騬騳騱騴騵騿鹹鹺麚麛麙麘黁麵鶗鶘鶒鶡鶚鶻鶖鷀鶿鶤鶩鶥鶕鶝鶣鶙鶨鶞鶫鶦鶛鶪鶔鶟鶠鶢鰆鯻鰊鰌鰇鰕鰏鰂鰃鰓鯷鰛鰐鰒鰍鰉鰁鯿鯶鯾鰈鰔鯸鰗鰀鱀鰠鰰鰘鰖鰄鯹鰚鰋鰑鰅鰦鯼黪黩黧黥黦黨黤鼍鼅鼯鼰齟齚齣齙齠齝齡齛齞龐龏颥衊羺",//20
                "劘劗酈酇儸儺儷儼儹卛蘺蘴蘬蘷蘲蘵忂邎飜廱囁囈囀囂嚻囃囆囄寷孈孇巋巐屬攏攝攜攡攛灏灊灋灃灄灕灇灍灅灈灐灉懾懼夔赣殲爝爚爛爟爖爙櫼櫳櫻櫺權欄欌欃欍欅欁欀櫾犩歡曩曨禳禴瓘瓏瓖瓔瓓斕朇臝朧臟皬龝矐矑癫癧癩癮癨癪礴礳礮礰礭礯襯襰襱蠢蠡蠟蠩蠜蠝蠫蠠蠤罍耰纇纍纆纈續纎纏纐纅纋纉艪籑籖籐籓籔籒贔贑贐贒贓镾轟轜轞轛覼覽觺觼軇辯譸讁譺譵譹譼讂譳譅譶譻醺醻醹趯趰躏躊躋躑躍躎躌鐾鑀鐻鐳鐵鑊鐺鐸鐶鐲鐿鐮鏽鐴鐰鑉鐬鐱鏴鐪鑝鑓鑁闤闢闣闧闦饘饚饛饖鳡鳠鳢鳣霸露霹霿靀霶霻霺霷雤飅飆飇飈飊飉鞽韃鞼鞿髓髐髒魕靧韢馩顥顧顦顤顨鬘鬗鬖鬫鬹鬺驅驃騾驄驂騺騼騹騻騽驉驇鹻麝麜麶鶺鷇鷉鶱鶯鷊鷃鷂鷄鶬鶲鶹鶵鷁鶼鶴鷔鷝鶭鷎鶾鶮鷨鷅鷌鶸鶳鶽鶶鷈鷆鷏鷋鶷鷍鶰鰧鰲鰭鰱鰣鰨鰥鰩鰷鰟鰜鰪鰝鰡鰢鰬鱃鰯鰤鰮鰞鰫鱁黯黮黭黬黫鼙鼚鼛鼱齎齦齜齩齨齧齤齥龑龡颦羼\uE829\uE83C",//21
                "儻亹蘼蘸蘽蘿蘹蘾蘻虀蘱邐邏奱彎廲囊囋囅囉囌囇囎孌孋孊孍玁玀獿玂巎巓巒巖巗巑巕彲攧攦攢攤攞攟攠灑灔灒灘灖灗壧圝戂孿戵爡爞爜爠氍欋欉欇欆欈欎禵瓙瓗懿臞皭瓤穰穱镶镵竸矓矔癭癬鹳鹴礵礱礶礷礲羇疊竊竉襶襴襷襳瓕蠧蠥蠴蠨蠦蠭聽罏罎耲耱糱糴糵纑纒艫籧籝籙籜籟籛籚籡籘籗贗贖贕贘轡轢轠豄覿覾觽觻讆讀讅譾譿讄讉讃躔躐躚躓躒躕躖躗鑒鑋鑍鑌鑄鑑鑔鑛鑃鑅鑇鑧鑎鑖鑈鑏鑐鑂鑆饕饔鳤霾霽霼飋韂韁韄韀髑體韣顫顩顪顭頀鬙鬚鬜鬝髝鬻驐驍驚驕驋驓驔驎驑驒驈驏麞鷩鷟鷙鷗鷖鷓鷚鷐鷘鷬鷑鷜鷞鷵鷒鷕鷛鷠鰶鱇鰼鱈鰹鰾鰳鰻鰵鱅鱉鱂鰺鱑鰴鰿鱄鰽鰸鱋鱌鱜鱆黱黰鼇鼆黐鼜鼘鼴鼲鼳鼵齂齬齪齫龒龢\uE820",//22
                "劙劚儽虃虇虄虅奲彏囐囏囒孏玃巘巔巚攫攥攩攪攨灛灙灚灡灜壨戄戃爢欐欒欏欑欕曬曫曪曮禷禶攣毊灓瓚戀戁臢癯癰襵襺襼蠲蠱蠸蠪蠬蠰蠯蠮蠳聾罐纓纔纖纕覉襲艬籠籣籥籤籢籨籞籦贙轤轣豅觾讔讎讌變讐讇讍讈讏醼趱躜躙躘躠躛鑣鑢鑚鑤鑠鑕鑥鑞鑡鑟鑙鑘鑗鑜鑦饜靆靁韈韅髕髖魘魗魙靨韤馪顯顬顮鬟鬠鬛鬞髞驘驛驗驌驖驜驙麟黂鷭鷰鷯鷦鷲鷼鷳鷸鷥鷱鷮鷢鷶鷤鷻鷡鷴鷧鷣鷪鷷鱚鱝鱏鱖鱓鱔鱒鱗鱘鱍鱕鱎鱦鱙鱪鱊鱛黴黲黳鼈鼷鼹鼶鼸齄齃齏齯齮齰齭齱龔龕龓颧",//23
                "儾虉虆虁虂虈囓囑囍囕孎巙屭攬攭灞灠灝灟壩爤爣欓欔欗曭瓛斖瓥穳穲矗矙矖矕癱癲礸礹羈羉襻襸襹蠹蠺蠵蠷蠶纛艷纗艭籩籪籬贛贚贜觀軈讙讕讓讖讒讋讑釂醾釀醽醿貛躞躤躝躟鑫鑪鑮鑩鑬饝靄靃靂靈靅靇雦雥韆韇韥顰鬡鬢驞驝驟黌鹽鹼麠鸊鷹鷺鷽鸌鸂鸇鷫鸏鸀鸄鸁鷿鸉鸈鷾鸃鸆鸒鸅鱥鱯鱤鱧鱢鱠鱮鱟鱣鱫鱞鱩鱰鱐鱡鼉鼞齆齅齹齶齲齷齵齴齳衢衋" ,//24
                "廳彠囔馕攮灣灢壪爥爦斸欙欛欖欚欝欘犪曯戆戅矡矘襽蠻糶臠臡纘纚纙覊籮籭籫豒觿讛讘讗躥躡躣躢鑶鑱鑰鑲鑭鑵鑯鑳鑨饟饞靉韉髗顱顲鬣鬬麡鸑鸎鸐鸍鸋鱭鱨鱱鱴鱬鱶黵鼊鼟鼝齇齻齸齺龣\uE84F",//25
                "虌虊灤灦灎圞氎欜矚癳蠼虪糷糳籰籯轥讚讝釁釃釅釄趲躧躦躪鑷鑹鑸鑺鑴靊飌顴鬭鬮驥驢驣驠鸔鸓鱲鱵鱳黶龤龥",//26
                "龞飝灨灧犫灥蠽蠾蠿纝纜豓軉讞讜貜躩鑾鑼鑽鑻饠饡靌靍靎靋飍馫顳鬤鬰驩驦驤驧驡鸕鸖鸗鱷鱸黷齈",//27
                "囖爧欞欟戇癴豔躨鑿钁钂钄钀雧驨麢鸘鸛鸚鸙鱹黸鼺齼齽",//28
                "虋纞讟钃靏韊鬱驪麷鸜",//29
                "厵爨癵籱饢驫麣鸞鸝鱺",//30
                "灩",//31
                "灪籲",//3
                "爩麤鱻",//33
                "龖龗",//34
                "齾",//35
                "齉",//36
        };

        for (int i=0;i<chineseArray.length;i++){

            String subString=chineseArray[i];


            for (int j=0;j<subString.length();j++){
                String singleChinese=subString.substring(j,j+1);


                if (chinese.equals(singleChinese)){
                    return  i+1;

                }

            }

        }

        return index;
    }



}
