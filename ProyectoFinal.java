import javax.swing.*;
import java.io.*; 
import java.util.Scanner;

public class ProyectoFinal {

   //nombre: menuSearch.
   //propósito: submenu para la opcion 2 del Main Menu.
   //precondiciones: String, Int
   //postcondiciones: String, Int
   //argumentos que recibe y su descripción: n/a
   //valores que devuelve : String
   //excepciones: n/a
   //autor: Manuel Ruiz
   //algoritmo : El metodo pide al usuario que entre una opcion y luego ejecuta con respecto a dicha opcion.
   //funciones a las que hace referencia : showInputDialog, parseInt, showMessageDialog
   //fecha de creación: May/3/2019
   //versión: 1.0

   public static void menuSearch() {
   
      int opcion,        
          noRec;
      String fecha,
             opt, 
             strNoRec;  
      opt = JOptionPane.showInputDialog("\nSearch by:\n1. No. Rec\n2. Date\n3. Return\n"); 
      opcion = Integer.parseInt(opt); 
                                 
      while (opcion != 3){ 
         switch(opcion){               
            case 1:
               {  
                  strNoRec = JOptionPane.showInputDialog("\nEnter No. of Record:\n"); 
                  noRec = Integer.parseInt(strNoRec); 
                  buscaPacientes(noRec); 
                  break;
               }               
            case 2:
               {                 
                  fecha = JOptionPane.showInputDialog("\nEnter Appointment Date (MM/DD/YYYY): \n"); 
                  buscaPacientesFecha(fecha);                          
                  break;
               }               
            case 3:
               { 
                  break;
               }               
            default :
               { 
                  JOptionPane.showMessageDialog(null, "Try again!", "Wrong Option" , JOptionPane.PLAIN_MESSAGE); 
                  break;
               }              
         }            
         opt = JOptionPane.showInputDialog("\nSearch by:\n1. No. Rec\n2. Date\n3. Return\n"); 
         opcion = Integer.parseInt(opt); 
      }
   }
 
   //nombre: menuChange.
   //propósito: submenu para la opcion 3 del Main Menu.
   //precondiciones: String, Int
   //postcondiciones: String, Int
   //argumentos que recibe y su descripción: n/a
   //valores que devuelve : String
   //excepciones: n/a
   //autor: Manuel Ruiz
   //algoritmo : El metodo pide al usuario que entre una opcion y luego ejecuta con respecto a dicha opcion.
   //funciones a las que hace referencia : showInputDialog, parseInt, showMessageDialog
   //fecha de creación: May/3/2019
   //versión: 1.0
                    
   public static void menuChange() {
   
      int opcion;         
      String opt;            
      opt = JOptionPane.showInputDialog("\nChange:\n1. Username\n2. Password\n3. Return\n"); 
      opcion = Integer.parseInt(opt); 
      while (opcion != 3){    
         switch(opcion){
            case 1:
               { 
                  changeUsername();
                  break;
               }               
            case 2:
               { 
                  changePassword();
                  break;
               }               
            case 3:
               { 
                  break;
               }               
            default :
               { 
                  JOptionPane.showMessageDialog(null, "Try again!", "Wrong Option" , JOptionPane.PLAIN_MESSAGE); 
                  break;
               }               
         }             
         opt = JOptionPane.showInputDialog("\nChange:\n1. Username\n2. Password\n3. Return\n");
         opcion = Integer.parseInt(opt); 
      }
   }
            

