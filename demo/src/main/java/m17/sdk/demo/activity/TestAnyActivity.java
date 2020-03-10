package m17.sdk.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.plattysoft.leonids.ParticleSystem;
import com.plattysoft.leonids.modifiers.ScaleModifier;

import m17.sdk.demo.R;
import m17.sdk.demo.utils.ThreadPool;

public class TestAnyActivity extends AppCompatActivity {

    private static int[] THEME_LIVE_ICON = new int[]{
            R.drawable.colorheart_1, R.drawable.colorheart_2, R.drawable.colorheart_3, R.drawable.colorheart_4, R.drawable.colorheart_5, R.drawable.colorheart_6, R.drawable.colorheart_7, R.drawable.colorheart_8,
            R.drawable.colorheart_9, R.drawable.colorheart_10, R.drawable.colorheart_11, R.drawable.colorheart_12, R.drawable.colorheart_13, R.drawable.colorheart_14, R.drawable.colorheart_15, R.drawable.colorheart_16,
            R.drawable.colorheart_17, R.drawable.colorheart_18, R.drawable.colorheart_19, R.drawable.colorheart_20, R.drawable.colorheart_21, R.drawable.colorheart_22, R.drawable.colorheart_23, R.drawable.colorheart_24,
            R.drawable.colorheart_25, R.drawable.colorheart_26, R.drawable.colorheart_27, R.drawable.colorheart_28};

    private long mNowSec;
    private View mView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_any);

        //mView = findViewById(R.id.layout_particle_animation);
        showTestAnimation();
    }

    private void showTestAnimation() {
        mNowSec = System.currentTimeMillis();
        ThreadPool.getInstance().execute(() -> {
            while (true) {
                if (System.currentTimeMillis() - mNowSec >= Math.random() * 200 + 300) {
                    mNowSec = System.currentTimeMillis();
                    TestAnyActivity.this.runOnUiThread(() -> {
                        showParticleAnimation(this, mView);
                    });
                }
            }
        });
    }

    public void showParticleAnimation(Activity activity, View view) {
        if (activity == null) return;

        float initialValue = (float) 0.3 + (float) (Math.random() * 0.2);
        float finalValue = (float) 0.4 + (float) (Math.random() * 0.2);
        int startMillis = 0;
        int endMillis = 500;
        float acceleration = 0.000003f;
        int fadeOutTime = 500;

        ScaleModifier scaleModifier = new ScaleModifier(initialValue, finalValue, startMillis, endMillis, new LinearInterpolator());
        ParticleSystem particle = new ParticleSystem(
                activity,
                1,
                THEME_LIVE_ICON[(int) (Math.random() * THEME_LIVE_ICON.length)], 3000);

        particle.setSpeedByComponentsRange(-0.02f, 0.02f, -0.2f, -0.1f);
        particle.setAcceleration(acceleration, 90);
        particle.setInitialRotationRange(-20, 20);
        particle.setRotationSpeed(-20 + ((int) (Math.random() * 40)));
        particle.setFadeOut(fadeOutTime);
        particle.addModifier(scaleModifier);
        //particle.addModifier(new AlphaModifier(255, 0, 0, 1500, new LinearInterpolator()));
        particle.oneShot(view, 1);
    }


}
