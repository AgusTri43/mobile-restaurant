package lat.pam.mobilerestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;

import lat.pam.utsrestaurant.R;

public class MenuList extends AppCompatActivity {

    TextView pizza, spaghetti, burger, steak, frenchFries;
    TextView pizzaDetail, spaghettiDetail, burgerDetail, steakDetail, frenchFriesDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        pizza = findViewById(R.id.pepperoni_pizza);
        pizzaDetail = findViewById(R.id.pepperoni_pizza_detail);
        spaghetti = findViewById(R.id.spaghetti);
        spaghettiDetail = findViewById(R.id.spaghetti_detail);
        burger = findViewById(R.id.burger);
        burgerDetail = findViewById(R.id.burger_detail);
        steak = findViewById(R.id.steak);
        steakDetail = findViewById(R.id.steak_detail);
        frenchFries = findViewById(R.id.french_fries);
        frenchFriesDetail = findViewById(R.id.french_fries_detail);


        server();

        FloatingActionButton fab = findViewById(R.id.button_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuList.this, MenuDetail.class));
            }
        });


    }

    private void server() {
        String url= GlobalAPI.base_url;
        StringRequest request = new StringRequest(

                Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    // Pizza
                    String pizzaName = jsonArray.getJSONObject(0).getString("foodName");
                    pizza.setText(pizzaName);
                    String pizzaDetails = jsonArray.getJSONObject(0).getString("details");
                    pizzaDetail.setText(pizzaDetails);

                    // Spaghetti
                    String spaghettiName = jsonArray.getJSONObject(1).getString("foodName");
                    spaghetti.setText(spaghettiName);
                    String spaghettiDetails = jsonArray.getJSONObject(1).getString("details");
                    spaghettiDetail.setText(spaghettiDetails);

                    // Burger
                    String burgerName = jsonArray.getJSONObject(2).getString("foodName");
                    burger.setText(burgerName);
                    String burgerDetails = jsonArray.getJSONObject(2).getString("details");
                    burgerDetail.setText(burgerDetails);

                    // Steak
                    String steakName = jsonArray.getJSONObject(3).getString("foodName");
                    steak.setText(steakName);
                    String steakDetails = jsonArray.getJSONObject(3).getString("details");
                    steakDetail.setText(steakDetails);

                    // French Fries
                    String frenchFriesName = jsonArray.getJSONObject(4).getString("foodName");
                    frenchFries.setText(frenchFriesName);
                    String frenchFriesDetails = jsonArray.getJSONObject(4).getString("details");
                    frenchFriesDetail.setText(frenchFriesDetails);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MenuList.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        // request queue using volley
        RequestQueue requestQueue = Volley.newRequestQueue(MenuList.this);
        requestQueue.add(request);
    }
}