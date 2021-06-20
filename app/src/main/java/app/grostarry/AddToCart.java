package app.grostarry;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.Context.MODE_PRIVATE;

public class AddToCart {
    private FirebaseAuth mAuth;
    FirebaseUser userid;
    FirebaseDatabase database;
    DatabaseReference myRef;


    String uid;
    String product_id;
    int quantity;

    AddToCart()
    {
        mAuth = FirebaseAuth.getInstance();
        userid = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("users").child(userid.getUid().toString());
    }



    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
         this.uid=uid;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean  add()
    {

        DatabaseReference cartRef = database.getReference("Cart").child(uid);
        cartRef.child(product_id).setValue(this);
       return true;
    }



}
