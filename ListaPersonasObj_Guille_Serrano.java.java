import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Random;

public class ListaPersonasObj2 {
    public static void main(String[] args) {
        persona p1=new persona();
        persona p2=new persona();
        persona p3=new persona();
        persona p4=new persona();
        persona p5=new persona();

        
        //estableciendo los set antes de con el get obtener el resultado
        p1.setNombre("Hugo Sánchez");
        p1.setApellido("Márquez"); //este no es necesario  se puede tener nombre y apellido en uno solo
        System.out.println("La persona 1 es: "+p1.getNombre()+" "+p1.getApellido());


        p2.setNombre("Marco Polo Salvatierra");
        System.out.println("La persona 2 es: "+p2.getNombre());

        p3.setNombre("Juana de Arco");
        System.out.println("La persona 3 es: "+p3.getNombre());

        p4.setNombre("Juan Manuel Fangio");
        System.out.println("La persona 4 es: "+p4.getNombre());

        p5.setNombre("Rodolfo Neri Vela");
        System.out.println("La persona 5 es: "+p5.getNombre());

        //agregando los 5 a una lista

    
        

    List<String> listaDestino = new ArrayList<>();
    listaDestino.add(p1.getNombre());   //add es para añadir elementos pero solo cuando empleamos arraylist 
    listaDestino.add(p2.getNombre());
    listaDestino.add(p3.getNombre());
    listaDestino.add(p4.getNombre());
    listaDestino.add(p5.getNombre());

   
   System.out.println("\n Orden Original:\n ");
   for (String listaDestino2: listaDestino){ // ld es la lista que contiene los objetos 
    System.out.println(listaDestino2);       //ld2 nombre en el for de la nueva lista 

   }
   
    //System.out.println("\nLa lista de destino ¿contiene la lista origen?: "+p1.getNombre());

//Orden alfabetico
Collections.sort(listaDestino); 
//listaDestino.sort((n1,n2)->p1.compareToIgnoreCase(p2));   //como son letras y no numeros no podemos usar compareTo (requiere meter un metodo para compareTo)   en vez de eso usaremos  Collections
System.out.println("\nOrden alfabetico:\n");
for(String elemento:listaDestino){
    System.out.println(elemento);
}

//Orden inverso
Collections.sort(listaDestino,Collections.reverseOrder()); 
//listaDestino.sort((n1,n2)->p1.compareToIgnoreCase(p2));   //como son letras y no numeros no podemos usar compareTo (requiere meter un metodo para compareTo)   en vez de eso usaremos  Collections
System.out.println("\nOrden inverso:\n");
for(String elemento:listaDestino){
    System.out.println(elemento);
}
    
 


    
    }
}

class persona{
private String nombre, apellido;

//nombre GET Y SET
public String getNombre(){ //get retorna
    return nombre;
}

// public void setNombre(){     se puede asi tambien sin pasar parametros
// nombre="hugo"; //y poniendo valores desde aqui PERO SI YA VAN AQUI YA NO SE PONEN EN LOS () DEL OBJETO
// }

public void setNombre(String nombre){
    this.nombre=nombre;  //this le paso valores en el objeto
}

//apellido GET Y SET

public String getApellido(){
    return apellido;
}

public void setApellido(String apellido){
    this.apellido=apellido;
}

}

//ESTE SI FUNCIONA

/*   EL PRIMER PROGRAMA ListasPersonasObjetos SE CORROMPIO, PUES EN ESTE OTRO PROGRAMA O SEA AQUI ListasPersonasObj2.java
FUNCIONA   Y ESO QUE PUSIMOS EL CODIGO INTEGRO AQUI DE ESE AQUI
Y DE TODOS MODOS SALIA ESTO --LO MEJOR ES NO PONER EN CARPETAS LOS PROGRAMAS PORQUE ALGO LES PASA CUANDO SE GUARDAN EN CARPETAS

Exception in thread "main" java.lang.NoSuchMethodError: 'void ListaPersonasEntregable2.persona.setnombre(java.lang.String)'
        at ListaPersonasEntregable2.ListaPersonasObjetos.main(ListaPersonasObjetos.java:17)

Y AQUI FUNCIONA BIEN 


Este es un algoritmo que se estaba probando

    List<persona> alumnos = new ArrayList<>();
    Random random = new Random();
    int nAlumnos = (int)(Math.floor(Math.random()));//random.nextInt(10)+15;         
    for(int i=0;i< nAlumnos;i++){
       persona a = new persona();        //nombresAleatorios[i] = nombres[(int) (Math.floor(Math.random()
        a.setNombre("nombre " + i);
        alumnos.add(a); //Agrega alumno
    }
    

    //Consultamos alumnos        
    for(int j=0; j< alumnos.size(); j++){
      System.out.println(alumnos.get(j).getNombre());
    }
*/