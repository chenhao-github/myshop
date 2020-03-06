package com.myshop.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter {
    public Context mContext;
    public List<T> mDatas;

    public BaseAdapter(Context context, List<T> datas) {
        mContext = context;
        mDatas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext,getLayout(),null);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BaseViewHolder h = (BaseViewHolder)holder;
        T t = mDatas.get(position);
        bindData(h,t);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
    //获取条目布局
    public abstract int getLayout();
    //把数据绑定到条目组件上
    public abstract void bindData(BaseViewHolder holder,T data);
    //刷新数据
    public void updataListClearAddMore(List<T> list){
        mDatas.clear();
        mDatas.addAll(list);
    }
    //累加数据
    public void updataListAddMore(List<T> list){
        mDatas.addAll(list);
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder{
        SparseArray views ;//通过容器收集组件,用消耗内存换每次的findviewbyid
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            views = new SparseArray();
        }

        public View getViewById(int id){
            View view = (View) views.get(id);
            if(view == null){
                view = itemView.findViewById(id);
                views.append(id,view);
            }
            return view;
        }
    }


}
