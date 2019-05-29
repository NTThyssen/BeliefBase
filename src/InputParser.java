import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class InputParser {
    String input;

    public SentenceInterface evaluateString(String input){
        input = input.trim();
        int nestedLevel = 0;
        int i = 0;
        int expr1Start = 0, expr1End = 0, expr2Start = 0, expr2End = 0;
        Connective connective = null;
        SentenceInterface expr1, expr2;
        boolean hasConnective = false, isTrue = true;
        while(i < input.length()){
            if(input.charAt(i) == '('){
                //start of expression found
                if(nestedLevel == 0){
                    if(i == 1 && input.charAt(i-1) == '!'){
                        isTrue = false;

                    }
                    /*if(i != 0 && input.charAt(i-1) == '!'){
                        expr1Start = i;
                    }else{
                        expr1Start = i+1;
                    }*/
                    expr1Start = i+1;

                }
                nestedLevel++;
            }
            int connectiveLength = isConnective(input.substring(i));
            if(connectiveLength > 0){
                if(nestedLevel == 1){
                    hasConnective = true;
                    expr1End = i-1;
                    connective = Connective.valueOf(input.substring(i, i + connectiveLength));
                    expr2Start = i + connectiveLength;
                }
                i = i + connectiveLength;
            //connective found
            }
            if(input.charAt(i) == ')'){
                if(nestedLevel == 1){
                    //end of expression found
                    expr2End = i-1;
                }
                nestedLevel--;
            }
            i++;
        }
        if(hasConnective){
            expr1 = evaluateString(input.substring(expr1Start, expr1End+1));
            expr2 = evaluateString(input.substring(expr2Start, expr2End+1));
            return new Expression(isTrue, expr1, connective, expr2);
        }else{
            String variable = input.trim();
            if(variable.charAt(0) == '!'){
                //is false
                return new Variable(false, variable.substring(1));
            }else{
                return new Variable(true, variable);
            }
        }
    }

    private int isConnective(String temp){
        if(temp.length() >= 3 && temp.substring(0, 3).equals("AND")){
            return 3;
        }else if(temp.length() >= 2 && temp.substring(0, 2).equals("OR")){
            return 2;
        }else if(temp.length() >= 13 && temp.substring(0, 13).equals("BIIMPLICATION")){
            return 13;
        }else if(temp.length() >= 11 && temp.substring(0, 11).equals("IMPLICATION")){
            return 11;
        }else{
            return 0;
        }
    }

    public ArrayList<SentenceInterface> split(ArrayList<SentenceInterface> sentenceInterfaceList, SentenceInterface sentence){

        if(sentence.getConnective() != null && sentence.getConnective() == Connective.AND){
            split(sentenceInterfaceList, sentence.getSentence1());
            split(sentenceInterfaceList, sentence.getSentence2());
        }else {
            sentenceInterfaceList.add(sentence);
        }

        return sentenceInterfaceList;
    }

    public ArrayList<SentenceInterface> takeInput(String input){
        return  split(new ArrayList<>(), evaluateString(input));
    }
}
