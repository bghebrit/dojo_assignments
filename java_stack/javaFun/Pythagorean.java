import java.lang.Math;
public class Pythagorean {
    public double calculateHypotenuse(int legA,int legB) {
        double a = legA * legA;
        double b = legB * legB;        
        double C = Math.sqrt(a + b);  
        return C;
    }
}