package com.marcin.cardssql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "AppCompatActivity";

    public static final String EXTRA_UPDATE = "update";
    public static final String EXTRA_DELETE = "delete";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_COLOR = "color";
    public static final String EXTRA_INITIAL = "initial";

    public static final String TRANSITION_FAB = "fab_transition";
    public static final String TRANSITION_INITIAL = "initial_transition";
    public static final String TRANSITION_NAME = "name_transition";
    public static final String TRANSITION_DELETE_BUTTON = "delete_button_transition";

    public RecyclerView recyclerView;
    private SampleMaterialAdapter adapter;
    private ArrayList<Card> cardsList = new ArrayList<>();
    private int[] colors;
    private String[] names;
    public CardsData cardsData = new CardsData(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = getResources().getStringArray(R.array.names_array);
        colors = getResources().getIntArray(R.array.initial_colors);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new GetOrCreateCardsListTask().execute();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair<View, String> pair = Pair.create(v.findViewById(R.id.fab), TRANSITION_FAB);

                ActivityOptionsCompat options;
                Activity act = MainActivity.this;
                options = ActivityOptionsCompat.makeSceneTransitionAnimation(act, pair);

                Intent transitionIntent = new Intent(act, TransitionAddActivity.class);
                act.startActivityForResult(transitionIntent, adapter.getItemCount(), options.toBundle());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        cardsData.open();
        Log.d(DEBUG_TAG, "cardsData otworzno w metodzie onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        cardsData.close();
        Log.d(DEBUG_TAG, "cardsData zamknięto w metodzie onPause()");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        cardsData.open();
        Log.d(DEBUG_TAG, "requestCode ma wartość " + requestCode);
        // Jeśli wywołanie adapter.getItemCount() zaróci kod żądania, będzie to oznaczać, że dodajemy nową pozycję.
        // Wszelkie zwrócone wartości mniejsze od adapter.getItemCount() oznaczają edycję istniejącego elementu.
        if (requestCode == adapter.getItemCount()) {
            if (resultCode == RESULT_OK) {
                // Upewniamy się, że żądanie dodania zakończyło się pomyślnie. W takim przypadku
                // dodajemy imię i aktualizujemy listę.
                String name = data.getStringExtra(EXTRA_NAME);
                int color = data.getIntExtra(EXTRA_COLOR, 0);
                int newPosition = adapter.getItemCount();
                Log.d(DEBUG_TAG, "newPosition = " + newPosition);
                adapter.addCard(name, color);
            }
        } else {
            // Jakakolwiek wartośc różna od adapter.getItemCount() oznacza edycję istniejącego elementu listy,
            // wartość requestCode określa położenie elementu na liście.
            if (resultCode == RESULT_OK) {
                // Upewniamy się, że żądanie aktualizacji zostało wykonane prawidłowo.
                RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(requestCode);
                if (data.getExtras().getBoolean(EXTRA_DELETE, false)) {
                    // Jeśli zażądano usunięcia, to usuwamy.
                    // Użytkownik usunął kontakt.
                    adapter.deleteCard(viewHolder.itemView, requestCode);
                } else if (data.getExtras().getBoolean(EXTRA_UPDATE)) {
                    // Imię uległo zmianie, aktualizujemy użytkownika.
                    String name = data.getStringExtra(EXTRA_NAME);
                    viewHolder.itemView.setVisibility(View.INVISIBLE);
                    adapter.updateCard(name, requestCode);
                }
            }
        }
    }




    public void doSmoothScroll(int position) {
        recyclerView.smoothScrollToPosition(position);
    }



public class GetOrCreateCardsListTask extends AsyncTask<Void, Void, ArrayList<Card>> {
    @Override
    protected ArrayList<Card> doInBackground(Void... params) {
        cardsData.open();
        cardsList = cardsData.getAll();
        if (cardsList.size() == 0) {
            for (int i = 0; i < 50; i++) {
                Card card = new Card();
                card.setName(names[i]);
                card.setColor_resources(colors[i]);
                cardsList.add(card);
                cardsData.create(card);
                Log.d(DEBUG_TAG, "Karta o identyfikatorze " + card.getId() + ", imię: " + card.getName() + ", kolor: " + card.getColorResource());
            }
        }
        return cardsList;
    }

    @Override
    protected void onPostExecute(ArrayList<Card> cards) {
        super.onPostExecute(cards);
        adapter = new SampleMaterialAdapter(MainActivity.this, cardsList, cardsData);
        recyclerView.setAdapter(adapter);
    }
}
}
