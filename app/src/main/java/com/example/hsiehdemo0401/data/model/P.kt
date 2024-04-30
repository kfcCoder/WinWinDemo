package com.example.hsiehdemo0401.data.model

data class P(
    val at: Long,
    val att: Att,
    val count: List<Int>,
    val desc: String,
    val id: String,
    val is_favorite: Boolean,
    val is_prv: String,
    val p_stk: List<List<Any>>,
    val plc: List<String>,
    val `private`: List<Any>,
    val reply: List<List<Any>>,
    val source: List<Any>
)