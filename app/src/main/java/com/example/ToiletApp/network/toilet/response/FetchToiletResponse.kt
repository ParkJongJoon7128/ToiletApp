package com.example.ToiletApp.network.toilet.response

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "Publtolt")
data class FetchToiletResponse(

    @Element(name = "row")
    val row: List<ToiletData>,
    @Element(name = "head")
    val head: Head
)

@Xml(name = "head")
data class Head(
    @PropertyElement(name = "list_total_count")
    val listTotalCount: String,
    @PropertyElement(name = "api_version")
    val api_version: String,
    @Element(name = "RESULT")
    val result: Result
)
@Xml(name="RESULT")
data class Result(
    @PropertyElement(name = "CODE")
    val code: String,
    @PropertyElement(name = "MESSAGE")
    val message: String,
)

@Xml(name="row")
data class ToiletData(
    // 화장실 명
    @PropertyElement(name = "PBCTLT_PLC_NM")
    val PBCTLT_PLC_NM: String? = null,

    // 소재지 도로명 주소
    @PropertyElement(name = "REFINE_ROADNM_ADDR")
    val REFINE_ROADNM_ADDR: String? = null,

    // 소재지 지번 주소
    @PropertyElement(name = "REFINE_LOTNO_ADDR")
    val REFINE_LOTNO_ADDR: String? = null,

    // 남녀 공용 화장실 여부
    @PropertyElement(name = "MALE_FEMALE_CMNUSE_TOILET_YN")
    val MALE_FEMALE_CMNUSE_TOILET_YN: String? = null,

    // 남성용 대변기 수
    @PropertyElement(name = "MALE_WTRCLS_CNT")
    val MALE_WTRCLS_CNT: String? = null,

    // 남성용 소변기 수
    @PropertyElement(name = "MALE_UIL_CNT")
    val MALE_UIL_CNT: String? = null,

    // 남성용 장애인용 대변기 수
    @PropertyElement(name = "MALE_DSPSN_WTRCLS_CNT")
    val MALE_DSPSN_WTRCLS_CNT: String? = null,

    // 남성용 장애인용 소변기 수
    @PropertyElement(name = "MALE_DSPSN_UIL_CNT")
    val MALE_DSPSN_UIL_CNT: String? = null,

    // 남성용 어린이용 대변기 수
    @PropertyElement(name = "MALE_KID_WTRCLS_CNT")
    val MALE_KID_WTRCLS_CNT: String? = null,

    // 남성용 어린이용 소변기 수
    @PropertyElement(name = "MALE_KID_UIL_CNT")
    val MALE_KID_UIL_CNT: String? = null,

    // 여성용 대변기 수
    @PropertyElement(name = "FEMALE_WTRCLS_CNT")
    val FEMALE_WTRCLS_CNT: String? = null,

    // 여성용 장애인용 대변기 수
    @PropertyElement(name = "FEMALE_DSPSN_WTRCLS_CNT")
    val FEMALE_DSPSN_WTRCLS_CNT: String? = null,

    // 여성용 어린이용 대변기 수
    @PropertyElement(name = "FEMALE_KID_WTRCLS_CNT")
    val FEMALE_KID_WTRCLS_CNT: String? = null,

    // 관리 기관명
    @PropertyElement(name = "MANAGE_INST_NM")
    val MANAGE_INST_NM: String? = null,

    // 전화 번호
    @PropertyElement(name = "MNGINST_TELNO")
    val MNGINST_TELNO: String? = null,

    // 위도
    @PropertyElement(name = "REFINE_WGS84_LAT")
    val REFINE_WGS84_LAT: String? = null,

    // 경도
    @PropertyElement(name = "REFINE_WGS84_LOGT")
    val REFINE_WGS84_LOGT: String? = null,

    // 화장실 소유 구분
    @PropertyElement(name = "TOILET_POSESN_DIV")
    val TOILET_POSESN_DIV: String? = null,
)


