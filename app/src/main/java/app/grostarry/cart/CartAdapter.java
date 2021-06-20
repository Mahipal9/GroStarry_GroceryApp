package app.grostarry.cart;

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

import app.grostarry.AddToCart;
import app.grostarry.ProductA;
import app.grostarry.R;

import static android.content.Context.MODE_PRIVATE;
import static com.mikepenz.iconics.Iconics.getApplicationContext;

public class CartAdapter extends RecyclerView.Adapter<app.grostarry.cart.CartAdapter.ViewHolder>{



    List<ProductA> data;


    CartAdapter(List<ProductA> data)
    {
        this.data = data;
    }

    @Override
    public app.grostarry.cart.CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.layout_itemcart, parent, false);
        app.grostarry.cart.CartAdapter.ViewHolder viewHolder = new app.grostarry.cart.CartAdapter.ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull app.grostarry.cart.CartAdapter.ViewHolder holder, int position) {
        final ProductA productA = data.get(position);
        //imgProduct
        holder.txtProductName.setText(productA.getProductName());
        holder.txtOrigionalPrice.setText(String.valueOf(productA.getOriginalPrice()));
        holder.txtCurrentPrice.setText(String.valueOf(productA.getCurrentPrice()));


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgProduct;
        public TextView txtProductName;
        public TextView txtOrigionalPrice;
        public TextView txtCurrentPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.product_image_1);
            txtProductName = itemView.findViewById(R.id.Product_text_1);
            txtOrigionalPrice = itemView.findViewById(R.id.txt_originalprice1);
            txtCurrentPrice = itemView.findViewById(R.id.txt_currentprice1);
        }
    }
}
