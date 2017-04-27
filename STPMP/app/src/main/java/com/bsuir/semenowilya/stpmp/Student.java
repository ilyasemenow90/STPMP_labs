/*
 * Copyright (c) 2016 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.bsuir.semenowilya.stpmp;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class Student {

  public String firstName;
  public String lastName;


  public static ArrayList<Student> getRecipesFromFile(String filename, Context context){
    final ArrayList<Student> studentList = new ArrayList<>();

    try {
      // Load data
      String jsonString = loadJsonFromAsset(filename, context);
      JSONObject json = new JSONObject(jsonString);
      JSONArray recipes = json.getJSONArray("students");

      // Get Student objects from data
      for(int i = 0; i < recipes.length(); i++){
        Student student = new Student();

        student.firstName = recipes.getJSONObject(i).getString("firstName");
        student.lastName = recipes.getJSONObject(i).getString("lastName");

        studentList.add(student);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }

    return studentList;
  }

  static String convertStreamToString(java.io.InputStream is) {
    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
    return s.hasNext() ? s.next() : "";
  }

  @Nullable
  private static String loadJsonFromAsset(String filename, Context context) {
    String json = null;

    try {
      AssetManager myAssetManager = context.getAssets();
      InputStream is = myAssetManager.open(filename);
      json = convertStreamToString(is);
      is.close();
/*
      InputStream is = context.getAssets().open(filename);
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      json = new String(buffer, "UTF-8");*/
    }
    catch (java.io.IOException ex) {
      ex.printStackTrace();
      return null;
    }

    return json;
  }

}
