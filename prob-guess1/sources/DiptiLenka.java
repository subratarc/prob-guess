import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;


//interface Compute { 
//int getExact(int actual, int predicted) throws Exception;
//int getAlmost(int actual, int predicted) throws Exception;
//}

 

public class DiptiLenka implements Compute{
public static void main(String[] args) {
// TODO Auto-generated method stub
Random gen= new Random();
DiptiLenka pd = new DiptiLenka();
int target= 0;
while(hasDupes(target= (gen.nextInt(9000) + 1000)));
System.out.print("Random Number generated is " + target + " \n");
String targetStr = target +"";
boolean guessed = false;
Scanner input = new Scanner(System.in);
int guesses = 0;
do{
int Exact = 0;
int Almost = 0;
System.out.print("Guess a four digit number with no duplicate digits: ");
int guess;
try{
guess = input.nextInt();
if(hasDupes(guess) || guess < 1000 || guess>9999) continue;

if(guess == target){
break;
}
int exact = pd.getExact(target, guess);
int almost = pd.getAlmost(target, guess);
System.out.println(almost - exact + " Almost and "+ exact +" Exact.");

}catch(Exception e){
continue;
}
}while(!guessed);
System.out.println("You won after "+guesses+" guesses!");
}

public static boolean hasDupes(int num){
boolean[] digs = new boolean[10];
while(num > 0){
if(digs[num%10]) return true;
digs[num%10] = true;
num/= 10;
}
return false;
}
 
@Override
public int getExact(int actual, int predicted) throws Exception {
// TODO Auto-generated method stub

int exact = 0;
if(actual==predicted){
return actual;

}
String targetStr = actual + ""; 
String guessStr = predicted + "";
for(int i= 0;i < 4;i++){
if(guessStr.charAt(i) == targetStr.charAt(i)){
exact++;
}
}
return exact;
}
@Override
public int getAlmost(int actual, int predicted) throws Exception {
// TODO Auto-generated method stub
int guess = 0;

int guesses = 0;
String targetStr = actual +"";
guesses++;
String guessStr = predicted + "";
for(int i= 0;i < 4 ;i++){
if(targetStr.contains(guessStr.charAt(i)+"")){
guess++;
}
}
return guess;
} 
}
