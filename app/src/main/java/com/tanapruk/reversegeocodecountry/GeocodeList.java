package com.tanapruk.reversegeocodecountry;

import android.util.Log;
import com.google.gson.annotations.SerializedName;
import com.tanapruk.reversegeocodecountry.Polygon.Point;
import com.tanapruk.reversegeocodecountry.Polygon.Polygon;
import java.util.List;

/**
 * Created by Tanapruk on 8/7/2015.
 */
public class GeocodeList {


    @SerializedName("geocodelist")
    private List<Geocode> geocodeList;


    private List<Geocode> getGeocodeList() {
        return geocodeList;
    }

    private int getIndexFromCountryName(String countryName) {
        int index = 0;
        for (int i = 0; i < getGeocodeList().size(); i++) {
            if (getGeocodeList().get(i).getName().equals(countryName)) {
                index = i;
                break;
            }
        }

        return index;
    }

    private void setGeocodeList(List<Geocode> geocodeList) {
        this.geocodeList = geocodeList;
    }

    public String getCountryName(double latitude, double longitude) {
        return getGeocode(latitude, longitude).getName();
    }
    public String getCountryId(double latitude, double longitude) {
        return getGeocode(latitude, longitude).getId();
    }

    Geocode getGeocode(double latitude, double longitude) {


        Point currentPoint = new Point((float) latitude, (float) longitude);


        for (int i = 0; i < geocodeList.size(); i++) {

            Geocode geocode = geocodeList.get(i);

            List<PolygonSet> polygonSetList = geocode.getPolygonSetList();

            for (int j = 0; j < polygonSetList.size(); j++) {

                PolygonSet polygonSet = polygonSetList.get(j);

                List<LocationPoint> polygonList = polygonSet.getPolygonList();

                Polygon.Builder polygonBuilder = new Polygon.Builder();
                for (int k = 0; k < polygonList.size(); k++) {
                    LocationPoint locationPoint = polygonList.get(k);
                    polygonBuilder.addVertex(new Point((float) locationPoint.getLatitude(), (float) locationPoint.getLongitude()));
                }

                Polygon polygon = polygonBuilder.build();

                if (polygon.contains(currentPoint)) {
                    return geocode;
                }

            }
        }

        Log.e("Check", "Your latitude and longitude doesn't match anywhere on earth.");

        Geocode geocode = new Geocode();
        geocode.setId("No match found.");
        geocode.setName("No match found");
        return geocode;

    }



    private class Geocode {
        String id;
        String name;
        Geometry geometry;

        private String getId() {
            return id;
        }

        private void setId(String id) {
            this.id = id;
        }

        private String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        private Geometry getGeometry() {
            return geometry;
        }

        private void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }

        private String getType() {
            return geometry.getType();
        }

        private Coordinates getCoordinates() {
            return geometry.getCoordinates();
        }

        private boolean isMultiPolygon() {
            return (geometry.getType().equals("MultiPolygon"));
        }

        private List<PolygonSet> getPolygonSetList() {
            return geometry.getCoordinates().getPolygonsetList();
        }
    }

    private class Geometry {

        String type;
        Coordinates coordinates;

        private String getType() {
            return type;
        }

        private void setType(String type) {
            this.type = type;
        }

        private Coordinates getCoordinates() {
            return coordinates;
        }

        private void setCoordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
        }
    }


    private class Coordinates {

        @SerializedName("polygonset")
        List<PolygonSet> polygonSetList;

        public List<PolygonSet> getPolygonsetList() {
            return polygonSetList;
        }

        public void setPolygonsetList(List<PolygonSet> polygonSetList) {
            this.polygonSetList = polygonSetList;
        }
    }


    private class PolygonSet {
        @SerializedName("polygon")
        List<LocationPoint> polygonList;

        private List<LocationPoint> getPolygonList() {
            return polygonList;
        }

        private void setPolygonList(List<LocationPoint> polygonList) {
            this.polygonList = polygonList;
        }
    }

    private class LocationPoint {

        double latitude;
        double longitude;

        public LocationPoint(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }


}
