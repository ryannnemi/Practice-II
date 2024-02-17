package edu.psu.sweng888.practiceii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

// Define adapter for ListView
public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, int resource, List<Book> books) {
        super(context, resource, books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Book book = getItem(position);

        TextView titleTextView = convertView.findViewById(R.id.textViewTitle);
        TextView subtitleTextView = convertView.findViewById(R.id.textViewSubtitle);

        titleTextView.setText(String.format("%d. %s", book.getPlace(), book.getTitle()));

                subtitleTextView.setText(book.getAuthor());

        return convertView;
    }
}
