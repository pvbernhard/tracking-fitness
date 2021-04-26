package com.lp2final.controle;


import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lp2final.modelo.AtividadeFeita;
import com.lp2final.modelo.Perfil;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class GerarPdf {

    public void criarPdf(String arquivoPerfil ){

        PerfilControle pp = new PerfilControle(arquivoPerfil);
        Perfil perfil = pp.getPerfil();

        Document doc = new Document();
        String nomePdf = "Relatorio Geral.pdf";

        try {
            //gerar um arquivo pdf
            PdfWriter.getInstance(doc, new FileOutputStream(nomePdf));
            doc.open();
            //escrever no primeiro paragrafo
            Paragraph p = new Paragraph("Informações Do Perfil");
            p.setAlignment(1); //centraliza na tela
            doc.add(p);// adiciono o paragrafo feito acima2
            p = new Paragraph("   ");//Pula linha
            doc.add(p);

            PdfPTable tab = new PdfPTable(1);//criar uma tabela com o nuemro de colunas
            //essa tabela vai ter a coluna do perfil onde vai conter as informaçoes de
            //nome,idade,peso,altura e outra que mostrar o imc e Sua situaçao em relação ao imc

            //Dentro da tabela criada no botando o primeiro valor dela
            PdfPCell c1 = new PdfPCell(new Paragraph("PERFIL"));

            //adiciona a paragrafos criado na tabela
            tab.addCell(c1);
            //informaçoes do perfil
            c1 = new PdfPCell(new Paragraph("Nome: "+perfil.getNome()));
            tab.addCell(c1);
            c1 = new PdfPCell(new Paragraph("Idade: "+perfil.getIdade()+""));
            tab.addCell(c1);
            c1 = new PdfPCell(new Paragraph("Peso: "+perfil.getPeso()+""));
            tab.addCell(c1);
            c1 = new PdfPCell(new Paragraph("Altura: "+perfil.getAltura()+""));
            tab.addCell(c1);
            c1 = new PdfPCell(new Paragraph("IMC: "+String.format("%.2f", perfil.imc())));
            tab.addCell(c1);
            c1 = new PdfPCell(new Paragraph("Voce está: "+perfil.imcClassificacao()));
            tab.addCell(c1);
            doc.add(tab);

            p = new Paragraph("   ");//Pula linha
            doc.add(p);
            PdfPTable tabPeso = new PdfPTable(1);

            PdfPCell cPeso = new PdfPCell(new Paragraph("HISTORICO DE PESOS"));
            tabPeso.addCell(cPeso);
            //pego todas as informaçoes do arquivo perfilPeso
            ArrayList<String> data = pp.getDataPesoTotal();
            ArrayList<String> peso = pp.getPesototal();

            for (int i =0;i<data.size();i++) {
                cPeso = new PdfPCell(new Paragraph("Data: "+data.get(i) +"   Peso: "+ peso.get(i)));
                tabPeso.addCell(cPeso);
            }
            doc.add(tabPeso);

            doc.add(new Paragraph("   "));
            PdfPTable tabAtividades = new PdfPTable(1);
            tabAtividades.addCell(new PdfPCell(new Paragraph("ATIVIDADES FEITAS")));
            ArrayList<AtividadeFeita> atividades = new AtividadesControle(arquivoPerfil).lerAtividadesFeitas();

            for (AtividadeFeita atividadeFeita : atividades) {
                tabAtividades.addCell(new PdfPCell(new Paragraph(atividadeFeita.toString())));
            }
            doc.add(tabAtividades);

            doc.close();


        } catch (Exception ignored){

        }

    }

}
