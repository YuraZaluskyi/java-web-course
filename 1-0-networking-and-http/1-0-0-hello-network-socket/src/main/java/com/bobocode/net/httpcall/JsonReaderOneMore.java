package com.bobocode.net.httpcall;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import lombok.SneakyThrows;

public class JsonReaderOneMore {

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
    JsonObject jsonObject = new JsonParser().parse(stringBuilder.toString()).getAsJsonObject();
    JsonArray jsonArray = jsonObject.getAsJsonArray("photos");
    for (int i = 0; i < jsonArray.size(); i++) {
      String image = jsonArray.get(i).getAsJsonObject().get("img_src").getAsString();
      System.out.println(image);
    }
  }
}
