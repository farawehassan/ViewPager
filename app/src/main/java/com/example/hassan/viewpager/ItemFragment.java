package com.example.hassan.viewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends Fragment {
    private Product mProduct;
    private static final String PRODUCT_KEY = "product_key";

    public static ItemFragment newInstance(Product product) {
        
        Bundle args = new Bundle();
        args.putParcelable(PRODUCT_KEY, product);
        
        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_detail, container, false);

        Bundle args = getArguments();
        if (args == null) throw new AssertionError();

        mProduct = args.getParcelable(PRODUCT_KEY);
        if (mProduct == null) throw new AssertionError();

        //display product name
        TextView nameText = rootView.findViewById(R.id.nameText);
        nameText.setText(mProduct.getName());

        //display product description
        TextView descriptionText = rootView.findViewById(R.id.descriptionText);
        descriptionText.setText(mProduct.getDescription());

        //display price text
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String price = formatter.format(mProduct.getPrice());
        TextView priceText = rootView.findViewById(R.id.priceText);
        priceText.setText(price);

        //Display image with product id from the drawable
        String productId = mProduct.getProductId();
        int imageResource = getActivity().getResources()
                .getIdentifier(productId, "drawable", getActivity().getPackageName());
        ImageView iv = rootView.findViewById(R.id.imageView);
        iv.setImageResource(imageResource);


        return rootView;
    }

}
