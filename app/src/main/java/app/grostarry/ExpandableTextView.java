package app.grostarry;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ExpandableTextView extends AppCompatActivity {
    TextView descText;
    ImageView plus, minus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details_page);
        Toast.makeText(ExpandableTextView.this,"Plus Clicked", Toast.LENGTH_LONG).show();

        descText = (TextView) findViewById(R.id.description_text);
        plus = (ImageView) findViewById(R.id.plus);
        minus = (ImageView) findViewById(R.id.minus);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ExpandableTextView.this,"Plus Clicked", Toast.LENGTH_LONG).show();
            }
        });


        plus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Plus Clicked",Toast.LENGTH_LONG).show();
                plus.setVisibility(View.GONE);
                minus.setVisibility(View.VISIBLE);
                descText.setMaxLines(5);

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Minus Clicked",Toast.LENGTH_LONG).show();
                minus.setVisibility(View.GONE);
                plus.setVisibility(View.VISIBLE);
                descText.setMaxLines(1);

            }
        });



    }

}
