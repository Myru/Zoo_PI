/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PI.UFABC;

/**
 *
 * @author Myru
 */

import java.io.BufferedReader; // Para fazer a leitura arquivo.txt
import java.io.FileReader; // Para habilitar leitura de um arquivo.txt
import java.io.FileWriter; // Para habilitar escrita em um aquivo.txt
import java.io.IOException; // Para possivel erro de IO
import java.io.PrintWriter; // Para fazer a escrita em arquivo.txt
import java.util.Scanner; // Para reconhcer entrada de dados via teclado

public class Zoo_Main {

    /**
     * @param args the command line arguments
     */
    
    static String aux; // variavel global auxiliar de entrada de texto

    /*os contadores necessitam ser globais, pois senao seriam "re-criados" a
    cada chamada da funcao */
    static int contAni = 0; // contador de quantos animais estao catalogados
    static int contFunc = 0; // contador de quantos funcionario estao catalogados
    static int contJaula = 0; // contador de quantas jaulas estao catalogadas
    static int contAlimenta = 0; // contador de quantos registros de alimentacao estao catalogadas
    static int contLimp = 0; // contador de quantos registros de limpeza estao catalogados
    static int contCodAlimenta = 0; // contador interno para Codigo da Alimentacao
    static int contCodLimp = 0; // contador interno para Codigo da Limpeza
    //matrizes sao globais, pois serao usadas em mais de um void, todas com 50 linhas
    static String animal[][] = new String[50][5]; // matriz para catalogar animais
    static String func[][] = new String[50][4]; // matriz para catalogar funcionarios
    static String jaula[][] = new String[50][3]; // matriz para catalogar jaulas
    static String alimenta[][] = new String[50][8]; // matriz para catalogar alimentações
    static String limpeza[][] = new String[50][4]; // matriz para catalogar limpeza
    static int opmenu = 0; // variavel global de controle de opcao do menu
    static int i = 0; // variavel global de incremento de laco de repeticao
    static int j = 0; // variavel global de incremento de laco de repetição
    static int flag = 0; // variavel global de controle
    static Scanner teclado = new Scanner(System.in); // instancia de entrada de dados

    // Aonde serão salvos os valores das matrizes nos arquivos .txt
    public static void salvar() {

        /* Para cada matriz é criado um arquivo.txt para armazenar seus valores
         * As logicas sao as mesmas para cada matriz
         * sem necessidade de comentar todos os passos
         */
        try {
            // cria variavel para criar arquivo de texto animal.txt
            FileWriter fwAni = new FileWriter("animal.txt");

            // cria variavel para escrever no arquivo de texto passado por fwAni
            PrintWriter outAni = new PrintWriter(fwAni);

            // laco para escrever todos os valores da matriz animal em animal.txt
            for (i = 0; i < contAni; i++) {
                outAni.println(animal[i][0] + "\t" + animal[i][1] + "\t" + animal[i][2] + "\t" + animal[i][3] + "\t" + animal[i][4]);
            }

            // encerra atividades da variavel outAni
            outAni.close();

            // Os proximos comandos fazem referencias as outras 4 matrizes
            FileWriter fwFunc = new FileWriter("funcionario.txt");
            PrintWriter outFunc = new PrintWriter(fwFunc);
            for (i = 0; i < contFunc; i++) {
                outFunc.println(func[i][0] + "\t" + func[i][1] + "\t" + func[i][2] + "\t" + func[i][3]);
            }
            outFunc.close();

            FileWriter fwJau = new FileWriter("jaula.txt");
            PrintWriter outJau = new PrintWriter(fwJau);
            for (i = 0; i < contJaula; i++) {
                outJau.println(jaula[i][0] + "\t" + jaula[i][1] + "\t" + jaula[i][2]);
            }
            outJau.close();

            FileWriter fwAli = new FileWriter("alimenta.txt");
            PrintWriter outAli = new PrintWriter(fwAli);
            for (i = 0; i < contAlimenta; i++) {
                outAli.println(alimenta[i][0] + "\t" + alimenta[i][1] + "\t" + alimenta[i][2] + "\t" + alimenta[i][3] + "\t" + alimenta[i][4] + "\t" + alimenta[i][5] + "\t" + alimenta[i][6] + "\t" + alimenta[i][7]);
            }
            outAli.close();

            FileWriter fwLimp = new FileWriter("limpeza.txt");
            PrintWriter outLimp = new PrintWriter(fwLimp);
            for (i = 0; i < contLimp; i++) {
                outLimp.println(limpeza[i][0] + "\t" + limpeza[i][1] + "\t" + limpeza[i][2] + "\t" + limpeza[i][3]);
            }
            outLimp.close();

            System.out.println("Dados salvos com sucesso");
            teclado.next();
        } catch (IOException erro) {
            System.out.println("Erro ao salvar arquivos");
        }
    }

