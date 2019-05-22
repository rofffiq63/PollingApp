package under.the.bridge.pollingapp.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import under.the.bridge.pollingapp.R;
import under.the.bridge.pollingapp.injection.AppComponent;
import under.the.bridge.pollingapp.injection.DaggerFeedsViewComponent;
import under.the.bridge.pollingapp.injection.FeedsViewModule;
import under.the.bridge.pollingapp.model.PollingData;
import under.the.bridge.pollingapp.presenter.FeedsPresenter;
import under.the.bridge.pollingapp.presenter.loader.PresenterFactory;
import under.the.bridge.pollingapp.view.FeedsView;

public final class FeedsFragment extends BaseFragment<FeedsPresenter, FeedsView> implements FeedsView {
    @Inject
    PresenterFactory<FeedsPresenter> mPresenterFactory;
    @BindView(R.id.pollList)
    RecyclerView pollList;
    Unbinder unbinder;

    PollingAdapter pollingAdapter;

    // Your presenter is available using the mPresenter variable

    public FeedsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feeds, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Your code here
        // Do not call mPresenter from here, it will be null! Wait for onStart
    }

    @Override
    public void onStart() {
        super.onStart();
        ((HomeActivity) getContext()).getPolls();
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerFeedsViewComponent.builder()
                .appComponent(parentComponent)
                .feedsViewModule(new FeedsViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<FeedsPresenter> getPresenterFactory() {
        return mPresenterFactory;
    }

    public void dataReady(PollingData response) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pollList.setLayoutManager(linearLayoutManager);
        pollList.setAdapter(new PollingAdapter(response.getData()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public class PollingAdapter extends RecyclerView.Adapter<PollingAdapter.ViewHolder> {

        List<PollingData.DataBean> dataBeans;

        public PollingAdapter(List<PollingData.DataBean> dataBean) {
            this.dataBeans = dataBean;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_polls, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.bind(dataBeans.get(i));
        }

        @Override
        public int getItemCount() {
            return dataBeans.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.cardView)
            CardView cardView;
            @BindView(R.id.textView)
            TextView textView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }

            public void bind(PollingData.DataBean dataBean) {
                textView.setText(dataBean.getTitle());
            }
        }
    }
}
