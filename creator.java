import java.util.Random;
public class creator {

char[] color = new char[4];

    public creator() {
        for(int i=0;i<color.length;i++){
            color[i]=generator();
        }
    }

    public static char generator(){
        //Create random number in range 0-96
        Random random = new Random();
        char letter = 0;
        int range = random.nextInt(97);
            if (range <= 16) {
                 letter = 'O';
            } else if (range > 16 && range <= 32) {
                 letter = 'B';
            } else if (range > 32 && range <= 48) {
                 letter = 'G';
            } else if (range > 48 && range <= 64) {
                 letter = 'Y';
            } else if (range > 64 && range <= 80) {
                 letter = 'R';
            } else if (range > 80) {
                 letter = 'W';
            }

        return letter;
        }


    public char[] getColor(){
        return color;
    }

    public void printCreation(){
        System.out.println("The created pattern is");
    for (int i = 0; i < color.length; i++) {
        System.out.print(color[i] + ", ");
    }
            System.out.println();
}
}