package com.ntkduy1604.airfliteproject_getrestful;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import junit.framework.Test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class JsonGet extends AppCompatActivity {
//    private String TAG = MainActivity.class.getSimpleName(); //For debugging purpose
    private ListView listView;              // Create a ListView variable
    private ArrayList<Word> words;          // Add array of Words To JsonGet
    private WordAdapter itemsAdapter;       // Create a WordAdapter item

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        words = new ArrayList<Word>();
        listView = (ListView) findViewById(R.id.word_list);
        itemsAdapter = new WordAdapter(JsonGet.this, words, R.color.category_device_list);

        new GetContacts().execute();
    }

    /**
     * Async task class to wait for other tasks to be finished
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {
        String mId, mName, mSerialno, mActivedate;
//        String mModel, mTagid, mUserid, mComid;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler httpHandler = new HttpHandler();
            String mUrl = "https://tadac.com.au/airflite/api1/1/devices";

            // Making a request to url and getting response
            String jsonStr = httpHandler.makeServiceCall(mUrl);
//            Log.e(TAG, jsonStr);
            String temp;

            if (jsonStr != null) {
                try {
                    /**
                     * Get latitude & longitude from geocode Google
                     */
                    JSONArray jsonArray = new JSONArray(jsonStr);
                    Log.v("Length", Integer.toString(jsonArray.length()));
                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        temp = jsonObject.getString("id");                 mId = temp;
                        temp = jsonObject.getString("name");             mName = temp;
                        temp = jsonObject.getString("serialno");     mSerialno = temp;
                        temp = jsonObject.getString("activedate"); mActivedate = temp;
//                        temp = jsonObject.getString("userid");         mUserid = temp;
//                        temp = jsonObject.getString("comid");           mComid = temp;
//                        temp = jsonObject.getString("model");           mModel = temp;
//                        temp = jsonObject.getString("tagid");           mTagid = temp;

                        words.add(new Word(mId, mName, mSerialno, mActivedate,
//                                mUserid, mComid,  mModel, mTagid,
                                R.mipmap.ic_launcher));
                        itemsAdapter = new WordAdapter(JsonGet.this, words, R.color.category_device_list);
                    }
                } catch (final JSONException jsonException) {
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            // Create an ArrayAdapter variable with String data type
            listView.setAdapter(itemsAdapter);
        }
    }
}
