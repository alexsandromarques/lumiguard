package com.projeto.lumiguard.ia;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import org.springframework.stereotype.Service;

import weka.classifiers.Classifier;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

@Service
public class IAService {

    private Classifier modelo;
    private Instances estrutura;

    public IAService() throws Exception {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("modelo.model"))) {
//            modelo = (Classifier) ois.readObject();
//        }
//
//        // Estrutura deve ser idêntica à usada para treinar o modelo
//        estrutura = new Instances(
//                new java.io.BufferedReader(new java.io.FileReader("estrutura.arff")));
//        estrutura.setClassIndex(estrutura.numAttributes() - 1);
    }

    public String preverRisco(String tipoFalha, String bairro) throws Exception {
        Instance nova = new DenseInstance(estrutura.numAttributes());
        nova.setDataset(estrutura);
        nova.setValue(0, tipoFalha); // ex: atributo tipoFalha
        nova.setValue(1, bairro);    // ex: atributo bairro

        double resultado = modelo.classifyInstance(nova);
        return estrutura.classAttribute().value((int) resultado);
    }
}
