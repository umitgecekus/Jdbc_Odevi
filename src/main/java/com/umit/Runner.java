package com.umit;

import com.umit.controller.UserController;

public class Runner {
    /**
     * ---> giriş yapan kişinin bilgilerini bir yerde tutacaksınız.
     * ---> Yeni Ana Ekran
     * *********************************
     * 1- Postları görüntüle
     * 2- Post paylaş
     * 3- Kullanıcıları Görüntüle  (+)
     * 4- Logout (Sistemden Çıkış yap login ekranına dön.)
     * -----------------------------------
     *       ***********************************
     *       ********** POST LİSTESİ ***********
     *       ***********************************
     *
     *       * * * * * * * * * * * * * * * * * *
     *       *       Muhammet Hoca           * *
     *       *bugün java öğrenmek için güzel-  *
     *       bir gün.                          *
     *                            29.12.2023   *
     *       * * * * * * * * * * * * * * * * * *
     */
    public static void main(String[] args) {
        new UserController().app();


    }
}
