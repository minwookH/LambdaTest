package com.example.hmw.lambdatest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Func1;
import rx.subjects.PublishSubject;


public class MainActivity extends ActionBarActivity {

    private ListView listView;
    private EditText inputText;
    private ArrayAdapter<String> listAdapter;
    private PublishSubject<String> publishSubject1;
    private PublishSubject<String> publishSubject2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = (EditText)findViewById(R.id.inputText);
        listView = (ListView)findViewById(R.id.listView);

        // Android에서 제공하는 string 문자열 하나를 출력 가능한 layout으로 어댑터 생성
        listAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);

        // Xml에서 추가한 ListView 연결
        listView = (ListView) findViewById(R.id.listView);

        // ListView에 어댑터 연결
        listView.setAdapter(listAdapter);

        List<String> list1 = new ArrayList<String>();

        list1.add("a"); list1.add("b"); list1.add("c"); list1.add("d"); list1.add("e"); list1.add("f");
        list1.add("g"); list1.add("h"); list1.add("i"); list1.add("j"); list1.add("k"); list1.add("l");
        list1.add("m"); list1.add("n"); list1.add("o"); list1.add("p"); list1.add("q"); list1.add("r");
        list1.add("s"); list1.add("t"); list1.add("u"); list1.add("v"); list1.add("w"); list1.add("x");
        list1.add("y"); list1.add("z");


        //String [] list = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        //Observable<String> o = Observable.from(list);
        //Observable.from(list1).subscribe(s -> listAdapter.add(s));

        publishSubject1 = PublishSubject.create();
        publishSubject1.subscribe(s -> listAdapter.add(s));

        for(int i=0 ; i<list1.size() ; i++){
            publishSubject1.onNext(list1.get(i));
        }




        publishSubject2 = PublishSubject.create();
        publishSubject2.filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                Log.e("s", s.toString());
                Log.e("list.contains(s)", String.valueOf(list1.contains(s)));
                return list1.contains(s);
            }
        }).subscribe(a -> {
            listAdapter.add(a);
            listAdapter.notifyDataSetChanged();
        });

        inputText.addTextChangedListener(new TextWatcher() {

            List<String> input = new ArrayList<String>();

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("before", s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("onTextChanged", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("after", s.toString());

                input.clear();

                for (int i = 0; i < s.length(); i++) {
                    input.add(String.valueOf(s.charAt(i)));
                }

                listAdapter.clear();

                for(int i=0 ; i<input.size() ; i++){
                    publishSubject2.onNext(input.get(i));
                }

                /*Observable.from(input)
                        .filter(new Func1<String, Boolean>() {
                            @Override
                            public Boolean call(String s) {
                                Log.e("s", s.toString());
                                Log.e("list.contains(s)", String.valueOf(list1.contains(s)));
                                return list1.contains(s);
                            }
                        }).subscribe(a -> listAdapter.add(a));*/

            }
        });
    }
}
