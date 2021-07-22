package com.example.location.location_updates_background.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat
import java.util.Date
import java.util.UUID

/**
 * Data class for Location related data (only takes what's needed from
 * {@link android.location.Location} class).
 */
@Entity(tableName = "my_location_table")
data class MyLocationEntity(
    @PrimaryKey val id: UUID,
    val latitude: Double,
    val longitude: Double,
    val foreground: Boolean,
    val date: Date = Date()
) {

    override fun toString(): String {
        val appState = if (foreground) {
            "in app"
        } else {
            "in BG"
        }

        return "$latitude, $longitude $appState on " +
                "${DateFormat.getDateTimeInstance().format(date)}.\n"
    }
}
