package me.ivt.com.ui.parallax;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/**
 * desc:
 */
public class ParallaxLayoutInflater extends LayoutInflater {
    
    protected ParallaxLayoutInflater(Context context) {
        super(context);
    }
    
    private LayoutInflater mLayoutInflater;
    
    protected ParallaxLayoutInflater(LayoutInflater original, Context newContext) {
        super(original, newContext);
        mLayoutInflater = original;
    }
    
    @Override
    public LayoutInflater cloneInContext(Context newContext) {
        return new ParallaxLayoutInflater(this, newContext);
    }
    
    //自定义创建视图工厂类
    class ParallaxFactory implements Factory {
        
        @Override
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            //1.实例化里面的view
            View view = null;
            if (view == null) {
                view = createView(name, context, attrs);
            }
            
            return null;
        }
        
        private View createView(String name, Context context, AttributeSet attrs) {
            try {
                if (name.contains(".")) {
                    mLayoutInflater.createView(name,null,attrs);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return  null; 
        };
    }
}