   //nombre: createUsername.
   //propósito: Primero busca si existe un archivo que contiene un username, de no existir el metodo lo crea.
   //precondiciones: Tipo String
   //postcondiciones: Tipo String
   //argumentos que recibe y su descripción: Recibe argumentos tipo String ingresador por el usuario
   //valores que devuelve : Devuelve valores Tipo String que almacena en el .txt
   //excepciones: La primera exepcion se utiliza para crear el password, la segunda es por si ocurre algun error.
   //autor: Manuel Ruiz
   //algoritmo : Este metodo primero intenta leer username.txt, de este no existir pasa a Create username seguido del proximo try que crea el archivo.
   //funciones a las que hace referencia : FileReader, BufferedReader, showInputDialog.
   //fecha de creación: May/3/2019
   //versión: 1.0
   public static void createUsername() {  
      String username; 
        
      try {
         FileReader fr = new FileReader("username.txt");    
         BufferedReader br = new BufferedReader(fr);  
         br.close();      
      } catch (IOException e) {     
         username = JOptionPane.showInputDialog("\nCreate a username: \n");
            
         try{
            PrintWriter pr = new PrintWriter ("username.txt"); 
            pr.println(username); 
            pr.close(); 
         } catch (IOException b){
            System.out.println("File error " + e);
         }
      }     
   } //end createUsername
   
   
   
   //nombre: changeUsername
   //propósito: cambiar una constraseña ya existente
   //precondiciones: String
   //postcondiciones: String
   //argumentos que recibe y su descripción: Recibe argumentos tipo string ingresados por el usuario
   //valores que devuelve: Devuelve valores tipo String que almacena en Username.txt
   //excepciones: Utiliza la Excepcion para detectar si existe algún error.
   //autor: Manuel Ruiz
   //algoritmo : Este metodo se utiliza para cambiar un Username ya existente por uno nuevo. 
   //funciones a las que hace referencia: PrintWriter y showInputDialog
   //fecha de creación: May/3/2019
   //versión: 1.0

   public static void changeUsername(){
      String username;      
      try {         
         username = JOptionPane.showInputDialog("\nEnter new username: \n"); 
         PrintWriter pr = new PrintWriter ("username.txt"); 
         pr.println(username);       
         pr.close();     
      } catch (IOException b){
         System.out.println("File error " + b);
      }
   } //end changeUsername()



   //nombre: createPassword.
   //propósito: Primero busca si existe un archivo que contiene una contraseña, de no existir el metodo lo crea.
   //precondiciones: Tipo String
   //postcondiciones: Tipo String
   //argumentos que recibe y su descripción: Recibe argumentos tipo String ingresador por el usuario
   //valores que devuelve : Devuelve valores Tipo String que almacena en el .txt
   //excepciones: La primera exepcion se utiliza para crear el password, la segunda es por si ocurre algun error.
   //autor: Manuel Ruiz
   //algoritmo : Este metodo primero intenta leer password.txt, de este no existir pasa a Create password seguido del proximo try que crea el archivo.
   //funciones a las que hace referencia : FileReader, BufferedReader, showInputDialog.
   //fecha de creación: May/3/2019
   //versión: 1.0
   
   public static void createPassword() {    
      String password;       
      try {
         FileReader fr = new FileReader("password.txt");     
         BufferedReader br = new BufferedReader(fr);    
         br.close();      
      } catch (IOException e) {      
         password = JOptionPane.showInputDialog("\nCreate a password: \n"); 
      
         try{
            PrintWriter pr = new PrintWriter ("password.txt"); 
            pr.println(password); 
            pr.close();     
         } catch (IOException b){
            System.out.println("File error " + e);
         }
      }
   } //end createPass

   //nombre: changePassword
   //propósito: cambiar una constraseña ya existente
   //precondiciones: String
   //postcondiciones: String
   //argumentos que recibe y su descripción: Recibe argumentos tipo string ingresados por el usuario
   //valores que devuelve: Devuelve valores tipo String que almacena en password.txt
   //excepciones: Utiliza la Excepcion para detectar si existe algún error.
   //autor: Manuel Ruiz
   //algoritmo : Este metodo se utiliza para cambiar una contraseña ya existente por una nueva. 
   //funciones a las que hace referencia: PrintWriter y showInputDialog
   //fecha de creación: May/3/2019
   //versión: 1.0
   public static void changePassword(){   
      String password; 
     
      try {
         
         password = JOptionPane.showInputDialog("\nEnter new password: \n"); 
         PrintWriter pr = new PrintWriter ("password.txt"); 
         pr.println(password); 
         pr.close();  
      } catch (IOException b){
         System.out.println("File error " + b);
      }
   } //end changePassword()

