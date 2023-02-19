package com.example.map_dp

import android.location.Location
import kotlin.math.roundToInt

class Marketlist {
    val unionmarket = listOf("홈플러스 면목점", "이마트 상봉점", "방학동도깨비시장", "하나로클럽 양재점",
        "이마트 성수점", "서울중앙시장", "롯데백화점 잠실점", "청량리종합시장", "홈플러스 월드컵점", "홈플러스 독산점",
        "망원시장", "통인시장", "NC백화점 불광점", "롯데마트 서울역점", "송화시장", "대림시장", "현대백화점 미아점",
        "고척근린시장", "홈플러스 영등포점", "우림시장", "농협 하나로마트 용산점", "대림중앙시장", "신세계백화점", "신영시장",
        "이마트 가양점", "롯데백화점 관악점", "공릉동 도깨비시장", "상계중앙시장", "하나로클럽 미아점", "뉴코아아울렛 강남점",
        "이마트 이수점", "방이시장", "신창시장", "현대시장", "광장시장", "마천중앙시장", "이마트 여의도점", "관악신사시장(신림4동)",
        "금남시장", "수유재래시장", "농협하나로마트 신촌점", "인왕시장", "신원시장(신림1동)", "롯데백화점 노원점", "돈암제일시장",
        "동원시장", "남성시장", "둔촌역전통시장", "마포농수산물시장", "암사종합시장", "롯데백화점 미아점", "롯데백화점 영등포점",
        "남구로시장", "이마트 청계점", "롯데슈퍼", "이마트 목동점", "이마트 창동점", "홈플러스 시흥점", "화곡본동시장", "이마트 미아점",
        "홈플러스 강동점", "영천시장", "목3동시장", "숭인시장", "신세계백화점 강남점", "롯데백화점 강남점", "원당종합시장", "현대백화점 신촌점",
        "용문시장", "롯데백화점 청량리점", "NC백화점 신구로점", "청담삼익시장", "노룬산골목시장", "뚝도시장", "이마트 용산점", "세이브 마트",
        "대조시장", "롯데마트 강변점", "남대문시장", "방배종합시장", "영등포전통시장", "이마트 명일점", "홈플러스 등촌점", "이마트 역삼점",
        "남문시장", "홈플러스 잠실점", "후암시장", "이마트 신도림점", "홈플러스 동대문점", "홈플러스 목동점", "자양골목시장", "이마트 왕십리점",
        "이마트 은평점", "홈플러스 방학점", "장위골목시장", "이마트 자양점", "도곡시장", "홈플러스 중계점", "경동시장", "롯데백화점")

    data class loca(var idx: Int = -1, var lati :Double, var longi :Double, var dist :Float) //시장 위, 경도, 거리 저장할 class

