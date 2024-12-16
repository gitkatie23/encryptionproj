class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){

    // This example we are substituting all lower case 
    // letters to another lower case letter.
    char[] sub = new char[8];
    sub[0] = 'a';
    sub[1] = 'e';
    sub[2] = 'i';
    sub[3] = 'o';
    sub[4] = 'u';
	sub[5] = 'l';
	sub[6] = 'd';
	sub[7] = 'r';
	
    char[] sub2 = new char[8];
    sub2[0] = '\u1800';  // MONGOLIAN FULL STOP
    sub2[1] = '\u1801';  // MONGOLIAN ELLIPSIS
    sub2[2] = '\u1805';  // MONGOLIAN FOUR DOTS
    sub2[3] = '\u1808';  // MONGOLIAN MANCHU COMMA
    sub2[4] = '\u1812';  // MONGOLIAN DIGIT TWO
    sub2[5] = '\u1886';  // MONGOLIAN LETTER ALI GALI THREE BALUDA 
	sub2[6] = '\u1899';  // MONGOLIAN LETTER TODO ALI GALI ZHA
	sub2[7] = '\u1882'; // MONGOLIAN LETTER ALI GALI DAMARU 
    
    // Encoding message
    String file = Input.readFile("Original.txt");

    //substituion
    // String encodedMsg1 = subEncryption(file,sub,sub2);
    // Input.writeFile("Encode1.txt",encodedMsg1);

    // caesar cipher
    String encodedMsg2 = encode(file);
    Input.writeFile("Encode2.txt",encodedMsg2);

    // reverse
    //String encodedMsg3 = reverse(encodedMsg2);
    //Input.writeFile("Encode3.txt",encodedMsg3);

    
    // decoding message
    //String file2 = Input.readFile("Encode3.txt");
    
    //String decodedMsg1 = reverse(file2);
    //Input.writeFile("Decode1.txt", decodedMsg1);
    
    //String decodedMsg2 = decode(decodedMsg1);
    //Input.writeFile("Decode2.txt", decodedMsg2);
    
    //String decodedMsg3 = subEncryption(decodedMsg2, sub2, sub);
    //Input.writeFile("Decode3.txt", decodedMsg3);
    
    
  }
  
  
  
  //Cipher encoding with no wrapping
  String encode(String txt){
    String bld="";
    int ascii;
    char ch='\0';
    for(int x=0; x<=txt.length()-5;x++){
      ch=txt.charAt(x);
      ascii=(int)ch;
      ascii+=5;
      bld+= (char)ascii;
    }
     
    return bld;
  }

  
  String decode(String txt){
    String bld="";
    int ascii;
    char ch='\0';
    for(int x=0; x<=txt.length()-1;x++){
      ch=txt.charAt(x);
      ascii=(int)ch;
      ascii-=1;
      bld+= (char)ascii;
    }
    return bld;
  }

  // Substituion encoding
  String subEncryption(String s, char[] sub, char[] sub2){
    String bld="";
    char ch ='\0';
    int index=0;
    for(int x=0; x<=s.length()-1; x++){
      ch=s.charAt(x);
      index=indexOf(ch,sub);
      if(index!=-1){
        bld+=sub2[index];
      }
      else{
        bld+=ch;
      }
    }
    return bld;
  }
  
  int indexOf(char ch, char[] arry){
    for(int x=0; x<=arry.length-1; x++){
      if(arry[x]==ch){
        return x;
      }
    }
    return -1;
  }
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }

}