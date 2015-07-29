package PI.UFABC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Zoo_Main {

    static Scanner entrada = new Scanner(System.in);
    static String auxiliar;
    
    static int contAnimal = 0;
    static int contRecinto = 0;
    static int contLimpeza = 0;
    static int contAlimentacao = 0;
    static int contFuncionario = 0;
    
    static int contCodLimpeza = 0;
    static int contCodAlimentacao = 0;
    
    static String animal[][] = new String[100][5];
    static String recinto[][] = new String[100][3];
    static String limpeza[][] = new String[100][4];
    static String alimentacao[][] = new String[100][8];
    static String funcionario[][] = new String[100][4];
    
    static int controle = 0;
    static int opmenu = 0;
    static int i = 0;
    static int j = 0;
    
    public static void salvar() {

        try {
            FileWriter fwAnimais = new FileWriter("Animais.txt");
            PrintWriter outAnimais = new PrintWriter(fwAnimais);
            
            for (i = 0; i < contAnimal; i++) {
                outAnimais.println(animal[i][0] + "\t" + animal[i][1] + "\t" + animal[i][2] + "\t" + animal[i][3] + "\t" + animal[i][4]);
            }
            outAnimais.close();

            FileWriter fwFuncionarios = new FileWriter("Funcionarios.txt");
            PrintWriter outFuncionarios = new PrintWriter(fwFuncionarios);
            
            for (i = 0; i < contFuncionario; i++) {
                outFuncionarios.println(funcionario[i][0] + "\t" + funcionario[i][1] + "\t" + funcionario[i][2] + "\t" + funcionario[i][3]);
            }
            outFuncionarios.close();

            FileWriter fwRecintos = new FileWriter("Recintos.txt");
            PrintWriter outRecintos = new PrintWriter(fwRecintos);
            
            for (i = 0; i < contRecinto; i++) {
                outRecintos.println(recinto[i][0] + "\t" + recinto[i][1] + "\t" + recinto[i][2]);
            }
            outRecintos.close();

            FileWriter fwAlimentacoes = new FileWriter("Alimentacoes.txt");
            PrintWriter outAlimentacoes = new PrintWriter(fwAlimentacoes);
            
            for (i = 0; i < contAlimentacao; i++) {
                outAlimentacoes.println(alimentacao[i][0] + "\t" + alimentacao[i][1] + "\t" + alimentacao[i][2] + "\t" + alimentacao[i][3] + "\t" + alimentacao[i][4] + "\t" + alimentacao[i][5] + "\t" + alimentacao[i][6] + "\t" + alimentacao[i][7]);
            }
            outAlimentacoes.close();

            FileWriter fwLimpezas = new FileWriter("Limpezas.txt");
            PrintWriter outLimpezas = new PrintWriter(fwLimpezas);
            
            for (i = 0; i < contLimpeza; i++) {
                outLimpezas.println(limpeza[i][0] + "\t" + limpeza[i][1] + "\t" + limpeza[i][2] + "\t" + limpeza[i][3]);
            }
            outLimpezas.close();

            System.out.println("Dados salvos com sucesso!");
            entrada.next();
            
        } catch (IOException erro) {
            System.out.println("Erro ao salvar arquivos.");
        }
    }

    public static void carregar() {

        try {
            String linha = null;
            String coluna[] = null;

            FileReader frAnimais = new FileReader("Animais.txt");
            BufferedReader brAnimais = new BufferedReader(frAnimais);
            i = 0;
            
            while ((linha = brAnimais.readLine()) != null) {
                coluna = linha.split("\t");
                for (j = 0; j < 5; j++) {
                    animal[i][j] = coluna[j];
                }
                i++;
            }
            contAnimal = i;
            brAnimais.close();

            FileReader frFuncionarios = new FileReader("Funcionarios.txt");
            BufferedReader brFuncionarios = new BufferedReader(frFuncionarios);
            i = 0;
            
            while ((linha = brFuncionarios.readLine()) != null) {
                coluna = linha.split("\t");
                for (j = 0; j < 4; j++) {
                    funcionario[i][j] = coluna[j];
                }
                i++;
            }
            contFuncionario = i;
            brFuncionarios.close();

            FileReader frRecintos = new FileReader("Recintos.txt");
            BufferedReader brRecintos = new BufferedReader(frRecintos);
            i = 0;
            
            while ((linha = brRecintos.readLine()) != null) {
                coluna = linha.split("\t");
                for (j = 0; j < 3; j++) {
                    recinto[i][j] = coluna[j];
                }
                i++;
            }
            contRecinto = i;
            brRecintos.close();

            FileReader frAlimentacoes = new FileReader("Alimentacoes.txt");
            BufferedReader brAlimentacoes = new BufferedReader(frAlimentacoes);
            i = 0;
            
            while ((linha = brAlimentacoes.readLine()) != null) {
                coluna = linha.split("\t");
                for (j = 0; j < 8; j++) {
                    alimentacao[i][j] = coluna[j];
                }
                i++;
            }
            contAlimentacao = i;
            
            if (i != 0) {
                contCodAlimentacao = Integer.parseInt(alimentacao[i - 1][0]);
                contCodAlimentacao++;
            }
            brAlimentacoes.close();

            FileReader frLimpezas = new FileReader("Limpezas.txt");
            BufferedReader brLimpezas = new BufferedReader(frLimpezas);
            i = 0;
            
            while ((linha = brLimpezas.readLine()) != null) {
                coluna = linha.split("\t");
                for (j = 0; j < 4; j++) {
                    limpeza[i][j] = coluna[j];
                }
                i++;
            }
            contLimpeza = i;
            
            if (i != 0) {
                contCodLimpeza = Integer.parseInt(limpeza[i - 1][0]);
                contCodLimpeza++;
            }
            brLimpezas.close();
            
        } catch (IOException erro) {
            System.out.println("Erro ao carregar as informações.");
        }
    }
    
    public static void menuAnimal() {
       
        do {
            i = 0;
            controle = 0;
            
            System.out.println("\n\n\n");
            System.out.println("MENU ANIMAIS");
            System.out.println("1- Novo Registro");
            System.out.println("2- Apagar Registro");
            System.out.println("3- Procurar Registro");
            System.out.println("4- Modificar Registro");
            System.out.println("5- Listar Registros");
            System.out.println("6- Voltar");
            System.out.print("Escolha opção desejada: ");
            
            opmenu = entrada.nextInt();
            
            if (opmenu == 1) {
                if (contAnimal <= 100) {
                    System.out.println("\nNOVO REGISTRO");
                    System.out.print("Número de chamada: ");
                    
                    auxiliar = entrada.next();
                    
                    while (i <= contAnimal && controle == 0) {
                        if (auxiliar.equals(animal[i][0])) {
                            System.out.println("CÓDIGO INVÁLIDO!!!");
                            controle = 1;
                        }
                        else if (i == contAnimal) {
                            animal[contAnimal][0] = auxiliar;
                        }
                        i++;
                    }
                    
                    if (controle == 0) {
                        System.out.print("Nome popular do animal: ");
                        animal[contAnimal][1] = entrada.next();
                        System.out.print("Tipo de alimentação: ");
                        animal[contAnimal][2] = entrada.next();
                        System.out.print("Quantidade de alimento e frequência (Kg/dia): ");
                        animal[contAnimal][3] = entrada.next();
                        System.out.print("Horário típico: ");
                        animal[contAnimal][4] = entrada.next();
                        
                        contAnimal++;
                        
                        System.out.println("Operação realizada com êxito!");
                        System.out.println("Aperte Enter para continuar...");
                    }

                } else {
                    System.out.println("MATRIZ CHEIA!!!");
                }
                entrada.next();
            }

            if (opmenu == 2) {
                System.out.println("\n APAGAR REGISTRO");
                System.out.print("Digite o Nº de chamada a ser retirado: ");
                
                auxiliar = entrada.next();

                while (i <= contAnimal && controle == 0) {
                    if (auxiliar.equals(animal[i][0])) {
                        while (i < contAnimal) {
                            animal[i][0] = animal[i + 1][0];
                            animal[i][1] = animal[i + 1][1];
                            animal[i][2] = animal[i + 1][2];
                            animal[i][3] = animal[i + 1][3];
                            animal[i][4] = animal[i + 1][4];
                            i++;
                        }
                        contAnimal--;
                        controle = 1;
                        
                        System.out.println("REGISTRO APAGADO COM SUCESSO!");

                    } 
                    else if (i == contAnimal) {
                        System.out.println("REGISTRO NÃO EXISTE!!!");
                    }
                    i++;
                }
                entrada.next();
            }

            if (opmenu == 3) {
                System.out.println("\n PROCURAR REGISTRO");
                System.out.print("Digite o Nº de chamada da procura: ");
                
                auxiliar = entrada.next();

                while (i <= contAnimal && controle == 0) {
                    if (auxiliar.equals(animal[i][0])) {
                        System.out.println("Nome popular do animal: " + animal[i][1]);
                        System.out.println("Tipo de alimentação: " + animal[i][2]);
                        System.out.println("Quantidade de alimento e frequência (Kg/dia): " + animal[i][3]);
                        System.out.println("Horário típico: " + animal[i][4]);
                        System.out.println("Operação realizada com sucesso!!!");
                        System.out.println("Aperte Enter para continuar...");
                        
                        controle = 1;
                        
                    } 
                    else if (i == contAnimal) {
                        System.out.println("REGISTRO NÃO EXISTE!!!");
                    }
                    i++;
                }
                entrada.next();
            }

            if (opmenu == 4) {
                System.out.println("\nMODIFICAR REGISTRO");
                System.out.print("Digite o Nº de chamada a ser alterado: ");
                
                auxiliar = entrada.next();

                while (i <= contAnimal && controle == 0) {
                    if (auxiliar.equals(animal[i][0])) {
                        System.out.print("Novo nome popular do animal [" + animal[i][1] + "]: ");
                        animal[i][1] = entrada.next();
                        System.out.print("Novo tipo de alimentação [" + animal[i][2] + "]: ");
                        animal[i][2] = entrada.next();
                        System.out.print("Nova quantidade e frequência de alimentação (Kg/dia)[" + animal[i][3] + "]: ");
                        animal[i][3] = entrada.next();
                        System.out.print("Horário da típico [" + animal[i][4] + "]: ");
                        animal[i][4] = entrada.next();
                        System.out.println("Operação realizada com Sucesso!!!");
                        System.out.println("Aperte Enter para continuar...");
                        controle = 1;
                        
                    } 
                    else if (i == contAnimal) {
                        System.out.println("REGISTRO NÃO ENCONTRADO!!!");
                    }
                    i++;
                }
                entrada.next();
            }

            if (opmenu == 5) {
                System.out.println("\nEXIBIR REGISTROS");
                
                for (i = 0; i < contAnimal; i++) {
                    System.out.println("Número de chamada: " + animal[i][0]);
                    System.out.println("Nome popular do animal: " + animal[i][1]);
                    System.out.println("Tipo de alimentação: " + animal[i][2]);
                    System.out.println("Quantidade e frequência de alimentação (KG/dia): " + animal[i][3]);
                    System.out.println("Horário da típico: " + animal[i][4] + "\n");
                }

                System.out.println("Operação realizada com Sucesso!!!");
                System.out.println("Aperte Enter para continuar...");
                
                entrada.next();
                
            }

            if (opmenu != 1 && opmenu != 2 && opmenu != 3 && opmenu != 4 && opmenu != 5 && opmenu != 6) {
                System.out.println("OPÇÃO INVÁLIDA!!!");
                entrada.next();
            }
        } while (opmenu != 6);
    }

    public static void menuFuncionario() {

        int funcao = 0;
        do {
            i = 0;
            controle = 0;
            
            System.out.println("\n\n\n");
            System.out.println("MENU FUNCIONÁRIOS");
            System.out.println("1- Novo Cadastro");
            System.out.println("2- Apagar Cadastro");
            System.out.println("3- Procurar Cadastro");
            System.out.println("4- Alterar Cadastro");
            System.out.println("5- Exibir Cadastros");
            System.out.println("6- Voltar");
            System.out.print("Escolha opção desejada: ");
            
            opmenu = entrada.nextInt();

            if (opmenu == 1) {
                if (contFuncionario <= 100) {
                    System.out.println("\nNOVO CADASTRO");
                    System.out.print("Informe o CPF: ");
                    auxiliar = entrada.next();

                    while (i <= contFuncionario && controle == 0) {
                        if (auxiliar.equals(funcionario[i][0])) {
                            System.out.println("JÁ EXISTE ESTE Nº DE CPF NO CADASTRO!");
                            controle = 1;
                        } 
                        else if (i == contFuncionario) {
                            funcionario[contFuncionario][0] = auxiliar;
                        }
                        i++;
                    }

                    if (controle == 0) {
                        System.out.print("Nome: ");
                        funcionario[contFuncionario][1] = entrada.next();
                        System.out.print("Telefone: ");
                        funcionario[contFuncionario][2] = entrada.next();
                        
                        while (controle == 0) {
                            System.out.println("Selecione a Função: ");
                            System.out.println("1- Equipe de Apoio");
                            System.out.println("2- Nutricionista");
                            System.out.println("3- Veterinário");
                            System.out.print("Selecione: ");
                            funcao = entrada.nextInt();

                            if (funcao == 1) {
                                funcionario[contFuncionario][3] = "Equipe de apoio";
                                System.out.println("Função: " + funcionario[contFuncionario][3]);
                                controle = 1;
                            } 
                            else if (funcao == 2) {
                                funcionario[contFuncionario][3] = "Nutricionista";
                                System.out.println("Função: " + funcionario[contFuncionario][3]);
                                controle = 1;
                            } 
                            else if (funcao == 3) {
                                funcionario[contFuncionario][3] = "Veterinário";
                                System.out.println("Função: " + funcionario[contFuncionario][3]);
                                controle = 1;
                            } else {
                                System.out.println("FUNÇÃO INVÁLIDA!!!");
                            }
                        }
                        contFuncionario++;
                        System.out.println("Operação realizada com Sucesso!!!");
                        System.out.println("Aperte Enter para continuar...");
                    }
                } else {
                    System.out.println("MATRIZ CHEIA!!!");
                }
                entrada.next();
            }

            if (opmenu == 2) {
                System.out.println("\nAPAGAR CADASTRO");
                System.out.print("Digite o CPF do funcionário a ser apagado: ");
                auxiliar = entrada.next();

                while (i <= contFuncionario && controle == 0) {

                    if (auxiliar.equals(funcionario[i][0])) {
                        while (i < contFuncionario) {
                            funcionario[i][0] = funcionario[i + 1][0];
                            funcionario[i][1] = funcionario[i + 1][1];
                            funcionario[i][2] = funcionario[i + 1][2];
                            funcionario[i][3] = funcionario[i + 1][3];
                            i++;
                        }
                        contFuncionario--;
                        controle = 1;
                        System.out.println("FUNCIONÁRIO RETIRADO!!!");

                    } 
                    else if (i == contFuncionario) {
                        System.out.println("CPF NÃO EXISTE NA MATRIZ!!!");
                    }
                    i++;
                }
                entrada.next();
            }

            if (opmenu == 3) {
                System.out.println("\nPROCURAR CADASTRO");
                System.out.print("Digite o CPF do funcionário que deseja procurar: ");
                auxiliar = entrada.next();

                while (i <= contFuncionario && controle == 0) {
                    if (auxiliar.equals(funcionario[i][0])) {
                        System.out.println("Nome: " + funcionario[i][1]);
                        System.out.println("Telefone: " + funcionario[i][2]);
                        System.out.println("Função: " + funcionario[i][3]);
                        System.out.println("Operação realizada com sucesso!!!");
                        System.out.println("Aperte Enter para continuar...");
                        
                        controle = 1;
                    } 
                    else if (i == contFuncionario) {
                        System.out.println("CPF NÃO CADASTRADO!!!");
                    }
                    i++;
                }
                entrada.next();
            }

            if (opmenu == 4) {
                System.out.println("\nALTERAR CADASTRO");
                System.out.print("Digite o o CPF do funcionário a ser alterado: ");
                
                auxiliar = entrada.next();

                while (i <= contFuncionario && controle == 0) {
                    if (auxiliar.equals(funcionario[i][0])) {
                        System.out.println("Selecione a nova função [" + funcionario[i][3] + "]");
                        System.out.println("1- Equipe de Apoio");
                        System.out.println("2- Nutricionista");
                        System.out.println("3- Veterinario");
                        System.out.print("Selecione: ");
                        
                        funcao = entrada.nextInt();

                        if (funcao == 1 || funcao == 2 || funcao == 3) {
                            if (funcao == 1) {
                                funcionario[i][3] = "Equipe de Apoio";
                            }
                            if (funcao == 2) {
                                funcionario[i][3] = "Nutricionista";
                            }
                            if (funcao == 3) {
                                funcionario[i][3] = "Veterinario";
                            }
                            System.out.print("Novo nome [" + funcionario[i][1] + "]: ");
                            funcionario[i][1] = entrada.next();
                            System.out.print("Novo telefone [" + funcionario[i][2] + "]: ");
                            funcionario[i][2] = entrada.next();
                            System.out.println("Operação realizada com Sucesso!!!");
                            System.out.println("Aperte Enter para continuar...");
                        } else
                        {
                            System.out.println("FUNÇÃO INVÁLIDA!!!");
                        }

                        controle = 1;

                    } 
                    else if (i == contFuncionario) {
                        System.out.println("CPF NÃO CADASTRADO!!!");
                    }
                    i++;
                }
                entrada.next();
            }

            if (opmenu == 5) {
                System.out.println("\nEXIBIR CADASTROS");

                for (i = 0; i < contFuncionario; i++) {
                    System.out.println("CPF: " + funcionario[i][0]);
                    System.out.println("Nome: " + funcionario[i][1]);
                    System.out.println("Telefone: " + funcionario[i][2]);
                    System.out.println("Função: " + funcionario[i][3] + "\n");
                }

                System.out.println("Operação realizada com Sucesso!!!");
                System.out.println("Aperte Enter para continuar...");
                entrada.next();

            }
            
            if (opmenu != 1 && opmenu != 2 && opmenu != 3 && opmenu != 4 && opmenu != 5 && opmenu != 6) {
                System.out.println("OPÇÃO INVÁLIDA!!!");
                entrada.next();
            }
        } while (opmenu != 6);
    }

    public static void menuRecinto() {
        do {
            i = 0;
            controle = 0;

            System.out.println("\n\n\n");
            System.out.println("CONTROLE DE RECINTOS");
            System.out.println("1- Cadastrar Recinto");
            System.out.println("2- Apagar Cadastro");
            System.out.println("3- Buscar Cadastro");
            System.out.println("4- Alterar Cadastro");
            System.out.println("5- Exibir Cadastros");
            System.out.println("6- Voltar");
            System.out.print("Escolha opção desejada: ");
            
            opmenu = entrada.nextInt();

            if (opmenu == 1) {
                if (contRecinto <= 100) {
                    System.out.println("\nCADASTRAR RECINTO");

                    System.out.print("Número do Recinto: ");
                    auxiliar = entrada.next();

                    while (i <= contRecinto && controle == 0) {
                        if (auxiliar.equals(recinto[i][0])) {
                            System.out.println("EXISTE OUTRO RECINTO CADASTRADO COM ESTE NÚMERO!!!");
                            controle = 1;
                        } 
                        else if (i == contRecinto) {
                            recinto[contRecinto][0] = auxiliar;
                        }
                        i++;
                    }

                    if (controle == 0) {
                        System.out.print("Número de animais no recinto: ");
                        recinto[contRecinto][1] = entrada.next();
                        System.out.print("Frequência de limpeza do recinto: ");
                        recinto[contRecinto][2] = entrada.next();
                        contRecinto++;
                        System.out.print("Operação realizada com Sucesso!!!");
                        System.out.println("Aperte Enter para continuar...");
                    }
                } else {
                    System.out.println("MATRIZ CHEIA!!!");
                }
                entrada.next();
            }

            if (opmenu == 2) {
                System.out.println("\nAPAGAR CADASTRO");
                System.out.print("Digite o número do recinto a ser retirado: ");
                auxiliar = entrada.next();

                while (i <= contRecinto && controle == 0) {

                    if (auxiliar.equals(recinto[i][0])) {
                        while (i < contRecinto) {
                            recinto[i][0] = recinto[i + 1][0];
                            recinto[i][1] = recinto[i + 1][1];
                            recinto[i][2] = recinto[i + 1][2];
                            i++;
                        }
                        contRecinto--;
                        controle = 1;
                        System.out.println("CADASTRO EXCLUIDO!!!");

                    } 
                    else if (i == contRecinto) {
                        System.out.println("NÃO EXISTE RECINTO COM O CÓDIGO FORNECIDO!!!");
                    }
                    i++;
                }
                entrada.next();
            }

            if (opmenu == 3) {
                System.out.println("\nPROCURAR RECINTO");
                System.out.print("Digite o número do recinto a ser buscada: ");
                auxiliar = entrada.next();

                while (i <= contRecinto && controle == 0) {
                    if (auxiliar.equals(recinto[i][0])) {
                        System.out.println("Número de animais no recinto: " + recinto[i][1]);
                        System.out.println("Frequência de limpeza: " + recinto[i][2]);
                        System.out.println("Operação realizada com sucesso!!!");
                        System.out.println("Aperte Enter para continuar...");
                        controle = 1;
                    } 
                    else if (i == contRecinto) {
                        System.out.println("RECINTO NÃO CADASTRADO!!!");
                    }
                    i++;
                }
                entrada.next();
            }

            if (opmenu == 4) {
                System.out.println("\nALTERAR CADASTRO");
                System.out.print("Digite o número do recinto a ser alterado: ");
                auxiliar = entrada.next();

                while (i <= contRecinto && controle == 0) {
                    if (auxiliar.equals(recinto[i][0])) {
                        System.out.print("Novo número de animais no recinto: [" + recinto[i][1] + "]: ");
                        recinto[i][1] = entrada.next();
                        System.out.print("Nova frequência de limpeza [" + recinto[i][2] + "]: ");
                        recinto[i][2] = entrada.next();
                        System.out.println("Operação realizada com sucesso!!!");
                        System.out.println("Aperte Enter para continuar...");
                        controle = 1;

                    } 
                    else if (i == contRecinto) {
                        System.out.println("RECINTO NÃO CADASTRADO!!!");
                    }
                    i++;
                }
                entrada.next();
            }

            if (opmenu == 5) {
                System.out.println("\nEXIBIR CADASTROS");

                for (i = 0; i < contRecinto; i++) {
                    System.out.println("Número do recinto: " + recinto[i][0]);
                    System.out.println("Número de animais no recinto: " + recinto[i][1]);
                    System.out.println("Frequência de limpeza: " + recinto[i][2] + "\n");
                }
                System.out.println("Operação concluida com sucesso!!!");
                System.out.println("Aperte Enter para continuar...");
                entrada.next();
            }
            if (opmenu != 1 && opmenu != 2 && opmenu != 3 && opmenu != 4 && opmenu != 5 && opmenu != 6) {
                System.out.println("OPÇÃO INVÁLIDA!!!");
                entrada.next();
            }
        } while (opmenu != 6);
    }

    public static void menuAlimentacao() {
        String aux2;
        do {
            i = 0;
            controle = 0;

            System.out.println("\n\n\n");
            System.out.println("MENU CUIDADOS E ALIMENTAÇÃO");
            System.out.println("1- Novo registro");
            System.out.println("2- Excluir registro");
            System.out.println("3- Buscar Registro");
            System.out.println("4- Alterar Registro");
            System.out.println("5- Exibir Registros");
            System.out.println("6- Sair");
            System.out.print("Escolha opção desejada: ");
            opmenu = entrada.nextInt();

            if (opmenu == 1) {
                if (contAlimentacao <= 100) {
                    System.out.println("\nNOVO REGISTRO");
                    System.out.println("Número de controle: " + contCodAlimentacao);
                    System.out.print("Código do animal alimentado: ");
                    auxiliar = entrada.next();
                    while (i <= contAnimal && controle == 0) {
                        if (auxiliar.equals(animal[i][0])) {
                            controle = 1;
                        } 
                        else if (i == contAnimal) {
                            System.out.println("REGISTRO NÃO ENCONTRADO!!!");
                        }
                        i++;
                    }

                    if (controle == 1) {
                        i = 0;
                        controle = 0;
                        
                        System.out.print("CPF do funcionario: ");
                        aux2 = entrada.next();

                        while (i <= contFuncionario && controle == 0) {

                            if (aux2.equals(funcionario[i][0]) && funcionario[i][3].equals("Funcionario do zoologico")) {
                                controle = 1;
                            } 
                            else if (i == contFuncionario) {
                                System.out.println("CADASTRO NÃO ENCONTRADO!!!");
                            }
                            i++;
                        }

                        if (controle == 1) {
                            
                            alimentacao[contAlimentacao][0] = Integer.toString(contCodAlimentacao);
                            alimentacao[contAlimentacao][1] = auxiliar;
                            alimentacao[contAlimentacao][2] = aux2;

                            System.out.print("Dia [xx]: ");
                            alimentacao[contAlimentacao][3] = entrada.next();
                            System.out.print("Mês [xx]: ");
                            alimentacao[contAlimentacao][4] = entrada.next();
                            System.out.print("Ano [xxxx]: ");
                            alimentacao[contAlimentacao][5] = entrada.next();
                            System.out.print("Horário: ");
                            alimentacao[contAlimentacao][6] = entrada.next();
                            System.out.print("Obs: ");
                            alimentacao[contAlimentacao][7] = entrada.next();

                            contCodAlimentacao++;
                            contAlimentacao++;
                            System.out.println("Operação concluida com êxito!!!");
                            System.out.println("Aperte Enter para continuar...");
                        }
                    }
                } else {
                    System.out.println("MATRIZ CHEIA!!!");
                }
                entrada.next();
            }

            if (opmenu == 2) {
                System.out.println("\nAPAGAR REGISTRO");
                System.out.print("Digite o número do registro a ser apagado: ");
                auxiliar = entrada.next();

                while (i <= contAlimentacao && controle == 0) {

                    if (auxiliar.equals(alimentacao[i][0])) {
                        while (i < contAlimentacao) {
                            alimentacao[i][0] = alimentacao[i + 1][0];
                            alimentacao[i][1] = alimentacao[i + 1][1];
                            alimentacao[i][2] = alimentacao[i + 1][2];
                            alimentacao[i][3] = alimentacao[i + 1][3];
                            alimentacao[i][4] = alimentacao[i + 1][4];
                            alimentacao[i][5] = alimentacao[i + 1][5];
                            alimentacao[i][6] = alimentacao[i + 1][6];
                            alimentacao[i][7] = alimentacao[i + 1][7];
                            i++;
                        }
                        contAlimentacao--;
                        controle = 1;
                        System.out.println("REGISTRO APAGADO!!!");

                    } 
                    else if (i == contAlimentacao) {
                        System.out.println("CÓDIGO FORNECIDO NÃO CADASTRADO NO SISTEMA!!!");
                    }
                    i++;
                }
                entrada.next();
            }

            if (opmenu == 3) {
                System.out.println("\nBUSCAR REGISTRO");
                System.out.print("Digite o dia a ser buscado: ");
                String dia = entrada.next();
                System.out.print("Digite o mês a ser buscada: ");
                String mes = entrada.next();
                System.out.print("Digite o ano a ser buscado: ");
                String ano = entrada.next();

                while (i <= contAlimentacao) {

                    if (dia.equals(alimentacao[i][3]) && mes.equals(alimentacao[i][4]) && ano.equals(alimentacao[i][5])) {

                        System.out.println("Código do Registro: " + alimentacao[i][0]);
                        System.out.println("Código do animal alimentado: " + alimentacao[i][1]);
                        System.out.println("CPF do funcionario: " + alimentacao[i][2]);
                        System.out.println("Horário da alimentacao: " + alimentacao[i][6]);
                        System.out.println("OBS: " + alimentacao[i][7] + "\n");

                        controle = 1;
                    }
                    i++;
                }

                if (controle == 0){
                    System.out.println("NENHUM REGISTRO COM ESSA DATA FOI ENCONTRADO!!!");
                } else {
                    System.out.println("Operação realizada com sucesso!!!");
                    System.out.println("Aperte Enter para continuar...");
                }
                entrada.next();
            }

            if (opmenu == 4) {
                System.out.println("\nALTERAR CADASTRO");
                System.out.print("Digite o número do cadastro a ser alterado: ");
                auxiliar = entrada.next();

                while (i <= contAlimentacao && controle == 0) {
                    if (auxiliar.equals(alimentacao[i][0])) {
                        controle = 1;
                    } 
                    else if (i == contAlimentacao) {
                        System.out.println("CADASTRO NÃO EXISTE");
                    }
                    i++;
                }

                if (controle == 1) {
                    j = i - 1;
                    i = 0;
                    controle = 0;
                    System.out.print("Novo código do animal [" + alimentacao[j][1] + "]: ");
                    auxiliar = entrada.next();
                    
                    while (i <= contAnimal && controle == 0) {
                        if (auxiliar.equals(animal[i][0])) {
                            controle = 1;
                        } 
                        else if (i == contAnimal) {
                            System.out.println("CADASTRO NÃO ENCONTRADO!!!");
                        }
                        i++;
                    }

                    if (controle == 1) {
                        i = 0;
                        controle = 0;

                        System.out.print("Novo CPF do funcionario [" + alimentacao[j][2] + "]: ");
                        aux2 = entrada.next();

                        while (i <= contFuncionario && controle == 0) {
                            if (aux2.equals(funcionario[i][0])) {
                                controle = 1; // cpf existe
                            } 
                            else if (i == contFuncionario) {
                                System.out.println("CADASTRO NÃO ENCONTRADO!!!");
                            }
                            i++;
                        }

                        if (controle == 1) {
                            
                            alimentacao[j][1] = auxiliar;
                            alimentacao[j][2] = aux2;
                            System.out.print("Novo dia [" + alimentacao[j][3] + "]: ");
                            alimentacao[j][3] = entrada.next();
                            System.out.print("Novo mês [" + alimentacao[j][4] + "]: ");
                            alimentacao[j][4] = entrada.next();
                            System.out.print("Novo ano [" + alimentacao[j][5] + "]: ");
                            alimentacao[j][5] = entrada.next();
                            System.out.print("Novo hora [" + alimentacao[j][6] + "]: ");
                            alimentacao[j][6] = entrada.next();
                            System.out.print("Nova OBS [" + alimentacao[j][7] + "]: ");
                            alimentacao[j][7] = entrada.next();
                            System.out.println("Operação concluida com êxito!!!");
                            System.out.println("Aperte Enter para continuar...");
                        }
                    }
                }
                entrada.next();
            }

            if (opmenu == 5) {
                System.out.println("\nEXIBIR REGISTROS");
                for (i = 0; i < contAlimentacao; i++) {
                    System.out.println("Número de Controle: " + alimentacao[i][0]);
                    System.out.println("Código do Animal: " + alimentacao[i][1]);
                    System.out.println("CPF do Funcionario: " + alimentacao[i][2]);
                    System.out.println("Dia: " + alimentacao[i][3]);
                    System.out.println("Mês: " + alimentacao[i][4]);
                    System.out.println("Ano: " + alimentacao[i][5]);
                    System.out.println("Hora: " + alimentacao[i][6]);
                    System.out.println("OBS: " + alimentacao[i][7] + "\n");
                }
                System.out.println("Operação concluida com Sucesso!!!");
                System.out.println("Aperte Enter para continuar...");
                entrada.next();
            }

            if (opmenu != 1 && opmenu != 2 && opmenu != 3 && opmenu != 4 && opmenu != 5 && opmenu != 6) {
                System.out.println("OPÇÃO INVÁLIDA!!!");
                entrada.next();
            }
        } while (opmenu != 6);
    }

    public static void menuLimpeza() {
        do {
            i = 0;
            controle = 0;

            System.out.println("\n\n\n");
            System.out.println("MENU LIMPEZA");
            System.out.println("1- Novo registro");
            System.out.println("2- Apagar registro");
            System.out.println("3- Procurar Registro");
            System.out.println("4- Alterar Registro");
            System.out.println("5- Exibir Registros");
            System.out.println("6- Voltar");
            System.out.print("Escolha opção desejada: ");
            opmenu = entrada.nextInt();

            if (opmenu == 1) {
                if (contLimpeza <= 100) {
                    System.out.println("\nNOVO REGISTRO");
                    System.out.println("Número de controle: " + contCodLimpeza);
                    System.out.print("Código do recinto limpo: ");
                    
                    auxiliar = entrada.next();
                    
                    while (i <= contRecinto && controle == 0) {
                        if (auxiliar.equals(recinto[i][0])) {
                            controle = 1;
                        } 
                        else if (i == contRecinto) {
                            System.out.println("RECINTO NÃO CADASTRADO!!!");
                        }
                        i++;
                    }

                    if (controle == 1) {
                        
                        limpeza[contLimpeza][0] = Integer.toString(contCodLimpeza);
                        limpeza[contLimpeza][1] = auxiliar;
                        System.out.print("Data [xx/xx/xxxx]: ");
                        limpeza[contLimpeza][2] = entrada.next();
                        System.out.print("Horário: ");
                        limpeza[contLimpeza][3] = entrada.next();

                        contCodLimpeza++;
                        contLimpeza++;
                        System.out.println("Operação concluida com sucesso!!!");
                        System.out.println("Aperte Enter para continuar...");
                    }
                } else {
                    System.out.println("MATRIZ CHEIA!!!");
                }
                entrada.next();
            }

            if (opmenu == 2) {
                System.out.println("\nEXCLUIR REGISTRO");
                System.out.print("Digite o número do registro a ser excluido: ");
                auxiliar = entrada.next();

                while (i <= contLimpeza && controle == 0) {

                    if (auxiliar.equals(limpeza[i][0])) {
                        while (i < contLimpeza) {
                            limpeza[i][0] = limpeza[i + 1][0];
                            limpeza[i][1] = limpeza[i + 1][1];
                            limpeza[i][2] = limpeza[i + 1][2];
                            limpeza[i][3] = limpeza[i + 1][3];
                            i++;
                        }
                        contLimpeza--;
                        controle = 1;
                        System.out.println("REGISTRO APAGADO");

                    } 
                    else if (i == contLimpeza) {
                        System.out.println("CÓDIGO FORNECIDO NÃO ESTA CADASTRADO NO SISTEMA!!!");
                    }
                    i++;
                }
                entrada.next();
            }

            if (opmenu == 3) {
                System.out.println("\nPROCURAR REGISTRO");
                System.out.print("Digite o recinto a ser buscado: ");
                auxiliar = entrada.next();

                while (i <= contLimpeza) {
                    if (auxiliar.equals(limpeza[i][1])) {
                        System.out.println("Código do Registro: " + limpeza[i][0]);
                        System.out.println("Data: " + limpeza[i][2]);
                        System.out.println("Horário: " + limpeza[i][3] + "\n");
                        controle = 1;
                    }
                    i++;
                }

                if (controle == 0)
                {
                    System.out.println("REGISTRO NÃO ENCONTRADO!!!");
                } else {
                    System.out.println("Operação realizada com Sucesso!!!");
                    System.out.println("Aperte Enter para continuar...");
                }
                entrada.next();
            }

            if (opmenu == 4) {
                System.out.println("\nALTERAR REGISTRO");
                System.out.print("Digite o número do registro a ser alterado: ");
                auxiliar = entrada.next();

                while (i <= contLimpeza && controle == 0) {
                    if (auxiliar.equals(limpeza[i][0])) {
                        controle = 1;
                    } 
                    else if (i == contLimpeza) {
                        System.out.println("RECINTO NÃO CADASTRADO!!!");
                    }
                    i++;
                }

                if (controle == 1) {
                    j = i - 1;
                    i = 0;
                    controle = 0;
                    
                    System.out.print("Novo código do recinto limpo[" + limpeza[j][1] + "]: ");
                    auxiliar = entrada.next();
                    while (i <= contRecinto && controle == 0) {
                        if (auxiliar.equals(recinto[i][0])) {
                            controle = 1;
                        } 
                        else if (i == contRecinto) {
                            System.out.println("REGISTRO NÃO ENCONTRADO!!!");
                        }
                        i++;
                    }

                    if (controle == 1) {
                        limpeza[j][1] = auxiliar;
                        System.out.print("Nova data [" + limpeza[j][2] + "]: ");
                        limpeza[j][2] = entrada.next();
                        System.out.print("Novo horário [" + limpeza[j][3] + "]: ");
                        limpeza[j][3] = entrada.next();
                        System.out.println("Operação concluida com sucesso!!!");
                        System.out.println("Aperte Enter para continuar...");
                    }
                }
                entrada.next();
            }

            if (opmenu == 5) {
                System.out.println("\nMOSTRAR REGISTROS");
                for (i = 0; i < contLimpeza; i++) {
                    System.out.println("Número de Controle: " + limpeza[i][0]);
                    System.out.println("Número do Recinto: " + limpeza[i][1]);
                    System.out.println("Data: " + limpeza[i][2]);
                    System.out.println("Hora: " + limpeza[i][3] + "\n");
                }
                System.out.println("Operação concluida com Sucesso!!!");
                System.out.println("Aperte Enter para continuar...");
                entrada.next();
            }

            if (opmenu != 1 && opmenu != 2 && opmenu != 3 && opmenu != 4 && opmenu != 5 && opmenu != 6) {
                System.out.println("OPÇÃO INVÁLIDA!!!");
                entrada.next();
            }
        } while (opmenu != 6);
    }

    public static void menuPrincipal() {
        System.out.println("ZOOMIGO by Zoosoft");
        System.out.println("1- Menu Animais");
        System.out.println("2- Menu Funcionarios");
        System.out.println("3- Menu Recinto");
        System.out.println("4- Menu Alimentação");
        System.out.println("5- Menu Limpeza");
        System.out.println("6- Salvar");
        System.out.println("7- Sair");
        System.out.print("Escolha a opção desejada: ");
    }

    public static void main(String[] args) {
        carregar();
        entrada.useDelimiter("\\n");
        do {
            menuPrincipal();
            opmenu = entrada.nextInt();
            switch (opmenu) {
                case 1:
                    menuAnimal();
                    opmenu = 1;
                    break;
                case 2:
                    menuFuncionario();
                    opmenu = 2;
                    break;
                case 3:
                    menuRecinto();
                    opmenu = 3;
                    break;
                case 4:
                    menuAlimentacao();
                    opmenu = 4;
                    break;
                case 5:
                    menuLimpeza();
                    opmenu = 5;
                    break;
                case 6:
                    salvar();
                    opmenu = 6;
                    break;
            }
            
            if (opmenu != 1 && opmenu != 2 && opmenu != 3 && opmenu != 4 && opmenu != 5 && opmenu != 6 && opmenu != 7) {
                System.out.println("OPÇÃO INVÁLIDA!!!");
                entrada.next();
            }
            System.out.println("\n\n\n");
        } while (opmenu != 7);
        do {
            System.out.println("Deseja Salvar? 1-Sim / 2-Nao");
            System.out.print("Opção: ");
            opmenu = entrada.nextInt();
            if (opmenu == 1)
            {
                salvar();
            }
        } while (opmenu != 1 && opmenu != 2);
    }
}