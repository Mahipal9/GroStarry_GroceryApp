package app.grostarry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AllProducts extends AppCompatActivity {

    List<ProductA> data= new ArrayList<ProductA>();
    RecyclerView recyclerView;
    ProductRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);

        // Storing data into SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPhonePref", MODE_PRIVATE);
        String phone = sharedPreferences.getString("phone","");


        ProductA o = new ProductA();
        o.setCategory("Snacks");
        o.setId("578GGA");
        o.setProductName("Biscuits");
        o.setOffer(25);
        o.setOriginalPrice(20f);
        o.setCurrentPrice(15f);


          // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("AllProducts");


//        // Getting the ID from firebase database.
//        String StudentRecordIDFromServer = myRef.push().getKey();
//
//        // Adding the both name and number values using student details class object using ID.
//        myRef.child(StudentRecordIDFromServer).setValue(o);
//
//        // Showing Toast message after successfully data submit.
//        Toast.makeText(AllProducts.this,"Data Inserted Successfully into Firebase Database", Toast.LENGTH_LONG).show();


        /*Add to cart starts here*/

//        Toast.makeText(getApplicationContext(),phone,Toast.LENGTH_LONG).show();
//        AddToCart ac = new AddToCart();
//        ac.setProduct_id("SAA123");
//        ac.setQuantity(2);
//        ac.setUid(phone);
//        ac.add();



        /*Add to cart ends here*/


        recyclerView = (RecyclerView) findViewById(R.id.product_list);
        adapter = new ProductRecyclerViewAdapter(data);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    ProductA pDetails = dataSnapshot.getValue(ProductA.class);

                    data.add(pDetails);
                }

                adapter = new ProductRecyclerViewAdapter( data);

                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });








    }
}
