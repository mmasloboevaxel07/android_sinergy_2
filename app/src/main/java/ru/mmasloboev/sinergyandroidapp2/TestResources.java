package ru.mmasloboev.sinergyandroidapp2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class TestResources extends AppCompatActivity {

    private boolean isSubscribed = false;
    private View mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_resources);

        String profileName = "@matvei";
        setTitle("Профиль пользователя " + profileName);

        Button buttonSubscribe = findViewById(R.id.btnSubscribe);
        buttonSubscribe.setOnClickListener(view -> {
            if (isSubscribed) {
                Snackbar snackbar = Snackbar.make(view, "Вы точно хотите отписаться от " + profileName + "?", Snackbar.LENGTH_SHORT);
                snackbar.setAction("Да", view1 -> {
                    buttonSubscribe.setText("Подписаться");
                    buttonSubscribe.setBackgroundColor(getResources().getColor(R.color.not_subscribe_color));
                    isSubscribed = false;
                });
                snackbar.show();
            } else {
                buttonSubscribe.setText("Отписаться");
                buttonSubscribe.setBackgroundColor(getResources().getColor(R.color.subscribe_color));
                isSubscribed = true;
                Toast toast = Toast.makeText(getApplicationContext(), "Теперь вы подписаны на " + profileName, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        mainLayout = findViewById(R.id.main_layout);

        Button buttonChangeColor = findViewById(R.id.btnChangeColor);
        buttonChangeColor.setOnClickListener(view -> changeBackgroundColor());
    }

    private void changeBackgroundColor() {
        Random random = new Random();
        int color = android.graphics.Color.rgb(random.nextInt(256),random.nextInt(256), random.nextInt(256));
        mainLayout.setBackgroundColor(color);
    }
}