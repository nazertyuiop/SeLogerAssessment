package com.assessment.seloger.utils

import com.assessment.domain.model.Announce
import kotlin.random.Random


internal fun Random.nextListAnnounces() =
    generateSequence { nextAnnounce() }.take(nextInt(6)).toList()

private fun Random.nextAnnounce() = Announce(
    nextInt(),
    nextInt().toString(),
    nextInt(),
    nextInt(),
    nextInt(8).toString(),
    nextInt(),
    nextInt().toString(),
    nextInt().toString(),
    nextInt()
)
