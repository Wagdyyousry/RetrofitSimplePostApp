package com.wagdybuild.retrofitproject.models

data class Post(
    var userId: Int = 0,
    var id: Int = 0,
    var title: String = "",
    var body: String = ""
)
