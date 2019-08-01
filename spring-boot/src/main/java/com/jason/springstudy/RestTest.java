package com.jason.springstudy;

import com.alibaba.fastjson.JSON;
import com.jason.springstudy.config.Xmanager;
import com.jason.springstudy.model.Person;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class RestTest {
    public static URL getUrl() throws MalformedURLException {
        return new URL("http://localhost:9001/tai/kill3?appid=name");
    }

    public static <T> T kill(Class<T> tClass) throws IOException {
        URL url = getUrl();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        InputStream inputStream = null;

        if (conn.getResponseCode() == HttpServletResponse.SC_OK) {
            inputStream = conn.getInputStream();
        } else {
            inputStream = conn.getErrorStream();
        }
        if (inputStream == null) {
            throw new NullPointerException("Server returned empty body");
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        System.out.println(line);

        reader.close();
        return JSON.parseObject(line,tClass);
    }

    public static void test() throws IOException {
        URL url = new URL("http://localhost:9001/tai/kill2?appid=name");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = null;
        /*while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }*/
        line = reader.readLine();
        Person person = JSON.parseObject(line, Person.class);
        reader.close();
        System.out.println(person);
    }

    public static void main(String[] args) throws IOException {
        kill(Person.class);
    }
}
