package com.myshop.ui.regist;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.myshop.R;
import com.myshop.base.BaseActivity;
import com.myshop.interfaces.regist.RegistConstract;
import com.myshop.model.bean.RegistBean;
import com.myshop.presenter.regist.RegistPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class RegistActivity extends BaseActivity<RegistConstract.Presenter> implements RegistConstract.View {

    @BindView(R.id.et_name)
    EditText etNickName;
    @BindView(R.id.et_pw)
    EditText etPw;

    @Override
    protected int getLayout() {
        return R.layout.activity_regist;
    }

    @Override
    protected RegistConstract.Presenter createPresenter() {
        return new RegistPresenter();
    }

    @Override
    protected void initView() {

    }

    public void onBtnClick(View view){
        regist();
    }

    @OnClick(R.id.btn_regist)
    public void regist() {
        String nickname = etNickName.getText().toString();
        String pw = etPw.getText().toString();
        if(!TextUtils.isEmpty(nickname) && !TextUtils.isEmpty(pw)){
            presenter.regist(nickname,pw,"111111");
        }else {
            showTips("不能为空!");
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    public void registReturn(RegistBean result) {
        if(result.getErrno() == 0){
            showTips("注册成功");
            finish();
        }else {
            showTips(result.getErrmsg());
        }
    }
}
