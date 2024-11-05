package id.ac.binus.persiapanuts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<DataModel> shoesList;
    ListView listdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listdata = findViewById(R.id.ListViewData);
        shoesList = new ArrayList<>();

        DataModel shoes = new DataModel(R.drawable.airjordan13retro, "Off-White Nike Air Jordan 1 \"UNC\"", "Rp 12.000.000,00");
        shoesList.add(shoes);

        shoes = new DataModel(R.drawable.airjordan9gnrgm24, "Air Jordan 4RM", "Rp 2,199,000");
        shoesList.add(shoes);

        shoes = new DataModel(R.drawable.airjordanoffwhitechicago, "Air Jordan 13 Retro 'White and Midnight Navy'","Rp 3,269,000");
        shoesList.add(shoes);

        shoes = new DataModel(R.drawable.wmnsairjordan5retro, "Air Jordan 5 Retro 'Lucky Green'", "Rp 3,169,000");
        shoesList.add(shoes);

        shoes = new DataModel(R.drawable.wnsairjordan4rm, "Air Jordan 9 G NRG", "Rp 3,369,000");
        shoesList.add(shoes);

        ContentAdapter adapter = new ContentAdapter(getApplicationContext(),shoesList);
        listdata.setAdapter(adapter);

        listdata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //intent(page skarang, page yang dituju)
                Intent intent = new Intent(MainActivity.this, DetailProduct.class);

                intent.putExtra("ProductImage",shoesList.get(i).getImage());
                intent.putExtra("ProductName",shoesList.get(i).getNama());
                intent.putExtra("ProductPrice",shoesList.get(i).getHarga());

                startActivity(intent);
            }
        });

    }
}