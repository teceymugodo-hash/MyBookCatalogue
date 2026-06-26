package com.example.mybookcatalogue;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("The Last Ember", "Daniel Roth", "Historical Thriller", "A former archaeologist is pulled into a deadly conspiracy when ancient secrets buried beneath Rome resurface.", R.drawable.the_last_ember));
        bookList.add(new Book("Quantum Mirage", "Lila Chen", "Science Fiction", "In a future where time travel is illegal, a rogue physicist must choose between saving the world or saving her daughter.", R.drawable.quantum_mirage));
        bookList.add(new Book("Roots & Wings", "Maria Esteban", "Literary Fiction", "A moving generational story of a Cuban-American family searching for identity, belonging, and redemption.", R.drawable.roots_and_wings));
        bookList.add(new Book("The Mind Sculptor", "Dr. Evan Shaw", "Psychology/Non-Fiction", "A groundbreaking look at neuroplasticity and how you can rewire your brain for success and happiness.", R.drawable.the_mind_sculptor));
        bookList.add(new Book("Inkbound: Chronicles of the Lost Library", "J.R. Faulkner", "Fantasy/Adventure", "A young librarian discovers that ancient books can open portals to other worlds-but not all stories have happy endings.", R.drawable.inkbound));
        bookList.add(new Book("Startup Savage", "Nicole Vega", "Business/Entrepreneurship", "A brutally honest guide to launching a tech startup in the real world, full of failures, pivots, and unexpected wins.", R.drawable.startup_savage));
        bookList.add(new Book("Beneath Crimson Skies", "Tomasz Novak", "Historical Fiction/WWII", "The intertwined lives of resistance fighters, spies, and survivors during the Nazi occupation of Warsaw.", R.drawable.beneath_crimson));
        bookList.add(new Book("The Art of Stillness", "Tara Bell", "Self-Help/Mindfulness", "Learn how to find peace in a chaotic world by mastering the ancient wisdom of stillness.", R.drawable.the_art_of_stillness));
        bookList.add(new Book("Neon Ghosts", "Khalid Jones", "Urban Fantasy/Mystery", "A private investigator with the ability to see spirits uncovers a supernatural conspiracy beneath the city's neon lights.", R.drawable.neon_ghosts));
        bookList.add(new Book("Eat Green, Live Clean", "Dr. Sanjay Patel", "Health & Wellness", "A practical guide to plant-based nutrition and detox living, backed by science and easy recipes.", R.drawable.eat_green_live_clean));

        BookAdapter adapter = new BookAdapter(bookList, book -> {
            Intent intent = new Intent(MainActivity.this, BookDetailActivity.class);
            intent.putExtra("book", book);
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);
    }
}
