package shubham.com.customviewexample;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lovelyView) LovelyView mLovelyView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    public void btnPressed(View view) {
        mLovelyView.setCircleColor(Color.GREEN);
        mLovelyView.setLabelColor(Color.MAGENTA);
        mLovelyView.setLabelText("Help");
    }
}
