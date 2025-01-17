package com.carto.advanced.kotlin.model

import com.carto.advanced.kotlin.R
import com.carto.advanced.kotlin.sections.buildingfloors.BuildingFloorsActivity
import com.carto.advanced.kotlin.sections.clustering.ClusteringActivity
import com.carto.advanced.kotlin.sections.editing.EditingActivity
import com.carto.advanced.kotlin.sections.geocoding.GeocodingActivity
import com.carto.advanced.kotlin.sections.gpslocation.GPSLocationActivity
import com.carto.advanced.kotlin.sections.groundoverlay.GroundOverlayActivity
import com.carto.advanced.kotlin.sections.offlinerouting.OfflineRoutingActivity
import com.carto.advanced.kotlin.sections.packagedownload.PackageDownloadActivity
import com.carto.advanced.kotlin.sections.reversegeocoding.ReverseGeocodingActivity
import com.carto.advanced.kotlin.sections.routesearch.RouteSearchActivity
import com.carto.advanced.kotlin.sections.styles.StyleChoiceActivity
import com.carto.advanced.kotlin.sections.vectorelement.VectorElementActivity

/**
 * Created by aareundo on 30/06/2017.
 */
class Samples {

    companion object {
        val list: MutableList<Sample> = mutableListOf(
                Sample(R.drawable.icon_sample_styles, "BASEMAP STYLES",
                        "Various samples of different CARTO Base Maps", StyleChoiceActivity::class.java
                ),
                Sample(R.drawable.icon_sample_route_search, "SEARCH API",
                        "Search POIs along a route", RouteSearchActivity::class.java
                ),
                Sample(R.drawable.icon_sample_package_download, "OFFLINE MAP",
                        "Download existing packages for offline use", PackageDownloadActivity::class.java
                ),
                Sample(R.drawable.icon_sample_offline_routing, "OFFLINE ROUTING",
                        "Download existing routing packages for offline use", OfflineRoutingActivity::class.java
                ),
                Sample(R.drawable.icon_sample_vector_objects, "VECTOR ELEMENTS",
                        "Different popups, polygons and a NMLModel", VectorElementActivity::class.java
                ),
                Sample(R.drawable.icon_sample_groundoverlay, "GROUND OVERLAY",
                        "Ground overlay, indoor maps", GroundOverlayActivity::class.java
                ),
                Sample(R.drawable.icon_sample_clustering, "ELEMENT CLUSTERING",
                        "Loads 20000 elements and shows as clusters", ClusteringActivity::class.java
                ),
                Sample(R.drawable.icon_sample_object_editing, "OBJECT EDITING",
                        "Places editable objects on the world map", EditingActivity::class.java
                ),
                Sample(R.drawable.icon_sample_gps_location, "GPS LOCATION",
                        "Locates you and places a marker on the location", GPSLocationActivity::class.java
                ),
                Sample(R.drawable.icon_sample_geocoding, "GEOCODING",
                        "Enter an address to locate it on the map", GeocodingActivity::class.java
                ),
                Sample(R.drawable.icon_sample_reverse_geocoding, "REVERSE GEOCODING",
                        "Click on an area on the map to get information about it", ReverseGeocodingActivity::class.java
                ),
                Sample(R.drawable.icon_sample_building_floors, "BUILDING FLOORS",
                        "Show or hide different floors of a building", BuildingFloorsActivity::class.java
                )

        )
    }
}
