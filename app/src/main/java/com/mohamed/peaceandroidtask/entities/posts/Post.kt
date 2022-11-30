package com.mohamed.peaceandroidtask.entities.posts

data class Post(
    var createTime: String = "",
    var fields: Fields = Fields(),
    var name: String = "",
    var updateTime: String = ""
)