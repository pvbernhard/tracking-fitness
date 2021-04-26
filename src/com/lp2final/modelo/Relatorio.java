package com.lp2final.modelo;

import com.lp2final.controle.AtividadesControle;
import com.lp2final.controle.PerfilControle;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;

public class Relatorio {
    private final Perfil perfil;
    private ArrayList<AtividadeFeita> atividadesFeitas;
    private PerfilControle perfilControle;

    public Relatorio(String nomeArquivoPerfil) {
        PerfilControle perfilControle = new PerfilControle(nomeArquivoPerfil);
        this.perfilControle = perfilControle;
        AtividadesControle atividadesControle = new AtividadesControle(nomeArquivoPerfil);
        this.atividadesFeitas = new ArrayList<>();
        try {
            this.atividadesFeitas = atividadesControle.lerAtividadesFeitas();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.perfil = perfilControle.getPerfil();

        sortAtividadesFeitas();
    }

    public Relatorio(Perfil perfil, ArrayList<AtividadeFeita> atividadesFeitas) {
        this.perfil = perfil;
        this.atividadesFeitas = atividadesFeitas;

        sortAtividadesFeitas();
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public ArrayList<AtividadeFeita> getAtividadesFeitas() {
        return atividadesFeitas;
    }

    public ArrayList<AtividadeFeita> getAtividadesFeitas(String strDataInicio, String strDataFim) {
        Instant dataInicio = Instant.parse(strDataInicio.replaceAll("/", "-").concat("T00:00:00Z"));
        Instant dataFim = Instant.parse(strDataFim.replaceAll("/", "-").concat("T00:00:00Z"));
        return getAtividadesFeitas(dataInicio, dataFim);
    }

    public ArrayList<AtividadeFeita> getAtividadesFeitas(Instant dataInicio, Instant dataFim) {
        ArrayList<AtividadeFeita> atividades = new ArrayList<>();

        for (AtividadeFeita atividadeFeita : this.getAtividadesFeitas()) {
            if (atividadeFeita.getData().isAfter(dataFim) || atividadeFeita.getData().equals(dataFim)) {
                break;
            }
            if (atividadeFeita.getData().isAfter(dataInicio) || atividadeFeita.getData().equals(dataInicio)) {
                atividades.add(atividadeFeita);
            }
        }

        return atividades;
    }

    public double getMediaGastosCaloricos(String strDataInicio, String strDataFim) {
        Instant dataInicio = Instant.parse(strDataInicio.replaceAll("/", "-").concat("T00:00:00Z"));
        Instant dataFim = Instant.parse(strDataFim.replaceAll("/", "-").concat("T00:00:00Z"));
        return getMediaGastosCaloricos(dataInicio, dataFim);
    }

    public double getMediaGastosCaloricos(Instant dataInicio, Instant dataFim) {
        ArrayList<AtividadeFeita> atividades = getAtividadesFeitas(dataInicio, dataFim);
        double somatorio = 0.0;
        for (AtividadeFeita atividade : atividades) {
            if (atividade.getCaloriasPerdidas() != null) {
                somatorio += atividade.getCaloriasPerdidas();
            }
        }
        if (atividades.size() > 0) {
            return somatorio / atividades.size();
        } else {
            return 0.0;
        }
    }

    public double getMediaAtividades(String strDataInicio, String strDataFim) {
        Instant dataInicio = Instant.parse(strDataInicio.replaceAll("/", "-").concat("T00:00:00Z"));
        Instant dataFim = Instant.parse(strDataFim.replaceAll("/", "-").concat("T00:00:00Z"));
        return getMediaAtividades(dataInicio, dataFim);
    }

    public double getMediaAtividades(Instant dataInicio, Instant dataFim) {
        ArrayList<AtividadeFeita> atividades = getAtividadesFeitas(dataInicio, dataFim);
        if (atividades.size() == 0) {
            return 0.0;
        }
        ArrayList<Integer> atividadesPorDia = new ArrayList<>();
        int quantidadeAtividades = 0;
        String ultimaDia = atividades.get(0).getDia();
        for (AtividadeFeita atividade : atividades) {
            if (ultimaDia.equals(atividade.getDia())) {
                quantidadeAtividades++;
            } else {
                atividadesPorDia.add(quantidadeAtividades);
                quantidadeAtividades = 1;
            }
        }
        atividadesPorDia.add(quantidadeAtividades);
        double somatorio = 0.0;
        for (Integer i : atividadesPorDia) {
            somatorio += (double) i;
        }
        return somatorio / (double) atividadesPorDia.size();
    }

    private void sortAtividadesFeitas() {
        this.getAtividadesFeitas().sort((o1, o2) -> o2.getData().compareTo(o1.getData()));
    }

    public void setPerfilControle(PerfilControle perfilControle) {
        this.perfilControle = perfilControle;
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder("[PERFIL]\n" +
                "Nome: " + perfil.getNome() +
                "\nPeso: " + String.format("%.2f", perfil.getPeso()) +
                "\nAltura: " + String.format("%.2f", perfil.getAltura()) +
                "\nIdade: " + perfil.getIdade() +
                "\nMeta de calorias: " + perfil.getMetaCal() +
                "\nMeta de tempo: " + perfil.getMetaTemp() +
                String.format("\nIMC: %.2f (%s)\n", perfil.imc(), perfil.imcClassificacao()) +
                "\n[HISTÓRICO DE PESOS]\n");

        for (int i = 0; i < perfilControle.getDataPesoTotal().size(); i++) {
            texto.append(String.format("[%s] %s kg\n", perfilControle.getDataPesoTotal().get(i), perfilControle.getPesototal().get(i)));
        }
        texto.append("\n[ATIVIDADES FEITAS]\n");
        for (AtividadeFeita atividadeFeita_ : this.getAtividadesFeitas(Instant.MIN, Instant.MAX)) {
            texto.append(atividadeFeita_);
            texto.append("\n");
        }
        texto.append(String.format("\nMédia de gastos calóricos: %.2f\n", this.getMediaGastosCaloricos(Instant.MIN, Instant.MAX)));
        texto.append(String.format("Média de atividades por dia: %.2f\n", this.getMediaAtividades(Instant.MIN, Instant.MAX)));
        return texto.toString();
    }
}
