package com.ntkduy1604.airfliteproject_getrestful;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by NTKDUY on 3/1/2017
 * for PIGGY HOUSE
 * you can contact me at: ntkduy1604@gmail.com
 */

public class jsonObjectCreator {
    private String mId, mName, mSerialno, mActivedate;
    private String TAG = MainActivity.class.getSimpleName(); //For debugging purpose

    //    private String mModel, mTagid, mUserid, mComid;     //Scalable data
// Constructor without image
    public  jsonObjectCreator (){}

    public JSONObject createJsonObject(String vId,
                             String vName,
                             String vSerialno,
//                             String vUserid,
//                             String vComid,
//                             String vModel,
//                             String vTagid,
                             String vActivedate
    ) {
        mId = vId;
        mName = vName;
        mSerialno = vSerialno;
        mActivedate = vActivedate;
//        mUserid = vUserid;
//        mComid = vComid;
//        mModel = vModel;
//        mTagid = vTagid;
        JSONObject newDevice = new JSONObject();
        try {
            newDevice.put("id",         mId);
            newDevice.put("name",       mName);
            newDevice.put("serialno",   mSerialno);
            newDevice.put("activedate", mActivedate);
//            newDevice.put("userid",     mUserid);
//            newDevice.put("comid",      mComid);
//            newDevice.put("model",      mModel);
//            newDevice.put("tagid",      mTagid);
        } catch (JSONException e){
            Log.e(TAG, "Exception " + e.toString());
        }
        return newDevice;
    }
}
