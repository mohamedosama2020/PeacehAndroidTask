package com.mohamed.peaceandroidtask.usecases

import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class GetMediaUseCase @Inject constructor() {
    suspend operator fun invoke(id:String): String {
        val fbStorage = Firebase.storage("gs://peach-assessment.appspot.com")
        return fbStorage.reference.child(id).downloadUrl.await().toString().plus(".png")
    }
}