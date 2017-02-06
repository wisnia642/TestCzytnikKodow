package com.example.admin.testczytnikkodow;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.Random;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    //UI instance variables
    private Button scanBtn,cleanBtn;
    private TextView  numer;
    private EditText Imie;
    private ListView lista;
    private long start;
    String imie,status;
    Double czas;
    String tab[] = {"jeden","dwa","trzy","cztery","pięć","sześć","siedem","osiem","dziewięć"};

    String[] tab1 = new String[100];
    String[] tab2 = new String[100];
    String[] tab3 = new String[100];
    //String[] tab4 = new String[100];



    private static final String SAMPLE_DB_NAME = "Wyniki";
    private static final String SAMPLE_TABLE_NAME = "Karta";

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(),
                message,
                Toast.LENGTH_LONG).show();
    }



    private void readsqlLight() {
        ToDataBase();
        try {
            SQLiteDatabase sampleDB = this.openOrCreateDatabase(SAMPLE_DB_NAME, MODE_PRIVATE, null);

            Cursor c = sampleDB.rawQuery("Select * from 'Wynik'", null);
            int i=0;
            while (c.moveToNext()) {
                tab1[i] = String.valueOf(c.getString(1));
                tab2[i] = String.valueOf(c.getString(2));
                tab3[i] = String.valueOf(c.getString(3));
                i++;
            }
            sampleDB.close();
        }catch (Exception e)
        {
            showToast("Błąd w wykonywaniu polecenia" +e);
        }

    }

    private void cleansqlLight()
    {
        try {
            SQLiteDatabase sampleDB = this.openOrCreateDatabase(SAMPLE_DB_NAME,MODE_PRIVATE,null);
            sampleDB.execSQL("Delete from Wynik ");
            sampleDB.close();

        }catch (Exception e)
        {
            showToast("Błąd przy czyszczeniu listy wyników" +e);
        }
    }


    private void ToDataBase() {
        try {
            SQLiteDatabase sampleDB = this.openOrCreateDatabase(SAMPLE_DB_NAME, MODE_PRIVATE, null);
            sampleDB.execSQL("CREATE TABLE IF NOT EXISTS Wynik (ID  AUTO_INCREMENT, Nazwa VARCHAR,Czas VARCHAR,Stan INT)");
           // showToast("połączenie udało się");

        } catch (Exception e) {
            showToast("błąd połączenia");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiate UI items
        scanBtn = (Button)findViewById(R.id.scan_button);
        cleanBtn = (Button)findViewById(R.id.button16);
        numer = (TextView) findViewById(R.id.textView);
        Imie = (EditText) findViewById(R.id.editText);
        lista = (ListView) findViewById(R.id.listView);

        //listen for clicks
        scanBtn.setOnClickListener(this);

        cleanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cleansqlLight();
            }
        });

        ToDataBase();
        readsqlLight();
        customAdapter adapter=new customAdapter(this, tab1,tab2,tab3);
        lista.setAdapter(adapter);

        Imie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=0;
                if(i==0) {
                    Imie.setText("");
                    i++;
                }
            }
        });

    }

    public void onClick(View v){

        try{
        //Uruchamianie aplikacji skaner
        imie = Imie.getText().toString();
        if(imie!=null & !imie.equals("Podaj swoje imię")) {
            //check for scan button
            Intent i = new Intent(MainActivity.this, ra.class);
            i.putExtra("imie", imie);
            startActivity(i);


            /* funkcjonalność wyłączona skanera
            //włącznie skanera
            if (v.getId() == R.id.scan_button) {
                //instantiate ZXing integration class
                IntentIntegrator scanIntegrator = new IntentIntegrator(this);
                //start scanning
                scanIntegrator.initiateScan();
            }*/
            Log.i("Nowy",imie);
        }else
        {
            showToast("Wpisz swoje imię");
        }}catch (Exception e)
        {
            Log.i("Nowy",""+e);

        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        start=System.currentTimeMillis();
        //retrieve result of scanning - instantiate ZXing object
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode,
                resultCode, intent);
        //check we have a valid result
        if (scanningResult != null) {
            //get content from Intent Result
            String scanContent = scanningResult.getContents();
            //get format name of data scanned
            String scanFormat = scanningResult.getFormatName();

            //pobieranie daty systemowej
            Calendar cal = Calendar.getInstance();

            int d=cal.get(Calendar.DAY_OF_MONTH);
            int m=cal.get(Calendar.MONTH);
            int r=cal.get(Calendar.YEAR);

            //Generowanie losowych liczb
            Random w = new Random();
            int a = w.nextInt(9);
            Toast.makeText(getApplicationContext(),
                    String.valueOf(a), Toast.LENGTH_LONG).show();

            long stop=System.currentTimeMillis();
            System.out.println("Czas zeskanowania wszystkich kodów:"+(stop-start));
            czas = Double.valueOf(stop-start);
            status = d+"/"+m+"/"+r;

           // writesqlLight();

            showToast("Twój czas to: "+String.valueOf(stop-start));

            //długie obliczenia
            for(int i=0;i<9;i=i+0) {
                //wystartowanie czasu

                switch (a) {
                    case 0: Toast.makeText(getApplicationContext(),
                            String.valueOf(a), Toast.LENGTH_LONG).show();
                        //sprawdzanie warunku
                        if (scanContent.equals(tab[0])) {
                            //ponowne uruchamianie skanera
                            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
                            //start scanning
                            scanIntegrator.initiateScan();
                            i++;
                        }else
                        {
                            showToast("błąd skanowania");
                        }
                        break;

                    case 1: Toast.makeText(getApplicationContext(),
                            String.valueOf(a), Toast.LENGTH_LONG).show();
                        if (scanContent.equals(tab[1])) {
                            //ponowne uruchamianie skanera
                            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
                            //start scanning
                            scanIntegrator.initiateScan();
                            i++;
                        }else
                        {
                            showToast("błąd skanowania");
                        }
                        break;
                    case 2: Toast.makeText(getApplicationContext(),
                            String.valueOf(a), Toast.LENGTH_LONG).show();
                        if (scanContent.equals(tab[2])) {
                            //ponowne uruchamianie skanera
                            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
                            //start scanning
                            scanIntegrator.initiateScan();
                            i++;
                        }else
                        {
                            showToast("błąd skanowania");
                        }
                        break;
                    case 3: Toast.makeText(getApplicationContext(),
                            String.valueOf(a), Toast.LENGTH_LONG).show();
                        if (scanContent.equals(tab[3])) {
                            //ponowne uruchamianie skanera
                            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
                            //start scanning
                            scanIntegrator.initiateScan();
                            i++;
                        }else
                        {
                            showToast("błąd skanowania");
                        }
                        break;
                    case 4: Toast.makeText(getApplicationContext(),
                            String.valueOf(a), Toast.LENGTH_LONG).show();
                        if (scanContent.equals(tab[4])) {
                            //ponowne uruchamianie skanera
                            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
                            //start scanning
                            scanIntegrator.initiateScan();
                            i++;
                        }else
                        {
                            showToast("błąd skanowania");
                        }
                        break;
                    case 5: Toast.makeText(getApplicationContext(),
                            String.valueOf(a), Toast.LENGTH_LONG).show();
                        if (scanContent.equals(tab[5])) {
                            //ponowne uruchamianie skanera
                            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
                            //start scanning
                            scanIntegrator.initiateScan();
                            i++;
                        }else
                        {
                            showToast("błąd skanowania");
                        }
                        break;
                    case 6: Toast.makeText(getApplicationContext(),
                            String.valueOf(a), Toast.LENGTH_LONG).show();
                        if (scanContent.equals(tab[6])) {
                            //ponowne uruchamianie skanera
                            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
                            //start scanning
                            scanIntegrator.initiateScan();
                            i++;
                        }else
                        {
                            showToast("błąd skanowania");
                        }
                        break;
                    case 7: Toast.makeText(getApplicationContext(),
                            String.valueOf(a), Toast.LENGTH_LONG).show();
                        if (scanContent.equals(tab[7])) {
                            //ponowne uruchamianie skanera
                            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
                            //start scanning
                            scanIntegrator.initiateScan();
                            i++;
                        }else
                        {
                            showToast("błąd skanowania");
                        }
                        break;
                    case 8: Toast.makeText(getApplicationContext(),
                            String.valueOf(a), Toast.LENGTH_LONG).show();
                        if (scanContent.equals(tab[8])) {
                            //ponowne uruchamianie skanera
                            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
                            //start scanning
                            scanIntegrator.initiateScan();
                            i++;
                        }else
                        {
                            showToast("błąd skanowania");
                        }
                        break;

                    default:
                        showToast("Błąd skanowania");
                }
            }

        }
        else{
            //invalid scan data or scan canceled
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}
