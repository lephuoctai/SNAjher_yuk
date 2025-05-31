package com.todo.snajher_yuk;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class SignUpPage extends AppCompatActivity {
    private void linkText(View view, String src, ArrayList<String> spans, int idColor, View.OnClickListener listener) {
        MaterialTextView terms = (MaterialTextView) view;
        SpannableString spannableString = new SpannableString(src);
        int color = ContextCompat.getColor(this, idColor);

        for(String span : spans) {
            int start = src.indexOf(span);
            int end = start + span.length();

            spannableString.setSpan(
                    new ForegroundColorSpan(color),
                    start,
                    end,
                    spannableString.SPAN_EXCLUSIVE_EXCLUSIVE
            );
        };

        terms.setOnClickListener(listener);
        terms.setText(spannableString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signUpPage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        String src = "By signing up you accept the Terms of Service and Privacy Policy";
        MaterialTextView terms = findViewById(R.id.terms_sign_up);
        int idColor = R.color.Royal_Blue;
        ArrayList<String> spans = new ArrayList<String>();
            spans.add("Terms of Service");
            spans.add("Privacy Policy");
        linkText(terms, src, spans, idColor, v -> {
        });

        MaterialTextView view = findViewById(R.id.loginLink);
        src = "Already have an account? Login";
        idColor = R.color.Royal_Blue;
        ArrayList<String> spans2 = new ArrayList<String>();
            spans2.add("Login");
        linkText(view, src, spans2, idColor, v -> {
            startActivity(new Intent(this, LoginPage.class));
        });

    }
}