   //nombre: verifyLogin
   //propósito: Verificar la contraseña
   //precondiciones: String, int,
   //postcondiciones: String
   //argumentos que recibe y su descripción: Recibe argumentos tipo String ingresados por el usuario para verificar si el usurname la contraseña son correctos
   //valores que devuelve : Devuelve valores int. si el username y la contraseña son correctos almacena 0 en la variable opcion, si son incorrectos devuelve un 6
   //excepciones: Utiliza la Excepcion para detectar si existe algún error. 
   //autor: Manuel Ruiz   
   //algoritmo : Este metodo se utiliza para verificar si el usuario está ingresando la contraseña correcta, para poder acceder al programa.
   //funciones a las que hace referencia : ReadLine, FileReader, BufferedReader y showMessageDialog.
   //fecha de creación:May/3/2019
   //versión:1.0
   public static int verifyLogin(String user, String pass) {  
      int opcion = 5;    
      try {
         String line,   
            username,
            password;            
         FileReader fr2 = new FileReader("username.txt");     
         BufferedReader br2 = new BufferedReader(fr2); 
         FileReader fr3 = new FileReader("password.txt");   
         BufferedReader br3 = new BufferedReader(fr3);  
      
         while ((line = br2.readLine()) != null) { 
            if(line.contains(user)){ 
               username = line;               
               if (username.equals(user)){            
                  while ((line = br3.readLine()) != null) { 
                     if (line.contains(pass)) {  
                        password = line;            
                        if (password.equals(pass)) {  
                           opcion = 0;
                        } else {   //if line.equals(pass)                     
                        }                      
                     } else { // if line.contains(pass)){
                     }   
                  } //end while                    
               } else { // if username.equals(user)
               } 
            } else { // if line.contains(user)
            } br3.close();
            br2.close();                 
         } //end while     
      } catch (IOException e) { 
      }
      return (opcion);
   }//end verifyLogin



   //nombre: getPacientes
   //propósito: Almacena pacientes en archivos
   //precondiciones: int, String
   //postcondiciones: int, String
   //argumentos que recibe y su descripción: Recibe argumentos tipos string ingresados por el usuario
   //valores que devuelve : Almacena valores que fueron ingresados por el usuario y aumenta la variable count que tambien se guarda en otro archivo
   //excepciones: Utiliza la Excepcion para detectar si existe algún error.
   //autor: Cesar Velez
   //algoritmo : Este metodo primero lee la cantidad de archivos que se han guardado en count.tct y luego crea el nuevo archivo. (Esto para evitar borrar archivos existentes) 
   //funciones a las que hace referencia : FileReader, hasNextLine(), nextLine(), valueOf()
   //fecha de creación:May/3/2019
   //versión:1.0    
   
