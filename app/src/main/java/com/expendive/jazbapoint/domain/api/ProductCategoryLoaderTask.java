package com.expendive.jazbapoint.domain.api;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.expendive.jazbapoint.OneLeggedApi10;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Request;
import org.scribe.model.Request;
import org.scribe.model.Response;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import java.util.List;

import static com.expendive.jazbapoint.domain.api.NetworkConstantsKt.BASE_URL;
import static com.expendive.jazbapoint.domain.api.NetworkConstantsKt.CONSUMER_KEY;
import static com.expendive.jazbapoint.domain.api.NetworkConstantsKt.CONSUMER_SECRET;
import static com.expendive.jazbapoint.domain.api.NetworkConstantsKt.PRODUCTS_RETRIEVAL_URL;

public class ProductCategoryLoaderTask extends AsyncTask<String, Void, Void> {

    private static final int NUMBER_OF_COLUMNS = 2;
    private Context context;
    private RecyclerView recyclerView;

    public ProductCategoryLoaderTask(RecyclerView listView, Context context) {
        this.recyclerView = listView;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        if (null != ((ECartHomeActivity) context).getProgressBar())
            ((ECartHomeActivity) context).getProgressBar().setVisibility(
                    View.VISIBLE);
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);

        if (null != ((ECartHomeActivity) context).getProgressBar())
            ((ECartHomeActivity) context).getProgressBar().setVisibility(
                    View.GONE);

        if (recyclerView != null) {
            CategoryListAdapter simpleRecyclerAdapter = new CategoryListAdapter(
                    context);
            recyclerView.setAdapter(simpleRecyclerAdapter);
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
        OAuthService service = new ServiceBuilder().provider(OneLeggedApi10.class)
                .apiKey(CONSUMER_KEY)
                .apiSecret(CONSUMER_SECRET)
                .signatureType(SignatureType.QueryString)
                .debug()
                .build();
        OAuthRequest request = new OAuthRequest(Verb.GET, PRODUCTS_RETRIEVAL_URL + "/1648");
        service.signRequest(new Token("", ""), request);
        Response response = request.send();
        if (response.isSuccessful()) {
            String part = response.getBody().substring(3934);
            System.out.println(response.getBody());
            System.out.println(part);
            Gson gson = new Gson();
            Product product = gson.fromJson(response.getBody(), Product.class);
            System.out.println(product);
//            List<Category> categ = gson.fromJson(response.getBody(), new TypeToken<List<Category>>(){}.getType());
//            for (Category cat : categ) {
//                System.out.println(cat);
//            }
        }

        FakeWebServer.getFakeWebServer().addCategory();
        return null;
    }
}