package com.example.check_listdesegurana;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextClock;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrayList;
    Dialog dialog;
    DatabaseReference reference;
    Salvos salvos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText observacao = findViewById(R.id.observacao);
        final EditText equipamento  = findViewById(R.id.equipamento);
        final RadioGroup radioGroupTurno = findViewById(R.id.radioGroupTurno);
        final RadioGroup RGPF = findViewById(R.id.RGPF);
        final RadioGroup RGBTEMER = findViewById(R.id.RGBTEMER);
        final RadioGroup RGBTMICRO = findViewById(R.id.RGBTMICRO);
        final RadioGroup RGBTCORTINA = findViewById(R.id.RGBTCORTINA);
        final RadioGroup RGBTREFILO = findViewById(R.id.RGBTREFILO);
        final RadioGroup RGBTQUADRO = findViewById(R.id.RGBTQUADRO);
        final RadioGroup RGBTAMBIENTE = findViewById(R.id.RGBTAMBIENTE);
        final TextClock hora = findViewById(R.id.hora);
        final EditText data = findViewById(R.id.data);

        salvos = new Salvos();
        Button Confirmar = findViewById(R.id.Confirmar);
        reference = FirebaseDatabase.getInstance().getReference("Check-List");
        final Calendar myCalendar = Calendar.getInstance();


        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {

                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);


            }
        };


        arrayList = new ArrayList<>();
        arrayList.add("PE-0064");
        arrayList.add("RE-0091");
        arrayList.add("TE-056");
        arrayList.add("MS-051");
        arrayList.add("EX-018");
        arrayList.add("RE-7181");
        arrayList.add("RE-7182");
        arrayList.add("PE-7183");
        arrayList.add("MS-7191");
        arrayList.add("EX-0023");
        arrayList.add("TE-7122");
        arrayList.add("RE-031");
        arrayList.add("RE-030");
        arrayList.add("MT-050");
        arrayList.add("EX-022");
        arrayList.add("MS-083");
        arrayList.add("TE-0108");
        arrayList.add("TE-8362");
        arrayList.add("MS-8373");
        arrayList.add("RE-026");
        arrayList.add("RE-7596");
        arrayList.add("EX-8542");
        arrayList.add("MS-050");
        arrayList.add("MS-015");
        arrayList.add("MS-012");
        arrayList.add("MS-002");
        arrayList.add("AP-019");
        arrayList.add("AP-7771");
        arrayList.add("AP-7772");
        arrayList.add("EB-8575");
        arrayList.add("PR-142");
        arrayList.add("BT-0003");
        arrayList.add("PR-094");
        arrayList.add("RO/PR-94");
        arrayList.add("PR-082");
        arrayList.add("RO-003");
        arrayList.add("PR-0064");
        arrayList.add("PR-0097");
        arrayList.add("PR-096");
        arrayList.add("PR-144");
        arrayList.add("PR-058");
        arrayList.add("PR-083");
        arrayList.add("BR-085");
        arrayList.add("PR-140");
        arrayList.add("MF-009");
        arrayList.add("PR-141");
        arrayList.add("MF-004");
        arrayList.add("PR-114");
        arrayList.add("MF-005");
        arrayList.add("PR-093");
        arrayList.add("BT-7334");
        arrayList.add("PR-014");
        arrayList.add("BT-0016");
        arrayList.add("PR-119");
        arrayList.add("PR-135");
        arrayList.add("PR-059");
        arrayList.add("PR-052");
        arrayList.add("PR-147");
        arrayList.add("PR-143");
        arrayList.add("PR-145");
        arrayList.add("PR-085");
        arrayList.add("TE-107");
        arrayList.add("TE-7678");
        arrayList.add("TE-018");
        arrayList.add("TE-100");
        arrayList.add("TE-019");
        arrayList.add("TE-102");
        arrayList.add("PR-053");
        arrayList.add("BR-057");
        arrayList.add("PR-087");
        arrayList.add("BR-0022");
        arrayList.add("PR-0006");
        arrayList.add("PR-099");
        arrayList.add("PR-104");
        arrayList.add("PR-0008");
        arrayList.add("PR-098");
        arrayList.add("PR-117");
        arrayList.add("PR-050");
        arrayList.add("BR-048");
        arrayList.add("BR-049");
        arrayList.add("BR-055");
        arrayList.add("PR-051");
        arrayList.add("BR-082");
        arrayList.add("PR-092");
        arrayList.add("BR-0013");
        arrayList.add("PR-088");
        arrayList.add("TE-097");
        arrayList.add("LITO 03");
        arrayList.add("DESCARGA LITO 03");
        arrayList.add("LITO 02");
        arrayList.add("DESCARGA LITO 02");
        arrayList.add("LITO 17");
        arrayList.add("DESCARGA LITO 17");
        arrayList.add("LITO 04");
        arrayList.add("LITO 14");
        arrayList.add("LITO 13");


        equipamento.setOnClickListener(new View.OnClickListener() {
            {

            }
            @Override
            public void onClick(View view) {

                dialog = new Dialog(getApplicationContext());
                dialog.setContentView(R.layout.dialog_searchable_spinner);
                dialog.getWindow().setLayout(650, 900);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                EditText editText = dialog.findViewById(R.id.edit_text);
                ListView listView = dialog.findViewById(R.id.list_view);

                final ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this
                , android.R.layout.simple_list_item_1, arrayList);

                listView.setAdapter(adapter);


                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {



                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            equipamento.setText(adapter.getItem(i));
                            dialog.dismiss();
                        }
                    });
            }
        });


           Confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                if (equipamento.getText().toString().equals(""))

                {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setIcon(R.drawable.ic_baseline_error_outline_24);
                    dialog.setTitle("Dados inválidos");
                    dialog.setMessage("Informe o respectivo equipamento.");
                    dialog.setNeutralButton("Ok", null);
                    dialog.show();
                }


                else
                    {

                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Confirmação");
                    alert.setMessage("Todas as informações estão corretas?");

                        alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                RadioButton selecionado;
                                String turno;
                                int idSelecionado = radioGroupTurno.getCheckedRadioButtonId(); //pega o id do RadioButton selecionado
                                selecionado = findViewById(idSelecionado); //Seleciona o RB selecionado pelo id
                                turno = String.valueOf(selecionado.getText()); //Pega o texto do RB

                                RadioButton selecionadoProtecao;
                                String protecao;
                                int idSelecionadoProtecao = RGPF.getCheckedRadioButtonId();
                                selecionadoProtecao = findViewById(idSelecionadoProtecao);
                                protecao = String.valueOf(selecionadoProtecao.getText());


                                RadioButton selecionadoEmergencia;
                                String emergencia;
                                int idSelecionadoEmergencia = RGBTEMER.getCheckedRadioButtonId(); //pega o id do RadioButton selecionado
                                selecionadoEmergencia = findViewById(idSelecionadoEmergencia); //Seleciona o RB selecionado pelo id
                                emergencia = String.valueOf(selecionadoEmergencia.getText()); //Pega o texto do RB

                                RadioButton selecionadoMicros;
                                String micros;
                                int idSelecionadoMicros = RGBTMICRO.getCheckedRadioButtonId();
                                selecionadoMicros = findViewById(idSelecionadoMicros);
                                micros = String.valueOf(selecionadoMicros.getText());


                                RadioButton selecionadoCortinas;
                                String cortinas;
                                int idSelecionadoCortinas = RGBTCORTINA.getCheckedRadioButtonId();
                                selecionadoCortinas = findViewById(idSelecionadoCortinas);
                                cortinas = String.valueOf(selecionadoCortinas.getText());

                                RadioButton selecionadoRefilos;
                                String refilos;
                                int idSelecionadoRefilos = RGBTREFILO.getCheckedRadioButtonId();
                                selecionadoRefilos = findViewById(idSelecionadoRefilos);
                                refilos = String.valueOf(selecionadoRefilos.getText());

                                RadioButton selecionadoQuadros;
                                String quadros;
                                int idSelecionadoQuadros = RGBTQUADRO.getCheckedRadioButtonId();
                                selecionadoQuadros = findViewById(idSelecionadoQuadros);
                                quadros = String.valueOf(selecionadoQuadros.getText());


                                RadioButton selecionadoAmbiente;
                                String ambiente;
                                int idSelecionadoAmbiente = RGBTAMBIENTE.getCheckedRadioButtonId();
                                selecionadoAmbiente = findViewById(idSelecionadoAmbiente);
                                ambiente = String.valueOf(selecionadoAmbiente.getText());

                                salvos.setObservacao(observacao.getText().toString());
                                salvos.setEquipamento(equipamento.getText().toString());
                                salvos.setData(data.getText().toString());
                                salvos.setHora(hora.getText().toString());
                                salvos.setTurno(turno);
                                salvos.setProtecoesFixas(protecao);
                                salvos.setBotoeirasEmergencia(emergencia);
                                salvos.setMicrosDeSeguranca(micros);
                                salvos.setCortinasDeLuz(cortinas);
                                salvos.setDispositivosRemocao(refilos);
                                salvos.setQuadrosEletricos(quadros);
                                salvos.setAmbiente(ambiente);

                               String eqp = equipamento.getText().toString();
                               String key = reference.child("Check-List").push().getKey();
                               reference.child(eqp + key).setValue(salvos);



                                Toast.makeText(MainActivity.this, "Check-List de Segurança enviado com sucesso.", Toast.LENGTH_SHORT).show();
                                equipamento.setText("");
                                observacao.setText("");
                                equipamento.requestFocus();
                                Intent ii = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(ii);

                            }

                        }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);                            }
                        });

                        alert.show();

                }
            }


            });




        String currentDateTimeString = java.text.DateFormat.getDateInstance().format(new Date());
            data.setText(currentDateTimeString);


    }
}