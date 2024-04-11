import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class arabic {

    public static char[] alphabit={'ء','آ','أ','ؤ','إ','ئ','ا', 'ب', 'ة', 'ت', 'ث', 'ج', 'ح', 'خ', 'د', 'ذ', 'ر', 'ز', 'س', 'ش', 'ص', 'ض', 'ط', 'ظ', 'ع', 'غ', 'ف', 'ق', 'ك', 'ل', 'م', 'ن', 'ه', 'و','ى','ي'};


    public static String caserShift_en(String cihperText, int key){
        cihperText=cihperText.toLowerCase();
        char[] cihperText_arr = cihperText.toCharArray();

        for (int i=0;i<cihperText.length();i++){
            for (int j=0;j<alphabit.length;j++){
                if (cihperText_arr[i]==alphabit[j]){
                    cihperText_arr[i]=alphabit[(j+key)%alphabit.length];
                    break;
                }
            }
        }
        cihperText=String.valueOf(cihperText_arr);
        return cihperText;
    }

    public static String caserShift_de(String cihperText, int key){
        cihperText=cihperText.toLowerCase();
        char[] cihperText_arr = cihperText.toCharArray();

        for (int i=0;i<cihperText.length();i++){
            for (int j=0;j<alphabit.length;j++){
                if (cihperText_arr[i]==alphabit[j]){
                    j=Math.floorMod(j-key,alphabit.length);
                    cihperText_arr[i]=alphabit[j];
                    break;
                }
            }
        }
        cihperText=String.valueOf(cihperText_arr);
        return cihperText;
    }
    public static void main(String[] args) {
        int key;
        Scanner sc=new Scanner(System.in);
        System.out.print("\n1- Encryption\n2- Decryption\nChoice: ");
        int choice =sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("\nEnter KEY: ");
                key=sc.nextInt();
                System.out.print("\nEnter PlainText: ");
                sc.nextLine();
                String en=sc.nextLine();
                System.out.println("cipherText: " + caserShift_en(en, key));
                break;
            case 2:
                System.out.print("\nEnter PlainText: ");
                sc.nextLine();
                String de=sc.nextLine();
                for (int i=0;i<alphabit.length;i++) {
                    System.out.println("Shift: "+ i+"\tplainText: " + caserShift_de(de, i));
                }
                break;
        }
    }
}