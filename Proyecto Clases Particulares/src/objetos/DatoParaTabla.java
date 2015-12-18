package objetos;

public interface DatoParaTabla {
    public int getNumColumnas();  // N�mero de columnas (campos del dato)
    public Object getValor(int col);  // Devolver valor de columna col
    public void setValor(Object value, int col);  // Asignar valor a columna col
}
