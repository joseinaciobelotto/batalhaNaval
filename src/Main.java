import java.util.Random;
import java.util.Scanner;
public class Main {
    static Scanner ler = new Scanner(System.in);
    static Random rand = new Random();
    //---------------------------------------------------IMPRESSÃO-----------------------------------------------------------------------------//
    static String[][] matrixMapUm = new String[10][10];
    static String[][] matrixMapDois = new String[10][10];
    static String[][] getMatrixMapUmAtacada = new String[10][10];
    static String[][] getMatrixMapDoisAtacada = new String[10][10];
    //static = NORMAL;
    public static String[][] iniciar(String[][] matrixMap){
        for (int aux1=0; aux1<matrixMap.length; aux1++)
        {
            for (int aux2=0; aux2<matrixMap[0].length; aux2++)
            {
                matrixMap[aux1][aux2]= "🌊";
            }
        }
        return matrixMap;
    }
    static void printar(String[][] matrixMap){
        char alfabeto = 65;
        System.out.println("   || 0 |  1 |  2 |  3 |  4  |  5  |  6 | 7  |  8 |  9 ||");
        for (int aux = 0; aux<10; aux++){
            System.out.printf(" " + alfabeto + " ");
            for (int aux2=0; aux2<matrixMap[0].length; aux2++)
            {
                System.out.printf("| "+ matrixMap[aux][aux2] +" ");
            }
            System.out.printf("| \n");
            alfabeto++;
        }
    }
    static String[][] percorrerMatriz( String[][]matrixMap,int tamanhoEscHere,int cabecaXHere, int cabecaYHere, char direcaoHere)
    {
        int aux1, aux2,aux3 = 0;
        for (aux1=0; aux1<matrixMap.length; aux1++)
        {
            for (aux2=0; aux2<matrixMap[0].length; aux2++)
            {
                if(aux1 == cabecaXHere && aux2 == cabecaYHere)
                {
                    matrixMap[aux1][aux2] = "⚓";
                    if(tamanhoEscHere == 2)
                    {
                        if(direcaoHere == 'V'){
                            for (int contP = aux1; contP <= aux1 + 1; contP++) {
                                matrixMap[contP][aux2] = "⚓";
                            }
                        }
                        else if(direcaoHere == 'H'){
                            for (int contP = aux2; contP <= aux2 + 1; contP++) {
                                matrixMap[aux1][contP] = "⚓";
                            }
                        }
                    }
                    else if(tamanhoEscHere == 3){
                        if(direcaoHere == 'V'){
                            for (int contP = aux1; contP <= aux1 + 2; contP++) {
                                matrixMap[contP][aux2] = "⚓";
                            }
                        }
                        else if(direcaoHere == 'H') {
                            for (int contP = aux2; contP <= aux2 + 2; contP++) {
                                matrixMap[aux1][contP] = "⚓";
                            }
                        }
                    }
                    else if(tamanhoEscHere == 4)
                    {
                        if(direcaoHere == 'V'){
                            for (int contP = aux1; contP <= aux1 + 3; contP++) {
                                matrixMap[contP][aux2] = "⚓";
                            }
                        }
                        else if(direcaoHere == 'H'){
                            for (int contP = aux2; contP <= aux2 + 3; contP++) {
                                matrixMap[aux1][contP] = "⚓";
                            }
                        }
                    }
                }
            }
        }
        return matrixMap;
    }
    //--------------------------------------------------------POSICIONAMENTO---------------------------------------------------------//
    static int testeDePercorrimento(String[][] matrixMap, int tamanhoEscHere, int cabecaXHere, int cabecaYHere, char direcaoHere)
    {
        int aux=0, linhaColuna = 0, barcos = 0;
        switch (direcaoHere)
        {
            case 'H':
                aux = cabecaYHere;
                for (; aux<=(tamanhoEscHere+cabecaYHere-1); aux++)
                {
                    if(matrixMap[cabecaXHere][aux] == "⚓")
                    {
                        barcos++;
                    }
                }
                break;
            case 'V':
                aux = cabecaXHere;
                for (; aux<=(tamanhoEscHere+cabecaXHere-1); aux++)
                {
                    if(matrixMap[aux][cabecaYHere] == "⚓")
                    {
                        barcos++;
                    }
                }
                break;
        }
        return barcos;
    };
    static int[] tamanho( String[][] matrixMap, int tamanhoEsc, int cabecaX, int cabecaY, char direcao, int varTipo, int posicionamentoTeste)
    {
        int somaDirecao =0;
        int[] tamanhoReturn = new int[7];
        switch (direcao)
        {
            case 'V':
                somaDirecao = cabecaX + tamanhoEsc;
                break;
            case 'H':
                somaDirecao = cabecaY + tamanhoEsc;
                break;
        }
        if (varTipo != 0) {
            if (somaDirecao <= 10)
            {
                tamanhoReturn[0] = -1;
                tamanhoReturn[1] = 0;
                if (0 != testeDePercorrimento(matrixMap, tamanhoEsc, cabecaX, cabecaY, direcao))
                {
                    System.out.println("Já tem um barco ai!");
                    tamanhoReturn[1] = 3;
                    tamanhoReturn[0] = 0;
                }
            } else {
                System.out.println("Saiu do campo de batalha!");
                tamanhoReturn[1] = 3;
                tamanhoReturn[0] = 0;
            }
        }
        else
        {
            System.out.println("Número de barcos esgotado!");
            tamanhoReturn[1]=3;
        }
        return tamanhoReturn;
    }
    static String[][] pedir(String[][] matrixMap)
    {
        Scanner ler = new Scanner(System.in);
        char tipo, direcao = 0;
        int varGi = 1, varGr = 2, varMe = 3, varPe =4, posicionamentoTeste = 3, cabecaX = 1, cabecaY = 1, tamanhoEsc = 0;
        int[] varBarco = new int[4];
        varBarco[0] = varGi;
        varBarco[1] = varGr;
        varBarco[2] = varMe;
        varBarco[3] = varPe;
        while (varBarco[0] != 0 || varBarco[1] != 0 || varBarco[2] != 0 || varBarco[3] != 0 || posicionamentoTeste != 0)
        {
            posicionamentoTeste = 3;
            while (posicionamentoTeste == 3)
            {
                System.out.println("Qual a linha do primeiro quadrado do barco?");
                cabecaX = (int) ler.next().toUpperCase().charAt(0);
                cabecaX = cabecaX - 65;
                if (cabecaX >= 0 && cabecaX <= 9) {
                    System.out.println("Qual a coluna do primeiro quadrado do barco?");
                    cabecaY = (int) ler.next().toUpperCase().charAt(0);
                    cabecaY = cabecaY - 48;
                    if (cabecaY >= 0 && cabecaY <= 9) {
                        posicionamentoTeste--;
                    } else {
                        System.out.println("Posição inválida! Digite novamente!");
                    }
                } else {
                    System.out.println("Posição inválida! Digite novamente!");
                }
                ler.nextLine();
            }
            while (posicionamentoTeste == 2)
            {
                System.out.println("Posicionar na vertical ou na horizontal? (V/H)");
                direcao = ler.next().toUpperCase().charAt(0);
                switch (direcao) {
                    case 'V':
                        posicionamentoTeste--;
                        break;
                    case 'H':
                        posicionamentoTeste--;
                        break;
                    default:
                        System.out.println("Direção inválida! Digite novamente");
                        posicionamentoTeste = 2;
                }
            }
            while (posicionamentoTeste == 1)
            {
                int[] tamanhoReturnHere = new int[7];
                int auxBarco = 0;
                System.out.println("Qual barco você deseja selecionar?");
                System.out.println("A - Barco Gigante(4)  Você possui" + "[" + varBarco[0] + "]" + "deste tipo sobrando");
                System.out.println("B - Barco Grande(3)   Você possui" + "[" + varBarco[1] + "]" + "deste tipo sobrando");
                System.out.println("C - Barco Médio(2)    Você possui" + "[" + varBarco[2] + "]" + "deste tipo sobrando");
                System.out.println("D - Barco Pequeno(1)  Você possui" + "[" + varBarco[3] + "]" + "deste tipo sobrando");
                tipo = ler.next().toUpperCase().charAt(0);
                switch (tipo) {
                    case 'A':
                        auxBarco = 0;
                        tamanhoEsc = 4;
                        break;
                    case 'B':
                        auxBarco = 1;
                        tamanhoEsc = 3;
                        break;
                    case 'C':
                        auxBarco = 2;
                        tamanhoEsc = 2;
                        break;
                    case 'D':
                        auxBarco = 3;
                        tamanhoEsc = 1;
                        break;
                    default: {
                        posicionamentoTeste = 1;
                    }
                }
                tamanhoReturnHere = tamanho(matrixMap,tamanhoEsc,  cabecaX,  cabecaY, direcao, varBarco[auxBarco],  posicionamentoTeste);
                varBarco[auxBarco]+= tamanhoReturnHere[0];
                posicionamentoTeste = tamanhoReturnHere[1];
                System.out.println("Digite o próximo barco!");
            }
            if(posicionamentoTeste == 0)
            {
                percorrerMatriz(matrixMap, tamanhoEsc, cabecaX, cabecaY, direcao);
                printar(matrixMap);
            }
        }
        return matrixMap;
    }
    static String[][] positAleatoria(String[][]matrixMapHere)
    {
        int varGi = 1, varGr = 2, varMe = 3, varPe = 4, testePosit = 0, testePosita = 20, tamanhoEsc = 0, aux2 = 0, x =0, y =0, randHere=0,  auxTipo =0;
        char varTipo = '0', vOh = 'a';
        int[] tamanhoReturnHere = new int[7];
        int[] varTipos = new int[4];
        varTipos[0]=varGi;
        varTipos[1]=varGr;
        varTipos[2]=varMe;
        varTipos[3]=varPe;
        for( aux2=10; aux2> 0; )
        {
            if(varTipos[auxTipo]<=0 && auxTipo<=3)
            {
                auxTipo++;
            }
            switch (auxTipo)
            {
                case 0:
                    varTipo =  'A';
                    tamanhoEsc = 4;
                    if (rand.nextInt(0,2) == 1) {
                        vOh = 'V';
                    } else {
                        vOh = 'H';
                    }
                    x = rand.nextInt(0,10);
                    y = rand.nextInt(0,10);
                    tamanhoReturnHere =  tamanho(matrixMapHere,  tamanhoEsc, x, y, vOh, varTipo, 0);
                    testePosit = tamanhoReturnHere[1];
                    if( testePosit==3 ){
                    }else{
                        aux2-=1;
                        varGi--;
                        varTipos[0]-=1;
                        percorrerMatriz(matrixMapHere, tamanhoEsc, x, y, vOh);
                    }
                    break;
                case 1:
                    varTipo =  'B';
                    tamanhoEsc = 3;
                    if (rand.nextInt(0,2) == 1) {
                        vOh = 'V';
                    } else {
                        vOh = 'H';
                    }
                    x = rand.nextInt(0,10);
                    y = rand.nextInt(0,10);
                    tamanhoReturnHere = tamanho(matrixMapHere,  tamanhoEsc, x, y, vOh, varTipo, 0);
                    testePosit = tamanhoReturnHere[1];
                    if(testePosit==3){
                    }else{
                        aux2-=1;
                        varGr--;
                        varTipos[1]-=1;
                        percorrerMatriz(matrixMapHere, tamanhoEsc, x, y, vOh);
                    }
                    break;
                case 2:
                    varTipo =  'C';
                    tamanhoEsc = 2;
                    if (rand.nextInt(0,2) == 1) {
                        vOh = 'V';
                    } else {
                        vOh = 'H';
                    }
                    x = rand.nextInt(0,10);
                    y = rand.nextInt(0,10);
                    tamanhoReturnHere =   tamanho(matrixMapHere,  tamanhoEsc, x, y, vOh, varTipo, 0);
                    testePosit = tamanhoReturnHere[1];
                    if(testePosit==3){
                    }else{
                        aux2-=1;
                        varMe--;
                        varTipos[2]-=1;
                        percorrerMatriz(matrixMapHere, tamanhoEsc, x, y, vOh);
                    }
                    break;
                case 3:
                    varTipo =  'D';
                    tamanhoEsc = 1;
                    if (rand.nextInt(0,2) == 1) {
                        vOh = 'V';
                    } else {
                        vOh = 'H';
                    }
                    x = rand.nextInt(0,10);
                    y = rand.nextInt(0,10);
                    tamanhoReturnHere =    tamanho(matrixMapHere,  tamanhoEsc, x, y, vOh, varTipo, 0);
                    testePosit = tamanhoReturnHere[1];
                    if(testePosit==3){
                    }else{
                        varPe--;
                        varTipos[3]-=1;
                        aux2-=1;
                        percorrerMatriz(matrixMapHere, tamanhoEsc, x, y, vOh);
                    }
                    break;
            }
        }
        return matrixMapHere;
    }
    static String[][] aleatorio(String[][] matrixMap){
        matrixMap = positAleatoria(matrixMap);
        return matrixMap;
    }
    //---------------------------------------------------------------INTRODUCAO--------------------------------------------------------------//
    static int modo(){
        int num = 1;
        do{
            System.out.println("SELECIONE O MODO DE JOGO:");
            System.out.println("1 - JOGADOR vs JOGADOR");
            System.out.println("2 - JOGADOR VS COMPUTADOR");
            num = (int) ler.next().toUpperCase().charAt(0);
            num = num - 48;
        } while(num < 1 || num > 2);
        return num;
    }
    static String[][] jj(){
        j1();
        j2();
        return matrixMapUm;
    }
    static String[][] jc(){
        System.out.println("VEZ DO ROBO");
        String[][] matrixComputador = aleatorio(matrixMapDois);
        for(int aux=0; aux<50; aux++){
            System.out.println("\n");
        }
        return matrixComputador;
    }
    static String[][] j1(){
        System.out.println("\nVEZ DO JOGADOR 1!");
        matrixMapUm = iniciar(matrixMapUm);
        percorrerMatriz(matrixMapUm, 10, 10, 10, 'a');
        int num = 1;
        do{
            System.out.println("1 - ESCOLHER MANUALMENTE");
            System.out.println("2 - ESCOLHER AUTOMATICAMENTE");
            num = (int) ler.next().toUpperCase().charAt(0);
            num = num - 48;
        } while(num < 1 || num > 2);
        if(num == 1){
            printar(matrixMapUm);
            matrixMapUm = pedir(matrixMapUm);
        }
        else{
            matrixMapUm = aleatorio(matrixMapUm);
            for(int aux=0; aux<50; aux++){
                System.out.println("\n");
            }
            printar(matrixMapUm);
        }
        return matrixMapUm;
    }
    static String[][] j2(){
        System.out.println("\nVEZ DO JOGADOR 2!");
        matrixMapDois = iniciar(matrixMapDois);
        percorrerMatriz(matrixMapDois, 10, 10, 10, 'a');
        System.out.println("1 - ESCOLHER MANUALMENTE");
        System.out.println("2 - ESCOLHER AUTOMATICAMENTE");
        int sel = 0;
        while(sel != 1 && sel != 2 ) {
            sel = (int) ler.next().toUpperCase().charAt(0);
            sel = sel - 48;
        }
        if(sel == 1){
            printar(matrixMapDois);
            matrixMapDois = pedir(matrixMapDois);
        }
        else{
            matrixMapDois = aleatorio(matrixMapDois);
            for(int aux=0; aux<50; aux++){
                System.out.println("\n");
            }
            printar(matrixMapDois);
        }
        return matrixMapDois;
    }
    //-----------------------------------------------------------------ATAQUE----------------------------------------------------------------------//
    static int ataque(String[][] matrixMap, int jogador, int contBar){
        int cabecaX = 9;
        int cabecaY = 9;
        System.out.println("MAPA DO ADIVERSÁRIO:");;
        if(jogador == 1){
            printar(getMatrixMapDoisAtacada);
        }
        else{
            printar(getMatrixMapUmAtacada);
        }
        System.out.println("\nVEZ DO JOGADOR " + jogador + "!");
        do {
            System.out.println("\nESCOLHA UMA LINHA PARA ATACAR");
            cabecaX = (int) ler.next().toUpperCase().charAt(0);
            cabecaX = cabecaX - 65;
        }while(cabecaX <0 || cabecaX>9);
        do{
            System.out.println("\nESCOLHA UMA COLUNA PARA ATACAR");
            cabecaY = (int) ler.next().toUpperCase().charAt(0);
            cabecaY = cabecaY - 48;
        }while(cabecaY < 0 || cabecaY>9);
        contBar = atacando(matrixMap, 1, cabecaX, cabecaY, 'B', contBar, jogador);
        return contBar;
    }
    static int atacando(String[][]matrixMap,int tamanhoEscHere,int cabecaXHere, int cabecaYHere, char direcaoHere, int contBar, int jogador){
        if(direcaoHere == 'B'){
            if(matrixMap[cabecaXHere][cabecaYHere] == "🌊"){
                if(tamanhoEscHere != 9) {
                    System.out.println("\nVOCÊ ERROU UMA BOMBA!");
                }
                else{
                    System.out.println("\nO ROBÔ ERROU UMA BOMBA");
                }
                if(jogador == 1){
                    getMatrixMapDoisAtacada[cabecaXHere][cabecaYHere] = "❌";
                    printar(getMatrixMapDoisAtacada);
                }
                else{
                    getMatrixMapUmAtacada[cabecaXHere][cabecaYHere] = "❌";
                    printar(getMatrixMapUmAtacada);
                }
            }
            else if (matrixMap[cabecaXHere][cabecaYHere] == "⚓" ) {
                if(tamanhoEscHere != 9) {
                    System.out.println("\nVOCÊ ACERTOU UMA BOMBA!");
                }
                else{
                    System.out.println("\nO ROBÔ ACERTOU UMA BOMBA");
                }
                contBar--;
                if(jogador == 1){
                    getMatrixMapDoisAtacada[cabecaXHere][cabecaYHere] = "🎇";
                    printar(getMatrixMapDoisAtacada);
                }
                else{
                    getMatrixMapUmAtacada[cabecaXHere][cabecaYHere] = "🎇";
                    printar(getMatrixMapUmAtacada);
                }
            }
        }
        if (matrixMap[cabecaXHere][cabecaYHere] == "🎲" && direcaoHere == 'B' ){
            System.out.println("\nVOCÊ JA TENTOU AI! MAIS ATENÇÃO NA PRÓXIMA VEZ\n");
        }
        matrixMap[cabecaXHere][cabecaYHere] = "🎲";
        System.out.println("\nDIGITE QUALQUER CARACTERES PARA CONTINUAR");
        int descarte = ler.next().charAt(0);
        return contBar;
    }
    static int testeBotAcerto = 0, aON, xGlobal =0, yGlobal =0,auxGlobal = 5,contBarAnt = 20, testeAcertoAgora = 0,auxGlobalTeste = 1,consecutivo = 0,auxTodasPosicoes = 0,direcaoAcerto = -1;
    static boolean testeDentro = true;
    static int[] consecutivdade = new int[2];
    static String[] todasPosicoes= new String[101];
    static int[] testarRepetidas()
    {
        boolean testeString = false;
        int[] xEy = new int[2];
        while (testeString != true)
        {
            int auxTesteTodasPosicoes=0;
            int aux4=0;
            String xS;
            String yS;
            String junto;
            todasPosicoes[0]="111";
            xGlobal = rand.nextInt(0, 10);
            yGlobal = rand.nextInt(0, 10);
            xS = String.valueOf(xGlobal);
            yS = String.valueOf(yGlobal);
            junto = xS + yS;
            for (int e = 0; e < todasPosicoes.length && testeString != true; e++)
            {
                if (todasPosicoes[e] != null)
                {
                    if (todasPosicoes[e].equals(junto)) {
                        auxTesteTodasPosicoes++;
                    }
                }
                else
                {
                    if (auxTesteTodasPosicoes == 0) {
                        auxTodasPosicoes++;
                        todasPosicoes[auxTodasPosicoes] = junto;
                        xEy[0] = xGlobal;
                        xEy[1] = yGlobal;
                        testeString = true;
                    }
                }
            }
        }
        return xEy;
    };
    static int ataqueBot(String[][] matrixMap, int jogador, int contBar)
    {
        do {
            int tentiva = 0;
            for (int e = 0; e <= todasPosicoes.length; e++) {
                if (todasPosicoes[e] == null) {
                    e = 105;
                }
            }
            if (contBarAnt > contBar) {
                consecutivdade[0] = consecutivdade[1];
                consecutivdade[1] = contBar;
                if (consecutivdade[0] == consecutivdade[1]) {
                    consecutivo = 1;
                }
                testeDentro = false;
                testeAcertoAgora = 1;
                testeBotAcerto = 1;
                auxGlobal = 1;
            } else {
                if (auxGlobal >= 5) {
                    testeBotAcerto = 0;
                    int[] xEyHere = new int[2];
                    xEyHere = testarRepetidas();
                    xGlobal = xEyHere[0];
                    yGlobal = xEyHere[1];
                } else {
                    consecutivo = 0;
                    testeAcertoAgora = 0;
                    testeDentro = false;
                    testeBotAcerto = 1;
                }
            }
            while (!testeDentro) {
                if (testeBotAcerto == 1) {
                    switch (auxGlobal) {
                        case 1:
                            if (consecutivo == 0) {
                                if (testeAcertoAgora == 1) {
                                    if (xGlobal != 0) {
                                        testeBotAcerto = 2;
                                        direcaoAcerto = -1;
                                    }
                                }
                                auxGlobalTeste = 1;
                                testeBotAcerto = 2;
                            } else {
                                auxGlobal = 5;
                                testeBotAcerto = 2;
                            }
                            break;
                        case 2:
                            if (consecutivo == 0) {
                                if (testeAcertoAgora == 0 && auxGlobalTeste == 1) {
                                    if (xGlobal != 9) {
                                        xGlobal++;
                                        testeBotAcerto = 2;
                                        direcaoAcerto = +1;
                                    }
                                    auxGlobalTeste = 2;
                                    testeBotAcerto = 2;
                                }
                            } else {
                                auxGlobal = 5;
                                testeBotAcerto = 2;
                            }
                            break;
                        case 3:
                            if (consecutivo == 0) {
                                if (testeAcertoAgora == 0) {
                                    if (xGlobal != 0) {
                                        xGlobal--;
                                    }
                                    if (yGlobal != 0) {
                                        testeBotAcerto = 2;
                                        direcaoAcerto = -1;
                                    }
                                }
                                auxGlobalTeste = 3;
                                testeBotAcerto = 2;
                            } else {
                                auxGlobal = 5;
                                testeBotAcerto = 2;
                            }
                            break;
                        case 4:
                            if (consecutivo == 0) {
                                if (testeAcertoAgora == 0 && auxGlobalTeste == 3) {
                                    if (yGlobal != 0) {
                                        yGlobal++;
                                    }
                                    if (yGlobal != 9) {
                                        testeBotAcerto = 2;
                                        direcaoAcerto = +1;
                                    } else {
                                        yGlobal--;
                                    }
                                }
                                testeBotAcerto = 2;
                                auxGlobalTeste = 4;
                            } else {
                                auxGlobal = 5;
                                testeBotAcerto = 2;
                            }
                            break;
                        default:
                            testeBotAcerto = 2;
                    }
                }
                if (testeBotAcerto == 2) {
                    if (auxGlobalTeste >= 1 && auxGlobalTeste <= 2) {
                        int auxTesteTentativa = 0;
                        int e = 0;
                        boolean nullnum = false;
                        xGlobal += direcaoAcerto;
                        tentiva = xGlobal;
                        while (nullnum == false) {
                            for (e = 0; e < todasPosicoes.length; e++) {
                                if (todasPosicoes[e] != null) {
                                    if (todasPosicoes[e].equals(String.valueOf(tentiva))) {
                                        auxTesteTentativa++;
                                    }
                                } else {
                                    nullnum = true;
                                }
                            }
                        }
                        if (tentiva >= 0 && tentiva <= 9 && 0 == auxTesteTentativa) {
                            testeDentro = true;
                            testeBotAcerto = 1;
                            auxGlobal++;
                        } else {
                            int[] xEyHere = new int[2];
                            xEyHere = testarRepetidas();
                            xGlobal = xEyHere[0];
                            yGlobal = xEyHere[1];
                        }
                    } else if (auxGlobalTeste >= 3 && auxGlobalTeste <= 4) {
                        int auxTesteTentativa = 0;
                        int e = 0;
                        boolean nullnum = false;
                        yGlobal += direcaoAcerto;
                        tentiva = yGlobal;
                        while (nullnum == false) {
                            for (e = 0; e < todasPosicoes.length; e++) {
                                if (todasPosicoes[e] != null) {
                                    if (todasPosicoes[e].equals(String.valueOf(tentiva))) {
                                        auxTesteTentativa++;
                                    }
                                } else {
                                    nullnum = true;
                                }
                            }
                        }
                        if (tentiva >= 0 && tentiva <= 9 && 0 == auxTesteTentativa) {
                            testeDentro = true;
                            testeBotAcerto = 1;
                            auxGlobal++;
                        } else {
                            int[] xEyHere = new int[2];
                            xEyHere = testarRepetidas();
                            xGlobal = xEyHere[0];
                            yGlobal = xEyHere[1];
                        }
                    } else {
                        auxGlobal = 5;
                    }
                }
            }
            contBarAnt=contBar;
        }while(matrixMap[xGlobal][yGlobal] == "🎲");
        contBar = atacando(matrixMap, 9, xGlobal , yGlobal, 'B', contBar, jogador);
        return contBar;
    }
    //-------------------------------------------------------MAIN-------------------------------------------------------------//
    public static void main(String[] args)
    {
        iniciar(matrixMapDois);
        iniciar(getMatrixMapUmAtacada);
        iniciar(getMatrixMapDoisAtacada);
        int contBar1 = 20;
        int contBar2 = 20;
        int escolha = 0;
        escolha = modo();
        switch (escolha)
        {
            case 1:
                matrixMapUm = j1();
                System.out.println("\nDIGITE QUALQUER CARACTERES PARA CONTINUAR");
                int descarte = ler.next().charAt(0);
                for(int aux=0; aux<50; aux++){
                    System.out.println("\n");
                }
                matrixMapDois = j2();
                System.out.println("\nDIGITE QUALQUER CARACTERES PARA CONTINUAR");
                descarte = ler.next().charAt(0);
                for(int aux=0; aux<50; aux++){
                    System.out.println("\n");
                }
                while(contBar1 > 0 && contBar2 > 0 ){
                    System.out.println("\n\n\n\n\n");
                    contBar1 = ataque(matrixMapDois, 1, contBar1);
                    System.out.println("\n\n\n\n\n");
                    contBar2 = ataque(matrixMapUm, 2, contBar2);
                }
                if(contBar2 == 0 && contBar1>0 ) {
                    System.out.println("\n\n\n\n\n");
                    printar(getMatrixMapUmAtacada);
                    System.out.println("\n⭐ FIM DE JOGO! JOGADOR 2 GANHOU! ⭐");
                }
                else if(contBar1 == 0 && contBar2>0){
                    System.out.println("\n\n\n\n\n");
                    printar(getMatrixMapDoisAtacada);
                    System.out.println("\n⭐ FIM DE JOGO! JOGADOR 1 GANHOU! ⭐");
                }
                else{
                    System.out.println("\n⭐ FIM DE JOGO! EMPATE ⭐");
                }
                break;
            case 2:
                matrixMapUm = j1();
                System.out.println("DIGITE QUALQUER CARACTERES PARA CONTINUAR");
                descarte = ler.next().charAt(0);
                for(int aux=0; aux<50; aux++){
                    System.out.println("\n");
                }
                matrixMapDois = jc();
                while(contBar1 > 0 && contBar2 > 0 ){
                    System.out.println("\n\n\n\n\n");
                    contBar1 = ataque(matrixMapDois, 1, contBar1);
                    System.out.println("\n\n\n\n\n");
                    contBar2 = ataqueBot(matrixMapUm, 2, contBar2);
                }
                if(contBar2 == 0 && contBar1>0 ) {
                    System.out.println("\n\n\n\n\n");
                    printar(getMatrixMapUmAtacada);
                    System.out.println("\n⭐ FIM DE JOGO! COMPUTADOR GANHOU! ⭐");
                }
                else if(contBar1 == 0 && contBar2>0){
                    System.out.println("\n\n\n\n\n");
                    printar(getMatrixMapDoisAtacada);
                    System.out.println("\n⭐ FIM DE JOGO! JOGADOR 1 GANHOU! ⭐");
                }
                else{
                    System.out.println("\n ⭐ FIM DE JOGO! EMPATE ⭐");
                }
                break;
        }
        int pontoj1 = 20;
        int pontoj2 = 20;
        while(pontoj1>0){
        }
    }
}