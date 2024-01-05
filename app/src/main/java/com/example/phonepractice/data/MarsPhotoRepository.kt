package com.example.phonepractice.data

import com.example.phonepractice.model.MarsPhoto
import com.example.phonepractice.network.MarsApiService

interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

class NetworkMarsPhotosRepository(
    private val marsApiService: MarsApiService
): MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> = marsApiService.getPhotos()
}
