package com.example.main_dp.selectfcts

import android.content.Context

class Datafun {
    private var data_overlap = listOf("0")

    fun Garefun(context: Context){
        val data = hashMapOf(
            "photo" to "bread",
            "id" to "Gare",
            "menuname" to "가래떡",
            "display" to "1"
        )
        data_overlap = listOf("흰떡")
        exist_indata().existdata(data, data_overlap, context)
    }

    fun Dduckfun(context: Context){
        val data = hashMapOf(
            "photo" to "bread",
            "id" to "Dduckguk",
            "menuname" to "떡국떡",
            "display" to "1"
        )
        data_overlap = listOf("흰떡")
        exist_indata().existdata(data, data_overlap, context)
    }

    fun Dduckbokkifun(context: Context){
        val data = hashMapOf(
            "photo" to "bread",
            "id" to "Dduckbokki",
            "menuname" to "떡볶이떡",
            "display" to "1"
        )
        data_overlap = listOf("흰떡")
        exist_indata().existdata(data, data_overlap, context)
    }

    fun Baguettefun(context: Context){
        val data = hashMapOf(
            "photo" to "bread",
            "id" to "Baguette",
            "menuname" to "바게트",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }

    fun Baeglefun(context: Context){
        val data = hashMapOf(
            "photo" to "bread",
            "id" to "Baegle",
            "menuname" to "베이글",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }

    fun Shickbbangfun(context: Context){
        val data = hashMapOf(
            "photo" to "bread",
            "id" to "Shickbbang",
            "menuname" to "식빵",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }

    fun Chickmeatfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Chickmeat",
            "menuname" to "닭고기",
            "display" to "1"
        )
        data_overlap = listOf("닭", "닭살", "닭가슴살")
        exist_indata().existdata(data, data_overlap, context)
    }

    fun Chicklegfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Chickleg",
            "menuname" to "닭다리",
            "display" to "1"
        )
        data_overlap = listOf("닭", "닭살")
        exist_indata().existdata(data, data_overlap, context)
    }

    fun Chickanshimfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Chickanshim",
            "menuname" to "닭안심",
            "display" to "1"
        )
        data_overlap = listOf("안심", "닭살")
        exist_indata().existdata(data, data_overlap, context)
    }

    fun Chickbongfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Chickbong",
            "menuname" to "닭봉",
            "display" to "1"
        )
        data_overlap = listOf("닭")
        exist_indata().existdata(data, data_overlap, context)
    }

    fun Chickfeetfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Chickfeet",
            "menuname" to "닭발",
            "display" to "1"
        )
        data_overlap = listOf("닭")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Matsalclamfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Matsalclam",
            "menuname" to "맛살조개",
            "display" to "1"
        )
        data_overlap = listOf("조개살", "조갯살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Junbokfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Junbok",
            "menuname" to "전복",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Piclamfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Piclam",
            "menuname" to "피조개",
            "display" to "1"
        )
        data_overlap = listOf("조개살", "조갯살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Clamsalfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Clamsal",
            "menuname" to "조갯살",
            "display" to "1"
        )
        data_overlap = listOf("조개살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Matclamfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Matclam",
            "menuname" to "맛조개",
            "display" to "1"
        )
        data_overlap = listOf("맛살조개")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Golbangfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Golbang",
            "menuname" to "골뱅이",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Bajirakfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Bajirak",
            "menuname" to "바지락",
            "display" to "1"
        )
        data_overlap = listOf("조개살", "조갯살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Gulfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Gul",
            "menuname" to "굴",
            "display" to "1"
        )
        data_overlap = listOf("생굴")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Jaechupfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Jaechup",
            "menuname" to "재첩",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Garibifun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Garibi",
            "menuname" to "가리비",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Chamsorafun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Chamsora",
            "menuname" to "참소라살",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Moshifun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Moshi",
            "menuname" to "모시조개",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Honghapfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Honghap",
            "menuname" to "홍합",
            "display" to "1"
        )
        data_overlap = listOf("검은껍질홍합")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Cowmeatfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Cowmeat",
            "menuname" to "소고기",
            "display" to "1"
        )
        data_overlap = listOf("쇠고기", "쇠고기(힘줄없는부위)", "쇠고기(안심 또는 등심)")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Cowcutfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Cowcut",
            "menuname" to "다진소고기",
            "display" to "1"
        )
        data_overlap = listOf("다진쇠고기", "다짐육", "다짐육(소고기)", "채썬쇠고기")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Cowtailfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Cowtail",
            "menuname" to "소꼬리",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Cowanshimfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Cowanshim",
            "menuname" to "소고기안심",
            "display" to "1"
        )
        data_overlap = listOf("안심", "쇠고기(안심 또는 등심)")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Cowdungshimfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Cowdungshim",
            "menuname" to "소고기등심",
            "display" to "1"
        )
        data_overlap = listOf("쇠고기(안심 또는 등심)")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Cowheadfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Cowhead",
            "menuname" to "양지머리",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Cowbloodfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Cowblood",
            "menuname" to "선지",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Shirimpfun(context:Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Shirimp",
            "menuname" to "새우",
            "display" to "1"
        )
        data_overlap = listOf("중새우살", "가재새우", "생새우", "새우살", "중새우", "잔새우")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Flowercrapfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Flowercarp",
            "menuname" to "꽃게",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Crapfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Crap",
            "menuname" to "게",
            "display" to "1"
        )
        data_overlap = listOf("게살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Daehafun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Daeha",
            "menuname" to "대하",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Cocktailshirimpfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Cocktailshirimp",
            "menuname" to "칵테일새우",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Eggfun(context: Context){
        val data = hashMapOf(
            "photo" to "milk",
            "id" to "Egg",
            "menuname" to "계란",
            "display" to "1"
        )
        data_overlap = listOf("계란흰자", "계란노른자", "달걀노른자", "달걀", "삶은계란", "계란후라이", "달걀")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Cheesefun(context: Context){
        val data = hashMapOf(
            "photo" to "milk",
            "id" to "Cheese",
            "menuname" to "치즈",
            "display" to "1"
        )
        data_overlap = listOf("슬라이스치즈", "파마산치즈치즈", "모짜렐라치즈", "치즈", "에멘탈 치즈가루", "피자치즈", "파마산치즈", "치즈가루", "크림치즈", "아가용치즈", "아가용 치즈", "슈레드 치즈(모짜렐라치즈)", "파마르산치즈")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Yogartfun(context: Context){
        val data = hashMapOf(
            "photo" to "milk",
            "id" to "Yogart",
            "menuname" to "요거트",
            "display" to "1"
        )
        data_overlap = listOf("플레인요구르트")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Milkfun(context: Context){
        val data = hashMapOf(
            "photo" to "milk",
            "id" to "Milk",
            "menuname" to "우유",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Dubufun(context: Context){
        val data = hashMapOf(
            "id" to "Dubu",
            "photo" to "etc",
            "menuname" to "두부",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Sundubufun(context: Context){
        val data = hashMapOf(
            "id" to "Sundubu",
            "photo" to "etc",
            "menuname" to "순두부",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Kongbijifun(context: Context){
        val data = hashMapOf(
            "id" to "Kongbiji",
            "photo" to "etc",
            "menuname" to "콩비지",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Yubufun(context: Context){
        val data = hashMapOf(
            "id" to "Yubu",
            "photo" to "etc",
            "menuname" to "유부",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Mylchifun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Mylchi",
            "menuname" to "멸치",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Squidfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Squid",
            "menuname" to "오징어",
            "display" to "1"
        )
        data_overlap = listOf("마른오징어", "오징어채")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Bukuhfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Bukuh",
            "menuname" to "북어",
            "display" to "1"
        )
        data_overlap = listOf("통북어", "생선살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Sangtaefun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Sangtae",
            "menuname" to "생태",
            "display" to "1"
        )
        data_overlap = listOf("생선살", "흰살생선", "흰살 생선")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Salmonfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Salmon",
            "menuname" to "연어",
            "display" to "1"
        )
        data_overlap = listOf("생선살", "연어살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Boiledoctofun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Boiledocto",
            "menuname" to "삶은 문어살",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Gapsquidfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Gapsquid",
            "menuname" to "갑오징어",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Ggolddugifun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Ggolddugi",
            "menuname" to "꼴뚜기",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Jjukumifun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Jjukumi",
            "menuname" to "쭈꾸미",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Domifun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Domi",
            "menuname" to "도미",
            "display" to "1"
        )
        data_overlap = listOf("생선살", "흰살생선", "흰살 생선")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Dongtaefun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Dongtae",
            "menuname" to "동태",
            "display" to "1"
        )
        data_overlap = listOf("생선살", "흰살생선", "흰살 생선", "동태살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Janmylchifun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Janmylchi",
            "menuname" to "잔멸치",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Galchifun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Galchi",
            "menuname" to "갈치",
            "display" to "1"
        )
        data_overlap = listOf("생선살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Daegufun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Daegu",
            "menuname" to "대구",
            "display" to "1"
        )
        data_overlap = listOf("대구살", "생선살", "흰살생선", "흰살 생선", "생대구")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Junuhfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Junuh",
            "menuname" to "전어",
            "display" to "1"
        )
        data_overlap = listOf("생선살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Maegifun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Maegi",
            "menuname" to "메기",
            "display" to "1"
        )
        data_overlap = listOf("생선살", "흰살생선", "흰살 생선")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Inguhfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Inguh",
            "menuname" to "잉어",
            "display" to "1"
        )
        data_overlap = listOf("생선살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Songuhfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Songuh",
            "menuname" to "송어",
            "display" to "1"
        )
        data_overlap = listOf("생선살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Agufun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Agu",
            "menuname" to "아구",
            "display" to "1"
        )
        data_overlap = listOf("아귀", "생선살", "흰살생선", "흰살 생선")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Jogifun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Jogi",
            "menuname" to "조기",
            "display" to "1"
        )
        data_overlap = listOf("생선살", "흰살생선", "흰살 생선")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Nakjifun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Nakji",
            "menuname" to "낙지",
            "display" to "1"
        )
        data_overlap = listOf("낙지다리")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Driedsquidfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Driedsquid",
            "menuname" to "말린 오징어",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Chamchifun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Chamchi",
            "menuname" to "참치",
            "display" to "1"
        )
        data_overlap = listOf("생선살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Octopusfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Octopus",
            "menuname" to "문어",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Ggongchifun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Ggongchi",
            "menuname" to "꽁치",
            "display" to "1"
        )
        data_overlap = listOf("생선살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Godungfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Godung",
            "menuname" to "고등어",
            "display" to "1"
        )
        data_overlap = listOf("생선살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Hunjaesalmonfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Hunjaesalmon",
            "menuname" to "훈제연어",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Codarifun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Codari",
            "menuname" to "코다리",
            "display" to "1"
        )
        data_overlap = listOf("생선살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Gwanguhfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Gwanguh",
            "menuname" to "광어",
            "display" to "1"
        )
        data_overlap = listOf("생선살", "흰살생선", "흰살 생선")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Janguhfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Janguh",
            "menuname" to "장어",
            "display" to "1"
        )
        data_overlap = listOf("생선살", "장어대리", "장어뼈")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Chunguhalfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Chunguhal",
            "menuname" to "청어알",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Salmonalfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Salmonal",
            "menuname" to "연어알",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Myungranjutfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Myungranjut",
            "menuname" to "명란젓",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Junuhjutgalfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Junuhjutgal",
            "menuname" to "전어젓갈",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Nalchialfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Nalchial",
            "menuname" to "날치알",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Haeparifun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Haepari",
            "menuname" to "해파리",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Midudukfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Miduduk",
            "menuname" to "미더덕",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Myungranfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Myungran",
            "menuname" to "명란",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Haesamfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Haesam",
            "menuname" to "해삼",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Applefun(context: Context){
        val data = hashMapOf(
            "photo" to "fruit",
            "id" to "Apple",
            "menuname" to "사과",
            "display" to "1"
        )
        data_overlap = listOf("사과즙")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Grapefruitfun(context: Context){
        val data = hashMapOf(
            "photo" to "fruit",
            "id" to "Grapefruit",
            "menuname" to "자몽",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Strawberryfun(context: Context){
        val data = hashMapOf(
            "photo" to "fruit",
            "id" to "Strawberry",
            "menuname" to "딸기",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Driedgrapefun(context: Context){
        val data = hashMapOf(
            "photo" to "fruit",
            "id" to "Driedgrapefruit",
            "menuname" to "건포도",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Lemonfun(context: Context){
        val data = hashMapOf(
            "photo" to "fruit",
            "id" to "Lemon",
            "menuname" to "레몬",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Grapefun(context: Context){
        val data = hashMapOf(
            "photo" to "fruit",
            "id" to "Grape",
            "menuname" to "포도",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Cherryfun(context: Context){
        val data = hashMapOf(
            "photo" to "fruit",
            "id" to "Cherry",
            "menuname" to "체리",
            "display" to "1"
        )
        data_overlap = listOf("체리알")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Avocadofun(context: Context){
        val data = hashMapOf(
            "photo" to "fruit",
            "id" to "Avocado",
            "menuname" to "아보카도",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Bananafun(context: Context){
        val data = hashMapOf(
            "photo" to "fruit",
            "id" to "Banana",
            "menuname" to "바나나",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Orangefun(context: Context){
        val data = hashMapOf(
            "photo" to "fruit",
            "id" to "Orange",
            "menuname" to "오렌지",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Limefun(context: Context){
        val data = hashMapOf(
            "photo" to "fruit",
            "id" to "Lime",
            "menuname" to "라임",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Blueberryfun(context: Context){
        val data = hashMapOf(
            "photo" to "fruit",
            "id" to "Blueberry",
            "menuname" to "건블루베리",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Ssalfun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Ssal",
            "menuname" to "쌀",
            "display" to "1"
        )
        data_overlap = listOf("밥", "쌀뜰물", "찬밥", "불린쌀", "불린 쌀", "진밥", "참쌀")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Chapssalfun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Chapssal",
            "menuname" to "찹쌀",
            "display" to "1"
        )
        data_overlap = listOf("불린 찹쌀", "진밥(멥쌀+찹쌀)", "진밥")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Susufun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Susu",
            "menuname" to "수수",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Chajofun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Chajo",
            "menuname" to "차조",
        )
        data_overlap = listOf("조")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Junbunfun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Junbun",
            "menuname" to "전분",
            "display" to "1"
        )
        data_overlap = listOf("감자전분")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Milgarufun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Milgaru",
            "menuname" to "밀가루",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Chapsslagarufun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Chapssalgaru",
            "menuname" to "찹쌀가루",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Nokmalfun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Nokmal",
            "menuname" to "녹말",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Delggaegarufun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Delggaegaru",
            "menuname" to "들깨가루",
            "display" to "1"
        )
        data_overlap = listOf("들깻가루")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Nokmalgarufun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Nokmalgaru",
            "menuname" to "녹말가루",
            "display" to "1"
        )
        data_overlap = listOf("녹말물")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Gangryuckfun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Gangryuck",
            "menuname" to "강력분",
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Jatgarufun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Jatgaru",
            "menuname" to "잣가루",
            "display" to "1"
        )
        data_overlap = listOf("잣", "식용유/소금/참기름/잣가루")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Frygarufun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Frygaru",
            "menuname" to "튀김가루",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Kongfun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Kong",
            "menuname" to "콩",
            "display" to "1"
        )
        data_overlap = listOf("날콩가루", "흰콩", "풋콩", "껍질콩", "서리태콩", "콩가루")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Patfun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Pat",
            "menuname" to "팥",
            "display" to "1"
        )
        data_overlap = listOf("삶은팥", "팥삶은물")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Hukimjafun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Hukimja",
            "menuname" to "흑임자",
            "display" to "1"
        )
        data_overlap = listOf("볶은 흑임자(검은깨)")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Wandufun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Wandu",
            "menuname" to "완두콩",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Peanutfun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Peanut",
            "menuname" to "땅콩",
            "display" to "1"
        )
        data_overlap = listOf("땅콩가루")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Ggaefun(context: Context){
        val data = hashMapOf(
            "photo" to "rice",
            "id" to "Ggae",
            "menuname" to "깨",
            "display" to "1"
        )
        data_overlap = listOf("참깨", "깨소금", "들깨", "검은깨", "통깨")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Dashimafun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Dashima",
            "menuname" to "다시마",
            "display" to "1"
        )
        data_overlap = listOf("다시물", "다시마국물", "쌈다시마", "다시마 우린 물", "국물용 다시마")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Seaweedfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Seaweed",
            "menuname" to "미역",
            "display" to "1"
        )
        data_overlap = listOf("불린미역")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Gimfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Gim",
            "menuname" to "김",
            "display" to "1"
        )
        data_overlap = listOf("김밥용김", "구운김")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Paraefun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Parae",
            "menuname" to "파래",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Haechofun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Haecho",
            "menuname" to "해초",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun womukfun(context: Context){
        val data = hashMapOf(
            "photo" to "fish",
            "id" to "Umuk",
            "menuname" to "우묵",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Gopchangfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Gopchang",
            "menuname" to "곱창",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Rawmeatfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Rawmeat",
            "menuname" to "육회",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Dangfun(context: Context){
        val data = hashMapOf(
            "photo" to "noodle",
            "id" to "Dang",
            "menuname" to "당면",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Naengfun(context: Context){
        val data = hashMapOf(
            "photo" to "noodle",
            "id" to "Naeng",
            "menuname" to "냉면",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Kalfun(context: Context){
        val data = hashMapOf(
            "photo" to "noodle",
            "id" to "Kal",
            "menuname" to "칼국수",
            "display" to "1"
        )
        data_overlap = listOf("칼국수면")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Jjolfun(context: Context){
        val data = hashMapOf(
            "photo" to "noodle",
            "id" to "Jjol",
            "menuname" to "쫄면",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Ssalguksufun(context: Context){
        val data = hashMapOf(
            "photo" to "noodle",
            "id" to "Ssalguksu",
            "menuname" to "쌀국수",
            "display" to "1"
        )
        data_overlap = listOf("쌀국수면")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Udongfun(context: Context){
        val data = hashMapOf(
            "photo" to "noodle",
            "id" to "Udong",
            "menuname" to "우동",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Spafun(context: Context){
        val data = hashMapOf(
            "photo" to "noodle",
            "id" to "Spa",
            "menuname" to "스파게티",
            "display" to "1"
        )
        data_overlap = listOf("스파게티", "페투치네")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Ramenfun(context: Context){
        val data = hashMapOf(
            "photo" to "noodle",
            "id" to "Ramen",
            "menuname" to "라면",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Guksufun(context: Context){
        val data = hashMapOf(
            "photo" to "noodle",
            "id" to "Guksu",
            "menuname" to "국수",
            "display" to "1"
        )
        data_overlap = listOf("녹차국수", "밀국수", "소면")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Oliveoilfun(context: Context){
        val data = hashMapOf(
            "photo" to "oil",
            "id" to "Oliveoil",
            "menuname" to "올리브유",
            "display" to "1"
        )
        data_overlap = listOf("올리브오일")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Chamoilfun(context: Context){
        val data = hashMapOf(
            "photo" to "oil",
            "id" to "Chamoil",
            "menuname" to "참기름",
            "display" to "1"
        )
        data_overlap = listOf("식용유/소금/참기름/잣가루")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Vegeoilfun(context: Context){
        val data = hashMapOf(
            "photo" to "oil",
            "id" to "Vegeoil",
            "menuname" to "식물성기름",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Gochuoilfun(context: Context){
        val data = hashMapOf(
            "photo" to "oil",
            "id" to "Gochuoil",
            "menuname" to "고추기름",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Fryoilfun(context: Context){
        val data = hashMapOf(
            "photo" to "oil",
            "id" to "Fryoil",
            "menuname" to "튀김기름",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Yutoilfun(context: Context){
        val data = hashMapOf(
            "photo" to "oil",
            "id" to "Yutoil",
            "menuname" to "엿기름",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Sikoilfun(context: Context) {
        val data = hashMapOf(
            "photo" to "oil",
            "id" to "Sikoil",
            "menuname" to "식용유",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Saladoilfun(context: Context){
        val data = hashMapOf(
            "photo" to "oil",
            "id" to "Saladoil",
            "menuname" to "샐러드오일",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Podossioilfun(context: Context){
        val data = hashMapOf(
            "photo" to "oil",
            "id" to "Podossioil",
            "menuname" to "포도씨유",
            "display" to "1"
        )
        data_overlap = listOf("참빛고운포도씨유")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Duloilfun(context: Context){
        val data = hashMapOf(
            "photo" to "oil",
            "id" to "Duloil",
            "menuname" to "들기름",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Pigmeatfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Pigmeat",
            "menuname" to "돼지고기",
            "display" to "1"
        )
        data_overlap = listOf("돼기고기", "돼지 볼살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Pigbackfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Pigback",
            "menuname" to "돼지등갈비",
            "display" to "1"
        )
        data_overlap = listOf("갈비", "돼기고기")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Piganshimfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Piganshim",
            "menuname" to "돼지고기안심",
            "display" to "1"
        )
        data_overlap = listOf("안심", "돼기고기")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Pigcutfun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Pigcut",
            "menuname" to "다진돼지고기",
            "display" to "1"
        )
        data_overlap = listOf("돼기고기", "다짐육", "다짐육(돼지고기)")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Piggalbifun(context: Context){
        val data = hashMapOf(
            "photo" to "meat",
            "id" to "Piggalbi",
            "menuname" to "돼지갈비",
            "display" to "1"
        )
        data_overlap = listOf("갈비", "돼기고기")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Crapmatsalfun(context: Context){
        val data = hashMapOf(
            "photo" to "sausage",
            "id" to "Crapmatsal",
            "menuname" to "게맛살",
            "display" to "1"
        )
        data_overlap = listOf("맛살")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Umukfun(context: Context){
        val data = hashMapOf(
            "photo" to "sausage",
            "id" to "Umuk",
            "menuname" to "장식용어묵",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Hamfun(context: Context){
        val data = hashMapOf(
            "photo" to "sausage",
            "id" to "Ham",
            "menuname" to "햄",
            "display" to "1"
        )
        data_overlap = listOf("슬라이스햄", "네모난햄")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Baconfun(context: Context){
        val data = hashMapOf(
            "photo" to "sausage",
            "id" to "Bacon",
            "menuname" to "베이컨",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Franksausagefun(context: Context){
        val data = hashMapOf(
            "photo" to "sausage",
            "id" to "Franksausage",
            "menuname" to "프랑크소세지",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Viennasausagefun(context: Context){
        val data = hashMapOf(
            "photo" to "sausage",
            "id" to "Viennasiusage",
            "menuname" to "비엔나소세지",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Golbangcanfun(context: Context){
        val data = hashMapOf(
            "photo" to "sausage",
            "id" to "Golbangcan",
            "menuname" to "골뱅이통조림",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Ggongchicanfun(context: Context){
        val data = hashMapOf(
            "photo" to "sausage",
            "id" to "Ggongchican",
            "menuname" to "꽁치통조림",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Chamchicanfun(context: Context){
        val data = hashMapOf(
            "photo" to "sausage",
            "id" to "Chamchican",
            "menuname" to "참치통조림",
            "display" to "1"
        )
        data_overlap = listOf("참치캔")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Fruitcanfun(context: Context){
        val data = hashMapOf(
            "photo" to "sausage",
            "id" to "Fruitcan",
            "menuname" to "과일통조림",
            "display" to "1"
        )
        data_overlap = listOf("후루츠칵테일")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Soysaucefun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Soysauce",
            "menuname" to "간장",
            "display" to "1"
        )
        data_overlap = listOf("진간장 ", "국간장", "햇살담은간장", "양념간장", "[쇠고기양념] 간장", "[불고기양념] 간장", "조림간장", "[절임간장] 진간장", "[비빔양념] 간장", "맛간장")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Gochujangfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Gochujang",
            "menuname" to "고추장",
            "display" to "1"
        )
        data_overlap = listOf("[초고추장] 고추장")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Gochugarufun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Gochugaru",
            "menuname" to "고추가루",
            "display" to "1"
        )
        data_overlap = listOf("고춧가루", "굵은고춧가루", "고운고춧가루", "[양념장] 고춧가루")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Saltfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Salt",
            "menuname" to "소금",
            "display" to "1"
        )
        data_overlap = listOf("[절임용 소금물] 소금", "[국물용 소금물] 소금", "식용유/소금/참기름/잣가루", "맛소금", "굵은소금", "꽃소금", "고운소금", "[배합초] 소금", "소금약간", "굵은소금·후춧가루", "볶은소금", "소급", "'소금, 후추'")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Honeyfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Honey",
            "menuname" to "꿀",
            "display" to "1"
        )
        data_overlap = listOf("조청")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Dajingarlicfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Dajingarlic",
            "menuname" to "다진마늘",
            "display" to "1"
        )
        data_overlap = listOf("풋마늘", "채썬마늘", "간마늘", "저민마늘")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Doanjangfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Daonjang",
            "menuname" to "된장",
            "display" to "1"
        )
        data_overlap = listOf("왜된장", "일본된장", "순창콩된장", "미소된장", "미소", "아기된장소스")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Mayonnaisefun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Mayonnaise",
            "menuname" to "마요네즈",
            "display" to "1"
        )
        data_overlap = listOf("오렌지마요네즈", "마요네스")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Mustardfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Mustard",
            "menuname" to "머스타드",
            "display" to "1"
        )
        data_overlap = listOf("머스터드", "허니머스타드", "머스타드", "허니머스터드")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Mulyotfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Mulyot",
            "menuname" to "물엿",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Butterfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Butter",
            "menuname" to "버터",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Sugerfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Suger",
            "menuname" to "설탕",
            "display" to "1"
        )
        data_overlap = listOf("흰설탕", "흑설탕", "황설탕")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Miwonfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Miwon",
            "menuname" to "미원",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Ssamjangfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Ssamjang",
            "menuname" to "쌈장",
            "display" to "1"
        )
        data_overlap = listOf("청정원순창쌈장")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Dashidafun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Dashida",
            "menuname" to "쇠고기 다시다",
            "display" to "1"
        )
        data_overlap = listOf("청정원맛선생", "쇠고기스톡")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Vinegerfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Vineger",
            "menuname" to "식초",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Oligodangfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Oligodang",
            "menuname" to "올리고당",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Chungukjangfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Chungukjang",
            "menuname" to "청국장",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Chojangfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Chojang",
            "menuname" to "초고추장",
            "display" to "1"
        )
        data_overlap = listOf("[초고추장] 고추장")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Chunjangfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Chunjang",
            "menuname" to "춘장",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Chilisaucefun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Chilisauce",
            "menuname" to "칠리소스",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Ketchupfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Ketchup",
            "menuname" to "케첩",
            "display" to "1"
        )
        data_overlap = listOf("토마토케첩", "토마토케찹")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Pepperfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Pepper",
            "menuname" to "후추",
            "display" to "1"
        )
        data_overlap = listOf("통후추", "후춧가루", "흰후춧가루", "흰후추", "굵은소금·후춧가루")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Jutgukfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Jutguk",
            "menuname" to "젓국",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Lemonjuicefun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Lemonjuice",
            "menuname" to "레몬즙",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Shirimpjutfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Shirimpjut",
            "menuname" to "새우젓",
            "display" to "1"
        )
        data_overlap = listOf("새우젓국")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Driedshirimpgarufun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Driedshirimpgaru",
            "menuname" to "건새우가루",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Yuksumulchifun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Yusumulchi",
            "menuname" to "육수용멸치",
            "display" to "1"
        )
        data_overlap = listOf("멸칫국물", "멸치다시물", "[멸치장국] 국멸치", "국멸치", "국물용멸치")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Katsuobushifun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Katsuobushi",
            "menuname" to "가쓰오브시",
            "display" to "1"
        )
        data_overlap = listOf("가쓰오브시국물", "가쯔오브시")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Driedshirimpfun(context: Context){
        val data = hashMapOf(
            "photo" to "salt",
            "id" to "Driedshirimp",
            "menuname" to "건새우",
            "display" to "1"
        )
        data_overlap = listOf("말린 새우", "잔새우")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Kongnamulfun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Kongnamul",
            "menuname" to "콩나물",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Sukjufun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Sukju",
            "menuname" to "숙주",
            "display" to "1"
        )
        data_overlap = listOf("숙주나물")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Minarifun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Minari",
            "menuname" to "미나리",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Greenonionfun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Greenonion",
            "menuname" to "파",
            "display" to "1"
        )
        data_overlap = listOf("다진파", "실파", "대파", "가는파", "굵은파", "[쇠고기양념] 다진파", "다진식파", "파뿌리", "다진쪽파", "다진대파", "쪽파", "통파", "[양념장] 다진파", "대파 대", "육수용 대파")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Dorajifun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Doraji",
            "menuname" to "도라지",
            "display" to "1"
        )
        data_overlap = listOf("통도라지", "도라지나물")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Gosarifun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Gosari",
            "menuname" to "고사리",
            "display" to "1"
        )
        data_overlap = listOf("고사리나물")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Shigumchifun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Shigumchi",
            "menuname" to "시금치",
            "display" to "1"
        )
        data_overlap = listOf("시금치즙", "시금치나물")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Pyogofun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Pyogo",
            "menuname" to "표고",
            "display" to "1"
        )
        data_overlap = listOf("말린표고버섯", "말린 표고버섯", "표고", "버섯")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Yangsongfun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Yangsong",
            "menuname" to "양송이버섯",
            "display" to "1"
        )
        data_overlap = listOf("송이버섯", "버섯")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Nutarifun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Nutari",
            "menuname" to "느타리버섯",
            "display" to "1"
        )
        data_overlap = listOf("버섯")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Mokifun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Moki",
            "menuname" to "목이버섯",
            "display" to "1"
        )
        data_overlap = listOf("버섯")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Saesongfun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Saesong",
            "menuname" to "새송이버섯",
            "display" to "1"
        )
        data_overlap = listOf("송이버섯", "미니새송이버섯", "버섯")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Pangefun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Pange",
            "menuname" to "팽이버섯",
            "display" to "1"
        )
        data_overlap = listOf("버섯")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Aehobakfun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Aehobak",
            "menuname" to "애호박",
            "display" to "1"
        )
        data_overlap = listOf("애호박(속살)")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Hobakfun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Hobak",
            "menuname" to "호박",
            "display" to "1"
        )
        data_overlap = listOf("청동호박", "호박잎", "둥근호박")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Carrotfun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Carrot",
            "menuname" to "당근",
            "display" to "1"
        )
        data_overlap = listOf("당근즙", "당근잎", "당근채")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Buchufun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Buchu",
            "menuname" to "부추",
            "display" to "1"
        )
        data_overlap = listOf("영양부추")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Gochufun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Gochu",
            "menuname" to "고추",
            "display" to "1"
        )
        data_overlap = listOf("다진고추", "마른고추", "붉은 고추", "다진풋고추", "청양고추", "다진청고추", "다진홍고추",  "삭힌고추", "이태리고추", "칠리", "무지개고추", "풋고추")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Garlicfun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Garlic",
            "menuname" to "마늘",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Daechufun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Daechu",
            "menuname" to "대추",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Potatofun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Potato",
            "menuname" to "감자",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Onionfun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Onion",
            "menuname" to "양파",
            "display" to "1"
        )
        data_overlap = listOf("다진양파", "양파즙")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Pimangfun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Pimang",
            "menuname" to "피망",
            "display" to "1"
        )
        data_overlap = listOf("빨강파프리카·노랑 파프리카·청피망", "녹색피망", "홍피망", "청피망 각각")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Papricafun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Paprica",
            "menuname" to "파프리카",
            "display" to "1"
        )
        data_overlap = listOf("적파프리카", "황파프리카", "노란 파프리카", "붉은 파프리카", "미니파프리카", "빨강파프리카·노랑 파프리카·청피망", "노랑/빨강 파프리카")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Cucumberfun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Cucumber",
            "menuname" to "오이",
            "display" to "1"
        )
        data_overlap = listOf("백오이")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Sangchufun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Sangchu",
            "menuname" to "상추",
            "display" to "1"
        )
        data_overlap = listOf("상추잎", "꽃상추")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Ggatipfun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Ggatip",
            "menuname" to "깻잎",
            "display" to "1"
        )
        data_overlap = listOf("들깻잎")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Mufun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Mu",
            "menuname" to "무",
            "display" to "1"
        )
        data_overlap = listOf("총각무", "무즙", "무채", "래디쉬", "육수용 무")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Brocolifun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Brocoli",
            "menuname" to "브로콜리",
            "display" to "1"
        )
        data_overlap = listOf("브로코리")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Chunggyungfun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Chunggyung",
            "menuname" to "청경채",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Bangtofun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Bangto",
            "menuname" to "방울토마토",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Tomatofun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Tomato",
            "menuname" to "토마토",
            "display" to "1"
        )
        data_overlap = listOf("홀토마토", "토마토소스")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Bamfun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Bam",
            "menuname" to "밤",
            "display" to "1"
        )
        data_overlap = listOf("깐밤", "생밤")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Baechufun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Baechu",
            "menuname" to "배추",
            "display" to "1"
        )
        data_overlap = listOf("배춧잎", "풋배추", "배추잎", "얼갈이배추", "절인 배추")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Kimchifun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Kimchi",
            "menuname" to "김치",
            "display" to "1"
        )
        data_overlap = listOf("배추김치", "김칫잎", "열무김치", "열무", "신김치")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Yungeunfun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Yungeun",
            "menuname" to "연근",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Yangsangchufun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Yangsangchu",
            "menuname" to "양상추",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Yangbaechufun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Yangbaechu",
            "menuname" to "양배추",
            "display" to "1"
        )
        data_overlap = listOf("적양배추잎", "양배추잎", "적양배추")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Gogumafun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Goguma",
            "menuname" to "고구마",
            "display" to "1"
        )
        data_overlap = listOf("0")
        exist_indata().existdata(data, data_overlap, context)
    }
    fun Oksusufun(context: Context){
        val data = hashMapOf(
            "photo" to "cabbage",
            "id" to "Oksusu",
            "menuname" to "옥수수",
            "display" to "1"
        )
        data_overlap = listOf("옥수수통조림", "스위트콘")
        exist_indata().existdata(data, data_overlap, context)
    }
}