# Android Offline Reverse Geocode Country

A module for getting a country name and country code when given a specific latitude and longitude. It works offline. No need for an Internet connection.


## Usage
##### Copy the following files to your project:
1.  Polygon folder
  1.  Line
  2.  Point
  3.  Polygon
2.  GeocoderList.java
3.  GeocoderListBuilder.java
4.  ReverseGeocodeCountryWithName.json (in assets folder)

The code is simplified to one line.
```
String countryId = GeocodeListBuilder.getCountryId(context, latitude, longitude);
String countryName = GeocodeListBuilder.getCountryName(context, latitude, longitude);

```

## Sample App


[Reverse Geocode Country on Play Store](https://play.google.com/store/apps/details?id=com.tanapruk.reversegeocodecountry)

## Attribution
The code here are combine from:


1.  [ios-offline-reverse-geocode-country](https://github.com/krisrak/ios-offline-reverse-geocode-country)
I modified the JSON file so that it is easier to deserialization in android.

2.  [polygon-contains-point](https://github.com/sromku/polygon-contains-point)
This module helps locate a given latitude and longitude whether it is in a polygon of a given country.

## License
The MIT License (MIT)

Copyright (c) 2015 Tanapruk Tangphianphan
```
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```