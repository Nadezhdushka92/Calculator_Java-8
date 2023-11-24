import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        System.out.println("Введите строку для вычисления: ");
        Scanner scanner = new Scanner(System.in);
        String stringToCalc = scanner.nextLine();

        String resultCalc = " ";
        try {
            resultCalc = calc(stringToCalc);
        } catch (Exception e) {
            System.out.println("throws Exception");

        }
        if (!resultCalc.equals(" ")) {
            System.out.println("Результат вычисления: ");
            System.out.println(resultCalc);
        }
    }

    public static String calc(String input) throws Exception {
        String resToString = new String();
        String tempResToString = new String();
        int res = 0;
        int aToInt = 0;
        int bToInt = 0;

        String [] strings = input.split(" ");
        String a = strings[0];
        if (!isPresent(a)) {
            aToInt = Integer.parseInt(a);
        }else{
            RomNum RomNumAra = RomNum.valueOf(a);
            aToInt = Integer.parseInt(RomNumAra.getValue());
            //System.out.println(RomNumAra.getValue());
        }

        String sign = strings[1];
        String b = strings[2];
        if (!isPresent(b)) {
            bToInt = Integer.parseInt(b);
        }else{
            RomNum RomNumArb = RomNum.valueOf(b);
            bToInt = Integer.parseInt(RomNumArb.getValue());
        }
        //System.out.println(aToInt);
        //System.out.println(bToInt);
        //System.out.println(a);
        //System.out.println(sign);
        //System.out.println(b);

        if ((strings.length > 3) || (strings.length < 3)) {
            throw new Exception();//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)
        }

        if (aToInt > 0 && bToInt > 0 && aToInt < 11 && bToInt < 11) {
            switch (sign) {
                case "+":
                    res = aToInt + bToInt;
                    break;
                case "-":
                    if (!isPresent(a) && !isPresent(b)) {
                        res = aToInt - bToInt;
                    }else{
                        throw new Exception();//т.к. в римской системе нет отрицательных чисел
                    }
                    break;
                case "*":
                    res = aToInt * bToInt;
                    break;
                case "/":
                    res = aToInt / bToInt;
                    break;
                default:
                    throw new Exception();//т.к. строка не является математической операцией
            }
        }else{
            throw new Exception();//т.к. не число от 1 до 10, I до X
        }
        if (!isPresent(a) && !isPresent(b)) {
            resToString = Integer.toString(res);

        }else if (isPresent(a) && isPresent(b)) {
            tempResToString = Integer.toString(res);
            RomNum transTempResToEnum = RomNum.getByValue(tempResToString);
            //System.out.println(transTempResToEnum);
            //System.out.println(tempResToString);
            resToString = transTempResToEnum.name();
            //System.out.println(resToString);

        }else{
            throw new Exception();//т.к. используются одновременно разные системы счисления
        }

        return resToString;
    }

    public static boolean isPresent(String data) {

        try {
            Enum.valueOf(RomNum.class, data);
            return true;
        } catch (IllegalArgumentException e) {
            //System.out.println("Это не римские цифры");
            return false;
        }
    }


}
