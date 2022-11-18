package ar.edu.undec.nlp.analisis;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Analizador {

    private boolean introduccion = false;
    private boolean metodo = false;
    private boolean resultado = false;
    private boolean discusion = false;

    private List<String> i = new ArrayList<>();
    private List<String> m = new ArrayList<>();
    private List<String> r = new ArrayList<>();
    private List<String> d = new ArrayList<>();

    public Analizador(){

    }

    private List<String> sentencias = new ArrayList<>();

    private void cargarValores() {
        i.add("destaca");
        i.add("destaca");
        i.add("embargo");
        i.add("problema");
        i.add("historicamente");
        i.add("dificultad");
        i.add("caracteristica");
        i.add("historia");
        i.add("histórico");

        m.add("metodología");
        m.add("metodologías");
        m.add("método");
        m.add("métodos");
        m.add("comparar");
        m.add("compración");
        m.add("modelo");
        m.add("técnicas");
        m.add("procesamiento");
        m.add("utilizando");
        m.add("medir");
        m.add("proceso");

        r.add("comparar");
        r.add("comparando");
        r.add("proceso");
        r.add("resultados");
        r.add("encontramos");
        r.add("disminución");
        r.add("muestra");
        r.add("índice");
        r.add("obtener");
        r.add("obteniendo");
        r.add("muestra");
        r.add("valores");

        d.add("resultados");
        d.add("confiable");
        d.add("obtenidos");
        d.add("futuro");
        d.add("objetivo");
        d.add("impportancia");
        d.add("conclusión");
        d.add("opinión");
    }

    private void loadProperties(CoreDocument coreDocument) {

        Properties props = StringUtils.argsToProperties("-props", "spanish");

        props.setProperty("annotators", "tokenize, ssplit, pos");

        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        pipeline.annotate(coreDocument);

    }


    public String analizarTexto(String texto){

        this.cargarValores();

        CoreDocument coreDocument =new CoreDocument(texto);

        this.loadProperties(coreDocument);

        List<CoreLabel> coreLabelList = coreDocument.tokens();

        int valor= 0;
        String salida = "";

        for (CoreLabel coreLabel : coreLabelList) {

            String pos = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);

            if (!pos.equals("ADP") && !pos.equals("PUNCT") && !pos.equals("DET") && !pos.equals("AUX") && !pos.equals("PRON")) {
                if (coreLabel.sentIndex() == valor) {
                    salida += coreLabel.originalText() + " ";
                } else {
                    valor += 1;
                    sentencias.add(salida);
                    salida = coreLabel.originalText() + " ";
                }
            }
        }

        sentencias.add(salida);

        this.verificarValores(sentencias);

        String salida2="";

        if(introduccion && metodo && resultado && discusion){
            salida2+="Cumple con la estructura IMRD";
        }else{
            salida2+= "No cumple con la estructura IMRD. Solamente cumple con: ";
            if (introduccion){
                salida2+="Introducción. ";
            }
            if (metodo){
                salida2+="Métodos. ";
            }
            if (resultado){
                salida2+="Resultados. ";
            }
            if (discusion){
                salida2+="Discusión. ";
            }
        }
        if(introduccion && metodo && resultado && discusion){
        }else{
            salida2+= "Para mejorar la elaboración del resúmen tenga en cuenta las siguientes recomendaciones: ";
            if (!introduccion){
                salida2+=" Introducción: Proporcionar información sobre el contexto de la investigación, señalando la importancia del presente estudio. \n" +
                        "Por ejemplo: ¿Por qué es importante analizar este tema concreto desde el ángulo que has elegido?. ";
            }
            if (!metodo){
                salida2+=" Métodos: Describir los materiales, sujetos, variables, procedimientos. \n" +
                        "Por ejemplo: ¿Cómo se hizo la investigación?. ";
            }
            if (!resultado){
                salida2+=" Resultados: Informar de los principales resultados/conclusiones de la investigación. \n" +
                        "Por ejemplo: ¿Qué ha encontrado la investigación?. ";
            }
            if (!discusion){
                salida2+=" Discusión: Interpretación de los resultados, discutir las implicaciones o aplicaciones y realizar recomendaciones. \n" +
                        "Por ejemplo: ¿Qué significan los resultados?, ¿A qué implicaciones o aplicaciones conducen las conclusiones?. ";
            }
        }

        return salida2;
    }

    private void verificarValores(List<String> sentencias) {

        for (String s : sentencias) {

            int valorI = 0;
            int valorM = 0;
            int valorR = 0;
            int valorD = 0;

            if (!introduccion) {
                valorI += this.verificarIntroduccion(s, i);

                if (valorI >= 1) {
                    introduccion = true;
                }
            }

            if (!metodo) {
                valorM += this.verificarMetodo(s, m);

                if (valorM >= 1) {
                    metodo = true;
                }
            }

            if (!resultado) {
                valorR += this.verificarResultado(s, r);
                if (valorR >= 1) {
                    resultado = true;
                }
            }

            if (!discusion) {
                valorD += this.verificarDiscucion(s, d);
                if (valorD > 0) {
                    discusion = true;
                }
            }

        }

    }

    private int verificarDiscucion(String sentence, List<String> d) {
        String text = sentence.toString();
        int valor= 0;
        for (String a: d){
            if(text.contains(a)){
                valor+=1;
//                System.out.println(a);
            }
        }

        return valor;

    }

    private int verificarResultado(String sentence, List<String> r) {
        String text = sentence.toString();
        int valor= 0;
        for (String a: r){
            if(text.contains(a)){
                valor+=1;
//                System.out.println(a);
            }
        }

        return valor;

    }

    private int verificarMetodo(String sentence, List<String> m) {
        String text = sentence.toString();
        int valor= 0;
        for (String a: m){
            if(text.contains(a)){
                valor+=1;
//                System.out.println(a);
            }
        }

        return valor;

    }

    private int verificarIntroduccion(String sentence, List<String> i) {
        String text = sentence.toString();
        int valor = 0;
        for (String a : i) {
            if (text.contains(a)) {
                valor += 1;
                //                System.out.println(a);
            }
        }

        return valor;

    }

}
