package com.mohamed.peaceandroidtask.entities

data class Fields(
    var authorID: AuthorID = AuthorID(),
    var caption: Caption = Caption(),
    var uiComments: Comments = Comments(),
    var createdAt: CreatedAt = CreatedAt(),
    var id: Id = Id(),
    var mediaType: MediaType = MediaType(),
    var storageRef: StorageRef = StorageRef()
)