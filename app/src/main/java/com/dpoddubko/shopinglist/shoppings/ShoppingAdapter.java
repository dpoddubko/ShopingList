package com.dpoddubko.shopinglist.shoppings;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.dpoddubko.shopinglist.R;
import com.dpoddubko.shopinglist.dao.Shopping;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ShoppingHolder> {
    @Inject
    ShoppingListPresenter presenter;

    ICardClickListener listener;

    List<Shopping> data = new ArrayList<>();

    public ShoppingAdapter(ICardClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ShoppingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.purchase_card, parent, false);
        return new ShoppingHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(ShoppingHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Shopping> users) {
        data.clear();
        data.addAll(users);
        notifyDataSetChanged();
    }

    static class ShoppingHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.shopping_title)
        TextView title;
        @BindView(R.id.shopping_content)
        TextView content;
        @BindView(R.id.shopping_photo)
        ImageView photo;
        @BindView(R.id.complete_chb_item)
        CheckBox complete;
        private ICardClickListener listener;
        private View v;

        public ShoppingHolder(View v, ICardClickListener listener) {
            super(v);
            ButterKnife.bind(this, v);
            this.listener = listener;
            this.v = v;
        }

        void bind(Shopping shopping) {
            title.setText(String.format("id: %s, title: %s", shopping.getId(), shopping.getTitle()));
            content.setText(String.format("content: %s, isCompleted: %s",
                    shopping.getContent(), shopping.isCompleted()));

            complete.setOnCheckedChangeListener(
                    (compoundButton, b) -> listener.onCheckClicked(shopping.getId(), b));
            v.setOnClickListener(view -> listener.onCardClicked(shopping.getId()));
        }
    }

}
