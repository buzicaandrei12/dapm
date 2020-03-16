package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ListView listOfCars;
    CarAdapter carAdapter;
    private EditText addNewCar;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfCars = findViewById(R.id.iv_list_cars);
        carAdapter = new CarAdapter(this);
        listOfCars.setAdapter(carAdapter);
        addNewCar = findViewById(R.id.ed_new_car);
        addButton = findViewById(R.id.b_add_car);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resource;
                if(getResources().getIdentifier(addNewCar.getText().toString().toLowerCase().trim(),"drawable",getPackageName())!= 0)
                {
                    resource = getResources().getIdentifier(addNewCar.getText().toString().toLowerCase().trim() ,"drawable",getPackageName());
                }
                else
                {
                    resource = R.drawable.lab5_car_icon;
                }
                carAdapter.addCar(addNewCar.getText().toString(), resource);

                addNewCar.setText("");
            }
        });

    }
}

class Car{
    String name;
    int imageResource;
}

class TagCar{
    TextView name;
    ImageView image;
}
