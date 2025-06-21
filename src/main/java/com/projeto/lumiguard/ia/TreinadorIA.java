package com.projeto.lumiguard.ia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class TreinadorIA {

    public static void main(String[] args) {
        try {
            // Caminho para o arquivo .arff dentro do resources
            DataSource source = new DataSource("src/main/resources/weka/denuncias.arff");
            Instances data = source.getDataSet();

            // Define o atributo de classe (neste caso, "prioridade")
            if (data.classIndex() == -1) {
                data.setClassIndex(data.numAttributes() - 1);
            }

            // Cria o classificador (árvore de decisão J48)
            Classifier classifier = new J48();
            classifier.buildClassifier(data);

            // Salva o modelo em disco
            ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("src/main/resources/weka/modelo.model"));
            oos.writeObject(classifier);
            oos.flush();
            oos.close();

            System.out.println("Modelo treinado e salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
