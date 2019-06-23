package com.example.manara.capstone_stage2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Get_Data  {
    ArrayList<Articales> articalesArrayList=new ArrayList<>();
    Articales articale=new Articales();

    private static final String NAME = "name";
    private static final String ID = "id";
    private static final String AUTHOR = "author";
    private static final String TITLE = "title";
    private static final String DESC = "description";
    private static final String URL = "url";
    private static final String URLlToImage = "urlToImage";
    private static final String PublishedAt = "publishedAt";
    private static final String CONTETNT = "content";

    String data="";

    public ArrayList<Articales> getArticles() throws IOException {
        //read url
        try {
            URL url= new URL("https://newsapi.org/v2/everything?domains=wsj.com,nytimes.com&apiKey=208e2a7651fb4b30b8be99fbabcfc1eb");

            //make connection to get data
            HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
            // read data by input stream
            InputStream inputStream= httpURLConnection.getInputStream();
            BufferedReader bufferedInputStream= new BufferedReader(new InputStreamReader(inputStream));
            String line ="";
            while (line!=null)
            {
                line =bufferedInputStream.readLine();
                data+=line;
            }
            JSONObject articales = new JSONObject(data);
            JSONArray list_articales=  articales.getJSONArray("articles");
            for (int i =0;i<list_articales.length();i++)
            {
                JSONObject jsonObject=(JSONObject) list_articales.get(i);
                JSONObject source=jsonObject.getJSONObject("source");
                articale.setName((String) source.get(NAME));
                articale.setId((String) source.get(ID));
                articale.setAuthor( jsonObject.getString(AUTHOR));
                articale.setTitle( jsonObject.getString(TITLE));
               // articale.setContent( jsonObject.getString(CONTETNT));
                articale.setDescription( jsonObject.getString(DESC));
                articale.setPublishedAt( jsonObject.getString(PublishedAt));
                articale.setUrl( jsonObject.getString(URL));
                articale.setUrlToImage( jsonObject.getString(URLlToImage));


                articalesArrayList.add(articale);
                articale=new Articales();
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return articalesArrayList;
    }
}
