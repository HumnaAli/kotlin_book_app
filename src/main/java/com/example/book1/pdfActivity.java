package com.example.book1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class pdfActivity extends AppCompatActivity {

    PDFView pdfView;
    Button toggleNightModeButton;
    ImageView previousPageButton;
    ImageView nextPageButton;
    ImageView homeButton; // Add ImageView for home button
    boolean isNightMode = false;
    int pageNumber = 0;
    View backgroundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        // Get the page number from intent extra
        pageNumber = getIntent().getIntExtra("pageNumber", 0);

        pdfView = findViewById(R.id.pdfshow);
        toggleNightModeButton = findViewById(R.id.toggleNightModeButton);
        previousPageButton = findViewById(R.id.previousPageButton);
        nextPageButton = findViewById(R.id.nextPageButton);
        backgroundView = findViewById(R.id.backgroundView);

        // Initialize home button
        homeButton = findViewById(R.id.homeButton);

        toggleNightModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleNightMode();
            }
        });

        previousPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPreviousPage();
            }
        });

        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextPage();
            }
        });

        // Set OnClickListener for home button
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the home page (MainActivity)
                startActivity(new Intent(pdfActivity.this, MainActivity.class));
                finish(); // Finish this activity to prevent going back to it when pressing back button
            }
        });

        loadPdf();
    }

    private void loadPdf() {
        pdfView.fromAsset("kotlin.pdf")
                .defaultPage(pageNumber) // Load from specified page number
                //.scrollHandle(new DefaultScrollHandle(this))
                .pageFling(true)
                .swipeHorizontal(true)
                .nightMode(isNightMode)
                .spacing(10)
                .pageFitPolicy(FitPolicy.WIDTH)
                .load();

        // Set background color based on mode
        if (isNightMode) {
            backgroundView.setBackgroundColor(Color.BLACK);
            toggleNightModeButton.setText(R.string.light_mode);
        } else {
            backgroundView.setBackgroundColor(Color.WHITE);
            toggleNightModeButton.setText(R.string.night_mode);
        }
    }

    private void toggleNightMode() {
        isNightMode = !isNightMode;
        loadPdf();
    }

    private void goToPreviousPage() {
        pdfView.jumpTo(pdfView.getCurrentPage() - 1, true);
    }

    private void goToNextPage() {
        pdfView.jumpTo(pdfView.getCurrentPage() + 1, true);
    }
}