package com.example.admin.testczytnikkodow;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ra extends ActionBarActivity {

    Button B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15;
    TextView T1, T2;
    ImageView O1;
    ImageView H1, H2, H3;

    Bundle applesData;

    int wartosc[] = new int[20];
    private PopupWindow mpopup;
    long start;
    long stop;
    double czas;
    int iClicks = 0;
    int minuty = 0;
    int godziny = 0;
    int a = 0, serca = 0, zm = 0;
    int b = 0, c = 0;
    int przycisk = 0;
    int licznik = 0, wynik;
    String zero[] = new String[5];
    String status = "", imie = "";


    //Dane do bazy danych
    private static final String SAMPLE_DB_NAME = "Wyniki";
    private static final String SAMPLE_TABLE_NAME = "Karta";

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(),
                message,
                Toast.LENGTH_LONG).show();
    }

    private void ToDataBase() {
        try {
            SQLiteDatabase sampleDB = this.openOrCreateDatabase(SAMPLE_DB_NAME, MODE_PRIVATE, null);
            sampleDB.execSQL("CREATE TABLE IF NOT EXISTS Wynik (ID  AUTO_INCREMENT, Nazwa VARCHAR,Czas VARCHAR,Stan INT)");
            //    showToast("połączenie udało się");

        } catch (Exception e) {
            showToast("błąd połączenia");
        }

    }

    private void writesqlLight() {
        ToDataBase();
        try {

            //pobieranie daty systemowej
            Calendar cal = Calendar.getInstance();

            int d = cal.get(Calendar.DAY_OF_MONTH);
            int m = cal.get(Calendar.MONTH);
            int r = cal.get(Calendar.YEAR);
            status = d + "/" + m+1 + "/" + r;
            Log.i("blad",m+""+ status);
            SQLiteDatabase sampleDB = this.openOrCreateDatabase(SAMPLE_DB_NAME, MODE_PRIVATE, null);

            sampleDB.execSQL("INSERT INTO Wynik (Nazwa,Czas,Stan) VALUES " +
                    "('" + imie + "','" + c + "','" + status + "')"); //na pewno źle

            sampleDB.close();

        } catch (Exception e) {
            showToast("Błąd w wykonywaniu " + e);
        }

    }

    public void mpoup() {


        //czas wyswietlania buzki
        zm = 6;
        final View popUpView = getLayoutInflater().inflate(R.layout.koniec, null);
        // inflating popup layout
        mpopup = new PopupWindow(popUpView, ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        //Creation of popup
        mpopup.setAnimationStyle(android.R.style.Animation_Dialog);
        new Handler().postDelayed(new Runnable() {

            public void run() {
                mpopup.showAtLocation(popUpView, Gravity.CENTER, 0, 0);
            }

        }, 100L);


        Button nowy = (Button) popUpView.findViewById(R.id.button30);
        Button koniec = (Button) popUpView.findViewById(R.id.button17);

        if (licznik != 30) {
            nowy.setEnabled(false);
        }


        nowy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ra.this, ra1.class);
                i.putExtra("serca", serca);
                i.putExtra("wynik", wynik);
                i.putExtra("imie", imie);
                startActivity(i);
            }
        });

        koniec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writesqlLight();
                Intent i = new Intent(ra.this, MainActivity.class);
                startActivity(i);
            }
        });

        //liczy wyświetlone buźki ilość
       // licznik = 5;
    }


    public void generator() {
        //Generowanie losowych liczb
        Random w = new Random();
        a = w.nextInt(13);
        b = a;
        //wyświetlanie kolejnych obrazków
        //  T2.setText(String.valueOf(a));
        // Toast.makeText(getApplicationContext(),
        //   String.valueOf(a), Toast.LENGTH_LONG).show();

        //licznik do zmiany buźki
        zm = 0;
        switch (a) {
            case 0:
                int id = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/mina0", null, null);
                O1.setImageResource(id);
                break;
            case 1:
                int id1 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/mina1", null, null);
                O1.setImageResource(id1);
                break;
            case 2:
                int id2 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/mina2", null, null);
                O1.setImageResource(id2);
                break;
            case 3:
                int id3 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/mina3", null, null);
                O1.setImageResource(id3);
                break;
            case 4:
                int id4 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/mina4", null, null);
                O1.setImageResource(id4);
                break;
            case 5:
                int id5 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/mina5", null, null);
                O1.setImageResource(id5);
                break;
            case 6:
                int id6 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/mina6", null, null);
                O1.setImageResource(id6);
                break;
            case 7:
                int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/mina7", null, null);
                O1.setImageResource(id7);
                break;
            case 8:
                int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/mina8", null, null);
                O1.setImageResource(id8);
                break;
            case 9:
                int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/mina9", null, null);
                O1.setImageResource(id9);
                break;
            case 10:
                int id10 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/mina10", null, null);
                O1.setImageResource(id10);
                break;
            case 11:
                int id11 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/mina11", null, null);
                O1.setImageResource(id11);
                break;
            case 12:
                int id12 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/mina12", null, null);
                O1.setImageResource(id12);
                break;
            case 13:
                int id13 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/mina13", null, null);
                O1.setImageResource(id13);
                break;
            case 14:
                int id14 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/mina14", null, null);
                O1.setImageResource(id14);
                break;

        }

    }


 //     public void czas() {
   //   System.out.println("Czas zeskanowania wszystkich kodów:" + (stop - start));
   //   czas = Double.valueOf(stop - start);
    //  showToast("Twój czas to: " + String.valueOf(stop - start) + "sekund");
    //   }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ra);

        B1 = (Button) findViewById(R.id.button);
        B2 = (Button) findViewById(R.id.button2);
        B3 = (Button) findViewById(R.id.button3);
        B4 = (Button) findViewById(R.id.button4);
        B5 = (Button) findViewById(R.id.button8);
        B6 = (Button) findViewById(R.id.button12);
        B7 = (Button) findViewById(R.id.button5);
        B8 = (Button) findViewById(R.id.button9);
        B9 = (Button) findViewById(R.id.button13);
        B10 = (Button) findViewById(R.id.button6);
        B11 = (Button) findViewById(R.id.button11);
        B12 = (Button) findViewById(R.id.button14);
        B13 = (Button) findViewById(R.id.button7);
        B14 = (Button) findViewById(R.id.button10);
        B15 = (Button) findViewById(R.id.button15);

        T1 = (TextView) findViewById(R.id.textView6);
        T2 = (TextView) findViewById(R.id.textView10);

        O1 = (ImageView) findViewById(R.id.imageView);
        H1 = (ImageView) findViewById(R.id.imageButton);
        H2 = (ImageView) findViewById(R.id.imageButton2);
        H3 = (ImageView) findViewById(R.id.imageButton3);


        zero[0] = "0";
        zero[1] = "0";
        zero[2] = "0";
        wartosc[0] = 1;


        //Pobieranie imienia z wcześniejszego layotu
        applesData = getIntent().getExtras();
        imie = applesData.getString("imie");



        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        zm++;
                        if (zm == 4) {
                            generator();
                            wynik = wynik - 10;
                            licznik++;

                            if ( wynik == -100) {
                                // licznik = 30; -- nie wiem do czego to służy :p
                                mpoup();
                            }
                        }

                        T2.setText(String.valueOf(wynik));
                        c = wynik;

                        if (licznik < 19) {
                            iClicks = iClicks + 1;
                            T1.setText(String.valueOf(zero[0] + godziny + ":" + zero[1] + minuty + ":" + zero[2] + iClicks));
                        }



                        if (iClicks == 9) {
                            zero[2] = "";
                        }
                        if (iClicks == 59) {
                            minuty = minuty + 1;
                            iClicks = 0;
                            zero[2] = "0";
                        }
                        if (minuty == 9) {
                            zero[1] = "";
                        }
                        if (minuty == 59) {
                            godziny = godziny + 1;
                            iClicks = 0;
                            minuty = 0;
                            zero[1] = "0";
                        }
                        if (godziny == 9) {
                            zero[1] = "";
                        }
                        if (godziny == 1) {
                            zero[1] = "0";
                        }
                        if (serca == 0) {

                            int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                            H1.setImageResource(id7);
                            int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                            H2.setImageResource(id8);
                            int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                            H3.setImageResource(id9);
                        }


                    }
                });

            }
        }, 0, 1000);

        //wystartowanie czasu w sekundach
        //  start=System.currentTimeMillis();

        //wywoływanie kolejnych liczb losowych
        generator();


        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosc[0] = 5;
                if (wartosc[b] == 5) {
                    //  showToast(String.valueOf(wartosc[0]));
                    wartosc[0] = 2;
                    generator();
                    licznik++;
                    wynik = wynik + 10;
                } else {
                    //showToast("siema1");
                    wynik = wynik - 10;
                    serca++;
                    if (serca == 1) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 2) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 3) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 4) {
                        mpoup();
                    }

                }

            }
        });

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosc[1] = 1;
                if (wartosc[b] == 1) {
                    generator();
                    licznik++;
                    wynik = wynik + 10;
                } else {

                    wynik = wynik - 10;
                    serca++;
                    if (serca == 1) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 2) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 3) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 4) {
                        mpoup();
                    }


                }

            }
        });

        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosc[2] = 2;
                if (wartosc[b] == 2) {
                    generator();
                    licznik++;
                    wynik = wynik + 10;
                } else {

                    wynik = wynik - 10;
                    serca++;
                    if (serca == 1) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 2) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 3) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 4) {
                        mpoup();
                    }

                }
            }
        });

        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosc[3] = 3;
                if (wartosc[b] == 3) {
                    generator();
                    licznik++;
                    wynik = wynik + 10;
                } else {

                    wynik = wynik - 10;
                    serca++;
                    if (serca == 1) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 2) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 3) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 4) {
                        mpoup();
                    }

                }
            }
        });

        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosc[4] = 4;
                if (wartosc[b] == 4) {
                    generator();
                    licznik++;
                    wynik = wynik + 10;
                } else {

                    wynik = wynik - 10;
                    serca++;
                    if (serca == 1) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 2) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 3) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 4) {
                        mpoup();
                    }

                }
            }
        });

        B6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosc[5] = 5;
                if (wartosc[b] == 5) {
                    generator();
                    licznik++;
                    wynik = wynik + 10;
                } else {

                    wynik = wynik - 10;
                    serca++;
                    if (serca == 1) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 2) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 3) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 4) {
                        mpoup();
                    }

                }
            }
        });

        B7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosc[6] = 6;
                if (wartosc[b] == 6) {
                    generator();
                    licznik++;
                    wynik = wynik + 10;
                } else {

                    wynik = wynik - 10;
                    serca++;
                    if (serca == 1) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 2) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 3) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 4) {
                        mpoup();
                    }

                }
            }
        });

        B8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosc[7] = 7;
                if (wartosc[b] == 7) {
                    generator();
                    licznik++;
                    wynik = wynik + 10;
                } else {

                    wynik = wynik - 10;
                    serca++;
                    if (serca == 1) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 2) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 3) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 4) {
                        mpoup();
                    }

                }
            }
        });

        B9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosc[8] = 8;
                if (wartosc[b] == 8) {
                    generator();
                    licznik++;
                    wynik = wynik + 10;
                } else {

                    wynik = wynik - 10;
                    serca++;
                    if (serca == 1) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 2) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 3) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 4) {
                        mpoup();
                    }

                }
            }
        });

        B10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosc[9] = 9;
                if (wartosc[b] == 9) {
                    generator();
                    licznik++;
                    wynik = wynik + 10;
                } else {

                    wynik = wynik - 10;
                    serca++;
                    if (serca == 1) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 2) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 3) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 4) {
                        mpoup();
                    }

                }
            }
        });

        B11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosc[10] = 10;
                if (wartosc[b] == 10) {
                    generator();
                    licznik++;
                    wynik = wynik + 10;
                } else {

                    wynik = wynik - 10;
                    serca++;
                    if (serca == 1) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 2) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 3) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 4) {
                        mpoup();
                    }

                }
            }
        });

        B12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosc[11] = 11;
                if (wartosc[b] == 11) {
                    generator();
                    licznik++;
                    wynik = wynik + 10;
                } else {

                    wynik = wynik - 10;
                    serca++;
                    if (serca == 1) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 2) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 3) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 4) {
                        mpoup();
                    }

                }
            }
        });

        B13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosc[12] = 12;
                if (wartosc[b] == 12) {
                    generator();
                    licznik++;
                    wynik = wynik + 10;
                } else {

                    wynik = wynik - 10;
                    serca++;
                    if (serca == 1) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 2) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 3) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 4) {
                        mpoup();
                    }

                }
            }
        });

        B14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosc[13] = 13;
                if (wartosc[b] == 13) {
                    generator();
                    licznik++;
                    wynik = wynik + 10;
                } else {

                    wynik = wynik - 10;
                    serca++;
                    if (serca == 1) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 2) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 3) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 4) {
                        mpoup();
                    }

                }
            }
        });

        B15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosc[14] = 14;
                if (wartosc[b] == 14) {
                    generator();
                    licznik++;
                    wynik = wynik + 10;
                } else {

                    wynik = wynik - 10;
                    serca++;
                    if (serca == 1) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 2) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth1", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 3) {
                        int id7 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H1.setImageResource(id7);
                        int id8 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H2.setImageResource(id8);
                        int id9 = getResources().getIdentifier("com.example.admin.testczytnikkodow:drawable/hearth", null, null);
                        H3.setImageResource(id9);
                    }
                    if (serca == 4) {
                        mpoup();
                    }

                }

            }
        });
    }
}


