package com.alfa;


import okhttp3.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.IOException;

public class Main {

    final OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .addHeader("TokenForCreatingAMUser", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbGZhbGFidGVzdCIsImV4cCI6MTcwNjg2MzQwOCwiaWF0IjoxNjc1MzI3NDA4fQ.-Lg2mSYu5FpPqG_pNd9cP_7--7y95ToEQ2SIJ7HuGdwWp_TspMZGok9DtR8rWqKSxFOVMcZtKKE0sybDoZbJGw")
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws IOException, ParseException {

        Main example = new Main();
        String response = example.run("https://test-alfa-mobile.alfabank.ru/mobile/autotests/am-user/create");

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(response);

        String lastName = (String) jsonObject.get("lastName");
        String name = (String) jsonObject.get("name");
        String patronymic = (String) jsonObject.get("patronymic");
        String phoneNumber = (String) jsonObject.get("phoneNumber");


        System.out.println("LastName: " + lastName);
        System.out.println("Name: " + name);
        System.out.println("Patronymic: " + patronymic);
        System.out.println("PhoneNumber: " + phoneNumber);
        System.out.print(response);
    }
}

