package app.grostarry.cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import app.grostarry.ProductA;
import app.grostarry.ProductRecyclerViewAdapter;
import app.grostarry.R;

public class Cart extends AppCompatActivity {
    List<ProductA> data= new ArrayList<ProductA>();
    RecyclerView recyclerView;
    CartAdapter adapter;
    ArrayList<String> product_id_list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Storing data into SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPhonePref", MODE_PRIVATE);
        String phone = sharedPreferences.getString("phone", "");


        ProductA o = new ProductA();
        o.setCategory("Snacks");
        o.setId("578GGA");
        o.setProductName("Biscuits");
        o.setOffer(25);
        o.setOriginalPrice(20f);
        o.setCurrentPrice(15f);

        ArrayList<String> myProductId = new ArrayList<>();

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myProductIdRef = database.getReference("Cart").child(phone);
        myProductIdRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    /*ProductA pDetails = dataSnapshot.getValue(ProductA.class);
                    data.add(pDetails);*/

                    product_id_list.add(dataSnapshot.child("product_id").getValue().toString());
                    //Log.i("TAG","data:"+dataSnapshot.child("product_id").getValue());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });





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
        adapter = new CartAdapter(data);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    ProductA pDetails = dataSnapshot.getValue(ProductA.class);
                    Log.i("CART",dataSnapshot.child("id").getValue().toString()); //if(pDetails.getId())
                    if(product_id_list.contains(dataSnapshot.child("id").getValue().toString())) {
                        data.add(pDetails);
                    }
                }
                adapter = new CartAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}