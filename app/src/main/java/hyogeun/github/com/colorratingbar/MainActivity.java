package hyogeun.github.com.colorratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hyogeun.github.com.colorratingbarlib.ColorRatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ColorRatingBar colorRatingBar = new ColorRatingBar(this);
        colorRatingBar.setRatingProgressColor(R.color.colorPrimary);
        colorRatingBar.setRatingEmptyColor(R.color.colorAccent);
        colorRatingBar.setRating(3.0f);
    }
}
