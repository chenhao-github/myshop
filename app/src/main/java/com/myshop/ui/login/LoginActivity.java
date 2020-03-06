package com.myshop.ui.login;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.myshop.MainActivity;
import com.myshop.R;
import com.myshop.base.BaseActivity;
import com.myshop.interfaces.login.LoginConstract;
import com.myshop.model.bean.LoginBean;
import com.myshop.presenter.login.LoginPresenter;
import com.myshop.ui.regist.RegistActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginConstract.Presenter> implements LoginConstract.View {
    @BindView(R.id.et_name)
    EditText etNickName;
    @BindView(R.id.et_pw)
    EditText etPw;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginConstract.Presenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {

    }

    //绑定点击监听
    @OnClick({R.id.btn_login,R.id.btn_regist})
    public void onBtnClick(View view){
        if (view.getId() == R.id.btn_login) {
            login();
        }else {
            startActivity(new Intent(LoginActivity.this, RegistActivity.class));
        }
    }

    private void login() {
        String nickname = etNickName.getText().toString();
        String pw = etPw.getText().toString();
        if(!TextUtils.isEmpty(nickname) && !TextUtils.isEmpty(pw)){
            presenter.login(nickname,pw);
        }else {
            showTips("不能为空!");
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    public void loginRetrun(LoginBean result) {
        if(result.getData().getCode() == 200){
            startActivity(new Intent(this, MainActivity.class));
        }else {
            showTips(result.getData().getMsg());
        }
    }
    
}
