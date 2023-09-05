package dev.nurik;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Diary {

    private String subject;
    private String text;
    private int dd;
    private int mm;
    private int yy;

    public Diary() {


    }

    public Diary(String pSubject, String pText, int pDd, int pMm, int pYy){

        dd = pDd;
        mm = pMm;
        yy = pYy;
        text = pText;
        subject = pSubject;
    }

    public void saveToDiary(Diary diary) {

        String configuring = "Sana: " + diary.dd + "/" + mm + "/" + diary.yy + "\nMavzu: " + diary.subject + "\n\nBo'lgan voqealar : " + diary.text;
        try (FileOutputStream os = new FileOutputStream("Z:\\OneDrive\\Desktop\\projects\\Personal-Diary\\app-diary\\src\\main\\java\\dev\\nurik\\resources\\last_day.txt", true)) {
            byte[] bytes = configuring.getBytes();
            os.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Bajarildi!");
    }

    public String getMyLastDay() throws IOException {

        FileInputStream inputStream = new FileInputStream("Z:\\OneDrive\\Desktop\\projects\\Personal-Diary\\app-diary\\src\\main\\java\\dev\\nurik\\resources\\last_day.txt");

        String fileContent = "";

        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            fileContent += new String(buffer, 0, bytesRead);
        }

        return fileContent;
    }
}