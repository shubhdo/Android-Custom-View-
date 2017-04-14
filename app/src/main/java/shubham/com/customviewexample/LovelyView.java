package shubham.com.customviewexample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HP-User on 4/14/2017.
 */


public class LovelyView extends View {
    private int circleCol, labelCol;
    private String circleText;
    private Paint circlePaint;
    public LovelyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        circlePaint=new Paint();
        TypedArray a=context.getTheme().obtainStyledAttributes(attrs,R.styleable.LovelyView,0,0);
        try {
            //get the text and colors specified using the names in attrs.xml
            circleText = a.getString(R.styleable.LovelyView_circleLabel);
            circleCol = a.getInteger(R.styleable.LovelyView_circleColor, 0);//0 is default
            labelCol = a.getInteger(R.styleable.LovelyView_labelColor, 0);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewWidthHalf=this.getMeasuredWidth()/2;
        int viewHeightHalf=this.getMeasuredHeight()/2;
        int radius = 0;
        if(viewWidthHalf>viewHeightHalf)
            radius=viewHeightHalf-10;
        else
            radius=viewWidthHalf-10;
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(circleCol);
        canvas.drawCircle(viewWidthHalf,viewHeightHalf,radius,circlePaint);
        circlePaint.setColor(labelCol);
        circlePaint.setTextAlign(Paint.Align.CENTER);
        circlePaint.setTextSize(50);
        canvas.drawText(circleText,viewWidthHalf,viewHeightHalf,circlePaint);


    }
    public int getCircleColor(){
        return circleCol;
    }

    public int getLabelColor(){
        return labelCol;
    }

    public String getLabelText(){
        return circleText;
    }
    public void setCircleColor(int newColor) {
        circleCol=newColor;
        invalidate();
        requestLayout();

    }
    public void setLabelColor(int newColor){
        //update the instance variable
        labelCol=newColor;
        //redraw the view
        invalidate();
        requestLayout();
    }
    public void setLabelText(String newLabel){
        //update the instance variable
        circleText=newLabel;
        //redraw the view
        invalidate();
        requestLayout();
    }

}
