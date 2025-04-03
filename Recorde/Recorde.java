package Recorde;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Recorde {
    private LocalDate data;
    private double tempo;
    private String nome;

    public Recorde(LocalDate data, double tempo, String nome) {
        this.data = data;
        this.tempo = tempo;
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public double getTempo() {
        return tempo;
    }

    public String getNome() {
        return nome;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        String dataFormatada = this.data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return "Nome: " + this.nome + " | Tempo: " + this.tempo + " segundos | Data: " + dataFormatada;
    }
}
