package com.example.vikram.simpleretrofitcall;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Vikram on 04-May-17.
 */

public interface ApInterface {
        @Streaming
        @GET
        Call<JsonObject> downloadFileWithDynamicUrlSync(@Url String fileUrl);
}
