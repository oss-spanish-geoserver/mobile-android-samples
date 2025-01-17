package com.carto.advanced.kotlin.components.popupcontent.stylepopupcontent

import android.content.Context
import com.carto.advanced.kotlin.sections.base.views.BaseScrollView
import com.carto.advanced.kotlin.sections.base.views.BaseView
import com.carto.advancedmap.R

/**
 * Created by aareundo on 17/07/2017.
 */
class StylePopupContent(context: Context) : BaseView(context) {

    companion object {
        @JvmStatic val CartoVectorSource = "carto.streets"
        @JvmStatic val CartoRasterSource = "carto.osm"

        @JvmStatic val Bright = "BRIGHT"
        @JvmStatic val Positron = "POSITRON"
        @JvmStatic val DarkMatter = "DARKMATTER"
        @JvmStatic val Voyager = "VOYAGER"

        @JvmStatic val HereSatelliteDaySource = "SATELLITE DAY"
        @JvmStatic val HereNormalDaySource = "NORMAL DAY"
    }

    private val container = BaseScrollView(context)

    private val cartoVector = StylePopupContentSection(context)
    private val cartoRaster = StylePopupContentSection(context)

    fun getItems() : MutableList<StylePopupContentSection> {
        return mutableListOf(cartoVector, cartoRaster)
    }

    init {

        addView(container)

        cartoVector.source = CartoVectorSource
        cartoVector.header.text = "CARTO VECTOR"
        cartoVector.addItem(Voyager, R.drawable.style_image_nutiteq_voyager)
        cartoVector.addItem(Positron, R.drawable.style_image_nutiteq_positron)
        cartoVector.addItem(DarkMatter, R.drawable.style_image_nutiteq_darkmatter)

        container.addView(cartoVector)

        cartoRaster.source = CartoRasterSource
        cartoRaster.header.text = "HERE RASTER"
        cartoRaster.addItem(HereSatelliteDaySource, R.drawable.style_image_here_satellite)
        cartoRaster.addItem(HereNormalDaySource, R.drawable.style_image_here_normal)

        container.addView(cartoRaster)
    }

    override fun layoutSubviews() {

        val padding = (5 * context.resources.displayMetrics.density).toInt()
        val headerPadding = (20 * context.resources.displayMetrics.density).toInt()

        val x = padding
        var y = 0
        val w = frame.width - 2 * padding
        var h = cartoVector.getCalculatedHeight()

        cartoVector.setFrame(x, y, w, h)

        y += h + headerPadding
        h = cartoRaster.getCalculatedHeight() + headerPadding

        cartoRaster.setFrame(x, y, w, h)
    }

    fun highlightDefault() {
        val default = cartoVector.list[0]

        default.highlight()
        previous = default
    }

    var previous: StylePopupContentSectionItem? = null



}