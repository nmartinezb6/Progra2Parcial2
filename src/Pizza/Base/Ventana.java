package Pizza.Base;


import Pizza.Base.Especialidades.Especialidades;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class Ventana extends JFrame{
    private JPanel panel;
    private JComboBox cbPizza;
    private JComboBox cbSize;
    private JButton btnPizza;
    private JTextArea txtSalida;
    private JComboBox cbTopping;
    private JButton btnTopping;
    private JScrollPane scroll;
    private JScrollPane scroll2;
    private JTable tblTopping;
    private JScrollPane scroll3;
    private JTextArea txtTotal;
    private JButton btnPreparar;
    private JScrollPane scroll4;
    private JTextArea txtPreparacion;
    private JTextArea txtToppings;
    private JLabel lblPizza;



    public Ventana (){
        //Creacion de ventana
        this.setContentPane(panel);
        this.setSize(600,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocationRelativeTo(null);



        //TextArea
        this.txtSalida.setEditable(false);
        this.txtTotal.setEditable(false);

        //Tabla
        this.tblTopping.addColumn(new TableColumn());
        System.out.println();

        //Botones
        initButtonPizza();
        initButtonTopping();
        eliminarToppong();
        initBotonPreaparacion();
    }
    public Especialidades selectedPizza;
    public void initButtonPizza(){
   String[] nombre = {
            Especialidades.PEPPERONI_NAME,
            Especialidades.HAWAIIAN_NAME,
            Especialidades.VEGETARIAN_NAME,
            Especialidades.SUPREME_NAME,
            Especialidades.WHITE_NAME

    };
   String[] size = {
            Pizza.SMALL_SIZE,
            Pizza.MEDIUM_SIZE,
            Pizza.LARGE_SIZE
    };
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectedPizza = new Especialidades(
                        nombre[cbPizza.getSelectedIndex()],
                        size[cbSize.getSelectedIndex()]
                );

                setSalida();
                setToppings();

            }
        };
        btnPizza.addActionListener(accion);
    }
    public void initButtonTopping(){
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //verificar pizza
                if (selectedPizza == null){
                    JOptionPane.showMessageDialog(null,
                            "No ha seleccionado una Pizza",
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                switch (cbTopping.getSelectedIndex()) {
                    case 0:
                        selectedPizza.addTopping(new Topping(Topping.PEPPERONI_NAME, Topping.PEPPERONI_PRICE));
                        break;
                    case 1:
                        selectedPizza.addTopping(new Topping(Topping.PINEAPPLE_NAME, Topping.PINEAPPLE_PRICE));
                        break;
                    case 2:
                        selectedPizza.addTopping(new Topping(Topping.SWEET_PEPPER_NAME, Topping.SWEET_PEPPER_PRICE));
                        break;
                    case 3:
                        selectedPizza.addTopping(new Topping(Topping.ONION_NAME, Topping.ONION_PRICE));
                        break;
                    case 4:
                        selectedPizza.addTopping(new Topping(Topping.CHEESE_NAME, Topping.CHEESE_PRICE));
                        break;
                    case 5:
                        selectedPizza.addTopping(new Topping(Topping.MUSHROOMS_NAME, Topping.MUSHROOMS_PRICE));
                        break;

                }
                setToppings();
            }
        };
        btnTopping.addActionListener(accion);
    }
    //nueva funcion
    public void eliminarToppong(){
        //
        MouseListener accion = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    selectedPizza.toppings.remove(tblTopping.getSelectedRow());
                    setToppings();
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        tblTopping.addMouseListener(accion);
    }
    public void setSalida(){
        if(selectedPizza == null){
            return;
        }
       String salida = "";
         salida = String.format(
                "Nombre: %s\n"
                 +"Tamaño: %s\n"
                 + "Precio: Q %.2f"
                 ,
                 selectedPizza.name,
                 selectedPizza.size,
                 selectedPizza.getPrice()
        );
         txtSalida.setText(salida);
        setTotal();
    }
    public void setToppings(){
        if(selectedPizza == null){
            return;
        }
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("Toppings");
        for(int i = 0; i < selectedPizza.toppings.size(); i++){
            modelo.addRow(new String[]{selectedPizza.toppings.get(i).getNombre()
            + String.format(" Q %.2f", this.selectedPizza.toppings.get(i).getPrice())
            });
            modelo.isCellEditable(i,0);

        }
        this.tblTopping.setModel(modelo);
        setTotal();
    }
    public void setTotal(){
        double precio = selectedPizza.getPrice();
        for (int i = 0; i < selectedPizza.toppings.size(); i++) {
            precio += selectedPizza.toppings.get(i).getPrice();
        }
        String salida = String.format(
                " Q %.2f",
                precio
        );
        txtTotal.setText(java.lang.String.valueOf(salida));
    }
    //Preparacion
    Thread hiloPreparacion;
    boolean permitirpreparacion ;
    public Thread initPreparacion(){
        return new Thread(new Runnable() {
            @Override
            public void run() {
                permitirpreparacion = false;
                txtPreparacion.setText("ORDEN RECIBIDA\n");
                esperar(1000);

                txtPreparacion.append("Preparando Masa\n");
                esperar(2000);

                txtPreparacion.append("Agregando Toppings\n");
                esperar(750);

                for (int i = 0; i < selectedPizza.toppings.size(); i++) {
                    java.lang.String topping = selectedPizza.toppings.get(i).getNombre();
                    txtPreparacion.append(" Agregando: " + topping + "\n");
                    esperar(700);

                }
                    txtPreparacion.append("Horneando Pizza\n");
                    esperar(700);

                    txtPreparacion.append("Empaquetando\n");
                    esperar(800);

                txtPreparacion.append("La pizza esta lista");
                permitirpreparacion = true;
            }
        });
    }

    public void esperar(long tiempo){
        try{
            Thread.sleep(tiempo);
        }catch (Exception err){
            System.out.println(err);
        }
    }

    public void initBotonPreaparacion(){
        permitirpreparacion = true;

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedPizza == null){
                    JOptionPane.showMessageDialog(null,
                            "No se ha seleccionado ninguna Pizza",
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(!permitirpreparacion){
                    JOptionPane.showMessageDialog(null,
                            "No se puede preparar mas de una pizza a la vez",
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                hiloPreparacion = initPreparacion();
                hiloPreparacion.start();
            }
        };
        btnPreparar.addActionListener(accion);
    }


}
