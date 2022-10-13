package com.cesusc.jogodavelha

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val botoes = listOf(
        R.id.btn_1,
        R.id.btn_2,
        R.id.btn_3,
        R.id.btn_4,
        R.id.btn_5,
        R.id.btn_6,
        R.id.btn_7,
        R.id.btn_8,
        R.id.btn_9,
    )


    fun btnClick(view: View) {
        val btnSelecionado =  view as Button;
        var cellId = 0;

        when (btnSelecionado.id) {
            R.id.btn_1 -> cellId = 1
            R.id.btn_2 -> cellId = 2
            R.id.btn_3 -> cellId = 3
            R.id.btn_4 -> cellId = 4
            R.id.btn_5 -> cellId = 5
            R.id.btn_6 -> cellId = 6
            R.id.btn_7 -> cellId = 7
            R.id.btn_8 -> cellId = 8
            R.id.btn_9 -> cellId = 9
        }
//        Toast.makeText(this, "ID: $cellId", Toast.LENGTH_LONG).show();
        playJogada(cellId, btnSelecionado)

    }

    // Array guarda a jogada de cada jogador
    var jogador1 = ArrayList<Int>();
    var jogador2 = ArrayList<Int>();

    // Inicio do jogo
    var jogada = 1;

    fun playJogada (cellId: Int, btnSelecionado: Button) {
        if (jogada == 1) {
            btnSelecionado.text = "X";
            btnSelecionado.setBackgroundColor(Color.GREEN);
            jogador1.add(cellId);
            jogada = 2
        } else {
            btnSelecionado.text = "O";
            btnSelecionado.setBackgroundColor(Color.YELLOW)
            jogador2.add(cellId);
            jogada = 1
        }
        btnSelecionado.isEnabled = false
        validaVencedor()
    }


    fun verificaGanhador(valor_1: Int, valor_2: Int, valor_3: Int) {
        var ganhador = -1;
        if (jogador1.contains(1) && jogador1.contains(2) && jogador1.contains(3)) {
            ganhador = 1;
            //Verifica ganhador linha 1
        } else if (jogador2.contains(1) && jogador2.contains(2) && jogador2.contains(3)) {
            ganhador = 2;
        }
    }

    fun validaVencedor() {
        var ganhador = -1;

        //Verifica ganhador linha 1
        if (jogador1.contains(1) && jogador1.contains(2) && jogador1.contains(3)) {
            ganhador = 1;
          //Verifica ganhador linha 1
        } else if (jogador2.contains(1) && jogador2.contains(2) && jogador2.contains(3)) {
            ganhador = 2;

          //Verifica ganhador linha 2
        } else if (jogador1.contains(4) && jogador1.contains(5) && jogador1.contains(6)) {
            ganhador = 1;

          //Verifica ganhador linha 2
        } else if (jogador2.contains(4) && jogador2.contains(5) && jogador2.contains(6)) {
            ganhador = 2;

          //Verifica ganhador linha 3
        } else if (jogador1.contains(7) && jogador1.contains(8) && jogador1.contains(9)) {
            ganhador = 1;

          //Verifica ganhador linha 3
        } else if (jogador2.contains(7) && jogador2.contains(8) && jogador2.contains(9)) {
            ganhador = 2;
          //Verifica ganhador diagonal 1
        } else if (jogador1.contains(1) && jogador1.contains(5) && jogador1.contains(9)) {
            ganhador = 1;
          //Verifica ganhador diagonal 1
        } else if (jogador2.contains(1) && jogador2.contains(5) && jogador2.contains(9)) {
            ganhador = 2;
          //Verifica ganhador diagonal 2
        } else if (jogador1.contains(3) && jogador1.contains(5) && jogador1.contains(7)) {
            ganhador = 1;
          //Verifica ganhador diagonal 2
        } else if (jogador2.contains(3) && jogador2.contains(5) && jogador2.contains(7)) {
            ganhador = 2;
          //Verifica ganhador coluna 1
        } else if (jogador1.contains(1) && jogador1.contains(4) && jogador1.contains(7)) {
            ganhador = 1;
          //Verifica ganhador coluna 1
        } else if (jogador2.contains(1) && jogador2.contains(4) && jogador2.contains(7)) {
            ganhador = 2;
          //Verifica ganhador coluna 2
        } else if (jogador1.contains(2) && jogador1.contains(5) && jogador1.contains(8)) {
            ganhador = 1;
          //Verifica ganhador coluna 2
        } else if (jogador2.contains(2) && jogador2.contains(5) && jogador2.contains(8)) {
            ganhador = 2;
          //Verifica ganhador coluna 2
        } else if (jogador1.contains(3) && jogador1.contains(6) && jogador1.contains(9)) {
            ganhador = 1;
          //Verifica ganhador coluna 2
        } else if (jogador2.contains(3) && jogador2.contains(6) && jogador2.contains(9)) {
            ganhador = 2;
        }

        if(ganhador != -1) {
            if (ganhador == 1) {
                Toast.makeText(this, "JOGADOR 1 GANHOU O JOGO", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "JOGADOR 2 GANHOU O JOGO", Toast.LENGTH_SHORT).show();
            }
        }
    }

    fun limparCampos(view: View) {
        jogador1.clear();
        jogador2.clear();

        for (campoBotao in botoes) {
            val obterBotao = findViewById<Button>(campoBotao);
            obterBotao.text = "";
            obterBotao.isEnabled = true;
            obterBotao.setBackgroundColor(Color.BLUE)
        }
    }

}