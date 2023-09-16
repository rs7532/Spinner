    package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    String[][] Europe_data, Asia_data, North_america_data, South_america_data, Africa_data;
    String[] Continents;
    String[] Europe_countries, Asia_countries, Africa_countries, North_America_countries, South_America_countries;
    Spinner spin;
    ListView lv;
    ArrayAdapter<String> Europe_adp, Asia_adp, Africa_adp, North_America_adp, South_America_adp;
    TextView Capital_tv, Language_tv, Population_tv, Anthem_tv;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Continents = new String[]{"Europe", "Asia", "Africa", "North America", "South America"};

        Capital_tv = findViewById(R.id.Capital_tv);
        Population_tv = findViewById(R.id.Population_tv);
        Language_tv = findViewById(R.id.Language_tv);
        Anthem_tv = findViewById(R.id.Anthem_tv);

        lv = findViewById(R.id.List_View);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);

        spin = findViewById(R.id.Spinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter<String> spinner_adp = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Continents);
        spin.setAdapter(spinner_adp);

        Europe_countries = new String[]{"France", "Germany", "Austria", "Norway", "Italy", "Britain", "The Netherlands"};
        Asia_countries = new String[]{"Japan", "China", "Israel", "India", "South Korea", "Thailand", "Singapore"};
        Africa_countries = new String[]{"Morocco", "Senegal", "Sudan", "Algeria", "Uganda", "Tunisia", "Luv"};
        North_America_countries = new String[]{"United States", "Canada", "Mexico", "Cuba", "Panama", "Costa Rica", "Greenland"};
        South_America_countries = new String[]{"Brazil", "Argentina", "Colombia", "Peru", "Chile", "Ecuador", "Uruguay"};


        Europe_data = new String[][]{
                {"France", "Paris", "67 million", "French", "The Marseilles"},
                {"Germany", "Berlin", "82 million", "German", "Das Lied der Deutschen"},
                {"Austria", "Vienna", "9 million", "German", "Land der Berge, Land am Strome"},
                {"Norway", "Oslo", "5 Million", "Norwegian", "Oh, we will love this land"},
                {"Italy", "Rome", "59 million", "Italian", "mameli"},
                {"Britain", "London", "67 million", "English", "god save the king"},
                {"The Netherlands", "Amsterdam", "17 million", "Dutch", "Het Wilhelmus"}
        };

        Asia_data = new String[][]{
                {"Japan", "Tokyo", "125 million", "Japanese", "your rule"},
                {"China", "Beijing", "1 billion", "Chinese", "march of the volunteers"},
                {"Israel", "Jerusalem", "9 million", "Hebrew", "The hope"},
                {"India", "New delhi", "1 billion", "Hindi", "jana gana mana"},
                {"South Korea", "Seoul", "51 million", "Korean", "aagokaga"},
                {"Thailand", "Bangkok", "71 million", "Thai", "phlang chat"},
                {"Singapore", "Singapore", "5 million", "Mandarin", "Let's go singapore"}
        };

        Africa_data = new String[][]{
                {"Morocco", "Rabat", "37 million", "Arabic", "The sheriffic anthem"},
                {"Senegal", "Dakar", "16 million", "French", "Tell everyone about your stories, hit the bellphones"},
                {"Sudan", "Hartom", "45 million", "Arabic","We are the army of God, the army of the homeland"},
                {"Algeria", "Algiers", "44 million", "Arabic", "From an oath"},
                {"Uganda", "kampala", "44 million", "Swahili", "Oh Uganda, land of beauty"},
                {"Tunisia", "Tunis", "12 million", "Arabic", "defenders of the homeland"},
                {"luv", "Tripoli", "6 million", "Arabic", "Luv,Luv,Luv"}
        };

        South_america_data = new String[][]{
                {"Brazil", "Brazilia", "214 million", "Portuguese", "the Brazilian National Anthem"},
                {"Argentina", "Buenos Aires", "45 million", "Spanish", "the national anthem of argentina"},
                {"Colombia", "Bogota", "51 million", "Spanish", "the national anthem of the Republic of Colombia"},
                {"Peru", "Lima", "33 million", "Spanish", "the national anthem of Peru"},
                {"Chile", "Santiago de Chile", "19 million", "Spanish", "the national anthem of Chile"},
                {"Ecuador", "kito", "18 million", "Spanish", "We salute you from our homeland"},
                {"Uruguay", "montevideo", "3 million", "Spanish", "The people of the east, the homeland or the grave"}
        };

        North_america_data = new String[][]{
                {"United States", "Washington D.C", "331 million", "English", "The Star Spangled Banner"},
                {"Canada", "Ottawa", "38 million", "English", "Oh Cananda"},
                {"Mexico", "Mexico City", "126 million", "Spanish", "the Mexican National Anthem"},
                {"Cuba", "Havana", "11 million", "Spanish", "Biamo's Anthem"},
                {"Panama", "Panama", "4 million", "Spanish", "the strait anthem"},
                {"Costa Rica", "San Hoze", "5 million", "Spanish", "A noble homeland, your beautiful flag"},
                {"Greenland", "Nook", "56 thousands", "Greenlandic", "You, our ancient country"}
        };


        Europe_adp = new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Europe_countries);
        Asia_adp = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Asia_countries);
        Africa_adp = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Africa_countries);
        North_America_adp = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, North_America_countries);
        South_America_adp = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, South_America_countries);

    }


        @SuppressLint("SetTextI18n")
        public void Show_country_data(String[][] continent, int position){
            Capital_tv.setText("Capital: " + continent[position][1]);
            Population_tv.setText("Population: " + continent[position][2]);
            Language_tv.setText("Language: " + continent[position][3]);
            Anthem_tv.setText("Anthem: " + continent[position][4]);
        }


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (lv.getAdapter().equals(Europe_adp)) {
                Show_country_data(Europe_data, position);
            }
            else if(lv.getAdapter().equals(Asia_adp)){
                Show_country_data(Asia_data, position);
            }
            else if(lv.getAdapter().equals(Africa_adp)){
                Show_country_data(Africa_data, position);
            }
            else if(lv.getAdapter().equals(North_America_adp)){
                    Show_country_data(North_america_data, position);
            }
            else{
                Show_country_data(South_america_data, position);
            }
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case 0:
                    lv.setAdapter(Europe_adp);
                    break;
                case 1:
                    lv.setAdapter(Asia_adp);
                    break;
                case 2:
                    lv.setAdapter(Africa_adp);
                    break;
                case 3:
                    lv.setAdapter(North_America_adp);
                    break;
                case 4:
                    lv.setAdapter(South_America_adp);
                    break;

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }