package LimpiarFormularioJswing;

//*Limpiar formularios entornos grafcio
public class LimpiarFormularioJswing {
    
    public void limpiarFormulario(Component[] componentes) {

        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof JPanel) {
                limpiarFormulario(((JPanel) componentes[i]).getComponents());
            } else if (componentes[i] instanceof JViewport) {
                limpiarFormulario(((JViewport) componentes[i]).getComponents());
            } else if (componentes[i] instanceof JScrollPane) {
                limpiarFormulario(((JScrollPane) componentes[i]).getComponents());
            } else if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setText("");
            } else if (componentes[i] instanceof JTextArea) {
                ((JTextArea) componentes[i]).setText("");
            } else if (componentes[i] instanceof JPasswordField) {
                ((JPasswordField) componentes[i]).setText("");
            } else if (componentes[i] instanceof JCheckBox) {
                ((JCheckBox) componentes[i]).setSelected(false);
            } else if (componentes[i] instanceof JRadioButton) {
                ((JRadioButton) componentes[i]).setSelected(false);
            } else if (componentes[i] instanceof JToggleButton) {
                ((JToggleButton) componentes[i]).setSelected(false);
            } else if (componentes[i] instanceof JComboBox) {
                ((JComboBox) componentes[i]).setSelectedIndex(0);
            } else if (componentes[i] instanceof JSlider) {
                ((JSlider) componentes[i]).setValue(((JSlider) componentes[i]).getMinimum());
            } else if (componentes[i] instanceof JSpinner) {
                ((JSpinner) componentes[i]).setValue(0);
            } else if (componentes[i] instanceof JFormattedTextField) {
                ((JFormattedTextField) componentes[i]).setText("");
            } else if (componentes[i] instanceof JTable) {
                ((DefaultTableModel) (((JTable) componentes[i]).getModel())).setRowCount(0);
            }
        }
    }
//*Llamada a metodo
    limpiarFormulario(this.getContentPane().getComponents());
}