    //Aonde serão carregados os valores que estao armazenados nos arquivos .txt nas matrizes
    public static void carregar() {

        /* Para cada matriz foi criado um arquivo.txt para armazenar seus valores
         * As logicas sao as mesmas para cada carregamento de matriz
         * sem necessidade de comentar todos os passos
         * Caso nenhum arquivo.txt tenha sido criado ainda, a propria linguagem java
         * desconsidera essa parte do codigo
         */

        try {
            String linha = null;
            String col[] = null;

            // variavel para habilitar leitura de arquivo.txt
            FileReader frAni = new FileReader("animal.txt");

            // variavel para ler o conteudo do aquivo.txt apontado por frAni
            BufferedReader brAni = new BufferedReader(frAni);
            i = 0;

            /* Para trazer os valores contidos em animal.txt para a matriz animal
             * primeiramente será necessário ler todo o conteudo da linha
             * depois, separar a cada "\t" o conteudo e indexar na matriz col
             * após adicionado todos os elementos da linha na matriz col, é passado
             * os elementos de col para a matriz animal controlados pela variavel j
             * que sao as colunas. A variavel i é incrementada a cada vez que uma nova linha
             * é lida
             */

            // enquanto o conteudo de brAni for diferente de nulo
            while ((linha = brAni.readLine()) != null) {
                col = linha.split("\t"); // dividir a linha a cada \t
                for (j = 0; j < 5; j++) {
                    animal[i][j] = col[j]; // passando os valores de col para animal
                }
                i++; // incremento
            }

            // neste momento i indica o numero de animais cadastrados +1
            contAni = i;

            // encerra atividades de brAni
            brAni.close();

            // mesma logica do FileReader anterior
            FileReader frFunc = new FileReader("funcionario.txt");
            BufferedReader brFunc = new BufferedReader(frFunc);
            i = 0;
            while ((linha = brFunc.readLine()) != null) {
                col = linha.split("\t");
                for (j = 0; j < 4; j++) {
                    func[i][j] = col[j];
                }
                i++;
            }
            contFunc = i;
            brFunc.close();

            FileReader frJau = new FileReader("jaula.txt");
            BufferedReader brJau = new BufferedReader(frJau);
            i = 0;
            while ((linha = brJau.readLine()) != null) {
                col = linha.split("\t");
                for (j = 0; j < 3; j++) {
                    jaula[i][j] = col[j];
                }
                i++;
            }
            contJaula = i;
            brJau.close();

            FileReader frAli = new FileReader("alimenta.txt");
            BufferedReader brAli = new BufferedReader(frAli);
            i = 0;
            while ((linha = brAli.readLine()) != null) {
                col = linha.split("\t");
                for (j = 0; j < 8; j++) {
                    alimenta[i][j] = col[j];
                }
                i++;
            }
            contAlimenta = i;

            /* Para poder utilizar a variavel contCodAlimenta sera necessario descobrir
             * qual foi o ultimo codigo que foi colocado na matriz. Como i sempre aponta
             * para o proximo elemento NULL é necessario pegar o valor que esta em
             * alimenta[i-1][0] que é o codigo do ultimo registro de alimentação indexado
             * Caso i==0 é porque nao ha nenhum registro na matriz
             */

            if (i != 0) {
                // comando para converter um valor String para Integer
                contCodAlimenta = Integer.parseInt(alimenta[i - 1][0]);

                /* é necessario colocar contCodAlimenta++ para que ele fique na posição
                 * exata para uma nova indexação de dados
                 */
                contCodAlimenta++;
            }
            brAli.close();

            FileReader frLimp = new FileReader("limpeza.txt");
            BufferedReader brLimp = new BufferedReader(frLimp);
            i = 0;
            while ((linha = brLimp.readLine()) != null) {
                col = linha.split("\t");
                for (j = 0; j < 4; j++) {
                    limpeza[i][j] = col[j];
                }
                i++;
            }
            contLimp = i;

            //mesma logica do FileReader anterior
            if (i != 0) {
                contCodLimp = Integer.parseInt(limpeza[i - 1][0]);
                contCodLimp++;
            }
            brLimp.close();
        } catch (IOException erro) {
            System.out.println("Erro ao carregar as informação");
        }
    }

