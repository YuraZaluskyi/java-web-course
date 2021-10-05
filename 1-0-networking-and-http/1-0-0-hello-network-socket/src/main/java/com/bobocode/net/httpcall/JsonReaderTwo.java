package com.bobocode.net.httpcall;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.util.Objects;
import javax.imageio.ImageIO;
import lombok.SneakyThrows;

public class JsonReaderTwo {

  @SneakyThrows
  public static void main(String[] args) {
    URL url = new URL(
        "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=10&api_key=DEMO_KEY");
    URLConnection connection = url.openConnection();
    BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(connection.getInputStream()));
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    while ((str = bufferedReader.readLine()) != null) {
      stringBuilder.append(str);
    }
    bufferedReader.close();
//    System.out.println(stringBuilder.toString());
    JsonObject jsonObject = new JsonParser().parse(stringBuilder.toString()).getAsJsonObject();
    JsonArray jsonArray = jsonObject.getAsJsonArray("photos");

//    System.out.println(jsonArray.get(0).getAsJsonObject().getAsJsonObject().get("img_src"));
//    JsonElement img_src = jsonArray.get(0).getAsJsonObject().getAsJsonObject().get("img_src");

    for (int i = 0; i < jsonArray.size(); i++) {
      String image = jsonArray.get(i).getAsJsonObject().get("img_src").getAsString();
//      System.out.println(image);


      URL urlImage = new URL(image);
//      Image image1 = ImageIO.read(urlImage);

      InputStream inputStream = urlImage.openStream();
      BufferedImage bufferedImage = ImageIO.read(inputStream);

      inputStream.close();
      System.out.println(image);
    }
//    URL url1 = new URL(jsonArray.get(0).getAsJsonObject().get("img_src").getAsString());
//    InputStream inputStream = url1.openStream();
//    BufferedImage bufferedImage = ImageIO.read(inputStream);
//    System.out.println(bufferedImage.getWidth());
//    System.out.println(bufferedImage.getHeight());
//    inputStream.close();
//    System.out.println(bufferedImage.toString());
  }

}
