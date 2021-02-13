package com.seloger.assessment.domain

import com.seloger.assessment.domain.model.Announce

interface AnnounceRepository {
    suspend fun getListAnnounce(): List<Announce>
}

