package com.codeguy.myallcomponent.activity.recyclerviewdemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codeguy.myallcomponent.R;
import com.codeguy.myallcomponent.models.FoodItem;
import com.codeguy.myallcomponent.models.Footer;
import com.codeguy.myallcomponent.models.Header;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new Space(20));
        List<RecyclerViewItem> dummyList = createDummyList();
        recyclerView.setAdapter(new MyAdapter(this, dummyList));
    }

    //Method to create dummy data
    private List<RecyclerViewItem> createDummyList() {
        List<RecyclerViewItem> recyclerViewItems = new ArrayList<>();
        Header header = new Header("Welcome To Food Express", "Non-Veg Menu",
                "https://cdn1.imggmi.com/uploads/2019/10/18/b91eb9a510419e563861b9537fdb73dc-full.jpg");
        //add header
        recyclerViewItems.add(header);
        String[] imageUrls = {"https://cdn1.imggmi.com/uploads/2019/10/18/b91eb9a510419e563861b9537fdb73dc-full.jpg",
                "https://cdn1.imggmi.com/uploads/2019/10/18/b91eb9a510419e563861b9537fdb73dc-full.jpg",
                "https://cdn1.imggmi.com/uploads/2019/10/18/b91eb9a510419e563861b9537fdb73dc-full.jpg",
                "https://cdn1.imggmi.com/uploads/2019/10/18/b91eb9a510419e563861b9537fdb73dc-full.jpg",
                "https://cdn1.imggmi.com/uploads/2019/10/18/b91eb9a510419e563861b9537fdb73dc-full.jpg"};
        String[] titles = {"5 in 1 Chicken Zinger Box",
                "Paneer Butter Masala",
                "Chicken Lollipop Masala", "Paneer Manchurian", "Non-Veg. Lemon & Coriander Soup"};
        String[] descriptions = {"Chicken zinger+hot wings [2 pieces]+veg strip [1 piece]+Pillsbury cookie cake+Pepsi [can]",
                "A spicy North Indian dish made from cottage cheese, cream, butter and select spices",
                "Chicken wings coated with batter of flour",
                "Deep-fried cottage cheese balls sautéed with ginger", "Meat shreds, lime juice and coriander"};
        String[] price = {"₹220", "₹530", "₹400", "₹790", "₹150"};
        boolean[] isHot = {true, false, true, true, false};
        for (int i = 0; i < imageUrls.length; i++) {
            FoodItem foodItem = new FoodItem(titles[i], descriptions[i], imageUrls[i], price[i], isHot[i]);
            //add food items
            recyclerViewItems.add(foodItem);
        }

        Footer footer = new Footer("Your diet is a bank account. Good food choices are good investments.",
                "Bethenny Frankel", "https://cdn1.imggmi.com/uploads/2019/10/18/b91eb9a510419e563861b9537fdb73dc-full.jpg");
        //add footer
        recyclerViewItems.add(footer);
        return recyclerViewItems;
    }
}
