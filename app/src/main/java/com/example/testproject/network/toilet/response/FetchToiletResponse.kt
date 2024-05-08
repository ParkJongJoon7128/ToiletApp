package com.example.testproject.network.toilet.response

import com.google.gson.annotations.SerializedName

data class FetchToiletResponse(
    @SerializedName("code")
    val code: String? = null,
    val data: ArrayList<ToiletData>
)

data class ToiletData(
    val PBCTLT_PLC_NM: String? = null,
    val REFINE_ROADNM_ADDR: String? = null,
    val REFINE_LOTNO_ADDR: String? = null,
    val MALE_FEMALE_CMNUSE_TOILET_YN: String? = null,
    val MALE_WTRCLS_CNT: String? = null,
    val MALE_UIL_CNT: String? = null,
    val MALE_DSPSN_WTRCLS_CNT: String? = null,
    val MALE_DSPSN_UIL_CNT: String? = null,
    val MALE_KID_WTRCLS_CNT: String? = null,
    val MALE_KID_UIL_CNT: String? = null,
    val FEMALE_WTRCLS_CNT: String? = null,
    val FEMALE_DSPSN_WTRCLS_CNT: String? = null,
    val FEMALE_KID_WTRCLS_CNT: String? = null,
    val MANAGE_INST_NM: String? = null,
    val MNGINST_TELNO: String? = null,
    val REFINE_WGS84_LAT: String? = null,
    val REFINE_WGS84_LOGT: String? = null,
    val TOILET_POSESN_DIV: String? = null,
)