package com.expendive.jazbapoint.domain.api;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.expendive.jazbapoint.R;
import com.expendive.jazbapoint.domain.mock.FakeWebServer;
import com.expendive.jazbapoint.models.Category;
import com.expendive.jazbapoint.models.Product;
import com.expendive.jazbapoint.ui.activities.ECartHomeActivity;
import com.expendive.jazbapoint.ui.adapter.CategoryListAdapter;
import com.expendive.jazbapoint.ui.adapter.CategoryListAdapter.OnItemClickListener;
import com.expendive.jazbapoint.ui.fragments.ProductOverviewFragment;
import com.expendive.jazbapoint.util.AppConstants;
import com.expendive.jazbapoint.util.Utils;
import com.expendive.jazbapoint.util.Utils.AnimationType;

import java.util.ArrayList;
import java.util.List;

public class CategoryLoaderTask extends AsyncTask<String, Void, Void> {

    private Context context;
    private View rootView;
    private View scrollView;

    private RecyclerView computingRecyclerView;
    private RecyclerView accessoriesRecyclerView;
    private RecyclerView phonesTabletsRecyclerView;
    private RecyclerView groceriesRecyclerView;

    private List<Product> computers = new ArrayList<>();
    private List<Product> accessories = new ArrayList<>();
    private List<Product> phonesTablets = new ArrayList<>();
    private List<Product> groceries = new ArrayList<>();

    public CategoryLoaderTask(View scrollView, View rootView, Context context) {
        this.rootView = rootView;
        this.context = context;
        this.scrollView = scrollView;
        computingRecyclerView = rootView.findViewById(R.id.computing_recyclerView);
        accessoriesRecyclerView = rootView.findViewById(R.id.accessories_recyclerView);
        phonesTabletsRecyclerView = rootView.findViewById(R.id.phones_tablets_recyclerView);
        groceriesRecyclerView = rootView.findViewById(R.id.grocers_recyclerView);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (null != ((ECartHomeActivity) context).getProgressBar())
            ((ECartHomeActivity) context).getProgressBar().setVisibility(
                    View.VISIBLE);
        scrollView.setVisibility(View.GONE);
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);

        scrollView.setVisibility(View.VISIBLE);

        if (null != ((ECartHomeActivity) context).getProgressBar())
            ((ECartHomeActivity) context).getProgressBar().setVisibility(
                    View.GONE);

        if (rootView != null) {
            CategoryListAdapter simpleRecyclerAdapter = new CategoryListAdapter(context);
            computingRecyclerView.setAdapter(simpleRecyclerAdapter);
            simpleRecyclerAdapter
                    .SetOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            AppConstants.INSTANCE.setCURRENT_CATEGORY(position);
                            Utils.switchFragmentWithAnimation(
                                    R.id.frag_container,
                                    new ProductOverviewFragment(),
                                    ((ECartHomeActivity) context), null,
                                    AnimationType.SLIDE_LEFT);
                        }
                    });
        }
    }

    @Override
    protected Void doInBackground(String... params) {
//        computers = new ProductFetcher(ProductFetcher.COMPUTING_CATEGORY).getProducts();
//        accessories = new ProductFetcher(ProductFetcher.ACCESSORIES_CATEGORY).getProducts();
//        phonesTablets = new ProductFetcher(ProductFetcher.PHONES_TABLETS_CATEGORY).getProducts();
//        groceries = new ProductFetcher(ProductFetcher.GROCERS_CATEGORY).getProducts();
        List<Category> list = new ProductFetcher("").getCategories();
        for (Category cat : list)
            System.out.println(cat);
        FakeWebServer.getFakeWebServer().addCategory();
        return null;
    }
}