    val market_loc_lati = arrayListOf(loca(idx=0, lati=37.5804974, longi=127.0819554, dist=0.0F), loca(idx=1, lati=37.596478, longi=127.093596, dist=0.0F), loca(idx=2, lati=37.664468299999996, longi=127.03404459999999, dist=0.0F), loca(idx=3, lati=37.4629931, longi=127.043105, dist=0.0F), loca(idx=4, lati=37.539938899999996, longi=127.0531674, dist=0.0F), loca(idx=5, lati=37.5661516, longi=127.01966469999999, dist=0.0F), loca(idx=6, lati=37.5121997, longi=127.0994558, dist=0.0F), loca(idx=7, lati=37.5818118, longi=127.0404075, dist=0.0F), loca(idx=8, lati=37.567758399999995, longi=126.89811470000001, dist=0.0F), loca(idx=9, lati=37.468649299999996, longi=126.8968106, dist=0.0F), loca(idx=10, lati=37.5565449, longi=126.90605759999998, dist=0.0F), loca(idx=11, lati=37.5807168, longi=126.96998219999999, dist=0.0F), loca(idx=12, lati=37.609708399999995, longi=126.92885319999998, dist=0.0F),
        loca(idx=13, lati=37.5558166, longi=126.97039419999999, dist=0.0F), loca(idx=14, lati=37.549370499999995, longi=126.83566839999999, dist=0.0F), loca(idx=15, lati=37.4915685, longi=126.89993049999998, dist=0.0F), loca(idx=16, lati=37.608331299999996, longi=127.0287845, dist=0.0F), loca(idx=17, lati=37.5022222, longi=126.85, dist=0.0F), loca(idx=18, lati=37.518150399999996, longi=126.89589559999999, dist=0.0F), loca(idx=19, lati=37.5967341, longi=127.09825679999999, dist=0.0F), loca(idx=20, lati=37.533122, longi=126.96469400000001, dist=0.0F), loca(idx=21, lati=37.4915685, longi=126.89993049999998, dist=0.0F), loca(idx=22, lati=37.5609008, longi=126.98098890000001, dist=0.0F), loca(idx=23, lati=37.5329774, longi=126.8360087, dist=0.0F), loca(idx=24, lati=37.5578966, longi=126.86229780000001, dist=0.0F), loca(idx=25, lati=37.4905756, longi=126.9249911, dist=0.0F), loca(idx=26, lati=37.6225575, longi=127.07595839999999, dist=0.0F), loca(idx=27, lati=37.6592473, longi=127.07009679999999, dist=0.0F), loca(idx=28, lati=37.6215608, longi=127.02691130000001, dist=0.0F),
        loca(idx=29, lati=37.509425199999995, longi=127.00734460000001, dist=0.0F), loca(idx=30, lati=37.4846083, longi=126.98077209999998, dist=0.0F), loca(idx=31, lati=37.510765299999996, longi=127.1160681, dist=0.0F), loca(idx=32, lati=37.6397214, longi=127.03712829999999, dist=0.0F), loca(idx=33, lati=37.4572968, longi=126.90281329999999, dist=0.0F), loca(idx=34, lati=37.570039799999996, longi=126.99960360000001, dist=0.0F), loca(idx=35, lati=37.4985346, longi=127.1512503, dist=0.0F), loca(idx=36, lati=37.5187455, longi=126.92642470000001, dist=0.0F), loca(idx=37, lati=37.4875827, longi=126.91646240000001, dist=0.0F), loca(idx=38, lati=37.548398899999995, longi=127.0225213, dist=0.0F), loca(idx=39, lati=37.630767999999996, longi=127.023174, dist=0.0F), loca(idx=40, lati=37.5560188, longi=126.9331229, dist=0.0F), loca(idx=41, lati=37.5907707, longi=126.94306940000001, dist=0.0F), loca(idx=42, lati=37.4815721, longi=126.9283657, dist=0.0F), loca(idx=43, lati=37.6552207, longi=127.0612826, dist=0.0F), loca(idx=44, lati=37.591736399999995, longi=127.01594689999999, dist=0.0F),
        loca(idx=45, lati=37.5897984, longi=127.08987409999999, dist=0.0F), loca(idx=46, lati=37.4890208, longi=126.9805799, dist=0.0F), loca(idx=47, lati=37.5279312, longi=127.1350664, dist=0.0F), loca(idx=48, lati=37.5651596, longi=126.89847, dist=0.0F), loca(idx=49, lati=37.550799999999995, longi=127.12895879999999, dist=0.0F), loca(idx=50, lati=37.6145502, longi=127.03050979999999, dist=0.0F), loca(idx=51, lati=37.515887899999996, longi=126.90751909999997, dist=0.0F), loca(idx=52, lati=37.490172199999996, longi=126.88613839999998, dist=0.0F), loca(idx=53, lati=37.5710434, longi=127.02222959999999, dist=0.0F), loca(idx=54, lati=37.490172199999996, longi=126.88613839999998, dist=0.0F), loca(idx=55, lati=37.5257763, longi=126.87032719999999, dist=0.0F), loca(idx=56, lati=37.6516667, longi=127.0469444, dist=0.0F), loca(idx=57, lati=37.451976699999996, longi=126.900714, dist=0.0F), loca(idx=58, lati=37.5428372, longi=126.84401989999999, dist=0.0F), loca(idx=59, lati=37.610890999999995, longi=127.029824, dist=0.0F), loca(idx=60, lati=37.5456582, longi=127.1422439, dist=0.0F),
        loca(idx=61, lati=37.5709535, longi=126.9611967, dist=0.0F), loca(idx=62, lati=37.548285, longi=126.86523109999999, dist=0.0F), loca(idx=63, lati=37.6130238, longi=127.02896419999998, dist=0.0F), loca(idx=64, lati=37.5049693, longi=127.0042386, dist=0.0F), loca(idx=65, lati=37.496941, longi=127.05332000000001, dist=0.0F), loca(idx=66, lati=37.490172199999996, longi=126.88613839999998, dist=0.0F), loca(idx=67, lati=37.5560608, longi=126.93579679999999, dist=0.0F), loca(idx=68, lati=37.535927099999995, longi=126.9602499, dist=0.0F), loca(idx=69, lati=37.580676, longi=127.0476654, dist=0.0F),        loca(idx=70, lati=37.5009121, longi=126.8826056, dist=0.0F), loca(idx=71, lati=37.521988199999996, longi=127.05964490000001, dist=0.0F), loca(idx=72, lati=37.536501099999995, longi=127.06482209999999, dist=0.0F), loca(idx=73, lati=37.5383729, longi=127.0537407, dist=0.0F), loca(idx=74, lati=37.529444399999996, longi=126.96555559999999, dist=0.0F), loca(idx=75, lati=37.474277, longi=126.91764330000001, dist=0.0F), loca(idx=76, lati=37.610486099999996, longi=126.92880720000001, dist=0.0F),
        loca(idx=77, lati=37.5355987, longi=127.09567129999998, dist=0.0F), loca(idx=78, lati=37.559178599999996, longi=126.97766920000001, dist=0.0F), loca(idx=79, lati=37.4819619, longi=126.9836936, dist=0.0F), loca(idx=80, lati=37.5196337, longi=126.90705899999999, dist=0.0F), loca(idx=81, lati=37.5546516, longi=127.15575170000001, dist=0.0F), loca(idx=82, lati=37.5602424, longi=126.84624380000001, dist=0.0F), loca(idx=83, lati=37.4991357, longi=127.0485619, dist=0.0F), loca(idx=84, lati=37.276841999999995, longi=127.01870710000001, dist=0.0F), loca(idx=85, lati=37.5162275, longi=127.10299889999999, dist=0.0F), loca(idx=86, lati=37.5502034, longi=126.97644240000001, dist=0.0F), loca(idx=87, lati=37.5070431, longi=126.89021849999997, dist=0.0F), loca(idx=88, lati=37.5745108, longi=127.03875779999998, dist=0.0F), loca(idx=89, lati=37.5302084, longi=126.8732314, dist=0.0F), loca(idx=90, lati=37.532796, longi=127.07726199999999, dist=0.0F), loca(idx=91, lati=37.562148199999996, longi=127.0379421, dist=0.0F), loca(idx=92, lati=37.600389299999996, longi=126.92025679999999, dist=0.0F),
        loca(idx=93, lati=37.6648183, longi=127.04359939999999, dist=0.0F), loca(idx=94, lati=37.6102808, longi=127.0512945, dist=0.0F), loca(idx=95, lati=37.5376127, longi=127.0726183, dist=0.0F), loca(idx=96, lati=37.4973378, longi=127.05163270000001, dist=0.0F), loca(idx=97, lati=37.639815, longi=127.06864019999999, dist=0.0F), loca(idx=98, lati=37.5797534, longi=127.0390013, dist=0.0F), loca(idx=99, lati=37.536501099999995, longi=127.06482209999999, dist=0.0F))

    var tmp_fifth = arrayListOf<loca>()

    fun marketdist(
        search_lati: Double,
        search_logi: Double
    ): Pair<ArrayList<String>, ArrayList<loca>> {

        val now_loc = Location("")
        now_loc.latitude = search_lati
        now_loc.longitude = search_logi //현위치 위, 경도

        for (i in market_loc_lati.indices){
            val tmp_loc = Location("")
            tmp_loc.latitude = market_loc_lati[i].lati
            tmp_loc.longitude = market_loc_lati[i].longi
            var tmp_dist = now_loc.distanceTo(tmp_loc) / 1000 //km 변환
            tmp_dist = ((tmp_dist * 100).roundToInt()).toFloat() / 100 //소수점 아래 세번째자리에서 반올림
            market_loc_lati[i].dist = tmp_dist
        }

        market_loc_lati.sortBy { it.dist }

        val result_list = ArrayList<String>()

        for (i in 0..4){
            result_list.add(unionmarket[market_loc_lati[i].idx]) //제일 가까운 5개 시장 이름
            tmp_fifth.add(market_loc_lati[i]) //제일 가까운 5개 시장 경, 위도, 거리
        }

        return Pair(result_list, tmp_fifth)
    }
}