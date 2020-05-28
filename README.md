# Crypter🔐
Crypter is a program that encrypts and decrypts text by console or file using classic one-letter replacement encryption techniques like the Cesar and Atbash algorithm, polyalphabetic replacement encryption like Vigenère, and a special encryption algorithm inspired by AES.

**REQUERIMIENTS**

- _**Funtional Requerimient:**_

          1.Show a menu with all text file paths both encrypted and decrypted by the program.
          2.Sort the file paths according to the criteria selected by the user (Name or date).
          3.Delete text file paths as encrypted or decrypted saved by the program.
          4.Customize the text’s display of encrypted or decrypted files (Font type, bold, height and italics).
          5.Encrypt and decrypt text files or console text using the Vigenere polyalphabetic encryption technique using a password (WordKey).
          6.Encrypt and decrypt text files or console text using a simplified encryption technique inspired by AES symmetric encryption using a password.
          7.Encrypt and decrypt text files or console text using the Caesar alphabetic monkey encryption technique using a number key and a direction (Right or Left).
          8.Encrypt and decrypt text files or console text using the Atbash Mono Alphabetic Encryption technique.

- _**Non-Funtional Requerimient:**_

          1.Read a text file to encrypt or decrypt it using the BufferedReader class.
          2.Save the encrypted or decrypted text in a txt file using the BufferedWritter class.
          3.Serialize the RouteManager class because it stores the encrypted and decrypted files.
          4.Store the paths of the encrypted and decrypted texts by the program in a double-linked list.
          5.Use recursive methods to search Objects in an array.
          6.Use binary search methods to search a char data in a string.
          7.Use the Comparable and Comparator interface to sort the linked list of paths using different order criteria, such as date and file name
          8.Display the paths of encrypted and decrypted texts using TableView
          9.Implement exceptions for cases:
          
                    a.When the user enables the option to write by console but does not write anything in it (ConsoleEmptyException).
                    b.When the user specifies a password longer than the message itself, in the Vigenere Algorithm (WordKeyInvalidException).
                    c.When the user writes a word in the numerical password of Cesar (NumberFormatException)

**CONSTRUCTION OF SCENARIOS AND DESIGN OF TEST CASES:** _[HERE](https://github.com/ValeArias07/Crypter-/blob/master/entregas/entrega_final/CONSTRUCTION%20OF%20SCENARIOS%20AND%20DESIGN%20OF%20TEST%20CASES.pdf)_

**CLASS DIAGRAM:** _[HERE](https://github.com/ValeArias07/Crypter-/blob/master/entregas/entrega_final/CLASS%20DIAGRAM.pdf)_

**VIDEO:**

[![Watch the video](https://img.youtube.com/vi/zJrlHIRZ7lg/hqdefault.jpg)](https://www.youtube.com/watch?v=zJrlHIRZ7lg)

# USE MANUAL📚

**Starting screen**

![Pantalla_Inicio](https://github.com/ValeArias07/Crypter-/blob/master/src/images/Pantalla_Inicio.PNG)

On this screen you will find 3 options:

**Encrypt and Decrypt**

Once you select Encrypt or Decrypt, a window will be displayed that will have the Settings option in the upper left

![Settings](https://github.com/ValeArias07/Crypter-/blob/master/src/images/Setting_Encrypt.png)

In this part you will have to select 2 options:

**TextInput:** Here you will have to choose if you want to enter the text through the console or through a text file.

![TxtInput](https://github.com/ValeArias07/Crypter-/blob/master/src/images/Setting_TxtInput.png)

- _Cosole:_ If you select console, a window opens to write the text.
          
![Console](https://github.com/ValeArias07/Crypter-/blob/master/src/images/Setting_Console.png)
         
- _Text file:_ If you select by a text file, the option to search for a document (.txt) on your computer is enabled.
          
![file](https://github.com/ValeArias07/Crypter-/blob/master/src/images/Setting_File.png)

**Method type:** You must choose a type of encryption or decryption method, either monoalphabetical or polyalphabetical.

![Method](https://github.com/ValeArias07/Crypter-/blob/master/src/images/Setting_Method.png)

- _Monoalphabetic:_ Within this section you will find two methods of encryption and decryption:

![Mono](https://github.com/ValeArias07/Crypter-/blob/master/src/images/Setting_Mono.png)

_Cesar_

![Cesar](https://github.com/ValeArias07/Crypter-/blob/master/src/images/Cesar_Encrypt.png)

_Atbash_

![Atbash](https://github.com/ValeArias07/Crypter-/blob/master/src/images/Atbash_Encrypt.png)

- _Polialphabetic:_ Within this section you will find two methods of encryption and decryption:

![Poli](https://github.com/ValeArias07/Crypter-/blob/master/src/images/Setting_Poli.png)

_Vigenère_

![Vigenere](https://github.com/ValeArias07/Crypter-/blob/master/src/images/Vigenere_Encrypt.png)

_AES_

![AES](https://github.com/ValeArias07/Crypter-/blob/master/src/images/AES_Encrypt.png)

**Editing text:** This is the window that is displayed when you want to change the format of an encrypted or decrypted text. You can change the letter, its size, color, among others.

![Editing](https://github.com/ValeArias07/Crypter-/blob/master/src/images/EnDecriptTxt.png)

**Route Manager**

![Route_Manager](https://github.com/ValeArias07/Crypter-/blob/master/src/images/Route_Manager.png)

Here you will have the possibility to manage the files that you have encrypted or decrypted. You can delete or view files, where you can also edit the text format and sort the files by name or date
