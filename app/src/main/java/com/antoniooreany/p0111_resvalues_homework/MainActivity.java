package com.antoniooreany.p0111_resvalues_homework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private final static byte ICON_BLACK_48_DP_FLAG = 0;
    private final static byte ICON_GREY_48_DP_FLAG = 1;
    private final static byte ICON_BLACK_18_DP_FLAG = 2;
    private final static byte ICON_GREY_18_DP_FLAG = 3;
    private static final String TAG = "myFirstLogs";
    private Button button;
    private ImageView imageView;
    private byte buttonClickFlag = 0;
    private int leftMarginMaxValue;
    private int topMarginMaxValue;
    private int rightMarginMaxValue;
    private int bottomMarginMaxValue;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);

        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        int heightPixels = displayMetrics.heightPixels;
        int widthPixels = displayMetrics.widthPixels;
        float heightDp = heightPixels / density;
        float widhtDp = widthPixels / density;

        leftMarginMaxValue = (int) heightDp;
        topMarginMaxValue = (int) widhtDp;
        rightMarginMaxValue = (int) heightDp;
        bottomMarginMaxValue = (int) widhtDp;

        Log.d(TAG, "heightPixels = " + heightPixels);
        Log.d(TAG, "widthPixels = " + widthPixels);
        Log.d(TAG, "heightDp = " + heightDp);
        Log.d(TAG, "widhtDp = " + widhtDp);

        setImageViewMargins(imageView, leftMarginMaxValue, topMarginMaxValue, rightMarginMaxValue, bottomMarginMaxValue);
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * @param view is an object, in which setOnClickListener() method was invoked.
             */
            @Override
            public void onClick(View view) {
                switch (buttonClickFlag) {
                    case ICON_BLACK_48_DP_FLAG:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_android_grey600_48dp));
                        buttonClickFlag = ICON_GREY_48_DP_FLAG;
                        setImageViewMargins(imageView, leftMarginMaxValue, topMarginMaxValue, rightMarginMaxValue, bottomMarginMaxValue);
                        break;
                    case ICON_GREY_48_DP_FLAG:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_android_black_18dp));
                        buttonClickFlag = ICON_BLACK_18_DP_FLAG;
                        setImageViewMargins(imageView, leftMarginMaxValue, topMarginMaxValue, rightMarginMaxValue, bottomMarginMaxValue);
                        break;
                    case ICON_BLACK_18_DP_FLAG:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_android_grey600_18dp));
                        buttonClickFlag = ICON_GREY_18_DP_FLAG;
                        setImageViewMargins(imageView, leftMarginMaxValue, topMarginMaxValue, rightMarginMaxValue, bottomMarginMaxValue);
                        break;
                    case ICON_GREY_18_DP_FLAG:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_android_black_48dp));
                        buttonClickFlag = ICON_BLACK_48_DP_FLAG;
                        setImageViewMargins(imageView, leftMarginMaxValue, topMarginMaxValue, rightMarginMaxValue, bottomMarginMaxValue);
                        break;
                }
            }
        });
    }

    private void setImageViewMargins(ImageView imageView, int leftMarginMaxValue, int topMarginMaxValue, int rightMarginMaxValue, int bottomMarginMaxValue) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int leftMargin = (int) (Math.random() * leftMarginMaxValue);
            int topMargin = (int) (Math.random() * topMarginMaxValue);
            int rightMargin = (int) (Math.random() * rightMarginMaxValue);
            int bottomMargin = (int) (Math.random() * bottomMarginMaxValue);
            marginLayoutParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);
            Log.d(TAG, "leftMargin = " + leftMargin + "\n"
                    + "topMargin = " + topMargin + "\n"
                    + "rightMargin = " + rightMargin + "\n"
                    + "bottomMargin = " + bottomMargin + "\n");
        }
    }
}
