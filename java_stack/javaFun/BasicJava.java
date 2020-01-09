import java.util.ArrayList;

public class BasicJava{
    public void printInt(){
        for(int i=1;i<=255;i++){
            System.out.println(i);
        }
    }
    public void printOdd(){
        for(int i=1;i<=255;i++){
            if(i%2==1){
               System.out.println(i);
            }
            else{
                continue;
            }
        }
    }
    public void printSum(){
        int sum = 0;
        for(int i=0;i<=255;i++){
            sum += i;
        }
        System.out.println(sum);
    }
    public void iterateArray(int[] myArray){
        int length = myArray.length;
        for(int i=0;i<length;i++){
            System.out.println(myArray[i]);
        }
    }
    public void findMax(int[] myArray){
        int max = myArray[0];
        int length = myArray.length;
        for(int i=0;i<length;i++){
            if(max < myArray[i]){
                max = myArray[i];
            }
        }
    }
    public void getAverage(int[] myArray){
        int length = myArray.length;
        double sum = 0;
        for(int i=0;i<length;i++){
            sum += myArray[i];
        }
        double avg = sum / length;
        System.out.println(avg);
    }
    public void oddArray(){
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        for (int i=1 ; i<256 ; i = i + 2){
            myArray.add(i);
        }
        System.out.println(myArray);
    }
    public void greaterY(int[] myArray, int y){
        int length = myArray.length;
        int counter = 0;
        for(int i=0;i<length;i++){
            if(myArray[i]>y){
                counter = counter + 1;
            }
        }
        System.out.println(counter);
    }
    public void squareValues(int[] myArray){
        int length = myArray.length;
        for(int i=0; i<length; i++){
            myArray[i] = myArray[i] * myArray[i];
        }
        System.out.println(myArray);
    }
    public void eliminateNegative(int[] myArray){
        int length = myArray.length;
        for(int i=0;i<length;i++){
            if(myArray[i]<0){
                myArray[i]=0;
            }
        }
        System.out.println(myArray);

    }
    public void maxMinAvg(int[] givenArray){
        int length = givenArray.length;
        int max = givenArray[0];
        int min = givenArray[0];
        double sum = 0;
        for(int i=0; i<length; i++){
            if(givenArray[i] > max){
                max = givenArray[i];
            }
            if(givenArray[i] < min){
                min = givenArray[i];
            }     
        sum = sum + givenArray[i];
        }
        double avg = sum / length;
        System.out.println(min);
        System.out.println(max);
        System.out.println(avg);
    }

}
