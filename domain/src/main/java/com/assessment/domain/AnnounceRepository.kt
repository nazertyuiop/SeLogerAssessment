package com.assessment.domain

import com.assessment.domain.model.Announce


interface AnnounceRepository {
    suspend fun getListAnnounce(): List<Announce>
}

