package app.grostarry;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.glide.slider.library.SliderLayout;
import com.glide.slider.library.animations.DescriptionAnimation;
import com.glide.slider.library.slidertypes.BaseSliderView;
import com.glide.slider.library.slidertypes.TextSliderView;
import com.glide.slider.library.tricks.ViewPagerEx;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikepenz.actionitembadge.library.ActionItemBadge;


import java.util.ArrayList;

import app.grostarry.cart.Cart;

public class Dashboard extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;
    private TextView txtOffer1,txtOffer2,txtOffer3,txtOffer4,txtOffer5,txtOffer6,txtOffer7,txtOffer8,txtOffer9,txtOffer10;
    private ImageView imgProduct1,imgProduct2,imgProduct3,imgProduct4,imgProduct5,imgProduct6,imgProduct7,imgProduct8,imgProduct9,imgProduct10;
    private TextView txtPrice1,txtPrice2,txtPrice3,txtPrice4,txtPrice5,txtPrice6,txtPrice7,txtPrice8,txtPrice9,txtPrice10;
    private TextView txtMRP1,txtMRP2,txtMRP3,txtMRP4,txtMRP5,txtMRP6,txtMRP7,txtMRP8,txtMRP9,txtMRP10;
    private TextView txtDecription1,txtDecription2,txtDecription3,txtDecription4,txtDecription5,txtDecription6,txtDecription7,txtDecription8,txtDecription9,txtDecription10;
    private TextView txtQuantity1,txtQuantity2,txtQuantity3,txtQuantity4,txtQuantity5,txtQuantity6,txtQuantity7,txtQuantity8,txtQuantity9,txtQuantity10;

    Boolean catv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*Temporary Redirection
        Intent intentP=new Intent(getApplicationContext(),AllProducts.class);
        startActivity(intentP);
        /*Temporary Redirection*/


        mDemoSlider = findViewById(R.id.slider);

        CardView card_category_personal_care = findViewById(R.id.card_category_personal_care);
        card_category_personal_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AllProducts.class);
                startActivity(i);
            }
        });

        txtOffer1 = findViewById(R.id.txt_offer1);
        txtOffer2 = findViewById(R.id.txt_offer2);
        txtOffer3 = findViewById(R.id.txt_offer3);
        txtOffer4 = findViewById(R.id.txt_offer4);
        txtOffer5 = findViewById(R.id.txt_offer5);
        txtOffer6 = findViewById(R.id.txt_offer6);
        txtOffer7 = findViewById(R.id.txt_offer7);
        txtOffer8 = findViewById(R.id.txt_offer8);
        txtOffer9 = findViewById(R.id.txt_offer9);
        txtOffer10 = findViewById(R.id.txt_offer10);

        imgProduct1 = findViewById(R.id.img_product1);
        imgProduct2 = findViewById(R.id.img_product2);
        imgProduct3 = findViewById(R.id.img_product3);
        imgProduct4 = findViewById(R.id.img_product4);
        imgProduct5 = findViewById(R.id.img_product5);
        imgProduct6 = findViewById(R.id.img_product6);
        imgProduct7 = findViewById(R.id.img_product7);
        imgProduct8 = findViewById(R.id.img_product8);
        imgProduct9 = findViewById(R.id.img_product9);
        imgProduct10 = findViewById(R.id.img_product10);

        txtPrice1 = findViewById(R.id.txt_price1);
        txtPrice2 = findViewById(R.id.txt_price2);
        txtPrice3 = findViewById(R.id.txt_price3);
        txtPrice4 = findViewById(R.id.txt_price4);
        txtPrice5 = findViewById(R.id.txt_price5);
        txtPrice6 = findViewById(R.id.txt_price6);
        txtPrice7 = findViewById(R.id.txt_price7);
        txtPrice8 = findViewById(R.id.txt_price8);
        txtPrice9 = findViewById(R.id.txt_price9);
        txtPrice10 = findViewById(R.id.txt_price10);

        txtMRP1 = findViewById(R.id.txt_mrp1);
        txtMRP2 = findViewById(R.id.txt_mrp2);
        txtMRP3 = findViewById(R.id.txt_mrp3);
        txtMRP4 = findViewById(R.id.txt_mrp4);
        txtMRP5 = findViewById(R.id.txt_mrp5);
        txtMRP6 = findViewById(R.id.txt_mrp6);
        txtMRP7 = findViewById(R.id.txt_mrp7);
        txtMRP8 = findViewById(R.id.txt_mrp8);
        txtMRP9 = findViewById(R.id.txt_mrp9);
        txtMRP10 = findViewById(R.id.txt_mrp10);

        txtDecription1 = findViewById(R.id.txt_description1);
        txtDecription2 = findViewById(R.id.txt_description2);
        txtDecription3 = findViewById(R.id.txt_description3);
        txtDecription4 = findViewById(R.id.txt_description4);
        txtDecription5 = findViewById(R.id.txt_description5);
        txtDecription6 = findViewById(R.id.txt_description6);
        txtDecription7 = findViewById(R.id.txt_description7);
        txtDecription8 = findViewById(R.id.txt_description8);
        txtDecription9 = findViewById(R.id.txt_description9);
        txtDecription10 = findViewById(R.id.txt_description10);

        txtQuantity1 = findViewById(R.id.txt_quantity1);
        txtQuantity2 = findViewById(R.id.txt_quantity2);
        txtQuantity3 = findViewById(R.id.txt_quantity3);
        txtQuantity4 = findViewById(R.id.txt_quantity4);
        txtQuantity5 = findViewById(R.id.txt_quantity5);
        txtQuantity6 = findViewById(R.id.txt_quantity6);
        txtQuantity7 = findViewById(R.id.txt_quantity7);
        txtQuantity8 = findViewById(R.id.txt_quantity8);
        txtQuantity9 = findViewById(R.id.txt_quantity9);
        txtQuantity10 = findViewById(R.id.txt_quantity10);



        final ArrayList<String> p_id = new ArrayList<>();
        final ArrayList<String> p_offer = new ArrayList<>();
        final ArrayList<String> p_imageurl = new ArrayList<>();
        final ArrayList<String> p_name = new ArrayList<>();
        final ArrayList<String> p_description = new ArrayList<>();
        final ArrayList<String> p_origionalprice = new ArrayList<>();
        final ArrayList<String> p_pricenow = new ArrayList<>();
        final ArrayList<String> p_quantity = new ArrayList<>();

        final ArrayList<String> itemlist = new ArrayList<>();
        itemlist.add("item1");
        itemlist.add("item2");
        itemlist.add("item3");
        itemlist.add("item4");
        itemlist.add("item5");
        itemlist.add("item6");
        itemlist.add("item7");
        itemlist.add("item8");
        itemlist.add("item9");
        itemlist.add("item10");


        /*code for hide and show category strats here*/
        catv1 = false;
        final LinearLayout catll1 = findViewById(R.id.expand1);
        final View redLayout = findViewById(R.id.cat1);
        final ViewGroup parent = findViewById(R.id.parent1);
        final ImageView arrow_cat1=findViewById(R.id.arrow_cat1);
        redLayout.setVisibility(View.GONE);
        catll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catv1 = !catv1;
                Transition transition = new Slide(Gravity.TOP);
                transition.setDuration(30000);
                transition.addTarget(R.id.card_view_1);

                TransitionManager.beginDelayedTransition(parent, transition);
                redLayout.setVisibility(catv1 ? View.VISIBLE : View.GONE);
                catll1.setBackgroundColor(catv1? Color.parseColor("#ffe699"):Color.parseColor("#FFFFFF"));
                arrow_cat1.setImageResource(catv1?R.drawable.ic_keyboard_arrow_up_black_24dp:R.drawable.ic_keyboard_arrow_down_black_24dp);
            }
        });

        /*code for hide and show category ends here*/





        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mRef1 = FirebaseDatabase.getInstance().getReference("bestselling");

