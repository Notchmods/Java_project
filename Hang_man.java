import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Variables
        int strokes = 0;
        ArrayList<Character> letters= new ArrayList<Character>();

        //Actual word, clue words and letters
        String Clue,words;


        System.out.println("Welcome to hang man, firstly you type a word and let your friend guess it");
        //Enter the word
        System.out.println("What is the word that you want to enter: ");
        Scanner enter_word = new Scanner(System.in);
        words=enter_word.nextLine();

        //Get some clues for Hang man
        System.out.println("Give a clue for the word: ");
        Scanner enter_clue = new Scanner(System.in);
        Clue=enter_clue.nextLine();

        Arrayify(words,letters);

        //Clear the console
        for(int i=0;i<50;i++){
            System.out.println(" ");
        }
        System.out.println(Clue);
        System.out.println("Guess the word: ");
        Enter_words(words,strokes,letters);
    }

    public static void Print_hanging(int stroke){
        switch(stroke){
            case 1:
                System.out.println("  +---+\n" +
                        "  |   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |");
                break;
            case 2:
                System.out.println(" +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |");
                break;
            case 3:
                System.out.println("  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        "  |   |\n" +
                        "      |\n" +
                        "      |");
                break;
            case 4:
                System.out.println(" +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|   |\n" +
                        "      |\n" +
                        "      |");
                break;
            case 5:
                System.out.println("  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        "      |\n" +
                        "      |");
                break;
            case 6:
                System.out.println("  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        " / \\  |\n" +
                        "      |");
                System.out.println("It's over");
                break;
            default:
                System.out.println("Start the game again?");
        }
    }


    public static void Arrayify(String word,ArrayList<Character> letter_collection) {
        for(int i =0;i<word.length();i++){
            letter_collection.add(word.charAt(i));
        }
    }

    public static void Enter_words(String words, int strokes,ArrayList<Character> letter_collection){
       String current_letter;
       ArrayList<Character> new_letters= new ArrayList<Character>();
        while(true){
            //Get the letter
            System.out.print("\n");
            Scanner new_words=new Scanner(System.in);
            current_letter=new_words.next();

            //Compare letter to the ones in the array
            //If correct then display correct letter otherwise draw hang man
                if(letter_collection.contains(current_letter.charAt(0))){
                    //If letter hasn't already been guessed then add it
                    if(!new_letters.contains(current_letter.charAt(0))){
                        new_letters.add(current_letter.charAt(0));
                    }
                    //Display letters or stroke depending on what the users has guessed
                    for(int i=0;i< words.length();i++){
                        if(new_letters.contains(words.charAt(i))){
                            System.out.print(words.charAt(i));
                        }else{
                            System.out.print("_");
                        }

                    }
                }else{
                    //If guessed incorrectly then hang man will be drawn stroke by stroke
                    strokes+=1;
                    Print_hanging(strokes);
                }

                //Check for victory by comparing letter collection to the current letter collection
                if(letter_collection.equals(new_letters)){
                    System.out.println("\nYou've guessed the word, it's "+words);
                }else{
                   continue;
                }


        }
    }
}
