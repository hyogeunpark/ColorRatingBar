package hyogeun.github.com.colorratingbarlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatRatingBar;
import android.util.AttributeSet;

/**
 * Created by hyogeun.park on 2017. 6. 1..
 */

public class ColorRatingBar extends AppCompatRatingBar {

    public ColorRatingBar(Context context) {
        super(context);
    }

    public ColorRatingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ColorRatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ColorRatingBar, defStyleAttr, 0);
        int progressColor = a.getColor(R.styleable.ColorRatingBar_progress_color, ContextCompat.getColor(context, R.color.colorPrimary));
//        int halfColor = a.getColor(R.styleable.ColorRatingBar_half_color, ContextCompat.getColor(context, R.color.colorAccent));
        int emptyColor = a.getColor(R.styleable.ColorRatingBar_empty_color, ContextCompat.getColor(context, R.color.colorAccent));

        LayerDrawable stars = (LayerDrawable) getProgressDrawable();
        // Filled stars
        setRatingStarColor(DrawableCompat.wrap(stars.getDrawable(2)), progressColor);
        // Half filled stars
        setRatingStarColor(DrawableCompat.wrap(stars.getDrawable(1)), progressColor);
        // Empty stars
        setRatingStarColor(DrawableCompat.wrap(stars.getDrawable(0)), emptyColor);

    }

    private void setRatingStarColor(Drawable drawable, @ColorInt int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            DrawableCompat.setTint(drawable, color);
        } else {
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public void setRatingProgressColor(int resId) {
        LayerDrawable stars = (LayerDrawable) getProgressDrawable();
        // Filled stars
        setRatingStarColor(DrawableCompat.wrap(stars.getDrawable(2)), ContextCompat.getColor(getContext(), resId));
    }

    public void setRatingHalfColor(int resId) {
        LayerDrawable stars = (LayerDrawable) getProgressDrawable();
        // Half filled stars
        setRatingStarColor(DrawableCompat.wrap(stars.getDrawable(1)), ContextCompat.getColor(getContext(), resId));
    }

    public void setRatingEmptyColor(int resId) {
        LayerDrawable stars = (LayerDrawable) getProgressDrawable();
        // Half filled stars
        setRatingStarColor(DrawableCompat.wrap(stars.getDrawable(0)), ContextCompat.getColor(getContext(), resId));
    }
}
