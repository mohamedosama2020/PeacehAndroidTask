package com.mohamed.peaceandroidtask.entities

data class Comments(
    var arrayValue: ArrayValue = ArrayValue()
)

data class ArrayValue(
    var values: List<Value> = listOf()
)