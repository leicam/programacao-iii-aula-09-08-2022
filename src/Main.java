import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            Integer[] array =
                    new Integer[] {9, 3, 8, 2, 7, 1};

            System.out.println("Antes: " +
                    obterDadosArray(array));

            System.out.println("Depois: " +
                    obterDadosArray(quicksort(array)));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String obterDadosArray(Integer[] array){
        String dados = "";

        for(Integer valor : array){
            dados += valor + ", ";
        }

        return  dados;
    }

    private static Integer[] quicksort(Integer[] array){
        if (array.length < 2)
            return array;

        Integer indice = (array.length - 1) / 2;
        Integer pivo = array[indice];

        List<Integer> menores = new ArrayList<Integer>();
        List<Integer> maiores = new ArrayList<Integer>();
        List<Integer> resultado = new ArrayList<Integer>();

        for (Integer valor : array){
            if (valor < pivo)
                menores.add(valor);
            else if (valor > pivo)
                maiores.add(valor);
        }

        menores = Arrays.asList(
                quicksort(menores.toArray(new Integer[menores.size()])));
        maiores = Arrays.asList(
                quicksort(maiores.toArray(new Integer[maiores.size()])));

        resultado.addAll(menores);
        resultado.add(pivo);
        resultado.addAll(maiores);

        return resultado
                .toArray(new Integer[resultado.size()]);
    }





}