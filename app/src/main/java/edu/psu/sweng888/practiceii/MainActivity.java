package edu.psu.sweng888.practiceii;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private BookAdapter adapter;
    private List<Book> bookList;

    // Define activities on app open
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup listView
        listView = findViewById(R.id.listView);

        // Create a list of books on the NYT Best Sellers List for February 25, 2024
        bookList = createTop10List();

        // Create and set the adapter
        adapter = new BookAdapter(this, R.layout.list_item, bookList);
        listView.setAdapter(adapter);

        // Set item click listener to direct to SecondActivity for book details
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get position of selected book in the list
                Book selectedBook = bookList.get(position);

                // Set explicit intent to move to SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // Pass selected book info to SecondActivity
                intent.putExtra("selectedBook", selectedBook);
                // Start SecondActivity
                startActivity(intent);
            }
        });
    }

    // Define list of books using Book class. Books from NYT Combined Best Sellers for week of Feb 25th, 2024
    private List<Book> createTop10List() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "The Women", "Kristin Hannah","In 1965, a nursing student follows her brother to serve during the Vietnam War and returns to a divided America."));
        bookList.add(new Book(2, "The Teacher", "Frieda McFadden","A math teacher at Caseham High suspects there is more going on behind a scandal involving a teacher and a student."));
        bookList.add(new Book(3,"House of Flame and Shadow", "Sarah J. Maas","The third book in the Crescent City series. Bryce wants to return home while Hunt is trapped in Asteri's dungeons."));
        bookList.add(new Book(4, "Bride", "Ali Hazelwood","Issues of trust arise when an alliance is made between a Vampyre named Misery Lark and a Were named Lowe Moreland."));
        bookList.add(new Book(5, "Fourth Wing", "Rebecca Yarros","Violet Sorrengail is urged by the commanding general, who also is her mother, to become a candidate for the elite dragon riders."));
        bookList.add(new Book(6, "Iron Flame", "Rebecca Yarros","The second book in the Empyrean series. Violet Sorrengail’s next round of training might require her to betray the man she loves."));
        bookList.add(new Book(7, "House of Earth and Blood", "Sarah J. Maas","Passion arises between Bryce Quinlan and Hunt Athalar as they seek to avenge the deaths of Bryce’s friends."));
        bookList.add(new Book(8, "The Heaven and Earth Grocery Store", "James McBride","Secrets held by the residents of a dilapidated neighborhood come to life when a skeleton is found at the bottom of a well."));
        bookList.add(new Book(9, "The Ghost Orchid", "Jonathan Kellerman","The 39th book in the Alex Delaware series. Milo and Alex dig up the pasts of two homicide victims found in Bel Air."));
        bookList.add(new Book(10, "The Housemaid", "Freida McFadden","Troubles surface when a woman looking to make a fresh start takes a job in the home of the Winchesters."));
        return bookList;
    }
}