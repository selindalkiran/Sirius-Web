Sirius WEB
=====================
Created by Lenovo on 11.12.2018

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

Sirius Login Senaryosu
-----------------------
Tags:Login

* Login olunur
* "2" saniye bekle$



Sirius Login_Password_Error Senaryosu
-------------------------------------
Tags:Login_Error

* "https://68.183.66.245/" adresine gidilir
* "GIRIS YAP" butonuna tıklanır
* "TELEFON" alanına "5555555511" metni yazılır
* "SIFRE" alanına "112233" metni yazılır
* "GONDER" butonuna tıklanır
* "HATA_PASSWORD" elementinden gelen text "Mevcut şifren hatalı" değerini içerir
* "2" saniye bekle$


Sirius Login_Wrong_PhoneNumber Senaryosu
----------------------------------------
Tags:Login_Error

* "https://68.183.66.245/" adresine gidilir
* "GIRIS YAP" butonuna tıklanır
* "TELEFON" alanına "4444444444" metni yazılır
* "SIFRE" alanına "112233" metni yazılır
* "GONDER" butonuna tıklanır
* "HATA_PASSWORD" elementinden gelen text "Hatali Giris Yaptiniz" değerini içerir
* "2" saniye bekle$




Sirius Login_Password_TooShort Senaryosu
--------------------------------------
Tags:Login_Error

* "https://68.183.66.245/" adresine gidilir
* "GIRIS YAP" butonuna tıklanır
* "TELEFON" alanına "5555555511" metni yazılır
* "SIFRE" alanına "1234" metni yazılır
* "GONDER" butonuna tıklanır
* "HATA_PASSWORD" elementinden gelen text "Şifre 6-15 karakter uzunluğunda olmak zorunda" değerini içerir
* "2" saniye bekle$



Sirius Login_Password_TooLong Senaryosu
----------------------------------------
Tags:Login_Error

* "https://68.183.66.245/" adresine gidilir
* "GIRIS YAP" butonuna tıklanır
* "TELEFON" alanına "5555555511" metni yazılır
* "SIFRE" alanına "123456123456123456" metni yazılır
* "GONDER" butonuna tıklanır
* "HATA_PASSWORD" elementinden gelen text "Şifre 6-15 karakter uzunluğunda olmak zorunda" değerini içerir
* "2" saniye bekle$


Sirius SignUp Senaryosu
------------------------
Tags:Singup


* Kullanıcı kaydolur
* "2" saniye bekle$






Sirius AileHekimi_Service_Request Senaryosu
-------------------------------------------
Tags:AileHekimiServiceRequest

* "https://68.183.66.245/" adresine gidilir
* "GIRIS YAP" butonuna tıklanır
* "TELEFON" alanına "5555555511" metni yazılır
* "SIFRE" alanına "123456" metni yazılır
* "GONDER" butonuna tıklanır
* "HIZMET TALEBI" butonuna tıklanır
* "DOKTOR" butonuna tıklanır
* "GONDER DOKTOR" butonuna tıklanır
* "AILE HEKIMI" butonuna tıklanır
* "GONDER AILE HEKIMI" butonuna tıklanır
* "KENDIM" butonuna tıklanır
* "GONDER KENDIM" butonuna tıklanır
* "OFIS" butonuna tıklanır
* "GONDER OFIS" butonuna tıklanır
* "YIL" butonuna tıklanır
* "2019" butonuna tıklanır
* "GONDER TIMESHEET" butonuna tıklanır
* "NOTE" alanına "gec kalmayin" metni yazılır
* "GONDER NOTE" butonuna tıklanır
* "BACK TO DASHBOARD" butonuna tıklanır
* "2" saniye bekle$
