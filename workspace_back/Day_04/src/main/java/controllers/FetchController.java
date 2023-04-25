package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import dto.ContactDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("*.fetch")
public class FetchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getRequestURI();
        Gson gson = new Gson();
        if (command.equals("/exam01.fetch")) {
            System.out.println("비동기 통신 요청 확인");
        } else if (command.equals("/exam02.fetch")) {

            String title = request.getParameter("title");
            String myName = request.getParameter("myName");

            System.out.println(title);
            System.out.println(myName);
            JsonWriter jsonWriter = gson.newJsonWriter(response.getWriter());
            String jsonResult = gson.toJson("{title:"+title+",myName:"+myName+"}");
            jsonWriter.jsonValue(jsonResult).flush();
//            jsonWriter.beginArray().value(title).value(myName).endArray().flush();
        } else if (command.equals("/exam03.fetch")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String contact = request.getParameter("contact");
            ContactDTO contactDTO = ContactDTO.builder()
                    .id(id)
                    .name(name)
                    .contact(contact)
                    .build();
            String contactJson = gson.toJson(contactDTO);
            JsonWriter jsonWriter = gson.newJsonWriter(response.getWriter());
            jsonWriter.jsonValue(contactJson).flush();
        } else if (command.equals("/exam04.fetch")) {
            ContactDTO contact1 = ContactDTO.builder()
                    .id(1)
                    .name("Jack")
                    .contact("123")
                    .build();
            ContactDTO contact2 = ContactDTO.builder()
                    .id(2)
                    .name("Bob")
                    .contact("456")
                    .build();
            ContactDTO contact3 = ContactDTO.builder()
                    .id(3)
                    .name("Eve")
                    .contact("789")
                    .build();
            List<ContactDTO> contactList = new ArrayList<>(Arrays.asList(contact1,contact2,contact3));
            String contactsJson = gson.toJson(contactList);

            JsonWriter jsonWriter = gson.newJsonWriter(response.getWriter());
            jsonWriter.jsonValue(contactsJson).flush();
        } else if (command.equals("/exam05.fetch")) {
            String[] arr = new String[]{"Apple", "Orange", "Mango"};
            ContactDTO contactDTO = ContactDTO.builder().id(1).name("AI").contact("12").build();
            JsonObject responseJson = new JsonObject();
            responseJson.add("arr", gson.toJsonTree(arr));
            responseJson.add("contact", gson.toJsonTree(contactDTO));

            JsonWriter jsonWriter = gson.newJsonWriter(response.getWriter());
            jsonWriter.jsonValue(responseJson.toString()).flush();

//            response.getWriter().append(responseJson.toString());
        }
    }
}
