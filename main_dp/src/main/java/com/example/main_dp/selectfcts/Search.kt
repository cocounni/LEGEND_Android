package com.example.main_dp.selectfcts

import android.content.Context

class Search {
    val searchlist = arrayOf("가래떡", "떡국떡", "떡볶이떡", "바게트", "베이글", "식빵",
        "닭고기", "닭다리", "닭안심", "닭봉", "닭발",
        "홍합", "모시조개", "참소라살", "가리비", "재첩", "굴", "바지락",
        "골뱅이", "맛조개", "조갯살", "피조개", "전복", "맛살조개",
        "소고기", "다진소고기", "소꼬리", "소고기안심", "소고기등심", "양지머리", "선지",
        "새우", "꽃게", "게", "대하", "칵테일새우",
        "계란", "치즈", "요거트", "우유",
        "두부", "순두부", "콩비지", "유부",
        "멸치", "오징어", "북어", "생태", "연어", "삶은 문어살", "갑오징어", "꼴뚜기",
        "쭈꾸미", "도미", "동태", "잔멸치", "갈치", "대구", "전어", "메기", "잉어",
        "송어", "아구", "조기", "낙지", "말린 오징어", "참치", "문어", "꽁치", "고등어",
        "훈제연어", "코다리", "광어", "장어",
        "청어알", "연어알", "명란젓", "전어젓갈", "날치알", "해파리", "미더덕", "명란", "해삼",
        "사과", "자몽", "딸기", "건포도", "레몬", "포도", "체리", "아보카도", "바나나", "오렌지", "라임", "건블루베리",
        "쌀", "찹쌀", "수수", "차조", "전분", "밀가루", "찹쌀가루", "녹말", "들깨가루",
        "녹말가루", "강력분", "잣가루", "튀김가루", "콩", "팥", "흑임자", "완두콩", "땅콩", "깨",
        "다시마", "미역", "김", "파래", "해초", "우묵",
        "곱창", "육회",
        "당면", "냉면", "칼국수", "쫄면", "쌀국수", "우동", "스파게티", "라면", "국수",
        "올리브유", "참기름", "식물성기름", "고추기름", "튀김기름", "엿기름", "식용유", "샐러드오일", "포도씨유", "들기름",
        "돼지고기", "돼지등갈비", "돼지고기안심", "다진돼지고기", "돼지갈비",
        "게맛살", "장식용어묵", "햄", "베이컨", "프랑크소세지", "비엔나소세지", "골뱅이통조림", "꽁치통조림", "참치통조림", "과일통조림",
        "간장", "고추장", "고추가루", "소금", "꿀", "다진마늘", "된장", "마요네즈", "머스타드", "물엿",
        "버터", "설탕", "미원", "쌈장", "쇠고기 다시다", "식초", "올리고당", "청국장", "초고추장", "춘장", "칠리소스",
        "케첩", "후추", "젓국", "레몬즙", "새우젓", "건새우가루", "육수용멸치", "가쓰오브시", "건새우",
        "콩나물", "숙주", "미나리", "파", "도라지", "고사리", "시금치", "표고", "양송이버섯", "느타리버섯", "목이버섯", "새송이버섯",
        "팽이버섯", "애호박", "호박", "당근", "부추", "고추", "마늘", "대추", "감자", "양파", "피망", "파프리카", "오이", "상추",
        "깻잎", "무", "브로콜리", "청경채", "방울토마토", "토마토", "밤", "배추", "김치", "연근", "양상추", "양배추", "고구마", "옥수수"
    )

