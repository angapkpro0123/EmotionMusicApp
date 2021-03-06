package com.example.emotionmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.wave.MultiWaveHeader;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.Calendar;

public class ChooseEmotionActivity extends AppCompatActivity {

    ImageView mainBackGround;
    ImageButton happyEarthEmotion, loveEarthEmotion, sadEarthEmotion, boringEarthEmotion, cryEarthEmotion, sickEarthEmotion, angryEarthEmotion;
    AbsoluteLayout mainScreen;
    LinearLayout questionTextLayout;
    TextView happyEarthEmotionText, loveEarthEmotionText, sadEarthEmotionText, boringEarthEmotionText, cryEarthEmotionText, sickEarthEmotionText, angryEarthEmotionText;

    TextView questionText;

    Animation chooseEmotionScreenAni;

    MultiWaveHeader waveHeader, waveFooter;

    String id_chude = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // code allow app to use full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_choose_emotion);

        castControl();
        setChooseEmotionScreenBackground();
        setControlAnimation();

        // Add click ani for button
        PushDownAnim.setPushDownAnimTo(happyEarthEmotion, loveEarthEmotion, sadEarthEmotion, boringEarthEmotion, cryEarthEmotion, sickEarthEmotion, angryEarthEmotion)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_RELEASE_DURATION)
                .setInterpolatorPush(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setInterpolatorRelease(PushDownAnim.DEFAULT_INTERPOLATOR);
    }

    @Override
    protected void onStart() {
        super.onStart();

        setChooseEmotionScreenBackground();
        onEmotionChooseListener();
    }

    @Override
    protected void onResume() {
        super.onResume();

        setChooseEmotionScreenBackground();
        onEmotionChooseListener();
    }

    @Override
    public void finish() {
        super.finish();

        // add animation when user back to previous screen
        Intent startMainActivity = new Intent(ChooseEmotionActivity.this, MainActivity.class);
        startActivity(startMainActivity);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    // cast all icon and textview to set animation
    public void castControl() {
        mainBackGround = (ImageView) findViewById(R.id.chooseEmotionMainBackGround);
        mainScreen = (AbsoluteLayout) findViewById(R.id.mainScreen);
        questionTextLayout = (LinearLayout) findViewById(R.id.questionLayout);

        happyEarthEmotion = (ImageButton) findViewById(R.id.happyEarthEmotion);
        happyEarthEmotionText = (TextView) findViewById(R.id.happyEmotionText);

        loveEarthEmotion = (ImageButton) findViewById(R.id.loveEarthEmotion);
        loveEarthEmotionText = (TextView) findViewById(R.id.loveEmotionText);

        sadEarthEmotion = (ImageButton) findViewById(R.id.sadEarthEmotion);
        sadEarthEmotionText = (TextView) findViewById(R.id.sadEmotionText);

        boringEarthEmotion = (ImageButton) findViewById(R.id.boringEarthEmotion);
        boringEarthEmotionText = (TextView) findViewById(R.id.boringEmotionText);

        cryEarthEmotion = (ImageButton) findViewById(R.id.cryEarthEmotion);
        cryEarthEmotionText = (TextView) findViewById(R.id.cryEmotionText);

        sickEarthEmotion = (ImageButton) findViewById(R.id.sickEarthEmotion);
        sickEarthEmotionText = (TextView) findViewById(R.id.sickEmotionText);

        angryEarthEmotion = (ImageButton) findViewById(R.id.angryEarthEmotion);
        angryEarthEmotionText = (TextView) findViewById(R.id.angryEmotionText);

//        waveHeader = (MultiWaveHeader) findViewById(R.id.headerWave);
        waveFooter = (MultiWaveHeader) findViewById(R.id.footerWave);
    }

    // set animation for all emotion icon and textview
    public void setControlAnimation() {
        //chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.choose_emotion_screen_back_ground_ani);
        //mainBackGround.startAnimation(chooseEmotionScreenAni);

        chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.choose_emotion_screen_headertext_ani);
        questionTextLayout.startAnimation(chooseEmotionScreenAni);

        chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.happy_icon_and_text_ani);
        happyEarthEmotion.startAnimation(chooseEmotionScreenAni);
        chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.happy_icon_and_text_ani);
        happyEarthEmotionText.startAnimation(chooseEmotionScreenAni);

        chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.love_emotion_and_text_ani);
        loveEarthEmotion.startAnimation(chooseEmotionScreenAni);
        chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.love_emotion_and_text_ani);
        loveEarthEmotionText.startAnimation(chooseEmotionScreenAni);

        chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.sad_icon_and_text_ani);
        sadEarthEmotion.startAnimation(chooseEmotionScreenAni);
        chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.sad_icon_and_text_ani);
        sadEarthEmotionText.startAnimation(chooseEmotionScreenAni);

        chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.boring_icon_and_text_ani);
        boringEarthEmotion.startAnimation(chooseEmotionScreenAni);
        chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.boring_icon_and_text_ani);
        boringEarthEmotionText.startAnimation(chooseEmotionScreenAni);

        chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.cry_icon_and_text_ani);
        cryEarthEmotion.startAnimation(chooseEmotionScreenAni);
        chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.cry_icon_and_text_ani);
        cryEarthEmotionText.startAnimation(chooseEmotionScreenAni);

        chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.sick_icon_and_text_ani);
        sickEarthEmotion.startAnimation(chooseEmotionScreenAni);
        chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.sick_icon_and_text_ani);
        sickEarthEmotionText.startAnimation(chooseEmotionScreenAni);

        chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.angry_icon_and_text_ani);
        angryEarthEmotion.startAnimation(chooseEmotionScreenAni);
        chooseEmotionScreenAni = AnimationUtils.loadAnimation(ChooseEmotionActivity.this, R.anim.angry_icon_and_text_ani);
        angryEarthEmotionText.startAnimation(chooseEmotionScreenAni);

        setQuestionTextBackground();

