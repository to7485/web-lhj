package ex3_generic;

public interface ISample<T> {
	public void addElement(T t, int index);
	public T getElement(int index);
}