   public static void getPacientes() {      
      FileReader reader1;
      Scanner fileInput1;
      String strLine;
      int count = 0;
   
      try{
         reader1 = new FileReader("count.txt");
         fileInput1 = new Scanner(reader1);
         while (fileInput1.hasNextLine()){
            strLine = fileInput1.nextLine();
            count = Integer.valueOf(strLine);
         } fileInput1.close();
      } catch (IOException z){
      }
   
      FileReader reader;
      Scanner fileInput;
      PrintWriter fileOutput;
      PrintWriter write;
      int nDeRecord;
      String name,
          inicial,
          apellidos,    
          soc,
          DoB,
          sex,
          address,
          planMed,
          fechaVisita,
          diag,
          receta,
          nextVisit;                 
      nDeRecord = count+1;
                                 
      fechaVisita = JOptionPane.showInputDialog("\nToday's Date (MM/DD/YYYY): \n");         
      name  = JOptionPane.showInputDialog("No. of Record: " +nDeRecord+ "\nName: ");       
      inicial  = JOptionPane.showInputDialog("\nMiddle Initial: \n");        
      apellidos  = JOptionPane.showInputDialog("\nLast Name: \n");
      soc  = JOptionPane.showInputDialog("\nSSN (xxx-xx-xxxx): \n");
      DoB  = JOptionPane.showInputDialog("\nDoB (MM/DD/YYYY): \n");
      sex  = JOptionPane.showInputDialog("\nGender (M/F): \n");
      address = JOptionPane.showInputDialog("\nAddress: \n");
      planMed  = JOptionPane.showInputDialog("\nMedical Insurance: \n");       
      diag = JOptionPane.showInputDialog("\nDiagnostic: \n");
      receta = JOptionPane.showInputDialog("\nPrescription: \n");
      nextVisit = JOptionPane.showInputDialog("\nNext Appointment (MM/DD/YYYY): \n");              
                        
      try{
         fileOutput = new PrintWriter(nDeRecord+".txt");
         fileOutput.println("---------------------------------------");
         fileOutput.println("No. de Record: " + nDeRecord);
         fileOutput.println("Last Appointment: " + fechaVisita);
         fileOutput.println("Name: " + name);
         fileOutput.println("Middle Initial: " + inicial);
         fileOutput.println("Last Name: " + apellidos);
         fileOutput.println("SSN: " + soc);
         fileOutput.println("Date of birth: " + DoB);
         fileOutput.println("Gender: " + sex);
         fileOutput.println("Address: " + address);
         fileOutput.println("Medical Insurance: " + planMed);           
         fileOutput.println("Diagnostic: " + diag);
         fileOutput.println("Prescription: " + receta);
         fileOutput.println("Next Appointment: " + nextVisit);
         fileOutput.println("---------------------------------------");
         fileOutput.close();            
      } catch (IOException e){
         System.out.println("File error " + e);
      }//end catch
   
      try{
         write = new PrintWriter("count.txt");
         write.println(nDeRecord);
         write.close();            
      } catch (IOException e){
         System.out.println("File error " + e);
      }//end catch
   } //end getPacientes()

   //nombre: buscaPacientes
   //propósito: Buscar pacientes mediante un numero ingresado por el usuario, en este caso lo utilizaremos para los numero de record
   //precondiciones:  int
   //postcondiciones: String
   //argumentos que recibe y su descripción: Recibe argumentos tipo int que es utilizado para localizar el archivo
   //valores que devuelve : Devuelve valores tipo String con la informacion ingresada dentro del archivo
   //excepciones: Utiliza la Excepcion para detectar si existe algún error.
   //autor: Manuel Ruiz
   //algoritmo : Este metodo busca el numero de archivo ingresado por el usuario (En nuestro caso el numero de record) y nos permite localizarlo
   //funciones a las que hace referencia : FileReader, BufferedReader
   //fecha de creación:May/3/2019
   //versión:1.0
   public static void buscaPacientes(int a){
    
      try {
         FileReader fr = new FileReader(a+".txt");     
         BufferedReader br = new BufferedReader(fr);
         String str;    
         while ((str = br.readLine()) !=null) {
            System.out.println(str);
         } br.close();    
      } catch (IOException e) {
         JOptionPane.showMessageDialog(null, "Try again!", "File not Found" , JOptionPane.PLAIN_MESSAGE);
      }
   }//end busca pacientes

