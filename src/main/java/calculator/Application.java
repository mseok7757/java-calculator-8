package calculator;

import camp.nextstep.edu.missionutils.Console;
//import java.io.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();

        int result = calculate(input);
        System.out.println(result);

    }

    //문자열 기본 구분자로 계산
    public static int calculate(String input){

        // 쉼표와 클론을 구분자로 처리후 numbers에 담기
        String[] numbers = input.split("[,:]");

        // 정수형으로 변환후 합산
        int sum = 0;
        for (String number : numbers){
            sum += Integer.parseInt(number);
        }

        return sum;

    }
}
