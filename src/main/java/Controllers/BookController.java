package Controllers;

import Objects.Book;
import View.Alert;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BookController {
    public static List<Book> bookList;
    public static String path="Books.JSON";

    public static void readBooks () {
        ObjectMapper objectMapper=new ObjectMapper();

        try {
            bookList = objectMapper.readValue(new File(path), new TypeReference<List<Book>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeBooks(){
        ObjectMapper objectMapper=new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), bookList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Book getBook(String title){
        return bookList.stream().filter(e -> title.equals(e.getTitle())).findAny().orElse(null);

    }

    public static void addBook(String title, String author, String content) {
        if(getBook(title)==null) {
            Book bk = new Book();
            bk.setTitle(title);
            bk.setAuthor(author);
            bk.setContent(content);
            bookList.add(bk);
            writeBooks();
        }
        else
        {
            Alert.display("Error","Title already exists.");
        }

    }

}
