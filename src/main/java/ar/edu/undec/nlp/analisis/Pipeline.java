package ar.edu.undec.nlp.analisis;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Properties;

public class Pipeline {

    private static Properties properties;

    private static String propertiesName ="tokenize, ssplit, pos";

    private static StanfordCoreNLP stanfordCoreNLP;

    private Pipeline(){

    }

    static {
        properties = new Properties();
        properties.setProperty("annotators", propertiesName);
        properties.setProperty("tokenize.language", "es");

    }


    public static StanfordCoreNLP getStanfordCoreNLP(){

        if(stanfordCoreNLP == null){
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }

        return stanfordCoreNLP;
    }

}