   //nombre: buscaPacientesFecha
   //propósito: Buscar información de pacientes, según una fecha en especifico.
   //precondiciones: Int, String
   //postcondiciones: String
   //argumentos que recibe y su descripción: Recibe argumentos tipo String la fecha de la proxima visita ingresada por el usuario
   //valores que devuelve : Devuelve valores tipo String que muestra en la pantalla toda la informacion del paciente o pacientes con la misma fecha de proxima visita
   //excepciones: Utiliza la Excepcion para detectar si existe algún error. 
   //autor: Manuel Ruiz
   //algoritmo : Este metodo busca todos los archivos y solo muestra en pantalla los que concuerden con la fecha de proxima visita
   //funciones a las que hace referencia : FileReader, Scanner, hasNextLine(), nextLine(), valueOf()
   //fecha de creación:May/3/2019
   //versión:1.0
   public static void buscaPacientesFecha(String a){    
      FileReader reader; 
      Scanner fileInput;
      String strLine;
      int count=0;
      boolean match = false;
   
      try{
         reader = new FileReader("count.txt");
         fileInput = new Scanner(reader);
         while (fileInput.hasNextLine()){
            strLine = fileInput.nextLine();
            count = Integer.valueOf(strLine);
         } fileInput.close();
      } catch (IOException e) {
         JOptionPane.showMessageDialog(null, "Try again!", "File not Found" , JOptionPane.PLAIN_MESSAGE);
      }
   
      for (int i=1; i <= count; i++){
         try{ 
            String line, nextVisit,
               line2;  
            FileReader fr2 = new FileReader(i+".txt"); 
            FileReader fr3 = new FileReader(i+".txt");      
            BufferedReader br2 = new BufferedReader(fr2); 
            BufferedReader br3 = new BufferedReader(fr3);
            while ((line = br2.readLine()) != null) {
               if (line.contains("Appointment: " + a)){
                  match = true;
                  while ((line2 = br3.readLine()) != null) {          
                     System.out.println(line2);   
                  }     
               }         
            } br3.close();
            br2.close();        
         } catch (IOException e) {   
         }      
      }// end for
        
      if (!match){
         JOptionPane.showMessageDialog(null, "No appointments on this date", a , JOptionPane.PLAIN_MESSAGE);  
      }          
   } //end buscarPacientesFecha()
    
    
    

   //nombre: editarPaciente
   //propósito: Editar archivos de pacientes ya existente
   //precondiciones: Tipo String
   //postcondiciones: Tipo String
   //argumentos que recibe y su descripción: Recibe mediante el usuario que numero de record será editado, seguido de los datos del paciente
   //valores que devuelve : devuelve valores Sring que se almacenan en un archivo según el numero de record del paciente
   //excepciones: Utiliza la Excepcion para detectar si existe algún error.
   //autor: Manuel Ruiz
   //algoritmo : El metodo pide al usuario que numero de record editará,  seguido de los datos del paciente y finalmente los almacena en el archivo según el numero de record     
   //funciones a las que hace referencia : Scanner, FileReader, PrintWriter, nextLine()
   //fecha de creación:May/3/2019
   //versión:1.0
   public static void editarPaciente(){
      Scanner input = new Scanner (System.in);
      FileReader reader;     
      PrintWriter fileOutput;
      String nDeRecord,
             name,
             inicial,
             apellidos,
             soc,
             DoB,
             sex,
             address,
             planMed,
             fechaVisita,
             diag,
             receta,
             nextVisit; 
                    
      nDeRecord = JOptionPane.showInputDialog("Enter the patient's No. of Record:");      
      try {
         reader = new FileReader(nDeRecord+".txt");
         Scanner fileInput = new Scanner (reader);        
         fechaVisita = JOptionPane.showInputDialog("\nToday's Date (MM/DD/YYYY): \n");             
         name  = JOptionPane.showInputDialog("Name:");
         inicial  = JOptionPane.showInputDialog("\nMiddle Initial: \n");
         apellidos  = JOptionPane.showInputDialog("\nLast Name: \n");
         soc  = JOptionPane.showInputDialog("\nSSN (xxx-xx-xxxx): \n");
         DoB  = JOptionPane.showInputDialog("\nDoB (MM/DD/YYYY): \n");
         sex  = JOptionPane.showInputDialog("\nGender (M/F): \n");
         address = JOptionPane.showInputDialog("\nAddress: \n");
         planMed  = JOptionPane.showInputDialog("\nMedical Insurance: \n");          
         diag = JOptionPane.showInputDialog("\nDiagnostic: \n");
         receta = JOptionPane.showInputDialog("\nPrescription: \n");
         nextVisit = JOptionPane.showInputDialog("\nNext Appointment (MM/DD/YYYY): \n");             
      
         try{
            fileOutput = new PrintWriter(nDeRecord+".txt");
            fileOutput.println("---------------------------------------");         
            fileOutput.println("No. of Record: " + nDeRecord);
            fileOutput.println("Last Appointment: " + fechaVisita);
            fileOutput.println("Name: " + name);
            fileOutput.println("Middle Initial: " + inicial);
            fileOutput.println("Last Name: " + apellidos);
            fileOutput.println("SSN: " + soc);
            fileOutput.println("Date of Birth: " + DoB);
            fileOutput.println("Gender: " + sex);
            fileOutput.println("Address: " + address);
            fileOutput.println("Medical Insurance: " + planMed);         
            fileOutput.println("Diagnostic: " + diag);
            fileOutput.println("Prescription: " + receta);
            fileOutput.println("Next Appointment: " + nextVisit);
            fileOutput.println("---------------------------------------");
            fileOutput.close();
         } catch (IOException e){
            System.out.println("File error " + e);
         }    
      
      } catch (IOException w){
         JOptionPane.showMessageDialog(null, "Try again!", "File not Found" , JOptionPane.PLAIN_MESSAGE);       
      }
   }   //end editarPaciente()
              
