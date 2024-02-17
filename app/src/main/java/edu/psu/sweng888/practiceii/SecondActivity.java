package edu.psu.sweng888.practiceii;

import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    // Initiate flag to determine if user has navigated back from SecondActivity
    private boolean isBackPressedHandled = false;

    // Define activity when SecondActivity is opened
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Retrieve selected book
        Book selectedBook = (Book) getIntent().getSerializableExtra("selectedBook");

        // Null check for selectedBook
        if (selectedBook != null) {
            // Find the TextViews in the layout
            TextView titleTextView = findViewById(R.id.titleTextView);
            TextView authorTextView = findViewById(R.id.authorTextView);
            TextView descriptionTextView = findViewById(R.id.descriptionTextView);

            // Set text on TextViews with selected book data
            titleTextView.setText(selectedBook.getTitle());
            authorTextView.setText(selectedBook.getAuthor());
            descriptionTextView.setText(selectedBook.getDescription());
        } else {
            // Handle case where selected book is null
            Log.e("SecondActivity", "Selected book is null");
            finish();
        }

        // Create a callback to handle back button press
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Set a flag to indicate that the user returned from SecondActivity
                if (!isBackPressedHandled) {

                    // Display a Toast message indicating operation was completed successfully
                    Toast.makeText(SecondActivity.this, "Operation completed successfully", Toast.LENGTH_SHORT).show();

                    // Reset flag
                    isBackPressedHandled = true;
                    // Proceed with the back button press
                    finish();
                }
            }
        };

        // Add the callback to the onBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, callback);
    }
}