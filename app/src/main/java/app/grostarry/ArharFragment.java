package app.grostarry;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ArharFragment extends Fragment {

    ImageView product_image_1;
    TextView Product_text_1;

    public ArharFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_arhar, container, false);

        ImageView product_image_1=(ImageView) view.findViewById(R.id.product_image_1);
        TextView Product_text_1=(TextView) view.findViewById(R.id.Product_text_1);

        product_image_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getActivity(),Product_details_page.class);
                startActivity(i);
            }
        });

        Product_text_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getActivity(),Product_details_page.class);
                startActivity(i);
            }
        });
        return view;

    }

}
// product_image_1 = findViewById(R.id.product_image_1);
  //       card_View1 = findViewById(R.id.card_view_1);