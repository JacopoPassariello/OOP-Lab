package it.unisa.bookshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Bookshop {

    final private List<Book> bookshop;

    public Bookshop() {
        bookshop = new ArrayList<>();
    }

    public List<Book> findByAuthor(String author) {
        List<Book> authorList = new ArrayList<>();
        for(Book b : bookshop)
        {
            if(b.getAuthor().equals(author)) authorList.add(b);
        }
        return authorList;
    }

    public List<Book> findByTitleContent(String titleContent) {
        List<Book> titleContentList = new ArrayList<>();
        for(Book b : bookshop)
        {
            if(b.getTitle().equals(titleContent)) titleContentList.add(b);
        }
        return titleContentList;
    }

    public List<Book> findMaxAvailable() {
        List<Book> MaxNumberOfCopies = new ArrayList<>();
        bookshop.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return -(o1.getNumberOfCopies()-o2.getNumberOfCopies());
            }
        });
        int max = bookshop.get(0).getNumberOfCopies();
        for(Book b : bookshop)
        {
            if(b instanceof AudioBook) continue;
            if(b.getNumberOfCopies() == max) MaxNumberOfCopies.add(b);
        }
        return MaxNumberOfCopies;
    }

    public List<Book> findBelowAvailability(int threshold) {
        List<Book> booksBelowAvailability = new ArrayList<>();
        for(Book b : bookshop)
        {
            if(b instanceof AudioBook) continue;
            if(b.getNumberOfCopies() <= threshold) booksBelowAvailability.add(b);
        }
        return booksBelowAvailability;
    }

    public List<Book> getBookshop() {
        return bookshop;
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        while(in.hasNextLine())
        {
            String type = in.nextLine();
            String title,author,editor,format;
            int numberOfCopies,length;
            if(type.equals("AudioBook"))
            {
                title = in.nextLine();
                author= in.nextLine();
                editor= in.nextLine();
                length= Integer.parseInt(in.nextLine());
                format= in.nextLine();
                bookshop.add(new AudioBook(title,author,editor,length,format));
            }
            if(type.equals("Book"))
            {
                title = in.nextLine();
                author= in.nextLine();
                editor= in.nextLine();
                numberOfCopies= Integer.parseInt(in.nextLine());
                bookshop.add(new Book(title,author,editor,numberOfCopies));
            }

        }
    }
}

