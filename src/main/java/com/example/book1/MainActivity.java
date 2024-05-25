package com.example.book1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.book1.pdfActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView chapterListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chapterListView = findViewById(R.id.chapterListView);

        // Define your chapter titles
        List<String> chapters = new ArrayList<>();
        chapters.add("Main Page");
        chapters.add("Table of Content");
        chapters.add("About the Author");
        chapters.add("About the Technical Reviewer");
        chapters.add("Introduction");
        chapters.add("CHAPTER 1:Your First Kotlin Application: Hello Kotlin");
        chapters.add("CHAPTER 2:Classes and Objects:Object Orientation Philosophy");
        chapters.add("CHAPTER 3:Classes at Work:Properties and Functions");
        chapters.add("CHAPTER 4:Classes and Objects:Extended Features");
        chapters.add("CHAPTER 5 Expressions: Operations on Data");
        chapters.add("CHAPTER 6:Comments in Kotlin Files");
        chapters.add("CHAPTER 7:Structural Constructs");
        chapters.add("CHAPTER 8:Exceptions: If Something Goes Wrong");
        chapters.add("CHAPTER 9:Data Containers");
        chapters.add("CHAPTER 10:True, False, and Undecided: Nullability");
        chapters.add("CHAPTER 11:Handling Equality");
        chapters.add("CHAPTER 12:Back to Math: Functional Programming");
        chapters.add("CHAPTER 13:About Type Safety:Generics");
        chapters.add("CHAPTER 14:Adding Hints:Annotations");
        chapters.add("CHAPTER 15:Using the Java and Kotlin APIs");
        chapters.add("CHAPTER 16:The Collections API");
        chapters.add("CHAPTER 17:More APIs");
        chapters.add("CHAPTER 18:Working in Parallel:Multithreading");
        chapters.add("CHAPTER 19:Using External Libraries");
        chapters.add("CHAPTER 20:XML and JSON");
        chapters.add("Appendix");
        chapters.add("Index");
        // Add more chapters as needed

        // Create an adapter for the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chapters);

        // Set the adapter to the ListView
        chapterListView.setAdapter(adapter);

        // Set item click listener for the ListView
        chapterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected chapter title
                String chapterTitle = (String) parent.getItemAtPosition(position);
                // Get the page number for the selected chapter
                int pageNumber = getPageNumberForChapter(chapterTitle);
                // Open PDFActivity with the selected page number
                openPdfActivity(pageNumber);
            }
        });
    }

    // Method to get the page number for a given chapter title
    private int getPageNumberForChapter(String chapterTitle) {
        // This is a simplified example, you need to replace it with your actual implementation
        switch (chapterTitle) {
            case "Main Page":
                return 0;
            case "Table of Content":
                return 4;
            case "About the Author":
                return 16;
            case "About the Technical Reviewer":
                return 17;
            case "Introduction":
                return 18;
            case "CHAPTER 1:Your First Kotlin Application: Hello Kotlin":
                return 22;
            case "CHAPTER 2:Classes and Objects:Object Orientation Philosophy":
                return 36;
            case "CHAPTER 3:Classes at Work:Properties and Functions":
                return 89;
            case "CHAPTER 4:Classes and Objects:Extended Features":
                return 133;
            case "CHAPTER 5 Expressions: Operations on Data":
                return 156;
            case "CHAPTER 6:Comments in Kotlin Files":
                return 173;
            case "CHAPTER 7:Structural Constructs":
                return 188;
            case "CHAPTER 8:Exceptions: If Something Goes Wrong":
                return 201;
            case "CHAPTER 9:Data Containers":
                return 208;
            case "CHAPTER 10:True, False, and Undecided: Nullability":
                return 262;
            case "CHAPTER 11:Handling Equality":
                return 268;
            case "CHAPTER 12:Back to Math: Functional Programming":
                return 274;
            case "CHAPTER 13:About Type Safety:Generics":
                return 289;
            case "CHAPTER 14:Adding Hints:Annotations":
                return 302;
            case "CHAPTER 15:Using the Java and Kotlin APIs":
                return 318;
            case "CHAPTER 16:The Collections API":
                return 321;
            case "CHAPTER 17:More APIs":
                return 358;
            case "CHAPTER 18:Working in Parallel:Multithreading":
                return 403;
            case "CHAPTER 19:Using External Libraries":
                return 447;
            case "CHAPTER 20:XML and JSON":
                return 456;
            case "Appendix":
                return 477;
            case "Index":
                return 509;
            default:
                return 0; // Default to page 0 if chapter title is not found
        }
    }

    // Method to open PDFActivity with the specified page number
    private void openPdfActivity(int pageNumber) {
        Intent intent = new Intent(this, pdfActivity.class);
        intent.putExtra("pageNumber", pageNumber);
        startActivity(intent);
    }
}
