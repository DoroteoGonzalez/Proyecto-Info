import java.time.chrono.IsoChronology;

import org.xml.sax.ext.LexicalHandler;

/*
    Esta es su clase principal. El unico metodo que debe implementar es
    public String[] solve(Maze maze)
    pero es libre de crear otros metodos y clases en este u otro archivo que desee.
*/
public class Solver{
    private Node actual = maze.getStartingSpace();  /*Inicializa el nodo actual como (0, 0, 0) */
    private String way = ""; /*El string en el que se guardaran los pasos para finalizar el laberinto (la cueva pues) */
    private ArrayList<Node> visited; /*[(x, x, x), (y, y, y), (z, z, z), ...]  Un arreglo en el que se guardaran los nodos que hayamos visitado, servira como registro. */
    private ArrayList<Node> danger; /*Un arreglo que nos servira de apoyo a la hora de encontrarnos una cueva con peligro dentro, igual servira de registro*/

    public Solver(){
        //Sientase libre de implementar el contructor de la forma que usted lo desee
       
    }
    
    public String magia(Maze maze, node inical,  String way, ArrayList<Node> danger, ArrayList<Node> visited){ /*Usted diga que si xd */
        //Sientase libre de implementar el contructor de la forma que usted lo desee
        if (!maze.isExitSpace(inical.xIndex, inical.yIndex, inical.zIndex)){ /*La funcion .isExitSpace devuelve el nodo que contiene la salida, y lo compraramos con nuestro nodo inicial */
            visited.add(inical); /*Si el nodo inicial no es la salida, guarda el nodo en el arreglo visited*/

        if(actual.danger){/*.danger es una funcion que nos dice si la cueva en la que estamos contiene o no un peligro */
            danger.add(actual);/*Guarda el nodo actual en el arreglo danger */
            actual = visited.get(visited.size() - 1);/*Cambia nuestro nodo actual, a el nodo anterior registrado en el arreglo visited*/
            way = way.substring(way);
        }
        if (!visited.contains(maze.movenorth(actual)) && actual.north){
            way = way + "N";
            actual = maze.moveNorth(actual);
        }
        if (!visited.contains(maze.movesouth(actual)) && actual.south){
            way = way + "S";
            actual = maze.moveSouth(actual);
        }
        if (!visited.contains(maze.moveEast(actual)) && actual.east){
            way = way + "E";
            actual = maze.moveEast(actual);
        }
        if (!visited.contains(maze.moveWest(actual)) && actual.west){
            way = way + "W";
            actual = maze.moveWest(actual);
        }
        if (!visited.contains(maze.moveUp(actual)) && actual.up){
            way = way + "U";
            actual = maze.moveUp(actual);
        }
        if (!visited.contains(maze.moveDown(actual)) && actual.down){ 
            way = way + "D";
            actual = maze.moveDown(actual);
        }
        /*En general las funciones ateriores son de dos condiciones, la primera comprueba si el nodo siguiente aun no ha sido visitado y la segunda comprueba que podamos movernos a ese nodo */
        /*Si se cumplen las condiciones, se agregara la direccion a seguir al string way */
        /*Y se movera al siguiente nodo */
         }
        if (way.length() >= 1){
            way = way.substring(0, way.length());
        }
        return way;
    }
    
    public String solve(Maze maze){
        //Implemente su metodo aqui. Sientase libre de implementar métodos adicionales
        Node inicial = actual; /*Iniciamos el recorrido en el nodo (0, 0, 0) */
        String aux = Magia(maze, inicial, way, danger, visited);  /*Manda los datos requeridos para que ocurra la magia (se resuelva el laberinto) */
        String answer = "[" + aux + "]"; /*Colocamos nuestra respuesta en el formato de entrega */

        return answer;
        }

}