    //Aonde ocorrera todo o processo de catalogacao de animais
    public static void menuAnimal() {
        do { //repetir...
            i = 0; // zerando variavel de incremento
            flag = 0; //zerando variavel de controle

            System.out.println("\n\n\n"); // espacos
            System.out.println("MENU ANIMAIS");
            System.out.println("1- Novo Registro");
            System.out.println("2- Apagar Registro");
            System.out.println("3- Procurar Registro");
            System.out.println("4- Modificar Registro");
            System.out.println("5- Listar Registros");
            System.out.println("6- Voltar");
            System.out.print("Selecione a opção: ");
            opmenu = teclado.nextInt(); // entrada de uma das 6 opcoes

            if (opmenu == 1) { // Se o usuario apertou 1 entrara no menu de Cadstro de Animal
                if (contAni <= 50) { // so entrara se o contador nao excedeu o limite do vetor
                    System.out.println("\nNOVO REGISTRO");

                    System.out.print("NUMERO DE CHAMADA: ");
                    aux = teclado.next(); // entra com um codigo qualquer para o animal

                    /* laco para verificar se o Codigo ja existe na matriz
                     * ele rodara ate a "i" chegar no final do contador
                     * e enquanto a "flag" continuar valendo 0
                     */

                    while (i <= contAni && flag == 0) {
                        // variavel.equals() -> comando de comparacao de string
                        if (aux.equals(animal[i][0])) { // se o codigo ja existir na coluna [0]
                            System.out.println("ERRO !!! CODIGO INVALIDO");
                            flag = 1; // flag para sair do laco
                        } /*se o laco percorrer todo conteudo da coluna [0] e nao encontrar
                         * nenhum registro repetido é adicionado o conteudo de aux
                         * na animal[contAni][0
                         */ else if (i == contAni) {
                            animal[contAni][0] = aux;
                        }

                        i++; // passa para a proxima linha
                    } // while

                    /*neste caso a flag == 0 significa que o conteudo de aux foi adicionado
                     * na matriz e que o processo de cadastro pode continuar
                     */
                    if (flag == 0) {
                        // entrada de dados na matriz
                        System.out.print("Nome popular do animal : ");
                        animal[contAni][1] = teclado.next();
                        System.out.print("Tipo de alimentação: ");
                        animal[contAni][2] = teclado.next();
                        System.out.print("Quantidade, em kg, de alimento e frequencia (Kg/dia): ");
                        animal[contAni][3] = teclado.next();
                        System.out.print("Horario tipico: ");
                        animal[contAni][4] = teclado.next();

                        /* avança para o proximo indice da matriz, indicando que o cadastro
                         * foi terminado com sucesso
                         */
                        contAni++;
                        System.out.println("Operacao realizada com exito!");
                    }

                } else {
                    System.out.println("MATRIZ CHEIA"); // else do if(contAni<=50)
                }
                teclado.next(); // da uma pausa no processo para o usuario poder ver o que foi feito
            }


            if (opmenu == 2) { // Se o usuario apertou 2 entrara no menu de Excluir de Animal
                System.out.println("\n APAGAR REGISTRO");

                /*Nesse momento o usuario podera excluir um dos animais catalogados
                 * Para isso, ele tera que digitar o codigo do animal
                 */
                System.out.print("Digite o Nº de chamada a ser retirado: ");
                aux = teclado.next();

                while (i <= contAni && flag == 0) { // mesmo codigo anterior
                    if (aux.equals(animal[i][0])) { // se o cpf existir na matriz

                        /* Para nao haver espaços em branco na matriz, todos os elementos
                         * cadastrados posteriormente ao que sera retirado, sao trazidos uma
                         * posicao para tras, um a um
                         */
                        while (i < contAni) {
                            animal[i][0] = animal[i + 1][0];
                            animal[i][1] = animal[i + 1][1];
                            animal[i][2] = animal[i + 1][2];
                            animal[i][3] = animal[i + 1][3];
                            animal[i][4] = animal[i + 1][4];
                            i++; // incremento do laco interno, partindo da posicao atual do externo
                        }
                        contAni--; // retrocede o contador um indice
                        flag = 1; // flag para saida do laco
                        System.out.println("REGISTRO APAGADO");

                    } else if (i == contAni) { // se o laco chegar no final da coluna[0]
                        System.out.println("REGISTRO NÃO EXISTE!!!");
                    }
                    i++; // incremento do laco externo
                }
                teclado.next();
            }

            if (opmenu == 3) { // Buscar Animal
                System.out.println("\n PROCURAR REGISTRO");
                System.out.print("Digite o Nº de chamada da procura: ");
                aux = teclado.next();

                while (i <= contAni && flag == 0) {
                    if (aux.equals(animal[i][0])) { // se o codigo existir na coluna[0]
                        //é exibido todas as informcoes do animal buscado
                        System.out.println("Nome popular do animal: " + animal[i][1]);
                        System.out.println("Tipo de alimentação: " + animal[i][2]);
                        System.out.println("Quantidade de alimento (em KG) e frequencia: " + animal[i][3]);
                        System.out.println("Horario tiico: " + animal[i][4]);
                        System.out.println("Operacao realizada com sucesso!");
                        flag = 1; // flag para saida do laco

                    } else if (i == contAni) { // se o laco chegar no final da matriz
                        System.out.println("REGISTRO NÃO EXISTE");
                    }
                    i++;
                }
                teclado.next();
            }

            if (opmenu == 4) { // Alterar animal
                System.out.println("\nMODIFICAR REGISTRO");
                // Menu de alteracao de informacoes de um animal
                // Codigo do animal nao podera ser mudado!
                System.out.print("Digite o Nº de chamada a ser alterado: ");
                aux = teclado.next();

                while (i <= contAni && flag == 0) {
                    if (aux.equals(animal[i][0])) { // se o codigo existir na matriz

                        // Exibe o conteudo atual antes de muda-lo
                        System.out.print("Novo nome popular do animal [" + animal[i][1] + "]: ");
                        animal[i][1] = teclado.next();
                        System.out.print("Novo tipo de alimentação que se alimenta [" + animal[i][2] + "]: ");
                        animal[i][2] = teclado.next();
                        System.out.print("Nova quantidade e frequencia de alimentacao (KG)[" + animal[i][3] + "]: ");
                        animal[i][3] = teclado.next();
                        System.out.print("Horario da Tipico [" + animal[i][4] + "]: ");
                        animal[i][4] = teclado.next();
                        System.out.println("Operacao realizada com Sucesso!");
                        flag = 1; // flag para saida do laco

                    } else if (i == contAni) { // se o laco chegar no final da matriz
                        System.out.println("REGISTRO NÃO ENCONTRADO");
                    }
                    i++;
                }
                teclado.next();
            }

            if (opmenu == 5) { // Exibir todos os elementos cadastrados na matriz
                System.out.println("\nEXIBIR REGISTROS");
                for (i = 0; i < contAni; i++) { // percorre ate o ultimo elemento
                    System.out.println("Numero de chamada: " + animal[i][0]);
                    System.out.println("Nome Popular do animal: " + animal[i][1]);
                    System.out.println("Tipo de Alimentação: " + animal[i][2]);
                    System.out.println("Quantidade e Frequencia de alimentação (KG/dia): " + animal[i][3]);
                    System.out.println("Horario da Tipico: " + animal[i][4] + "\n");
                }

                System.out.println("Operacao realizada com Sucesso!");
                teclado.next();
            }

            // caso o usuario nao entre com nenhum dos numeros indicados no menu CONTROLE DE ANIMAIS
            if (opmenu != 1 && opmenu != 2 && opmenu != 3 && opmenu != 4 && opmenu != 5 && opmenu != 6) {
                System.out.println(" ERRO!! Opcao Invalida");
                teclado.next();
            }
        } while (opmenu != 6); // ... enquanto opmenu nao for 6
    }

