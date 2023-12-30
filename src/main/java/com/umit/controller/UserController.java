package com.umit.controller;

import com.umit.entity.User;
import com.umit.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserController {
    private UserRepository userRepository;
    public UserController(){
        this.userRepository = new UserRepository();
    }
    public void Login(){
        System.out.println("""
                    *************************************
                    ****      KULLANICI GIRIS      ******
                    *************************************
                
                """);
        System.out.print("Kullanıcı adı......: ");
        String username = new Scanner(System.in).nextLine();
        System.out.print("Sifre......: ");
        String password = new Scanner(System.in).nextLine();
        Optional<User> userOptinal = userRepository.doLogin(username,password);

        if(userOptinal.isPresent()){
            User logedInUser= userOptinal.get();
            System.out.println("GIRIS YAPILDI.");
            kullanicilariGoruntule();
        }else{
            System.out.println("Kullanıcı adı ya da sifre hatalıdır.");
        }

    }


    public static void kullanicilariGoruntule() {
        UserRepository userRepository = new UserRepository();
        List<User> users = userRepository.findAll();

        if (!users.isEmpty()) {
            System.out.println("********** KULLANICILAR **********");
            for (User user : users) {
                System.out.println("User ID: " + user.getId());
                System.out.println("Ad Soyad: " + user.getAdsoyod());
                System.out.println("Username: " + user.getUsername());
                System.out.println("-------------------------------");
            }
        } else {
            System.out.println("Henüz kullanıcı bulunmamaktadır.");
        }
    }




    public void Register(){
        System.out.println("""
                    *************************************
                    ****     YENI KULLANICI KAYDI   *****
                    *************************************
                
                """);
        System.out.print("Ad soyad.....: ");
        String adsoyad = new Scanner(System.in).nextLine();
        String username;
        boolean isUser;
        do{
            System.out.print("Kullanıcı adı.....: ");
            username= new Scanner(System.in).nextLine();
            isUser = userRepository.isUserName(username);
            if(isUser)
                System.err.println("Bu kullanıcı adı zaten kullanılıyor. Lütfen değiştirin");
        }while (isUser);

        System.out.print("Sifre.....: ");
        String password = new Scanner(System.in).nextLine();

        userRepository.isUserName(username);

        User user = new User(adsoyad,username,password,"");
        userRepository.save(user);
    }
    public void yeniAnaEkran(){
        int secim;
        do{
            System.out.println("""
                    
                         *  ******************************
                         *  ********** HOSGELDIN  ********  //kullanıcı adını getirmeyi yap
                         *  ******** G I R I S ***********
                         *  1- Postları Goruntule
                         *  2- Post Paylas
                         *  3- Kullanıcıları Goruntule
                         *  4- LogOut
                     
                
             
                """);
            System.out.print("Lütfen seciniz....: ");
            secim = new Scanner(System.in).nextInt();
            switch (secim){
                // case 1 : new PostController().postlariGoruntule(); break;
                case 2 :  break;
                case 3 : kullanicilariGoruntule(); break;
                case 4 :
                    System.out.println("Ana menuye donuluyor... "); app(); break;
                default:
                    System.err.println("Lütfen geçerli bir seçim yapınız.");
                    break;
            }
        }while (secim!=0);
    }

    public void app(){
        int secim;
        do{

            System.out.println("""
                    
                         *  ******************************
                         *  ******* Java Forum Sayfası ***
                         *  ******** G I R I S ***********
                         *  1- Login
                         *  2- Register
                         *  0- C I K I S
                
                
             
                """);
            System.out.print("Lütfen seciniz....: ");
            secim = new Scanner(System.in).nextInt();
            switch (secim){
                case 1 : new UserController().Login(); break;
                case 2 : new UserController().Register(); break;
                default:
                    System.err.println("Lütfen geçerli bir seçim yapınız.");
                    break;
            }
        }while (secim!=0);
        System.out.println("CIKIS");
    }
}
