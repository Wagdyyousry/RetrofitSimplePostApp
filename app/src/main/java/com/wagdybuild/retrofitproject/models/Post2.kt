package com.wagdybuild.retrofitproject.models

data class Post2(
    var id: Int = 0,
    var url: String = "",
    var content: String = "",
    var image: String = "",
    var thumbnail: String = "",
    var status: String = "",
    var category: String = "",
    var publishedAt: String = "",
    var updatedAt: String = "",
    var userId: Int = 0
)