    /* Os proximos voids utilizam quase a mesma codificação do void menuAnimal, logo, apenas
    os novos comandos serão comentados */
    // Aonde ocorrera todo o processo de catalogacao de funcionarios & parceiros do zoo
    public static void menuFunc() {

        int prof = 0; // variavel sera usada no cadastro de profissao
        do {
            i = 0;
            flag = 0;
            System.out.println("\n\n\n");
            System.out.println("MENU FUNCIONARIOS");
            System.out.println("1- Novo Cadastro");
            System.out.println("2- Apagar Cadastro");
            System.out.println("3- Procurar Cadastro");
            System.out.println("4- Alterar Cadastro");
            System.out.println("5- Exibir Cadastros");
            System.out.println("6- Voltar");
            System.out.print("Escolha opcao desejada: ");
            opmenu = teclado.nextInt();

            if (opmenu == 1) { // Novo Profissional
                if (contFunc <= 50) {
                    System.out.println("\nNOVO CADASTRO");
                    System.out.print("INFORME CPF: ");
                    aux = teclado.next();

                    while (i <= contFunc && flag == 0) {
                        if (aux.equals(func[i][0])) {
                            System.out.println("JA EXISTE ESTE Nº DE CPF NO CADASTRO");
                            flag = 1;
                        } else if (i == contFunc) {
                            func[contFunc][0] = aux;
                        }
                        i++;
                    }

                    if (flag == 0) {
                        System.out.print("Nome: ");
                        func[contFunc][1] = teclado.next();
                        System.out.print("Telefone: ");
                        func[contFunc][2] = teclado.next();

                        /* Tres Profissoes existem no cenario: Funcionario do Zoologico,
                         * Veterinario e Nutricionista, neste momento o usuario entrara
                         * com uma das 3 opcoes na variavel prof, enquanto ele nao digitar
                         * os numeros certos, o laco nao deixa ele sair
                         */
                        while (flag == 0) { // reutilizando flag
                            System.out.println("Selecione a Funcao");
                            System.out.println("1- Equipe de Apoio");
                            System.out.println("2- Nutricionista");
                            System.out.println("3- Veterinario");
                            System.out.print("Selecione: ");
                            prof = teclado.nextInt();

                            if (prof == 1) { // caso tenha pressionado 1
                                func[contFunc][3] = "Equipe de apoio";
                                System.out.println("Funcao: " + func[contFunc][3]);
                                flag = 1;
                            } else if (prof == 2) { // caso tenha pressionado 2
                                func[contFunc][3] = "Nutricionista";
                                System.out.println("Funcao: " + func[contFunc][3]);
                                flag = 1;
                            } else if (prof == 3) { // caso tenha pressionado 3
                                func[contFunc][3] = "Veterinario";
                                System.out.println("Funcao: " + func[contFunc][3]);
                                flag = 1;
                            } else // qualquer outro numero
                            {
                                System.out.println("Funcao Invalida");
                            }
                        }
                        contFunc++;
                        System.out.println("Operacao realizada com Sucesso!!!");
                    }
                } else {
                    System.out.println("MATRIZ CHEIA");
                }
                teclado.next();
            }

            if (opmenu == 2) { // Excluir profissional
                System.out.println("\nAPAGAR CADASTRO");
                System.out.print("Digite o CPF do funcionario a ser apagado: ");
                aux = teclado.next();

                while (i <= contFunc && flag == 0) {

                    if (aux.equals(func[i][0])) {
                        while (i < contFunc) {
                            func[i][0] = func[i + 1][0];
                            func[i][1] = func[i + 1][1];
                            func[i][2] = func[i + 1][2];
                            func[i][3] = func[i + 1][3];
                            i++;
                        }
                        contFunc--;
                        flag = 1;
                        System.out.println("FUNICIONARIO RETIRADO");

                    } else if (i == contFunc) {
                        System.out.println("CPF NÃO EXISTE NA MATRIZ!");
                    }
                    i++;
                }
                teclado.next();
            }

            if (opmenu == 3) { // Buscar profissional
                System.out.println("\nPROCURAR CADASTRO");
                System.out.print("Digite o CPF do funcionario que deseja procurar: ");
                aux = teclado.next();

                while (i <= contFunc && flag == 0) {
                    if (aux.equals(func[i][0])) {
                        System.out.println("Nome: " + func[i][1]);
                        System.out.println("Telefone: " + func[i][2]);
                        System.out.println("Funcao: " + func[i][3]);
                        System.out.println("Operacao realizada com sucesso!!!");
                        flag = 1;

                    } else if (i == contFunc) {
                        System.out.println("CPF NÃO CADASTRADO");
                    }
                    i++;
                }
                teclado.next();
            }

            if (opmenu == 4) { // Alterar
                System.out.println("\nALTERAR CADASTRO");

                System.out.print("Digite o o CPF do funcionario a ser alterado: ");
                aux = teclado.next();

                while (i <= contFunc && flag == 0) {
                    if (aux.equals(func[i][0])) {

                        // Aqui primeiramente tem entrada na profissao
                        System.out.println("Selecione a nova funcao [" + func[i][3] + "]");
                        System.out.println("1- Equipe de Apoio");
                        System.out.println("2- Nutricionista");
                        System.out.println("3- Veterinario");
                        System.out.print("Selecione: ");
                        prof = teclado.nextInt();

                        // se as profissoes forem 1 ou 2 ou 3 prossegue ...
                        if (prof == 1 || prof == 2 || prof == 3) {
                            if (prof == 1) {
                                func[i][3] = "Equipe de Apoio";
                            }
                            if (prof == 2) {
                                func[i][3] = "Nutricionista";
                            }
                            if (prof == 3) {
                                func[i][3] = "Veterinario";
                            }
                            System.out.print("Novo nome [" + func[i][1] + "]: ");
                            func[i][1] = teclado.next();
                            System.out.print("Novo telefone [" + func[i][2] + "]: ");
                            func[i][2] = teclado.next();
                            System.out.println("Operacao realizada com Sucesso!!!");
                        } else // ... senao, profissao invalida
                        {
                            System.out.println("Funcao Invalida");
                        }

                        flag = 1;

                    } else if (i == contFunc) {
                        System.out.println("CPF NÃO CADASTRADO");
                    }
                    i++;
                }
                teclado.next();
            }

            if (opmenu == 5) { // exibe todos na tela em um laco
                System.out.println("\nEXIBIR CADASTROS");

                for (i = 0; i < contFunc; i++) {
                    System.out.println("CPF: " + func[i][0]);
                    System.out.println("Nome: " + func[i][1]);
                    System.out.println("Telefone: " + func[i][2]);
                    System.out.println("Funcao: " + func[i][3] + "\n");
                }

                System.out.println("Operacao realizada com Sucesso!!!");
                teclado.next();

            } // if opmenu == 5

            if (opmenu != 1 && opmenu != 2 && opmenu != 3 && opmenu != 4 && opmenu != 5 && opmenu != 6) {
                System.out.println("Opcao Invalida");
                teclado.next();
            }
        } while (opmenu != 6);
    }

