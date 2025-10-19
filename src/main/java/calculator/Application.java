package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;
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

        String[] numbers;

        //입력값의 첫번째 값이 //이고 \n의 인덱스가 3일경우 실행
        if (input.startsWith("//") && input.indexOf("\\n")==3){

            //커스텀 구분자를 추출
            char customSeparator = input.charAt(2);
            //숫자부분부터만 담기
            input = input.substring(input.indexOf("n") + 1);
            numbers= input.split("[,:" + customSeparator + "]");
        } else {
            numbers = input.split("[,:]");
        }

        // 정수형으로 변환후 합산
        int sum = 0;
        for (String number : numbers){
            sum += Integer.parseInt(number);
        }



        return sum;

    }
}
