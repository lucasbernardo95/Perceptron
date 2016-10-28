
/**
 * @author lber 28/10/16
 */
public class Perceptron {

    int[][] entradas;
    int saidas[];
    int pesos[];
    double aprendizagem = 2;

    public Perceptron(int entradas[][], int saidas[], int pesos[]) {
        this.entradas = entradas;
        this.saidas = saidas;
        this.pesos = pesos;
    }

    public void treinar() {
        int saida = 0;
        for (int i = 0; i < entradas.length; i++) {//entradas.length corresponde às 6 linhas das entradas
            saida = ativacao(i);
            //e = Yd – Y 
            int erro = (saidas[i] - saida);
            //Caso a saída seja diferente da esperada, recalcula os pesos e repete a volta no laço
            if (saida != saidas[i]) {
                //envia o índice da entrada e o valor do erro que foi calculado
                calcularPesos(i, erro);
                //repete a volta
                --i;
            } else {//caso a saída seja o valor que era esperado 

                //printa a coluna com os valores corretos
                System.out.print("Entradas: ");
                for (int j = 0; j < entradas[0].length; j++) {
                    System.out.print(" " + entradas[i][j]);
                }
                System.out.println(" Saída esperada: " + saidas[i] + " Saída obtida: " + saida);
            }
        }

    }

    public void calcularPesos(int p, int erro) {
        for (int i = 0; i < pesos.length; i++) {
            pesos[i] = (int) (pesos[i] + aprendizagem * erro * entradas[i][i]);
            //System.out.println("novo peso " + i + " = " + (pesos[i] + aprendizagem * erro * entradas[i][i]));
        }
    }

    // Método responsável pelo somatório e a função de ativação.
    public int ativacao(int indice) {
        //variável para armazenar o somatório
        int soma = 0;
        for (int i = 0; i < pesos.length; i++) {
            soma += (pesos[i] * entradas[indice][i]);
        }
        /**
         * Se o sinal for forte, ou seja, maior que o limite estabelecido, deixa
         * o sinal passar caso contrário, não deixa.
         */
        return (soma >= 0) ? 1 : 0;//se for maior retorna 1, se não retorna 0
    }
}
