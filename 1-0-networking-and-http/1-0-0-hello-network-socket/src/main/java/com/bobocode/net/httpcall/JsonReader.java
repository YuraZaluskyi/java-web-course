package com.bobocode.net.httpcall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import lombok.SneakyThrows;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {

  @SneakyThrows
  public static void main(String[] args) {
    URL url = new URL(
        "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY");
    URLConnection urlConnection = url.openConnection();
    BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(urlConnection.getInputStream()));
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    while ((str = bufferedReader.readLine()) != null) {
      stringBuilder.append(str);
    }
    bufferedReader.close();
    Object object = new JSONParser().parse(stringBuilder.toString());
    JSONObject jsonObject = (JSONObject) object;
    JSONArray arrayPhotos = (JSONArray) jsonObject.get("photos");
    Iterator photoIterator = arrayPhotos.iterator();
    while (photoIterator.hasNext()) {
      JSONObject photo = (JSONObject) photoIterator.next();
      System.out.println(photo.get("img_src"));
    }
  }
}