import java.io.File;
import java.sql.SQLOutput;
import java.util.*;
import java.lang.Math;


public class movies2 {

    public static void main(String [] args) throws Exception{
        File file = new File("movie.txt");
        Scanner scanner = new Scanner(file);
        int i=0;
        int k=0;
        String answer = "";
        int ranNumber= (int) ((Math.random()*26)+1);
        while(scanner.hasNextLine()){
            i++;
            String line = scanner.nextLine();
            if(i==ranNumber)
            {
                answer = line;
                k=answer.length();
            }
        }
        List<Character> rightAnswer = new ArrayList<>();
        for(i=0;i<answer.length();i++){
            rightAnswer.add(answer.charAt(i));
        }


        List<String> underscore = new ArrayList<String>();
        for (i=0;i<k;i++){
            underscore.add("_");
        }
        List<Character> answers = new ArrayList<>();
        boolean guessed=true;
        int z=0;
        List<String> mistakes = underscore;
        while(guessed)
        {
            int counter=0;
            String formattedString = underscore.toString()
                    .replace(",", "")  //remove the commas
                    .replace("[", "")  //remove the right bracket
                    .replace("]", "")
                    .replace(" ", "")//remove the left bracket
                    .trim();           //remove trailing spaces from partially initialized arrays
            String formattedString1 = rightAnswer.toString()
                    .replace(", ", "")  //remove the commas
                    .replace("[", "")  //remove the right bracket
                    .replace("]", "")  //remove the left bracket
                    .replace(" ", "_")
                    .trim();
            if(formattedString1.equals(formattedString))
            {
                System.out.println("Congratulations you win with "+ z + " mistakes");
                break;
            }
            if(z>4){
                System.out.println("You have made 5 mistakes and you lose :(");
                break;
            }
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("You are guessing: "+ formattedString);
            System.out.println("Guess a letter:");
            String letter = scanner1.nextLine();
            char d =letter.charAt(0);
            for(i=0;i<answer.length();i++){
                if(d==rightAnswer.get(i)){
                    underscore.set(i,letter);
                }
                else if(mistakes.equals(underscore)){
                    counter++;
                    if(counter==answer.length()){
                        z++;
                        System.out.println("You have made "+z+" mistakes");
                    }
                }
            }
            answers.add(d);
            System.out.println("You already have tried: "+answers.toString());
              //remove trailing spaces from partially initialized arrays

            }

        }
    }


