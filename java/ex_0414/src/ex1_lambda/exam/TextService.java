package ex1_lambda.exam;

public class TextService {

	public String processText(String text, StringProcessor processor) {
		return processor.process(text);
	}
}
