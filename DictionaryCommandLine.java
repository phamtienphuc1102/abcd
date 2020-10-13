import java.io.*;
import java.util.Scanner;

public class DictionaryCommandLine extends DictionaryManagement {
    public void DictionaryBasic(){
        DictionaryManagement dima = new DictionaryManagement();
        dima.insertFromCommandline();
        dima.showAllWord();
    }
    public void dictionaryAdvanced()  {
        DictionaryManagement dima = new DictionaryManagement();
        dima.showAllWord();
        dima.insertFromFile();        //đọc file, in từ điển
        dima.dictionaryAddWord();    // thêm từ
        dima.dictionaryLookup();   //tìm kiếm
    }
    public void dictionarySearcher(){
        String search;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word to look up: ");
        search = scanner.nextLine();
        try {
            File f = new File("dictionaries.txt");
            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);
            String line;

            String[] WordArray = new String[10000];

            while (true){
                line = br.readLine();
                if(line == null){
                    break;
                }
                else{
                    WordArray = line.split(" : ");
                }

                for(int i = 0; i < WordArray.length; i++){
                    String[] array1 = search.split("");
                    String[] array2 = WordArray[i].split("");

                    int dem = 0;
                    for(int j = 0; j < array1.length; j++) {
                        if(array1[j].equals(array2[j])){
                            dem++;
                        }
                        if(dem == array1.length) {
                            System.out.println(WordArray[i]);
                        }
                    }

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}