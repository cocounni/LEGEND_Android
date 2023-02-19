package com.example.map_dp

class DataClass{
    data class market(
        val ListNecessariesPricesService: ListNecessariesPricesService
    )

    data class ListNecessariesPricesService(
        val RESULT: RESULT,
        val list_total_count: Int, //총 데이터건수
        val row: List<Row>
    )

    data class RESULT(
        val CODE: String,
        val MESSAGE: String
    )

    data class Row(
        val ADD_COL: String,
        val A_NAME: String,
        val A_PRICE: String,
        val A_SEQ: Double,
        val A_UNIT: String,
        val M_GU_CODE: String,
        val M_GU_NAME: String,
        val M_NAME: String,
        val M_SEQ: Double,
        val M_TYPE_CODE: String,
        val M_TYPE_NAME: String,
        val P_DATE: String,
        val P_SEQ: Double,
        val P_YEAR_MONTH: String
    )
}