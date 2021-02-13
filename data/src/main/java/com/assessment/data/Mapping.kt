package com.assessment.data

import com.assessment.data.network.AnnounceItemJson
import com.assessment.data.network.AnnouncesResponseJson
import com.assessment.domain.model.Announce


fun AnnounceItemJson.toModel(): Announce {
    return Announce(
        nbrBedrooms = bedrooms,
        city = city,
        id = id,
        area = area,
        image = url,
        price = price,
        professional = professional,
        propertyType = propertyType,
        nbrRooms = rooms
    )
}


fun AnnouncesResponseJson.toListModel(): List<Announce> {
    return items.map {
        it.toModel()
    }
}