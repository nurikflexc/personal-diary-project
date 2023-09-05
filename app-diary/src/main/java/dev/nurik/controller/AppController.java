package dev.nurik.controller;

import java.io.IOException;
import java.util.Scanner;

import dev.nurik.App;
import dev.nurik.Diary;

public class AppController {

    private int aDd;
    private int aMm;
    private int aYy;
    private String aSubject;
    private String aText;

    public AppController() throws IOException {

        System.out.println("Kundaligingizga xush kelibsiz!\n");
        choosing(1);
        System.out.println("Bugun sana necha edi(faqat raqamlardan foydalaning)?");
        choosing(2);
        System.out.println("Eslatma uchun raxmat!\nQaysi oy?");
        choosing(3);
        System.out.println("Yaxshi!\nQaysi yil?");
        choosing(4);
        System.out.println("Ma'lumot uchun raxmat.\n\nBugun nima haqida gaplashamiz?");
        choosing(5);
        System.out.println("Qiziqarliga o'xshaydi...\nMenga bugun bo'lgan barcha narsalarni aytib bering, juda qiziqib keyayabman.\n\nBuyerdan boshlang: ");
        choosing(6);
    }

    public void choosing(int index) throws IOException {

        Scanner iScanner = new Scanner(System.in);
        Scanner tScanner = new Scanner(System.in);

        switch(index) {

            case 1:
            System.out.println("0 - Chiqish; 1 - Yangi kun; 2 - Oxirgi kun;");
            int chose = iScanner.nextInt();
            if (chose == 0) {

                System.out.println("\nKo'rishguncha!");
                System.exit(0);
            } else if (chose == 1) {

                return;
            } else if (chose == 2) {

                System.out.println(new Diary().getMyLastDay());
                new AppController();
            }
                break;
            case 2:
            System.out.print("Kun: ");
            aDd = iScanner.nextInt();
            break;
            case 3:
            System.out.print("Oy: ");
            aMm = iScanner.nextInt();
            break;
            case 4:
            System.out.print("Yil: ");
            aYy = iScanner.nextInt();
            break;
            case 5:
            System.out.print("Mavzu: ");
            aSubject = tScanner.nextLine();
            break;
            case 6:
            aText = tScanner.nextLine();
            new Diary().saveToDiary(new Diary(aSubject, aText, aDd, aMm, aYy));
            System.out.println("\nO'ylaymanki bu bugun uchun yetarli, ko'rishguncha!");
            new AppController();
            break;
        }
    }
}