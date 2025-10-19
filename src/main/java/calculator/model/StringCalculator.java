package calculator.model;

import java.util.regex.Pattern;

public class StringCalculator {

    public static int calculate(String input) {

        String[] numbers;

        // 커스텀 구분자 정의가 맞을 시만 실행
        // 조건: //로 시작, \n으로 끝, 커스텀 구분자는 한 글자, 숫자는 올 수 없음
        if (input.startsWith("//")
                && input.substring(3, 5).equals("\\n")
                && !Character.isDigit(input.charAt(2))) {

            // 커스텀 구분자 추출
            char customSeparator = input.charAt(2);

            // 숫자 부분만 담기
            input = input.substring(input.indexOf("n") + 1);

            // 모든 공백 제거
            input = input.replace(" ", "");

            // 커스텀 구분자가 특수문자로 해석되지 않도록 Pattern.quote() 사용
            numbers = input.split("[,:" + Pattern.quote(String.valueOf(customSeparator)) + "]");
        } else {
            numbers = input.split("[,:]");
        }

        // 정수형으로 변환 후 합산
        int sum = 0;

        for (String number : numbers) {

            int num;

            try {
                num = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                System.out.println("문제 있는 값: " + number);
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
            }

            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }

            sum += num;
        }

        return sum;
    }
}