//        waveHeader.setVelocity(1);
//        waveHeader.setProgress(0.8F);
//        waveHeader.isRunning();
//        waveHeader.setGradientAngle(45);
//        waveHeader.setWaveHeight(40);
//        waveHeader.setStartColor(Color.RED);
//        waveHeader.setCloseColor(Color.CYAN);

        waveFooter.setVelocity(1);
        waveFooter.setProgress(0.9F);
        waveFooter.isRunning();
        waveFooter.setGradientAngle(45);
        waveFooter.setWaveHeight(40);
        waveFooter.setStartColor(Color.CYAN);
        waveFooter.setCloseColor(Color.rgb(23, 105, 255));
    }

    public void setQuestionTextBackground() {
        chooseEmotionScreenAni.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // set background for question text after finish all animation to make a square for emotion icon
                questionText = (TextView) findViewById(R.id.questionText);

                Bitmap mainBackgroundBmp = ((BitmapDrawable) mainBackGround.getDrawable()).getBitmap();
                Bitmap cropImg = Bitmap.createBitmap(mainBackgroundBmp, 0, 0, mainBackgroundBmp.getWidth(), mainBackgroundBmp.getHeight() - 940);

                questionText.setBackground(new BitmapDrawable(getResources(), cropImg));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    // check current day is which day of the werk to set the correct background
    public void setChooseEmotionScreenBackground() {
        switch (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
                mainBackGround.setImageResource(R.drawable.music_notes_background);
                break;
            case Calendar.TUESDAY:
                mainBackGround.setImageResource(R.drawable.music_word_background);
                break;
            case Calendar.WEDNESDAY:
                mainBackGround.setImageResource(R.drawable.feeling_girl_background);
                break;
            case Calendar.THURSDAY:
                mainBackGround.setImageResource(R.drawable.guitar_background);
                break;
            case Calendar.FRIDAY:
                mainBackGround.setImageResource(R.drawable.headphone_background);
                break;
            case Calendar.SATURDAY:
                mainBackGround.setImageResource(R.drawable.song_background);
                break;
            case Calendar.SUNDAY:
                mainBackGround.setImageResource(R.drawable.music_background);
                break;
        }
    }

    // function to check which icon uer chose and start music play screen
    @SuppressLint("ClickableViewAccessibility")
    public void onEmotionChooseListener() {
        happyEarthEmotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startMusicPlayScreen = new Intent(ChooseEmotionActivity.this, PlayMusicScreen.class);
                id_chude = "1";
                startMusicPlayScreen.putExtra("id_chude", id_chude);
                startActivity(startMusicPlayScreen);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        loveEarthEmotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startMusicPlayScreen = new Intent(ChooseEmotionActivity.this, PlayMusicScreen.class);
                id_chude = "2";
                startMusicPlayScreen.putExtra("id_chude", id_chude);
                startActivity(startMusicPlayScreen);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        sadEarthEmotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startMusicPlayScreen = new Intent(ChooseEmotionActivity.this, PlayMusicScreen.class);
                id_chude = "3";
                startMusicPlayScreen.putExtra("id_chude", id_chude);
                startActivity(startMusicPlayScreen);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


           boringEarthEmotion.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent startMusicPlayScreen = new Intent(ChooseEmotionActivity.this, PlayMusicScreen.class);
                   id_chude = "4";
                   startMusicPlayScreen.putExtra("id_chude", id_chude);
                   startActivity(startMusicPlayScreen);
                   overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
               }
        });

        cryEarthEmotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startMusicPlayScreen = new Intent(ChooseEmotionActivity.this, PlayMusicScreen.class);
                id_chude = "5";
                startMusicPlayScreen.putExtra("id_chude", id_chude);
                startActivity(startMusicPlayScreen);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        sickEarthEmotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startMusicPlayScreen = new Intent(ChooseEmotionActivity.this, PlayMusicScreen.class);
                id_chude = "6";
                startMusicPlayScreen.putExtra("id_chude", id_chude);
                startActivity(startMusicPlayScreen);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        angryEarthEmotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startMusicPlayScreen = new Intent(ChooseEmotionActivity.this, PlayMusicScreen.class);
                id_chude = "7";
                startMusicPlayScreen.putExtra("id_chude", id_chude);
                startActivity(startMusicPlayScreen);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
}
