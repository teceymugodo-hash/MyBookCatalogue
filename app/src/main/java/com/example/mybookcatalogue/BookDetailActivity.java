package com.example.mybookcatalogue;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Book book = (Book) getIntent().getSerializableExtra("book");

        if (book != null) {
            ImageView ivCover = findViewById(R.id.ivDetailCover);
            TextView tvTitle = findViewById(R.id.tvDetailTitle);
            TextView tvAuthor = findViewById(R.id.tvDetailAuthor);
            TextView tvGenre = findViewById(R.id.tvDetailGenre);
            TextView tvDescription = findViewById(R.id.tvDetailDescription);

            ivCover.setImageResource(book.getImageResId());
            tvTitle.setText(book.getTitle());
            tvAuthor.setText(getString(R.string.author_label, book.getAuthor()));
            tvGenre.setText(getString(R.string.genre_label, book.getGenre()));
            tvDescription.setText(book.getDescription());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