//           mRef1.child("item1").child("id").setValue("1");
//            mRef1.child("item1").child("offer").setValue("25");
//            mRef1.child("item1").child("imageurl").setValue("25");
//            mRef1.child("item1").child("name").setValue("25");
//            mRef1.child("item1").child("description").setValue("25");
//            mRef1.child("item1").child("origional_price").setValue("25");
//            mRef1.child("item1").child("price_now").setValue("25");
//            mRef1.child("item1").child("quantity").setValue("25");

        mRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
               // Toast.makeText(getApplicationContext(),"Data is changed now",Toast.LENGTH_LONG).show();
                p_offer.clear();
                p_id.clear();
                p_imageurl.clear();
                p_name.clear();
                p_description.clear();
                p_origionalprice.clear();
                p_pricenow.clear();
                p_quantity.clear();
                for(String node:itemlist)
                {
                    p_offer.add(dataSnapshot.child(node).child("offer").getValue().toString());
                    p_id.add(dataSnapshot.child(node).child("id").getValue().toString());
                    p_imageurl.add(dataSnapshot.child(node).child("imageurl").getValue().toString());
                    p_name.add(dataSnapshot.child(node).child("name").getValue().toString());
                    p_description.add(dataSnapshot.child(node).child("description").getValue().toString());
                    p_origionalprice.add(dataSnapshot.child(node).child("origional_price").getValue().toString());
                    p_pricenow.add(dataSnapshot.child(node).child("price_now").getValue().toString());
                    p_quantity.add(dataSnapshot.child(node).child("quantity").getValue().toString());


                }

                /*set offer prices from the ArrayList*/
                txtOffer1.setText(p_offer.get(0)+"% OFF");
                txtOffer2.setText(p_offer.get(1)+"% OFF");
                txtOffer3.setText(p_offer.get(2)+"% OFF");
                txtOffer4.setText(p_offer.get(3)+"% OFF");
                txtOffer5.setText(p_offer.get(4)+"% OFF");
                txtOffer6.setText(p_offer.get(5)+"% OFF");
                txtOffer7.setText(p_offer.get(6)+"% OFF");
                txtOffer8.setText(p_offer.get(7)+"% OFF");
                txtOffer9.setText(p_offer.get(8)+"% OFF");
                txtOffer10.setText(p_offer.get(9)+"% OFF");


                /*setting image url*/
               Glide.with(getApplicationContext()).load(p_imageurl.get(0).toString()).placeholder(R.drawable.loading_iconb).into(imgProduct1);
                Glide.with(getApplicationContext()).load(p_imageurl.get(1).toString()).placeholder(R.drawable.loading_iconb).into(imgProduct2);
                Glide.with(getApplicationContext()).load(p_imageurl.get(2).toString()).placeholder(R.drawable.loading_iconb).into(imgProduct3);
                Glide.with(getApplicationContext()).load(p_imageurl.get(3).toString()).placeholder(R.drawable.loading_iconb).into(imgProduct4);
                Glide.with(getApplicationContext()).load(p_imageurl.get(4).toString()).placeholder(R.drawable.loading_iconb).into(imgProduct5);
                Glide.with(getApplicationContext()).load(p_imageurl.get(5).toString()).placeholder(R.drawable.loading_iconb).into(imgProduct6);
                Glide.with(getApplicationContext()).load(p_imageurl.get(6).toString()).placeholder(R.drawable.loading_iconb).into(imgProduct7);
                Glide.with(getApplicationContext()).load(p_imageurl.get(7).toString()).placeholder(R.drawable.loading_iconb).into(imgProduct8);
                Glide.with(getApplicationContext()).load(p_imageurl.get(8).toString()).placeholder(R.drawable.loading_iconb).into(imgProduct9);
                Glide.with(getApplicationContext()).load(p_imageurl.get(9).toString()).placeholder(R.drawable.loading_iconb).into(imgProduct10);

                /*setting current price url*/
               txtPrice1.setText("₹"+p_pricenow.get(0));
                txtPrice2.setText("₹"+p_pricenow.get(1));
                txtPrice3.setText("₹"+p_pricenow.get(2));
                txtPrice4.setText("₹"+p_pricenow.get(3));
                txtPrice5.setText("₹"+p_pricenow.get(4));
                txtPrice6.setText("₹"+p_pricenow.get(5));
                txtPrice7.setText("₹"+p_pricenow.get(6));
                txtPrice8.setText("₹"+p_pricenow.get(7));
                txtPrice9.setText("₹"+p_pricenow.get(8));
                txtPrice10.setText("₹"+p_pricenow.get(9));

                /*mrp price*/
                txtMRP1.setText("₹"+p_origionalprice.get(0));
                txtMRP2.setText("₹"+p_origionalprice.get(1));
                txtMRP3.setText("₹"+p_origionalprice.get(2));
                txtMRP4.setText("₹"+p_origionalprice.get(3));
                txtMRP5.setText("₹"+p_origionalprice.get(4));
                txtMRP6.setText("₹"+p_origionalprice.get(5));
                txtMRP7.setText("₹"+p_origionalprice.get(6));
                txtMRP8.setText("₹"+p_origionalprice.get(7));
                txtMRP9.setText("₹"+p_origionalprice.get(8));
                txtMRP10.setText("₹"+p_origionalprice.get(9));

                txtMRP1.setPaintFlags(txtMRP1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                txtMRP2.setPaintFlags(txtMRP1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                txtMRP3.setPaintFlags(txtMRP1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                txtMRP4.setPaintFlags(txtMRP1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                txtMRP5.setPaintFlags(txtMRP1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                txtMRP6.setPaintFlags(txtMRP1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                txtMRP7.setPaintFlags(txtMRP1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                txtMRP8.setPaintFlags(txtMRP1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                txtMRP9.setPaintFlags(txtMRP1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                txtMRP10.setPaintFlags(txtMRP1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

               txtDecription1.setText(p_description.get(0));
                txtDecription2.setText(p_description.get(1));
                txtDecription3.setText(p_description.get(2));
                txtDecription4.setText(p_description.get(3));
                txtDecription5.setText(p_description.get(4));
                txtDecription6.setText(p_description.get(5));
                txtDecription7.setText(p_description.get(6));
                txtDecription8.setText(p_description.get(7));
                txtDecription9.setText(p_description.get(8));
                txtDecription10.setText(p_description.get(9));

                txtQuantity1.setText(p_quantity.get(0));
                txtQuantity2.setText(p_quantity.get(1));
                txtQuantity3.setText(p_quantity.get(2));
                txtQuantity4.setText(p_quantity.get(3));
                txtQuantity5.setText(p_quantity.get(4));
                txtQuantity6.setText(p_quantity.get(5));
                txtQuantity7.setText(p_quantity.get(6));
                txtQuantity8.setText(p_quantity.get(7));
                txtQuantity9.setText(p_quantity.get(8));
                txtQuantity10.setText(p_quantity.get(9));

            }



            @Override
            public void onCancelled(DatabaseError error)
            {
                Toast.makeText(getApplicationContext(),"Error "+error.toException(),Toast.LENGTH_LONG).show();
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        });



        ArrayList<String> listUrl = new ArrayList<>();
        ArrayList<String> listName = new ArrayList<>();

        listUrl.add("https://www.revive-adserver.com/media/GitHub.jpg");
        listName.add("JPG - Github");

        listUrl.add("https://tctechcrunch2011.files.wordpress.com/2017/02/android-studio-logo.png");
        listName.add("PNG - Android Studio");

        listUrl.add("http://static.tumblr.com/7650edd3fb8f7f2287d79a67b5fec211/3mg2skq/3bdn278j2/tumblr_static_idk_what.gif");
        listName.add("GIF - Disney");

        listUrl.add("http://www.gstatic.com/webp/gallery/1.webp");
        listName.add("WEBP - Mountain");

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.centerCrop();
        //.diskCacheStrategy(DiskCacheStrategy.NONE)
        //.placeholder(R.drawable.placeholder)
        //.error(R.drawable.placeholder);

        for (int i = 0; i < listUrl.size(); i++) {
            TextSliderView sliderView = new TextSliderView(this);
            // if you want show image only / without description text use DefaultSliderView instead

            // initialize SliderLayout
            sliderView
                    .image(listUrl.get(i))
                    .description(listName.get(i))
                    .setRequestOption(requestOptions)
                    .setProgressBarVisible(true)
                    .setOnSliderClickListener(this);

            //add your extra information
            sliderView.bundle(new Bundle());
            sliderView.getBundle().putString("extra", listName.get(i));
            mDemoSlider.addSlider(sliderView);
        }

        // set Slider Transition Animation
        // mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);

        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
        mDemoSlider.stopCyclingWhenTouch(false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.abc,menu);

        ActionItemBadge.update(this,menu.findItem(R.id.cart),getDrawable(R.drawable.ic_shopping_cart_black_24dp),ActionItemBadge.BadgeStyles.RED,8);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.cart:
                Intent intentCart = new Intent(Dashboard.this, Cart.class);
                startActivity(intentCart);
        }
        return true;
    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this, slider.getBundle().getString("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }



}

