package calculator.controller;


import calculator.model.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public void run() {
        //입력메세지 요청
        OutputView.printRequestMessage();

        //
        String input = InputView.readInput();

        int result = StringCalculator.calculate(input);

        OutputView.printResult(result);
    }
}
