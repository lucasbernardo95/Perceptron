/**
 * @author lber 28/10/16
 */
public class Principal {
    public static void main(String[] args) {
        //Variável com valores das entradas
        int entradas[][] = { 
            {1,0,1,0}, 
            {0,1,0,1}, 
            {1,0,1,0},
            {0,1,1,1},
            {0,0,1,1},
            {0,0,0,1} 
        };
        //valores esperados como saída para cada linha de entrada
        int saidas[] = {0,1,0,1,0,1};
        
        //Valores dos pesos para cada entrada
        int pesos[] = {-1,1,-1,1};
        
        //Seta os valores de entradas, saídas esperadas para cada entrada, e os pesos para cada valor de entrada 
        Perceptron p = new Perceptron(entradas, saidas, pesos);
        //inicia o processo de aprendizagem da rede
        p.treinar();
    }
}