    // Aonde ocorrera todo o processo de catalogacao de jaulas
    public static void menuJaula() {
        do {
            i = 0;
            flag = 0;

            System.out.println("\n\n\n");
            System.out.println("CONTROLE DE RECINTOS");
            System.out.println("1- Cadastrar Recinto");
            System.out.println("2- Apagar Cadastro");
            System.out.println("3- Buscar Cadastro");
            System.out.println("4- Alterar Cadastro");
            System.out.println("5- Exibir Cadastros");
            System.out.println("6- Voltar");
            System.out.print("Escolha opcao desejada: ");
            opmenu = teclado.nextInt();

            if (opmenu == 1) { // nova jaula
                if (contJaula <= 50) {
                    System.out.println("\nCADASTRAR RECINTO");

                    System.out.print("Numero do Recinto: ");
                    aux = teclado.next();

                    while (i <= contJaula && flag == 0) {
                        if (aux.equals(jaula[i][0])) {
                            System.out.println("EXISTE OUTRO RECINTO CADASTRADO COM ESTE NÚMERO");
                            flag = 1;
                        } else if (i == contJaula) {
                            jaula[contJaula][0] = aux;
                        }
                        i++;
                    }

                    if (flag == 0) {
                        System.out.print("Numero de animais no recinto: ");
                        jaula[contJaula][1] = teclado.next();
                        System.out.print("Frequencia de limpeza do recinto: ");
                        jaula[contJaula][2] = teclado.next();
                        contJaula++;
                        System.out.print("Operacao realizada com Sucesso!!!");
                    }
                } else {
                    System.out.println("MATRIZ CHEIA");
                }
                teclado.next();
            }

            if (opmenu == 2) { // retirar jaula
                System.out.println("\nAPAGAR CADASTRO");
                System.out.print("Digite o numero do recinto a ser retirado: ");
                aux = teclado.next();

                while (i <= contJaula && flag == 0) {

                    if (aux.equals(jaula[i][0])) {
                        while (i < contJaula) {
                            jaula[i][0] = jaula[i + 1][0];
                            jaula[i][1] = jaula[i + 1][1];
                            jaula[i][2] = jaula[i + 1][2];
                            i++;
                        }
                        contJaula--;
                        flag = 1;
                        System.out.println("CADASTRO EXCLUIDO");

                    } else if (i == contJaula) {
                        System.out.println("NAO EXISTE RECINTO COM O CÓDIGO FORNECIDO");
                    }
                    i++;
                }
                teclado.next();
            }

            if (opmenu == 3) { // buscar jaula
                System.out.println("\nPROCURAR RECINTO");
                System.out.print("Digite o numero do recinto a ser buscada: ");
                aux = teclado.next();

                while (i <= contJaula && flag == 0) {
                    if (aux.equals(jaula[i][0])) {
                        System.out.println("Numero de animais no recinto: " + jaula[i][1]);
                        System.out.println("Frequencia de limpeza: " + jaula[i][2]);
                        System.out.println("Operacao realizada com sucesso!!!");
                        flag = 1;
                    } else if (i == contJaula) {
                        System.out.println("RECINTO NAO CADASTRADO");
                    }
                    i++;
                }
                teclado.next();
            }

            if (opmenu == 4) { // alterar jaula
                System.out.println("\nALTERAR CADASTRO");
                System.out.print("Digite o numero do recinto a ser alterado: ");
                aux = teclado.next();

                while (i <= contJaula && flag == 0) {
                    if (aux.equals(jaula[i][0])) {
                        System.out.print("Novo Numero de animais no recinto: [" + jaula[i][1] + "]: ");
                        jaula[i][1] = teclado.next();
                        System.out.print("Nova frequencia de limpeza [" + jaula[i][2] + "]: ");
                        jaula[i][2] = teclado.next();
                        System.out.println("Operacao realizada com sucesso!!!");
                        flag = 1;

                    } else if (i == contJaula) {
                        System.out.println("RECINTO NAO CADASTRADO");
                    }
                    i++;
                }
                teclado.next();
            }

            if (opmenu == 5) { // exibe todos em um laco
                System.out.println("\nEXIBIR CADASTROS");

                for (i = 0; i < contJaula; i++) {
                    System.out.println("Numero do recinto: " + jaula[i][0]);
                    System.out.println("Numero de animais enjaulados: " + jaula[i][1]);
                    System.out.println("Frequencia de limpeza: " + jaula[i][2] + "\n");
                }
                System.out.println("Operacao concluida com sucesso!");
                teclado.next();
            }
            if (opmenu != 1 && opmenu != 2 && opmenu != 3 && opmenu != 4 && opmenu != 5 && opmenu != 6) {
                System.out.println("Opcao Invalida");
                teclado.next();
            }
        } while (opmenu != 6);
    }

