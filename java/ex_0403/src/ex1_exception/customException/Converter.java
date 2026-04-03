package ex1_exception.customException;

public class Converter {

	public int toInt(String value)throws NumberFormatException {
		return Integer.parseInt(value);
	}
}
