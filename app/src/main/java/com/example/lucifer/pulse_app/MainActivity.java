package com.example.lucifer.pulse_app;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    public String TAG = "volley_picassa_pulse";
    ArrayList<OBJECT_MODEL> users;
    RecyclerView.LayoutManager m = new LinearLayoutManager(this);
    RecyclerView recyclerView;
    RequestQueue requestQueue;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.listview);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), m.getPaddingTop());
        recyclerView.addItemDecoration(dividerItemDecoration);
        requestQueue = Volley.newRequestQueue(this);
        users = new ArrayList<OBJECT_MODEL>();
        getdata();

    }


    private void getdata() {
        String url = "https://pulse-api-v1.herokuapp.com/api/product";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray("products");
                    users.clear();
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject obj = array.getJSONObject(i);
                        users.add(new OBJECT_MODEL(String.valueOf(obj.getInt("cid")),
                                obj.getString("category"),
                                obj.getString("pname"),
                                obj.getString("pimage"), String.valueOf(obj.getInt("mrp"))));
                    }
//                    Toast.makeText(getApplicationContext(), Integer.toString(users.size()), Toast.LENGTH_LONG).show();
//                    list_adapter adapter = new list_adapter(users, getApplicationContext());
                    recycleListviewAdapter adapter = new recycleListviewAdapter(users, getApplicationContext());
                    recyclerView.setLayoutManager(m);
                    recyclerView.setAdapter(adapter);
                    Log.d(TAG, "onResponse: ");
//                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                            Toast.makeText(getApplicationContext(), "Item selected NO." + String.valueOf(users.get(i).getPid()), Toast.LENGTH_LONG).show();
//                        }
//                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d(TAG, "onRe:exception json " + e.getMessage());
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: error listen " + error.getMessage());
            }
        });
        requestQueue.add(request);
    }
}