    // Aonde ocorrera todo o processo de registros de alimentacao
    public static void menuAlimenta() {
        String aux2;
        do {
            i = 0;
            flag = 0;

            System.out.println("\n\n\n");
            System.out.println("MENU CUIDADOS E ALIMENTACAO");
            System.out.println("1- Novo registro");
            System.out.println("2- Excluir registro");
            System.out.println("3- Buscar Registro");
            System.out.println("4- Alterar Registro");
            System.out.println("5- Exibir Registros");
            System.out.println("6- Sair");
            System.out.print("Escolha opcao desejada: ");
            opmenu = teclado.nextInt();

            if (opmenu == 1) { // novo registro
                if (contAlimenta <= 50) {
                    System.out.println("\nNOVO REGISTRO");

                    /* Diferentemente dos voids anteriores que o usuário entrava com o codigo,
                     * neste o próprio programa se encarrega de coloca-los em ordem crescente
                     * de forma que eles nunca venham se repetir. Para isso foi criada a variavel
                     * contCodAlimenta
                     */
                    System.out.println("Numero de controle: " + contCodAlimenta);

                    /* Neste momento, ao entrar com o codigo do animal alimentado, o programa
                     * faz uma busca na matriz "animal" e verifica se o codigo digitado esta
                     * correto
                     */
                    System.out.print("Codigo do animal alimentado: ");
                    aux = teclado.next();
                    while (i <= contAni && flag == 0) {
                        if (aux.equals(animal[i][0])) {
                            flag = 1; // flag indicando que o animal foi encontrado
                        } else if (i == contAni) {
                            System.out.println("ERRO!!! REGISTRO NÃO ENCONTRADO");
                        }
                        i++;
                    }

                    if (flag == 1) { // se o animal for encontrado...
                        i = 0;
                        flag = 0;

                        /* A mesma logica se aplica aqui, mas dessa vez a pesquisa sera do
                        CPF do funcionario na matriz "func"
                         */
                        System.out.print("CPF do funcionario: ");
                        aux2 = teclado.next();

                        while (i <= contFunc && flag == 0) {

                            // se o CPF existir e for correspondente a um Funcionario do Zoologico
                            if (aux2.equals(func[i][0]) && func[i][3].equals("Funcionario do zoologico")) {
                                flag = 1; // flag indica que o funcionario foi encontrado
                            } else if (i == contFunc) {
                                System.out.println("ERRO !!! CADASTRO NÃO ENCONTRADO");
                            }
                            i++;
                        }

                        if (flag == 1) { // se o funcionario foi encontrado

                            /* Para evitar erros, so agora que os valores do contCodAlimenta, do CPF e
                             * do Codigo do animal foram adicionados na matriz "alimenta", assim se
                             * ocorrer algum erro em uma das etapas nenhum valor é indexado na matriz
                             */

                            /* contCodAlimenta é uma variavel do tipo int, logo, para indexar seu valor
                             * na matriz é necessário usar o comando Interger.toString, convertendo assim
                             * seu valor para string
                             */
                            alimenta[contAlimenta][0] = Integer.toString(contCodAlimenta);
                            alimenta[contAlimenta][1] = aux;
                            alimenta[contAlimenta][2] = aux2;

                            //Entrada dos dados
                            System.out.print("Dia [xx]: ");
                            alimenta[contAlimenta][3] = teclado.next();
                            System.out.print("Mes [xx]: ");
                            alimenta[contAlimenta][4] = teclado.next();
                            System.out.print("Ano [xxxx]: ");
                            alimenta[contAlimenta][5] = teclado.next();
                            System.out.print("Horario: ");
                            alimenta[contAlimenta][6] = teclado.next();
                            System.out.print("Obs: ");
                            alimenta[contAlimenta][7] = teclado.next();

                            contCodAlimenta++; // aumenta o contador de Codigo
                            contAlimenta++;
                            System.out.println("Operacao concluida com exito!");
                        }
                    }
                } else {
                    System.out.println("MATRIZ CHEIA");
                }
                teclado.next();
            }

            if (opmenu == 2) { // excluir registro
                System.out.println("\nAPAGAR REGISTRO");
                System.out.print("Digite o numero do registro a ser apagado: ");
                aux = teclado.next();

                while (i <= contAlimenta && flag == 0) {

                    if (aux.equals(alimenta[i][0])) {
                        while (i < contAlimenta) {
                            alimenta[i][0] = alimenta[i + 1][0];
                            alimenta[i][1] = alimenta[i + 1][1];
                            alimenta[i][2] = alimenta[i + 1][2];
                            alimenta[i][3] = alimenta[i + 1][3];
                            alimenta[i][4] = alimenta[i + 1][4];
                            alimenta[i][5] = alimenta[i + 1][5];
                            alimenta[i][6] = alimenta[i + 1][6];
                            alimenta[i][7] = alimenta[i + 1][7];
                            i++;
                        }
                        contAlimenta--;
                        flag = 1;
                        System.out.println("REGISTRO APAGADO");

                    } else if (i == contAlimenta) {
                        System.out.println("CÓDIGO FORNECIDO NÃO CADASTRADO NO SISTEMA");
                    }
                    i++;
                }
                teclado.next();
            }

            if (opmenu == 3) { // Buscar Animal
                System.out.println("\nBUSCAR REGISTRO");

                /*A busca aqui nao é efetuado atraves do codigo, mas sim da data da alimentacao
                logo, o usuario tera que digitar o dia, o mes e o ano que ele deseja buscar
                e todos os animais alimentados aquele dia aparecerao no laco de repeticao
                 */
                System.out.print("Digite o dia a ser buscado: ");
                String dia = teclado.next();
                System.out.print("Digite o mes a ser buscada: ");
                String mes = teclado.next();
                System.out.print("Digite o ano a ser buscado: ");
                String ano = teclado.next();

                while (i <= contAlimenta) {

                    //Estrutura de decisao para encontrar a data digitada pelo usuario
                    if (dia.equals(alimenta[i][3]) && mes.equals(alimenta[i][4]) && ano.equals(alimenta[i][5])) {

                        //Registros encontrados
                        System.out.println("Codigo do Registro: " + alimenta[i][0]);
                        System.out.println("Codigo do animal alimentado: " + alimenta[i][1]);
                        System.out.println("CPF do funcionario: " + alimenta[i][2]);
                        System.out.println("Horario da alimentacao: " + alimenta[i][6]);
                        System.out.println("OBS: " + alimenta[i][7] + "\n");

                        flag = 1; // mostra que pelo menos um animal foi encontrado
                    }
                    i++;
                }

                if (flag == 0) // se nenhum registro foi encontrado ...
                {
                    System.out.println("NENHUM REGISTRO COM ESSA DATA FOI ENCONTRADO");
                } else {
                    System.out.println("Operacao realizada com sucesso!!!");
                }
                teclado.next();
            }

            if (opmenu == 4) { // Alterar registro
                System.out.println("\nALTERAR CADASTRO");
                System.out.print("Digite o numero do cadastro a ser alterado: ");
                aux = teclado.next();

                // É feita uma busca para identificar se o numero do registro é valido
                while (i <= contAlimenta && flag == 0) {
                    if (aux.equals(alimenta[i][0])) {
                        flag = 1; // codigo existe
                    } else if (i == contAlimenta) {
                        System.out.println("CADASTRO NÃO EXISTE");
                    }
                    i++;
                }

                if (flag == 1) { // registro existindo
                    j = i - 1;// para deixar na posição correta de alteração
                    i = 0;
                    flag = 0;
                    System.out.print("Novo codigo do animal [" + alimenta[j][1] + "]: ");
                    aux = teclado.next();

                    //Novamente é feita uma busca para saber se o codigo digitado existe
                    while (i <= contAni && flag == 0) {
                        if (aux.equals(animal[i][0])) {
                            flag = 1; // codigo existe
                        } else if (i == contAni) {
                            System.out.println("ERRO CADASTRO NAO ENCONTRADO!!!");
                        }
                        i++;
                    }

                    if (flag == 1) { // codigo existindo ...
                        i = 0;
                        flag = 0;

                        System.out.print("Novo CPF do funcionario [" + alimenta[j][2] + "]: ");
                        aux2 = teclado.next();

                        //Busca pelo cpf
                        while (i <= contFunc && flag == 0) {
                            if (aux2.equals(func[i][0])) {
                                flag = 1; // cpf existe
                            } else if (i == contFunc) {
                                System.out.println("ERRO!!! CADASTRO NAO ENCONTRADO");
                            }
                            i++;
                        }

                        if (flag == 1) { // cpf existindo

                            //Entrada dos novos dados
                            alimenta[j][1] = aux;
                            alimenta[j][2] = aux2;
                            System.out.print("Novo dia [" + alimenta[j][3] + "]: ");
                            alimenta[j][3] = teclado.next();
                            System.out.print("Novo mes [" + alimenta[j][4] + "]: ");
                            alimenta[j][4] = teclado.next();
                            System.out.print("Novo ano [" + alimenta[j][5] + "]: ");
                            alimenta[j][5] = teclado.next();
                            System.out.print("Novo hora [" + alimenta[j][6] + "]: ");
                            alimenta[j][6] = teclado.next();
                            System.out.print("Nova OBS [" + alimenta[j][7] + "]: ");
                            alimenta[j][7] = teclado.next();
                            System.out.println("Operacao concluida com exito!");
                        }
                    }
                }
                teclado.next();
            }

            if (opmenu == 5) { // menu Exibir
                System.out.println("\nEXIBIR REGISTROS");
                for (i = 0; i < contAlimenta; i++) {
                    System.out.println("Numero de Controle: " + alimenta[i][0]);
                    System.out.println("Codigo do Animal: " + alimenta[i][1]);
                    System.out.println("CPF do Funcionario: " + alimenta[i][2]);
                    System.out.println("Dia: " + alimenta[i][3]);
                    System.out.println("Mes: " + alimenta[i][4]);
                    System.out.println("Ano: " + alimenta[i][5]);
                    System.out.println("Hora: " + alimenta[i][6]);
                    System.out.println("OBS: " + alimenta[i][7] + "\n");
                }
                System.out.println("Operacao concluida com Sucesso!!!");
                teclado.next();
            }

            if (opmenu != 1 && opmenu != 2 && opmenu != 3 && opmenu != 4 && opmenu != 5 && opmenu != 6) {
                System.out.println("Opcao Invalida");
                teclado.next();
            }
        } while (opmenu != 6);
    }

