package com.example.location.location_updates_background.data.db

import androidx.room.TypeConverter
import java.util.Date
import java.util.UUID

/**
 * Converts non-standard objects in the {@link MyLocation} data class into and out of the database.
 */
class MyLocationTypeConverters {

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toDate(millisSinceEpoch: Long?): Date? {
        return millisSinceEpoch?.let {
            Date(it)
        }
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?): String? {
        return uuid?.toString()
    }

    @TypeConverter
    fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }
}
