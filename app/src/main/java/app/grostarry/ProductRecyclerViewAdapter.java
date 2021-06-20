package app.grostarry;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.mikepenz.iconics.Iconics.getApplicationContext;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder>{



    List<ProductA> data;


    ProductRecyclerViewAdapter(List<ProductA> data)
    {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.layout_product_a, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ProductA productA = data.get(position);

        //imgProduct

        holder.txtProductName.setText(productA.getProductName());
        holder.txtOffer.setText(String.valueOf(productA.getOffer()));
        holder.txtOrigionalPrice.setText(String.valueOf(productA.getOriginalPrice()));
        holder.txtCurrentPrice.setText(String.valueOf(productA.getCurrentPrice()));


        holder.imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddToCart ac = new AddToCart();
                ac.setProduct_id(productA.getId());
                ac.setQuantity(2);
                ac.setUid("8805803087");
                ac.add();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgProduct;
        public TextView txtProductName;
        public TextView txtOffer;
        public TextView txtOrigionalPrice;
        public TextView txtCurrentPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.product_image_1);
            txtProductName = itemView.findViewById(R.id.Product_text_1);
            txtOffer = itemView.findViewById(R.id.txt_offerp_1);
            txtOrigionalPrice = itemView.findViewById(R.id.txt_originalprice1);
            txtCurrentPrice = itemView.findViewById(R.id.txt_currentprice1);
        }
    }
}
