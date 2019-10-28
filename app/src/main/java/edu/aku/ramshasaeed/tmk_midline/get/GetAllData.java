package edu.aku.ramshasaeed.tmk_midline.get;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import edu.aku.ramshasaeed.tmk_midline.adapter.SyncListAdapter;
import edu.aku.ramshasaeed.tmk_midline.contracts.AreasContract;
import edu.aku.ramshasaeed.tmk_midline.contracts.SyncModel;
import edu.aku.ramshasaeed.tmk_midline.contracts.TalukasContract;
import edu.aku.ramshasaeed.tmk_midline.contracts.UCsContract;
import edu.aku.ramshasaeed.tmk_midline.contracts.UsersContract;
import edu.aku.ramshasaeed.tmk_midline.contracts.VersionAppContract;
import edu.aku.ramshasaeed.tmk_midline.contracts.VillagesContract;
import edu.aku.ramshasaeed.tmk_midline.core.DatabaseHelper;
import edu.aku.ramshasaeed.tmk_midline.core.MainApp;

/**
 * Created by ali.azaz on 7/14/2017.
 */

public class GetAllData extends AsyncTask<String, String, String> {

    HttpURLConnection urlConnection;
    private String TAG = "";
    private Context mContext;
    private ProgressDialog pd;
    SyncListAdapter adapter;
    List<SyncModel> list;
    int position;


    private String syncClass;


    public GetAllData(Context context, String syncClass) {
        mContext = context;
        this.syncClass = syncClass;
        TAG = "Get" + syncClass;
    }

    public GetAllData(Context context, String syncClass, SyncListAdapter adapter, List<SyncModel> list) {
        mContext = context;
        this.syncClass = syncClass;
        this.adapter = adapter;
        this.list = list;
        TAG = "Get" + syncClass;
        switch (syncClass) {
            case "Talukas":
                position = 0;
                break;
            case "UCs":
                position = 1;
                break;
            case "Areas":
                position = 2;
                break;
            case "Villages":
                position = 3;
                break;
            case "Users":
                position = 4;
                break;
            case "VersionApp":
                position = 5;
                break;
        }
        list.get(position).settableName(syncClass);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setTitle("Syncing " + syncClass);
        pd.setMessage("Getting connected to server...");
//        pd.show();
        list.get(position).setstatus("Getting connected to server...");
        list.get(position).setstatusID(2);
        list.get(position).setmessage("");
        adapter.updatesyncList(list);

    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        switch (values[0]) {
            case "Talukas":
                position = 0;
                break;
            case "UCs":
                position = 1;
                break;
            case "Areas":
                position = 2;
                break;
            case "Villages":
                position = 3;
                break;
            case "Users":
                position = 4;
                break;
            case "VersionApp":
                position = 5;
                break;
        }
        list.get(position).setstatus("Syncing");
        list.get(position).setstatusID(2);
        list.get(position).setmessage("");
        adapter.updatesyncList(list);
    }

    @Override
    protected String doInBackground(String... args) {

        StringBuilder result = new StringBuilder();

        URL url = null;
        try {
            switch (syncClass) {
                case "Talukas":
                    url = new URL(MainApp._HOST_URL + TalukasContract.singleTalukas._URI);
                    position = 0;
                    break;
                case "UCs":
                    url = new URL(MainApp._HOST_URL + UCsContract.singleUCs._URI);
                    position = 1;
                    break;
                case "Areas":
                    url = new URL(MainApp._HOST_URL + AreasContract.singleAreas._URI);
                    position = 2;
                    break;
                case "Villages":
                    url = new URL(MainApp._HOST_URL + VillagesContract.singleVillages._URI);
                    position = 3;
                    break;
                case "Users":
                    url = new URL(MainApp._HOST_URL + UsersContract.singleUser._URI);
                    position = 4;
                    break;
                case "VersionApp":
                    url = new URL(MainApp._UPDATE_URL_NEW + VersionAppContract.VersionAppTable._URI);
                    position = 5;
                    break;
            }

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(100000 /* milliseconds */);
            urlConnection.setConnectTimeout(150000 /* milliseconds */);

            switch (syncClass) {
                case "Talukas":
                case "UCs":
                case "Areas":
                case "Villages":
                case "Users":
                case "VersionApp":
                            urlConnection.setRequestMethod("POST");
                            urlConnection.setDoOutput(true);
                            urlConnection.setDoInput(true);
                            urlConnection.setRequestProperty("Content-Type", "application/json");
                            urlConnection.setRequestProperty("charset", "utf-8");
                            urlConnection.setUseCaches(false);
                            // Starts the query
                            urlConnection.connect();

                    break;
            }


            Log.d(TAG, "doInBackground: " + urlConnection.getResponseCode());
            publishProgress(syncClass);
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                publishProgress("In Progress");

                String line;
                while ((line = reader.readLine()) != null) {
                    Log.i(TAG, syncClass + " In: " + line);
                    result.append(line);
                }
            }
        } catch (java.net.SocketTimeoutException e) {
            return null;
        } catch (java.io.IOException e) {
            return null;
        } finally {
            urlConnection.disconnect();
        }


        return result.toString();
    }

    @Override
    protected void onPostExecute(String result) {

        //Do something with the JSON string
        if (result != null) {
            String json = result;
            if (json.length() > 0) {
                DatabaseHelper db = new DatabaseHelper(mContext);
                String message;
                try {
                    JSONArray jsonArray = new JSONArray(json);

                    switch (syncClass) {
                        case "Talukas":
                            db.syncTalukas(jsonArray);
                            position = 0;
                            break;
                        case "UCs":
                            db.syncUCs(jsonArray);
                            position = 1;
                            break;
                        case "Areas":
                            db.syncAreas(jsonArray);
                            position = 2;
                            break;
                        case "Villages":
                            db.syncVillages(jsonArray);
                            position = 3;
                            break;
                        case "Users":
                            db.syncUser(jsonArray);
                            position = 4;
                            break;
                        case "VersionApp":
                            db.syncVersionApp(jsonArray);
                            position = 5;
                            break;
                    }

                    pd.setMessage("Received: " + jsonArray.length());
                    list.get(position).setmessage("Received: " + jsonArray.length());
                    list.get(position).setstatus("Successfull");
                    list.get(position).setstatusID(3);
                    adapter.updatesyncList(list);
//                    pd.show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                pd.setMessage("Received: " + json.length() + "");
                list.get(position).setmessage("Received: " + json.length() + "");
                list.get(position).setstatus("Successfull");
                list.get(position).setstatusID(3);
                adapter.updatesyncList(list);
//                pd.show();
            }
        } else {
            pd.setTitle("Connection Error");
            pd.setMessage("Server not found!");
            list.get(position).setstatus("Failed");
            list.get(position).setstatusID(1);
            list.get(position).setmessage("Server not found!");
            adapter.updatesyncList(list);
//            pd.show();
        }
    }

}
