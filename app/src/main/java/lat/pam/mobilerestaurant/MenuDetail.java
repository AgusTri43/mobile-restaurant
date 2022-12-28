package lat.pam.mobilerestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lat.pam.utsrestaurant.R;

public class MenuDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);
        Button btnMove = findViewById(R.id.button_order);
        Button btnbackWard = findViewById(R.id.button_back);

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuDetail.this, OrderDetail.class));
            }
        });

        btnbackWard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuDetail.this, MenuList.class));
            }
        });
    }
}