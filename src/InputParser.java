public class InputParser {
    String input;

    public SentenceInterface evaluateString(String input){
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
                    if(i == 1 && input.charAt(0) == '!'){
                        isTrue = false;
                    }
                    System.out.println("start found");
                    expr1Start = i+1;
                }else{

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
                System.out.println("connective found");
            //connective found
            }
            if(input.charAt(i) == ')'){
                if(nestedLevel == 1){
                    //end of expression found
                    System.out.println("end found");
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
}
