package com.assessment.data

import com.assessment.data.network.AnnounceItemJson
import com.assessment.data.network.AnnouncesResponse
import com.assessment.domain.model.Announce


fun AnnounceItemJson.toModel(): Announce {
    return Announce(
        nbrBedrooms = bedrooms ?: 0,
        city = city ?: "",
        id = requireNotNull(id),
        area = area ?: 0,
        image = url ?: "",
        price = requireNotNull(price),
        professional = professional ?: "",
        propertyType = propertyType ?: "",
        nbrRooms = rooms ?: 0
    )
}


fun AnnouncesResponse.toListModel(): List<Announce> {
    val result = mutableListOf<Announce>()
    items?.let {
        for (item in items) {
            try {
                result.add(item.toModel())
            } catch (e: Exception) {
                //skip the element
            }
        }
    }
    return result
}