    // Aonde ocorrera todo o processo de registros de limpeza
    public static void menuLimpeza() {
        do {
            i = 0;
            flag = 0;

            System.out.println("\n\n\n");
            System.out.println("MENU LIMPEZA");
            System.out.println("1- Novo registro");
            System.out.println("2- Apagar registro");
            System.out.println("3- Procurar Registro");
            System.out.println("4- Alterar Registro");
            System.out.println("5- Exibir Registros");
            System.out.println("6- Voltar");
            System.out.print("Escolha opcao desejada: ");
            opmenu = teclado.nextInt();

            if (opmenu == 1) { // novo registro
                if (contLimp <= 50) {
                    System.out.println("\nNOVO REGISTRO");

                    // Mesma logica do menuAlimenta, mas com a variavel contCodLimp
                    System.out.println("Numero de controle: " + contCodLimp);

                    /* A mesma logica de busca do void menuAlimenta se aplica aqui,
                     * mas dessa vez a pesquisa sera pelo codigo da jaula na matriz "jaula"
                     */
                    System.out.print("Codigo do recinto limpo: ");
                    aux = teclado.next();
                    while (i <= contJaula && flag == 0) {
                        if (aux.equals(jaula[i][0])) {
                            flag = 1; // indica que a jaula foi encontrada
                        } else if (i == contJaula) {
                            System.out.println("ERRO!!! RECINTO NAO CADASTRADO");
                        }
                        i++;
                    }

                    if (flag == 1) { // se a jaula foi encontrada

                        //Mesma logica do menuAlimenta
                        limpeza[contLimp][0] = Integer.toString(contCodLimp);
                        limpeza[contLimp][1] = aux;
                        System.out.print("Data [xx/xx/xxxx]: ");
                        limpeza[contLimp][2] = teclado.next();
                        System.out.print("Horario: ");
                        limpeza[contLimp][3] = teclado.next();

                        contCodLimp++;
                        contLimp++;
                        System.out.println("Operacao concluida com sucesso!!");
                    }
                } else {
                    System.out.println("MATRIZ CHEIA");
                }
                teclado.next();
            }

            if (opmenu == 2) { // excluir registro
                System.out.println("\nEXCLUIR REGISTRO");
                System.out.print("Digite o numero do registro a ser excluido: ");
                aux = teclado.next();

                while (i <= contLimp && flag == 0) {

                    if (aux.equals(limpeza[i][0])) {
                        while (i < contLimp) {
                            limpeza[i][0] = limpeza[i + 1][0];
                            limpeza[i][1] = limpeza[i + 1][1];
                            limpeza[i][2] = limpeza[i + 1][2];
                            limpeza[i][3] = limpeza[i + 1][3];
                            i++;
                        }
                        contLimp--;
                        flag = 1;
                        System.out.println("REGISTRO APAGADO");

                    } else if (i == contLimp) {
                        System.out.println("CÓDIGO FORNECIDO NÃO ESTA CADASTRADO NO SISTEMA");
                    }
                    i++;
                }
                teclado.next();
            }

            if (opmenu == 3) { // Buscar registro
                System.out.println("\nPROCURAR REGISTRO");
                //Busca feita pela jaula
                System.out.print("Digite o recinto a ser buscado: ");
                aux = teclado.next();

                // Exibira todos os registros de limpeza da jaula buscada
                while (i <= contLimp) {
                    if (aux.equals(limpeza[i][1])) { // se o codigo da jaula for encontrado
                        System.out.println("Codigo do Registro: " + limpeza[i][0]);
                        System.out.println("Data: " + limpeza[i][2]);
                        System.out.println("Horario: " + limpeza[i][3] + "\n");
                        flag = 1; // indica que pelo menos um registro de limpeza foi encontrado
                    }
                    i++;
                }

                if (flag == 0) // se nenhum registro foi encontrado
                {
                    System.out.println("REGISTRO NAO ENCONTRADO");
                } else {
                    System.out.println("Operacao realizada com Sucesso!!!");
                }
                teclado.next();
            }

            if (opmenu == 4) { // Alterar registro
                System.out.println("\nALTERAR REGISTRO");
                System.out.print("Digite o numero do registro a ser alterado: ");
                aux = teclado.next();

                // Busca para descobrir se o registro é válido
                while (i <= contLimp && flag == 0) {
                    if (aux.equals(limpeza[i][0])) {
                        flag = 1; // registro encontrada
                    } else if (i == contLimp) {
                        System.out.println("RECINTO NAO CADASTRADO");
                    }
                    i++;
                }

                if (flag == 1) { // registro encontrado...
                    j = i - 1;//para ficar na posição correta para a alteracao
                    i = 0;
                    flag = 0;
                    // Busca para descobrir se o codigo da jaula é valido
                    System.out.print("Novo codigo do recinto limpo[" + limpeza[j][1] + "]: ");
                    aux = teclado.next();
                    while (i <= contJaula && flag == 0) {
                        if (aux.equals(jaula[i][0])) {
                            flag = 1; // jaula encontrada
                        } else if (i == contJaula) {
                            System.out.println("REGISTRO NÃO ENCONTRADO");
                        }
                        i++;
                    }

                    if (flag == 1) { // se a jaula for encontrada
                        limpeza[j][1] = aux;
                        System.out.print("Nova data [" + limpeza[j][2] + "]: ");
                        limpeza[j][2] = teclado.next();
                        System.out.print("Novo horario [" + limpeza[j][3] + "]: ");
                        limpeza[j][3] = teclado.next();
                        System.out.println("Operacao concluida com sucesso!");
                    }
                }
                teclado.next();
            }

            if (opmenu == 5) { // menu Exibir
                System.out.println("\nMOSTRAR REGISTROS");
                for (i = 0; i < contLimp; i++) {
                    System.out.println("Numero de Controle: " + limpeza[i][0]);
                    System.out.println("Numero da Jaula: " + limpeza[i][1]);
                    System.out.println("Data: " + limpeza[i][2]);
                    System.out.println("Hora: " + limpeza[i][3] + "\n");
                }
                System.out.println("Operacao concluida com Sucesso!!!");
                teclado.next();
            }

            if (opmenu != 1 && opmenu != 2 && opmenu != 3 && opmenu != 4 && opmenu != 5 && opmenu != 6) {
                System.out.println("Opcao Invalida");
                teclado.next();
            }
        } while (opmenu != 6);
    }

