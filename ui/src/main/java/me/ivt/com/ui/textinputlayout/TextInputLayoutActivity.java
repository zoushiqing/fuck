package me.ivt.com.ui.textinputlayout;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;

import me.ivt.com.ui.R;

public class TextInputLayoutActivity extends AppCompatActivity {
    TextInputLayout mTextInputLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);
        mTextInputLayout = findViewById(R.id.text_input_layout);
        //检测长度应该低于六位数
        mTextInputLayout.setHelperText("生讷讷呢");
        mTextInputLayout.getEditText().addTextChangedListener(new MinelengthTextWatcher("长度为六的判断", mTextInputLayout));
        //开启计数
//        mTextInputLayout.setCounterEnabled(true);
//        mTextInputLayout.setCounterMaxLength(20);//最大值
    }
    
    class MinelengthTextWatcher implements TextWatcher {
        private String errorText;
        private TextInputLayout mTextInputLayout;
        
        public MinelengthTextWatcher(String errorText, TextInputLayout textInputLayout) {
            this.errorText = errorText;
            mTextInputLayout = textInputLayout;
        }
        
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            
        }
        
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            
        }
        
        @Override
        public void afterTextChanged(Editable s) {
            //文字改变后回调
            if (mTextInputLayout.getEditText().getText().toString().length()<6) {
                mTextInputLayout.setErrorEnabled(false);
            }else {
                mTextInputLayout.setErrorEnabled(true);
                mTextInputLayout.setError(errorText);
            }
        }
    }
}
