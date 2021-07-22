package com.example.location.location_updates_background.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.location.location_updates_background.data.LocationRepository
import java.util.concurrent.Executors

/**
 * Allows Fragment to observer {@link MyLocation} database, follow the state of location updates,
 * and start/stop receiving location updates.
 */
class LocationUpdateViewModel(application: Application) : AndroidViewModel(application) {

    private val locationRepository = LocationRepository.getInstance(
        application.applicationContext,
        Executors.newSingleThreadExecutor()
    )

    val receivingLocationUpdates: LiveData<Boolean> = locationRepository.receivingLocationUpdates

    val locationListLiveData = locationRepository.getLocations()

    fun startLocationUpdates() = locationRepository.startLocationUpdates()

    fun stopLocationUpdates() = locationRepository.stopLocationUpdates()
}
