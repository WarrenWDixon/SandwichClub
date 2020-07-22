package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        //public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients)
        Log.d("WWD", "in parseSandwichJson input json is " + json);
        JSONObject jOBJ = null;
        try {
            jOBJ = new JSONObject(json);
        } catch (JSONException e) {
            Log.d("WWD", "exception on creating JSON object from json string");
            e.printStackTrace();
        }
        Log.d("WWD", "created JSONObject form string " + jOBJ);
        JSONObject jsonName;
        try {
            jsonName = jOBJ.getJSONObject("name");
        } catch (JSONException e) {
            jsonName = null;
            Log.d("WWD", "got execption parsing name JSON Object");
            e.printStackTrace();
        }
        Log.d("WWD", "parsed name object is " +  jsonName);
        String n1= null;
        try {
            n1 =  jsonName.getString("mainName");
        } catch (JSONException e) {
            Log.d("WWD", "got exception parsing mainName");
            e.printStackTrace();
        }
        Log.d("WWD", "mainName is " + n1);
        String name = "DoubleDecker Sandwich";

        List<String> aka = new ArrayList<String>();

        // logic for parsing AKA array
        List<String> aka2 = new ArrayList<>();
        JSONArray jsonAKA = new JSONArray();
        try {
            jsonAKA  = jsonName.getJSONArray("alsoKnownAs");
        } catch (JSONException e) {
            Log.d("WWD", "got exception parsing AKA");
            e.printStackTrace();
        }

        Log.d("WWD", "AKA is " + jsonAKA);
        int len = jsonAKA.length();

        Log.d("WWD", "length of AKA array is " + len);
        /* for (int i =0 ; i < len ;i++) {
            try {
                aka2.add(jsonAKA.getJSONObject(i).toString());
            } catch (JSONException e) {
                Log.d("WWD", "error parsing AKA");
                e.printStackTrace();
            }
            Log.d("WWD", "aka is " + aka2.get(i));
        } */


        String origin2 = null;
        try {
            origin2 = jOBJ.getString("placeOfOrigin");
        } catch (JSONException e) {
            Log.d("WWD", "got exception parsing place of origin");
            e.printStackTrace();
        }
        Log.d("WWD","place of origin is " + origin2);
        String desc2 = null;
        try {
            desc2 = jOBJ.getString("description");
        } catch (JSONException e) {
            Log.d("WWD", "got exception parsing description");
            e.printStackTrace();
        }
        Log.d("WWD", "description is  " + desc2 );
        aka.add("Warrens sandwich");
        aka.add("Best sandwich ever");
        String origin = "Dallas, Texas";
        String description = "very delicious sandwich";
        String image = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG";
        List<String> ingredients = new ArrayList<>();
        Sandwich sandwich = new Sandwich(name, aka,origin,description,image, ingredients);
        return sandwich;
    }
}