   public static void main(String[]args){ //comienza el programa     
      Scanner input = new Scanner (System.in);      
      int opcion, //declaracion de variables tipo int para utilizar las opciones del switch y para buscar por numero de record          
         noRec;
      String pass, 
          opt, 
          user, //declaracion de variable tipo String para verificar el password y para poder buscar por la fecha de la proxima visita
          fecha;  
      
      JOptionPane.showMessageDialog(null, "This program was created by Manuel Ruiz and Cesar Velez. It's purpose is to create a medical record.", "Welcome!" , JOptionPane.PLAIN_MESSAGE);
      
      createUsername(); //invoca el metodo create a username, pero si el username existe el programa pasa a el proximo metodo que seria create a password
      createPassword(); //invoca el metodo create a password, pero si el password existe el programa pasa a el proximo metodo que seria verifyPassword
      user = JOptionPane.showInputDialog("\nEnter username: \n");  
      pass = JOptionPane.showInputDialog("\nEnter password: \n");        
      opcion = verifyLogin(user,pass);     
    for (int i=0; i<3; i++){
      if (opcion == 5){
      if (i<2){
      JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Woops!" , JOptionPane.PLAIN_MESSAGE); 
      user = JOptionPane.showInputDialog("\nEnter username: \n");  
      pass = JOptionPane.showInputDialog("\nEnter password: \n");
      opcion = verifyLogin(user,pass);
      } else {
      JOptionPane.showMessageDialog(null, "Goodbye!", "Incorrect Username or Password" , JOptionPane.PLAIN_MESSAGE);      
      }
      }
     }
         
      while(opcion != 5){ //mientras la opcion no sea igual a 5 va a seguir ejecutando        
         opt = JOptionPane.showInputDialog("\nMAIN MENU:\n1. Add Patient\n2. Search Patient\n3. Edit Patient\n4. Change Username or Password\n5. Exit\n");  
         opcion = Integer.parseInt(opt);         
         switch(opcion){
            case 1:
               { //invoca el metodo getPacientes();
                  getPacientes();
                  break;
               }            
            case 2:
               { 
                  menuSearch();
                  break;
               }               
            case 3:
               { //invoca el metodo editarPaciente();
                  editarPaciente();
                  break;
               }
            case 4:
               { //invoca el metodo changeUsername();
                  menuChange();
                  break;
               }            
            case 5:
               { //Salir del programa
                  JOptionPane.showMessageDialog(null, "See you later!", "Goodbye!" , JOptionPane.PLAIN_MESSAGE);
                  break;
               }   
            default:
               { //Si ninguna de las opciones anteriores es ingresada, se envia un mensaje de opcion incorrecta.
                  JOptionPane.showMessageDialog(null, "Try again!", "Wrong Option" , JOptionPane.PLAIN_MESSAGE);
               }
         } //end swtich
      } //end while
   } //end main
} //end class