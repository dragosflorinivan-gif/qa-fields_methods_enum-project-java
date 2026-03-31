FIELDS.METHODS.ENUM - tema

CERINTA

*Să creezi o clasă BrowserConfig care modelează configurația unui browser pentru teste automate,* 
*demonstrând utilizarea conceptelor de enum, constructori supraîncărcați cu this() și metode statice "factory".*

Reguli de Validare:

📌  Definește un enum public numit BrowserType în fișierul BrowserType.java.
○	Include valorile CHROME, FIREFOX, EDGE

📌  Definește clasa publică BrowserConfig în fișierul BrowserConfig.java.

○	Adaugă următoarele câmpuri private:

■	browser (de tip BrowserType)
■	version (de tip String)
■	isHeadless (de tip boolean)

○	Implementează 3 constructori publici supraîncărcați:

■	Un constructor care primește toți cei 3 parametri (browser, version, isHeadless) și inițializează câmpurile corespunzătoare folosind this.
■	Un constructor care primește doar browser și version. Acesta trebuie să apeleze constructorul principal folosind this(), setând isHeadless la false.
■	Un constructor care primește doar browser. Acesta trebuie să apeleze al doilea constructor folosind this(), setând version la "latest" și isHeadless la false.

○	Implementează Metoda Statică "Factory": Adaugă o metodă public static BrowserConfig createDefaultChromeConfig() 
care returnează o nouă instanță de BrowserConfig configurată pentru BrowserType.CHROME, versiunea "latest" și isHeadless setat la true.

○	Implementează Metoda de Afișare: Adaugă o metodă public void afiseazaConfig() care printează detaliile configurației obiectului curent (browser, version, isHeadless) 
într-un format lizibil în consolă (ex: "Browser: CHROME, Version: latest, Headless: true").

📌 Creează Clasa de Test TestConfigRunner:

○	Definește clasa publică TestConfigRunner în fișierul TestConfigRunner.java.

○	În metoda public static void main(String[] args):

■	Creează cel puțin o instanță BrowserConfig folosind fiecare dintre cei 3 constructori.
■	Creează o instanță BrowserConfig folosind metoda statică createDefaultChromeConfig().
■	Pentru fiecare instanță creată, apelează metoda afiseazaConfig() pentru a demonstra vizual 




REZOLVARE

- BrowserType va fi de tipul *enum* si va contine tipul de browser suportat (CHROME, FIREFOX si EDGE)
- BrowserConfig va contine in primul rand campurile private necesare (browser de tip BrowserType!!! -> va culege doar valorile din enum BrowserType configurat, version si isHeadless)
- Cei trei constructori creati vor fi supraîncărcați cu 3, 2 si un parametru. De asemenea metoda statică "Factory" va returna de fiecare data CHROME, latest si true
- Tot in fisierul BrowserConfig va fi adaugata o metoda de afisare ce va folosi valorile browser, version si isHeadless folosind *this*
- In fisierul TestConfigRunner.java vom avea practic scenariile de test pentru a testa fisierele precedente, BrowserConfig.java si BrowserType.java
- Pentru a fi interpretat de JVM, avem nevoie de *public static void main(String[] args)* unde vom construi tipurile de config dorite (obiecte) 
- Ultima parte va afisa configuratia pentru fiecare scenariu in parte, apeland metoda afiseazaConfig din BrowserConfig (este publică, deci poate fi utilizata de toate clasele:
        // Display configurations
        System.out.println("----- CONFIG 1 -----");
        c1.afiseazaConfig();



TESTARE

POZITIVA: 

T1:  
Instance using constructor with 3 parameters:
- BrowserConfig c1 = new BrowserConfig(BrowserType.CHROME, "146.0", true);

Expected:
----- CONFIG 1 -----
Detalii BrowserConfig:
  - Browser: CHROME
  - Version: 146.0
  - isHeadless: true

T2:  
Instance using constructor with 2 parameters:
- BrowserConfig c2 = new BrowserConfig(BrowserType.FIREFOX, "149.0");

Expected:
----- CONFIG 2 ------
Detalii BrowserConfig:
  - Browser: FIREFOX
  - Version: 149.0
  - isHeadless: false

T3:  
Instance using constructor with 1 parameter
- BrowserConfig c3 = new BrowserConfig(BrowserType.EDGE);

Expected:
----- CONFIG 3 -----
Detalii BrowserConfig:
  - Browser: EDGE
  - Version: latest
  - isHeadless: false
  
T4:
Instance using static method factory
- BrowserConfig c4 = BrowserConfig.createDefaultChromeConfig();

Expected:
----- CONFIG 4 (Factory) -----
Detalii BrowserConfig:
  - Browser: CHROME
  - Version: latest
  - isHeadless: true	


  
NEGATIVA (programul nu compileaza)

T5: 
No instance
- BrowserConfig c5 = BrowserConfig(); --> cannot find symbol method BrowserConfig()

T6: 
Wrong BrowserType
- BrowserConfig c6 = BrowserConfig(BrowserType.SAFARI); --> undefined browser type

T7: 
Make afiseazaConfig (BrowserConfig.java) from public to private --> cannot be accessed from TestConfigRunner.java
