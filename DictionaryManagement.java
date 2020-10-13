import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {

    public void insertFromCommandline() {
        int n;
        String temp1, temp2;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            Scanner sc1 = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            temp1 = sc1.nextLine();
            temp2 = sc2.nextLine();
            Word a = new Word(temp1, temp2);
            arr.add(a);
        }
    }

    public void showAllWord(){
        System.out.println("NO\t| English\t\t|Vietnamese");
        int i = 1;
        for(Word a : arr){
            System.out.println( i +"\t|"+ a.getWord_explain() + "\t\t|" +a.getWord_target());
            i++;
        }
    }

    public  void insertFromFile() {
        try {
            File f = new File("dictionaries.txt");
            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);
            String line;
            int i = 1;
            while ((line = br.readLine()) != null){
                System.out.println(i + "   | " + line);
                i++;
            }
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//nhap du lieu vao tu dien tu tep dictionaries.txt

    public  void dictionaryAddWord(){
        final String FILENAME = "dictionaries.txt";
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            int n;
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            File file = new File(FILENAME);
            // kiểm tra nếu file chưa có thì tạo file mới
            if (!file.exists()) {
                file.createNewFile();
            }
            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            for(int i = 0; i < n; i++){
                String temp1 , temp2 ;
                Scanner sc = new Scanner(System.in);

                temp1 = sc.nextLine();
                temp2 = sc.nextLine();

                bw.write(temp1+ " : " +temp2 +"\n");
                System.out.println("Xong");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    public  void dictionaryLookup(){
        //bo xung ham dictionaryLookup co chuc nang tra cuu tu dien bang dong lenh
        String search;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word to look up: ");
        search = scanner.nextLine();
        try {
            File f = new File("dictionaries.txt");
            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);
            String line;
            String[] WordArray;

            while (true){
                line = br.readLine();
                if(line == null){
                    break;
                }
                else{
                    WordArray = line.split(" : ");
                }

                for(int i = 0; i < WordArray.length; i++){
                    if(search.equals(WordArray[i])){
                        System.out.println(WordArray[i+1]);
                    }
                }

                /**
                 ArrayList<String> list = new ArrayList<String>();
                 for(int i = 0; i < WordArray.length; i++){
                    list.add(WordArray[i]);
                 }
                 for(int i = 0; i < list.size(); i++){
                    if(search.equals(list.get(i))){
                        System.out.println(list.get(i+1));
                    }
                }*/
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}