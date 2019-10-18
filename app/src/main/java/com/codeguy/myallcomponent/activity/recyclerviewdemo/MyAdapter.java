package com.codeguy.myallcomponent.activity.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codeguy.myallcomponent.R;
import com.codeguy.myallcomponent.models.FoodItem;
import com.codeguy.myallcomponent.models.Footer;
import com.codeguy.myallcomponent.models.Header;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<RecyclerViewItem> myItem;

    private class VIEW_TYPES {
        public static final int Header = 1;
        public static final int Normal = 2;
        public static final int Footer = 3;
    }

    public MyAdapter(Context context, List<RecyclerViewItem> myItem) {
        this.context = context;
        this.myItem = myItem;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = null;
        switch (viewType) {
            case VIEW_TYPES.Header:
                rowView =
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_header, parent, false);
                return new HeaderHolder(rowView);
            case VIEW_TYPES.Footer:
                rowView =
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_footer, parent, false);

                return new FooterHolder(rowView);
            case VIEW_TYPES.Normal:
                rowView =
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row, parent, false);
                return new FoodItemHolder(rowView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        RecyclerViewItem recyclerViewItem = myItem.get(position);
        switch (itemViewType) {
            case VIEW_TYPES.Header: // handle row header
                HeaderHolder headerHolder = (HeaderHolder) holder;
                Header header = (Header) recyclerViewItem;
                //set data
                headerHolder.texViewHeaderText.setText(header.getHeaderText());
                headerHolder.textViewCategory.setText(header.getCategory());
                Glide.with(context).load(header.getImageUrl()).into(headerHolder.imageViewHeader);

                break;
            case VIEW_TYPES.Footer: // handle row footer
                FooterHolder footerHolder = (FooterHolder) holder;
                Footer footer = (Footer) recyclerViewItem;
                //set data
                footerHolder.texViewQuote.setText(footer.getQuote());
                footerHolder.textViewAuthor.setText(footer.getAuthor());
                Glide.with(context).load(footer.getImageUrl()).into(footerHolder.imageViewFooter);

                break;
            case VIEW_TYPES.Normal: // handle row item
                FoodItemHolder foodItemHolder = (FoodItemHolder) holder;
                FoodItem foodItem = (FoodItem) recyclerViewItem;
                //set data
                foodItemHolder.texViewFoodTitle.setText(foodItem.getTitle());
                foodItemHolder.texViewDescription.setText(foodItem.getDescription());
                foodItemHolder.textViewPrice.setText(foodItem.getPrice());
                Glide.with(context).load(foodItem.getImageUrl()).into(foodItemHolder.imageViewFood);
                //check food item is hot or not to set visibility of hot text on image
                if (foodItem.isHot())
                    foodItemHolder.textViewIsHot.setVisibility(View.VISIBLE);
                else
                    foodItemHolder.textViewIsHot.setVisibility(View.GONE);
                break;

        }
    }


    @Override
    public int getItemCount() {
        return myItem.size();
    }

    @Override
    public int getItemViewType(int position) {
        RecyclerViewItem recyclerViewItem = myItem.get(position);
        if (recyclerViewItem instanceof Header)
            return VIEW_TYPES.Header;
        else if (recyclerViewItem instanceof Footer)
            return VIEW_TYPES.Footer;
        else if (recyclerViewItem instanceof FoodItem)
            return VIEW_TYPES.Normal;
        else
            return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }


    //Food item holder
    class FoodItemHolder extends RecyclerView.ViewHolder {
        TextView texViewFoodTitle, texViewDescription, textViewPrice, textViewIsHot;
        ImageView imageViewFood;

        FoodItemHolder(View itemView) {
            super(itemView);
            texViewFoodTitle = itemView.findViewById(R.id.texViewFoodTitle);
            texViewDescription = itemView.findViewById(R.id.texViewDescription);
            imageViewFood = itemView.findViewById(R.id.imageViewFood);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewIsHot = itemView.findViewById(R.id.textViewIsHot);
        }
    }

    //header holder
    class HeaderHolder extends RecyclerView.ViewHolder {
        TextView texViewHeaderText, textViewCategory;
        ImageView imageViewHeader;

        HeaderHolder(View itemView) {
            super(itemView);
            texViewHeaderText = itemView.findViewById(R.id.texViewHeaderText);
            textViewCategory = itemView.findViewById(R.id.textViewCategory);
            imageViewHeader = itemView.findViewById(R.id.imageViewHeader);
        }
    }

    //footer holder
    class FooterHolder extends RecyclerView.ViewHolder {
        TextView texViewQuote, textViewAuthor;
        ImageView imageViewFooter;

        FooterHolder(View itemView) {
            super(itemView);
            texViewQuote = itemView.findViewById(R.id.texViewQuote);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            imageViewFooter = itemView.findViewById(R.id.imageViewFooter);
        }
    }
}
