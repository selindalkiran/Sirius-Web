Sirius WEB
=====================
Created by Lenovo on 11.12.2018

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted pdenotes a step.
oint
Sirius Login Senaryosu
-----------------------
Tags:Login

* "https://68.183.66.245/" adresine gidilir
* "GIRIS YAP" butonuna tıklanır
* "TELEFON" alanına "5555555511" metni yazılır
* "SIFRE" alanına "123456" metni yazılır
* "GONDER" butonuna tıklanır
* "2" saniye bekle$



Sirius Login_Password_Error Senaryo3su
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


* "https://68.183.66.245/" adresine gidilir
* "KAYIT OL" butonuna tıklanır
* "2" saniye bekle$
* "SINGUP TELNO" alanına "5555559988" metni yazılır
* "NAME" alanına "Tuğçe" metni yazılır
* "SURNAME" alanına "Akın" metni yazılır
* "PASSWORD" alanına "123456" metni yazılır
* "BIRTDAY" alanına "12122012" metni yazılır
* "ACCEPT POLICY" butonuna tıklanır
* "GONDER SIGNUP" butonuna tıklanır
* "2" saniye bekle$

Sirius Signup-PhoneNumberAlreadyUse Senaryosu
---------------------------------------------

* Kayıt ol aksiyonu alınır
* "HATA SIGNUP" elementinden gelen text "Telefon numarası sistemde mevcut" değerini içerir
* "1" saniye bekle$


Sirius Talebi-Iptal-Et Senaryosu
---------------------------------

* Login olunur
* "HIZMET TALEBI" butonuna tıklanır
* "SERVICEREQUEST CLOSE ICON" butonuna tıklanır


Sirius AileHekimi_Service_Request Senaryosu
-------------------------------------------
Tags:AileHekimiServiceRequest

* Login olunur
* "HIZMET TALEBI" butonuna tıklanır
* "DOKTOR" butonuna tıklanır
* "GONDER MEDIC" butonuna tıklanır
* "AILE HEKIMI" butonuna tıklanır
* "GONDER DOKTOR BRANCH" butonuna tıklanır
* "KENDIM" butonuna tıklanır
* "GONDER KENDIM" butonuna tıklanır
* "OFIS" butonuna tıklanır
* "GONDER OFIS" butonuna tıklanır
* "DATE YEAR" butonuna tıklanır
* "YEAR" butonuna tıklanır
* "DATE MONTH" butonuna tıklanır
* "MONTH" butonuna tıklanır
* "DATE DAY" butonuna tıklanır
* "DAY" butonuna tıklanır
* "PERIOD" butonuna tıklanır
* "ONE TIME" butonuna tıklanır
* "TIME HOUR" butonuna tıklanır
* "HOUR" butonuna tıklanır
* "TIME MINUTE" butonuna tıklanır
* "MINUTE" butonuna tıklanır
* "GONDER TIMESHEET" butonuna tıklanır
* "NOTE" alanına "gec kalmayin" metni yazılır
* "GONDER NOTE" butonuna tıklanır
* "BACK TO DASHBOARD" butonuna tıklanır
* "2" saniye bekle$


Sirius Dahiliye_Service_Request Senaryosu
-------------------------------------------
Tags:DahiliyeServiceRequest

* Login olunur
* "HIZMET TALEBI" butonuna tıklanır
* "DOKTOR" butonuna tıklanır
* "GONDER MEDIC" butonuna tıklanır
* "DAHILIYE" butonuna tıklanır
* "GONDER DOKTOR BRANCH" butonuna tıklanır
* RelativeAddressDateNoteFinish aksiyonları alınır
* "2" saniye bekle$




Sirius Nurse_All_Services_Request Senaryosu
-------------------------------------------
Tags:NurseServiceRequest

* Login olunur
* "HIZMET TALEBI" butonuna tıklanır
* "NURSE" butonuna tıklanır
* "GONDER MEDIC" butonuna tıklanır
* "EVDE ENJEKSIYON" butonuna tıklanır
* "EVDE KAN ALMA" butonuna tıklanır
* "EVDE SERUM" butonuna tıklanır
* "EVDE SONDA" butonuna tıklanır
* "EVDE PANSUMAN" butonuna tıklanır
* "GONDER NURSE BRANCH" butonuna tıklanır
* RelativeAddressDateNoteFinish aksiyonları alınır
* "2" saniye bekle$



Sirius FTR_All_Services_Request Senaryosu
------------------------------------------
Tags:FTRServiceRequest

* Login olunur
* "HIZMET TALEBI" butonuna tıklanır
* "FIZYOTERAPIST" butonuna tıklanır
* "GONDER MEDIC" butonuna tıklanır
* "KONUSMA TERAPISTI" butonuna tıklanır
* "SOLUNUM TERAPISTI" butonuna tıklanır
* "YUTMA TERAPISTI" butonuna tıklanır
* "GENEL TERAPIST" butonuna tıklanır
* "IS TERAPISTI" butonuna tıklanır
* "GONDER FTR BRANCH" butonuna tıklanır
* RelativeAddressDateNoteFinish aksiyonları alınır
* "2" saniye bekle$






