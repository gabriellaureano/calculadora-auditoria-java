import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class GerenciadorArquivos {
    private static final String CAMINHO = "historico.txt";

    public static void salvarNoHistorico(String mensagem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO, true))) {
            writer.write(mensagem);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro crítico ao salvar arquivo: " + e.getMessage());
        }
    }

    public static void lerHistorico() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO))) {
            String linha;
            System.out.println("\n=== HISTÓRICO DE CÁLCULOS ===");
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
            System.out.println("=============================\n");
        } catch (FileNotFoundException e) {
            System.out.println("\n[!] O histórico ainda está vazio (arquivo não encontrado).\n");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}


interface Calculavel {
    default String executar() {
        return "";
    }
}

class VerificadorPrimo implements Calculavel{
    int num;

    public VerificadorPrimo(int num) {
        this.num = num;
    }

    @Override
    public String executar(){

        boolean ehprimo = true;

        if(num <= 1) ehprimo = false;

        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0 ){
                ehprimo = false;
                break;
            }
        }
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dateTime.format(formatador);

        String resultado = "["+dataFormatada+"] " + num + (ehprimo ? " é primo" : " não é primo");
        System.out.println("-=-=-= " + resultado + " =-=-=-");
        return resultado;
    }
}

class VerificadorParImpar implements Calculavel{
    int numero;

    public VerificadorParImpar(int numero) {
        this.numero = numero;
    }

    @Override
    public String executar(){

        boolean ehpar = true;

        if (numero % 2 != 0) ehpar = false;

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dateTime.format(formatador);

        String resultado = "["+dataFormatada+"] " + numero + (ehpar ? " é Par" : " é Impar");
        System.out.println("-=-=-= " + resultado + " =-=-=-");
        return resultado;
    }

}

class CalcularPotencia implements Calculavel{
    int base;
    int expoente;

    public CalcularPotencia(int base, int expoente) {
        this.base = base;
        this.expoente = expoente;
    }

    @Override
    public String executar(){
        double potencia = Math.pow(base,expoente);

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dateTime.format(formatador);

        String resultado = "["+dataFormatada+"]" + " " + base + " elevado a " + expoente + " é " + potencia;
        System.out.println("-=-=-= " + resultado + " =-=-=-");
        return resultado;
    }
}

class Menu{
    public static void menu(){
        System.out.println();
        System.out.println("Escolha:");
        System.out.println("1. VerificarPrimo");
        System.out.println("2. VerificarPar");
        System.out.println("3. Calcular Potência");
        System.out.println("4. Ver Histórico De Calculos");
        System.out.println("5. Sair");
    }

    public static void escolhaNumero(){
        System.out.println("Escolha um numero: ");
    }

        }

public class Main {
    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        while (true){

            try {
                Menu.menu();

                int resposta = teclado.nextInt();
                teclado.nextLine();

                if (resposta == 5) {
                    System.out.println("Saindo...");
                    break;
                }

                switch (resposta){
                    case 1:
                        Menu.escolhaNumero();
                        int numVP = teclado.nextInt();
                        teclado.nextLine();
                        VerificadorPrimo vp = new VerificadorPrimo(numVP);
                        String msgPrimo = vp.executar();
                        GerenciadorArquivos.salvarNoHistorico(msgPrimo);
                        break;

                    case 2:
                        Menu.escolhaNumero();
                        int numPI= teclado.nextInt();
                        teclado.nextLine();
                        VerificadorParImpar vpi = new VerificadorParImpar(numPI);
                        String msgParImpar = vpi.executar();
                        GerenciadorArquivos.salvarNoHistorico(msgParImpar);
                        break;
                    case 3:
                        System.out.println("Digite a base: ");
                        int base = teclado.nextInt();
                        teclado.nextLine();

                        System.out.println("Digite o expoente: ");
                        int expoente = teclado.nextInt();
                        teclado.nextLine();
                        CalcularPotencia cp = new CalcularPotencia(base,expoente);
                        String msgPotencia = cp.executar();
                        GerenciadorArquivos.salvarNoHistorico(msgPotencia);
                        break;

                    case 4:
                        GerenciadorArquivos.lerHistorico();
                        break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Erro: Você deve digitar apenas números inteiros!");
                teclado.nextLine();
            }
        }

    }
}












//        List<Calculavel> lista = new ArrayList<>();
//
//        lista.add(new VerificadorPrimo(5));
//        lista.add(new VerificadorPrimo(3));
//        lista.add(new VerificadorPrimo(8));
//        lista.add(new VerificadorParImpar(4));
//        lista.add(new VerificadorParImpar(6));
//        lista.add(new VerificadorParImpar(3));
//        lista.add(new VerificadorParImpar(9));
//
//
//        for (Calculavel num : lista){
//            num.executar();
//        }
//    }








//        for (Calculavel num : lista){
//            if(num instanceof VerificadorParImpar){
//                VerificadorParImpar verificadorParImpar = (VerificadorParImpar) num;
//                verificadorParImpar.executar();
//            }
//        }











//        Funcionario func = new Funcionario("Jose") {
//        };
//
//        System.out.println(func);
//        List<Funcionario> listaDeFuncionarios = new ArrayList<>();
//
//        listaDeFuncionarios.add(new Gerente("Gabriel"));
//        listaDeFuncionarios.add(new Desenvolvedor("Laureano"));
//
//        for (Funcionario funcionario : listaDeFuncionarios){
//            funcionario.calcularBonus();
//            if (funcionario instanceof Gerente ){
//                Gerente g = (Gerente) funcionario;
//                g.fazerLogin();
//            }
//        }
//    }

