package string;

public class NumberofAtoms {
    public String countOfAtoms(String formula) {
        int j = 0;
        int k = 0;
        for(int i =0; i<formula.length(); i++){
            char ch = formula.charAt(i);
            if(ch == '(' || Character.isUpperCase(ch)){
                String atom = formula.substring(j, i);
                Element ele = atomNum(atom);
            }
        }
        return "";
    }
    Element atomNum(String formula){
        for(int i =0; i<formula.length(); i++){
            Character ch = formula.charAt(i);
            if(Character.isDigit(ch)){
                return new Element(formula.substring(0, i), Integer.parseInt(formula.substring(i)));
            }
        }
        return new Element(formula, 1);
    }
}

class Element{
    String atom;
    int num;
    Element(){}
    Element(String atom, int num){
        this.atom = atom;
        this.num = num;
    }
}
