package org.ieeedtu.troika.utils;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by championswimmer on 20/1/14.
 */
public class SubmitRegister extends AsyncTask<Void, Void, String> {

    private HttpClient submitClient;
    private HttpPost submitPost;
    private HttpResponse submitResponse;

    public SubmitRegister (HttpClient sClient, HttpPost sPost) {
        this.submitClient = sClient;
        this.submitPost =sPost;
    }


    @Override
    protected String doInBackground(Void... voids) {
        String response = "Invalid server response";
        try {
            submitResponse = submitClient.execute(submitPost);
            response = EntityUtils.toString(submitResponse.getEntity());
        } catch (IOException e) {
            //TODO:
            // handle net not connected errors here
            e.printStackTrace();
        }
        Log.d("TROIKA SUBMIT", response);
        return response;
    }
}
