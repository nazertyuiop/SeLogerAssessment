package com.assessment.data

import com.assessment.data.network.AnnouncesApi
import com.assessment.domain.AnnounceRepository
import com.assessment.domain.model.Announce

class AnnounceRepositoryImpl(
    private val announcesApi: AnnouncesApi
) : AnnounceRepository {

    override suspend fun getListAnnounce(): List<Announce> {
        val response = announcesApi.getListAnnounces()
        return response.toListModel()
    }
}

