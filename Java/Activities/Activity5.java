package activities;

abstract class Book
{
    String title;
    abstract void setTitle(String s);
    public void getTitle()
    {
        System.out.println("Title:" + title);
    }
}

class MyBook extends Book {
    public void setTitle(String s) {
        title = s;
    }
}

public class Activity5 {
    public static void main(String[] args)
    {
            MyBook someNovel = new MyBook();
            someNovel.setTitle("Notebook");
            someNovel.getTitle();
    }
}
