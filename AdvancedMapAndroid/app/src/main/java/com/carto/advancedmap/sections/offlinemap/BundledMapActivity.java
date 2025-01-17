package com.carto.advancedmap.sections.offlinemap;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import com.carto.advancedmap.MapApplication;
import com.carto.advancedmap.sections.basemap.BaseMapsView;
import com.carto.advancedmap.baseclasses.activities.MapBaseActivity;
import com.carto.core.MapPos;
import com.carto.datasources.MBTilesTileDataSource;
import com.carto.datasources.TileDataSource;
import com.carto.layers.VectorTileLayer;
import com.carto.vectortiles.MBVectorTileDecoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BundledMapActivity extends MapBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // MapBaseActivity creates and configures mapView
        super.onCreate(savedInstanceState);

        contentView.addBaseLayer(BaseMapsView.DEFAULT_STYLE);

        TileDataSource source = createTileDataSource();

        // Get decoder from current layer,
        // so we wouldn't need a style asset to create a decoder from scratch
        VectorTileLayer baseLayer = (VectorTileLayer)contentView.mapView.getLayers().get(0);
        MBVectorTileDecoder decoder = (MBVectorTileDecoder)baseLayer.getTileDecoder();

        // Remove default baselayer
        contentView.mapView.getLayers().clear();

        // Add our new layer
        VectorTileLayer layer = new VectorTileLayer(source, decoder);
        contentView.mapView.getLayers().insert(0, layer);
        // Zoom to the correct location
        MapPos rome = contentView.projection.fromWgs84(new MapPos(12.4807, 41.8962));
        contentView.mapView.setFocusPos(rome, 0);
        contentView.mapView.setZoom(13, 0);
    }

    protected TileDataSource createTileDataSource() {

        // Offline map data source
        String mbTileFile = "rome_carto-streets.mbtiles";

        try {
            String localDir = getExternalFilesDir(null).toString();
            copyAssetToSDCard(getAssets(), mbTileFile, localDir);

            String path = localDir + "/" + mbTileFile;
            Log.i(MapApplication.LOG_TAG,"copy done to " + path);
            MBTilesTileDataSource vectorTileDataSource = new MBTilesTileDataSource(0, 14, path);

            return vectorTileDataSource;

        } catch (IOException e) {
            Log.e(MapApplication.LOG_TAG, "mbTileFile cannot be copied: " + mbTileFile);
            Log.e(MapApplication.LOG_TAG, e.getLocalizedMessage());
        }

    	return null;
    }

    public void copyAssetToSDCard(AssetManager assetManager, String fileName, String toDir) throws IOException {

        InputStream in = assetManager.open(fileName);
        File outFile = new File(toDir, fileName);

        // NB! Remember to check if storage is available and has enough space

        if (outFile.exists()) {
            // File already exists, no need to recreate
            return;
        }

        OutputStream out = new FileOutputStream(outFile);
        copyFile(in, out);
        in.close();
        in = null;
        out.flush();
        out.close();
        out = null;
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {

        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

}
