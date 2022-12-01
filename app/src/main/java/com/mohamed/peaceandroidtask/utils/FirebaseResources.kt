package com.mohamed.peaceandroidtask.utils

import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage

object FirebaseResources {
    private val fbStorage = Firebase.storage("gs://peach-assessment.appspot.com")
    fun getImageRef(id: String): StorageReference {
        return fbStorage.reference.child(id)
    }
}