    fun Searchfun(inputText: String, context: Context){
        when (inputText) {
            searchlist[0] -> {
                Datafun().Garefun(context)
            }
            searchlist[1] -> {
                Datafun().Dduckfun(context)
            }
            searchlist[2] -> {
                Datafun().Dduckbokkifun(context)
            }
            searchlist[3] -> {
                Datafun().Baguettefun(context)
            }
            searchlist[4] -> {
                Datafun().Baeglefun(context)
            }
            searchlist[5] -> {
                Datafun().Shickbbangfun(context)
            }
            searchlist[6] -> {
                Datafun().Chickmeatfun(context)
            }
            searchlist[7] -> {
                Datafun().Chicklegfun(context)
            }
            searchlist[8] -> {
                Datafun().Chickanshimfun(context)
            }
            searchlist[9] -> {
                Datafun().Chickbongfun(context)
            }
            searchlist[10] -> {
                Datafun().Chickfeetfun(context)
            }
            searchlist[11] -> {
                Datafun().Honghapfun(context)
            }
            searchlist[12] -> {
                Datafun().Moshifun(context)
            }
            searchlist[13] -> {
                Datafun().Chamsorafun(context)
            }
            searchlist[14] -> {
                Datafun().Garibifun(context)
            }
            searchlist[15] -> {
                Datafun().Jaechupfun(context)
            }
            searchlist[16] -> {
                Datafun().Gulfun(context)
            }
            searchlist[17] -> {
                Datafun().Bajirakfun(context)
            }
            searchlist[18] -> {
                Datafun().Golbangfun(context)
            }
            searchlist[19] -> {
                Datafun().Matclamfun(context)
            }
            searchlist[20] -> {
                Datafun().Clamsalfun(context)
            }
            searchlist[21] -> {
                Datafun().Piclamfun(context)
            }
            searchlist[22] -> {
                Datafun().Junbokfun(context)
            }
            searchlist[23] -> {
                Datafun().Matsalclamfun(context)
            }
            searchlist[24] -> {
                Datafun().Cowmeatfun(context)
            }
            searchlist[25] -> {
                Datafun().Cowcutfun(context)
            }
            searchlist[26] -> {
                Datafun().Cowtailfun(context)
            }
            searchlist[27] -> {
                Datafun().Cowanshimfun(context)
            }
            searchlist[28] -> {
                Datafun().Cowdungshimfun(context)
            }
            searchlist[29] -> {
                Datafun().Cowheadfun(context)
            }
            searchlist[30] -> {
                Datafun().Cowbloodfun(context)
            }
            searchlist[31] -> {
                Datafun().Shirimpfun(context)
            }
            searchlist[32] -> {
                Datafun().Flowercrapfun(context)
            }
            searchlist[33] -> {
                Datafun().Crapfun(context)
            }
            searchlist[34] -> {
                Datafun().Daehafun(context)
            }
            searchlist[35] -> {
                Datafun().Cocktailshirimpfun(context)
            }
            searchlist[36] -> {
                Datafun().Eggfun(context)
            }
            searchlist[37] -> {
                Datafun().Cheesefun(context)
            }
            searchlist[38] -> {
                Datafun().Yogartfun(context)
            }
            searchlist[39] -> {
                Datafun().Milkfun(context)
            }
            searchlist[40] -> {
                Datafun().Dubufun(context)
            }
            searchlist[41] -> {
                Datafun().Sundubufun(context)
            }
            searchlist[42] -> {
                Datafun().Kongbijifun(context)
            }
            searchlist[43] -> {
                Datafun().Yubufun(context)
            }
            searchlist[44] -> {
                Datafun().Mylchifun(context)
            }
            searchlist[45] -> {
                Datafun().Squidfun(context)
            }
            searchlist[46] -> {
                Datafun().Bukuhfun(context)
            }
            searchlist[47] -> {
                Datafun().Sangtaefun(context)
            }
            searchlist[48] -> {
                Datafun().Salmonfun(context)
            }
            searchlist[49] -> {
                Datafun().Boiledoctofun(context)
            }
            searchlist[50] -> {
                Datafun().Gapsquidfun(context)
            }
            searchlist[51] -> {
                Datafun().Ggolddugifun(context)
            }
            searchlist[52] -> {
                Datafun().Jjukumifun(context)
            }
            searchlist[53] -> {
                Datafun().Domifun(context)
            }
            searchlist[54] -> {
                Datafun().Janmylchifun(context)
            }
            searchlist[55] -> {
                Datafun().Galchifun(context)
            }
            searchlist[56] -> {
                Datafun().Daegufun(context)
            }
            searchlist[57] -> {
                Datafun().Dongtaefun(context)
            }
            searchlist[58] -> {
                Datafun().Junuhfun(context)
            }
            searchlist[59] -> {
                Datafun().Maegifun(context)
            }
            searchlist[60] -> {
                Datafun().Inguhfun(context)
            }
            searchlist[61] -> {
                Datafun().Songuhfun(context)
            }
            searchlist[62] -> {
                Datafun().Agufun(context)
            }
            searchlist[63] -> {
                Datafun().Jogifun(context)
            }
            searchlist[64] -> {
                Datafun().Nakjifun(context)
            }
            searchlist[65] -> {
                Datafun().Driedsquidfun(context)
            }
            searchlist[66] -> {
                Datafun().Chamchifun(context)
            }
            searchlist[67] -> {
                Datafun().Octopusfun(context)
            }
            searchlist[68] -> {
                Datafun().Ggongchifun(context)
            }
            searchlist[69] -> {
                Datafun().Godungfun(context)
            }
            searchlist[70] -> {
                Datafun().Hunjaesalmonfun(context)
            }
            searchlist[71] -> {
                Datafun().Codarifun(context)
            }
            searchlist[72] -> {
                Datafun().Gwanguhfun(context)
            }
            searchlist[73] -> {
                Datafun().Janguhfun(context)
            }
            searchlist[74] -> {
                Datafun().Chunguhalfun(context)
            }
            searchlist[75] -> {
                Datafun().Salmonalfun(context)
            }
            searchlist[76] -> {
                Datafun().Myungranjutfun(context)
            }
            searchlist[77] -> {
                Datafun().Junuhjutgalfun(context)
            }
            searchlist[78] -> {
                Datafun().Nalchialfun(context)
            }
            searchlist[79] -> {
                Datafun().Haeparifun(context)
            }
            searchlist[80] -> {
                Datafun().Midudukfun(context)
            }
            searchlist[81] -> {
                Datafun().Myungranfun(context)
            }
            searchlist[82] -> {
                Datafun().Haesamfun(context)
            }
            searchlist[83] -> {
                Datafun().Applefun(context)
            }
            searchlist[84] -> {
                Datafun().Grapefruitfun(context)
            }
            searchlist[85] -> {
                Datafun().Strawberryfun(context)
            }
            searchlist[86] -> {
                Datafun().Driedgrapefun(context)
            }
            searchlist[87] -> {
                Datafun().Lemonfun(context)
            }
            searchlist[88] -> {
                Datafun().Grapefun(context)
            }
            searchlist[89] -> {
                Datafun().Cherryfun(context)
            }
            searchlist[90] -> {
                Datafun().Avocadofun(context)
            }
            searchlist[91] -> {
                Datafun().Bananafun(context)
            }
            searchlist[92] -> {
                Datafun().Orangefun(context)
            }
            searchlist[93] -> {
                Datafun().Limefun(context)
            }
            searchlist[94] -> {
                Datafun().Blueberryfun(context)
            }
            searchlist[95] -> {
                Datafun().Ssalfun(context)
            }
            searchlist[96] -> {
                Datafun().Chapssalfun(context)
            }
            searchlist[97] -> {
                Datafun().Susufun(context)
            }
            searchlist[98] -> {
                Datafun().Chajofun(context)
            }
            searchlist[99] -> {
                Datafun().Junbunfun(context)
            }
            searchlist[100] -> {
                Datafun().Milgarufun(context)
            }
            searchlist[101] -> {
                Datafun().Chapsslagarufun(context)
            }
            searchlist[102] -> {
                Datafun().Nokmalfun(context)
            }
            searchlist[103] -> {
                Datafun().Delggaegarufun(context)
            }
            searchlist[104] -> {
                Datafun().Nokmalgarufun(context)
            }
            searchlist[105] -> {
                Datafun().Gangryuckfun(context)
            }
            searchlist[106] -> {
                Datafun().Jatgarufun(context)
            }
            searchlist[107] -> {
                Datafun().Frygarufun(context)
            }
            searchlist[108] -> {
                Datafun().Kongfun(context)
            }
            searchlist[109] -> {
                Datafun().Patfun(context)
            }
            searchlist[110] -> {
                Datafun().Hukimjafun(context)
            }
            searchlist[111] -> {
                Datafun().Wandufun(context)
            }
            searchlist[112] -> {
                Datafun().Peanutfun(context)
            }
            searchlist[113] -> {
                Datafun().Ggaefun(context)
            }
            searchlist[114] -> {
                Datafun().Dashimafun(context)
            }
            searchlist[115] -> {
                Datafun().Seaweedfun(context)
            }
            searchlist[116] -> {
                Datafun().Gimfun(context)
            }
            searchlist[117] -> {
                Datafun().Paraefun(context)
            }
            searchlist[118] -> {
                Datafun().Haechofun(context)
            }
            searchlist[119] -> {
                Datafun().womukfun(context)
            }
            searchlist[120] -> {
                Datafun().Gopchangfun(context)
            }
            searchlist[121] -> {
                Datafun().Rawmeatfun(context)
            }
            searchlist[122] -> {
                Datafun().Dangfun(context)
            }
            searchlist[123] -> {
                Datafun().Naengfun(context)
            }
            searchlist[124] -> {
                Datafun().Kalfun(context)
            }
            searchlist[125] -> {
                Datafun().Jjolfun(context)
            }
            searchlist[126] -> {
                Datafun().Ssalguksufun(context)
            }
            searchlist[127] -> {
                Datafun().Udongfun(context)
            }
            searchlist[128] -> {
                Datafun().Spafun(context)
            }
            searchlist[129] -> {
                Datafun().Ramenfun(context)
            }
            searchlist[130] -> {
                Datafun().Guksufun(context)
            }
            searchlist[131] -> {
                Datafun().Oliveoilfun(context)
            }
            searchlist[132] -> {
                Datafun().Chamoilfun(context)
            }
            searchlist[133] -> {
                Datafun().Vegeoilfun(context)
            }
            searchlist[134] -> {
                Datafun().Gochuoilfun(context)
            }
            searchlist[135] -> {
                Datafun().Fryoilfun(context)
            }
            searchlist[136] -> {
                Datafun().Yutoilfun(context)
            }
            searchlist[137] -> {
                Datafun().Sikoilfun(context)
            }
            searchlist[138] -> {
                Datafun().Saladoilfun(context)
            }
            searchlist[139] -> {
                Datafun().Podossioilfun(context)
            }
            searchlist[140] -> {
                Datafun().Duloilfun(context)
            }
            searchlist[141] -> {
                Datafun().Pigmeatfun(context)
            }
            searchlist[142] -> {
                Datafun().Pigbackfun(context)
            }
            searchlist[143] -> {
                Datafun().Piganshimfun(context)
            }
            searchlist[144] -> {
                Datafun().Pigcutfun(context)
            }
            searchlist[145] -> {
                Datafun().Piggalbifun(context)
            }
            searchlist[146] -> {
                Datafun().Crapmatsalfun(context)
            }
            searchlist[147] -> {
                Datafun().Umukfun(context)
            }
            searchlist[148] -> {
                Datafun().Hamfun(context)
            }
            searchlist[149] -> {
                Datafun().Baconfun(context)
            }
            searchlist[150] -> {
                Datafun().Franksausagefun(context)
            }
            searchlist[151] -> {
                Datafun().Viennasausagefun(context)
            }
            searchlist[152] -> {
                Datafun().Golbangcanfun(context)
            }
            searchlist[153] -> {
                Datafun().Ggongchicanfun(context)
            }
            searchlist[154] -> {
                Datafun().Chamchicanfun(context)
            }
            searchlist[155] -> {
                Datafun().Fruitcanfun(context)
            }
            searchlist[156] -> {
                Datafun().Soysaucefun(context)
            }
            searchlist[157] -> {
                Datafun().Gochujangfun(context)
            }
            searchlist[158] -> {
                Datafun().Gochugarufun(context)
            }
            searchlist[159] -> {
                Datafun().Saltfun(context)
            }
            searchlist[160] -> {
                Datafun().Honeyfun(context)
            }
            searchlist[161] -> {
                Datafun().Dajingarlicfun(context)
            }
            searchlist[162] -> {
                Datafun().Doanjangfun(context)
            }
            searchlist[163] -> {
                Datafun().Mayonnaisefun(context)
            }
            searchlist[164] -> {
                Datafun().Mustardfun(context)
            }
            searchlist[165] -> {
                Datafun().Mulyotfun(context)
            }
            searchlist[166] -> {
                Datafun().Butterfun(context)
            }
            searchlist[167] -> {
                Datafun().Sugerfun(context)
            }
            searchlist[168] -> {
                Datafun().Miwonfun(context)
            }
            searchlist[169] -> {
                Datafun().Ssamjangfun(context)
            }
            searchlist[170] -> {
                Datafun().Dashidafun(context)
            }
            searchlist[171] -> {
                Datafun().Vinegerfun(context)
            }
            searchlist[172] -> {
                Datafun().Oligodangfun(context)
            }
            searchlist[173] -> {
                Datafun().Chungukjangfun(context)
            }
            searchlist[174] -> {
                Datafun().Chojangfun(context)
            }
            searchlist[175] -> {
                Datafun().Chunjangfun(context)
            }
            searchlist[176] -> {
                Datafun().Chilisaucefun(context)
            }
            searchlist[177] -> {
                Datafun().Ketchupfun(context)
            }
            searchlist[178] -> {
                Datafun().Pepperfun(context)
            }
            searchlist[179] -> {
                Datafun().Jutgukfun(context)
            }
            searchlist[180] -> {
                Datafun().Lemonjuicefun(context)
            }
            searchlist[181] -> {
                Datafun().Shirimpjutfun(context)
            }
            searchlist[182] -> {
                Datafun().Driedshirimpgarufun(context)
            }
            searchlist[183] -> {
                Datafun().Yuksumulchifun(context)
            }
            searchlist[184] -> {
                Datafun().Katsuobushifun(context)
            }
            searchlist[185] -> {
                Datafun().Driedshirimpfun(context)
            }
            searchlist[186] -> {
                Datafun().Kongnamulfun(context)
            }
            searchlist[187] -> {
                Datafun().Sukjufun(context)
            }
            searchlist[188] -> {
                Datafun().Minarifun(context)
            }
            searchlist[189] -> {
                Datafun().Greenonionfun(context)
            }
            searchlist[190] -> {
                Datafun().Dorajifun(context)
            }
            searchlist[191] -> {
                Datafun().Gosarifun(context)
            }
            searchlist[192] -> {
                Datafun().Shigumchifun(context)
            }
            searchlist[193] -> {
                Datafun().Pyogofun(context)
            }
            searchlist[194] -> {
                Datafun().Yangsongfun(context)
            }
            searchlist[195] -> {
                Datafun().Nutarifun(context)
            }
            searchlist[196] -> {
                Datafun().Mokifun(context)
            }
            searchlist[197] -> {
                Datafun().Saesongfun(context)
            }
            searchlist[198] -> {
                Datafun().Pangefun(context)
            }
            searchlist[199] -> {
                Datafun().Aehobakfun(context)
            }
            searchlist[200] -> {
                Datafun().Hobakfun(context)
            }
            searchlist[201] -> {
                Datafun().Carrotfun(context)
            }
            searchlist[202] -> {
                Datafun().Buchufun(context)
            }
            searchlist[203] -> {
                Datafun().Gochufun(context)
            }
            searchlist[204] -> {
                Datafun().Garlicfun(context)
            }
            searchlist[205] -> {
                Datafun().Daechufun(context)
            }
            searchlist[206] -> {
                Datafun().Potatofun(context)
            }
            searchlist[207] -> {
                Datafun().Onionfun(context)
            }
            searchlist[208] -> {
                Datafun().Pimangfun(context)
            }
            searchlist[209] -> {
                Datafun().Papricafun(context)
            }
            searchlist[210] -> {
                Datafun().Cucumberfun(context)
            }
            searchlist[211] -> {
                Datafun().Sangchufun(context)
            }
            searchlist[212] -> {
                Datafun().Ggatipfun(context)
            }
            searchlist[213] -> {
                Datafun().Mufun(context)
            }
            searchlist[214] -> {
                Datafun().Brocolifun(context)
            }
            searchlist[215] -> {
                Datafun().Chunggyungfun(context)
            }
            searchlist[216] -> {
                Datafun().Bangtofun(context)
            }
            searchlist[217] -> {
                Datafun().Tomatofun(context)
            }
            searchlist[218] -> {
                Datafun().Bamfun(context)
            }
            searchlist[219] -> {
                Datafun().Baechufun(context)
            }
            searchlist[220] -> {
                Datafun().Kimchifun(context)
            }
            searchlist[221] -> {
                Datafun().Yungeunfun(context)
            }
            searchlist[222] -> {
                Datafun().Yangsangchufun(context)
            }
            searchlist[223] -> {
                Datafun().Yangbaechufun(context)
            }
            searchlist[224] -> {
                Datafun().Gogumafun(context)
            }
            searchlist[225] -> {
                Datafun().Oksusufun(context)
            }
        }
    }
}