    // Este void tem a funcionalidade de escrever na tela o menu principal
    public static void menuPrincipal() {
        System.out.println("ZOOMIGO by Zoosoft");
        System.out.println("1- Menu Animais");
        System.out.println("2- Menu Funcionarios");
        System.out.println("3- Menu Recinto");
        System.out.println("4- Menu Alimentação");
        System.out.println("5- Menu Limpeza");
        System.out.println("6- Salvar");
        System.out.println("7- Sair");
        System.out.print("Escolha a opcao desejada: ");
    }

    public static void main(String[] args) {
        carregar(); // carrega os dados dos arquivos.txt para as matrizes
        teclado.useDelimiter("\\n"); // faz com que o scanner reconheça espaços
        do { // laco de repeticao da tela inicial
            menuPrincipal(); // chama funcao menuPrincipal
            opmenu = teclado.nextInt(); // entra com a opcao desejada
            switch (opmenu) { // estrutura de decisao com base na variavel opmenu
                case 1: // controle de animais
                    menuAnimal();
                    opmenu = 1;
                    break;
                case 2: // controle de parceiros e funcionarios
                    menuFunc();
                    opmenu = 2;
                    break;
                case 3: // controle de jaulas
                    menuJaula();
                    opmenu = 3;
                    break;
                case 4: // controle de alimentacao
                    menuAlimenta();
                    opmenu = 4;
                    break;
                case 5: // controle de limpeza
                    menuLimpeza();
                    opmenu = 5;
                    break;
                case 6: // salvar
                    salvar();
                    opmenu = 6;
                    break;
            }

            /* caso for digitado qualquer outro numero a nao ser os delimitados
             * o programa da opcao invalida
             */
            if (opmenu != 1 && opmenu != 2 && opmenu != 3 && opmenu != 4 && opmenu != 5 && opmenu != 6 && opmenu != 7) {
                System.out.println("Opcao Invalida");
                teclado.next();
            }
            System.out.println("\n\n\n"); // pula linhas
        } while (opmenu != 7); // sai do laco ao apertar 7
        do {
            System.out.println("Deseja Salvar? 1-Sim / 2-Nao");
            System.out.print("Opcao: ");
            opmenu = teclado.nextInt();
            if (opmenu == 1) // caso opção selecionada seja um chama void salvar
            {
                salvar();
            }
        } while (opmenu != 1 && opmenu != 2); // sai do laço ao apertar um dos dois botoes
    }
}
