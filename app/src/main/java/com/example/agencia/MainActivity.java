package com.example.agencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText txtNumBoleto;
    private EditText txtNombre;
    private EditText txtEdad;
    private Spinner spnDestino;
    private Spinner spnTipoBoleto;
    private EditText txtPrecio;
    private Spinner spnDia;
    private Spinner spnMes;
    private Spinner spnAño;
    private Button btnImprimir;
    private Button btnNuevo;
    private TextView lblImpresion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumBoleto = (EditText) findViewById(R.id.txtNumBoleto);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        spnDestino = (Spinner) findViewById(R.id.spnDestino);
        spnTipoBoleto = (Spinner) findViewById(R.id.spnTipoBoleto);
        txtPrecio = (EditText) findViewById(R.id.txtPrecio);
        spnDia = (Spinner) findViewById(R.id.spnDia);
        spnMes = (Spinner) findViewById(R.id.spnMes);
        spnAño = (Spinner) findViewById(R.id.spnAño);
        btnImprimir = (Button) findViewById(R.id.btnImprimir);
        btnNuevo = (Button) findViewById(R.id.btnNuevo);
        lblImpresion = (TextView) findViewById(R.id.lblImpresion);

        Boletos Boleto = new Boletos();

        ArrayAdapter<String> AdaptadorDestino =
                new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,
                        getResources().getStringArray(R.array.destino));
        spnDestino.setAdapter(AdaptadorDestino);

        ArrayAdapter<String> AdaptadorTipoBoleto =
                new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,
                        getResources().getStringArray(R.array.tipoBoleto));
        spnTipoBoleto.setAdapter(AdaptadorTipoBoleto);

        ArrayAdapter<String> AdaptadorDia =
                new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,
                        getResources().getStringArray(R.array.dia));
        spnDia.setAdapter(AdaptadorDia);

        ArrayAdapter<String> AdaptadorMes =
                new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,
                        getResources().getStringArray(R.array.mes));
        spnMes.setAdapter(AdaptadorMes);

        ArrayAdapter<String> AdaptadorAño =
                new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,
                        getResources().getStringArray(R.array.año));
        spnAño.setAdapter(AdaptadorAño);

        btnImprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNumBoleto.getText().toString().matches("") || txtNombre.getText().toString().matches("") ||
                        spnDestino.getSelectedItem().toString().trim().equals("") ||
                        spnTipoBoleto.getSelectedItem().toString().trim().equals("") ||
                        txtPrecio.getText().toString().matches("") ||
                        spnDia.getSelectedItem().toString().trim().equals("") ||
                        spnMes.getSelectedItem().toString().trim().equals("") ||
                        spnAño.getSelectedItem().toString().trim().equals("")){
                        Toast.makeText(MainActivity.this, "Es Necesario Llenar Todos los Campos",Toast.LENGTH_LONG).show();
                } else{
                    int numBoleto = Integer.parseInt(txtNumBoleto.getText().toString());
                    String nomCliente = txtNombre.getText().toString();
                    int edad = Integer.parseInt(txtEdad.getText().toString());
                    String destino = spnDestino.getSelectedItem().toString();
                    String tipoViaje = spnTipoBoleto.getSelectedItem().toString();
                    double precio = Double.parseDouble(txtPrecio.getText().toString());
                    String fecha = spnDia.getSelectedItem().toString() + "/" +
                                   spnMes.getSelectedItem().toString() + "/" +
                                   spnAño.getSelectedItem().toString();

                    Boleto.setNumBoleto(numBoleto);
                    Boleto.setNomCliente(nomCliente);
                    Boleto.setDestino(destino);
                    Boleto.setTipoViaje(tipoViaje);
                    Boleto.setPrecio(precio);
                    Boleto.setFecha(fecha);

                    lblImpresion.setText(" - - - - - - - -  - - - - - IMPRESION DE BOLETO - - - - - - - - - - - - - " +
                                  "\nNo°Boleto: " + Boleto.getNumBoleto() +
                                  "\nNombre Cliente: " + Boleto.getNomCliente() +
                                  "\nDestino: " + Boleto.getDestino() +
                                  "\nTipo Viaje: " + Boleto.getTipoViaje() +
                                  "\nPrecio: $" + Boleto.getPrecio() +
                                  "\nFecha: " + Boleto.getFecha() +
                                  "\nIMPORTE" +
                                  "\nSubtotal: $" + Boleto.calcularSubTotal() +
                                  "\nImpuesto 16% (+): $" + Boleto.calcularImpuesto() +
                                  "\nDescuento (-): $" + Boleto.calcularDescuento(edad) +
                                  "\nTotal a pagar: $" + Boleto.calcularTotal(edad));
                }
            }
        });

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lblImpresion.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "No todos o ningun estan llenos",Toast.LENGTH_LONG).show();
                } else {
                    txtNumBoleto.setText("");
                    txtNombre.setText("");
                    txtEdad.setText("");
                    spnDestino.setSelection(0);
                    spnTipoBoleto.setSelection(0);
                    txtPrecio.setText("");
                    spnDia.setSelection(0);
                    spnMes.setSelection(0);
                    spnAño.setSelection(0);
                    lblImpresion.setText("");
                }
            }
        });
    }
}