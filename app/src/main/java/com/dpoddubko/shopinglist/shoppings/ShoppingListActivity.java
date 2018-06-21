package com.dpoddubko.shopinglist.shoppings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.dpoddubko.shopinglist.R;
import com.dpoddubko.shopinglist.app.App;
import com.dpoddubko.shopinglist.dao.Shopping;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class ShoppingListActivity extends AppCompatActivity implements View, ICardClickListener {

    @Inject
    ShoppingListPresenter presenter;

    private ShoppingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        ButterKnife.bind(this);
        adapter = new ShoppingAdapter(this);
        App.get(this).component().inject(this);
        init();
    }

    @OnClick(R.id.delete_btn)
    public void submitDelete(android.view.View view) {
        if (!adapter.data.isEmpty())
            presenter.delete(adapter.data.get(0));
    }

    @OnCheckedChanged(R.id.complete_chb)
    void onGenderSelected(CompoundButton button, boolean checked) {
        if (!adapter.data.isEmpty())
            presenter.setAllAsCompleted(checked);
    }

    @OnClick(R.id.fab)
    public void submit(android.view.View view) {
        Shopping s = new Shopping();
        s.setTitle("title");
        s.setContent("content");
        s.setCompleted(false);
        presenter.insert(s);
    }

    private void init() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_activity);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        presenter.attachView(this);
        presenter.viewIsReady();
    }

    @Override
    public void showList(List<Shopping> shoppings) {
        adapter.setData(shoppings);
    }

    @Override
    public void showError(Throwable t) {
        Toast.makeText(this, t.getCause().getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    @Override
    public void onCheckClicked(int id, boolean b) {
        presenter.setCompleted(id, b);
    }

    @Override
    public void onCardClicked(int id) {
        Toast.makeText(this, "clicked cadrd with item id = " + id, Toast.LENGTH_SHORT)
                .show();
    }
}
