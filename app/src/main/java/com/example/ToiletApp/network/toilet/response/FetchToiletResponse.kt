package com.example.ToiletApp.network.toilet.response

data class FetchToiletResponse(
    val data: ArrayList<ToiletData>
)

data class ToiletData(
    // 화장실 명
    val PBCTLT_PLC_NM: String? = null,

    // 소재지 도로명 주소
    val REFINE_ROADNM_ADDR: String? = null,

    // 소재지 지번 주소
    val REFINE_LOTNO_ADDR: String? = null,

    // 남녀 공용 화장실 여부
    val MALE_FEMALE_CMNUSE_TOILET_YN: String? = null,

    // 남성용 대변기 수
    val MALE_WTRCLS_CNT: String? = null,

    // 남성용 소변기 수
    val MALE_UIL_CNT: String? = null,

    // 남성용 장애인용 대변기 수
    val MALE_DSPSN_WTRCLS_CNT: String? = null,

    // 남성용 장애인용 소변기 수
    val MALE_DSPSN_UIL_CNT: String? = null,

    // 남성용 어린이용 대변기 수
    val MALE_KID_WTRCLS_CNT: String? = null,
    
    // 남성용 어린이용 소변기 수
    val MALE_KID_UIL_CNT: String? = null,
    
    // 여성용 대변기 수
    val FEMALE_WTRCLS_CNT: String? = null,
    
    // 여성용 장애인용 대변기 수
    val FEMALE_DSPSN_WTRCLS_CNT: String? = null,

    // 여성용 어린이용 대변기 수
    val FEMALE_KID_WTRCLS_CNT: String? = null,

    // 관리 기관명
    val MANAGE_INST_NM: String? = null,

    // 전화 번호
    val MNGINST_TELNO: String? = null,

    // 위도
    val REFINE_WGS84_LAT: String? = null,

    // 경도
    val REFINE_WGS84_LOGT: String? = null,

    // 화장실 소유 구분
    val TOILET_POSESN_DIV: String? = null,
)