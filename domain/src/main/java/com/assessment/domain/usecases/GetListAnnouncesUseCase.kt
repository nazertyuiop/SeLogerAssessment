package com.assessment.domain.usecases

import com.assessment.domain.AnnounceRepository
import com.assessment.domain.model.Announce
import org.koin.standalone.KoinComponent

class GetListAnnouncesUseCase(private val announceRepository: AnnounceRepository ) : KoinComponent {
    suspend fun exec():List<Announce> = announceRepository.getListAnnounce()
}