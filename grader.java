public class grader {
    char[] accuracy = new char[4];

    public grader(char[] created, char[] guessed) {




        //Loop through guess
        for (int i = 0; i < guessed.length; i++) {
            //For every guess loop through the creation
            char c = guessed[i];

            for (int j = 0; j < created.length; j++) {
                char d = created[j];

                //If index and character are the same C

                if (c == d && i == j){
                    accuracy[i] = 'C';
                    break;
                }
                else if  (c == d && i != j) {
                    accuracy[i] = 'P';
                }
                else if (c != d && i!=j && accuracy[i] != 'P') {
                    accuracy[i] = 'X';
                }

            }

        }
        accuracy = isAlreadyCorrectInArray(accuracy, created, guessed);


    }



    public char[] getAccuracy() {
        return accuracy;
    }



    public void printAccuracy(){
        for(int i=0;i<accuracy.length;i++){
            System.out.print(accuracy[i] + ", ");
        }
        System.out.println();
    }

    public char[] isAlreadyCorrectInArray(char[] gradeArray, char [] created, char[] guessed){
        char[] createdCopy = created.clone();
        char[] gradedCopy = gradeArray.clone();

        for(int i = 0; i < gradeArray.length; i++){
            if(gradeArray[i] == 'C'){
                createdCopy[i] = 'a';
            }
            else{
                gradedCopy[i] = 'X';
            }
        }
        for(int i = 0; i < guessed.length; i++){
            char c = guessed[i];
            for(int j=0; j < createdCopy.length; j++){
                char d = createdCopy[j];
                if(c == d && i != j && createdCopy[i] != 'a'){
                    gradedCopy[i] = 'P';
                }
                else if(c!=d && i!=j && createdCopy[i] != 'a' && gradedCopy[i] != 'P'){
                    gradedCopy[i] = 'X';
                }
                else if(createdCopy[i] == 'a'){
                    gradedCopy[i] = 'C';
                }
            }
        }

       return gradedCopy;
    }



}