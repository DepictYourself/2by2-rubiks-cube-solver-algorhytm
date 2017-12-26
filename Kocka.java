package rubik;


public class Kocka {
    
    //Kocka szinei
    private String szinek = "FZPKNS";
    //Forgatás tesztelésére
    private String proba = "WASD";
    private int x = 0;
    //Kocka oldalai
    private char a[][] = new char [2][2];      
    private char b[][] = new char [2][2];
    private char c[][] = new char [2][2];
    private char d[][] = new char [2][2];
    private char e[][] = new char [2][2];
    private char f[][] = new char [2][2];
    //Forgatáshoz segédváltozó
    private char temp[] = new char [3];
    //Forgatás számláló
    private int p = 0;
    
    //Kirakáshoz használt elágazások
    private String st = "";
    
    public Kocka(){
        
    }
    
    //Feltöltés
    public void getfeltoltes()
    {
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a[i].length; j++)
            {                    
                a[i][j] = szinek.charAt(0);                
                //a[i][j] = proba.charAt(x); //Tesztelés
                //x++;                       //Tesztelés
                b[i][j] = szinek.charAt(1);
                //b[i][j] = proba.charAt(x); //Tesztelés
                //x++;                       //Tesztelés
                c[i][j] = szinek.charAt(2);
                //c[i][j] = proba.charAt(x); //Tesztelés
                //x++;                       //Tesztelés
                d[i][j] = szinek.charAt(3);
                //d[i][j] = proba.charAt(x); //Tesztelés
                //x++;                       //Tesztelés
                e[i][j] = szinek.charAt(4);
                //e[i][j] = proba.charAt(x); //Tesztelés
                //x++;                       //Tesztelés
                f[i][j] = szinek.charAt(5);
                //f[i][j] = proba.charAt(x); //Tesztelés
                //x++;                       //Tesztelés
            }
        }
    }
    
    //Kiíratás
    @Override
    public String toString(){
        String kiiras = "        +-------+\n"
        +"        "+"| "+a[0][0]+"   "+a[0][1]+" | \n"
        +"        "+"| "+a[1][0]+"   "+a[1][1]+" | \n"
        +"+"+"-"+"-"+"-"+"-"+"-"+"-"+"-"+"+"+"-"+"-"+"-"+"-"+"-"+"-"+"-"+"+"+"-"+"-"+"-"+"-"+"-"+"-"+"-"+"+"+"-"+"-"+"-"+"-"+"-"+"-"+"-"+"+\n"
        +"| "+b[0][0]+"   "+b[0][1]+" | "+c[0][0]+"   "+c[0][1]+" | "+d[0][0]+"   "+d[0][1]+" | "+e[0][0]+"   "+e[0][1]+" | \n"
        +"| "+b[1][0]+"   "+b[1][1]+" | "+c[1][0]+"   "+c[1][1]+" | "+d[1][0]+"   "+d[1][1]+" | "+e[1][0]+"   "+e[1][1]+" | \n"
        +"+"+"-"+"-"+"-"+"-"+"-"+"-"+"-"+"+"+"-"+"-"+"-"+"-"+"-"+"-"+"-"+"+"+"-"+"-"+"-"+"-"+"-"+"-"+"-"+"+"+"-"+"-"+"-"+"-"+"-"+"-"+"-"+"+\n"
        +"        "+"| "+f[0][0]+"   "+f[0][1]+" | \n"
        +"        "+"| "+f[1][0]+"   "+f[1][1]+" | \n"
        +"        "+'+'+'-'+'-'+'-'+'-'+'-'+'-'+'-'+'+';
        
        return  kiiras;
    }

    public int getP() {
        return p;
    }
    
    public String getSt() {
        return "elágazások azonosítója: \n"
                +st.substring(0, 8)+"\n"+
                st.substring(8, 16)+"\n"+
                st.substring(16, 24)+"\n"+
                st.substring(24, 32)+"\n"+
                st.substring(32, 40)+"\n"+
                st.substring(40, 47);
    }
    
    //Forgatások
    public void forgTb(){//Teteje Balra
        temp[0] = c[0][0];
        temp[1] = c[0][1];
        temp[2] = a[1][1];
        c[0][0] = d[0][0];
        c[0][1] = d[0][1];
        a[1][1] = a[0][1];
        d[0][0] = e[0][0];
        d[0][1] = e[0][1];
        a[0][1] = a[0][0];
        e[0][0] = b[0][0];
        e[0][1] = b[0][1];
        a[0][0] = a[1][0];
        b[0][0] = temp[0];
        b[0][1] = temp[1];
        a[1][0] = temp[2];
        p++;
    }
    
    public void forgTj(){//Teteje Jobbra
        temp[0] = c[0][0];
        temp[1] = c[0][1];
        c[0][0] = b[0][0];
        c[0][1] = b[0][1];
        b[0][0] = e[0][0];
        b[0][1] = e[0][1];
        e[0][0] = d[0][0];
        e[0][1] = d[0][1];
        d[0][0] = temp[0];
        d[0][1] = temp[1];
        temp[2] = a[1][1];
        a[1][1] = a[1][0];
        a[1][0] = a[0][0];
        a[0][0] = a[0][1];
        a[0][1] = temp[2];
        p++;
    }
    
    public void forgAb(){//Alsó oldal Balra
        temp[0] = c[1][0];
        temp[1] = c[1][1];
        c[1][0] = d[1][0];
        c[1][1] = d[1][1];
        d[1][0] = e[1][0];
        d[1][1] = e[1][1];
        e[1][0] = b[1][0];
        e[1][1] = b[1][1];
        b[1][0] = temp[0];
        b[1][1] = temp[1];
        temp[2] = f[0][0];
        f[0][0] = f[0][1];
        f[0][1] = f[1][1];
        f[1][1] = f[1][0];
        f[1][0] = temp[2];
        p++;
    }
    
    public void forgAj(){//Alsó oldal Jobbra
        temp[0] = c[1][0];
        temp[1] = c[1][1];
        c[1][0] = b[1][0];
        c[1][1] = b[1][1];
        b[1][0] = e[1][0];
        b[1][1] = e[1][1];
        e[1][0] = d[1][0];
        e[1][1] = d[1][1];
        d[1][0] = temp[0];
        d[1][1] = temp[1];
        temp[2] = f[0][0];
        f[0][0] = f[1][0];
        f[1][0] = f[1][1];
        f[1][1] = f[0][1];
        f[0][1] = temp[2];
        p++;
    }
    
    public void forgJf(){//Jobboldal Fel
        temp[0] = c[0][1];
        temp[1] = c[1][1];
        c[0][1] = f[0][1];
        c[1][1] = f[1][1];
        f[0][1] = e[1][0];
        f[1][1] = e[0][0];
        e[1][0] = a[0][1];
        e[0][0] = a[1][1];
        a[0][1] = temp[0];
        a[1][1] = temp[1];
        temp[2] = d[0][0];
        d[0][0] = d[1][0];
        d[1][0] = d[1][1];
        d[1][1] = d[0][1];
        d[0][1] = temp[2];
        p++;
    }
    
    public void forgJl(){//Jobboldal Le
        temp[0] = c[0][1];
        temp[1] = c[1][1];
        c[0][1] = a[0][1];
        c[1][1] = a[1][1];
        a[0][1] = e[1][0];
        a[1][1] = e[0][0];
        e[1][0] = f[0][1];        
        e[0][0] = f[1][1];
        f[0][1] = temp[0];
        f[1][1] = temp[1];
        temp[2] = d[0][1];
        d[0][1] = d[1][1];
        d[1][1] = d[1][0];
        d[1][0] = d[0][0];
        d[0][0] = temp[2];
        p++;
    }
    
    public void forgBf(){//Baloldal Fel
        temp[0] = c[0][0];
        temp[1] = c[1][0];
        c[0][0] = f[0][0];
        c[1][0] = f[1][0];
        f[0][0] = e[1][1];
        f[1][0] = e[0][1];
        e[1][1] = a[0][0];
        e[0][1] = a[1][0];
        a[0][0] = temp[0];
        a[1][0] = temp[1];
        temp[2] = b[0][1];
        b[0][1] = b[1][1];
        b[1][1] = b[1][0];
        b[1][0] = b[0][0];
        b[0][0] = temp[2];
        p++;
    }
    
    public void forgBl(){//Baloldal Le
        temp[0] = c[0][0];
        temp[1] = c[1][0];
        c[0][0] = a[0][0];
        c[1][0] = a[1][0];
        a[0][0] = e[1][1];
        a[1][0] = e[0][1];
        e[1][1] = f[0][0];
        e[0][1] = f[1][0];
        f[0][0] = temp[0];
        f[1][0] = temp[1];
        temp[2] = b[0][0];
        b[0][0] = b[1][0];
        b[1][0] = b[1][1];
        b[1][1] = b[0][1];
        b[0][1] = temp[2];
        p++;
    }
    
    public void forgEb(){//Előlap Balra
        temp[0] = b[0][1];
        temp[1] = b[1][1];
        b[0][1] = a[1][1];
        b[1][1] = a[1][0];
        a[1][1] = d[1][0];
        a[1][0] = d[0][0];
        d[1][0] = f[0][0];
        d[0][0] = f[0][1];
        f[0][0] = temp[0];
        f[0][1] = temp[1];
        temp[2] = c[0][0];
        c[0][0] = c[0][1];
        c[0][1] = c[1][1];
        c[1][1] = c[1][0];        
        c[1][0] = temp[2];
        p++;
    }
    
    public void forgEj(){//Előlap Jobbra
        temp[0] = b[0][1];
        temp[1] = b[1][1];
        b[0][1] = f[0][0];
        b[1][1] = f[0][1];
        f[0][0] = d[1][0];
        f[0][1] = d[0][0];
        d[1][0] = a[1][1];
        d[0][0] = a[1][0];
        a[1][1] = temp[0];
        a[1][0] = temp[1];
        temp[2] = c[0][0];
        c[0][0] = c[1][0];
        c[1][0] = c[1][1];
        c[1][1] = c[0][1];
        c[0][1] = temp[2];
        p++;
        
    }
    
    public void forgHb(){//Hátsólap Balra
        temp[0] = b[0][0];
        temp[1] = b[1][0];
        b[0][0] = a[0][1];
        b[1][0] = a[0][0];
        a[0][1] = d[1][1];
        a[0][0] = d[0][1];
        d[1][1] = f[1][0];
        d[0][1] = f[1][1];
        f[1][0] = temp[0];
        f[1][1] = temp[1];
        temp[2] = e[0][0];
        e[0][0] = e[1][0];
        e[1][0] = e[1][1];
        e[1][1] = e[0][1];
        e[0][1] = temp[2];
        p++;
    }
    
    public void forgHj(){//Hátsólap Jobbra
        temp[0] = b[0][0];
        temp[1] = b[1][0];
        b[0][0] = f[1][0];
        b[1][0] = f[1][1];
        f[1][0] = d[1][1];
        f[1][1] = d[0][1];
        d[1][1] = a[0][1];
        d[0][1] = a[0][0];
        a[0][1] = temp[0];
        a[0][0] = temp[1];
        temp[2] = e[0][0];
        e[0][0] = e[0][1];
        e[0][1] = e[1][1];
        e[1][1] = e[1][0];        
        e[1][0] = temp[2];
        p++;
    }
    
    
    public void keveres(){
        for(int i = 0; i < 6; i++){
            
            byte y = (byte)(Math.random()*6);
            System.out.println(y);
            if(y == 0){
                forgAj();
                forgJf();
                forgBl();
            }else if(y == 1){
                forgTj();
                forgBl();
                forgTb();
            }else if(y == 2){
                forgAb();
                forgJl();
                forgTb();
            }else if(y == 3){
                forgTb();
                forgBf();
                forgAj();
            }else if(y == 4){
                forgHb();
                forgEj();
                forgBf();
            }else{
                forgHj();
                forgEb();
                forgTj();
            }
        }
    }
    
    public void kirakas(){
        /*
        * A kocka kirakásánál egy úgynevezett "Layer-by-layer" tehát soronkénti kirakást alkalmaz az algoritmus
        * 1. A fehér színt rakja ki a felső oldalon úgy, hogy az kocka felső sorában oldalt is helyesek legyenenek a színek.
        *   4 db if-es szerkezet 24 + 21 + 18 + 15 = 78 elágazás
        *   
        * 2. Sárga oldal kirakása(Ortega metódus algoritmusait használva)
        *   1 db 28 ágú elágazás
        *   
        * 3. A kocka alsó sorának rendezése.
        *   1 db 24 ágú elágazás
        *
        *   130 elágazás
        *   1200 sor
        */
        
        //1. Fehér oldal kirakás
        
        //1.1 Fehér,Piros,Kék kocka helyre rakása
        
        //1.1.1 / 4-es számú kocka variációi
        if( a[1][1] == 'F' && c[0][1] == 'P' && d[0][0] == 'K'){
            st = st.concat("#1.1.1.1");
        }else if (a[1][1]=='P' && c[0][1]=='K' && d[0][0]=='F'){
            forgJl();
            forgEb();
            st = st.concat("#1.1.1.2");
        }else if (a[1][1]=='K' && c[0][1]=='F' && d[0][0]=='P'){
            forgTb();
            forgEj();
            st = st.concat("#1.1.1.3");
            
        //1.1.2 / 2-es kocka variációi
        }else if (a[0][1]=='F' && e[0][0]=='K' && d[0][1]=='P'){
            forgTb();
            st = st.concat("#1.1.2.1");
        }else if (a[0][1]=='P' && e[0][0]=='F' && d[0][1]=='K'){
            forgJl();
            st = st.concat("#1.1.2.2");
        }else if (a[0][1]=='K' && e[0][0]=='P' && d[0][1]=='F'){
            forgTb();
            forgTb();
            forgEj();
            st = st.concat("#1.1.2.3");
            
        //1.1.3 / 3-as kocka variációi
        }else if(a[1][0]=='F' && b[0][1]=='P' && c[0][0]=='K'){
            forgTj();
            st = st.concat("#1.1.3.1");
        }else if(a[1][0]=='K' && b[0][1]=='F' && c[0][0]=='P'){
            forgEj();
            st = st.concat("#1.1.3.2");
        }else if(a[1][0]=='P' && b[0][1]=='K' && c[0][0]=='F'){
            forgTj();
            forgTj();
            forgJl();
            st = st.concat("#1.1.3.3");
            
        //1.1.4 / 1-es kocka variációk
        }else if(a[0][0]=='F' && e[0][1]=='P' && b[0][0]=='K'){
            forgTj();
            forgTj();
            st = st.concat("#1.1.4.1");
        }else if(a[0][0]=='P' && e[0][1]=='K' && b[0][0]=='F'){
            forgHj();
            forgTb();
            st = st.concat("#1.1.4.2");
        }else if(a[0][0]=='K' && e[0][1]=='F' && b[0][0]=='P'){
            forgBl();
            forgTj();
            st = st.concat("#1.1.4.3");
        
        //1.1.5 / 5-ös kocka variációi
        }else if( e[1][0] == 'F' && d[1][1] == 'P' && f[1][1] == 'K'){
            forgAb();
            forgEb();
            st = st.concat("#1.1.5.1");
        }else if( e[1][0] == 'P' && d[1][1] == 'K' && f[1][1] == 'F'){
            forgJf();
            forgJf();
            st = st.concat("#1.1.5.2");
        }else if( e[1][0] == 'K' && d[1][1] == 'F' && f[1][1] == 'P'){
            forgAb();
            forgJf();
            st = st.concat("#1.1.5.3");
            
        //1.1.6 / 6-os kocka variációi
        }else if( e[1][1] == 'F' && b[1][0] == 'K' && f[1][0] == 'P'){
            forgAj();
            forgAj();
            forgJf();
            st = st.concat("#1.1.6.1");
        }else if( e[1][1] == 'P' && b[1][0] == 'F' && f[1][0] == 'K'){
            forgHj();
            forgTj();
            forgTj();
            st = st.concat("#1.1.6.2");
        }else if( e[1][1] == 'K' && b[1][0] == 'P' && f[1][0] == 'F'){
            forgBf();
            forgBf();
            forgTj();
            st = st.concat("#1.1.6.3");
            
        //1.1.7 / 7-es kocka variációi
        }else if( c[1][1] == 'F' && d[1][0] == 'K' && f[0][1] == 'P'){
            forgJf();
            st = st.concat("#1.1.7.1");
        }else if( c[1][1] == 'P' && d[1][0] == 'F' && f[0][1] == 'K'){
            forgEb();
            st = st.concat("#1.1.7.2");
        }else if( c[1][1] == 'K' && d[1][0] == 'P' && f[0][1] == 'F'){
            forgEj();
            forgAj();
            forgJf();
            st = st.concat("#1.1.7.3");
            
        //1.1.8 / 8-as kocka variációi
        }else if( c[1][0] == 'F' && f[0][0] == 'K' && b[1][1] == 'P'){
            forgAj();
            forgEb();
            st = st.concat("#1.1.8.1");
        }else if( c[1][0] == 'K' && f[0][0] == 'P' && b[1][1] == 'F'){
            forgAj();
            forgJf();
            st = st.concat("#1.1.8.2");
        }else if( c[1][0] == 'P' && f[0][0] == 'F' && b[1][1] == 'K'){
            forgEj();
            forgEj();
            st = st.concat("#1.1.8.3");
        }            
        
        //1.2 Fehér, Piros, Zöld kocka helyre rakása
		
	//1.2.1 / 3-as kocka  
        if(a[1][0]=='F' && b[0][1]=='Z' && c[0][0]=='P'){
            
            st = st.concat("#1.2.3.1");
	}else if(a[1][0]=='Z' && b[0][1]=='P' && c[0][0]=='F'){
            forgBf();
            forgBf();
            forgEb();
            forgAj();
            forgEj();
            st = st.concat("#1.2.3.2");
	}else if(a[1][0]=='P' && b[0][1]=='F' && c[0][0]=='Z'){
            forgBl();
            forgAb();
            forgEb();
            forgAj();
            forgEj();
            st = st.concat("#1.2.3.3");
	}
		
	//1.2.2 / 1-es kocka
	else if(a[0][0]=='F' && e[0][1]=='Z' && b[0][0]=='P'){
            forgHb();
            forgAj();
            forgAj();
            forgHj();
            forgBl();
            forgAb();
            forgBf();
            st = st.concat("#1.2.1.1");
	}else if(a[0][0]=='P' && e[0][1]=='F' && b[0][0]=='Z'){
            forgHb();
            forgEb();
            forgAj();
            forgEj();
            forgHj();
            st = st.concat("#1.2.1.2");
	}else if(a[0][0]=='Z' && e[0][1]=='P' && b[0][0]=='F'){
            forgBf();
            forgAj();
            forgAj();
            forgBl();
            forgAb();
            forgBf();
            st = st.concat("#1.2.1.3");
        }
        
        //1.2.2 / 2-es kocka variációk
        else if(a[0][1]=='F' && e[0][0]=='P' && d[0][1]=='Z'){
            forgHj();
            forgAj();
            forgEb();
            forgAj();
            forgEj();
            st = st.concat("#1.2.2.1");
        }else if(a[0][1]=='P' && e[0][0]=='Z' && d[0][1]=='F'){
            forgHb();
            forgHb();
            forgAj();
            forgAj();
            forgBl();
            forgAb();
            forgBf();
            st = st.concat("#1.2.2.2");
        }else if(a[0][1]=='Z' && e[0][0]=='F' && d[0][1]=='P'){
            forgHj();
            forgAb();
            forgBl();
            forgAb();
            forgBf();
            st = st.concat("#1.2.2.3");
        }
        
        //1.2.5 / 5-ös kocka variációk
        else if(e[1][0] == 'F' && d[1][1] == 'Z' && f[1][1] == 'P'){            
            forgAb();
            forgAb();
            forgBf();
            st = st.concat("#1.2.5.1");
        }else if(e[1][0] == 'Z' && d[1][1] == 'P' && f[1][1] == 'F'){
            forgHj();
            forgAj();
            forgAj();
            forgBl();
            forgAb();
            forgBf();
            st = st.concat("#1.2.5.2");
        }else if(e[1][0] == 'P' && d[1][1] == 'F' && f[1][1] == 'Z'){
            forgAj();
            forgEb();
            forgAj();
            forgEj();
            st = st.concat("#1.2.5.3");
        }
        
        //1.2.6 / 6-os kocka variációi
        else if(e[1][1] == 'F' && b[1][0] == 'P' && f[1][0] == 'Z'){
            forgEb();
            forgAj();
            forgEj();
            st = st.concat("#1.2.6.1");
        }else if(e[1][1] == 'Z' && b[1][0] == 'F' && f[1][0] == 'P'){
            forgAj();
            forgAj();
            forgBl();
            forgAb();
            forgBf();
            st = st.concat("#1.2.6.2");          
        }else if(e[1][1] == 'P' && b[1][0] == 'Z' && f[1][0] == 'F'){
            forgBf();
            forgBf();
            st = st.concat("#1.2.6.3");
        }
        
        //1.2.7 / 7-es kocka variációi
        else if(c[1][1]=='Z' && d[1][0]=='F' && f[0][1]=='P'){
            forgBl();
            forgAb();
            forgBf();
            st = st.concat("#1.2.7.1");
        }else if(c[1][1]=='P' && d[1][0]=='Z' && f[0][1]=='F'){
            forgAb();
            forgAb();
            forgBf();
            forgBf();
            st = st.concat("#1.2.7.2");
        }else if(c[1][1]=='F' && d[1][0]=='P' && f[0][1]=='Z'){
            forgAb();
            forgAb();
            forgEb();
            forgAj();
            forgEj();
            st = st.concat("#1.2.7.3");
        }
        
        //1.2.8 / 8-as kocka variációi
        else if(b[1][1]=='Z' && c[1][0]=='F' && f[0][0]=='P'){
            forgBf();
            st = st.concat("#1.2.8.1");
        }else if(b[1][1]=='F' && c[1][0]=='P' && f[0][0]=='Z'){
            forgAb();
            forgEb();
            forgAj();
            forgEj();
            st = st.concat("#1.2.8.2");           
        }else if(b[1][1]=='P' && c[1][0]=='Z' && f[0][0]=='F'){
            forgAb();
            forgBf();
            forgBf();
            st = st.concat("#1.2.8.3");
        }
        
        // 1.3 Fehér, Zöld, Narancs kocka kirakása
        
        //1.3.1 / 1-es kocka variációi
        if(a[0][0]=='F' && e[0][1]=='N' && b[0][0]=='Z'){
            st = st.concat("#1.3.1.1");
        }else if(a[0][0]=='N' && e[0][1]=='Z' && b[0][0]=='F'){
            forgBf();
            forgAb();
            forgBl();
            forgAj();
            forgHj();
            st = st.concat("#1.3.1.2");
        }else if(a[0][0]=='Z' && e[0][1]=='F' && b[0][0]=='N'){
            forgHb();
            forgAb();
            forgBf();
            forgAj();
            forgBl();
            st = st.concat("#1.3.1.3");
        }
        
        //1.3.2 / 2-es kocka variációi
        else if(a[0][1]=='Z' && e[0][0]=='N' && d[0][1]=='F'){
            forgHb();
            st = st.concat("#1.3.2.1");
        }else if(a[0][1]=='N' && e[0][0]=='F' && d[0][1]=='Z'){
            forgHj();
            forgAj();
            forgAj();
            forgHb();
            forgAb();
            forgHj();
            st = st.concat("#1.3.2.2");
        }else if(a[0][1]=='F' && e[0][0]=='Z' && d[0][1]=='N'){
            forgHj();
            forgBf();
            forgAj();
            forgBl();
            st = st.concat("#1.3.2.3");
        }
        
        //1.3.5 / 5-ös kocka variációi
        else if(e[1][0]=='N' && d[1][1]=='Z' && f[1][1]=='F'){
            forgHb();
            forgHb();
            st = st.concat("#1.3.5.1");
        }else if(e[1][0]=='Z' && d[1][1]=='F' && f[1][1]=='N'){
            forgBf();
            forgAj();
            forgBl();
            st = st.concat("#1.3.5.2");
        }else if(e[1][0]=='F' && d[1][1]=='N' && f[1][1]=='Z'){
            forgAj();
            forgHj();
            st = st.concat("#1.3.5.3");
        }
        
        //1.3.6 / 6-os kocka variációi
        else if(e[1][1]=='F' && b[1][0]=='Z' && f[1][0]=='N'){
            forgAb();
            forgBf();
            forgAj();
            forgBl();
            st = st.concat("#1.3.6.1");
        }else if(e[1][1]=='N' && b[1][0]=='F' && f[1][0]=='Z'){
            forgHj();
            st = st.concat("#1.3.6.2");
        }else if(e[1][1]=='Z' && b[1][0]=='N' && f[1][0]=='F'){
            forgAb();
            forgHb();
            forgHb();
            st = st.concat("#1.3.6.3");
        }
        
        //1.3.7 / 7-es kocka variációk
        else if(c[1][1]=='F' && d[1][0]=='Z' && f[0][1]=='N'){
            forgAj();
            forgBf();
            forgAj();
            forgBl();
            st = st.concat("#1.3.7.1");
        }else if(c[1][1]=='Z' && d[1][0]=='N' && f[0][1]=='F'){
            forgAj();
            forgHb();
            forgHb();
            st = st.concat("#1.3.7.2");
        }else if(c[1][1]=='N' && d[1][0]=='F' && f[0][1]=='Z'){
            forgAb();
            forgAb();
            forgHj();
            st = st.concat("#1.3.7.3");
        }
        
        //1.3.8 / 8-as kocka variációk
        else if(b[1][1]=='N' && c[1][0]=='F' && f[0][0]=='Z'){
            forgAb();
            forgHj();
            st = st.concat("#1.3.8.1");
        }else if(b[1][1]=='Z' && c[1][0]=='N' && f[0][0]=='F'){
            forgAb();
            forgHb();
            forgBf();
            forgAj();
            forgBl();
            st = st.concat("#1.3.8.2");
        }else if(b[1][1]=='F' && c[1][0]=='Z' && f[0][0]=='N'){
            forgAb();
            forgAb();
            forgBf();
            forgAj();
            forgBl();
            st = st.concat("#1.3.8.3");
        }
        
        //1.4 Fehér, Narancs, Kék kocka helyre rakása
        
        //1.4.1 / 2-es kocka variációk
        
        if(a[0][1]=='N' && e[0][0]=='K' && d[0][1]=='F'){
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgAb();
            forgHj();
            forgAj();
            forgHb();
            st = st.concat("#1.4.1.2");
        }else if(a[0][1]=='K' && e[0][0]=='F' && d[0][1]=='N'){
            forgHj();
            forgAb();
            forgHb();
            forgAj();
            forgAj();
            forgJf();
            forgAb();
            forgJl();
            st = st.concat("#1.4.1.3");
        }
        
        //1.4.2 / 5-ös kocka variációk
        else if(e[1][0]=='F' && d[1][1]=='K' && f[1][1]=='N'){
            forgAj();
            forgJf();
            forgAb();
            forgJl();
            st = st.concat("#1.4.5.1");
        }else if(e[1][0]=='N' && d[1][1]=='F' && f[1][1]=='K'){
            forgAb();
            forgHj();
            forgAj();
            forgHb();
            st = st.concat("#1.4.5.2");
        }else if(e[1][0]=='K' && d[1][1]=='N' && f[1][1]=='F'){
            forgJf();
            forgAb();
            forgJl();
            forgAj();
            forgHj();
            forgAj();
            forgHb();
            st = st.concat("#1.4.5.3");
        }
        
        //1.4.3 / 6-os kocka variációk
        else if(e[1][1]=='K' && b[1][0]=='F' && f[1][0]=='N'){
            forgJf();
            forgAb();
            forgJl();
            st = st.concat("#1.4.6.1");
        }else if(e[1][1]=='F' && b[1][0]=='N' && f[1][0]=='K'){
            forgAb();
            forgAb();
            forgHj();
            forgAj();
            forgHb();
            st = st.concat("#1.4.6.2");
        }else if(e[1][1]=='N' && b[1][0]=='K' && f[1][0]=='F'){
            forgAb();
            forgJf();
            forgAb();
            forgJl();
            forgHj();
            forgAj();
            forgAj();
            forgHb();            
            st = st.concat("#1.4.6.3");
        }
        
        //1.4.4 / 7-es kocka variációk
        else if(c[1][1]=='F' && d[1][0]=='N' && f[0][1]=='K'){
            forgHj();
            forgAj();
            forgHb();
            st = st.concat("#1.4.7.1");
        }else if(c[1][1]=='N' && d[1][0]=='K' && f[0][1]=='F'){
            forgAj();
            forgHj();
            forgAj();
            forgHb();
            forgJf();
            forgAj();
            forgAj();
            forgJl();
            st = st.concat("#1.4.7.2");
        }else if(c[1][1]=='K' && d[1][0]=='F' && f[0][1]=='N'){
            forgAj();
            forgAj();
            forgJf();
            forgAb();
            forgJl();
            st = st.concat("#1.4.7.3");
        }
        
        //1.4.8 / 8-as kocka variációk
        else if(c[1][0]=='N' && b[1][1]=='F' && f[0][0]=='K'){
            forgAj();
            forgHj();
            forgAj();
            forgHb();
            st = st.concat("#1.4.8.1");
        }else if(c[1][0]=='K' && b[1][1]=='N' && f[0][0]=='F'){
            forgAj();
            forgAj();
            forgHj();
            forgAb();
            forgAb();
            forgHb();
            forgAj();
            forgAj();
            forgJf();
            forgAb();
            forgJl();
            st = st.concat("#1.4.8.2");
        }else if(c[1][0]=='F' && b[1][1]=='K' && f[0][0]=='N'){
            forgJf();
            forgAb();
            forgAb();
            forgJl();
            st = st.concat("#1.4.8.3");
        }
        
        //2. Sárga oldal kirakás
        
        //2.1 / 1. eset
        
        if(c[1][0]=='S' && c[1][1]=='S' && e[1][0]=='S' && e[1][1]=='S'){
            forgJf();
            forgJf();
            forgAj();
            forgAj();
            forgJf();
            forgAj();
            forgAj();
            forgJf();
            forgJf();
            st = st.concat("#2.1.1.2");
        }else if(b[1][0]=='S' && b[1][1]=='S' && d[1][0]=='S' && d[1][1]=='S'){
            forgAj();
            forgJf();
            forgJf();
            forgAj();
            forgAj();
            forgJf();
            forgAj();
            forgAj();
            forgJf();
            forgJf();
            st = st.concat("#2.1.1.3");
        }
        
        //2.2 / 2. eset
        else if(b[1][1]=='S' && b[1][0]=='S' && c[1][1]=='S' && e[1][0]=='S'){
            forgHb();
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgHj();
            st = st.concat("#2.2.2.1");
        }else if(c[1][0]=='S' && c[1][1]=='S' && b[1][0]=='S' && d[1][1]=='S'){
            forgAb();
            forgHb();
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgHj();
            st = st.concat("#2.2.2.2");
        }else if(c[1][0]=='S' && d[1][0]=='S' && d[1][1]=='S' && e[1][1]=='S'){
            forgAb();
            forgAb();
            forgHb();
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgHj();
            st = st.concat("#2.2.2.3");
        }else if(b[1][1]=='S' && d[1][0]=='S' && e[1][1]=='S' && e[1][0]=='S'){
            forgAj();
            forgHb();
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgHj();
            st = st.concat("#2.2.2.4");
        }
        
        //2.3 / 3.eset
        else if(f[1][0]=='S' && c[1][0]=='S' && d[1][0]=='S' && e[1][0]=='S'){
            forgJf();
            forgAj();
            forgJl();
            forgAj();
            forgJf();
            forgAj();
            forgAj();
            forgJl();
            st = st.concat("#2.2.3.1");
        }else if(f[0][0]=='S' && d[1][0]=='S' && e[1][0]=='S' && b[1][0]=='S'){
            forgAb();
            forgJf();
            forgAj();
            forgJl();
            forgAj();
            forgJf();
            forgAj();
            forgAj();
            forgJl();
            st = st.concat("#2.2.3.2");
        }else if(f[0][1]=='S' && b[1][0]=='S' && e[1][0]=='S' && c[1][0]=='S'){
            forgAb();
            forgAb();
            forgJf();
            forgAj();
            forgJl();
            forgAj();
            forgJf();
            forgAj();
            forgAj();
            forgJl();
            st = st.concat("#2.2.3.3");
        }else if(f[1][1]=='S' && b[1][0]=='S' && c[1][0]=='S' && d[1][0]=='S'){
            forgAj();
            forgJf();
            forgAj();
            forgJl();
            forgAj();
            forgJf();
            forgAj();
            forgAj();
            forgJl();
            st = st.concat("#2.2.3.4");
        }
        
        //2.4 / 4.eset
        else if(f[0][1]=='S' && d[1][1]=='S' && e[1][1]=='S' && b[1][1]=='S'){
            forgJf();
            forgAj();
            forgAj();
            forgJl();
            forgAb();
            forgJf();
            forgAb();
            forgJl();
            st = st.concat("#2.2.4.1");
        }else if(f[1][1]=='S' && e[1][1]=='S' && b[1][1]=='S' && c[1][1]=='S'){
            forgAb();
            forgJf();
            forgAj();
            forgAj();
            forgJl();
            forgAb();
            forgJf();
            forgAb();
            forgJl();
            st = st.concat("#2.2.4.2");
        }else if(f[1][0]=='S' && b[1][1]=='S' && c[1][1]=='S' && d[1][1]=='S'){
            forgAb();
            forgAb();
            forgJf();
            forgAj();
            forgAj();
            forgJl();
            forgAb();
            forgJf();
            forgAb();
            forgJl();
            st = st.concat("#2.2.4.3");
        }else if(f[0][0]=='S' && c[1][1]=='S' && d[1][1]=='S' && e[1][1]=='S'){
            forgAj();
            forgJf();
            forgAj();
            forgAj();
            forgJl();
            forgAb();
            forgJf();
            forgAb();
            forgJl();
            st = st.concat("#2.2.4.4");
        }
        
        //2.5 / 5. eset
        
        
        else if(f[0][1]=='S' && f[1][1]=='S' && b[1][1]=='S' && b[1][0]=='S'){
            forgHb();
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgHj();
            st = st.concat("#2.2.5.1");
        }else if(f[1][0]=='S' && f[1][1]=='S' && c[1][0]=='S' && c[1][1]=='S'){
            forgAb();
            forgHb();
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgHj();
            st = st.concat("#2.2.5.2");
        }else if(f[0][0]=='S' && f[1][0]=='S' && d[1][0]=='S' && d[1][1]=='S'){
            forgAb();
            forgAb();
            forgHb();
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgHj();
            st = st.concat("#2.2.5.3");
        }else if(f[0][0]=='S' && f[0][1]=='S' && e[1][0]=='S' && e[1][1]=='S'){
            forgAj();
            forgHb();
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgHj();
            st = st.concat("#2.2.5.4");
        }
        
        //2.6 / 6. eset
        else if(c[1][0]=='S' && e[1][1]=='S' && f[0][1]=='S' && f[1][1]=='S'){
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgJl();
            forgHb();
            forgJf();
            forgHj();
            st = st.concat("#2.2.6.1");
        }else if(f[1][0]=='S' && f[1][1]=='S' && b[1][1]=='S' && d[1][0]=='S'){
            forgAb();
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgJl();
            forgHb();
            forgJf();
            forgHj();
            st = st.concat("#2.2.6.2");
        }else if(f[0][0]=='S' && f[1][0]=='S' && c[1][1]=='S' && e[1][0]=='S'){
            forgAb();
            forgAb();
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgJl();
            forgHb();
            forgJf();
            forgHj();
            st = st.concat("#2.2.6.3");
        }else if(f[0][0]=='S' && f[0][1]=='S' && b[1][0]=='S' && d[1][1]=='S'){
            forgAj();
            forgJf();
            forgAj();
            forgJl();
            forgAb();
            forgJl();
            forgHb();
            forgJf();
            forgHj();
            st = st.concat("#2.2.6.4");
        }
        
        //2.7 / 7.eset
        else if(f[0][0]=='S' && f[1][1]=='S' && d[1][0]=='S' && e[1][1]=='S'){
            forgHb();
            forgJf();
            forgAb();
            forgJl();
            forgAb();
            forgJf();
            forgAj();
            forgJl();
            forgHj();
            st = st.concat("#2.2.7.1");
        }else if(f[1][0]=='S' && f[0][1]=='S' && b[1][1]=='S' && e[1][0]=='S'){
            forgAb();
            forgHb();
            forgJf();
            forgAb();
            forgJl();
            forgAb();
            forgJf();
            forgAj();
            forgJl();
            forgHj();
            st = st.concat("#2.2.7.2");
        }else if(f[0][0]=='S' && f[1][1]=='S' && c[1][1]=='S' && b[1][0]=='S'){
            forgAb();
            forgAb();
            forgHb();
            forgJf();
            forgAb();
            forgJl();
            forgAb();
            forgJf();
            forgAj();
            forgJl();
            forgHj();
            st = st.concat("#2.2.7.3");
        }else if(f[0][1]=='S' && f[1][0]=='S' && d[1][1]=='S' && c[1][0]=='S'){
            forgAj();
            forgHb();
            forgJf();
            forgAb();
            forgJl();
            forgAb();
            forgJf();
            forgAj();
            forgJl();
            forgHj();
            st = st.concat("#2.2.7.4");
        }
        
        //3. Lépés Alsó sor rendezés
        
        if(b[1][0]=='Z' && b[1][1]=='Z' && c[1][0]=='P' && c[1][1]=='P' && d[1][0]=='K' && d[1][1]=='K' && e[1][0]=='N' && e[1][1]=='N'){
            st = st.concat("#3.1.1.1");
        }else if(b[1][1]=='N' && c[1][0]=='Z' && c[1][1]=='K' && d[1][0]=='N' && d[1][1]=='P' && e[1][0]=='K' && e[1][1]=='Z' && b[1][0]=='P'){
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAb();
            forgAj();
            forgAj();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAb();
            st = st.concat("#3.1234");
        }else if(b[1][1]=='N' && c[1][0]=='Z' && c[1][1]=='K' && d[1][0]=='N' && d[1][1]=='Z' && e[1][0]=='P' && e[1][1]=='P' && b[1][0]=='K'){
            forgAj();
            forgAj();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAb();
            st = st.concat("#3.1243");
        }else if(b[1][1]=='N' && c[1][0]=='Z' && c[1][1]=='P' && d[1][0]=='K' && d[1][1]=='K' && e[1][0]=='N' && e[1][1]=='Z' && b[1][0]=='P'){
            forgAb();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            st = st.concat("#3.1324");
        }else if(b[1][1]=='N' && c[1][0]=='Z' && c[1][1]=='P' && d[1][0]=='K' && d[1][1]=='Z' && e[1][0]=='P' && e[1][1]=='K' && b[1][0]=='N'){
            forgAj();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAj();
            st = st.concat("#3.1342");
        }else if(b[1][1]=='N' && c[1][0]=='Z' && c[1][1]=='Z' && d[1][0]=='P' && d[1][1]=='K' && e[1][0]=='N' && e[1][1]=='P' && b[1][0]=='K'){
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAb();
            forgAb();            
            st = st.concat("#3.1423");
        }else if(b[1][1]=='N' && c[1][0]=='Z' && c[1][1]=='Z' && d[1][0]=='P' && d[1][1]=='P' && e[1][0]=='K' && e[1][1]=='K' && b[1][0]=='N'){
            forgAb();
            st = st.concat("#3.1432");
        }else if(b[1][1]=='K' && c[1][0]=='N' && c[1][1]=='N' && d[1][0]=='Z' && d[1][1]=='P' && e[1][0]=='K' && e[1][1]=='Z' && b[1][0]=='P'){
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAj();
            st = st.concat("#3.2134");
        }else if(b[1][1]=='K' && c[1][0]=='N' && c[1][1]=='N' && d[1][0]=='Z' && d[1][1]=='Z' && e[1][0]=='P' && e[1][1]=='P' && b[1][0]=='K'){
            forgAj();
            forgAj();
            st = st.concat("#3.2143");
        }else if(b[1][1]=='K' && c[1][0]=='N' && c[1][1]=='P' && d[1][0]=='K' && d[1][1]=='N' && e[1][0]=='Z' && e[1][1]=='Z' && b[1][0]=='P'){
            forgAj();
            forgAj();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAb();
            forgAb();
            st = st.concat("#3.2314");
        }else if(b[1][1]=='K' && c[1][0]=='N' && c[1][1]=='P' && d[1][0]=='K' && d[1][1]=='Z' && e[1][0]=='P' && e[1][1]=='N' && b[1][0]=='Z'){
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAb();
            forgAj();
            forgAj();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAb();
            forgAb();            
            st = st.concat("#3.2341");
        }else if(b[1][1]=='K' && c[1][0]=='N' && c[1][1]=='Z' && d[1][0]=='P' && d[1][1]=='N' && e[1][0]=='Z' && e[1][1]=='P' && b[1][0]=='K'){
            forgAj();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            st = st.concat("#3.2413");
        }else if(b[1][1]=='K' && c[1][0]=='N' && c[1][1]=='Z' && d[1][0]=='P' && d[1][1]=='P' && e[1][0]=='K' && e[1][1]=='N' && b[1][0]=='Z'){
            forgAb();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAb();
            st = st.concat("#3.2431");
        }else if(b[1][1]=='P' && c[1][0]=='K' && c[1][1]=='N' && d[1][0]=='Z' && d[1][1]=='K' && e[1][0]=='N' && e[1][1]=='Z' && b[1][0]=='P'){
            forgAj();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAb();
            st = st.concat("#3.3124");
        }else if(b[1][1]=='P' && c[1][0]=='K' && c[1][1]=='N' && d[1][0]=='Z' && d[1][1]=='Z' && e[1][0]=='P' && e[1][1]=='K' && b[1][0]=='N'){
            forgAb();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAb();
            forgAb();
            st = st.concat("#3.3142");
        }else if(b[1][1]=='P' && c[1][0]=='K' && c[1][1]=='K' && d[1][0]=='N' && d[1][1]=='N' && e[1][0]=='Z' && e[1][1]=='Z' && b[1][0]=='P'){
            forgAj();
            st = st.concat("#3.3214");
        }else if(b[1][1]=='P' && c[1][0]=='K' && c[1][1]=='K' && d[1][0]=='N' && d[1][1]=='Z' && e[1][0]=='P' && e[1][1]=='N' && b[1][0]=='Z'){            
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            st = st.concat("#3.3241");
        }else if(b[1][1]=='P' && c[1][0]=='K' && c[1][1]=='Z' && d[1][0]=='P' && d[1][1]=='N' && e[1][0]=='Z' && e[1][1]=='K' && b[1][0]=='N'){
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAj();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAj();
            st = st.concat("#3.3412");
        }else if(b[1][1]=='P' && c[1][0]=='K' && c[1][1]=='Z' && d[1][0]=='P' && d[1][1]=='K' && e[1][0]=='N' && e[1][1]=='N' && b[1][0]=='Z'){
            forgAj();
            forgAj();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAj();
            st = st.concat("#3.3421");
        }else if(b[1][1]=='Z' && c[1][0]=='P' && c[1][1]=='N' && d[1][0]=='Z' && d[1][1]=='K' && e[1][0]=='N' && e[1][1]=='P' && b[1][0]=='K'){
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAj();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            st = st.concat("#3.4123");
        }else if(b[1][1]=='Z' && c[1][0]=='P' && c[1][1]=='N' && d[1][0]=='Z' && d[1][1]=='P' && e[1][0]=='K' && e[1][1]=='K' && b[1][0]=='N'){
            forgAb();
            forgAb();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            st = st.concat("#3.4132");
        }else if(b[1][1]=='Z' && c[1][0]=='P' && c[1][1]=='K' && d[1][0]=='N' && d[1][1]=='N' && e[1][0]=='Z' && e[1][1]=='P' && b[1][0]=='K'){
            forgAb();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAj();
            st = st.concat("#3.4213");
        }else if(b[1][1]=='Z' && c[1][0]=='P' && c[1][1]=='K' && d[1][0]=='N' && d[1][1]=='P' && e[1][0]=='K' && e[1][1]=='N' && b[1][0]=='Z'){
            forgAj();
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAj();
            forgAj();            
            st = st.concat("#3.4231");
        }else if(b[1][1]=='Z' && c[1][0]=='P' && c[1][1]=='P' && d[1][0]=='K' && d[1][1]=='N' && e[1][0]=='Z' && e[1][1]=='K' && b[1][0]=='N'){
            forgJl();
            forgHb();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgHj();
            forgJl();
            forgEb();
            forgEb();
            forgJf();
            forgJf();
            forgAb();            
            st = st.concat("#3.4312");
        }
        
    }
        
}
