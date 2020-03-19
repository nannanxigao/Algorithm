package com.gn.algorithm;

import android.annotation.TargetApi;

import java.util.HashMap;
import java.util.Map;

public class 拼写单词 {

    /*

    给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。

    假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。

    注意：每次拼写时，chars 中的每个字母都只能用一次。

    返回词汇表 words 中你掌握的所有单词的 长度之和。



    示例 1：

    输入：words = ["cat","bt","hat","tree"], chars = "atach"
    输出：6
    解释：
    可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
    示例 2：

    输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
    输出：10
    解释：
    可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。


    提示：

    1 <= words.length <= 1000
    1 <= words[i].length, chars.length <= 100
    所有字符串中都仅包含小写英文字母
     */

    public static void main(String[] args) {
        String[] words = {"jdimdfzbygjgdrsisgblztowvwzewvrwuizaihnctoonlykrbzncqvbzjahxvyswdzcbwaqliiyzbddtsxrwb", "ybdhccgznflezzvifoshbatwedohwwhyajylprerarbsjcll", "febacfxkrwnkyoyhykzbfuueohtkvqjkrmclmiinmpwhumaummpxjqmvqnvlwkmiizewfnqnmjqmnxacrhgxodyglvzyyii", "tcymwrytgfnbggzqptaqwzpkjhleisuwsfzhna", "rdvuvrrqerihadnurdfkzfiwtodnzcwvrmuwkyjhgkdjtnuwlclnhttidukyhfdzozix", "mjoryzsbvkqlmtmcmsjljloabfaliecpmmiumq", "iwzpczbknmqrankiypxjxthlzsvhchpqv", "dqpgxyspa", "igsvidvyonqyprvkoaphuvqaxcceefckypojgfdiyubagihkztnhindjcdpolt", "iamvwzvdbfonuurfdzcnvohqrpyxgmjvbyiyovvccsilkblgpojmwvhdsewldgzvdlnecfudjjkmgmil", "lbtjpakidwtavvtllcpekgcmqigmrfkvfjyzbxlpxtnklqrfoasnocjnlhzafcjqdjqgmuardsifyrlkvrndat", "tfqdhgvduounzgbdnipofenkqzqrlntcppwkk", "dwtuwpqugxvkjnhxvpxsdxyeurkldhxnpmicxmntiokhcclptbbbamzcrwachvzi", "pdnmdakvxnwdmibwqclesycgomztyowtjskvwiwuaumwubrmkli", "sxabmaciwtbbtwwawfhqisthjqxsxslsptcxqgsrzxiirxmzzmoulqmwzwatkrjqgpelkenulstuxwzjno", "enhtapuuyildahjyryubmjqdhbtfhjzhwppqbzriytu", "momfgjhyxzpsp", "hhdyxizwufxjewqvbforsauqgexpqgrhbmycwcaxbwldljuhclpyfawbhypinsfjepgded", "cgowwwhvlaziuptfsxqygxxnqxbregcwaodyklkkywpdtofrupmeeaeoemmpdwltdzbvebuzfumfdbdqu", "xspywgpzetvfdzeyterumsweldzsdarwshssaxlfgqqlckcyeealjqdfkjdncoivvgkmcvaod", "ubuubimfvxvplgikclwilovjdkns", "luzrzwfwzlunkwlvpjqpwckboxhgufsjlpmklxxtiuvlvaydkdvqumhiospabiemygntpfotocufttzzewkbxf", "mqqktykhjxtebccvpwttybgvkkxndvxfagdnjmbezlmdgw", "opcobbidwttpeisekgmowtgcozeinvfliqbkbrtkvwxdobavjyrknsadjijwybtbayfytxeotfp", "c", "cefqqjft", "ijavryhszfeevxvrcubkvpobxajzfjhnyffkdnucigmisvalwfngwahy", "pzfkcxeehzytxrtbdqqcoaccnqiynsjypfrcablnznvmthga", "tlekyalvnyxsvr", "jsahgkicszfcheyqafvflufycicegxclqpbmvmakjbhtuwhcxerxwspgzsrubfqblbhavlwfhx", "tvzrvrsnjetkoxbliawcvzzakpmhhvnjubczcpgobuqjqffsrdxtxjarzgsuryajuatcyfbroginvjhlauzbrkhssf", "dqbrdlmkhkrdzecilmfuavrphuxbqjo", "pmdpypebaobezmcfazewjbabjqjvrefyravwrvneyfpesbwnbbymuvovjvqgfwmzcsweifbpkuzicpjsj", "wfobqlvkmehlrh", "soormzqclvrrhftinorqqtfprxqufqsadalczqgbdnirkohqvzucsuunzjvbcfrryzztgy", "lfpvzygoenywdaddtsnrtmdhqnrkuyydwbwmzbwxzmoxwxvyttomlqdsekhyoaltxjhdtggwxrueelgh", "sikbegcpidcsnbierikpueovdqaxzis", "bchfnjcxqkfavrpotyghvhdzfsnigpgeuen", "igcpbhexbrhqgvzbjuvgehqrntbdfluouysupmtykobvkxzhumwxtntmbnyditvjmgoqtbiabkzfx", "xlgxysycbrskihoxiolefjhgdluugsuvvlhxlbqxzcqgqoxrmhmrylpfbarrplqgpvep", "oivjponqitutsacujnlmwotbeinwfygnzdzqet", "yktuffealtkznzvccxuzejpruspfldidkheondsmdbgwrabkmwgtbguayqhyiynfjfqgbpxoizlhottxeqbauj", "sxghynxeletecuqbafmqmlmiwlaenuujfipfkeylcyfjxkznpkc", "gxekcfwgn", "zitnbxgfpnzdoaahksuajugypfdlzwzadmksgtuqoevnqjkwoybabozgovuzlazwlopcuofwnqpkcpyupnh", "oydlvwonusmqypnlpwhdakzdoft", "kphotdvwvjypd", "cdcwreimmvstaytgnlwrdzumkilseqrorlsgzmmogjixszokypjalqmexhjesknsnpgjowypsno", "bbfbbepyutonbnmtbmmdrgxnhoifxluendcayelykgoglnrucegkhoczbajaobdggmusdbdllz", "tmelbseagubuvjjvpzkyvbxcyxzoxjvhcqwmesdwi", "twbedagexfuyyghuqxgwxmtbckchmiknghoaswufihzcmcdkyiqphjwpgpqsavoiiejfoqoucmvcahxmshu", "aqnipfzpclcsyuecagdfho", "cfcigrykqaeclkckntqkioexxvzvqfyirgqiwsbamtigxewdgpbhxsrwiofxzakvofqzbznbkfpfqpnns", "uoyzgkluftocnmbdrpyrmaywyyevbfcebzfxqljgigcgfmoeznqpkbmiwmziqlmdealiknlfzdwbadyjunth", "pniwsxvfxlsfhkhijuwcdvzahgzjmxdjpggcmynlfeitrggpgfudhfsswqaxapmkalrmiikrdcqyovqqyiasc", "hjoff", "zchyafrvstjxrpcrjtxrzqtgemtnbioizjvrsbmmwsqfcqtovk", "rqopixeyjdtwekhdilymtmbvpllrbcfkfojwyzgvhlhxvflywzqiiqlnwooudmwjtfikdgecxsbwxnmmyaxkqyxbqsgn", "jrjjoqkpqfjslcklltztyhkmrqmlmvjczidsswyhmyowxuunogxomhxtireakdfheffjaarcmonvxxuhvlnpujenrvjpsdrngsif", "oluqeooumhfdizvbmzzxznccypdfqeibvhhbbknqcvdryuiqzmheivglczcxcneypm", "odiyjnibfvnmojenjmtnawnnsatslheoqliyqtsmrxojxlsqep", "xodhotsxujcannmgvmszwnpvlyxrvfntk", "pal", "pfuaarkhepsjjtljpdhne", "cmravobrplecnohwhfcxbgsmkqkqjmdrpz", "rhwlfbsjnoileeuatpwpzxsqssfxbakasvvhrnfvsnji", "cprpqsoavnarqcyjhuxeeapjwkbrignbhgkufpdbentazdgfrjksrmbvcbwypcrh", "ouxsbfsvuihlhjcsiccibxvxtpwuzhrthhotbinvclelxhujtxqnpzoylzatzgdvawmfjwychqeopcrdjnejdtfkdign", "zhoel", "jwcdwcwlljltoiepktkflngdsqeagqwowkbopjzwbruhzntusrixinwvf", "amn", "zpcniceupkondvpyjbckasmevmoxquumalzrnhpxskxugik", "cvefdfpkcctzpipaodrygoaoesgvihhhthygs", "bkohexejlvylwkrykmmcgcf", "olpytsjqlkdpwi", "qsidlbvlccnjtyrupfxprlwhcynoyxlbrxjojkiqrsawbaumnzkdkzchommc", "ixnpbwnjtpqczoybczviqfbjtuxjdibzgispvxdnjppranzldirjcxut", "zlzvegbitlzahbmkectimwpbaletlxpcotygzvwridoiswxiuawtz", "fhptimdesuoqzjiblcwnhhbaxptzraksykvfpunxfufrwcmvqnwjocoiy", "aiyorgqnkvdopapcjpenkymhnynpkzyntylozbydnpibdrpbvcutpxudrcsizoyk", "nmuyeikwomlcripugwjypkfvbvizvrmndhsacmdocjjdhtnqvuxmgrcfeczuxsa", "geulhswpnmyweuswggltxsguxnnvecovqxvteiuadxgdksmjtitwcpzmbxicwvclkndttsduxb", "tbdazbskpejjkquorhfdafdvlgglefjhqguriqaefpvhcqscfhtvkimqvjzxtaf", "ldnnyerfedgsffdhpbmbwuubrzsjibafxqccryuljvusadrlfxqw", "meylutslakssulbpvfonrfmvugblinwzrfgopxafnwwdcuufjuaimxrbheehjndxbiohskmvjrmpcewvvvrbaqbkfffgbb", "ygjmeswiarqiwkpuzjsfnbabtvgapaoazzkuafcpuuavzmvvhcnwedpgbizznkygooedxjggbdkrgkcyaautpvwwnvlfwikyl", "mjgnewabmklmzwazyhcdoyqowpgrdcnuzwoha", "nljceveqjwgwmylmbgkawzjdvueoglyxdbpdyqpgwgtmixlkxphtltijcm", "maunpmlrxvreydzpzllevzlxpbkeeyrsskuhtklrnmpytaugdnuvgotmptgprsfcrcenxg", "wxqdzhmffyesnlbweaipjgjojsvvfmyyrsxjuqgyseuojmsemhgxalbbdiepwbizkf", "ricbkdxnkujtlgnuzcx", "gttdwdoclpkcejljedytqilnrpgsphfetbxztwihmhhspvyfdtbavl", "srmlsxsnohyy", "lpg", "qpmfbycwecpgnthstqwcdwrfxlykjteonfqvgqfxgyjmnqfh", "guojktcpspmbtsfucyze", "uhkpgnmkewkhymqyfzxbb", "qifzafbdvmjgfmzdotznlbzsllakihgzdpmwliwmmyoyovofyhxupehqjryccvzsejvnfebbyaxtwji", "xifotcwgywruiymsgmkamaaqnawvooilhqflxptbiewtzcufqvlldsxapunlbbzurwlegvspxhkjnivmeuxu", "ewpkblzobahkxvmaorqxotmlszkjlnbbqhgfeoymxntpsilzzmgknzkpgwanlajbagyxdaxvgg", "xuxovygmkcyukmtsfwquiw", "otvowenq", "thfd", "upypegljhttngfmnrwoqunnysvaauywjppaqlqayfcpajnirjgwjmaeyfpkexyfhdztctsctgfyoyi", "pypgyhubkosgpcsiucjvocobhfiayxjydpjakwpduaybk", "zskfzaqcegxmcxjyyraaaskmurewhpdgeccdiqdruevkipfynevvgdwpmevxolczrssveyf", "qazabogdtspviktvigfumcliotxzlfgqdmnwnejdyuiaxdrhjpzpodjmk", "qozbqbokeous", "gwlvoonxjrhvzyqmnlwfykqex", "uaumnvenxonkofoquxkbevxhinefttwiymaeecwzlknmzljzcldmmpekrnfdql", "xzrghwbgmljjbboonroxerqkbuygiouaylhkdauoagnizfndqzabdbycwa", "wrmcoohqyiwguwxntxlaxlrcambhvughnujvqxtvxuiyvvbgdsqukkdrprcxk", "kajvhekqzmmolchwsnhwsotawzndwpoxxcphjxvjhwyqhzffyilcvwin", "osnjdwvjwtqplvovigvmkkuvzvyrnqbfpliyhvtbquiyucvfxzrvupjsaxisiqvdvjuavclfmbeddvype", "aa", "hzvczfzpteogbzckschfxooyybkkyodaoncwlfjrrozjedbniwhmrxbxgvsknpjtntia", "mnsplhfonlxqrfaoiqbroqrtvjdurciceuyazjslbxkznbjsaaiaiumshqmcdjrzkzkxskoiacnlwuumchanvp", "y", "llusbfpxolpcuxqlxsxusxljtvzoaukhebnimpaczhdgtlpdzmmxvqi", "cxxpgjxrfajufcyljmtomctdloifssgmqpdxnvnojtbczsunjirzmpavidwgvcrwioubusmrprda", "elyrktioorsgpmdogctdzoyumidyhkrcxjpsnqcjzqacpzsockdmpbobd", "cwklazpkfcycsdfjmjryxlikfpcjnjvjwckghqzhgcyhrfbfetmbakpnzjuvgmfngqluuxqvgprdmcclrdwkazvjciecidp", "jxgoqngvvdqgfzdtnlppzlpyxissnjpbcfvvdlzztbzspiwfglqbmvvqnpiscxzdmclnervesecqyyuppzeqnfzpddjn", "itprgrhysrwmhhaawatgzcoifzidwsmbubyigwcewvfsxipilgmyjoabnhovsr", "sdvroatgoiowdqxcchbkxuabrrxqrwqwaamebflbubghhdujyvjtrqjhs", "lcizmwl", "zbycvvwywvprknqomewgnukldcvzehmailqnpabcehjrsespzmcchlfiutwqhlcgvwwzgftqnsmmlxdot", "ycfajupfdilekjptftutzfultpjrupvajbtphxuxjacorflgh", "voeqeuorsrbostmivapuxevtmilhzxpeswivyiqkflxgdwpdieptpvplailynqsakhfnoluw", "qhaqtselyauycemuspozlctffeurfclumidaildhczgorkrvydqcraxhstswypcjktjzyijgbmozwfk", "cifmzmjvtuwzrvszvlkrfbxdztjtwttqxvwtrrdflwraygcnncq", "tqwdkiowbbeobixyurrlgzejkvrgpatwdfbkmexu", "qmohzsrkypncpinlhthrrjgalqhemwdliueqrnqbjqk", "jmuafzdxuyawoopckcihbgibuieaipjjuvelngmdwyhkthoeslmatibnxkexgiasuemzbbagijhuekilhguanvsi", "mcfttopijlwyiqjfddidkbrrznxiggspgrzv", "wkmpshoyvpcavisaluywwuxwggyguwyrewlsdxuhomkcipelifkzyremrdqnxriaddpzpqzfvdwyiuhkiyxlekpskkzawv", "qhcgluzepldgtcsyfquniwdy", "sqoxryxxgzqsjclmuvqiqawuidtihogggxjfzkniqjpyjwatpmecziomfgdkis", "istjakvtyzzaelduexpmnthzwgkwnhqtfdblilypkxirpnlnqrsjffthjdtbfwhxueboquotzvccnexwcre", "lrydfbliheallvpxasjfjfzeehxkxrgabcofnwetcjueolpgexetfieksdkeopci", "tptyttbimmijjnbciadfkwspfofbufpjuxcxylcbfdzoiqtsybxehtrryakqyptjkkkcsiqboreoiovoekelnx", "zavzklwqyzokxnunkhjylukjqcsrvlkuxs", "rtqyhcfhucrqadultzlumazicdu", "ohobdcictit", "xfganyznjxztlenimrljgyifwypjvmcxmjpdwfgspiyoyjetbrtrtxktiobhnzts", "fuvsdvoviyyzqzxliebnxpawtmczyiylnzvbyfilmbbgjoseyxbqawi", "kqtwdwcgtbgzmzejvskhevbokzdvomkawvqmsfwdhbnqdxlgy", "eplegvqtvywmbqtndpdcbbylonvowepnneqlywrtnryudbqorjasivuwkszxzfwqdqozrbubjuovkxehkenmlorvavznwoxbbj", "qjlynqakaxhvmbtzaymetjsilvmxfxjnlspufjxffwksiuyztzklwzvocatawrewicebujfgpq", "mghamvubjtiuviceyccpejehmumtaeejraargsbvfxsgbhigjejuvreuvgbjtzbrzmsrsgjhblzqoz", "zzvkiqrtyfssalidbudmgpjadfnvewcjxxeizrrkv", "wrsegnaznxixzhyhdmslgcgslrcmyvclh", "fujynwgcgocsbkzuvvppknspbvnitwbxnaf", "lihsicgcjuablnfflwuwifcrfwiioafxxbbqwgzibnwhoxzhvmhbgjafvcumjgthiqiuacojuycejodzghucnpogjyykzitugkcr", "wibifkhjooviuxbpucnreszrshiyfgcfywfncxiaodriejwrkskkwlgwxmzkrzfz", "pgmogxujiwkgusbriztdkzkoirswmxwmjjeomcbzg", "xzoksdragbjecrmropprjbtglqcsxzxaxfthhlkrcshobyisrlv", "gfgfhiljcgckutrrectpweexqmqntccqekojlbxsnvmkiareesbazlgsmunbagbmurgwzmb", "kldgnhosnhqdfpplqbpujzcpozokvyopbasgvkcevcwsrxjpgaksxybqsofsxzsdeflphvzpzqioflitssplfheepdraeketdj", "lrkykfzbqohzghvriwmwrtgptfdgwoclaehxujswufkmmuebvtozbhrjtpcmrwufrsjupoedgqsubbbvlbtkosrfdthrxbcq", "cuvkc", "qomgdgmepyktyexunnhirbqnarfdf", "rmvppwtfmeteylqons", "vdiqiavnkoxxqazrphttqhlevygfylfiyjkbmk", "nbeawufkicbfhwdohjmhalwxvnexleiarewaklpyrleygvqftnmtwhpxcbiajearbckhydjstlvwfeywdwcu", "fnwwldvonsrbqyfwecjclbodmzrgydejnsbshzbzosptoyugmvizkupntxffjzyijcjvnxhuzez", "imqfboyfcmbzjduerhkitmpopdaroi", "cukchstrkftlgefvyzpsujetytoebujmhwkipdgizdkipjcpvzzchqqrmqylmcszvemjbzgketpkzbrxguanvjbpxok", "bvyuoyqyryyeviocouoxdckpotoaklhalkxppvxwvzaxwh", "hkjlnprhizooehppsjxbsrbaxyuszevcukvoqffczvonstjiinxtwgzngctnkpbrpeohbxemlcjjgdlcvtfdodpqavcxftmnczk", "twzzzushasnqjxzfdtizajegksbhljakizojgausnhkxdfrypiriwmrraqnrhloctrvukkqons", "bizlpbpvdkcbcavxogrkaxmzbsujecqphusdxlhprrfokhbkgeapghdclkfgutfhkckoozolsyequrgnrndybvofuzca", "uhlgrpshm", "fffblhiue", "uxfxwhhhzwubnpkshnetkvmokzsnalh", "xzbqhsjmkkxkpreqdrooiifvkrxquxwlpytwbmespaqdknxcwfhnjesuwdujghoxznrlxelmi", "ljbdlnpjvzbiywyjqmxdxbqiwqkkvqslfklugpzithhviczc", "kqhattassqwlrxhpzaytmazlyfgvbglxgiqnrrghdjoclhhleqqlwdeblsviwkciqehcjypozryajlngeqrloxufpuryncat", "kyptacgghycdhhnhmlndjaqsrtjudnhwixqvuamkaguagzacczyirfqarfuklvjf", "tsuinonhxpreonbxzaztfeffdcymrxngqeuthmzojldodqlhpxpremc", "bvejqokgmvsxfugorsldmalka", "fxlloyqelywmhiwdtxvtttddthfzbajrgeznmxxgmwzvtmnnwjebeylwjspxygveswxtzefrfhlyhyyambt", "wuhqhyxfpsoaoyssbjwjxqzhckfyfsvonlmyphloyoagoxycirdriaramwxsrswbxptxzvdjticaacwnx", "vtgnhypjamsfxyvnzghqrmntherndth", "fmavnsloegrtcibrbifuibqvjvusppgmprqmibm", "prfyttezajzqbcccrhqdevnazibcpznkxouwegpbbapxlrmhkfhoihv", "hoaerkgvqbhssdrujbrtmlvwbnhqx", "ozerhqqdwfwduyxrjmtxrevbdtgmwpbhkxqjsnlssmestosukzlglqdfi", "gthdnp", "nukyujeknoixksgludcsmxbbsrqjbpnbtvuawtbihdo", "xflmwpjo", "eb", "uujqhzyytjv", "jgowebswpjsggcahajdxzlratrocfghnplpkabnzitmhfhwspgshvpamgqpilgortzvzuoexbaxcalxsxlzsdejgjgihulwxoabq", "sytmzzwifklxsrpyldonjbqchisdjfhpmhzjea", "eithdxqoyza", "sqozuxpdhuaqttpwvyilgjtrtttlmeabuxacxhhjmxfpunzdmxeghuukyutlfkk", "njsirzxawbzktvdyrhxzjkqgnipmjffsabonsdmkinjwqhmwngwcravsctcuglkk", "dmbkpmbvcklftvucfzjfagowavptxbezhrnkrvnfhauhfrdnfnxuneznqnjlwxxyhfcxrq", "cwdnifexgdpqqecqwktngwzqtqvbcywdphfxfnzoavileuflvkcnzirqdkpulrvmgjrqjblwfjdqacmwzytcqrxrspmlleolt"};
        String chars = "owqugdlpqrnasodvbemfhuzctbibeboxgdklfyzyucomprzzoxwwxm";

//        String[] words = {"aa","aab","bc"};
//        String chars = "aab";

        System.out.println(countCharacters1(words, chars));

    }

