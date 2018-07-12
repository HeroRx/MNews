package com.gzucm.mnews.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gzucm.mnews.R;
import com.gzucm.mnews.di.component.DaggerNewsComponent;
import com.gzucm.mnews.di.module.NewsModule;
import com.gzucm.mnews.mvp.contract.NewsContract;
import com.gzucm.mnews.mvp.presenter.NewsPresenter;
import com.gzucm.mnews.mvp.ui.adapter.DailyListAdapter;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class NewsFragment extends BaseFragment<NewsPresenter> implements NewsContract.View{

    @BindView(R.id.sr_news)
    RefreshLayout mSmartRefreshLayout;
    @BindView(R.id.rv_news)
    RecyclerView mRecyclerView;



    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerNewsComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .newsModule(new NewsModule(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    private void initSmartRefreshLayout() {
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresenter.cleanData();
                mPresenter.getLatestData();
                mSmartRefreshLayout.finishRefresh(1200);
            }
        });
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        Log.i("MNews--",""+ "获取数据");

        mPresenter.getLatestData();

        initSmartRefreshLayout();
        initLoadMore();

    }

    private void initLoadMore() {

        mSmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPresenter.getBeforeLoadMoreNews();
                mSmartRefreshLayout.finishLoadMore(1200);
            }
        });
    }

    /**
     * 通过此方法可以使 Fragment 能够与外界做一些交互和通信, 比如说外部的 Activity 想让自己持有的某个 Fragment 对象执行一些方法,
     * 建议在有多个需要与外界交互的方法时, 统一传 {@link Message}, 通过 what 字段来区分不同的方法, 在 {@link #setData(Object)}
     * 方法中就可以 {@code switch} 做不同的操作, 这样就可以用统一的入口方法做多个不同的操作, 可以起到分发的作用
     * <p>
     * 调用此方法时请注意调用时 Fragment 的生命周期, 如果调用 {@link #setData(Object)} 方法时 {@link Fragment#onCreate(Bundle)} 还没执行
     * 但在 {@link #setData(Object)} 里却调用了 Presenter 的方法, 是会报空的, 因为 Dagger 注入是在 {@link Fragment#onCreate(Bundle)} 方法中执行的
     * 然后才创建的 Presenter, 如果要做一些初始化操作,可以不必让外部调用 {@link #setData(Object)}, 在 {@link #initData(Bundle)} 中初始化就可以了
     * <p>
     * Example usage:
     * <pre>
     * public void setData(@Nullable Object data) {
     *     if (data != null && data instanceof Message) {
     *         switch (((Message) data).what) {
     *             case 0:
     *                 loadData(((Message) data).arg1);
     *                 break;
     *             case 1:
     *                 refreshUI();
     *                 break;
     *             default:
     *                 //do something
     *                 break;
     *         }
     *     }
     * }
     *
     * // call setData(Object):
     * Message data = new Message();
     * data.what = 0;
     * data.arg1 = 1;
     * fragment.setData(data);
     * </pre>
     *
     * @param data 当不需要参数时 {@code data} 可以为 {@code null}
     */
    @Override
    public void setData(@Nullable Object data) {
    }

    @Override
    public void showLoading() {
        mSmartRefreshLayout.autoRefresh();
    }

    @Override
    public void hideLoading() {

        mSmartRefreshLayout.finishRefresh(1200);
    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {

    }
    
    @Override
    public void setRecyclerAdapter(DailyListAdapter adapter) {


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        View headerView = getLayoutInflater().inflate(R.layout.header_daily_list_hot, (ViewGroup) mRecyclerView.getParent(), false);
        TextView textView = (TextView) headerView.findViewById(R.id.item_time);
        textView.setText("今日热闻");

        adapter.addHeaderView(headerView,1);
        mRecyclerView.setAdapter(adapter);

    }



}
