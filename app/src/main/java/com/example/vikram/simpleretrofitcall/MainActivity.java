package com.example.vikram.simpleretrofitcall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String url;

    Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call = (Button)findViewById(R.id.call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApInterface taskService = ServiceGenerator.createService(ApInterface.class);
                //need json thn write JsonObject, String thn string
                Call<JsonObject> call = taskService.downloadFileWithDynamicUrlSync(url);

                call.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, final Response<JsonObject> response) {
                        if (response.isSuccessful()) {

                           String res = response.body().toString();
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.d("err", "error");
                        //loading.dismiss();
                    }
                });

            }
        });
    }
}