    public static int countCharacters1(String[] words, String chars) {
        int result = 0;
        int[] num = new int[26];
        char[] charArray = chars.toCharArray();

        for(int i = 0; i < charArray.length; i++) {
            num[charArray[i] - 'a']++;
        }

        for (String word : words) {
            boolean isSupport = true;
            int[] table = new int[26];

            for (char wchar: word.toCharArray()) {
                table[wchar - 'a']++;
                if (table[wchar - 'a'] > num[wchar - 'a']) {
                    isSupport = false;
                    break;
                }
            }
            if (isSupport) {
                result += word.length();
            }
        }

        return result;
    }




    @TargetApi(24)
    public static int countCharacters(String[] words, String chars) {

        int result = 0;
        char[] charArray = chars.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> tmpmap = new HashMap<>();

        for (int i = 0; i < charArray.length; i++) {
            int m = map.getOrDefault(charArray[i], 0);
            map.put(charArray[i], m + 1);
        }

        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            boolean contain = true;

            tmpmap.clear();
            for (Map.Entry<Character, Integer> m : map.entrySet()) {
                tmpmap.put(m.getKey(), m.getValue());
            }


            for (int j = 0; j < word.length; j++) {
                if (tmpmap.containsKey(word[j])) {
                    tmpmap.put(word[j], tmpmap.get(word[j]) - 1);
                    if (tmpmap.get(word[j]) == -1) {
                        break;
                    }
                } else {
                    contain = false;
                    break;
                }
            }

            if (!tmpmap.containsValue(-1) && contain) {
                result += word.length;
            }

        }

        return result;
    }
}
