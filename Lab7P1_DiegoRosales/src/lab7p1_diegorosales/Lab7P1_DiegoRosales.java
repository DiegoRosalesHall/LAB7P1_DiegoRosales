
package lab7p1_diegorosales;
/*
FILA: 2
ASIENTO: 1
*/
import java.util.Scanner;
import java.util.Random;
public class Lab7P1_DiegoRosales {
public static Random rand = new Random();
public static Scanner mcgregor = new Scanner(System.in);
    


public static void main(String[] args) {
    int contador_menu=1;   
    while(contador_menu==1){
        System.out.println("");
        System.out.println("Seleccione su programa:");
        System.out.println("1.~ TRES EN RAYA");
        System.out.println("2.~ PUNTOS DE SILLA");
        System.out.println("3.~ FINALIZAR PROGRAMA");
        
        int opcion_menu = mcgregor.nextInt();
        switch(opcion_menu){
            
            
            
            case 1:
                boolean empate;
                boolean victoria_bot;
                boolean victoria_usuario;
                int fila_m; // fila maquina
                int columna_m; // columna maquina
                boolean posicion_maquina = true;
                boolean posicion_valida = true;
                char opcion_raya='s';
                while(true){
                int victoria = 1;
                System.out.println("Bienvenido a tres en raya!");
                char [][] tablero_raya = generar_tablero();
                imprimir_tablero(tablero_raya);
                while(victoria==1 ){
                    System.out.println("Escoja la Columna [ 0, 1, 2 ]");
                    int fila = mcgregor.nextInt();
                    
                    System.out.println("Escoja la Fila [ 0, 1, 2 ]");
                    int columna = mcgregor.nextInt();
                    
                    posicion_valida = validar_posicion(fila,columna, tablero_raya);
                    
                    if (posicion_valida == true){
                        tablero_raya = elegir_posicion(tablero_raya, fila, columna);
                        imprimir_tablero(tablero_raya);
                        victoria_usuario = verificarvictoria(tablero_raya);
                         if(victoria_usuario == true){
                                System.out.println("HAS GANADO!");
                                victoria=2;
                                break;
                            }
                       empate = empate(tablero_raya);
                       if(empate == true){
                                System.out.println("EMPATE!");
                                break;
                            }
                        while(victoria==1){
                        
                        fila_m = fila_maquina();
                        columna_m = columna_maquina();
                        
                        posicion_maquina = validar_posicion_maquina(fila_m,columna_m,tablero_raya);
                        
                         if(posicion_maquina == true){
                           tablero_raya = elegir_posicion_maquina(fila_m,columna_m,tablero_raya);
                            imprimir_tablero(tablero_raya);
                            
                            victoria_bot = verificarvictoria_bot(tablero_raya);
                            empate = empate(tablero_raya);
                            if(victoria_usuario == true){
                                System.out.println("HAS GANADO!");
                                victoria=2;
                                break;
                            }
                            
                            
                            
                            else if (victoria_bot == true){
                                System.out.println("EL BOT HA GANADO!");
                                victoria=2;
                                break;
                           
                                
                            }
                            else if(empate == true){
                                System.out.println("EMPATE!");
                                break;
                            }
                            break;
                         }
                         else if(posicion_valida == false){
                             break;
                                    
                                    }
                           
                        }
                        
                       
                       
                        
                    }

                }
                
                
                
                
                // ELECCION DE USUARIO
                System.out.println("Desea jugar otra vez? s/n");
                opcion_raya = mcgregor.next().charAt(0);
                    if(opcion_raya=='n'){
                        break;
                    }
                    
                    else{
                        
                    }
                
                }// FIN WHILE OPCION USUARIO
                
                
                
                
                
                
                
                
                
                break; // TRES RAYA FINAL
                
           
            
            
            
            
            
            
            
            
            
            case 2: 
                int cm;
                System.out.println("Ingrese el tamaño de la matriz:");
                int tamano = mcgregor.nextInt();
                int matriz [][] = generarIntMatrizAleatoria(tamano);
                imprimir_matriz(matriz);
                cm = encontrarPuntoSilla(matriz);
               
                break;
                
            
            case 3:
                contador_menu=2;
                break;
            
        }// FIN DE SWITCH
           
       }//FIN WHILE MENU
    
    
    
    }// FINAL DEL MAIN
public static int [][]generarIntMatrizAleatoria(int t){
         int [][]matriz = new int [t][t];
         for(int i = 0; i < t; i++){
            for(int j = 0; j < t; j++){
                matriz[i][j]= rand.nextInt(1,99);
            }
        }
        return matriz;   
}


public static void imprimir_matriz(int [][] t){
    for (int i = 0; i<t.length ;i++) {
        for (int j = 0; j < t[i].length; j++) {
            if(t[i][j]<10){
             System.out.print("[ " + t[i][j] + "  ]");   
            }
            else{
                System.out.print("[ " + t[i][j] + " ]");
            }
            
        }
        System.out.println();
        
    }  
}

public static int encontrarPuntoSilla(int [][] matrix){
    int columna_menor = 100;
   int con =0;
   int coninverso=0;
   boolean silla=false;
   int punto_fila=0;
   int mayor = 0 ;
    for(int i=0;i<matrix.length;i++){
        
        for(int j=0;j<matrix[i].length;j++){
            if(matrix[i][j]<columna_menor){
                columna_menor = matrix[i][j];
                con = j;
                
            }
            
            
        
        
        
        
        
     
    }
       
        
        
        
        for(int k=0;k<matrix.length;k++){
            
            if( matrix[k][con]>mayor){
                mayor = matrix[k][con];
                punto_fila = k;
            
        }
        }
        
            
        

       
    
        
        
        if( mayor == columna_menor){
            silla =  true;
            System.out.println("HAY SILLA");
            System.out.println("Punto de matriz: [ "+punto_fila+" ]"+"[ "+con+" ]");
            System.out.println("Numero de silla: "+mayor);
        }
        else{
            
        }
       
        
        columna_menor=100;
        mayor=0;
        
    }
     if(silla==false){
         System.out.println("NO HAY SILLA");
     }
    
    
    return columna_menor;
}







// X0 METHODS INICIO   
public static void imprimir_tablero(char [][] tablero){
    for(int i=0; i<3;i++){
        for(int j=0;j<3;j++){
            if(j==0){
            System.out.print("[ "+tablero[i][j]+", ");
            }
            if( j==1){
              System.out.print(tablero[i][j]+",");  
            }
            if(j==2){
                System.out.print(" "+tablero[i][j]+" ]");
                System.out.println();
            }
        }
    }
    System.out.println("");
}// X0 METHODS INICIO


public static char[][] generar_tablero(){
    char [][] tablero = new char[3][3];
    for ( int i=0; i<3;i++){
        for (int j=0; j<3;j++){
            tablero[i][j]= ' ';
        }
    }

    return tablero;
  
}

public static boolean validar_posicion(int f, int c, char [][] tablero){
boolean posicion;
if(  f>2 || f<0 ||  c>2 || c<0 ){
    System.out.println("Error, posicion fuera de rango");
    posicion = false;
    

}
else if (tablero[c][f] == 'X' ||tablero[c][f] == '0' ){
   System.out.println("Error, posicion ocupada");
    posicion = false; 
}
else{ posicion=true;}

return posicion;
}

public static boolean validar_posicion_maquina(int fm, int cm, char [][] tablero){
boolean posicion;
if (tablero[cm][fm] == 'X' || tablero[cm][fm] == '0' ){
    
    posicion = false; 
}
else{ 
    posicion=true;
}

return posicion;
}

public static char [][] elegir_posicion(char [][] tablero, int f, int c){
    for(int i =0; i < 3; i++){
        for(int j=0; j<3;j++){
            tablero [c][f]= 'X';
        }
        
    }
return tablero;
}

public static int fila_maquina(){
    int fila_maquina = rand.nextInt(0,3);
    return fila_maquina;
    }

public static int columna_maquina(){
    int columna_maquina = rand.nextInt(0,3);
    return columna_maquina;

    }

public static char [][] elegir_posicion_maquina(int fm, int cm,char[][] tablero){
   for(int i =0; i < 3; i++){
        for(int j=0; j<3;j++){
            tablero [cm][fm]= '0';
        }
        
    } 
    return tablero;
}

public static boolean verificarvictoria(char[][] tablero){
    boolean victoria_humano = false;
    if(tablero[0][0] == 'X'&&tablero[1][1]=='X'&&tablero[2][2]=='X'){
     victoria_humano  = true;
    // DIAGONAL " \ "   
    }
    if(tablero[0][2] == 'X'&&tablero[1][1]=='X'&&tablero[2][0]=='X'){
        victoria_humano = true;
        // Diagonal " / "
    }
    if(tablero[0][0] == 'X'&&tablero[1][0]=='X'&&tablero[2][0]=='X'){
        victoria_humano = true;
        // vertical " | " izquierda 
    }
    
    if(tablero[0][1] == 'X'&&tablero[1][1]=='X'&&tablero[2][1]=='X'){
        victoria_humano = true;
        // vertical " | " centro
    }
    
    if(tablero[2][0] == 'X'&&tablero[2][1]=='X'&&tablero[2][2]=='X'){
        victoria_humano = true;
        // vertical" | " derecha
    }
    if(tablero[0][0] == 'X'&&tablero[0][1]=='X'&&tablero[0][2]=='X'){
        victoria_humano = true;
        // Horizontal " - " arriba
    }
    if(tablero[1][0] == 'X'&&tablero[1][1]=='X'&&tablero[1][2]=='X'){
        victoria_humano = true;
        // Horizontal " - " centro
    }
    if(tablero[0][2] == 'X'&&tablero[1][2]=='X'&&tablero[2][2]=='X'){
        victoria_humano = true;
        // Horizontal " - " abajo
    }
    return victoria_humano;
}
public static boolean verificarvictoria_bot(char[][] tablero){
    boolean victoria_bot = false;
    if(tablero[0][0] == '0'&&tablero[1][1]=='0'&&tablero[2][2]=='0'){
     victoria_bot  = true;
    // DIAGONAL " \ "   
    }
    if(tablero[0][2] == '0'&&tablero[1][1]=='0'&&tablero[2][0]=='0'){
        victoria_bot = true;
        // Diagonal " / "
    }
    if(tablero[0][0] == '0'&&tablero[1][0]=='0'&&tablero[2][0]=='0'){
        victoria_bot = true;
        // vertical " | " izquierda 
    }
    
    if(tablero[0][1] == '0'&&tablero[1][1]=='0'&&tablero[2][1]=='0'){
        victoria_bot = true;
        // vertical " | " centro
    }
    
    if(tablero[2][0] == '0'&&tablero[2][1]=='0'&&tablero[2][2]=='0'){
        victoria_bot = true;
        // vertical" | " derecha
    }
    if(tablero[0][0] == '0'&&tablero[0][1]=='0'&&tablero[0][2]=='0'){
        victoria_bot = true;
        // Horizontal " - " arriba
    }
    if(tablero[1][0] == '0'&&tablero[1][1]=='0'&&tablero[1][2]=='0'){
        victoria_bot = true;
        // Horizontal " - " centro
    }
    if(tablero[0][2] == '0'&&tablero[1][2]=='0'&&tablero[2][2]=='0'){
        victoria_bot = true;
        // Horizontal " - " abajo
    }
    
    
    return victoria_bot;
}
public static boolean empate(char [][] tablero){
    int contador=0;
    boolean empate = false;
    for(int i=0; i<3;i++){
        for(int j=0;j<3;j++){
            if (tablero [j][i]=='X' || tablero[j][i]=='0'){
                contador++;
            }
        }
        if( contador ==9){
            empate=true;
        }
    }

    
    return empate;
}
  // X0 METHODS FIN

//METHODS PUNTO DE SILLA









 
}// FINAL DE LA CLASS
